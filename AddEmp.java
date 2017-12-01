import java.awt.*;
import java.util.Random; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.sql.PreparedStatement;
public class AddEmp extends JFrame
{
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
		new AddEmp().setVisible(true);
	}
	AddEmp()
	{
		background1();
		add();
	}
	public void background1()
	{	
		setTitle("Add Employee");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contain = getContentPane();
		contain.setBackground(Color.WHITE);
		contain.setLayout(new BorderLayout());
		ImageIcon i = new ImageIcon("C:/inspire/Add.png");
		botPanel = new JPanel();
		JLabel l = new JLabel(i);
		botPanel.add(l, BorderLayout.CENTER);
		botPanel.setBounds(0,400, 600, 735);
		botPanel.setBackground(Color.WHITE);
		layer = new JLayeredPane();
		layer.setLayout(null);
		layer.add(botPanel, Integer.valueOf(1));
	}
	public void add(){
		logPanel = new JPanel();
		logPanel.setBackground(Color.WHITE);
		logPanel.setLayout(null);
		JLabel l1= new JLabel("Employee name:");
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		l1.setBounds(50,50,250,50);
		l1.setFont(new Font("Arial", Font.BOLD, 20));
		logPanel.add(l1);
		JTextField t1,t2,t3;
		t1= new JTextField("Enter employee name:");
		t1.setBounds(250,50,300,50);
		t1.setFont(new Font("Arial", Font.BOLD, 22));
		logPanel.add(t1);	   
		JLabel l2= new JLabel("Employee contact:");
		l2.setFont(new Font("Tahoma",Font.PLAIN,20));
		l2.setBounds(50,150,250,50);
		l2.setFont(new Font("Arial", Font.BOLD, 22));
		logPanel.add(l2);
		t2= new JTextField("Enter employee contact:");
		t2.setBounds(250,150,300,50);
		t2.setFont(new Font("Arial", Font.BOLD, 22));
		logPanel.add(t2); 
       JLabel l3= new JLabel("Company id:");
       l3.setFont(new Font("Tahoma",Font.PLAIN,20));
       l3.setBounds(50,250,250,50);
       l3.setFont(new Font("Arial", Font.BOLD, 22));
       logPanel.add(l3);
       t3= new JTextField("Enter company id:");
       t3.setBounds(250,250,300,50);
       t3.setFont(new Font("Arial", Font.BOLD, 22));
       logPanel.add(t3);
       JButton B2= new JButton("BACK");
       B2.setBounds(350,350,120,60);
       B2.setFont(new Font("Arial", Font.BOLD, 22)); 
       logPanel.add(B2);
       
       B2.addActionListener(new ActionListener() 
       {
  	      public void actionPerformed(ActionEvent e) 
  	      {
  	    	Customer.main(new String[]{});
  	    	dispose();
  	      }
       });

       JButton B3= new JButton("ADD EMPLOYEE");
       B3.setBounds(50,350,250,60);
       B3.setFont(new Font("Arial", Font.BOLD, 22));
       B3.addActionListener(new ActionListener() 
       {     
  	      public void actionPerformed(ActionEvent e)
  	      {
  	    	  
  	    	  try 
  	    	  {
  	    		Connection con =DB.getConnection();
  	    		String ename=t1.getText();
  	    		String econ=t2.getText();
  	    		String cid=t3.getText();
  	    		String query1="select Max(Emp_id) from Employee;";
	    	    Statement sa=con.createStatement();
	    		ResultSet result1=sa.executeQuery(query1);
	   			int empid=0;
	   			if(result1.next())
	   			{
	    		    empid= result1.getInt(1);
	    		//System.out.println(bid);
	   			}
	    		empid=empid+1;
  	    		String query="insert into EMPLOYEE(C_ID,EMP_ID,EMP_NAME,EMP_CON) values(?,?,?,?);";
  				PreparedStatement ps=con.prepareStatement(query);
  				ps.setString(1,cid);
  				ps.setInt(2,empid);
  				ps.setString(3,ename);
  				ps.setString(4,econ);
  				ps.executeUpdate();
  				int a= JOptionPane.showConfirmDialog(logPanel,"Add new employee?");
  				if(a==JOptionPane.YES_OPTION) 
  				{
  	    		  JOptionPane.showMessageDialog(logPanel,"Employee is added");
  	    		  int b= JOptionPane.showConfirmDialog(logPanel,"Add another employee?");
  	    		  if(b==JOptionPane.YES_OPTION) 
  	    		  {
  	    			AddEmp.main(new String[]{});
  	    		  }
  				}
  				else if(a==JOptionPane.NO_OPTION)
  				{
  					AddEmp.main(new String[]{});
  				}
  	    	  }
  	    	  catch(Exception arg){System.out.println(arg);}
  	      }
    });
       Cursor cur = new Cursor(Cursor.HAND_CURSOR);
		B2.setCursor(cur);
		B3.setCursor(cur);
	logPanel.add(B3); 
    logPanel.setBounds(600, 0, 600, 735);
	layer.add(logPanel, Integer.valueOf(2));
	add(layer);
      
       
	}

}