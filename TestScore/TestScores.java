// Program: TestScores
// Author: Alex Miller
// Date Created: 11/5/18
// Date Modified: 11/5/18
// Purpose: Helping with TestScoresProgram
// Input: None
// Output:None
// Calculations:add grades together

//begin TestScores
public class TestScores
{  
   // Constructors for the grades
   private double grade1;
   private double grade2;
   private double grade3;
   
   // declares grades
   public TestScores()
   {
      grade1 = 0;    // Set grade 1 to 0
      grade2 = 0;    // Set grade 2 to 0
      grade3 = 0;    // Set grade 3 to 0
   }
   
   //method for getting grade 1
   public double getGrade1()
   {
      return grade1;
   }
   
   //method for getting grade 2
   public double getGrade2()
   {
      return grade2;
   }
   
   //method for getting grade 3
   public double getGrade3()
   {
      return grade3;
   }
   
   //method for setting grade 1
   public void setGrade1(double grade1Given)
   {
      grade1 = grade1Given;
   }
   
   //method for setting grade 2
   public void setGrade2(double grade2Given)
   {
      grade2 = grade2Given;
   }
   
   //method for setting grade 3
   public void setGrade3(double grade3Given)
   {
      grade3 = grade3Given;
   }
   
   //method for average
   public double calculateAverage()
   {
      return (grade1 + grade2 + grade3) / 3;
   }
   
//end TestScores
}