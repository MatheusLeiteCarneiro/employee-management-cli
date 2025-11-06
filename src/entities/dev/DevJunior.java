package entities.dev;

public class DevJunior extends DevEmployee {
    private static final double BONUS_PER_PROJECT = 150.00;


    public DevJunior(int id, String name, double baseSalary, int projectsMade) {
        super(id, name, baseSalary, projectsMade);
    }

    @Override
    public double totalPayment() {
        return getBaseSalary() + (getProjectsMade() * BONUS_PER_PROJECT);
    }

    @Override
    public String deparmentAndLevel() {
        return "Developer-Junior";
    }
}
