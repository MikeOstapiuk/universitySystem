package actions;

import entity.Department;
import service.SearchService;
import service.SearchServiceImpl;

import java.util.Scanner;

public class SearchAction implements Action {
    private final SearchService searchService = new SearchServiceImpl();

    @Override
    public void doAction(Department context) {
        System.out.println("Enter search query: ");
        Scanner scanner = new Scanner(System.in);
        searchService.getByTemplate(scanner.next());
    }
}
