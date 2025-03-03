import java.util.Scanner;
import java.io.*;
public class FinalProject 
{
  private int accumlator = 0;
  private int counter = 0;
  private int instruction = 0;
  private int opCode = 0;
  private int operand = 0;
  private boolean error = false;
  private int[] memory = new int[100];
  
  public void go() 
  {
    for (int i=0; i<100; i++)
    {
      memory[i]=0;
    }
    LoadMemory();
    Dump();
  }
  
  public int fetch(int location)
  {
    if(location > 100 || location <0)
    {
      error = true;
      System.out.println("Memory out of bounds error");
      return(0);
    }
    else{
      counter++;
      return(memory[location]);
    }
  }
  
  public void Execute()
  {
    Scanner sc = new Scanner(System.in);
    String data = " ";
    int number;
    char ascii;
    switch(opCode)
    {
        
    }
  }
  
  public void LoadMemory()
  {
    memory[0]=4306;
    memory[1]=9999;
    memory[2]=-9000;
    memory[3]=0010;
    memory[4]=0000;
    memory[5]=0000;
    memory[6]=3304;
    memory[7]=3101;
    memory[8]=799;
    memory[9]=903;
    memory[10]=5000;
  }
  
  public void Dump()
  {
    System.out.print("Accumlotor = " + accumlator + " ");
    System.out.print("Counter = " + counter + " ");
    System.out.print("Instruction = " + instruction + " ");
    System.out.print("OpCode = " + opCode + " ");
    System.out.print("Operand = " + operand + " ");
    System.out.println("Error (T/F) =" + error + " ");
  }
}