package entities;

public abstract class Employee {
    private int id;
    private String name;
    private double baseSalary;


    public Employee() {
    }

    public Employee(int id ,String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getId() {
        return id;
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

    public String paymentForEmployee(){
        return getId() + "- " + getName() + " | totalPayment: $" + String.format("%.2f", totalPayment());
    }
    public String typeOfEmployee(){
        StringBuilder sb = new StringBuilder();
        sb.append( getId() + "- " + getName() + " | " + deparmentAndLevel());
        return sb.toString();
    }

    public abstract Double totalPayment();
    public abstract String deparmentAndLevel();

}
