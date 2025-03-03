import java.util.Scanner;

public class TryCustomerDemo
{
   public static void main (String[] args)
   {
   
      String name = "Alex Miller";
      String address = "1313 Oak Lane";
      String phone = "6157776677";
      String number = "555-F";
      boolean mailing = false;
      
      Customer customer = new Customer(name, address, phone, number, mailing);
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println();
      System.out.println();
      
      System.out.print("Customer Name: " + customer.getName());
      
      System.out.println();
      System.out.println();
      
      System.out.print("Customer Address: " + customer.getAddress());
      
      System.out.println();
      System.out.println();
      
      System.out.print("Customer Phone Number: " + customer.getPhone());
      
      System.out.println();
      System.out.println();
      
      System.out.print("Customer Number: " + customer.getCustomerNumber());
      
      System.out.println();
      System.out.println();
      
      System.out.print("Customer on Mailing List: " + customer.getMailingList());
      
      System.out.println();
      System.out.println();
   }
}