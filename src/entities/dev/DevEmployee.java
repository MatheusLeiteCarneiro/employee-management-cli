package entities.dev;

import entities.Employee;

public abstract class DevEmployee extends Employee {
    private int projectsMade;

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

    public static boolean verifyLevel(Integer level) {
        if (level == null) {
            return false;
        }
        if (level == 1 || level == 2 || level == 3 || level == 4) {
            return true;
        }
        return false;
    }
}
