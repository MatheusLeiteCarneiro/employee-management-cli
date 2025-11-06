package entities.sales;

public class SalesTrainee extends SalesEmployee{

   private static final double COMISSION_RATE = 0.01;

    public SalesTrainee() {
        super();
    }

    public SalesTrainee(String name, double baseSalary, double monthSales) {
        super(name, baseSalary, monthSales);
    }

    @Override
    public Double totalPayment() {
        return getBaseSalary() + (getMonthSales() * COMISSION_RATE);
    }
}
