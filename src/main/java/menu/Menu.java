package menu;

import entity.Department;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu extends MenuItem {
    protected static final String MENU_ITEM = "%s. %s \n";
    protected static final String RETURN_TO_TOP_MENU = "Return to top menu";
    protected static final String WRONG_COMMAND = "Wrong command";

    private final List<MenuItem> subMenus;

    public Menu(String label, List<MenuItem> subMenus) {
        super(label);
        this.subMenus = subMenus;
    }

    public Menu(String label) {
        super(label);
        subMenus = new ArrayList<>();
    }

    public void addMenuItemToSubMenu(MenuItem... menuItems) {
        subMenus.addAll(Arrays.asList(menuItems));
    }

    @Override
    public void executeMenuItem(Department context) {
        while (true) {
            printMenu();
            int input = readInput();
            if (input > 0 && input <= subMenus.size()) {
                subMenus.get(input - 1).executeMenuItem(context);
            } else if (input == subMenus.size() + 1) {
                return;
            } else {
                System.out.println(WRONG_COMMAND);
            }
        }
    }

    private void printMenu() {
        for (int i = 0; i < subMenus.size(); i++) {
            System.out.format(MENU_ITEM, i + 1, subMenus.get(i).getLabel());
        }
        System.out.format(MENU_ITEM, subMenus.size() + 1, RETURN_TO_TOP_MENU);
    }

    protected int readInput() {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return -1;
        }
        return scanner.nextInt();
    }
}
