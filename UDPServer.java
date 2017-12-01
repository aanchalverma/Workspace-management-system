import java.net.*;
import java.util.*;
import java.io.*;
public class UDPServer {
    public static void main(String[] args){
        DatagramSocket aSocket = null;
        Scanner scn=new Scanner(System.in);
        int serverPort =999;
        System.out.println("Server Ready\n Waiting for connection....\n");
        try{
            aSocket=new DatagramSocket(serverPort);
            byte[] buffer=new byte[1000];
            byte[] buf=new byte[1000];
           
           // DatagramPacket data1=new DatagramPacket(buf,buf.length);
           // aSocket.receive(data1);
           
           // byte[] msg=new byte[1000];
           // msg=data1.getData();
           // System.out.println(new String(msg,0,data1.getLength()));
            
            System.out.println("\nEnter message to be sent:");
           // String str="Connected to server";
           String str=scn.nextLine();
            buffer=str.getBytes();
            DatagramPacket data=new DatagramPacket(buffer,buffer.length,InetAddress.getLocalHost(),998);
            aSocket.send(data);
            //System.out.println("\nEnter message to be sent:");
            
             //buffer=str.getBytes();
             //data=new DatagramPacket(buffer,buffer.length,InetAddress.getLocalHost(),998);
           // aSocket.send(data);
            
        }
        catch(SocketException e){
            System.out.println("Socket:"+e.getMessage());
        }
        catch(IOException e){
            System.out.println("Io:"+e.getMessage());
        }
        finally
        {
            System.out.println("\nMessage sent\nConnection terminated");
            if(aSocket!=null)
                aSocket.close();
            scn.close();
        }
    }
}


