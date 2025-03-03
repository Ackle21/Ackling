//Author: Alex Miller

public class Employee
{
   private String name;
   private String number;
   private String hireDate;
   
   public Employee()
   {
      name = "";
      number = "";
      hireDate = "";
   }
   
   public Employee(String n, String e, String h)
   {
      name = n;
      number = e;
      hireDate = h;
   }
   
   public void setName(String n)
   {
      name = n;
   }
   
   public void setNumber(String e)
   {
      name = e;
   }
   
   public void setHireDate(String h)
   {
      name = h;
   }
   
   public String getName()
   {
      return name;
   }
   
   public String getNumber()
   {
      return number;
   }
   
   public String getHireDate()
   {
      return hireDate;
   }
}