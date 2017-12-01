import java.awt.event.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import javax.swing.*;  
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
public class SS extends JFrame {  
	static Container contain;
	JLayeredPane layer;
	JPanel logPanel;
	JPanel botPanel;
	public static void main(String[] args) 
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		new SS().setVisible(true);
	}
	SS()
	{
		background1();
		special();
	}
	public void background1()
	{	
		setTitle("Special Service");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contain = getContentPane();
		contain.setBackground(Color.WHITE);
		contain.setLayout(new BorderLayout());
		ImageIcon i = new ImageIcon("C:/inspire/meeting.png");
		botPanel = new JPanel();
		JLabel l = new JLabel(i);
		botPanel.add(l, BorderLayout.CENTER);
		botPanel.setBounds(00,0, 1366, 735);
		botPanel.setBackground(Color.WHITE);
		layer = new JLayeredPane();
		layer.setLayout(null);
		layer.add(botPanel, Integer.valueOf(1));
	}
	public void special(){ 
	JTextField t1,t2,t3;
	JLabel l1,l2,l3,l4,l5,l6;
	String RoomType[]={"SMALL","MEDIUM","LARGE","EXTRA LARGE"};
	String Location[]={"MARATHAHALLI","KORMANGALA","HAL","VV PURAM","INDIRANAGAR","MG ROAD"};
	logPanel = new JPanel();
	logPanel.setBackground(Color.WHITE);
	logPanel.setLayout(null);
	l6=new JLabel("Enter Company ID:");  
	l6.setBounds(70,100, 200,30);
	t3= new JTextField("Enter Company ID");
	t3.setBounds(280,100,200,30);
    l2=new JLabel("Room Type:");  
    l2.setBounds(70,150, 200,30); 
    JComboBox<String> cb1=new JComboBox<>(RoomType);
    cb1.setBounds(280,150,200,30);
    JButton b3=new JButton("Details");  
    b3.setBounds(490,150,100,30);  
    b3.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e){
    		JOptionPane.showMessageDialog(logPanel,"Small Capacity = 5 \n Medium Capacit = 10 \n Large Capacity = 20 \n ExtraLarge = 50" );
    		
    	}
    });
    l4= new JLabel("Capacity");
    l4.setBounds(70,200,200,30);
    t1= new JTextField("Enter Capacity");
    t1.setBounds(280,200,200,30);
    l5= new JLabel("Date");
    l5.setBounds(70,250,200,30);
    t2= new JTextField("Enter Date (YYYY-MM-DD)");
    t2.setBounds(280,250,200,30);
    l3=new JLabel("Branch:");
    l3.setBounds(70,300,100,30);
    JComboBox<String> cb2=new JComboBox<>(Location);
    cb2.setBounds(280,300,200,30);    
    JButton b=new JButton("Check Availability");  
    b.setBounds(50,350,200,50);  
    JButton b1=new JButton("Back");  
    b1.setBounds(280,350,170,50);  
    b1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e)
      	{
      		Customer.main(new String[]{});
      		dispose();
      	}
      });
    b.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  
	    	  try {
	    		  	int bid=0;
	    		  Connection con=DB.getConnection();
	    		  String rt = (String)cb1.getSelectedItem();
	    		  String value = cb1.getSelectedItem().toString();
	    		  String capacity=t1.getText();
	    		  int cap=Integer.parseInt(capacity);
	    		  int count=0;
	    		  if(value=="SMALL")
	    		  {
	    			  if(cap>5)
	    			  {
	    				  JOptionPane.showMessageDialog(logPanel,"Capacity Exceeded" );
	    				  SS.main(new String[]{});
	    		      		dispose();
	    			  }
	    			  else
	    			  {
	    				  count++;
	    			  }
	    		  }
	    		  else if(value=="MEDIUM")
	    		  {
	    			  if(cap>10)
	    			  {
	    				  JOptionPane.showMessageDialog(logPanel,"Capacity Exceeded" );
	    				  SS.main(new String[]{});
	    		      		dispose();
	    			  }
	    			  else
	    			  {
	    				  count++;
	    			  }
	    		  }
	    		  else if(value=="LARGE")
	    		  {
	    			  if(cap>20)
	    			  {
	    				  JOptionPane.showMessageDialog(logPanel,"Capacity Exceeded" );
	    				  SS.main(new String[]{});
	    		      		dispose();
	    			  }
	    			  else
	    			  {
	    				  count++;
	    			  }
	    		  }
	    		  
	    		  else if(value=="EXTRA LARGE")
	    		  {
	    			  if(cap>50)
	    			  {
	    				  JOptionPane.showMessageDialog(logPanel,"Capacity Exceeded" );
	    				  SS.main(new String[]{});
	    		      		dispose();
	    			  }
	    			  else
	    			  {
	    				  count++;
	    			  }
	    		  }
	    		  if(count>0){
	    		  String cid=t3.getText();
	    		  int t1=Integer.parseInt(capacity);
	    		  String date=t2.getText();
	    		  String sdate="",edate="";
	    		  String loc = (String)cb2.getSelectedItem();
	    		  String value2 = cb2.getSelectedItem().toString();
	    		  //System.out.println(value2);
	    		  String query11="select cmp_speriod from company;";
	    		    Statement sa11=con.createStatement();
	    			ResultSet result11=sa11.executeQuery(query11);
	    			if(result11.next())
	    			{
	    		     sdate= result11.getString(1);
	    		     System.out.println(sdate);
	    		    }
	    			String query12="select cmp_eperiod from company;";
	    		    Statement sa12=con.createStatement();
	    			ResultSet result12=sa12.executeQuery(query12);
	    			if(result12.next())
	    			{
	    		     edate= result12.getString(1);
	    		     System.out.println(edate);
	    		    }
	    		  String query1="select Max(Book_id) from Booking;";
	    		    Statement sa=con.createStatement();
	    			ResultSet result1=sa.executeQuery(query1);
	    			int bookid=0;
	    			if(result1.next())
	    			{
	    		     bookid= result1.getInt(1);
	    		//System.out.println(bid);
	    		    }
	    			
	    			bookid=bookid+1;
	    		  String query="select b_id from branch where b_loc='"+value2+"';";
	    		  Statement s=con.createStatement();
	    			ResultSet result=s.executeQuery(query);
	    			if(result.next())
	    			{
	    		bid= result.getInt(1);
	    		//System.out.println(bid);
	    		}
	    		String q2="select bdate from booking where b_id="+bid+" and room_type='"+value+"';";
	    		 Statement s2=con.createStatement();
	    			ResultSet result2=s2.executeQuery(q2);
	    			int flag=0;
	    			Date date1= new Date();
	    			Date date2= new Date();
	    			String sdt;
	    			java.sql.Date sqlDate1 = null;
	    			if((sdate.compareTo(date)<0)&&(edate.compareTo(date)>0)){
	    			while(result2.next())
	    			{
	    				date1=new SimpleDateFormat("dd-MM-yyy").parse(date);  
		    			date2=result2.getDate("bdate");
		    			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    			sdt = df.format((date2));
		    			date1 = (Date) df.parse(date);
		    			sqlDate1 = new java.sql.Date(date1.getTime());
		    			if(date.equals(sdt))
		    			{
		    				flag=1;
		    				//System.out.println("Flag");
		    			}
	    			
	    			if(flag==1)
	    			{
	    				JOptionPane.showMessageDialog(logPanel,"Sorry,Date Not Available \n Please check for another date");
						dispose();
						SS.main(new String[]{});
	    				
	    			}
	    			else{	
	    				int a= JOptionPane.showConfirmDialog(logPanel,"Available \n Book?");
		    	    	  if(a==JOptionPane.YES_OPTION){
		    			String query2="insert into BOOKING(BOOK_ID,B_ID,C_ID,BDATE,ROOM_TYPE) values(?,?,?,?,?);";
		  				PreparedStatement ps=con.prepareStatement(query2);
		  				ps.setInt(1,bookid);
		  				ps.setInt(2,bid);
		  				ps.setString(3,cid);
		  				ps.setDate(4,sqlDate1);
		  				ps.setString(5,value);
		  				ps.executeUpdate();
		  				JOptionPane.showMessageDialog(logPanel,"Booking Completed Successfully \n Your Booking ID is: "+bookid);
		    	    		  Customer.main(new String[]{});
								dispose();
		    	    		  }
		    	    	  else if(a==JOptionPane.NO_OPTION)
		    	    		  SS.main(new String[]{});
	    			}
	    			}
	    		  }else{
	    				JOptionPane.showMessageDialog(logPanel,"Date not within contract period");
	    	    		  SS.main(new String[]{});
							dispose();
	    		  }
	    		  }
	    			
	      }
	    	  catch(Exception arg){System.out.println(arg);}
	      }
    });
    t1.setFont(new Font("Tahoma",Font.PLAIN,16));
    cb2.setFont(new Font("Tahoma",Font.PLAIN,16));
    cb1.setFont(new Font("Tahoma",Font.PLAIN,16));
    t2.setFont(new Font("Tahoma",Font.PLAIN,16));
    t3.setFont(new Font("Tahoma",Font.PLAIN,16));
    l2.setFont(new Font("Tahoma",Font.BOLD,20));
    l3.setFont(new Font("Tahoma",Font.BOLD,20));
    l4.setFont(new Font("Tahoma",Font.BOLD,20));
    l5.setFont(new Font("Tahoma",Font.BOLD,20));
    l6.setFont(new Font("Tahoma",Font.BOLD,20));
    b1.setFont(new Font("Tahoma",Font.BOLD,20));
    b.setFont(new Font("Tahoma",Font.BOLD,16));
    b3.setFont(new Font("Tahoma",Font.BOLD,16));
    Cursor cur = new Cursor(Cursor.HAND_CURSOR);
		b.setCursor(cur);
		b1.setCursor(cur);
		b3.setCursor(cur);
    logPanel.add(l2);logPanel.add(l3); logPanel.add(l4); logPanel.add(t1); logPanel.add(l5); logPanel.add(l6);
    logPanel.add(t3);
    logPanel.add(cb1); logPanel.add(cb2); logPanel.add(t2); logPanel.add(b1); logPanel.add(b3);
    logPanel.add(b);  
    logPanel.setBounds(500, 200, 600, 735);
    logPanel.setOpaque(false);
 	layer.add(logPanel, Integer.valueOf(2));
 	add(layer);
}  
}  