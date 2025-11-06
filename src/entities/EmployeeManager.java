package entities;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employeeList ;

    public EmployeeManager() {
        this.employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    public void addEmploye(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmploye(Employee employee){
        employeeList.remove(employee);
    }
    public double totalPayroll(){
        double sum = 0.0;
        for (Employee employee : employeeList){
            sum += employee.totalPayment();
        }
        return sum;
    }
    public String listAllEmployees(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employees list:\n");
        for (Employee employee : employeeList){
            sb.append("ID: " + employee.getId() + ", Name: " + employee.getName() + "\n");
        }
        return sb.toString();
    }
}
