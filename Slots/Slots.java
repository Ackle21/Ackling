import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Slots
{

   public static void main(String[] args) 
   throws IOException
   {
      Scanner keyboard = new Scanner(System.in);
      Random random = new Random();
      int[][] array = new int[3][3];
      
      int slotTries;
      
      System.out.println();
      System.out.printf("\t\t\tSlots\n");
      System.out.println();

      System.out.print("How many Tries: ");
      slotTries = keyboard.nextInt();
      
      System.out.println();
      
      for(int i = 0; i < slotTries; i++)
      {
         int randomNumber = random.nextInt(10);
         
         array[0][0] = randomNumber;
         
         randomNumber = random.nextInt(10);
         array[0][1] = randomNumber;
         
         randomNumber = random.nextInt(10);
         array[0][2] = randomNumber;
         
         randomNumber = random.nextInt(10);
         array[1][0] = randomNumber;
         
         randomNumber = random.nextInt(10);
         array[1][1] = randomNumber;
         
         randomNumber = random.nextInt(10);
         array[1][2] = randomNumber;
         
         randomNumber = random.nextInt(10);
         array[2][0] = randomNumber;
         
         randomNumber = random.nextInt(10);
         array[2][1] = randomNumber;
         
         randomNumber = random.nextInt(10);
         array[2][2] = randomNumber;
         
         System.out.printf("\t\t\t" + array[0][0] + " " + array[0][1] + " " + array[0][2] + "\n");
         System.out.printf("\t\t\t" + array[1][0] + " " + array[1][1] + " " + array[1][2] + "\n");
         System.out.printf("\t\t\t" + array[2][0] + " " + array[2][1] + " " + array[2][2] + "\n");
         System.out.println();
      }
            
   }
}