//Author: Alex Miller

public class PreferredCustomer extends Customer
{
   private double customerSpent;
   private int discount;
   
   public PreferredCustomer()
   {
      super();
      customerSpent = 0;
      discount = 0;
   }
   
   public PreferredCustomer(String n, String a, String p, String c, boolean m, double s, int d)
   {
      super(n, a, p, c, m);
      customerSpent = s;
      discount = d;
   }
   
   public void getCustomerSpent(int s)
   {
      customerSpent = s;
   }
   
   public void getDiscount(int d)
   {
      discount = d;
   }
   
   public double getCustomerSpent()
   {
      return customerSpent;
   }
   
   public int getDiscount()
   {
      return discount;
   }
}