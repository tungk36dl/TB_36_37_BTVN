package com.tt.sevice;


import com.tt.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    List<Department> getAllDepartment();
}
