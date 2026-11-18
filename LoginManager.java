/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;

/**
 *
 * @author Lenovo
 */
public class LoginManager {
    
    private final String username="admin";
    private final String password="admin123";

    public boolean login(String enteredUsername,String enteredPassword)
    {

        if (enteredUsername==null||enteredUsername.isEmpty())
        {
            System.out.println("Username cannot be empty.");
            return false;
        }

        if (enteredPassword==null||enteredPassword.isEmpty())
        {
            System.out.println("Password cannot be empty.");
            return false;
        }

        if (username.equals(enteredUsername)&& password.equals(enteredPassword))
        {

            System.out.println("Login successful!");
            return true;

        } else
        {
            System.out.println("Invalid username or password.");
            return false;
        }
    }
}
