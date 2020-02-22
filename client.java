import java.net.*;
import java.io.*;
import java.util.*;

class client
{
   public static void main(String[] args) throws IOException{
   Socket ts=null;
   ObjectInputStream ots=null;
   try
   {
        ts=new Socket("localhost",1313);
        ots=new ObjectInputStream(ts.getInputStream());
   }
   catch(UnknownHostException ue){
        System.err.println("Unknown");
        System.exit(1);
   }
   catch(IOException ie)
   {
      System.err.println("Localhost not connecting");
      System.exit(1);
   }
   try
   {
      Date sd=(Date)ots.readObject();
      System.out.println(sd);
   }
   catch(ClassNotFoundException ce)
   {
      System.err.println("Not there");
      System.exit(1);
   }
   ots.close();
   ts.close();
   }
}