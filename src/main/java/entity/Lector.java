package entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collections;
import java.util.Set;

@Entity
public class Lector {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToMany(mappedBy = "lectors")
    private Set<Department> departments;

    private Integer salary;

    public Lector() {
    }

    public Lector(String name, Degree degree, Set<Department> departments, Integer salary) {
        this.name = name;
        this.degree = degree;
        this.departments = departments;
        this.salary = salary;
    }

    public Lector(String name, Degree degree, Integer salary) {
        this(name, degree, Collections.emptySet(), salary);
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public enum Degree {
        ASSISTANT("Assistants"),
        ASSOCIATE_PROFESSOR("Associate professors"),
        PROFESSOR("Professors");

        String description;

        Degree(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }
}
