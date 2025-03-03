/**
   The Person class stores data about a person for the
   Person and Customer Classes programming challenge.
*/
public class Person
{
   private String name;       // The person's name
   private String address;    // The person's address
   private String phone;      // The person's phone number

   /**
      The no-arg constructor initializes the object with
      empty strings for name, address, and phone.
   */

   public Person()
   {
      name = "";
      address = "";
      phone = "";
   }

   /**
      This constructor initializes the object with
      a name, address, and a phone number.
      @param n The name.
      @param a The address.
      @param p The phone number.
   */

   public Person(String n, String a, String p)
   {
      name = n;
      address = a;
      phone = p;
   }

   /**
      The setName method sets the name field.
      @param n The name to use.
   */

   public void setName(String n)
   {
      name = n;
   }

   /**
      The setAddress method sets the address field.
      @param a The address to use.
   */

   public void setAddress(String a)
   {
      address = a;
   }

   /**
      The setPhone method sets the phone field.
      @param p The phone number to use.
   */

   public void setPhone(String p)
   {
      phone = p;
   }

   /**
      The getName method returns the name field.
      @return The name.
   */
   
   public String getName()
   {
      return name;
   }

   /**
      The getAddress method returns the address field.
      @return The address.
   */
   
   public String getAddress()
   {
      return address;
   }

   /**
      The getPhone method returns the phone field.
      @return The phone number.
   */
   
   public String getPhone()
   {
      return phone;
   }
}
