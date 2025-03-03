//Author: Alex Miller

import java.util.Scanner;

public class SumOfDigits
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      String numbers = "";
      int num = 0;
      int i = 0;
      int highest = 0;
      int lowest = 10;
      char[] numArray;
      
      System.out.println("");
      System.out.println();
      
      System.out.print("Input a series of numbers with no spaces(Ex: 79102): ");
      numbers = keyboard.nextLine();
      
      numbers = numbers.trim();
      
      numArray = numbers.toCharArray();
      
      for(i = 0; i < numArray.length; i++)
      {
         
         if (Character.isDigit(numArray[i])) 
         {
            numbers = String.valueOf(numArray[i]);
            num = num + Integer.parseInt(numbers);
            
            if(Integer.parseInt(numbers) < lowest)
            {
               lowest = Integer.parseInt(numbers);
            }
            if(Integer.parseInt(numbers) > highest)
            {
               highest = Integer.parseInt(numbers);
            }
         } 
         
      } 
      
      
      System.out.println("Lowest: " + lowest);
      System.out.println("Highest: " + highest);
      System.out.println("Sum: " + num);
   }
}