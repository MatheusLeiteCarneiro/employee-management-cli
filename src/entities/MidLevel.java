package entities;

public class MidLevel extends Employee {
    private static Double salesPercentageBonus ;
    private static Double goalPercentageBonus ;
    private double salesGoal ;

    public MidLevel(String name, Double baseSalary, double salesGoal) {
        super(name, baseSalary);
        this.salesGoal = salesGoal;
    }


    public static Double getSalesPercentageBonus() {
        return salesPercentageBonus;
    }

    public static void setSalesPercentageBonus(Double salesPercentageBonus) {
        MidLevel.salesPercentageBonus = salesPercentageBonus;
    }

    public static Double getGoalPercentageBonus() {
        return goalPercentageBonus;
    }

    public static void setGoalPercentageBonus(Double goalPercentageBonus) {
        MidLevel.goalPercentageBonus = goalPercentageBonus;
    }

    public void setSalesGoal(double salesGoal) {
        this.salesGoal = salesGoal;
    }

    public Double getSalesGoal() {
        return salesGoal;
    }

    @Override
    public Double totalPayment() {
        if(salesGoal <= getSalesValue()){
            return getBaseSalary() + (getSalesValue() * salesPercentageBonus) + (getBaseSalary() * goalPercentageBonus);
        }
        return getBaseSalary() + (getSalesValue() * salesPercentageBonus);
    }
}
