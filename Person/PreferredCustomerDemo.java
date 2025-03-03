import java.util.Scanner;

public class PreferredCustomerDemo
{
   public static void main (String[] args)
   {
   
      String name = "Alex Miller";
      String address = "1313 Oak Lane";
      String phone = "6157776677";
      String number = "555-F";
      double purchaseAmount = 500;
      int discount = 5;
      boolean mailing = false;
      
      PreferredCustomer prefCustomer = new PreferredCustomer(name, address, phone, number, mailing, purchaseAmount, discount);
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println();
      System.out.println();
      
      System.out.print("Customer Name: " + prefCustomer.getName());
      
      System.out.println();
      System.out.println();
      
      System.out.print("Customer Address: " + prefCustomer.getAddress());
      
      System.out.println();
      System.out.println();
      
      System.out.print("Customer Phone Number: " + prefCustomer.getPhone());
      
      System.out.println();
      System.out.println();
      
      System.out.print("Customer Number: " + prefCustomer.getCustomerNumber());
      
      System.out.println();
      System.out.println();
      
      System.out.print("Customer on Mailing List: " + prefCustomer.getMailingList());
      
      System.out.println();
      System.out.println();
      
      System.out.print("Amount Customer Spent: " + prefCustomer.getCustomerSpent());
      
      System.out.println();
      System.out.println();
      
      System.out.print("Discount Given: " + prefCustomer.getDiscount() + "%");
      
      System.out.println();
      System.out.println();
   }
}