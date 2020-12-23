package com.mike;

import com.mike.action.SearchAction;
import com.mike.menu.DepartmentsMenu;
import com.mike.menu.Menu;
import com.mike.menu.MenuAction;
import com.mike.menu.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.mike.service.DepartmentService;

import java.util.List;

@SpringBootApplication
public class UniversitySystemApplication {


    public static void main(String[] args) {
        SpringApplication.run(UniversitySystemApplication.class, args)
                .getBean("mainMenu", MenuItem.class).executeMenuItem(null);
    }

    @Bean
    public Menu mainMenu(@Qualifier("mainMenuItem") List<MenuItem> menuItems) {
        return new Menu(null, menuItems);
    }

    @Bean
    @Qualifier("mainMenuItem")
    MenuItem departmentListMenu(@Qualifier("departmentMenuItem") List<MenuItem> menuItems) {
        return new DepartmentsMenu("Department list", menuItems);
    }

    @Bean
    @Qualifier("departmentMenuItem")
    MenuItem showHeadOfDepartment(@Autowired DepartmentService departmentService) {
        return new MenuAction("Head of Department", departmentService::showHeadOfDepartment);
    }

    @Bean
    @Qualifier("departmentMenuItem")
    MenuItem showCountOfEmployees(@Autowired DepartmentService departmentService) {
        return new MenuAction("Count of employees", departmentService::showCountOfEmployees);
    }

    @Bean
    @Qualifier("departmentMenuItem")
    MenuItem showAvgSalary(@Autowired DepartmentService departmentService) {
        return new MenuAction("Show average salary", departmentService::showAvgSalary);
    }

    @Bean
    @Qualifier("departmentMenuItem")
    MenuItem showStatistics(@Autowired DepartmentService departmentService) {
        return new MenuAction("Show statistics", departmentService::showStatistics);
    }

    @Bean
    @Qualifier("mainMenuItem")
    MenuItem searchMenu(@Autowired SearchAction searchAction) {
        return new MenuAction("Search", searchAction);
    }
}
