// Program: TestScoresTest
// Author: Alex Miller
// Date Created: 11/5/18
// Date Modified: 11/5/18
// Purpose: Allow the user to enter in three grades and then display the grades along with the average 
// Input: Grades
// Output: Grades and averge
// Calculations: Average of grades

// Imports the java Scanner
import java.util.Scanner;


public class TestScoresProgram
{
   //Begin TestScoresProgram
   public static void main(String [] args )
   {
      //Allows use of keyboard
      Scanner keyboard = new Scanner(System.in);
      
      //Brings in TestScores class from previous program
      TestScores test = new TestScores();
      
      double grade1;      //stored data for grade 1
      double grade2;      //stored data for grade 2
      double grade3;      //stored data for grade 3
      
      //separation of environment from title
      System.out.println();
      System.out.println();
      
      //Output title
      System.out.println("\t\t\tTest Scores");
      System.out.println("\t\t\t-----------");
      
      //output user message for grade 1
      System.out.print("Enter grade #1: ");
      //input grade 1
      grade1 = keyboard.nextDouble();
      
      //output user message for grade 2
      System.out.print("Enter grade #2: ");
      //input grade 2
      grade2 = keyboard.nextDouble();
      
      //output user message for grade 2
      System.out.print("Enter grade #3: ");
      //input grade 3
      grade3 = keyboard.nextDouble();
      
      //Seperation of input from output
      System.out.println();
      System.out.println();
      
      //Output Title
      System.out.println("\t\t\tTest Scores");
      System.out.println("\t\t\t-----------");
      
      //Seperation from title to output
      System.out.println();
      
      //Bring in methods from original class
      test.setGrade1(grade1);
      test.setGrade2(grade2);
      test.setGrade3(grade3);
      
      //output grades and average
      System.out.printf("Score 1: %.2f\nScore 2: %.2f\nScore 3: %.2f\n--------------\nAverage: %.2f", test.getGrade1(), test.getGrade2(), test.getGrade3(), test.calculateAverage());
   }
   //end TestScoresProgram
}

