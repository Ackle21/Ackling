// Program: SoftwareSales
// Author: Alex Miller
// Date of Creation: 9/24/2018
// Modification Date: 9/24/2018
// Purpose: Allow the user to input the amount of packages they want and tell them the discount they earn and the total of the order
// Input: Number of packages
// Calculations: (Number of packages) * (discount earned in decimal form) = Total of order
// Outputs: Packages bought, Discount earned, and the Total of the order



//Get file classes needed for input
import java.util.Scanner;


public class SoftwareSales
{

   //Start        SoftwareSales
   public static void main (String[] args)
   {
      //Creates keyboard read object
      Scanner keyboard = new Scanner(System.in);
      
      //Creates the values
      double packages;
      double discount;
      double total;
      
      //Output       Separation between environment and Title
      System.out.println();
   
      //Output       Title
      System.out.println("Software Sales");
   
      //Output       Dashed Lines 
      System.out.println("--------------");
   
      //Output       Separation between Dashed Lines and Output
      System.out.println();
   
      //Output       User message for input 1
      System.out.println("Amount of packages bought(0 - 1000): ");
      
      //Input        Get number1
      packages = keyboard.nextDouble();
      
      //if           #1 >= 100
      if (packages >= 100)
      {
         //     then         discount = .50
         discount = .5;
      }
      
      //if else      #1 >= 50 
      else if (packages >= 50)
      {
         //     then         discount = .40
         discount = .4;
      }
      
      //if else      #1 >= 20 
      else if (packages >= 20)
      {
         //     then         discount = .30
         discount = .3;
      }
      
      //if else      #1 >= 10 
      else if (packages >= 10)
      {
         //     then         discount = .20
         discount = .2;
      }
      
      //else
      else 
      {
         //discount = 0
         discount = 0;
      }
      
      //if discount = 0;
      if (discount == 0)
      {
         //then Calculations (#1 * 99) = Total
         total = (packages * 99);
      }
      
      //else
      else 
      {
         //Calculations (#1 * 99) * discount = Total
         total = (packages * 99) * discount;
      }
      
      //Output       Separation between input and title
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      
      //Output       Title
      System.out.println("Software Sales");
      
      //Output       Dashed Lines
      System.out.println("--------------");
      
      //Output       Separation between dashed lines and output
      System.out.println();
      
      //Output       Text for Number 1 + number1
      System.out.println("Number of packages bought: " + packages);
      
      //Output       Text for Discount + discount
      System.out.println("Your earned discount: %" + (discount * 100) );
      
      //Output       Separation between Output and Output
      System.out.println();
      
      //Output       Text for Total + amountTotal
      System.out.println();
      System.out.printf("Total: %.2f", total);
      
      //Output       Separation between Output and environment
      System.out.println();
   }
   
//End          SoftwareSales

}