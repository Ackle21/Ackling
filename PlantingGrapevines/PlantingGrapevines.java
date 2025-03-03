// Program: PlantingGrapevines
// Author: Alex Miller
// Date of Creation: 9/10/2018
// Modification Date: 9/10/2018
/* Purpose: Allows the user to input a length of a row for grapevines, the amount of space used  by an end-post assembly, the space between the vines,
and then uses that information to display to the user how many grapevines can be planted in the row.
*/
// Input: Length of the grapevine row, Amount of space used by the end-post assembly, Space between vines
// Calculations: ( (Length of Row) - (2 * (space used by end-post assembly) ) ) / (space between vines)
/* Outputs: Length of the row being used for grapevines, Amount of space used by an end-post assembly, the space between vines, and the number of
grape vines that will fit in the row
*/

/*
Start        PlantingGrapevines
Output       Separation between environment and Title
Output       Title
Output       Dashed Lines
Output       Separation between Dashed Lines and Output
Output       User message for input 1
Input        Get Number 1
Output       User message for input 2
Input        Get Number 2
Output       User message for input 3
Input        Get Number 3
Calculations ((#1) - 2*(#2)) / (#3) = #4
Output       Separation between input and output
Output       Title
Output       Dashed Lines
Output       Separation between dashed lines and output
Output       Text for Number 1 + Number1
Output       Text for Number 2 + Number2
Output       Text for Number 3 + Number3
Output       Separation between Output and Output
Output       Text for Number 4 + Number4
Output       Separation between Output and environment
End          PlantingGrapevines
*/

//Get file classes needed for input
import java.util.Scanner;

//Creates java program class
public class PlantingGrapevines
{
   
   //Begin PlantingGrapevines
   public static void main (String[] args)
   {
      //Creates keyboard read object
      Scanner keyboard = new Scanner(System.in);
      
      //Spaces away from the top of the display
      System.out.println();
      
      //Output title
      System.out.println("Planting Grapevines");
      
      //Output Dashed Lines
      System.out.println("-------------------");
      
      //Output Separation between Dashed Lines and Output
      System.out.println();
      
      //Get first number and store the value
      System.out.println("Length of Row, in feet(0 - 1000): ");
      float lengthOfRow = keyboard.nextInt();
      
      //Get second number and store the value
      System.out.println("Amount of space used by end-post assembly, in feet(0 - 1000): ");
      float endPostAssemblySpace = keyboard.nextInt(); 
      
      //Get third number and store the value
      System.out.println("Space in between vines, in feet (0 - 1000): ");
      float spaceBetweenVines = keyboard.nextInt();
      
      //Calculate number 4 and store the value
      float GrapevinesInRow = (lengthOfRow - (2 * endPostAssemblySpace)) / spaceBetweenVines;
      
      //Separation
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      
      //Output Title
      System.out.println("Planting Grapevines");
      
      //Output Dashed Lines
      System.out.println("-------------------");
      
      //Separation
      System.out.println();
      
      //Output message along with number 1
      System.out.println("Length of Row: " + lengthOfRow);
      
      //Output message along with number 2
      System.out.println("Amount of space used by end-post assembly: " + endPostAssemblySpace);
      
      //Output message along with number 3
      System.out.println("Space in between vines: " + spaceBetweenVines);
      
      //Separation
      System.out.println();
      
      //Output message along with number 4
      System.out.println("Grapevines in row: " + GrapevinesInRow);
      System.out.println();
      
      //End PlantingGrapevines
   }
}
