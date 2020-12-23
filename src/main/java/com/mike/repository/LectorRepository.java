package com.mike.repository;

import com.mike.entity.Lector;
import com.mike.queryResult.CountResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    @Override
    Optional<Lector> findById(Long aLong);

    Long countByDepartments_Id(Long departmentId);

    @Query("SELECT new com.mike.queryResult.CountResult(COUNT(*), l.degree) " +
            "FROM Lector l " +
            "JOIN l.departments d " +
            "WHERE d.id=?1 " +
            "GROUP BY l.degree")
    List<CountResult> getCountsByDegree(Long departmentId);

    @Query("SELECT AVG(l.salary) " +
            "FROM Lector l " +
            "JOIN l.departments d " +
            "WHERE d.id=?1")
    Optional<Double> getAverageSalary(Long departmentId);

    List<Lector> findByNameLike(String name);
}
