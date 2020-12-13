package dao;

import entity.Lector;

import java.util.List;

public interface LectorDao {

    Lector findById(Long id);

    /**
     * @return list of Object arrays, which consist of two elements:
     *  - {@link Lector.Degree} degree as first element of array
     *  - {@link Integer} count as second element
     */
    List<Object[]> getCountsByDegree(Long departmentId);

    Double getAverageSalary(Long departmentId);

    List<Lector> searchByTemplate(String searchTemplate);
}
