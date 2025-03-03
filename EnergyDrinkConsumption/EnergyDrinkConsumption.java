// Program: EnergyDrinkConsumption
// Author: Alex Miller
// Date of Creation: 9/10/2018
// Modification Date: 9/10/2018
/* Purpose: Displays to the user the number of people surveyed for to find out how many people buy energy drinks weekly, How many people buy energy drinks weekly,
and how many of the energy drink buyers enjoy citrus-flavored energy drinks
*/ 
// Input: None
// Calculations: None
// Outputs: Number of people surveyed, Number of those who buy energy drinks weekly, Amount of those people who enjoy citrus flavored energy drinks




/*
Start  Energy Drink Consumption
Output Separation between environment and Title
Output Title (Energy Drink Consumption)
Output Separation between Title and Output
Output Number of people surveyed: 12467
Output Separation between number of people and output
Output Approximation of people who bought an energy drink each week + WeeklyBuyers
Output Amount of those buyers who enjoy Citrus-Flavored energy drinks + EnjoysCitrus
Output Separation between Output and Environment
End    Energy Drink Consumption
*/

//creates java program class
public class EnergyDrinkConsumption
{
   //begin EnergyDrinkConsumption
   public static void main (String[] args)
   {
      //First number
      int PeopleSurveyed = 12467;
      
      //Second Number
      int WeeklyBuyers = 1745;
      
      //Thind Number
      int EnjoysCitrus = 1117;
      
      //Separate environment from title
      System.out.println();
      
      //Output title
      System.out.println("Energy Drink Consumption");
      
      //Output Dashed Lines
      System.out.println("------------------------");
      
      //Separate Dashed Lines from Output
      System.out.println();
      
      //Output Number of people surveyed: 12467
      System.out.println("Number of people surveyed: " + PeopleSurveyed);
      
      //Separate Outputs
      System.out.println();
      
      //Output Approximation of people who bought an energy drink each week + WeeklyBuyers
      System.out.println("Approximate munber of people who buy energy drinks weekly: " + WeeklyBuyers);
      
      //Output Amount of those buyers who enjoy Citrus-Flavored energy drinks + EnjoysCitrus
      System.out.println("Number of those buyers who enjoy citrus-flavored energy drinks: " + EnjoysCitrus);
      
      //Separate Output from environment
      System.out.println();
      
      //End EnergyDrinkConsumption
   }
}
