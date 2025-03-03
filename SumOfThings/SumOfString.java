//Author: Alex Miller

import java.util.Scanner;

public class SumOfString
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      String numbers = "";
      int num = 0;
      int i = 0;
      String[] tokens;
      
      System.out.println("");
      System.out.println();
      
      System.out.print("Input a series of numbers separated by commas (Ex: 7,9,10,2): ");
      numbers = keyboard.nextLine();
      
      numbers = numbers.trim();
      
      tokens = numbers.split("[,]");
      
      for(i = 0; i < tokens.length; i++)
      {
         num = num + Integer.parseInt(tokens[i]);  
      } 
      
      System.out.println("Sum: " + num);
   }
}