// Program: Largest and Smallest
// Author: Alex Miller
// Date of Creation: 10/8/2018
// Modification Date: 10/8/2018
// Purpose: Allow user to enter numbers until they don't want to, then display the average of those numbers and the smallest and largest from among those numbers
// Input: As many mnumbers as the user wants between 0 and 100
// Calculations: Average of numbers, sum of numbers
// Outputs: Largest number, Average of numbers, Smallest number

//Get file classes needed for input
import java.util.Scanner;


public class LargestAndSmallest
{
   //begin LargestAndSmallest
   public static void main(String[] args)
   {
      //Creates keyboard read object
      Scanner keyboard = new Scanner(System.in);
      
      
      int i = 0; //how many times the user has inputted a number
      double sum = 0; //sum of inputtedNumber
      double inputtedNumber; //stores the number the user inputs
      double average; //average of all inputted numbers
      double largestNumber; //stores largest number of inputted numbers
      double smallestNumber; //stores smallest number of those inputted
      
      //separation of the environment from the title
      System.out.println();
      
      //title
      System.out.println("Largest and Smallest");
      
      //lines to underline title
      System.out.println("--------------------");
      
      //separation between title and output
      System.out.println();
      
      //ouptut messages telling the user the rules
      System.out.println("Please enter in a number between 0 and 100");
      System.out.println("To stop entering numbers, enter -99");
            
      //output user enters first number
      System.out.print("\nEnter number (0 - 100): ");
      
      //input number
      inputtedNumber = keyboard.nextDouble();
      
      //initializes smallest number
      smallestNumber = inputtedNumber;
      
      //initializes largest number
      largestNumber = inputtedNumber;
      
      //loop until sentinel (-99)
      while (inputtedNumber >= -99 && inputtedNumber <= 101)
      {
         
         //if number < smallestNumber
         if (inputtedNumber < smallestNumber)
         {
            //then smallestNumber = number
            smallestNumber = inputtedNumber;
         }
         
         //if number > largestNumber
         if (inputtedNumber > largestNumber)
         {
            //then largestNumber = number
            largestNumber = inputtedNumber;
         }
         
         //increment value for how many times the user has inputted something
         i++;
         
         //calculation adds the number stored within the sum to another number
         sum = sum + inputtedNumber;
         
         //separation from output to output
         System.out.println();
         
         //output another message for the number
         System.out.print("\nEnter another number (0 - 100): ");
         
         //input number
         inputtedNumber = keyboard.nextDouble();
      }
      
      //makes sure the user entered a valid number
      if (sum == 0)
      {
         //error message for not entering anything
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println("You didn't input any numbers, try again");
         System.out.println();
      }
      else
      {
         
         //calculation divides the sum by the numbers entered counter
         average = (sum / i);
      
         //separates outputs from final display
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println();
         
         //title
         System.out.println("Largest and Smallest");
      
         //lines to underline title
         System.out.println("--------------------");
      
         //separation between title and output
         System.out.println();
      
         //output largestNumber message and largestNumber
         System.out.println("Your largest number is: " + largestNumber);
      
         //output smallestNumber message and smallestNumber
         System.out.println("Your smallest number is : " + smallestNumber);
      
         //output sum message and sum of numbers
         System.out.println("Your sum is: " + sum);
      
         //output average message and the calculated average
         System.out.println("Your average is: " + average);
      
         //separates output from environment
         System.out.println();

      }
   }
   
   //end LargestAndSmallest
}
