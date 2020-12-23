package com.mike.service;

import com.mike.entity.Department;
import com.mike.queryResult.CountResult;
import com.mike.repository.DepartmentRepository;
import com.mike.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    private static final String AVERAGE_SALARY = "The average salary of %s is %.2f \n";
    private static final String HEAD_OF_DEPARTMENT = "Head of %s department is %s\n";
    private static final String LECTORS_BY_DEGREE = "Lectors by degree in %s department:\n";
    private static final String STATISTICS_BY_DEGREE = "%s - %s \n";
    private static final String NO_HEAD_LECTOR = "Department %s has no head lector\n";
    private static final String NO_LECTORS = "Department %s has no lectors\n";
    private static final String COUNT_LECTORS = "Department %s includes %d lectors\n";

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LectorRepository lectorRepository;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void showStatistics(Department department) {
        List<CountResult> results = lectorRepository.getCountsByDegree(department.getId());
        if (results.isEmpty()) {
            System.out.format(NO_LECTORS, department.getName());
        } else {
            System.out.format(LECTORS_BY_DEGREE, department.getName());
            results.forEach(r -> System.out.format(STATISTICS_BY_DEGREE, r.getCount(), r.getDegree()));
            System.out.println();
        }
    }

    @Override
    public void showHeadOfDepartment(Department department) {
        String message = Optional.ofNullable(department.getHeadLector())
                .map(h -> String.format(HEAD_OF_DEPARTMENT, department.getName(), h.getName()))
                .orElse(String.format(NO_HEAD_LECTOR, department.getName()));
        System.out.print(message);
    }

    @Override
    public void showAvgSalary(Department department) {
        Optional<Double> salary = lectorRepository.getAverageSalary(department.getId());
        String message = salary.map(s -> String.format(AVERAGE_SALARY, department.getName(), s))
                .orElse(String.format(NO_LECTORS, department.getName()));
        System.out.println(message);
    }

    @Override
    public void showCountOfEmployees(Department department) {
        Long count = lectorRepository.countByDepartments_Id(department.getId());
        if (count == 0) {
            System.out.format(NO_LECTORS, department.getName());
        } else {
            System.out.format(COUNT_LECTORS, department.getName(), count);
        }
    }
}
