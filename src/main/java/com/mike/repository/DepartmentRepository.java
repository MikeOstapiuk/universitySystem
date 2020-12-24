package com.mike.repository;

import com.mike.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Override
    List<Department> findAll();

    List<Department> findByNameLike(String name);
}
