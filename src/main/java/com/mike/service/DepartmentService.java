package com.mike.service;

import com.mike.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAll();

    void showStatistics(Department department);

    void showHeadOfDepartment(Department department);

    void showAvgSalary(Department department);

    void showCountOfEmployees(Department department);
}
