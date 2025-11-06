package entities;

public class HrEmployee extends Employee{
    public HrEmployee() {
        super();
    }

    public HrEmployee(int id, String name, Double baseSalary) {
        super(id, name, baseSalary);
    }

    @Override
    public Double totalPayment() {
        return getBaseSalary();
    }

    @Override
    public String deparmentAndLevel() {
        return "Human resources";
    }
}
