import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Customer extends JFrame {
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
			new Customer().setVisible(true);
		}
		Customer()
		{
			background1();
			cust();
		}
		public void background1()
		{	
			setTitle("Customer Logged-In");
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setLayout(new BorderLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			contain = getContentPane();
			contain.setBackground(Color.WHITE);
			contain.setLayout(new BorderLayout());
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
		public void cust(){
			logPanel = new JPanel();
			logPanel.setBackground(Color.WHITE);
			logPanel.setLayout(null);
			JButton B1= new JButton("VIEW EMPLOYEES");
			B1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		ViewEmployee.main(new String[]{});
        		dispose();
        	}
        });
       B1.setFont(new Font("Tahoma",Font.PLAIN,20));
        B1.setBounds(50,50,300,50);//400 width and 500 height  
        logPanel.add(B1);
      
       
	
        JButton B3= new JButton("SERVICE ENQUIRY");
        B3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		TOS.main(new String[]{});
        	}
        });

        B3.setFont(new Font("Tahoma",Font.PLAIN,20));
         B3.setBounds(50,120,300,50);//400 width and 500 height  
         logPanel.add(B3);
         
         JButton B4= new JButton("BOOKING");
         B4.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e)
         	{
         		SS.main(new String[]{});
         		dispose();
         	}
         });

         B4.setFont(new Font("Tahoma",Font.PLAIN,20));
          B4.setBounds(50,190,300,50);//400 width and 500 height  
          logPanel.add(B4);
          
          JButton B5= new JButton("ADD EMPLOYEE");
          B5.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e)
          	{
          		AddEmp.main(new String[]{});
          		dispose();
          	}
          });

          B5.setFont(new Font("Tahoma",Font.PLAIN,20));
           B5.setBounds(50,260,300,50);//400 width and 500 height  
           logPanel.add(B5);
           
        
           
           JButton B6= new JButton("REMOVE EMPLOYEE");
           B6.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent e)
           	{
           		RemEmp.main(new String[]{});
           		dispose();
           	}
           });

           B6.setFont(new Font("Tahoma",Font.PLAIN,20));
            B6.setBounds(50,330,300,50);//400 width and 500 height  
            logPanel.add(B6);
            
            
            JButton B7= new JButton("LOGOUT");
            B7.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e)
            	{
            		Registered.main(new String[]{});
            		dispose();
            	}
            });

            B7.setFont(new Font("Tahoma",Font.PLAIN,20));
             B7.setBounds(50,400,300,50);//400 width and 500 height
             Cursor cur = new Cursor(Cursor.HAND_CURSOR);
     		B1.setCursor(cur);
     		B3.setCursor(cur);
     		B4.setCursor(cur);
     		B5.setCursor(cur);
     		B6.setCursor(cur);
     		B7.setCursor(cur);
            logPanel.add(B7);
            logPanel.setBounds(500, 200, 600, 735);
            logPanel.setOpaque(false);
         	layer.add(logPanel, Integer.valueOf(2));
         	add(layer);
             
		
	}

}

