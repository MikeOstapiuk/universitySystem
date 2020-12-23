package com.mike.action;

import com.mike.entity.Department;
import com.mike.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SearchAction implements Action {

    @Autowired
    private SearchService searchService;

    @Override
    public void doAction(Department context) {
        System.out.println("Enter search query: ");
        Scanner scanner = new Scanner(System.in);
        searchService.getByTemplate(scanner.next());
    }
}
