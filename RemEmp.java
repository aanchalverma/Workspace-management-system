import java.sql.PreparedStatement;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;
public class RemEmp extends JFrame {
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
		new RemEmp().setVisible(true);
	}
	RemEmp()
	{
		background1();
		rem();
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
		ImageIcon i = new ImageIcon("C:/inspire/remove.png");
		botPanel = new JPanel();
		JLabel l = new JLabel(i);
		botPanel.add(l, BorderLayout.CENTER);
		botPanel.setBounds(0,400, 600, 735);
		botPanel.setBackground(Color.WHITE);
		layer = new JLayeredPane();
		layer.setLayout(null);
		layer.add(botPanel, Integer.valueOf(1));
	}
	public void rem(){
		logPanel = new JPanel();
		logPanel.setBackground(Color.WHITE);
		logPanel.setLayout(null);
      
       JLabel l1= new JLabel("Employee ID");
       l1.setFont(new Font("Tahoma",Font.BOLD,20));
       l1.setBounds(100,50,250,50);
      logPanel.add(l1);
       JTextField t1,t2;
       t1= new JTextField();
       t1.setFont(new Font("Tahoma",Font.PLAIN,20));
       t1.setBounds(250,50,200,50);
       logPanel.add(t1);
      
      

       JButton B3= new JButton("Remove Employee");

       B3.setFont(new Font("Tahoma",Font.BOLD,20));
        B3.setBounds(150,200,300,50);//400 width and 500 height  
        
      B3.addActionListener(new ActionListener() {
    	      @Override
    	      public void actionPerformed(ActionEvent e) {
    	    	  try {
    	    	  
    	    	  
    	    	  Connection con =DB.getConnection();
    	    	  String s1= t1.getText();
    	    	  if(s1==null)
    	    	  {
    	    		  JOptionPane.showMessageDialog(logPanel,"Enter the id");
    	    		  RemEmp.main(new String[]{});
    	        		dispose();
    	    	  }
    	    	  String query= "DELETE FROM EMPLOYEE WHERE EMP_ID=?;";
    				PreparedStatement ps=con.prepareStatement(query);
    				ps.setString(1,s1);
    				ps.executeUpdate();
    	    	  
    	    	  
    	    	 int a= JOptionPane.showConfirmDialog(logPanel,"Remove employee?");
    	    	  if(a==JOptionPane.YES_OPTION) {
    	    		  JOptionPane.showMessageDialog(logPanel,"Employee is removed");
    	    		  Customer.main(new String[]{});
    	    		  dispose();
    	    	  }
    	    	  }
    	    	  catch(Exception arg){System.out.println(arg);}
    	    		  
    	    			  
    	      
      }
      });
      JButton b4= new JButton("BACK");
      b4.setFont(new Font("Tahoma",Font.BOLD,20));
      b4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		Customer.main(new String[]{});
        		dispose();
        	}
        });
       b4.setBounds(150,270,300,50);//400 width and 500 height  
       logPanel.add(b4);
       logPanel.add(B3);
       Cursor cur = new Cursor(Cursor.HAND_CURSOR);
		b4.setCursor(cur);
		B3.setCursor(cur);
   logPanel.setBounds(600, 200, 600, 735);
	layer.add(logPanel, Integer.valueOf(2));
	add(layer);
	
      }

	}

