package entities;

public abstract class Employee {
    private int id;
    private String name;
    private double baseSalary;


    public Employee() {
    }

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void increaseSalary(double increaseValue){
        baseSalary += increaseValue;
    }

    public abstract Double totalPayment();

}
