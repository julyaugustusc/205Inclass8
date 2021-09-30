import java.io.*;
import java.util.ArrayList;


public class ReadObject
{
  public static void main (String[] args)
   {
    String filename = "computer.data";
    FileInputStream file = null;
    ObjectInputStream inStream = null;
    Object obj1=null;
    ArrayList<BankAccount> accounts=null;
    try
     {
       file = new FileInputStream (filename);
       inStream = new ObjectInputStream (file);
       obj1= inStream.readObject();

     }catch (FileNotFoundException exception)
     {
      System.out.println( filename + " was not found");
     }
     catch (IOException exception)
	      {
	       System.out.println("IOException has occurred.");
	      }

     catch (ClassNotFoundException exception)
	     {
	      System.out.println( filename + " was not found");
     }


       // Deserialize the objects
    try{

      do
      {

	  if (obj1 instanceof BankAccount)
	          {
	              BankAccount   comp2 = (BankAccount) obj1;

	               // Print the object
	               System.out.println (comp2);
          }



		 obj1 = inStream.readObject();

     } while(obj1 !=null);
     }
   catch (ClassNotFoundException exception)
     {
      System.out.println("Class was not found");
     }
   catch (FileNotFoundException exception)
     {
      System.out.println( filename + " was not found");
     }
   catch (IOException exception)
     {
      System.out.println("Done reading objects.");
     }

  }


}
