package entities.dev;

public class DevIntern extends DevEmployee{
    private static final double BONUS_PER_PROJECT = 50.00;

    public DevIntern() {
        super();
    }

    public DevIntern(int id, String name, double baseSalary, int projectsMade) {
        super(id, name, baseSalary, projectsMade);
    }

    @Override
    public Double totalPayment() {
        return getBaseSalary() + (getProjectsMade() * BONUS_PER_PROJECT);
    }
}
