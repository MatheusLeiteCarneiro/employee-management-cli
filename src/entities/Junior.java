package entities;

public class Junior extends Employee{

    private static Double salesPercentageBonus ;

    public Junior(String name, Double baseSalary) {
        super(name, baseSalary);
    }

    public static void setSalesPercentageBonus(Double salesPercentageBonus) {
        Junior.salesPercentageBonus = salesPercentageBonus;
    }

    public Double getSalesPercentageBonus() {
        return salesPercentageBonus;
    }

    @Override
    public Double totalPayment() {
        return getBaseSalary() + (getSalesValue() * salesPercentageBonus);
    }
}
