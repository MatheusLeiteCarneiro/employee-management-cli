package entities;

public class Senior extends Employee{
    private static Double salesPercentageBonus ;
    private static Double goalPercentageBonus ;
    private double salesGoal ;


    public Senior(String name, double baseSalary, double salesGoal) {
        super(name, baseSalary);
        this.salesGoal = salesGoal;
    }

    public static Double getSalesPercentageBonus() {
        return salesPercentageBonus;
    }

    public static void setSalesPercentageBonus(Double salesPercentageBonus) {
        Senior.salesPercentageBonus = salesPercentageBonus;
    }

    public static Double getGoalPercentageBonus() {
        return goalPercentageBonus;
    }

    public static void setGoalPercentageBonus(Double goalPercentageBonus) {
        Senior.goalPercentageBonus = goalPercentageBonus;
    }

    public double getSalesGoal() {
        return salesGoal;
    }

    public void setSalesGoal(double salesGoal) {
        this.salesGoal = salesGoal;
    }

    @Override
    public Double totalPayment() {
        if(salesGoal <= getSalesValue()){
            return getBaseSalary() + (getSalesValue() * salesPercentageBonus) + (getBaseSalary() * goalPercentageBonus);
        }
        return getBaseSalary() + (getSalesValue() * salesPercentageBonus);
    }
}
