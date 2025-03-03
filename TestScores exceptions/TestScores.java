//Alex Miller

import java.util.Scanner;

public class TestScores
{
	public static void main(String[]args)
	{
		int tests = 0;
		double[] grade = new double[tests];
		double gradeTotal = 0;
		double average;
		
		
		
		Scanner keyboard = new Scanner(System.in);
      
      System.out.println("         Test Scores");
      System.out.println("----------------------------");
		
		System.out.println("How many tests do you have? ");
		tests = keyboard.nextInt();
		
      System.out.println();
      
		grade = new double[(int) tests];
		
		
		for (int i = 0; i < grade.length; i++)
		{
			System.out.print("Enter grade for Test " + (i + 1) + ": ");
			grade[i] = keyboard.nextDouble();	
			
			if (grade[i] < 0 || grade[i]> 100)
			{
				try 
            {
				   throw new InvalidTestScore();
				} 
            catch (InvalidTestScore e) 
				{
               System.out.println();
					e.printStackTrace();
				}
            
            if(grade[i] < 0 || grade[i]> 100)
            {
               i--;
            }
			}
         
         System.out.println();
		}
		
		for (int i = 0; i < grade.length; i++)
		{
			gradeTotal += grade[i];
		}
		
		average = gradeTotal/grade.length;
		
		System.out.print("The average is: " + average);
		
		
	}
}
