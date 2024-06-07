package com.tt.controller;


import com.tt.dto.AccountDto;
import com.tt.entity.Account;
import com.tt.entity.Department;
import com.tt.repository.AccountRepository;
import com.tt.repository.DepartmentRepository;
import com.tt.sevice.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("account")
@Slf4j
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepo;

    @Autowired
    DepartmentRepository departmentRepo;

//    @GetMapping("getAll")
//    public List<Account> getAll(Model model,
//                                Pageable pageable) {
//        Page<Account> accountsPage = accountRepo.findAll(pageable);
//        List<Account> accounts = accountsPage.toList();
//        model.addAttribute("accounts", accounts);
//        model.addAttribute("totalPage", accountsPage.getTotalPages());
//        model.addAttribute("currentPage", pageable.getPageNumber());
//        return accounts;
//    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<Account> accountsPage = accountRepo.findAll(pageable);
        List<Account> accounts = accountsPage.toList();

        List<AccountDto> accountDtos = new ArrayList<>();
        for (Account account : accounts) {
            AccountDto accountDto = new AccountDto();
            accountDto.setId(account.getId());
            accountDto.setUsername(account.getUsername());
            accountDto.setPassword(account.getPassword());
            accountDto.setFullName(account.getFullName());
            accountDto.setAddress(account.getAddress());
            if(account.getDepartment() == null) {
                accountDto.setDepartmentName("Chưa có phòng ban");
            }else {
                accountDto.setDepartmentName(account.getDepartment().getDepartmentName());
            }
            accountDtos.add(accountDto);
        }
        return new ResponseEntity<>(accountDtos, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody AccountDto accountDto,
                                  @RequestParam Integer departmentId) {
        if(accountDto.getUsername() == null || accountDto.getPassword() == null || accountDto.getFullName() == null) {
            return new ResponseEntity<>("Các trường username, password, fullName không được bỏ trống!!!", HttpStatus.BAD_REQUEST);
        }
        Department department = departmentRepo.findById(departmentId).orElse(null);
        Account account = new Account();
        account.setUsername(accountDto.getUsername());
        account.setPassword(accountDto.getPassword());
        account.setFullName(accountDto.getFullName());
        account.setAddress(accountDto.getAddress());
        account.setDepartment(department);

        accountRepo.save(account);
        return new ResponseEntity<>("Tạo account thành công", HttpStatus.OK);
    }

    @PutMapping("account/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody AccountDto accountDto,
                                    @RequestParam Integer departmentId) {
        Account account = accountRepo.findById(id).orElse(null);
        if(account == null) {
            return new ResponseEntity<>("Không tìm thấy account với id = " + id, HttpStatus.BAD_REQUEST);
        }
        Department department = departmentRepo.findById(departmentId).orElse(null);

        account.setUsername(accountDto.getUsername());
        account.setPassword(accountDto.getPassword());
        account.setFullName(accountDto.getFullName());
        account.setAddress(accountDto.getAddress());
        account.setDepartment(department);

        accountRepo.save(account);

        return new ResponseEntity<>("Cập nhật account thành công", HttpStatus.OK);
    }

    @DeleteMapping("account/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Account account = accountRepo.findById(id).orElse(null);
        if (account == null) {
            return new ResponseEntity<>("Không tìm thấy account với id = " + id, HttpStatus.BAD_REQUEST);
        }

        accountRepo.delete(account);
        return new ResponseEntity<>("Xóa account thành công", HttpStatus.OK);
    }
}
