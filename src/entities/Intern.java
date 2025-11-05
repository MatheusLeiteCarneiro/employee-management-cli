package entities;

public class Intern extends Employee{

    public Intern(String name, Double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public Double totalPayment() {
        return getBaseSalary();
    }
}
