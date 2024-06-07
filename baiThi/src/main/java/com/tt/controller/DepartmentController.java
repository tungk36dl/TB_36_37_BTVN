package com.tt.controller;


import com.tt.dto.DepartmentDto;
import com.tt.entity.Department;
import com.tt.repository.DepartmentRepository;
import com.tt.sevice.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
@Slf4j
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DepartmentRepository departmentRepo;

    @GetMapping("getAll")
    public List<Department> getAll(Model model,
                                   Pageable pageable) {
        Page<Department> departmentsPage = departmentRepo.findAll(pageable);
        List<Department> departments = departmentsPage.toList();
        model.addAttribute("departments", departments);
        model.addAttribute("totalPage", departmentsPage.getTotalPages());
        model.addAttribute("currentPage", pageable.getPageNumber());
        return departments;
    }

    @GetMapping("getAll2")
    public ResponseEntity<?> getAll2(Pageable pageable) {
        Page<Department> departmentsPage = departmentRepo.findAll(pageable);
        List<Department> departments = departmentsPage.toList();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody DepartmentDto departmentDto) {
        if(departmentDto.getDepartmentName() == null) {
            return new ResponseEntity<>("Trường departmentName bị bỏ trống!!!", HttpStatus.BAD_REQUEST);
        }
        Department department = new Department();
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setNumPeople(departmentDto.getNumPeople());

        departmentRepo.save(department);
        return new ResponseEntity<>("Tạo department thành công", HttpStatus.OK);
    }

    @PutMapping("department/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody DepartmentDto departmentDto) {
        Department department = departmentRepo.findById(id).orElse(null);
        if(department == null) {
            return new ResponseEntity<>("Không tìm thấy department với id = " + id, HttpStatus.BAD_REQUEST);
        }

        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setNumPeople(departmentDto.getNumPeople());
        departmentRepo.save(department);

        return new ResponseEntity<>("Cập nhật department thành công", HttpStatus.OK);
    }

    @DeleteMapping("department/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Department department = departmentRepo.findById(id).orElse(null);
        if (department == null) {
            return new ResponseEntity<>("Không tìm thấy department với id = " + id, HttpStatus.BAD_REQUEST);
        }

        departmentRepo.delete(department);
        return new ResponseEntity<>("Xóa department thành công", HttpStatus.OK);
    }


}
