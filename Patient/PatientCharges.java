// Program: PatientCharges
// Author: Alex Miller
// Date Created: 11/5/18
// Date Modified: 11/7/18
// Purpose: Display the information of a patient and his procedures
// Input: None
// Output: Patient's information along with the information on his procedures
// Calculations: Sum of procedures

// Imports the java Scanner
import java.util.Scanner;

public class PatientCharges
{
   public static void main(String[] args)
   {
      //Allows use of keyboard
      Scanner keyboard = new Scanner(System.in);
      
      //Brings in Patient class
      Patient patient = new Patient();
      
      //Brings in Procedure class
      Procedure procedure = new Procedure();
      
      //separates environment from title
      System.out.println();
      
      //output title and dashed lines
      System.out.println("\t\t\t\t\t\t\t\t\t\tPatient Information");
      System.out.println("\t\t\t\t\t\t\t\t\t\t-------------------");
      
      //output patient's information
      System.out.printf("\nPatient: %s\nPatient's Address: %s\nPatient's Phone Number: %s\nEmergency Contact: %s",
       patient.getPatientName(), patient.getPatientAddress(), patient.getPatientPhoneNumber(), patient.getEmergencyContactInfo());
       
      //separates output from output
      System.out.println();
      
      //output procedure numbers for organization
      System.out.printf("\nProcedure #1\t\t\t\t\t\t\tProcedure #2\t\t\t\t\t\t\t\tProcedure #3\n");
      
      //output dashed lines for neatness
      System.out.println("-------------------------------------------------------------------------------------------------------------------");
      
      //output procedure names
      System.out.printf("\nProcedure Name: %s\t\tProcedure Name: %s\t\t\t\t\tProcedure Name: %s",
       procedure.getProcedure1Name(), procedure.getProcedure2Name(), procedure.getProcedure3Name());
       
      //output date of procedure
      System.out.printf("\nProcedure Date: %s\t\t\t\tProcedure Date: %s\t\t\t\t\tProcedure Date: %s",
       procedure.getProcedure1Date(), procedure.getProcedure2Date(), procedure.getProcedure3Date());
       
      //output name of practitioner that performed the procedure
      System.out.printf("\nPractitioner's Name: %s\tPractitioner's Name: %s\t\tPractitioner's Name: %s",
       procedure.getPractitioner1Name(), procedure.getPractitioner2Name(), procedure.getPractitioner3Name());
       
      //output charges of each procedure
      System.out.printf("\nProcedure's Charge: $%s\t\t\tProcedure's Charge: $%s\t\t\t\tProcedure's Charge: $%s",
       procedure.getProcedure1Charge(), procedure.getProcedure2Charge(), procedure.getProcedure3Charge());
       
      //output charge of all the procedures added up
      System.out.printf("\n\nTotal: $%s", procedure.totalCharge());
      
      //separation of output from environment
      System.out.println();
      
      
   }
}