package com.mike.repository;

import com.mike.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Override
    Optional<Department> findById(Long aLong);

    @Override
    List<Department> findAll();

    List<Department> findByNameLike(String name);
}
