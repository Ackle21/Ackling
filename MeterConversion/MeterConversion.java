// Program: MeterConversion
// Author: Alex Miller
// Date Created: 1/31/19
// Date Modified: 1/31/19
// Purpose: allows user to input a number in meters and then choose how it is converted to another distance measure
// Input: Meters
// Output: Kilometers, inches, or feet
// Calculations: meters to kilometers, meters to inches, meters to feet.

// Imports the java Scanner
import java.util.Scanner;

public class MeterConversion
{
   public static void main(String[] args)
   {
      double distance = 0;
      int choices = 0;
      int checking = 0;
      
      //Allows use of keyboard
      Scanner keyboard = new Scanner(System.in);
      
      //separate environment from output
      System.out.println();
      System.out.println();
      
      System.out.println("Meter Conversion");
      System.out.println("----------------");
      
      System.out.println();
      System.out.println();
      
      while (choices != 4)
      {
      
         System.out.println();
         System.out.println();
         
         System.out.print("Distance in distance: ");
         distance = keyboard.nextDouble();
         
         System.out.println();
         System.out.println();
         
         while (checking == 0)
         {
            Menu();
            choices = keyboard.nextInt();
            
            if(choices > 4 || choices < 1)
            {
               System.out.println();
               System.out.println();
               System.out.println("Your input wasn't a choice, try again");
               System.out.println("Your choices are numbers 1 - 4");
               
            }
            else
            checking = 1; 
         }
         
         if (choices == 1)
         {
            showKilometers(distance);
         }
         else if (choices == 2)
         {
            showInches(distance);
         }
         else if (choices == 3)
         {
            showFeet(distance);
         }
         else if (choices == 4)
         {
            quit(distance);
         }
         
         System.out.println();
      }
   }
   
   public static void Menu()
   {
      System.out.println("How would you like to convert that? (Type corresponding number 1 - 4)");
      System.out.println("1. Convert to Kilometers");
      System.out.println("2. Convert to Inches");
      System.out.println("3. Convert to Feet");
      System.out.println("4. Quit the Program");
      System.out.print("What's your choice?: ");
   }
   
   public static void showKilometers(double distance)
   {
      
      distance = (distance * .001);
      System.out.println(distance);
   }
   
   public static void showInches(double distance)
   {
      
      distance = (distance * 39.37);
      System.out.println(distance);
   }
   
   public static void showFeet(double distance)
   {
      
      distance = (distance * 3.281);
      System.out.println(distance);
   }
   public static void quit(double distance)
   {
      System.out.println();
      System.out.println("Goodbye");
   }
   
}

