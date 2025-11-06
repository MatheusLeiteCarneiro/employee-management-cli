package entities.sales;

public class SalesTrainee extends SalesEmployee {

    private static final double COMISSION_RATE = 0.01;

    public SalesTrainee(int id, String name, double baseSalary, double monthSales) {
        super(id, name, baseSalary, monthSales);
    }

    @Override
    public double totalPayment() {
        return getBaseSalary() + (getMonthSales() * COMISSION_RATE);
    }

    @Override
    public String deparmentAndLevel() {
        return "Sales-Trainee";
    }
}
