package service;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import dao.LectorDao;
import dao.LectorDaoImpl;
import entity.Department;
import entity.Lector;

import java.util.List;

public class SearchServiceImpl implements SearchService {

    public static final String NO_MATCHES_FOUND = "No matches found";
    public static final String FOUND_LECTORS_BY_TEMPLATE = "Found lectors by template:";
    public static final String FOUND_DEPARTMENTS_BY_TEMPLATE = "Found Departments by template:";
    public static final String FORMAT_ENTITY = "id: %s name: %s \n";
    LectorDao lectorDao = new LectorDaoImpl();
    DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public void getByTemplate(String wildcard) {
        List<Lector> lectors = lectorDao.searchByTemplate(wildcard);
        List<Department> departments = departmentDao.searchByTemplate(wildcard);
        if (lectors.isEmpty() && departments.isEmpty()) {
            System.out.println(NO_MATCHES_FOUND);
            return;
        }
        if (!lectors.isEmpty()) {
            System.out.println(FOUND_LECTORS_BY_TEMPLATE);
            lectors.forEach(l -> System.out.format(FORMAT_ENTITY, l.getId(), l.getName()));
        }
        if (!departments.isEmpty()) {
            System.out.println(FOUND_DEPARTMENTS_BY_TEMPLATE);
            departments.forEach(d -> System.out.format(FORMAT_ENTITY, d.getId(), d.getName()));
        }
    }
}
