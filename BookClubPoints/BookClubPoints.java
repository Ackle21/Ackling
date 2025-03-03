// Program: BookClubPoints
// Author: Alex Miller
// Date of Creation: 9/24/2018
// Modification Date: 9/24/2018
// Purpose: Allow the user to input books purchased and then tells them how many points they earned from doing so
// Input: Books purchased
// Calculations: None
// Outputs: Books purchased and Points awarded



//Get file classes needed for input
import java.util.Scanner;


public class BookClubPoints
{

   //Start        BookClubPoints
   public static void main (String[] args)
   {
      //Creates keyboard read object
      Scanner keyboard = new Scanner(System.in);
      
      //Creates the values
      double books;
      double points;
      
      //Output       Separation between environment and Title
      System.out.println();
      
      //Output       Title
      System.out.println("Book Club Points");
      
      //Output       Dashed Lines 
      System.out.println("----------------");
      
      //Output       Separation between Dashed Lines and Output
      System.out.println();
      
      //Output       User message for input 1
      System.out.println("Books bought this month(0 - 100): ");
      
      //Input        Get number1
      books = keyboard.nextDouble();
      
      //if           #1 >= 4
      if (books >= 4)
      {
         //then         points = 60
         points = 60;
      }
      
      //else if      #1 == 3 
      else if (books == 3)
      {
         //then         points = 30
         points = 30;
      }
      
      //else if      #1 == 2 
      else if (books == 2)
      {
         //then         points = 15
         points = 15;
      }
      
      //else if     #1 >= 1 
      else if (books == 1)
      {
         //then         points = 5
         points = 5;
      }
      
      //else    
      else
      {
         //then         points = 0
         points = 0;
      }     
      
      //Output       Separation between input and title
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      
      //Output       Title
      System.out.println("Book Club Points");
      
      //Output       Dashed Lines
      System.out.println("----------------");
      
      //Output       Separation between dashed lines and output
      System.out.println();
      
      //Output       Text for Number 1 + number1
      System.out.println("Books bought this month: " + books);
      
      //Output       Separation between number1 and points
      System.out.println();
      
      //Output       Text for points + points
      System.out.println("Points awarded: " + points);
      
      //Output       Separation between Output and environment   
      System.out.println();
   }
   
//End          BookClubPoints

}