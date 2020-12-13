package dao;

import entity.Department;
import entity.Lector;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private static final String FIND_ALL = "FROM " + Department.class.getName();
    private static final String GET_HEAD_LECTOR_ID = "SELECT d.headLector.id " +
                                                     "FROM " + Department.class.getName() + " d " +
                                                     "WHERE d.id = :dId";
    private static final String COUNT_LECTORS_BY_DEPARTMENT = "SELECT count(l) " +
                                                              "FROM " + Lector.class.getName() + " l " +
                                                              "RIGHT JOIN l.departments d " +
                                                              "WHERE d.id = :dId";
    private static final String SEARCH_BY_TEMPLATE = "FROM " + Department.class.getName() + " d " +
                                                     "WHERE d.name LIKE :name";

    private static Session getSession() {
        return new Configuration().configure().buildSessionFactory().openSession();
    }

    @Override
    public Department findById(Long id) {
        return getSession().get(Department.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Department> findAll() {
        return getSession().createQuery(FIND_ALL).list();
    }

    @Override
    public Long getHeadLectorId(Long id) {
        return (Long) getSession().createQuery(GET_HEAD_LECTOR_ID).setParameter("dId", id).getSingleResult();
    }

    @Override
    public Long countLectorsByDepartment(Long id) {
        return (Long) getSession().createQuery(COUNT_LECTORS_BY_DEPARTMENT).setParameter("dId", id).getSingleResult();
    }

    @Override
    public List<Department> searchByTemplate(String string) {
        return getSession().createQuery(SEARCH_BY_TEMPLATE).setParameter("name", "%" + string + "%").list();
    }
}
