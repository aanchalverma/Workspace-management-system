import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.*;
//import java.sql.Date;

import javax.swing.*;  
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
public class UpdateBill extends JFrame {  
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
		new UpdateBill().setVisible(true);  
		
	}
	UpdateBill(){
		background1();
		bill();
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
		public void bill(){
	JTextField t1;
	JLabel l1,l2,l3,l4,l5;
	logPanel = new JPanel();
	logPanel.setBackground(Color.WHITE);
	logPanel.setLayout(null);
    l1=new JLabel("UPDATE BILL");  
    l1.setForeground(Color.BLACK);
	l1.setFont(new Font("Tahoma", Font.PLAIN, 36));
    l1.setBounds(250,50, 200,30);  
    l2=new JLabel("Enter Company ID");  
    l2.setBounds(10,100, 200,30);  
    t1=new JTextField();  
    t1.setBounds(250,100, 200,30);  
    l3=new JLabel("Enter Bill Amount");
    l3.setBounds(10,150,200,30);
    JTextField t2 = new JTextField(); 
    t2.setBounds(250,150, 200,30);  
    l4=new JLabel("Enter Date");
    l4.setBounds(10,200,200,30);
    JTextField t3 = new JTextField(); 
    t3.setBounds(250,200, 200,30);  
    l5=new JLabel("Enter Type");
    l5.setBounds(10,250,200,30);
    JTextField t4 = new JTextField(); 
    t4.setBounds(250,250, 200,30);  
    logPanel.add(t1); logPanel.add(t2);  logPanel.add(t3); logPanel.add(t4);
    logPanel.add(l1); logPanel.add(l2);logPanel.add(l3); logPanel.add(l4); logPanel.add(l5); 
    JButton b=new JButton("UPDATE");  
    b.setBounds(70,320,200,50);  
    logPanel.add(b);
    b.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e)
    	{
    		try
    		{
    			Connection con=DB.getConnection();
    			// DateFormat formatter = new DateFormat("MM/dd/yyyy");
    			String q1,q2,q3,q4;
    			String cid=t1.getText();
    			int cid1=Integer.parseInt(cid);
    			String bamt=t2.getText();
    			int bamt1=Integer.parseInt(bamt);
    			String date=t3.getText();
    			//Date d= formatter.parse(date);
    			//Date date1=new SimpleDateFormat("yyyy/mm/dd").parse(date);
    			SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd");
    			Date parsed = format.parse(date);
    			java.sql.Date sql = new java.sql.Date(parsed.getTime());
    			String type=t4.getText();
    			int type2=Integer.parseInt(type);
    			 String query1="select Max(Bill_id) from Billing;";
	    		    Statement sa=con.createStatement();
	    			ResultSet result1=sa.executeQuery(query1);
	    			int billid=0;
	    			if(result1.next())
	    			{
	    		     billid= result1.getInt(1);
	    		//System.out.println(bid);
	    		    }
	    			System.out.println(cid);
	    			billid=billid+1;
    			String query="insert into BILLING(BILL_ID,TYPE,C_ID,BCOST,BDATE) values(?,?,?,?,?);";
  				PreparedStatement ps=con.prepareStatement(query);
  				ps.setInt(1,billid);
  				ps.setInt(2,type2);
  				ps.setInt(3,cid1);
  				ps.setInt(4,bamt1);
  				ps.setDate(5,sql);
  				ps.executeUpdate();
  				JOptionPane.showMessageDialog(logPanel,"Bill Updated");
  				dispose();
    			
    		}
    		
    		catch(Exception arg){System.out.println(arg);}
    	}
    });
    JButton b1= new JButton("BACK");
    b1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e)
      	{
      		Inspire.main(new String[]{});
      		dispose();
      	}
      });
    t1.setFont(new Font("Tahoma",Font.PLAIN,16));
    t2.setFont(new Font("Tahoma",Font.PLAIN,16));
    t4.setFont(new Font("Tahoma",Font.PLAIN,16));
    t3.setFont(new Font("Tahoma",Font.PLAIN,16));
    l2.setFont(new Font("Tahoma",Font.BOLD,20));
    l3.setFont(new Font("Tahoma",Font.BOLD,20));
    l4.setFont(new Font("Tahoma",Font.BOLD,20));
    l5.setFont(new Font("Tahoma",Font.BOLD,20));
    l1.setFont(new Font("Tahoma",Font.BOLD,20));
    b.setFont(new Font("Tahoma",Font.BOLD,20));
    b1.setFont(new Font("Tahoma",Font.BOLD,20));
     b1.setBounds(300,320,200,50);//400 width and 500 height  
     	logPanel.add(b1);
 		logPanel.setOpaque(false);
 		logPanel.setBounds(400, 200, 600, 735);
 		Cursor cur = new Cursor(Cursor.HAND_CURSOR);
 		b.setCursor(cur);
 		b1.setCursor(cur);
 		layer.add(logPanel, Integer.valueOf(2));
 		add(layer);   
}  
}  