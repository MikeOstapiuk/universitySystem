package dao;

import entity.Department;

import java.util.List;

public interface DepartmentDao {

    Department findById(Long id);

    List<Department> findAll();

    Long getHeadLectorId(Long id);

    Long countLectorsByDepartment(Long id);

    List<Department> searchByTemplate(String string);
}
