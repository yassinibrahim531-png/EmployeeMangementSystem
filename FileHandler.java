/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.List;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Kenzy Hassanen
 */
public class FileHandler {
    
    public void saveEmployees(List<Employee> employees) throws IOException
{
  FileOutputStream file = new FileOutputStream("employees.dat");
  ObjectOutputStream output = new ObjectOutputStream(file);
  output.writeObject(employees);
  output.close();
}
    
   public void saveDepartments(List<Department> departments) throws IOException
{
    FileOutputStream file = new FileOutputStream("departments.dat");
    ObjectOutputStream output = new ObjectOutputStream(file);

    output.writeObject(departments);

    output.close();
}
   
    public List<Employee> loadEmployees() throws IOException, ClassNotFoundException
{
   
  List <Employee> employees = new ArrayList<>(); 
   File file=new File("employees.dat");
    if(!file.exists())
        return employees;
    
  FileInputStream inputfile = new FileInputStream(file);
  ObjectInputStream input = new ObjectInputStream(inputfile);
  Object object = input.readObject();
  employees = (List<Employee>) object;
  input.close();
  return employees;
}
    
    public List<Department> loadDepartments() throws IOException, ClassNotFoundException
{
    List<Department> departments = new ArrayList<>();

    File file = new File("departments.dat");

    if (!file.exists())
        return departments;

    FileInputStream inputFile = new FileInputStream(file);
    ObjectInputStream input = new ObjectInputStream(inputFile);

    Object object = input.readObject();
    departments = (List<Department>) object;

    input.close();

    return departments;
}
    
}
