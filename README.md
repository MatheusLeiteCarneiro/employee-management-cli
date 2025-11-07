# Employee Management CLI 💼

**Description:** `A Java command-line application demonstrating advanced OOP (Polymorphism, Inheritance) to manage a company's payroll.`

This project is a complete employee management system built in Java. It was developed to practice and implement advanced Object-Oriented Programming concepts, focusing primarily on **Polymorphism**, **Inheritance** and **Abstraction**.

The application provides a full CRUD (Create, Read, Update, Delete) interface to manage employees across different departments (Sales, Development, HR) and calculates their specific salaries and the total company payroll.

---

## ✨ Features

* **Employee Registration:** Registers new employees, asking for specific data based on their department.
* **List All Employees:** Displays a clean list of all registered employees, showing their ID, Name, Department, and Level.
* **Change Employee Information:** Allows full updates for any employee, including name, base salary, and a complex logic to change an employee's department and level.
* **Remove Employee:** Securely removes an employee from the system by their ID, with a confirmation step.
* **Calculate Individual Payment:** Calculates the total monthly payment for a single employee, using polymorphism to apply the correct rules based on their role and level.
* **Check Total Payroll:** Calculates the total cost of the company's payroll, using polymorphism to sum each employee's unique payment.
* **Robust Input Handling:** Includes input validation for all user entries and prevent operations on an empty employee list.
---

## 🛠️ Technologies Used

* **Java 25**
* **IntelliJ IDEA**
* **Java Collections** (`ArrayList`, `List`)
* **Java Stream API** (`Comparator.comparing`)
* **Git & GitHub** for version control.

---

## 🚀 What I Learned (Concepts Practiced)

This was a complex project that solidified important concepts of (OOP):

* **Polymorphism:**
  * All the objects are managed in a single list of employees. The `employeeManager` class calculates the payroll by using **polymorphism** to call the `totalPayment()` for each object and sum them.
  
* **Inheritance & Abstraction:**
  * There are a multi-level class hierarchy to maintain a pattern and to reuse the code.
  The abstract class `Employee` is a base for all the other classes, that includes *ID*, *Name* and *Base salary*, and this class also have `totalPayment()` abstract method that forces all the concrete classes to create their own method.
 
* **Encapsulation:**
  * All class attributes are set `private` to protect the object ensuring that the logic is only managed by the entity that it owns it.
  
* **Professional Git Workflow:**
  * Maintained a clean repository with `.gitignore`.
  * Documented the entire development process, from initial design to final refactoring, with a detailed history of commits.
  
---

## 🏁 How to Run
1.  Open your **Terminal** (or `Git Bash` on Windows).
2.  Navigate to the directory (folder) where you want to save the project.
3.  **Copy and paste** the following command into your terminal and press **Enter**:

    ```bash
    git clone https://github.com/MatheusLeiteCarneiro/employee-management-cli.git
    ```
    *(This will create a new folder named `employee-management-cli` with all the project files.)*

4. Open the project in your Java IDE.
5. Locate and run the `Program.java` file (under `src/application/Program.java`).

---

Author: **Matheus Leite Carneiro**