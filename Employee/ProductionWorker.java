public class ProductionWorker extends Employee
{
   private int shift;
   private double rate;
   
   public ProductionWorker()
   {
      super();
      shift = 0;
      rate = 0;
   }
   
   public ProductionWorker(String n, String e, String h, int s, double r)
   {
      super(n, e, h);
      shift = s;
      rate = r;
   }
   
   public void setShift(int s)
   {
      shift = s;
   }
   
   public void setRate(double r)
   {
      rate = r;
   }
   
   public int getShift()
   {
      return shift;
   }
   
   public double getRate()
   {
      return rate;
   }
}