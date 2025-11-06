package application;

import entities.EmployeeManager;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        EmployeeManager employeeManager = new EmployeeManager();
        Integer operation = null;
        System.out.println("Welcome to the Employee Management!");
        do{
            System.out.println("\nWhat's the operation you want to make it?");
            System.out.println("Type:");
            System.out.println("| 1- Register a new employee | 2- Calculate month payment for a employee | 3- Check total payroll |");
            System.out.println("| 4-List all employees | 5-Remove a employee | 6- Change a employee information |");
            System.out.println("| 0- finish operations|");
            operation = sc.nextInt();
            switch (operation){
                case 1 :
                    break;
                case 2 :
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
