import java.io.*;
import java.net.*;
import java.util.Date;
class server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket ss=null;
        try
        {
            ss=new ServerSocket(1313);
        }
        catch(IOException e)
        {
           System.out.println("COuld not connect");
           System.exit(1); 
        }
        long c=1;
        Socket s=null;
        while(true)
        {
             try
             {
                  s=ss.accept();
                  System.out.println("Accepted Request "+(c++));
             }
             catch(IOException e){ System.out.println("Error"); System.exit(1);}
             ObjectOutputStream os=new ObjectOutputStream(s.getOutputStream());
             os.writeObject(new Date());
             os.close();
             s.close();
        }
    }
}