package entities.sales;

public class SalesExecutive extends SalesEmployee {
    private static final double COMISSION_RATE = 0.04;


    public SalesExecutive(int id, String name, double baseSalary, double monthSales) {
        super(id, name, baseSalary, monthSales);
    }

    @Override
    public Double totalPayment() {
        return getBaseSalary() + (getMonthSales() * COMISSION_RATE);
    }
}
