package entities.sales;

public class SalesAssociate extends SalesEmployee{
    private static final double COMISSION_RATE = 0.025;


    public SalesAssociate(int id, String name, double baseSalary, double monthSales) {
        super(id, name, baseSalary, monthSales);
    }

    @Override
    public Double totalPayment() {
        return getBaseSalary() + (getMonthSales() * COMISSION_RATE);
    }
}
