package com.tt.service;

import com.tt.entity.Department;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface DepartmentService {

    // abstraact method, public access modifier
     List<Department> getAll();


}
