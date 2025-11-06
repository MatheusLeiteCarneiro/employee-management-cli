package entities.sales;

import entities.Employee;

public abstract class SalesEmployee extends Employee {
    private double monthSales;

    public SalesEmployee(int id, String name, double baseSalary, double monthSales) {
        super(id, name, baseSalary);
        this.monthSales = monthSales;
    }

    public double getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(double monthSales) {
        this.monthSales = monthSales;
    }

    public static boolean verifyLevel(Integer level) {
        if (level == null) {
            return false;
        }
        if (level == 1 || level == 2 || level == 3) {
            return true;
        }
        return false;
    }

}
