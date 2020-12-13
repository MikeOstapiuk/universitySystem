package menu;

import actions.Action;
import entity.Department;

public final class MenuAction extends MenuItem {
    private final Action action;

    public MenuAction(String label, Action action) {
        super(label);
        this.action = action;
    }

    @Override
    public void executeMenuItem(Department context) {
        action.doAction(context);
    }
}
