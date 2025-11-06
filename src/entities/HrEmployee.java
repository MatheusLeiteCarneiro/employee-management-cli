package entities;

public class HrEmployee extends Employee{
    public HrEmployee() {
        super();
    }

    public HrEmployee(String name, Double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public Double totalPayment() {
        return getBaseSalary();
    }
}
