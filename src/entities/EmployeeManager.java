package entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employeeList;

    public EmployeeManager() {
        this.employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int index) {
        employeeList.remove(index);
    }

    public int verifyId(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employeeList.indexOf(employee);
            }
        }

        return -1;
    }

    public boolean verifyIfHaveEmployee() {
        if (employeeList.isEmpty()) {
            return false;
        }
        return true;
    }

    public double totalPayroll() {
        double sum = 0.0;
        for (Employee employee : employeeList) {
            sum += employee.totalPayment();
        }
        return sum;
    }

    public String listAllEmployees() {
        employeeList.sort(Comparator.comparing(Employee::getId));
        StringBuilder sb = new StringBuilder();
        sb.append("Employees list:\n");
        for (Employee employee : employeeList) {
            sb.append(employee.employeeRegister() + "\n");
        }
        return sb.toString();
    }

    public String payRollList() {
        employeeList.sort(Comparator.comparing(Employee::getId));
        StringBuilder sb = new StringBuilder();
        sb.append("Payroll List:\n");
        double total = 0.0;
        for (Employee employee : employeeList) {
            sb.append(employee.paymentForEmployee() + "\n");
            total += employee.totalPayment();
        }
        sb.append("Total: $" + String.format("%.2f", total));
        return sb.toString();
    }

}
