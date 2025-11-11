package application;

import entities.Employee;
import entities.EmployeeManager;
import entities.HrEmployee;
import entities.dev.*;
import entities.sales.*;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        EmployeeManager employeeManager = new EmployeeManager();
        int pickId = 0;
        int idIndex = 0;
        Integer operation = null;
        System.out.println("Welcome to the Employee Management!");
        do {
            System.out.println("\nWhat's the operation you want to make it?");
            System.out.println("Digit:");
            System.out.println("| 1- Register a new employee | 2- List all employees | 3- Change an employee information |");
            System.out.println("| 4- Delete an employee | 5- Calculate month payment for an employee | 6- Check total payroll |");
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
                    String name = validName(sc, sc.nextLine());

                    System.out.print("Base salary: ");
                    double baseSalary = positiveDouble(sc, sc.nextDouble());

                    String department = setDepartment(sc);
                    String departmentLevel = setDepartmentLevel(sc, department);
                    Employee newEmployee = newEmployee(sc, id, name, baseSalary, department, departmentLevel);
                    employeeManager.addEmployee(newEmployee);
                    System.out.println("Employee successfully registered!");
                    break;


                case 2:
                    if (!employeeManager.verifyIfHaveEmployee()) {
                        System.out.println("Operation canceled: There are no registered employees.");
                        System.out.println("Please register an employee first (Option 1).");
                        break;
                    }
                    System.out.print(employeeManager.listAllEmployees());

                    break;


                case 3:

                    if (!employeeManager.verifyIfHaveEmployee()) {
                        System.out.println("Operation canceled: There are no registered employees.");
                        System.out.println("Please register an employee first (Option 1).");
                        break;
                    }
                    System.out.print("Digit the employee ID you want to change the information: ");
                    pickId = sc.nextInt();
                    idIndex = employeeManager.verifyId(pickId);
                    while (idIndex == -1) {
                        System.out.print("This ID does not exist, digit a valid one: ");
                        pickId = sc.nextInt();
                        idIndex = employeeManager.verifyId(pickId);
                    }
                    Employee employee = employeeManager.getEmployeeList().get(idIndex);
                    Employee changedEmployee = changeEmployeeInfo(sc, employee);
                    employeeManager.removeEmployee(idIndex);
                    employeeManager.addEmployee(changedEmployee);
                    System.out.println("Changes saved!");
                    break;


                case 4:
                    if (!employeeManager.verifyIfHaveEmployee()) {
                        System.out.println("Operation canceled: There are no registered employees.");
                        System.out.println("Please register an employee first (Option 1).");
                        break;
                    }
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
                    int confirmation = verifyConfirmation(sc, sc.nextInt());
                    if (confirmation == 0) {
                        System.out.println("Operation canceled!");
                    } else {
                        employeeManager.removeEmployee(idIndex);
                        System.out.println("Employee successfully deleted!");
                    }
                    break;


                case 5:
                    if (!employeeManager.verifyIfHaveEmployee()) {
                        System.out.println("Operation canceled: There are no registered employees.");
                        System.out.println("Please register an employee first (Option 1).");
                        break;
                    }
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
                    if (!employeeManager.verifyIfHaveEmployee()) {
                        System.out.println("Operation canceled: There are no registered employees.");
                        System.out.println("Please register an employee first (Option 1).");
                        break;
                    }
                    System.out.println(employeeManager.payRollList());
                    break;

                case 0:
                    System.out.println("Operations finished!");
                    break;

                default:
                    System.out.println("Invalid operation!");
                    break;
            }

        } while (operation != 0);
        sc.close();
    }

    private static int verifyConfirmation(Scanner sc, int confirmation) {
        while (confirmation != 0 && confirmation != 1) {
            System.out.print("Invalid response, digit: (1-to confirm | 0-to cancel): ");
            confirmation = sc.nextInt();
        }
        return confirmation;
    }

    private static double positiveDouble(Scanner sc, double value) {
        while (value <= 0.0) {
            System.out.print("Type a value greater than 0: ");
            value = sc.nextDouble();
        }
        return value;
    }

    private static int positiveInt(Scanner sc, int value) {
        while (value < 0) {
            System.out.print("Type a positive value: ");
            value = sc.nextInt();
        }
        return value;
    }

    private static String validName(Scanner sc, String name) {
        while (name.isBlank()) {
            System.out.print("Type a valid name: ");
            name = sc.nextLine();
        }
        return name;
    }


    private static String setDepartment(Scanner sc) {
        String departmentName;
        while (true) {
            System.out.print("Department-(Digit: 1- for Sales, 2- for Developing, 3- for Human Resources): ");
            int departmentNumber = sc.nextInt();
            if (departmentNumber == 1) {
                departmentName = "Sales";
                break;
            } else if (departmentNumber == 2) {
                departmentName = "Dev";
                break;

            } else if (departmentNumber == 3) {
                departmentName = "Human Resources";
                break;
            } else {
                System.out.println("Invalid department number.");
            }
        }
        return departmentName;

    }

    private static String setDepartmentLevel(Scanner sc, String department) {
        String levelName = null;
        int levelNumber = 0;
        boolean validLevel = false;

        switch (department) {
            case "Human resources":
                break;
            case "Sales":
                while (!validLevel) {
                    System.out.print("Level of seller employee (Digit: 1- for Trainee, 2- for Associate, 3- for Executive): ");
                    levelNumber = sc.nextInt();
                    switch (levelNumber) {
                        case 1:
                            levelName = "Trainee";
                            validLevel = true;
                            break;
                        case 2:
                            levelName = "Associate";
                            validLevel = true;
                            break;
                        case 3:
                            levelName = "Executive";
                            validLevel = true;
                            break;
                        default:
                            System.out.println("Invalid level number.");
                    }

                }
                break;
            case "Dev":
                while (!validLevel) {
                    System.out.print("(Digit: 1- for Trainee, 2- for Junior, 3- for Mid level, 4- for Senior): ");
                    levelNumber = sc.nextInt();
                    switch (levelNumber) {
                        case 1:
                            levelName = "Trainee";
                            validLevel = true;
                            break;
                        case 2:
                            levelName = "Junior";
                            validLevel = true;
                            break;
                        case 3:
                            levelName = "MidLevel";
                            validLevel = true;
                            break;
                        case 4:
                            levelName = "Senior";
                            validLevel = true;
                            break;
                        default:
                            System.out.println("Invalid level number.");
                    }

                }
                break;
        }


        return levelName;

    }

    private static Employee newEmployee(Scanner sc, int id, String name, double baseSalary, String department, String departmentLevel) {
        switch (department) {
            case "Human Resources":
                return new HrEmployee(id, name, baseSalary);
            case "Sales":
                System.out.print("Value sold in this month: ");
                double valueSold = positiveDouble(sc, sc.nextDouble());
                switch (departmentLevel) {
                    case "Trainee":
                        return new SalesTrainee(id, name, baseSalary, valueSold);
                    case "Associate":
                        return new SalesAssociate(id, name, baseSalary, valueSold);
                    case "Executive":
                        return new SalesExecutive(id, name, baseSalary, valueSold);

                }
                break;
            case "Dev":
                System.out.print("Projects made this month: ");
                int projectsMade = positiveInt(sc, sc.nextInt());
                switch (departmentLevel) {
                    case "Trainee":
                        return new DevTrainee(id, name, baseSalary, projectsMade);
                    case "Junior":
                        return new DevJunior(id, name, baseSalary, projectsMade);
                    case "MidLevel":
                        return new DevMidLevel(id, name, baseSalary, projectsMade);
                    case "Senior":
                        return new DevSenior(id, name, baseSalary, projectsMade);

                }
                break;
        }
        return null;
    }

    private static Employee changeEmployeeInfo(Scanner sc, Employee oldEmployee) {
        System.out.println("You chose the employee: " + oldEmployee.employeeRegisterWithBaseSalary());
        System.out.println("What's the information you want to change?");

        while (true) {
            if (oldEmployee instanceof HrEmployee) {
                System.out.print("Digit:(1-Name | 2- Base salary | 3- Department/Level): ");
            }
            if (oldEmployee instanceof SalesEmployee) {
                System.out.print("Digit:(1-Name | 2- Base salary | 3- Department/Level | 4- Value sold): ");
            }
            if (oldEmployee instanceof DevEmployee) {
                System.out.print("Digit:(1-Name | 2- Base salary | 3- Department/Level | 4- Projects made): ");
            }
            int operation = sc.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("The actual name is: " + oldEmployee.getName());
                    System.out.print("New name: ");
                    sc.nextLine();
                    String name = validName(sc, sc.nextLine());
                    oldEmployee.setName(name);
                    return oldEmployee;
                case 2:
                    System.out.println("The actual base salary is: $" + String.format("%.2f", oldEmployee.getBaseSalary()));
                    System.out.print("New base salary: ");
                    double baseSalary = positiveDouble(sc, sc.nextDouble());
                    oldEmployee.setBaseSalary(baseSalary);
                    return oldEmployee;

                case 3:
                    System.out.println("Old department and level: " + oldEmployee.deparmentAndLevel());
                    String department = setDepartment(sc);
                    String departmentLevel = setDepartmentLevel(sc, department);
                    return newEmployee(sc, oldEmployee.getId(), oldEmployee.getName(), oldEmployee.getBaseSalary(), department, departmentLevel);


                case 4:
                    if (oldEmployee instanceof SalesEmployee) {
                        System.out.println("Actual value sold: $" + String.format("%.2f", ((SalesEmployee) oldEmployee).getMonthSales()));
                        System.out.print("New value sold: ");
                        double valueSold = positiveDouble(sc, sc.nextDouble());
                        ((SalesEmployee) oldEmployee).setMonthSales(valueSold);
                        return oldEmployee;
                    }
                    if (oldEmployee instanceof DevEmployee) {
                        System.out.println("Actual amount of projects made: " + ((DevEmployee) oldEmployee).getProjectsMade());
                        System.out.print("New amount: ");
                        int projectsMade = positiveInt(sc, sc.nextInt());
                        ((DevEmployee) oldEmployee).setProjectsMade(projectsMade);
                        return oldEmployee;
                    }
                default:
                    System.out.println("Invalid operation!");

            }
        }


    }

}
