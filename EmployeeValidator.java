/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employeemanagementsystem;

/**
 *
 * @author Kenzy Hassanen
 */
public class EmployeeValidator {

     public boolean isNotEmpty(String value)
     {
         return value!= null && !value.trim().isEmpty();
     }
     
   public boolean isValidInteger(String value)
{
    if(!isNotEmpty(value))
        return false;

    value = value.trim();

    try
    {
        Integer.parseInt(value);
        return true;
    }
    catch(NumberFormatException e)
    {
        return false;
    }
}
    
    public boolean isValidAge(String age)
    {
        if(!isValidInteger(age))
            return false;
        
        age=age.trim();
        return Integer.parseInt(age) > 0;
    }
    
    public boolean isValidSalary(String value)
    {
        if(!isNotEmpty(value))
            return false;
        
        value = value.trim();
        boolean hasDecimalPoint = false;
        for(int i=0;i<value.length();i++)
        {
            if(value.charAt(i)=='.')
            {
                if(hasDecimalPoint)
                    return false;
                
                if(i == 0 || i == value.length() - 1)
                 return false;
             
                
                hasDecimalPoint=true;
            }
            
            if((value.charAt(i) < '0' || value.charAt(i) > '9') && (value.charAt(i)!= '.'))
                return false;
        }
        double salary = Double.parseDouble(value);
        return Double.isFinite(salary) && salary >= 0;
    }
    
    public boolean isValidEmployeeType(String type)
    {
        if(!isNotEmpty(type))
            return false;
        
        type=type.trim();
        return type.equalsIgnoreCase("Full-Time") || type.equalsIgnoreCase("Part-Time");
    }
    
    
}
