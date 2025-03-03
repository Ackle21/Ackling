// Program: ArrayOperations2D
// Author: Alex Miller
// Date Created: 12/3/18
// Date Modified: 12/3/18
// Purpose: Processing a 2D array
// Input: predetermined numbers for the 2D array
// Output: total of all numbers, average of the numbers, sum of each row, sum of each column, highest number in each column, highest in each row
// Calculations: Sum of numbers, sum / 2 = average

// Imports the java Scanner
import java.util.Scanner;

//start ArrayOperations2D
public class ArrayOperations2D
{
   public static void main(String[] args)
   {
      //variable initialization
      double[][] numbers = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} }; //creates a 2D array and initializes numbers inside
      double average; //stores average of numbers
      double total; //stores total or sum of numbers
      double rowTotal; //stores sum of numbers in a row
      double columnTotal; //Stores sum of numbers in column
      double rowHighest; //stores highest number of row
      double rowLowest; //stores lowest number pf row
      
      //separates title from environment
      System.out.println();
      System.out.println();
      
      //Output Title
      System.out.println("       2D Array Operations");
      
      //Separates title from output
      System.out.println();
      System.out.println(); 
      
      //Outputs total of numbers
      total = getTotal(numbers);
      
      //Outputs average of all numbers in array
      average = getAverage(numbers);
      
      //outputs sum of first row
      rowTotal = getRowTotal(numbers, 0);
      //outputs sum of second row
      rowTotal = getRowTotal(numbers, 1);
      //outputs sum of third row
      rowTotal = getRowTotal(numbers, 2);
      
      //outputs sum of first column
      columnTotal = getColumnTotal(numbers, 0);
      //outputs sum of second column
      columnTotal = getColumnTotal(numbers, 1);
      //outputs sum of third column
      columnTotal = getColumnTotal(numbers, 2);
      
      //outputs highest number in first row
      rowHighest = getHighestInRow(numbers, 0);
      //outputs highest number in second row
      rowHighest = getHighestInRow(numbers, 1);
      //outputs highest number in third row
      rowHighest = getHighestInRow(numbers, 2);
      
      //outputs lowest number in first row
      rowLowest = getLowestInRow(numbers, 0); 
      //outputs lowest number in second row
      rowLowest = getLowestInRow(numbers, 1); 
      //outputs lowest number in third row
      rowLowest = getLowestInRow(numbers, 2);  
      
      //separates output from environment
      System.out.println();    
      System.out.println();
   }
   
   
   // Method: getTotal
   // Author: Alex Miller
   // Date Created: 12/3/18
   // Date Modified: 12/3/18
   // Purpose: Goes through each number of the array and sums them up
   // Input: None
   // Output: None
   // Calculations: Sum of numbers
   public static double getTotal(double[][] numbersArray)
   {
      //initalizes total to zero
      double total = 0;
      
      //for loop adds numbers together into the sum
      for (int row = 0; row < numbersArray.length; row++)
      {
         for (int col = 0; col < numbersArray[row].length; col++)
         {
            total = total + numbersArray[row][col];
            
         }
      }
      
      //outputs total of numbers
      System.out.println("The total is " + total);
      
      //returns total of numbers
      return total;
   }
   
   // Method: getAverage
   // Author: Alex Miller
   // Date Created: 12/3/18
   // Date Modified: 12/3/18
   // Purpose: Gets average of numbers
   // Input: None
   // Output: None
   // Calculations: Sum / 9
   public static double getAverage(double[][] numbersArray)
   {
      //initializes total to zero
      double total = 0;
      //initializes average to zero
      double average = 0;
      
      //for loop adds up all numbers for the total
      for (int row = 0; row < numbersArray.length; row++)
      {
         for (int col = 0; col < numbersArray[row].length; col++)
         {
            total = total + numbersArray[row][col];
            
         }
      }
      
      //averages numbers
      average = total / 9;
      
      //outputs average of numbers
      System.out.println("The average is " + average);
      
      //returns average of number
      return average;
   }
   
   // Method: getRowTotal
   // Author: Alex Miller
   // Date Created: 12/3/18
   // Date Modified: 12/3/18
   // Purpose: Gets sum of numbers per row
   // Input: None
   // Output: None
   // Calculations: Sum of numbers in row
   public static double getRowTotal(double[][] numbersArray, int row)
   {
      //initializes sum of row numbers to zero
      double total = 0;
      
      //for loop adding numbers in row together
      for (int col = 0; col < numbersArray[row].length; col++)
      {
         total = total + numbersArray[row][col];
      }
      
      //outputs row number and sum of row
      System.out.println("Total of row " + row + " is " + total);
      
      //returns total of row
      return total;
   }
   
   // Method: getColumnTotal
   // Author: Alex Miller
   // Date Created: 12/3/18
   // Date Modified: 12/3/18
   // Purpose: Gets sum of numbers per column
   // Input: None
   // Output: None
   // Calculations: Sum of numbers
   public static double getColumnTotal(double[][] numbersArray, int col)
   {
      //initializes total of column to zero
      double total = 0;
      
      //for sums the numbers in column
      for (int row = 0; row < numbersArray[col].length; row++)
      {
         total = total + numbersArray[row][col];
      }
      
      //outputs row number and sum of column
      System.out.println("The total of column " + col + " is " + total);
      
      //returns total of column
      return total;
   }
   
   // Method: getHighestInRow
   // Author: Alex Miller
   // Date Created: 12/3/18
   // Date Modified: 12/3/18
   // Purpose: Determines highest number per row
   // Input: None
   // Output: None
   // Calculations: None
   public static double getHighestInRow(double[][] numbersArray, int row)
   {
      //initializes highest number
      double rowHighest = numbersArray[row][0];
      
      //for loop for determining highest number
      for(int col = 0; col < numbersArray[row].length; col++)
      {
         //if for making sure the next number is either higher or lower than the last
         if (numbersArray[row][col] > rowHighest)
         {
            rowHighest = numbersArray[row][col];
         }
      }
      
      //outputs highest of row
      System.out.println("The highest number in row " + row + " is " + rowHighest);
      
      //returns highest number
      return rowHighest;
   }
   
   // Method: getLowestInRow
   // Author: Alex Miller
   // Date Created: 12/3/18
   // Date Modified: 12/3/18
   // Purpose: Determines lowest of numbers per row
   // Input: None
   // Output: None
   // Calculations: None
   public static double getLowestInRow(double[][] numbersArray, int row)
   {
      //initializes lowest number
      double rowLowest = numbersArray[row][0];
      
      //for loop for determining lowest number
      for(int col = 0; col < numbersArray[row].length; col++)
      {
         //if for making sure the next number is either higher or lower than the last
         if (numbersArray[row][col] < rowLowest)
         {
            rowLowest = numbersArray[row][col];
         }
      }
      
      //outputs lowest of numbers
      System.out.println("The highest number in row " + row + " is " + rowLowest);
      
      //returns lowest of row
      return rowLowest;
   }
}

//end ArrayOperations2D
