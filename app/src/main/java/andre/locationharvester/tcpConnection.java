package andre.locationharvester;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class tcpConnection
{

   public static void send(File file,int port)
   {
       try
       {
           //TEST:
    	   //System.out.println(" Providing file...");
           ServerSocket serverSocket = new ServerSocket(port);
           Socket socket = serverSocket.accept();
           //TEST:
           //System.out.println(" sending file to: " + socket.getRemoteSocketAddress());
           byte[] buffer = new byte[16384];
    	   InputStream inputStream = new FileInputStream(file);
           OutputStream outputStream = socket.getOutputStream();
           int len = 0;
           while ((len = inputStream.read(buffer)) > 0)
    	   {
               outputStream.write(buffer, 0, len);
           }
           System.out.println(" sending completed");
           inputStream.close();
           outputStream.close();
           socket.close();
           serverSocket.close();
           
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
   }
   
   public static void sendString(String stringToSend,int port)
   {
       try
       {
           //TEST:
    	   //System.out.println(" Providing file...");
           ServerSocket serverSocket = new ServerSocket(port);
           Socket socket = serverSocket.accept();
           //TEST:
           //System.out.println(" sending file to: " + socket.getRemoteSocketAddress());
           
           // convert String into InputStream
           byte[] buffer = new byte[16384];
           InputStream inputStream = new ByteArrayInputStream(stringToSend.getBytes());
           OutputStream outputStream = socket.getOutputStream();
           int len = 0;
           while ((len = inputStream.read(buffer)) > 0)
     	   {
               outputStream.write(buffer, 0, len);
           }
           inputStream.close();
           outputStream.close();
           socket.close();
           serverSocket.close();
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
   }
}
