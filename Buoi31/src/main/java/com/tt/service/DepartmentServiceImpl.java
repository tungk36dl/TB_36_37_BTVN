package com.tt.service;



import com.tt.entity.Department;
import com.tt.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

     @Autowired
    private DepartmentRepository departmentRepo;

    // c2:
//    public DepartmentServiceImpl(DepartmentRepository departmentRepo) {
//        this.departmentRepo = departmentRepo;
//    }


    @Override
    public List<Department> getAll() {
        List<Department> departments = departmentRepo.findAll();
        return departments;
    }

}
