import java.util.Scanner;

public class ProductionWorkerDemo
{
   public static void main (String[] args)
   {
      String name = "Alex Miller";
      String number = "555-F";
      String hireDate = "10/15/16";
      int shift = 8;
      double rate = 10.20;
      
      ProductionWorker prodWork = new ProductionWorker(name, number, hireDate, shift, rate);
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println();
      System.out.println();
      
      System.out.print("Employee Name: " + prodWork.getName());
      
      System.out.println();
      System.out.println();
      
      System.out.print("Employee Number: " + prodWork.getNumber());
      
      System.out.println();
      System.out.println();
      
      System.out.print("Employee Hire Date: " + prodWork.getHireDate());
      
      System.out.println();
      System.out.println();
      
      System.out.print("Employee Shift: " + prodWork.getShift());
      
      System.out.println();
      System.out.println();

      System.out.print("Employee Rate: " + prodWork.getRate());
      
      System.out.println();
      System.out.println();
   }
}