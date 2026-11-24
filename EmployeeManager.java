/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kenzy Hassanen
 */
public class EmployeeManager {
  private List<Employee> employees; 
  
  public EmployeeManager()
{
    employees = new ArrayList<>();
}
  
  public boolean addEmployee(Employee employee)
{
    if(employee == null)
        return false;

    for(Employee existingEmployee : employees)
    {
        if(existingEmployee.getEmployeeId() == employee.getEmployeeId())
            return false;
    }

    employees.add(employee);
    return true;
}
  public List<Employee> getAllEmployees()
{
    return employees;
}
  
  public boolean updateEmployee(int employeeId, Employee updatedEmployee)
{
    if(updatedEmployee == null)
        return false;

    if(updatedEmployee.getEmployeeId() != employeeId)
        return false;

    for(int i = 0; i < employees.size(); i++)
    {
        if(employees.get(i).getEmployeeId() == employeeId)
        {
            employees.set(i, updatedEmployee);
            return true;
        }
    }

    return false;
}
  
  public boolean deleteEmployee(int employeeId)
{
    for(int i = 0; i < employees.size(); i++)
    {
        if(employees.get(i).getEmployeeId() == employeeId)
        {
            employees.remove(i);
            return true;
        }
    }

    return false;
}
  
  public Employee searchEmployeeById(int employeeId)
{
    for(Employee employee : employees)
    {
        if(employee.getEmployeeId() == employeeId)
            return employee;
    }

    return null;
}
  
  public List<Employee> searchEmployeesByDepartment(String departmentName)
{
    List<Employee> result = new ArrayList<>();
    
    if(departmentName == null || departmentName.trim().isEmpty())
      return result;

    for(Employee employee : employees)
    {
        if(employee.getDepartment() != null &&
           employee.getDepartment().getDepartmentName().equalsIgnoreCase(departmentName))
        {
            result.add(employee);
        }
    }

    return result;
}
  
}