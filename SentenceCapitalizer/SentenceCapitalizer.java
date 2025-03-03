// Program: SentenceCapatalizer
// Author: Alex Miller
// Date Created: 2/6/19
// Date Modified: 2/7/19
// Purpose: 
// Input: 
// Output: 
// Calculations: 

// Imports the java Scanner
import java.util.Scanner;

public class SentenceCapitalizer
{
   public static void main(String[] args)
   {
      
      String userString = "";
      
      Capatalizer(userString);
      
   }
   
   public static void Capatalizer(String userString)
   {  
      char detectAndCapatalize;
      int i;
      StringBuilder inputtedString = new StringBuilder(userString);
      boolean isFirstCapital = true;
      
      //Allows use of keyboard
      Scanner keyboard = new Scanner(System.in);
      
      //separate environment from output
      System.out.println();
      System.out.println();
      
      System.out.println("Sentence Capatalizer");
      System.out.println("--------------------");
      
      System.out.println();
      System.out.println();
      
      System.out.print("Input sentence: ");
      userString = keyboard.nextLine();
      
      
      for (i = 0; i < userString.length(); i++)
      {
         detectAndCapatalize = userString.charAt(i);
         
         if(detectAndCapatalize == '.' || detectAndCapatalize == '!' || detectAndCapatalize == '?')
         {
            isFirstCapital = true;
            
         }
         else if(isFirstCapital && Character.isAlphabetic(detectAndCapatalize))
         {
            detectAndCapatalize = Character.toUpperCase(detectAndCapatalize);
            isFirstCapital = false;
            
         }
         inputtedString.append(detectAndCapatalize);
      }
      
      System.out.println(inputtedString);
      
   }
}

