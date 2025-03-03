//Alex Miller

import java.util.Scanner;

public class TimeConversion
{
   public static void main(String[] args)
   {
      
      String amPm = "";
      int hours;
      int minutes;
      int valid = 0;
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println();
      System.out.println();
      
      System.out.print("Enter in hour of day (1 - 12): ");
      hours = keyboard.nextInt();
      while (valid == 0)
      {
         if(hours <= 12 && hours > 0)
         {
            valid = 1;
         }
         else
         {
            System.out.println();
            System.out.println("That is not a valid time.");
            System.out.print("Please enter in a hour valid time (1 - 12): ");
            hours = keyboard.nextInt();
         }
      }
      
      valid = 0;
      
      System.out.println();
      System.out.print("Enter in minutes of the hour (00 - 60): ");
      minutes = keyboard.nextInt();
      while (valid == 0)
      {
         if(minutes <= 60 && minutes >= 00)
         {
            valid = 1;
         }
         else
         {
            System.out.println();
            System.out.println("That is not a valid time.");
            System.out.print("Please enter in a valid minutes time (0 - 60): ");
            minutes = keyboard.nextInt();
         }
      }
      
      
      valid = 0;
      System.out.println();
      System.out.print("AM or PM: ");
      amPm = keyboard.next();
      amPm = amPm.toUpperCase();
      while (valid == 0)
      {
         if(amPm.equals("AM") || amPm.equals("PM"))
         {
            valid = 1;
         }
         else
         {
            System.out.println();
            System.out.println("That is not a valid entry.");
            System.out.print("AM or PM: ");
            amPm = keyboard.next();
         }
      }
      
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.print("Army time: ");
      
      if(amPm.equals("PM"))
      {
         if(hours == 12)
         {
            setup(hours, minutes, amPm);
         }
         else
         {
         hours = hours + 12;
         setup(hours, minutes, amPm);
         }
      }
      else if(amPm.equals("AM"))
      {
         if(hours == 12)
         {
            hours = hours - 12;
            setup(hours, minutes, amPm);
         }
         else
         {
         setup(hours, minutes, amPm);
         }
         
      }
      
      
      System.out.println();
      System.out.println();
   }
   
   public static void setup(int hours, int minutes, String amPm)
   {
      
      if (minutes < 10)
      {
         System.out.print(hours + ":0" + minutes + " " + amPm);
      }
      else if(hours == 0)
      {
         System.out.print("0" + String.valueOf(hours) + ":" + minutes + " " + amPm);
      }
      else if(minutes < 10 && hours == 0)
      {
         System.out.print("0" + hours + ":0" + minutes + " " + amPm);
      }
      else
      {
         System.out.print(hours + ":" + minutes + " " + amPm);
      }
   }
}
