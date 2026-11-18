/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class DepartmentManager {
   
        private ArrayList<Department> departments;

    public DepartmentManager(ArrayList<Department> departments) {
        departments = new ArrayList<>();
    }
        
    public boolean addDepartment(Department department) {

        if (department == null) {
            System.out.println("Department cannot be null.");
            return false;
        }

        if (department.getDepartmentId()<=0) {
            System.out.println("Invalid Department ID.");
            return false;
        }

        if (department.getDepartmentName()==null||department.getDepartmentName().isEmpty()) {
            System.out.println("Department name cannot be empty.");
            return false;
        }

        if (findDepartmentById(department.getDepartmentId()) != null) {
            System.out.println("Department ID already exists.");
            return false;
        }

        for (Department d : departments) {

            if (d.getDepartmentName().equalsIgnoreCase(department.getDepartmentName()))
            {
                System.out.println("Department name already exists.");
                return false;
            }
        }

        departments.add(department);

        System.out.println("Department added successfully.");
        return true;
    }
    
    public Department findDepartmentById(int departmentId) {

        for (Department department : departments) {

            if (department.getDepartmentId()==departmentId)
            {
                return department;
            }
        }

        return null;
    }

    public boolean updateDepartment(int departmentId, String newName) {

        Department department=findDepartmentById(departmentId);

        if (department==null) {
            System.out.println("Department not found.");
            return false;
        }

        if (newName==null||newName.isEmpty())
        {
            System.out.println("Department name cannot be empty.");
            return false;
        }

        for (Department d : departments) {

            if (d.getDepartmentId()!=departmentId&&d.getDepartmentName().equalsIgnoreCase(newName)) {

                System.out.println("Department name already exists.");
                return false;
            }
        }

        department.setDepartmentName(newName);

        System.out.println("Department updated successfully.");
        return true;
    }
    
    public boolean removeDepartment(int departmentId) {

        Department department=findDepartmentById(departmentId);

        if (department==null)
        {
            System.out.println("Department not found.");
            return false;
        }

        departments.remove(department);

        System.out.println("Department removed successfully.");
        return true;
    }

    public void displayAllDepartments() {

        if (departments.isEmpty())
        {
            System.out.println("No departments available.");
            return;
        }

        for (Department department:departments) {

            System.out.println("ID: " + department.getDepartmentId());
            System.out.println("Name: " + department.getDepartmentName());

        }
    }

    public ArrayList<Department> getDepartments() {
        return new ArrayList<>(departments);
    }

    public boolean assignEmployeeToDepartment(Employee employee, int departmentId)
    {
        if (employee==null)
        {
            System.out.println("Employee cannot be null.");
            return false;
        }

        Department department=findDepartmentById(departmentId);

        if (department==null)
        {
            System.out.println("Department not found.");
            return false;
        }
        employee.setDepartment(department);
        System.out.println("Employee assigned successfully.");
        return true;
    }
    
}


    
        

        
