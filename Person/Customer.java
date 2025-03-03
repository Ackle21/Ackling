/**
The Customer class stores data about a person 
who is a customer for the Person and Customer 
Classes programming challenge.
*/
public class Customer extends Person
{
   private String customerNumber; // Customer number
   private boolean mailingList; // Add to mailing list?
   /**
   The no-arg constructor initializes the object with
   empty strings for name, address, phone, and
   customerNumber. The mailingList field is set
   to false.
   */
   
   public Customer()
   {
      super();
      customerNumber = "";
      mailingList = false;
   }
   /**
   This constructor initializes the object with
   a name, address, a phone number, a customer
   number, and mailing list status.
   @param n The name.
   @param a The address.
   @param p The phone number.
   @param c The customer number.
   @param m Mailing list status (true = yes, false = no).
   */
   
   public Customer(String n, String a, String p, String c, boolean m)
   {
      super(n, a, p);
      customerNumber = c;
      mailingList = m;
   }
   /**
   The setCustomerNumber method sets the customerNumber
   field.
   @param c The customer number to use.
   */
   
   public void setCustomerNumber(String c)
   {
      customerNumber = c;
   }
   /**
   The setMailingList method sets the mailing list
   status.
   @param m The mailing list status (true = add to 
   mailing list, false = do not add to mailing
   list).
   */
   
   public void setMailingList(boolean m)
   {
      mailingList = m;
   }
   /**
   The getCustomerNumber method retrns the customer
   number.
   @return The customer number.
   */
   public String getCustomerNumber()
   {
      return customerNumber;
   }
   /**
   The getMailingList method retrns the mailing list
   status.
   @return The mailing list status.
   */
   
   public boolean getMailingList()
   {
      return mailingList;
   }
}   