// Program: TestAverageAndGrade
// Author: Alex Miller
// Date Created: 1/28/19
// Date Modified: 1/31/19
// Purpose: Allow user to enter in 5 test scores, then outputs the average and letter graes of the scores
// Input: Grades
// Output: Grades, average, and letter grades
// Calculations: Average of grades

// Imports the java Scanner
import java.util.Scanner;


public class TestAverageAndGrade
{
   //Begin TestScoresProgram
   public static void main(String [] args )
   {
      //Allows use of keyboard
      Scanner keyboard = new Scanner(System.in);
      
      double grade1;      //stored data for grade 1
      double grade2;      //stored data for grade 2
      double grade3;      //stored data for grade 3
      double grade4;      //stored data for grade 4
      double grade5;      //stored data for grade 5
      
      //separation of environment from title
      System.out.println();
      System.out.println();
      
      //Output title
      System.out.println("\t\t\tTest Scores");
      System.out.println("\t\t\t-----------");
      
      //output user message for grade 1
      System.out.print("Enter grade #1 (XXX.XX): ");
      //input grade 1
      grade1 = keyboard.nextDouble();
      
      //output user message for grade 2
      System.out.print("Enter grade #2 (XXX.XX): ");
      //input grade 2
      grade2 = keyboard.nextDouble();
      
      //output user message for grade 3
      System.out.print("Enter grade #3 (XXX.XX): ");
      //input grade 3
      grade3 = keyboard.nextDouble();
      
      //output user message for grade 4
      System.out.print("Enter grade #4 (XXX.XX): ");
      //input grade 4
      grade4 = keyboard.nextDouble();
      
      //output user message for grade 5
      System.out.print("Enter grade #5 (XXX.XX): ");
      //input grade 5
      grade5 = keyboard.nextDouble();
      
      //Seperation of input from output
      System.out.println();
      System.out.println();
      
      //Output Title
      System.out.println("\t\t\tTest Scores");
      System.out.println("\t\t\t-----------");
      
      //Seperation from title to output
      System.out.println();
      
      //Outputs grades and their letter versions
      System.out.println("Grade 1: " + grade1 + " - " + determineGrade(grade1));
      System.out.println("Grade 2: " + grade2 + " - " + determineGrade(grade2));
      System.out.println("Grade 3: " + grade3 + " - " + determineGrade(grade3));
      System.out.println("Grade 4: " + grade4 + " - " + determineGrade(grade4));
      System.out.println("Grade 5: " + grade5 + " - " + determineGrade(grade5));
      
      //blank line for separation
      System.out.println();
      
      double average = calcAverage(grade1, grade2, grade3, grade4, grade5);
      
      //output grades and average
      System.out.printf("\nAverage: %.2f", average);
   }
   
   
   public static double calcAverage(double grade1, double grade2, double grade3, double grade4, double grade5)
   {
      //stores value for average
      double average = 0;
      
      //calculates average of the five grades
      average = (grade1 + grade2 + grade3 + grade4 + grade5) / 5;
   
      //returns the average to the program
      return average;
   }
   
   public static char determineGrade(double grade)
   {
      //stores letter grade
      char letterGrade = 'Z';
      
      //if statements to determine letter grade that corresponds with number grade
      if (grade >= 90 && grade <= 100)
      {
         letterGrade = 'A';
      }
      else if (grade >= 80 && grade <= 89)
      {
         letterGrade = 'B';
      }
      else if (grade >= 70 && grade <= 79)
      {
         letterGrade = 'C';
      }
      else if (grade >= 60 && grade <= 69)
      {
         letterGrade = 'D';
      }
      else 
      {
         letterGrade = 'F';
      }
      
      //returns letterGrade to the program
      return letterGrade;
   }
   
   //end TestScoresProgram
}




