// Program: Password Verifier
// Author: Alex Miller
// Date Created: 2/6/19
// Date Modified: 2/6/19
// Purpose:
// Input: 
// Output: 
// Calculations: 

// Imports the java Scanner
import java.util.Scanner;

public class PasswordVerifier
{
   public static void main(String[] args)
   {
      String input;
      Verifier verify = new Verifier();
      int isVerified = 0;
      
      //Allows use of keyboard
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println();
      System.out.println();
      
      System.out.println("Password Verifier");
      System.out.println("-----------------");
      
      System.out.println();
      System.out.println();
      
      System.out.println();
      System.out.print("Password: ");
      input = keyboard.nextLine();
      while (isVerified == 0)
      {
         //verify.passcodeVerify(password);
         
         if(!verify.isValid(input))
         {
            System.out.println();
            System.out.println();
            System.out.println("This password does not meet the criteria");
            System.out.println("Your password should: ");
            System.out.println("* Be at least 6 characters long");
            System.out.println("* Contain at least one uppercase letter");
            System.out.println("* Contain at least one lowercase letter");
            System.out.println("* Contain at least one digit");
            System.out.println();
            System.out.print("Password: ");
            input = keyboard.nextLine();
         }
         else
         {
            System.out.println();
            System.out.println("Your password meets the criteria");
            isVerified = 1;
            
         }
      }
   }
}