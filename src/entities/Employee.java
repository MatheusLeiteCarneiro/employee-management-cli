package entities;

public abstract class Employee {
    private int id;
    private String name;
    private double baseSalary;


    public Employee() {
    }

    public Employee(String name, Double baseSalary) {
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

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void increaseSalary(Double increaseValue){
        baseSalary += increaseValue;
    }

    public abstract Double totalPayment();

}
