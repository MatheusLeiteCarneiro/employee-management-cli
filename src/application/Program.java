package application;

import entities.Employee;
import entities.EmployeeManager;
import entities.HrEmployee;
import entities.dev.*;
import entities.sales.SalesAssociate;
import entities.sales.SalesEmployee;
import entities.sales.SalesExecutive;
import entities.sales.SalesTrainee;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        EmployeeManager employeeManager = new EmployeeManager();
        Integer operation = null;
        System.out.println("Welcome to the Employee Management!");
        do {
            System.out.println("\nWhat's the operation you want to make it?");
            System.out.println("Digit:");
            System.out.println("| 1- Register a new employee | 2- List all employees | 3- Change a employee information |");
            System.out.println("| 4- Delete a employee | 5- Calculate month payment for a employee | 6- Check total payroll |");
            System.out.println("| 0- finish operations |");
            operation = sc.nextInt();
            System.out.println();
            switch (operation) {
                case 1:
                    System.out.println("Employee data:");

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    int verifyId = employeeManager.verifyId(id);
                    while (verifyId != -1 || id < 0) {
                        System.out.print("This ID is not valid choose a new ID: ");
                        id = sc.nextInt();
                        verifyId = employeeManager.verifyId(id);
                    }

                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    while (!validName(name)) {
                        System.out.print("Type a valid name: ");
                        name = sc.nextLine();
                    }

                    System.out.print("Base salary: ");
                    double baseSalary = sc.nextDouble();
                    while (!validValue(baseSalary)) {
                        System.out.print("Type a value greater than 0: ");
                        baseSalary = sc.nextDouble();
                    }
                    System.out.print("Department-(Digit: 1- for Sales, 2- for Developing, 3- for Human Resources): ");
                    Integer department = null;
                    while (!verifyDepartment(department)) {
                        department = sc.nextInt();
                        switch (department) {
                            case 1:
                                System.out.print("Value sold in this month: ");
                                double monthSales = sc.nextDouble();
                                while (!validValue(monthSales)) {
                                    System.out.print("Type a value greater than 0: ");
                                    monthSales = sc.nextDouble();
                                }
                                System.out.print("Level of seller employee (Digit: 1- for Trainee, 2- for Associate, 3- for Executive): ");
                                Integer level = null;
                                while (!SalesEmployee.verifyLevel(level)) {
                                    level = sc.nextInt();
                                    switch (level) {
                                        case 1:
                                            employeeManager.addEmployee(new SalesTrainee(id, name, baseSalary, monthSales));
                                            break;
                                        case 2:
                                            employeeManager.addEmployee(new SalesAssociate(id, name, baseSalary, monthSales));
                                            break;
                                        case 3:
                                            employeeManager.addEmployee(new SalesExecutive(id, name, baseSalary, monthSales));
                                            break;
                                        default:
                                            System.out.println("Invalid level number.");
                                            System.out.print("(Digit: 1- for Trainee, 2- for Associate, 3- for Executive): ");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                System.out.print("Projects completed this month: ");
                                int projectsMade = sc.nextInt();
                                while (!validValue(projectsMade)) {
                                    System.out.print("Type a value greater than 0: ");
                                    projectsMade = sc.nextInt();
                                }
                                System.out.print("Level of developer employee (Digit: 1- for Trainee, 2- for Junior, 3- for Mid level, 4- for Senior): ");
                                level = null;
                                while (!DevEmployee.verifyLevel(level)) {
                                    level = sc.nextInt();
                                    switch (level) {
                                        case 1:
                                            employeeManager.addEmployee(new DevTrainee(id, name, baseSalary, projectsMade));
                                            break;
                                        case 2:
                                            employeeManager.addEmployee(new DevJunior(id, name, baseSalary, projectsMade));
                                            break;
                                        case 3:
                                            employeeManager.addEmployee(new DevMidLevel(id, name, baseSalary, projectsMade));
                                            break;
                                        case 4:
                                            employeeManager.addEmployee(new DevSenior(id, name, baseSalary, projectsMade));
                                            break;
                                        default:
                                            System.out.println("Invalid level number.");
                                            System.out.print("(Digit: 1- for Trainee, 2- for Junior, 3- for Mid level, 4- for Senior): ");
                                            break;
                                    }
                                }


                                break;
                            case 3:
                                employeeManager.addEmployee(new HrEmployee(id, name, baseSalary));
                                break;

                            default:
                                System.out.println("Invalid department number.");
                                System.out.print("(Digit: 1- for Sales, 2- for Developing, 3- for Human Resources): ");
                                break;

                        }
                    }
                    System.out.println("Employee succesfully registered!");
                    break;


                case 2:
                    System.out.print(employeeManager.listAllEmployees());

                    break;


                case 3:
                    int informationToChange = 0;
                    System.out.print("Digit the employee ID you want to change the information: ");
                    int pickId = sc.nextInt();
                    int idIndex = employeeManager.verifyId(pickId);
                    while (idIndex == -1) {
                        System.out.print("This ID does not exist, digit a valid one: ");
                        pickId = sc.nextInt();
                        idIndex = employeeManager.verifyId(pickId);
                    }
                    System.out.println("You chose the employee: " + employeeManager.getEmployeeList().get(idIndex).employeeRegisterWithBaseSalary());
                    System.out.println("What's the information you want to change?");
                    Employee employee = employeeManager.getEmployeeList().get(idIndex);


                    if (employee instanceof HrEmployee) {
                        System.out.print("Digit:(1-Name | 2- Base salary | 3- Department): ");

                        do {
                            informationToChange = sc.nextInt();
                            switch (informationToChange) {
                                case 1:
                                    System.out.println("The actual name is: " + employee.getName());
                                    System.out.print("New name: ");
                                    name = sc.nextLine();
                                    while (!validName(name)) {
                                        System.out.print("Type a valid name: ");
                                        name = sc.nextLine();
                                    }
                                    employeeManager.getEmployeeList().get(idIndex).setName(name);
                                    break;
                                case 2:
                                    System.out.println("The actual base salary is: $" + String.format("%.2f", employee.getBaseSalary()));
                                    System.out.print("New base salary: ");
                                    baseSalary = sc.nextDouble();
                                    while (!validValue(baseSalary)) {
                                        System.out.print("Type a value greater than 0: ");
                                        baseSalary = sc.nextDouble();
                                    }
                                    employeeManager.getEmployeeList().get(idIndex).setBaseSalary(baseSalary);

                                    break;

                                case 3:
                                    employeeManager.removeEmployee(idIndex);
                                    System.out.println("The actual department is: " + employee.deparmentAndLevel());
                                    System.out.print("New department (digit: 1- for Sales, 2- for Developing, 3- for Human Resources): ");
                                    department = null;
                                    while (!verifyDepartment(department)) {
                                        department = sc.nextInt();
                                        switch (department) {
                                            case 1:
                                                System.out.print("Value sold in this month: ");
                                                double monthSales = sc.nextDouble();
                                                while (!validValue(monthSales)) {
                                                    System.out.print("Type a value greater than 0: ");
                                                    monthSales = sc.nextDouble();
                                                }
                                                System.out.print("Level of seller employee (Digit: 1- for Trainee, 2- for Associate, 3- for Executive): ");
                                                Integer level = null;
                                                while (!SalesEmployee.verifyLevel(level)) {
                                                    level = sc.nextInt();
                                                    switch (level) {
                                                        case 1:
                                                            employeeManager.addEmployee(new SalesTrainee(employee.getId(), employee.getName(), employee.getBaseSalary(), monthSales));
                                                            break;
                                                        case 2:
                                                            employeeManager.addEmployee(new SalesAssociate(employee.getId(), employee.getName(), employee.getBaseSalary(), monthSales));
                                                            break;
                                                        case 3:
                                                            employeeManager.addEmployee(new SalesExecutive(employee.getId(), employee.getName(), employee.getBaseSalary(), monthSales));
                                                            break;
                                                        default:
                                                            System.out.println("Invalid level number.");
                                                            System.out.print("(Digit: 1- for Trainee, 2- for Associate, 3- for Executive): ");
                                                            break;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.print("Projects completed this month: ");
                                                int projectsMade = sc.nextInt();
                                                while (!validValue(projectsMade)) {
                                                    System.out.print("Type a value greater than 0: ");
                                                    projectsMade = sc.nextInt();
                                                }
                                                System.out.print("Level of developer employee (Digit: 1- for Trainee, 2- for Junior, 3- for Mid level, 4- for Senior): ");
                                                level = null;
                                                while (!DevEmployee.verifyLevel(level)) {
                                                    level = sc.nextInt();
                                                    switch (level) {
                                                        case 1:
                                                            employeeManager.addEmployee(new DevTrainee(employee.getId(), employee.getName(), employee.getBaseSalary(), projectsMade));
                                                            break;
                                                        case 2:
                                                            employeeManager.addEmployee(new DevJunior(employee.getId(), employee.getName(), employee.getBaseSalary(), projectsMade));
                                                            break;
                                                        case 3:
                                                            employeeManager.addEmployee(new DevMidLevel(employee.getId(), employee.getName(), employee.getBaseSalary(), projectsMade));
                                                            break;
                                                        case 4:
                                                            employeeManager.addEmployee(new DevSenior(employee.getId(), employee.getName(), employee.getBaseSalary(), projectsMade));
                                                            break;
                                                        default:
                                                            System.out.println("Invalid level number.");
                                                            System.out.print("(Digit: 1- for Trainee, 2- for Junior, 3- for Mid level, 4- for Senior): ");
                                                            break;
                                                    }
                                                }


                                                break;
                                            case 3:
                                                employeeManager.addEmployee(new HrEmployee(employee.getId(), employee.getName(), employee.getBaseSalary()));
                                                break;

                                            default:
                                                System.out.println("Invalid department number.");
                                                System.out.print("(Digit: 1- for Sales, 2- for Developing, 3- for Human Resources): ");
                                                break;

                                        }
                                    }

                                    break;
                                default:
                                    System.out.print("Invalid, digit:(1-Name | 2- Base salary | 3- Department): ");
                                    break;
                            }
                        } while (!verifyChangeWithoutLevels(informationToChange));
                        System.out.println("Changes saved!");
                    } else if (employee instanceof SalesEmployee) {
                        System.out.print("Digit:(1-Name | 2- Base salary | 3- Department/Level | 4- Value sold): ");
                        do {
                            informationToChange = sc.nextInt();
                            switch (informationToChange) {
                                case 1:
                                    System.out.println("The actual name is: " + employee.getName());
                                    System.out.print("New name: ");
                                    name = sc.nextLine();
                                    while (!validName(name)) {
                                        System.out.print("Type a valid name: ");
                                        name = sc.nextLine();
                                    }
                                    employeeManager.getEmployeeList().get(idIndex).setName(name);
                                    break;
                                case 2:
                                    System.out.println("The actual base salary is: $" + String.format("%.2f", employee.getBaseSalary()));
                                    System.out.print("New base salary: ");
                                    baseSalary = sc.nextDouble();
                                    while (!validValue(baseSalary)) {
                                        System.out.print("Type a value greater than 0: ");
                                        baseSalary = sc.nextDouble();
                                    }
                                    employeeManager.getEmployeeList().get(idIndex).setBaseSalary(baseSalary);

                                    break;

                                case 3:
                                    employeeManager.removeEmployee(idIndex);
                                    System.out.println("The actual department is: " + employee.deparmentAndLevel());
                                    System.out.print("New department (digit: 1- for Sales, 2- for Developing, 3- for Human Resources): ");
                                    department = null;
                                    while (!verifyDepartment(department)) {
                                        department = sc.nextInt();
                                        switch (department) {
                                            case 1:
                                                System.out.print("Value sold in this month: ");
                                                double monthSales = sc.nextDouble();
                                                while (!validValue(monthSales)) {
                                                    System.out.print("Type a value greater than 0: ");
                                                    monthSales = sc.nextDouble();
                                                }
                                                System.out.print("Level of seller employee (Digit: 1- for Trainee, 2- for Associate, 3- for Executive): ");
                                                Integer level = null;
                                                while (!SalesEmployee.verifyLevel(level)) {
                                                    level = sc.nextInt();
                                                    switch (level) {
                                                        case 1:
                                                            employeeManager.addEmployee(new SalesTrainee(employee.getId(), employee.getName(), employee.getBaseSalary(), monthSales));
                                                            break;
                                                        case 2:
                                                            employeeManager.addEmployee(new SalesAssociate(employee.getId(), employee.getName(), employee.getBaseSalary(), monthSales));
                                                            break;
                                                        case 3:
                                                            employeeManager.addEmployee(new SalesExecutive(employee.getId(), employee.getName(), employee.getBaseSalary(), monthSales));
                                                            break;
                                                        default:
                                                            System.out.println("Invalid level number.");
                                                            System.out.print("(Digit: 1- for Trainee, 2- for Associate, 3- for Executive): ");
                                                            break;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.print("Projects completed this month: ");
                                                int projectsMade = sc.nextInt();
                                                while (!validValue(projectsMade)) {
                                                    System.out.print("Type a value greater than 0: ");
                                                    projectsMade = sc.nextInt();
                                                }
                                                System.out.print("Level of developer employee (Digit: 1- for Trainee, 2- for Junior, 3- for Mid level, 4- for Senior): ");
                                                level = null;
                                                while (!DevEmployee.verifyLevel(level)) {
                                                    level = sc.nextInt();
                                                    switch (level) {
                                                        case 1:
                                                            employeeManager.addEmployee(new DevTrainee(employee.getId(), employee.getName(), employee.getBaseSalary(), projectsMade));
                                                            break;
                                                        case 2:
                                                            employeeManager.addEmployee(new DevJunior(employee.getId(), employee.getName(), employee.getBaseSalary(), projectsMade));
                                                            break;
                                                        case 3:
                                                            employeeManager.addEmployee(new DevMidLevel(employee.getId(), employee.getName(), employee.getBaseSalary(), projectsMade));
                                                            break;
                                                        case 4:
                                                            employeeManager.addEmployee(new DevSenior(employee.getId(), employee.getName(), employee.getBaseSalary(), projectsMade));
                                                            break;
                                                        default:
                                                            System.out.println("Invalid level number.");
                                                            System.out.print("(Digit: 1- for Trainee, 2- for Junior, 3- for Mid level, 4- for Senior): ");
                                                            break;
                                                    }
                                                }


                                                break;
                                            case 3:
                                                employeeManager.addEmployee(new HrEmployee(employee.getId(), employee.getName(), employee.getBaseSalary()));
                                                break;

                                            default:
                                                System.out.println("Invalid department number.");
                                                System.out.print("(Digit: 1- for Sales, 2- for Developing, 3- for Human Resources): ");
                                                break;

                                        }
                                    }

                                    break;
                                case 4:
                                    System.out.println("The actual value sold is: $" + String.format("%.2f", ((SalesEmployee) employee).getMonthSales()));
                                    System.out.print("New value sold: ");
                                    double valueSold = sc.nextDouble();
                                    while (!validValue(valueSold)) {
                                        System.out.print("Type a value greater than 0: ");
                                        valueSold = sc.nextDouble();
                                    }
                                    ((SalesEmployee) employeeManager.getEmployeeList().get(idIndex)).setMonthSales(valueSold);
                                    break;
                                default:
                                    System.out.print("Invalid, digit:(1-Name | 2- Base salary | 3- Department/Level | 4- Value sold): ");
                                    break;
                            }
                        } while (!verifyChange(informationToChange));
                        System.out.println("Changes saved!");
                    } else {
                        System.out.print("Digit:(1-Name | 2- Base salary | 3- Department/Level | 4- Projects made): ");
                        do {
                            informationToChange = sc.nextInt();
                            switch (informationToChange) {
                                case 1:
                                    System.out.println("The actual name is: " + employee.getName());
                                    System.out.print("New name: ");
                                    name = sc.nextLine();
                                    while (!validName(name)) {
                                        System.out.print("Type a valid name: ");
                                        name = sc.nextLine();
                                    }
                                    employeeManager.getEmployeeList().get(idIndex).setName(name);
                                    break;
                                case 2:
                                    System.out.println("The actual base salary is: $" + String.format("%.2f", employee.getBaseSalary()));
                                    System.out.print("New base salary: ");
                                    baseSalary = sc.nextDouble();
                                    while (!validValue(baseSalary)) {
                                        System.out.print("Type a value greater than 0: ");
                                        baseSalary = sc.nextDouble();
                                    }
                                    employeeManager.getEmployeeList().get(idIndex).setBaseSalary(baseSalary);

                                    break;

                                case 3:
                                    employeeManager.removeEmployee(idIndex);
                                    System.out.println("The actual department is: " + employee.deparmentAndLevel());
                                    System.out.print("New department (digit: 1- for Sales, 2- for Developing, 3- for Human Resources): ");
                                    department = null;
                                    while (!verifyDepartment(department)) {
                                        department = sc.nextInt();
                                        switch (department) {
                                            case 1:
                                                System.out.print("Value sold in this month: ");
                                                double monthSales = sc.nextDouble();
                                                while (!validValue(monthSales)) {
                                                    System.out.print("Type a value greater than 0: ");
                                                    monthSales = sc.nextDouble();
                                                }
                                                System.out.print("Level of seller employee (Digit: 1- for Trainee, 2- for Associate, 3- for Executive): ");
                                                Integer level = null;
                                                while (!SalesEmployee.verifyLevel(level)) {
                                                    level = sc.nextInt();
                                                    switch (level) {
                                                        case 1:
                                                            employeeManager.addEmployee(new SalesTrainee(employee.getId(), employee.getName(), employee.getBaseSalary(), monthSales));
                                                            break;
                                                        case 2:
                                                            employeeManager.addEmployee(new SalesAssociate(employee.getId(), employee.getName(), employee.getBaseSalary(), monthSales));
                                                            break;
                                                        case 3:
                                                            employeeManager.addEmployee(new SalesExecutive(employee.getId(), employee.getName(), employee.getBaseSalary(), monthSales));
                                                            break;
                                                        default:
                                                            System.out.println("Invalid level number.");
                                                            System.out.print("(Digit: 1- for Trainee, 2- for Associate, 3- for Executive): ");
                                                            break;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.print("Projects completed this month: ");
                                                int projectsMade = sc.nextInt();
                                                while (!validValue(projectsMade)) {
                                                    System.out.print("Type a value greater than 0: ");
                                                    projectsMade = sc.nextInt();
                                                }
                                                System.out.print("Level of developer employee (Digit: 1- for Trainee, 2- for Junior, 3- for Mid level, 4- for Senior): ");
                                                level = null;
                                                while (!DevEmployee.verifyLevel(level)) {
                                                    level = sc.nextInt();
                                                    switch (level) {
                                                        case 1:
                                                            employeeManager.addEmployee(new DevTrainee(employee.getId(), employee.getName(), employee.getBaseSalary(), projectsMade));
                                                            break;
                                                        case 2:
                                                            employeeManager.addEmployee(new DevJunior(employee.getId(), employee.getName(), employee.getBaseSalary(), projectsMade));
                                                            break;
                                                        case 3:
                                                            employeeManager.addEmployee(new DevMidLevel(employee.getId(), employee.getName(), employee.getBaseSalary(), projectsMade));
                                                            break;
                                                        case 4:
                                                            employeeManager.addEmployee(new DevSenior(employee.getId(), employee.getName(), employee.getBaseSalary(), projectsMade));
                                                            break;
                                                        default:
                                                            System.out.println("Invalid level number.");
                                                            System.out.print("(Digit: 1- for Trainee, 2- for Junior, 3- for Mid level, 4- for Senior): ");
                                                            break;
                                                    }
                                                }


                                                break;
                                            case 3:
                                                employeeManager.addEmployee(new HrEmployee(employee.getId(), employee.getName(), employee.getBaseSalary()));
                                                break;

                                            default:
                                                System.out.println("Invalid department number.");
                                                System.out.print("(Digit: 1- for Sales, 2- for Developing, 3- for Human Resources): ");
                                                break;

                                        }
                                    }

                                    break;
                                case 4:
                                    System.out.println("The actual amount of projects made is: " + ((DevEmployee) employee).getProjectsMade());
                                    System.out.print("New projects made amount: ");
                                    int projectsMade = sc.nextInt();
                                    while (!validValue(projectsMade)) {
                                        System.out.print("Type a value greater than 0: ");
                                        projectsMade = sc.nextInt();
                                    }
                                    ((DevEmployee) employeeManager.getEmployeeList().get(idIndex)).setProjectsMade(projectsMade);
                                    break;
                                default:
                                    System.out.print("Invalid, digit:(1-Name | 2- Base salary | 3- Department/Level | 4- Projects made): ");
                                    break;
                            }
                        } while (!verifyChange(informationToChange));
                        System.out.println("Changes saved!");
                    }
                    break;


                case 4:
                    System.out.print("Digit the employee ID you want to delete: ");
                    pickId = sc.nextInt();
                    idIndex = employeeManager.verifyId(pickId);
                    while (idIndex == -1) {
                        System.out.print("This ID does not exist, digit a valid one: ");
                        pickId = sc.nextInt();
                        idIndex = employeeManager.verifyId(pickId);
                    }
                    System.out.println("You chose the employee: " + employeeManager.getEmployeeList().get(idIndex).employeeRegister());
                    System.out.print("Digit: (1-to confirm | 0-to cancel): ");
                    int confirmation = sc.nextInt();
                    while (!verifyResponse(confirmation)) {
                        System.out.print("Invalid response, digit: (1-to confirm | 0-to cancel): ");
                        confirmation = sc.nextInt();
                    }
                    if (confirmation == 0) {
                        System.out.println("Operation canceled!");
                    } else {
                        employeeManager.removeEmployee(idIndex);
                        System.out.println("Employee succesfully deleted!");
                    }
                    break;


                case 5:
                    System.out.print("Digit the employee ID you want to calculate the payment: ");
                    pickId = sc.nextInt();
                    idIndex = employeeManager.verifyId(pickId);
                    while (idIndex == -1) {
                        System.out.print("This ID does not exist, digit a valid one: ");
                        pickId = sc.nextInt();
                        idIndex = employeeManager.verifyId(pickId);
                    }
                    System.out.println(employeeManager.getEmployeeList().get(idIndex).paymentForEmployee());

                    break;


                case 6:
                    System.out.println(employeeManager.payRollList());
                    break;

                case 0:
                    System.out.println("Operations finished!");
                    break;

                default:
                    System.out.println("Invalid operation!");
                    break;
            }

        }
        while (operation != 0);
        sc.close();
    }

    private static boolean verifyResponse(int confirmation) {
        if (confirmation == 0 || confirmation == 1) {
            return true;
        }
        return false;
    }

    private static boolean validValue(double value) {
        if (value <= 0.0) {
            return false;
        }
        return true;
    }

    private static boolean validName(String name) {
        if (name.isBlank()) {
            return false;
        }
        return true;
    }

    private static boolean verifyDepartment(Integer department) {
        if (department == null) {
            return false;
        }
        if (department == 1 || department == 2 || department == 3) {
            return true;
        }
        return false;
    }

    private static boolean verifyChange(int informationToChange) {
        if (informationToChange == 1 || informationToChange == 2 || informationToChange == 3 || informationToChange == 4) {
            return true;
        }
        return false;
    }

    private static boolean verifyChangeWithoutLevels(int informationToChange) {
        if (informationToChange == 1 || informationToChange == 2 || informationToChange == 3) {
            return true;
        }
        return false;
    }
}
