package com.tt.sevice;

import com.tt.entity.Department;
import com.tt.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepository departmentRepo;

    @Override
    public List<Department> getAllDepartment() {
        List<Department> departments = departmentRepo.findAll();
        return departments;
    }
}
