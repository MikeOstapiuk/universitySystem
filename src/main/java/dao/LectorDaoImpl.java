package dao;

import entity.Lector;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LectorDaoImpl implements LectorDao {

    private static final String COUNT_BY_DEGREE = "SELECT count(l), l.degree FROM " + Lector.class.getName() + " l " +
                                                  "INNER JOIN l.departments d " +
                                                  "WHERE d.id = :dId " +
                                                  "GROUP BY l.degree";
    private static final String AVERAGE_SALARY = "SELECT avg(l.salary) FROM " + Lector.class.getName() + " l " +
                                                 "INNER JOIN l.departments d " +
                                                 "WHERE d.id = :dId";
    private static final String SEARCH_BY_TEMPLATE = "FROM " + Lector.class.getName() + " l " +
                                                     "WHERE l.name LIKE :name";

    private static Session getSession() {
        return new Configuration().configure().buildSessionFactory().openSession();
    }

    @Override
    public Lector findById(Long id) {
        return getSession().get(Lector.class, id);
    }

    @Override
    public List<Object[]> getCountsByDegree(Long departmentId) {
        return getSession().createQuery(COUNT_BY_DEGREE).setParameter("dId", departmentId).list();
    }

    @Override
    public Double getAverageSalary(Long departmentId) {
        return (Double) getSession().createQuery(AVERAGE_SALARY).setParameter("dId", departmentId).getSingleResult();
    }

    @Override
    public List<Lector> searchByTemplate(String searchTemplate) {
        return getSession().createQuery(SEARCH_BY_TEMPLATE).setParameter("name", "%" + searchTemplate + "%").list();
    }
}
