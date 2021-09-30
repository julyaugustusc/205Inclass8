import java.io.*;

public class WriteObject
{
  public static void main (String[] args)
   {
      FileOutputStream fileOutput= null;
      ObjectOutputStream outStream = null;
      try
       {
         fileOutput = new FileOutputStream ("computer.data");
         outStream = new ObjectOutputStream (fileOutput);

        BankAccount b = new BankAccount();
        b.deposit(100);

         BankAccount b1 = new BankAccount();
        b1.deposit(200);

         // Serialize this above object to a file
        outStream.writeObject(b);
        outStream.writeObject(b1);
        }
    catch (NotSerializableException exception)
       {
          System.out.println("NotSerializableException");
       }
      catch (IOException exception)
       {
          System.out.println("IOExceotion");
        }
     finally
       {
            try
              {    if (outStream != null) outStream.close();    }
            catch (IOException exc)
               {   System.out.println(exc);      }
        }
	}
}

