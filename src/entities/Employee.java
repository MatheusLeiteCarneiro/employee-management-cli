package entities;

public abstract class Employee {
    private String name;
    private Double baseSalary;
    private Double salesValue;

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

    public Double getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(Double salesValue) {
        this.salesValue = salesValue;
    }
    public void increaseSalary(Double increaseValue){
        baseSalary += increaseValue;
    }

    public abstract Double totalPayment();

}
