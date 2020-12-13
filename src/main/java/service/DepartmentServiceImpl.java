package service;

import dao.DepartmentDaoImpl;
import dao.LectorDaoImpl;
import entity.Department;
import dao.DepartmentDao;
import dao.LectorDao;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private static final String AVERAGE_SALARY = "The average salary of %s is %.2f \n";
    private static final String HEAD_OF_DEPARTMENT = "Head of %s department is %s \n";
    private static final String LECTORS_BY_DEGREE = "Lectors by degree in %s department:\n";
    private static final String STATISTICS_BY_DEGREE = "%s - %s \n";

    private final DepartmentDao departmentDao = new DepartmentDaoImpl();
    private final LectorDao lectorDao = new LectorDaoImpl();


    @Override
    public List<Department> getAll() {
        return departmentDao.findAll();
    }

    @Override
    public void showStatistics(Long id) {
        String departmentName = departmentDao.findById(id).getName();
        List<Object[]> results = lectorDao.getCountsByDegree(id);
        System.out.format(LECTORS_BY_DEGREE, departmentName);
        results.forEach(r -> System.out.format(STATISTICS_BY_DEGREE, r[1], r[0]));
    }

    @Override
    public void showHeadOfDepartment(Long id) {
        Long headLectorId = departmentDao.getHeadLectorId(id);
        System.out.format(HEAD_OF_DEPARTMENT, departmentDao.findById(id).getName(), lectorDao.findById(headLectorId).getName());
    }

    @Override
    public void showAvgSalary(Long id) {
        Department department = departmentDao.findById(id);
        System.out.format(AVERAGE_SALARY, department.getName(), lectorDao.getAverageSalary(id));
    }

    @Override
    public void showCountOfEmployees(Long id) {
        System.out.println(departmentDao.countLectorsByDepartment(id));
    }
}
