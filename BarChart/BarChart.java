// Program: Bar Chart
// Author: Alex Miller
// Date of Creation: 10/8/2018
// Modification Date: 10/8/2018
// Purpose: Allows user to enter sales amounts of five stores and then displays the stores with their amounts in a visual manner beside the store number
// Input: Sales of five stores
// Calculations: $100 = 1 asterisk
// Outputs: Amount of asterisks equal to how many hundreds of dollars in sales there was

//Get file classes needed for input
import java.util.Scanner;


public class BarChart
{
   //begin BarChart
   public static void main(String[] args)
   {
      //Creates keyboard read object
      Scanner keyboard = new Scanner(System.in);
      
      final int stores = 5; //amount of stores
      final int asterisk = 100; //An asterisk is $100 in sales
      int whichStore; //which numbered store
      int asteriskNumber; //number of asterisks to be outputted
      double sales = 0; //Sales for a store
      String message = ("\n\n\n\n"); //String for output message
      
      //Separation between environment andtitle
      System.out.println();
      
      //title
      System.out.println("         Bar Chart");
      
      //lines for title
      System.out.println("         ---------");
      
      //separation between title and output
      System.out.println();
      
      //begin for loop
      for (whichStore = 1; whichStore <= stores; whichStore++)
      {
         //Output message for store's sales
         System.out.print("Enter sales amount for store " + whichStore + ": ");
         
         //input sales for stores
         sales = keyboard.nextDouble();
         
         //separation between output and the next output
         System.out.println();
         
         //calculation number of asterisks needed (sales / asterisks)
         asteriskNumber = (int)(sales / asterisk);
         
         //output store number to message
         message = message + "Store " + whichStore + ": ";
         
         //begin for loop for amount of asterisks
         for (int i = 1; i <= asteriskNumber; i++)
         {
            //Add asterisks for each $100 of sales
            message = message + "*";
            
            //end for loop
         }
         
         //output separation
         message = message + "\n\n";
         
      }
      //end for loop
      
      //output Sales Bar message and asterisks
      System.out.println(message);
      
      //separation of outpur from environment
      System.out.println();
      
   }
   
   //end BarChart
}
