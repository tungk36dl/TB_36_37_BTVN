package com.tt.controller;



import com.tt.entity.Department;
import com.tt.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
@Slf4j
public class DepartmentController {


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
