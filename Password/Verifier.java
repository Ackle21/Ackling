//Author: Alex Miller

public class Verifier
{
   public static boolean isValid(String str)
   {
      boolean status; //how valid
      
      if (str.length() >= 6 && hasUpperCase(str) && hasLowerCase(str) && hasDigit(str))
      {
         status = true;
      }
      else
      {
         status = false;
      }
         
      return status;
   }
   
   //checks if has uppercase letter
   private static boolean hasUpperCase(String str)
   {
      boolean status = false;
      
      for (int i = 0; i < str.length(); i++)
      {
         if (Character.isUpperCase(str.charAt(i)))
         {
            status = true;
         }
      }
      
      return status;
   }
   
   //checks if there is a lowercase letter
   private static boolean hasLowerCase(String str)
   {
      boolean status = false;
      
      for (int i = 0; i < str.length(); i++)
      {
         if (Character.isLowerCase(str.charAt(i)))
         {
            status = true;
         }
      }
      
      return status;
   }
   
   //checks if there is a digit
   private static boolean hasDigit(String str)
   {
      boolean status = false;
      
      for (int i = 0; i < str.length(); i++)
      {
         if (Character.isDigit(str.charAt(i)))
         {
            status = true;
         }
      }
      
      return status;
   }  
}