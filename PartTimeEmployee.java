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
public class PartTimeEmployee extends Employee{
    
    private double hourlyPaymentRate;
    private double hoursWorkedPerMonth;

    public PartTimeEmployee(double hourlyPaymentRate, double hoursWorkedPerMonth, int employeeId, String fullName, Department department, int age, String position) {
        super(employeeId, fullName, department, age, position);
        this.hourlyPaymentRate = hourlyPaymentRate;
        this.hoursWorkedPerMonth = hoursWorkedPerMonth;
    }

    public double getHourlyPaymentRate() {
        return hourlyPaymentRate;
    }

    public double getHoursWorkedPerMonth() {
        return hoursWorkedPerMonth;
    }

    public void setHourlyPaymentRate(double hourlyPaymentRate) {
        this.hourlyPaymentRate = hourlyPaymentRate;
    }

    public void setHoursWorkedPerMonth(double hoursWorkedPerMonth) {
        this.hoursWorkedPerMonth = hoursWorkedPerMonth;
    }
    
    @Override
    public double calculateMonthlySalary() {
        return hourlyPaymentRate * hoursWorkedPerMonth;
    }


    @Override
    public String getEmployeeType() {
        return "Part-Time";
    }
    
}