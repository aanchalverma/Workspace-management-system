import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Random;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;

import javax.swing.*;  
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
public class Registration extends JFrame {  
	static Container contain;
	JLayeredPane layer;
	JPanel logPanel;
	JPanel botPanel;
	
	Font f = new Font("Arial", Font.BOLD, 15);
	Font f1 = new Font("Tahoma", Font.BOLD, 14);

	public static void main(String[] args)
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		new Registration().setVisible(true);  
		
	}
	Registration(){
		background1();
		login();
	}
	public void background1()
	{	
		setTitle("Registration");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contain = getContentPane();
		contain.setLayout(new BorderLayout());
		contain.setBackground(Color.WHITE);
		ImageIcon i = new ImageIcon("C:/inspire/SmallLogo.png");
		botPanel = new JPanel();
		JLabel l = new JLabel(i);
		botPanel.add(l, BorderLayout.CENTER);
		botPanel.setBounds(500,50, 1366, 735);
		botPanel.setBackground(Color.WHITE);
		layer = new JLayeredPane();
		layer.setLayout(null);
		layer.add(botPanel, Integer.valueOf(1));
	}
		public void login(){

	JTextField t1,t2;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	logPanel = new JPanel();
	logPanel.setBackground(Color.WHITE);
	logPanel.setLayout(null);
	String services[]={"PLUG-IN OFFICE","VIRTUAL OFFICE","CUSTOM OFFICE"};
	String Location[]={"MARATHAHALLI","KORMANGALA","HAL","VV PURAM","INDIRANAGAR","MG ROAD"};
    l2=new JLabel("Company Name:");  
    l2.setBounds(70,100, 200,30);  
    t1=new JTextField("Enter Company Name"); 
    t1.setBounds(270,100,200,30);  
    l3=new JLabel("Service Name:"); 
    l3.setBounds(70,150,200,30);
    JComboBox<String> cb1=new JComboBox<>(services); 
    cb1.setBounds(270,155,200,30);
    JButton b2= new JButton("Details");
    b2.setBounds(480,155,100,30);
    l4=new JLabel("Contract Period:");  
    l4.setBounds(70,200,200,30);  
    t2=new JTextField("Enter Contract Period");  
    t2.setBounds(270,200,200,30);  
    l5=new JLabel("Branch Location:");
    l5.setBounds(70,250,200,30);
    JComboBox<String> cb2=new JComboBox<>(Location);
    cb2.setBounds(270,250,200,30);   
    l6=new JLabel("Set Password:");
    l6.setBounds(70,300,200,30);
    JPasswordField t3 = new JPasswordField(); 
    t3.setBounds(270,300, 200,30);  
    l7=new JLabel("Confirm Password:");
    l7.setBounds(70,350,200,30);
    JPasswordField t4 = new JPasswordField(); 
    t4.setBounds(270,350, 200,30);  
    logPanel.add(t1); logPanel.add(t2); //logPanel.add(b2);
    logPanel.add(l2); logPanel.add(t4);
    logPanel.add(l3); logPanel.add(l4); logPanel.add(t3);  
    logPanel.add(l5); logPanel.add(l6); logPanel.add(l7);
    t1.setFont(new Font("Tahoma",Font.PLAIN,16));
    cb2.setFont(new Font("Tahoma",Font.PLAIN,16));
    cb1.setFont(new Font("Tahoma",Font.PLAIN,16));
    t2.setFont(new Font("Tahoma",Font.PLAIN,16));
    t4.setFont(new Font("Tahoma",Font.PLAIN,16));
    t3.setFont(new Font("Tahoma",Font.PLAIN,16));
    l2.setFont(new Font("Tahoma",Font.BOLD,20));
    l3.setFont(new Font("Tahoma",Font.BOLD,20));
    l4.setFont(new Font("Tahoma",Font.BOLD,20));
    l5.setFont(new Font("Tahoma",Font.BOLD,20));
    l6.setFont(new Font("Tahoma",Font.BOLD,20));
    l7.setFont(new Font("Tahoma",Font.BOLD,20));
    b2.setFont(new Font("Tahoma",Font.BOLD,16));
    b2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e){
    		TOS.main(new String[]{});
    	}
    });
    JButton b1=new JButton("REGISTER");  
    b1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e)
    	{
    		try {
    			int bid=0;
    			Connection con=DB.getConnection();
    			 String cname=t1.getText();
    			  String serv = (String)cb1.getSelectedItem();
	    		  String value = cb1.getSelectedItem().toString();
	    		  String per =t2.getText();
	    			int t2=Integer.parseInt(per);
	    			String branch = (String)cb2.getSelectedItem();
		    		  String value2 = cb2.getSelectedItem().toString();
		    		  String password=String.valueOf(t3.getPassword());
		    		  int p=Integer.parseInt(password);
		    		  String pwd=String.valueOf(t4.getPassword());
		    		  String query="select b_id from branch where b_loc='"+value2+"';";
		    		  Statement s=con.createStatement();
		    			ResultSet result=s.executeQuery(query);
		    			if(result.next())
		    			{
		    					bid= result.getInt(1);
		    			}
		    		    String query1="select Max(C_id) from company;";
		    		    Statement sa=con.createStatement();
		    			ResultSet result1=sa.executeQuery(query1);
		    			int cid=0;
		    			if(result1.next())
		    			{
		    		     cid= result1.getInt(1);
		    		//System.out.println(bid);
		    		    }
		    		
		    			cid=cid+10;
		    			
		    			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		    			Date dt1 = new Date();
		    			Date dt2 = new Date();
		    			Calendar c = Calendar.getInstance(); 
		    			c.setTime(dt2); 
		    			c.add(Calendar.YEAR, t2);
		    			dt2 = c.getTime();
		    			java.sql.Date sqlDate1 = new java.sql.Date(dt1.getTime());
		    		    java.sql.Date sqlDate2 = new java.sql.Date(dt2.getTime());
		    			if(pwd.equals(password))
		    			{
		    				  String query2 = "insert into COMPANY(B_ID,C_ID,CMP_NAME,CMP_SPERIOD,CMP_EPERIOD,SERVICE_NAME,CMP_PWD) values(?,?,?,?,?,?,?);";
		    		  		  PreparedStatement ps=con.prepareStatement(query2);
		    						ps.setInt(1,bid);
		    						ps.setInt(2,cid);
		    						ps.setString(3,cname);
		    						ps.setDate(4,sqlDate1);
		    						ps.setDate(5,sqlDate2);
		    						ps.setString(6,value);
		    						ps.setInt(7,p);
		    						ps.executeUpdate();
		    						JOptionPane.showMessageDialog(logPanel,"Successfully Registered \n Your Company ID is:"+cid);
		    						LoginCustomer.main(new String[]{});
		    						dispose();
		  				}
		  				else
		  				{
		  					JOptionPane.showMessageDialog(logPanel,"Invalid Password");
		  					Registration.main(new String[]{});
		  		      		dispose();
		  				}
		    			}
    		
	    	  
	    	  catch(Exception arg){System.out.println(arg);}
	      }
  });
    b1.setBounds(50,400,200,50);  
    b1.setFont(new Font("Tahoma",Font.BOLD,20));
    JButton b3= new JButton("BACK");
    b3.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e)
      	{
      		Welcome.main(new String[]{});
      		dispose();
      	}
      });
     b3.setBounds(400,400,200,50);//400 width and 500 height  
     b3.setFont(new Font("Tahoma",Font.BOLD,20));
     logPanel.add(b3); logPanel.add(b2);
    logPanel.add(b1); logPanel.add(cb2); logPanel.add(cb1);
    logPanel.add(b1); logPanel.add(b2);
		logPanel.setOpaque(false);
		logPanel.setBounds(400, 200, 600, 735);
		Cursor cur = new Cursor(Cursor.HAND_CURSOR);
		b1.setCursor(cur);
		b2.setCursor(cur);
		b3.setCursor(cur);
		layer.add(logPanel, Integer.valueOf(2));
		add(layer);
}  
}  
