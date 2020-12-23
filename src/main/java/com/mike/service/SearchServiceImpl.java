package com.mike.service;

import com.mike.entity.Department;
import com.mike.entity.Lector;
import com.mike.repository.DepartmentRepository;
import com.mike.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    public static final String NO_MATCHES_FOUND = "No matches found";
    public static final String FOUND_LECTORS_BY_TEMPLATE = "Found lectors by template:";
    public static final String FOUND_DEPARTMENTS_BY_TEMPLATE = "Found Departments by template:";
    public static final String FORMAT_ENTITY = "id: %s name: %s \n";
    public static final String WILDCARD = "%%%s%%";

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private LectorRepository lectorRepository;

    @Override
    public void getByTemplate(String wildcard) {
        List<Lector> lectors = lectorRepository.findByNameLike(String.format(WILDCARD, wildcard));
        List<Department> departments = departmentRepository.findByNameLike(String.format(WILDCARD, wildcard));
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
