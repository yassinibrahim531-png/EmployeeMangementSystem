/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kenzy Hassanen
 */
public class FileHandler {

    public void saveEmployees(List<Employee> employees) throws FileNotFoundException {
        File file = new File("employees.txt");
        PrintWriter pw = new PrintWriter(file);

        for (Employee employee : employees) {
            int id = employee.getEmployeeId();
            String name = employee.getFullName();
            int departmentId = employee.getDepartment().getDepartmentId();
            int age = employee.getAge();
            String position = employee.getPosition();
            String type = employee.getEmployeeType();

            if (employee instanceof FullTimeEmployee) {
                FullTimeEmployee fullTime = (FullTimeEmployee) employee;
                double basicSalary = fullTime.getBasicMonthlySalary();
                double bonus = fullTime.getMonthlyBonus();

                pw.println(id + "," + name + "," + departmentId + "," + age + ","
                        + position + "," + type + "," + basicSalary + "," + bonus);
            } else if (employee instanceof PartTimeEmployee) {
                PartTimeEmployee partTime = (PartTimeEmployee) employee;
                double hourlyRate = partTime.getHourlyPaymentRate();
                double hoursWorked = partTime.getHoursWorkedPerMonth();
                pw.println(id + "," + name + "," + departmentId + "," + age + ","
                        + position + "," + type + "," + hourlyRate + "," + hoursWorked);
            }
        }

        pw.close();
    }

    public List<Employee> loadEmployees(DepartmentManager departmentManager) throws FileNotFoundException {
        ArrayList<Employee> employees = new ArrayList<>();
        File file = new File("employees.txt");

        if (!file.exists()) {
            return employees;
        }

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            try {
                String line = sc.nextLine();
                String[] tokens = line.split(",");

                if (tokens.length != 8) {
                    continue;
                }

                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                int departmentId = Integer.parseInt(tokens[2]);
                int age = Integer.parseInt(tokens[3]);
                String position = tokens[4];
                String type = tokens[5];

                Department department = departmentManager.findDepartmentById(departmentId);

                if (department == null) {
                    continue;
                }

                if (type.equals("Full-Time")) {
                    double basicSalary = Double.parseDouble(tokens[6]);
                    double bonus = Double.parseDouble(tokens[7]);

                    FullTimeEmployee fullTime = new FullTimeEmployee(
                            basicSalary, bonus, id, name, department, age, position);

                    employees.add(fullTime);
                } else if (type.equals("Part-Time")) {
                    double hourlyRate = Double.parseDouble(tokens[6]);
                    double hoursWorked = Double.parseDouble(tokens[7]);

                    PartTimeEmployee partTime = new PartTimeEmployee(
                            hourlyRate, hoursWorked, id, name, department, age, position);

                    employees.add(partTime);
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }

        sc.close();
        return employees;
    }

    public void saveDepartments(List<Department> departments) throws FileNotFoundException {
        File file = new File("departments.txt");
        PrintWriter pw = new PrintWriter(file);

        for (Department department : departments) {
            int departmentID = department.getDepartmentId();
            String departmentName = department.getDepartmentName();
            pw.println(departmentID + "," + departmentName);
        }
        pw.close();
    }

    public List<Department> loadDepartments() throws FileNotFoundException {
        ArrayList<Department> departments = new ArrayList<>();
        File file = new File("departments.txt");

        if (!file.exists()) {
            return departments;
        }

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            try {
                String line = sc.nextLine();
                String[] tokens = line.split(",");

                if (tokens.length != 2) {
                    continue;
                }

                int departmentID = Integer.parseInt(tokens[0]);
                String departmentName = tokens[1];

                Department department = new Department(departmentID, departmentName);
                departments.add(department);
            } catch (NumberFormatException e) {
                continue;
            }
        }

        sc.close();
        return departments;
    }
}
