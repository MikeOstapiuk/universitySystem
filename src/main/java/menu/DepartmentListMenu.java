package menu;

import entity.Department;
import service.DepartmentService;
import service.DepartmentServiceImpl;

import java.util.List;

public class DepartmentListMenu extends Menu {
    private final DepartmentService departmentService = new DepartmentServiceImpl();

    public DepartmentListMenu(String label, List<MenuItem> subMenus) {
        super(label, subMenus);
    }

    public DepartmentListMenu(String label) {
        super(label);
    }

    @Override
    public void executeMenuItem(Department context) {
        while (true) {
            List<Department> departmentList = departmentService.getAll();
            printDepartmentList(departmentList);
            int input = readInput();
            if (input > 0 && input <= departmentList.size()) {
                super.executeMenuItem(departmentList.get(input - 1));
            } else if (input == departmentList.size() + 1) {
                return;
            } else {
                System.out.println(WRONG_COMMAND);
            }
        }
    }

    private void printDepartmentList(List<Department> departmentList) {
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.format(MENU_ITEM, i + 1, departmentList.get(i).getName());
        }
        System.out.format(MENU_ITEM, departmentList.size() + 1, RETURN_TO_TOP_MENU);
    }
}
