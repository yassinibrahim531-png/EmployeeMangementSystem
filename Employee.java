/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employeemanagementsystem;

/**
 *
 * @author Lenovo
 */
public abstract class Employee{

    private int employeeId;
    private String fullName;
    private Department department;
    private int age;
    private String position;

    public Employee(int employeeId, String fullName, Department department, int age, String position) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.department = department;
        this.age = age;
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
    public abstract double calculateMonthlySalary();

    public abstract String getEmployeeType();
    
    
    
 
    
}
