package entities.sales;

import entities.Employee;

public abstract class SalesEmployee extends Employee {
    private double monthSales;

    public SalesEmployee() {
        super();
    }

    public SalesEmployee(int id, String name, double baseSalary, double monthSales) {
        super(id,name, baseSalary);
        this.monthSales = monthSales;
    }

    public double getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(double monthSales) {
        this.monthSales = monthSales;
    }

}
