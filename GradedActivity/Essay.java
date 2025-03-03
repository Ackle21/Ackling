//Author: Alex Miller

public class Essay extends GradedActivity
{
   private int grammar;
   private int spelling;
   private int length;
   private int content;
   
   public Essay()
   {
      super();
      grammar = 0;
      spelling = 0;
      length = 0;
      content = 0;
   }
   
   public Essay(int g, int s, int l, int c)
   {
      super();
      grammar = g; 
      spelling = s;
      length = l;
      content = c;
      
      int totalScore = grammar + spelling + length + content;
      
      setScore(totalScore);
   }
   
   public void setGrammar(int g)
   {
      grammar = g;
   }
   
   public void setSpelling(int s)
   {
      spelling = s;
   }
   
   public void setLength(int l)
   {
      length = l;
   }
   
   public void setContent(int c)
   {
      content = c;
   }
   
   public int getGrammar()
   {
      return grammar;
   }
   
   public int getSpelling()
   {
      return spelling;
   }
   
   public int getLength()
   {
      return length;
   }
   
   public int getContent()
   {
      return content;
   }
}