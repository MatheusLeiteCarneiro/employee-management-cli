package entities.dev;

public class DevJunior extends DevEmployee{
    private static final double BONUS_PER_PROJECT = 150.00;

    public DevJunior() {
        super();
    }

    public DevJunior(int id, String name, double baseSalary, int projectsMade) {
        super(id, name, baseSalary, projectsMade);
    }

    @Override
    public Double totalPayment() {
        return getBaseSalary() + (getProjectsMade() * BONUS_PER_PROJECT);
    }
}
