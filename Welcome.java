import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Welcome extends JFrame {
	static Container contain;
	JLayeredPane layer;
	JPanel logPanel;
	JPanel botPanel;
	
	Font f = new Font("Arial", Font.PLAIN, 15);
	Font f1 = new Font("Tahoma", Font.BOLD, 14);

	public static void main(String[] args)
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		new Welcome().setVisible(true);  
		
	}
	Welcome(){
		background1();
		login();
	}
	public void background1()
	{	
		setTitle("Welcome");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contain = getContentPane();
		contain.setLayout(new BorderLayout());
		ImageIcon i = new ImageIcon("C:/inspire/InspireLogo.png");
		botPanel = new JPanel();
		JLabel l = new JLabel(i);
		botPanel.add(l, BorderLayout.CENTER);
		botPanel.setBounds(0, 0, 1366, 735);
		botPanel.setBackground(Color.WHITE);
		layer = new JLayeredPane();
		layer.setLayout(null);
		layer.add(botPanel, Integer.valueOf(1));
	}
		public void login(){

			logPanel = new JPanel();
			logPanel.setBackground(Color.WHITE);
			logPanel.setLayout(null);
			JButton b1=new JButton("Customer");  
			b1.setBounds(70,100,200,60);
			b1.setFocusPainted(false);
			b1.setForeground(Color.BLACK);
			b1.setFont(new Font("Arial", Font.BOLD, 22));
			b1.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
	    		LoginCustomer.main(new String[]{});
	    		dispose();
				}
			});
			JButton b2=new JButton("Inspire");  
			b2.setBounds(400,100,200,60);  
			b2.setFocusPainted(false);
			b2.setForeground(Color.BLACK);
			b2.setFont(new Font("Arial", Font.BOLD, 22));
			b2.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					Login.main(new String[]{});
					dispose();
				}
			});
         Cursor cur = new Cursor(Cursor.HAND_CURSOR);
 		b1.setCursor(cur);
 		b2.setCursor(cur);
 		logPanel.add(b1); logPanel.add(b2);
 		logPanel.setOpaque(false);
 		logPanel.setBounds(300, 500, 600, 200);
 		layer.add(logPanel, Integer.valueOf(2));
 		add(layer);
	}
}
       