package service;

import entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAll();

    void showStatistics(Long id);

    void showHeadOfDepartment(Long id);

    void showAvgSalary(Long id);

    void showCountOfEmployees(Long id);
}
