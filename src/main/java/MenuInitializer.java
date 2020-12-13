import actions.SearchAction;
import entity.Department;
import actions.Action;
import menu.DepartmentListMenu;
import menu.MenuAction;
import menu.MenuItem;
import menu.Menu;
import service.DepartmentService;
import service.DepartmentServiceImpl;

public class MenuInitializer {
    public static void main(String[] args) {
        initializeMenu().executeMenuItem(null);
    }

    // This initializer was added in order to keep project simple and refrain from using any additional frameworks with
    // IoC containers. It could be substituted with Spring or any other IoC container fairly easy.
    public static MenuItem initializeMenu() {
        DepartmentService departmentService = new DepartmentServiceImpl();

        Menu mainMenu = new Menu(null);
        DepartmentListMenu departmentList = new DepartmentListMenu("Department list");
        MenuItem search = new MenuAction("Search", new SearchAction());
        mainMenu.addMenuItemToSubMenu(departmentList, search);

        MenuItem showHeadOfDepartment = new MenuAction("Head of Department", new Action() {
            @Override
            public void doAction(Department context) {
                departmentService.showHeadOfDepartment(context.getId());
            }
        });
        MenuItem showCountOfEmployees = new MenuAction("Count of employees", new Action() {
            @Override
            public void doAction(Department context) {
                departmentService.showCountOfEmployees(context.getId());
            }
        });
        MenuItem showAvgSalary = new MenuAction("Show average salary", new Action() {
            @Override
            public void doAction(Department context) {
                departmentService.showAvgSalary(context.getId());
            }
        });
        MenuItem showStatistics = new MenuAction("Show statistics", new Action() {
            @Override
            public void doAction(Department context) {
                departmentService.showStatistics(context.getId());
            }
        });
        departmentList.addMenuItemToSubMenu(showHeadOfDepartment, showCountOfEmployees, showAvgSalary, showStatistics);
        return mainMenu;
    }
}
