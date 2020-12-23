package com.mike.menu;

import com.mike.action.Action;
import com.mike.entity.Department;

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
