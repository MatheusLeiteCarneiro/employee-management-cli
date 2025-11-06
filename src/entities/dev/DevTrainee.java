package entities.dev;

public class DevTrainee extends DevEmployee{
    private static final double BONUS_PER_PROJECT = 50.00;

    public DevTrainee(int id, String name, double baseSalary, int projectsMade) {
        super(id, name, baseSalary, projectsMade);
    }

    @Override
    public Double totalPayment() {
        return getBaseSalary() + (getProjectsMade() * BONUS_PER_PROJECT);
    }

    @Override
    public String deparmentAndLevel() {
        return "Developer-Trainee";
    }
}

