// Program: Procedure
// Author: Alex Miller
// Date Created: 11/5/18
// Date Modified: 11/7/18
// Purpose: help with PatientCharges class
// Input: None
// Output: None
// Calculations: Sum of all procedure charges

//begin Procedure class
public class Procedure
{
   //constructor variables
   private String procedure1Name;   //stores name of first procedure
   private String procedure2Name;   //stores name of second procedure
   private String procedure3Name;   //stores name of third procedure
   private String procedure1Date;   //stores date of first procedure
   private String procedure2Date;   //stores date of second procedure
   private String procedure3Date;   //stores date of third procedure
   private String practitioner1Name;   //stores name of first practitioner
   private String practitioner2Name;   //stores name of second practitioner
   private String practitioner3Name;   //stores name of third practitioner
   private double procedure1Charge; //stores charge of first procedure
   private double procedure2Charge; //stores charge of second procedure
   private double procedure3Charge; //stores charge of third procedure
   private double procedureTotal;   //stores sum of the procedures
   
   //Initializes variables
   public Procedure()
   {
      procedure1Name = "Physical Exam";
      procedure2Name = "X-Ray";
      procedure3Name = "Blood Test";
      procedure1Date = "11/5/18";
      procedure2Date = "11/5/18";
      procedure3Date = "11/5/18";
      practitioner1Name = "Dr. Irvine";
      practitioner2Name = "Dr. Jamison";
      practitioner3Name = "Dr. Smith";
      procedure1Charge = 250.00;
      procedure2Charge = 500.00;
      procedure3Charge = 200.00;
   }
   
   //allows the procedure to be used in another class
   public String getProcedure1Name()
   {
      return procedure1Name;
   }
   
   //allows the procedure to be used in another class
   public String getProcedure2Name()
   {
      return procedure2Name;
   }
   
   //allows the procedure to be used in another class
   public String getProcedure3Name()
   {
      return procedure3Name;
   }
   
   //allows the procedure date to be used in another class
   public String getProcedure1Date()
   {
      return procedure1Date;
   }
   
   //allows the procedure date to be used in another class
   public String getProcedure2Date()
   {
      return procedure2Date;
   }
   
   //allows the procedure date to be used in another class
   public String getProcedure3Date()
   {
      return procedure3Date;
   }
   
   //allows the practitioner's name to be used in another class
   public String getPractitioner1Name()
   {
      return practitioner1Name;
   }
   
   //allows the practitioner's name to be used in another class
   public String getPractitioner2Name()
   {
      return practitioner2Name;
   }
   
   //allows the practitioner's name to be used in another class
   public String getPractitioner3Name()
   {
      return practitioner3Name;
   }

   //allows the procedure's charge to be used in another class
   public double getProcedure1Charge()
   {
      return procedure1Charge;
   }
   
   //allows the procedure's charge to be used in another class
   public double getProcedure2Charge()
   {
      return procedure2Charge;
   }
   
   //allows the procedure's charge to be used in another class
   public double getProcedure3Charge()
   {
      return procedure3Charge;
   }
   
   //sums up the three procedures' charges and allows another class to use it
   public double totalCharge()
   {
      procedureTotal = procedure1Charge + procedure2Charge + procedure3Charge;
      return procedureTotal;
   }
}
//end Procedure class