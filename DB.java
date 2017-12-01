import java.sql.Connection;
import java.sql.DriverManager;


public  class DB {

	
		 
		 
		public static void main(String args[]){  
			getConnection();
		}
		
		
		public static Connection getConnection()
		{
			Connection con =null;
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		
		 con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/aanchal?autoReconnect=true&useSSL=false","root","@nchAl5198");
		//System.out.println("Connection Established");
		//con.close();  
		}catch(Exception e){ System.out.println(e);}  
		/*if(con!= null)
			System.out.println("connection done");
		else
			System.out.println("connection not done");*/
		return con;
		}  
		

	

}
