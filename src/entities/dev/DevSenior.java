package entities.dev;

public class DevSenior extends DevEmployee{
    private static final double BONUS_PER_PROJECT = 500.00;

    public DevSenior() {
        super();
    }

    public DevSenior(String name, double baseSalary, int projectsMade) {
        super(name, baseSalary, projectsMade);
    }

    @Override
    public Double totalPayment() {
        return getBaseSalary() + (getProjectsMade() * BONUS_PER_PROJECT);
    }
}
