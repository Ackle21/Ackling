// Program: BackwardString
// Author: Alex Miller
// Date Created: 2/6/19
// Date Modified: 2/6/19
// Purpose: Allows user to input string and outputs that string backwards
// Input: User String
// Output: Backwards user string
// Calculations: None

// Imports the java Scanner
import java.util.Scanner;

public class BackwardString
{
   public static void main(String[] args)
   {
      String userString = "";
      
      //Allows use of keyboard
      Scanner keyboard = new Scanner(System.in);
      
      //separate environment from output
      System.out.println();
      System.out.println();
      
      System.out.println("Backward String");
      System.out.println("----------------");
      
      System.out.println();
      System.out.println();
      
      System.out.print("What word would you like to see backwards?:");
      userString = keyboard.nextLine();
      
      Backwards(userString);
   }
   
   public static void Backwards(String userString)
   {  
      System.out.println();
      System.out.print("Your inputted word backwards is:           ");
      
      for (int i = userString.length() - 1; i >= 0; i--)
      {
         System.out.print(userString.charAt(i));
      }
      
      System.out.println();
      System.out.println();
   }
}

