import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Inspire extends JFrame {
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
			new Inspire().setVisible(true);
		}
		Inspire()
		{
			background1();
			manage();
		}
		public void background1()
		{	
			setTitle("Manager Logged-In");
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
		public void manage(){
			logPanel = new JPanel();
			logPanel.setBackground(Color.WHITE);
			logPanel.setLayout(null);
			JButton B3= new JButton("VIEW CUSTOMERS");
			B3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		ViewCustomers.main(new String[]{});
        		dispose();
        	}
			}); 

			B3.setFont(new Font("Tahoma",Font.PLAIN,20));
			B3.setBounds(20,150,350,50);//400 width and 500 height  
			logPanel.add(B3);
         
			JButton B4= new JButton("VIEW SECURITY");
			B4.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent e)
           	{
           		ViewSecurity.main(new String[]{});
           		dispose();
           	}
			});

			B4.setFont(new Font("Tahoma",Font.PLAIN,20));
			B4.setBounds(430,150,350,50);//400 width and 500 height  
			logPanel.add(B4);
          
			JButton B5= new JButton("VIEW HOUSEKEEP");
			B5.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e)
          	{
          		ViewHousekeep.main(new String[]{});
          		dispose();
          	}
			});

			B5.setFont(new Font("Tahoma",Font.PLAIN,20));
			B5.setBounds(20,220,350,50);//400 width and 500 height  
			logPanel.add(B5);
           	
        
            JButton B7= new JButton("PREVIOUS TRANSACTIONS");
            B7.addActionListener(new ActionListener() {
              	public void actionPerformed(ActionEvent e)
              	{
              		ViewBill.main(new String[]{});
              		dispose();
              	}
            });

             B7.setFont(new Font("Tahoma",Font.PLAIN,20));
             B7.setBounds(430,220,350,50);//400 width and 500 height  
             logPanel.add(B7);
             
             
             JButton B8= new JButton("NEW TRANSACTION");
             B8.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent e)
             	{
             		UpdateBill.main(new String[]{});
             		dispose();
             	}
             });

             B8.setFont(new Font("Tahoma",Font.PLAIN,20));
              B8.setBounds(20,290,350,50);//400 width and 500 height  
              logPanel.add(B8);
              
              
              JButton B9= new JButton("LOGOUT");
              B9.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e)
                	{
                		Registered.main(new String[]{});
                		dispose();
                	}
                });
              B9.setFont(new Font("Tahoma",Font.PLAIN,20));
               B9.setBounds(430,290,350,50);
               Cursor cur = new Cursor(Cursor.HAND_CURSOR);
        		B3.setCursor(cur);
        		B4.setCursor(cur);
        		B5.setCursor(cur);
        		B7.setCursor(cur);
        		B5.setCursor(cur);
        		B8.setCursor(cur);
        		B9.setCursor(cur);
               logPanel.add(B9);
               logPanel.setBounds(300, 200, 900, 735);
               logPanel.setOpaque(false);
           		layer.add(logPanel, Integer.valueOf(2));
           		add(layer);
	}

}