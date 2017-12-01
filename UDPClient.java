import java.net.*;
import java.io.*;

public class UDPClient
{
	public static void main(String args[])
	{
		DatagramSocket aSocket=null;
		int clientPort=998;
		try
		{
			aSocket=new DatagramSocket(clientPort);
			byte[] buf=new byte[1000];
			//byte[] buf1=new byte[1000];
			
			DatagramPacket data=new DatagramPacket(buf,buf.length);
			System.out.println("Waiting for server\n");
			//buf1=conf.getBytes();
			
			//DatagramPacket data1=new DatagramPacket(buf1,buf1.length,InetAddress.getLocalHost(),999);
			//aSocket.send(data1);
			//System.out.println("Connected to server");
			//System.out.println("\n msg:");
			aSocket.receive(data);
			byte[] msg=new byte[1000];
			msg=data.getData();
			System.out.println("\n msg:"+(new String(msg,0,data.getLength())));
			//aSocket.receive(data);
			//msg=data.getData();
			
			//System.out.println(new String(msg,0,data.getLength()));
		}
		catch(SocketException e)
		{
			System.out.println("Socket:" +e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println("IO:" +e.getMessage());
		}
		finally
		{
			if(aSocket!=null)
				aSocket.close();
		}
	}
}


 

