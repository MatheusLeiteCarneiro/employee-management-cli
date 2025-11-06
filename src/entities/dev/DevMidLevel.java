package entities.dev;

public class DevMidLevel extends DevEmployee{
    private static final double BONUS_PER_PROJECT = 300.00;

    public DevMidLevel() {
        super();
    }

    public DevMidLevel(String name, double baseSalary, int projectsMade) {
        super(name, baseSalary, projectsMade);
    }

    @Override
    public Double totalPayment() {
        return getBaseSalary() + (getProjectsMade() * BONUS_PER_PROJECT);
    }
}
