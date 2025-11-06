package entities.dev;

import entities.Employee;

public abstract class DevEmployee extends Employee {
    private int projectsMade;

    public DevEmployee() {
        super();
    }

    public DevEmployee(int id, String name, double baseSalary, int projectsMade) {
        super(id, name, baseSalary);
        this.projectsMade = projectsMade;
    }

    public int getProjectsMade() {
        return projectsMade;
    }

    public void setProjectsMade(int projectsMade) {
        this.projectsMade = projectsMade;
    }
}
