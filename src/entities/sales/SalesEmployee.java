package entities.sales;

import entities.Employee;

public abstract class SalesEmployee extends Employee {
    private double monthSales;

    public SalesEmployee() {
        super();
    }

    public SalesEmployee(String name, Double baseSalary, double monthSales) {
        super(name, baseSalary);
        this.monthSales = monthSales;
    }

    public double getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(double monthSales) {
        this.monthSales = monthSales;
    }

}
