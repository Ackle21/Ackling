//Author: ALex Miller

public class EssayDemo
{
   public static void main(String[] args)
   {
      int grammar = 30;
      int spelling = 20;
      int length = 20;
      int content = 30;
      
      Essay essay = new Essay(grammar, spelling, length, content);
      
      System.out.println();
      System.out.println();
      
      System.out.println("Final Grade: " + essay.getScore());
      
      System.out.print("Letter Grade: " + essay.getGrade());
      
      System.out.println();
      System.out.println();
   }
}
