/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;
import java.io.Serializable;
/**
 *
 * @author Lenovo
 */
public class FullTimeEmployee extends Employee{
    
    private double basicMonthlySalary;
    private double monthlyBonus;

    public FullTimeEmployee(double basicMonthlySalary, double monthlyBonus, int employeeId, String fullName, Department department, int age, String position) {
        super(employeeId, fullName, department, age, position);
        this.basicMonthlySalary = basicMonthlySalary;
        this.monthlyBonus = monthlyBonus;
    }

    public double getBasicMonthlySalary() {
        return basicMonthlySalary;
    }

    public double getMonthlyBonus() {
        return monthlyBonus;
    }

    public void setBasicMonthlySalary(double basicMonthlySalary) {
        this.basicMonthlySalary = basicMonthlySalary;
    }

    public void setMonthlyBonus(double monthlyBonus) {
        this.monthlyBonus = monthlyBonus;
    }
    
    
    @Override
    public double calculateMonthlySalary() {
        return basicMonthlySalary+monthlyBonus;
    }
        
    @Override
    public String getEmployeeType()
    {
        return "Full-Time";
    }
}