package com.mike.menu;

import com.mike.entity.Department;

abstract public class MenuItem {
    protected String label;

    public MenuItem(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public abstract void executeMenuItem(Department context);
}
