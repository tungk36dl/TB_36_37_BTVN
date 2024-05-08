package com.tt.controller;

import com.tt.entity.Department;
import com.tt.repository.DepartmentRepository;

import com.tt.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("department")
@Slf4j
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepo;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Department> departments = departmentService.getAll();
        System.out.println(departments);

        model.addAttribute("departments", departments);
        return "department-list";
    }

    @GetMapping("delete/{id}")
    public String  delete(@PathVariable Integer id,
                         Model model){

        Optional<Department> opDepartment = departmentRepo.findById(id);
        if(opDepartment.isEmpty()) {
            System.out.println("Not found Department with id = " + id);
        }
        departmentRepo.deleteById(id);



//        return "department-list";
        return "redirect:/department";
    }




}
