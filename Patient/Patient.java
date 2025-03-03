// Program: Patient
// Author: Alex Miller
// Date Created: 11/5/18
// Date Modified: 11/7/18
// Purpose: Help the PatientCharges class
// Input: None
// Output: None
// Calculations: None

//begine Patient class
public class Patient
{
   private String patientName;   //storage location for the patient's name
   private String patientAddress;   //storage location for the patient's address
   private String patientPhoneNumber;  //storage location for patient's phone number
   private String emergencyContactInfo;   //storage location for patient's emergency contact and their phone number
   
   //initializes variables
   public Patient()
   {
      patientName = "George Pain Wilkerson";
      patientAddress = "1111 Coralince Circle, Hinkle, Ohio, 40032";
      patientPhoneNumber = "666-777-1234";
      emergencyContactInfo = "La-a Wilkers, 111-222-0987";
   }
   
   //returns patient's name
   public String getPatientName()
   {
      return patientName;
   }
      
   //returns patient's address
   public String getPatientAddress()
   {
      return patientAddress;
   }
   
   //return patient's phone number
   public String getPatientPhoneNumber()
   {
      return patientPhoneNumber;
   }
   
   //returns patient's emergency contact and the contact's phone number
   public String getEmergencyContactInfo()
   {
      return emergencyContactInfo;
   }
}
//End Patient class