package application;

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
            System.out.println("Type:");
            System.out.println("| 1- Register a new employee | 2- Calculate month payment for a employee | 3- Check total payroll |");
            System.out.println("| 4-List all employees | 5-Remove a employee | 6- Change a employee information |");
            System.out.println("| 0- finish operations|");
            operation = sc.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("Employee data:");

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    Integer verifyId = employeeManager.verifyId(id);
                    while (verifyId != null) {
                        System.out.print("This ID is not valid choose a new ID: ");
                        id = sc.nextInt();
                        verifyId = employeeManager.verifyId(id);
                    }

                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    while (!EmployeeManager.validName(name)) {
                        System.out.print("Type a valid name: ");
                        name = sc.nextLine();
                    }

                    System.out.print("Base salary: ");
                    double baseSalary = sc.nextDouble();
                    while (!EmployeeManager.validValue(baseSalary)) {
                        System.out.print("Type a value greater than 0: ");
                        baseSalary = sc.nextDouble();
                    }
                    System.out.print("Department-(Digit: 1- for Sales, 2- for Developing, 3- for Human Resources): ");
                    Integer department = null;
                    while (!EmployeeManager.verifyDepartment(department)) {
                        department = sc.nextInt();
                        switch (department) {
                            case 1:
                                System.out.print("Value sold in this month: ");
                                double monthSales = sc.nextDouble();
                                while (!EmployeeManager.validValue(monthSales)) {
                                    System.out.print("Type a value greater than 0: ");
                                    monthSales = sc.nextDouble();
                                }
                                System.out.print("Level of seller employee (Digit: 1- for Trainee, 2- for Associate, 3- for Executive): ");
                                Integer level = null;
                                while (!SalesEmployee.verifyLevel(level)) {
                                    level = sc.nextInt();
                                    switch (level) {
                                        case 1:
                                            employeeManager.addEmploye(new SalesTrainee(id, name, baseSalary, monthSales));
                                            break;
                                        case 2:
                                            employeeManager.addEmploye(new SalesAssociate(id, name, baseSalary, monthSales));
                                            break;
                                        case 3:
                                            employeeManager.addEmploye(new SalesExecutive(id, name, baseSalary, monthSales));
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
                                while (!EmployeeManager.validValue(projectsMade)) {
                                    System.out.print("Type a value greater than 0: ");
                                    projectsMade = sc.nextInt();
                                }
                                System.out.print("Level of developer employee (Digit: 1- for Trainee, 2- for Junior, 3- for Mid level, 4- for Senior): ");
                                level = null;
                                while (!DevEmployee.verifyLevel(level)) {
                                    level = sc.nextInt();
                                    switch (level) {
                                        case 1:
                                            employeeManager.addEmploye(new DevTrainee(id, name, baseSalary, projectsMade));
                                            break;
                                        case 2:
                                            employeeManager.addEmploye(new DevJunior(id, name, baseSalary, projectsMade));
                                            break;
                                        case 3:
                                            employeeManager.addEmploye(new DevMidLevel(id, name, baseSalary, projectsMade));
                                            break;
                                        case 4:
                                            employeeManager.addEmploye(new DevSenior(id, name, baseSalary, projectsMade));
                                            break;
                                        default:
                                            System.out.println("Invalid level number.");
                                            System.out.print("(Digit: 1- for Trainee, 2- for Junior, 3- for Mid level, 4- for Senior): ");
                                            break;
                                    }
                                }


                                break;
                            case 3:
                                employeeManager.addEmploye(new HrEmployee(id, name, baseSalary));
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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    break;
                default:
                    break;
            }

        }
        while (operation != 0);


        sc.close();
    }
}
