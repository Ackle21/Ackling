// Program: EvenOdd
// Author: Alex Miller
// Date of Creation: 10/21/2018
// Modification Date: 10/22/2018
// Purpose: Randomly generate 100 numbers and determine how many of those numbers are even and how many are odd
// Input: None
// Calculations: Random number % 2
// Outputs: Amount of even numbers and amount of odd numbers

//allows use of random numbers
import java.util.Random;

public class EvenOdd
{
   //start of EvenOdd
   public static void main(String[] args)
   {
      int randomNumber; //randomly generated number
      int evenNumbers = 0; //Stores amount of even numbers generated
      int oddNumbers = 0; //Stores amount of odd numbers
      int i; //control variable
      
      //Creates random numbers
      Random randomNumbers = new Random();
      
      //for loop start
      for(i = 1; i <= 100; i++)
      {
         //returns next random number as an integer
         randomNumber = randomNumbers.nextInt(10) + 1;
         
         //if the random number is even
         if(IsEven(randomNumber))
         {
            //then even numbers increases
            evenNumbers++;
         }
         //else
         else
         {
            //then odd numbers increases
            oddNumbers++;
         }
      }
      //for loop end
      
      //separation between environment and title
      System.out.println();
      
      //output title
      System.out.println("Even Odd");
      
      //output dashed lines
      System.out.println("--------");
      
      //separation between title and output
      System.out.println();
      
      //outpue message for even numbers and amaountOfEvenNumbers
      System.out.println("Even Numbers: " + evenNumbers);
      
      //output message for odd number + amountOfOddNumbers
      System.out.println("Odd Numbers: " + oddNumbers);
      
      //separation between output and environment
      System.out.println();
   }
   
   //method for determining whether the random number is even or odd
   public static boolean IsEven(int randomNumber)
   {
   //Method: IsEven
   //Author: Alex Miller
   //Date of Creation: 10/21/2018
   //Modification Date: 10/22/2018
   //Purpose: Determine whether the random number is even or odd
   //Input: None
   //Calculations: Random number % 2
   //Outputs: None
   
      //if random number % 2 = 0
      if ((randomNumber % 2) == 0)
      {
         //random number is true
         return true;
      }
      //else
      else
      {
         //random number is false
         return false;
      }
   }
   
   //End of EvenOdd
}