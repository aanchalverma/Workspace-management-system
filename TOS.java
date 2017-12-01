import java.awt.event.*;

import javax.swing.*;  
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
public class TOS extends JFrame{  
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
		new TOS().setVisible(true);
	}
	TOS()
	{
		background1();
		service();
	}
	public void background1()
	{	
		setTitle("Service Enquiry");
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
	public void service(){
		JLabel l1,l2,l3;
		logPanel = new JPanel();
		logPanel.setBackground(Color.WHITE);
		logPanel.setLayout(null);
	String services[]={"PLUG-IN OFFICE","VIRTUAL OFFICE","CUSTOM OFFICE"};
	String Location[]={"MARATHAHALLI","KORMANGALA","HAL","VV PURAM","INDIRANAGAR","MG ROAD"};  
    l1=new JLabel("Service Enquiry");  
    l1.setForeground(Color.BLACK);
	l1.setFont(new Font("Tahoma", Font.BOLD, 26));
    l1.setBounds(250,50, 270,30);  
    l2=new JLabel("Service Name:");  
    l2.setBounds(80,150, 200,30); 
    JComboBox<String> cb1=new JComboBox<>(services);
    cb1.setBounds(250,150,200,30);
    l3=new JLabel("Branch:");
    l3.setBounds(80,200,200,30);
    JComboBox<String> cb2=new JComboBox<>(Location);
    cb2.setBounds(250,200,200,30);  
    l2.setFont(new Font("Tahoma",Font.BOLD,16));
    l3.setFont(new Font("Tahoma",Font.BOLD,16));
    cb2.setFont(new Font("Tahoma",Font.PLAIN,16));
    cb1.setFont(new Font("Tahoma",Font.PLAIN,16));
   
    logPanel.add(l1); logPanel.add(l2);logPanel.add(l3);
    logPanel.setSize(400,400); logPanel.add(cb1); logPanel.add(cb2);
    JButton b=new JButton("Enquire");  
    b.setBounds(250,250,200,50);  
    b.setFont(new Font("Tahoma",Font.BOLD,16));
    
    b.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  
	    	  try {
	    		  
	    		  String service = (String)cb1.getSelectedItem();
	    		  if(service=="PLUG-IN OFFICE")
	    		  {
	    			  JOptionPane.showMessageDialog(logPanel,"Plugin Office \n In this service you are provided the office space on the basis of the seat you require.");
	    		  }
	    		  else if(service=="VIRTUAL OFFICE")
	    		  {
	    			  JOptionPane.showMessageDialog(logPanel,"Virtual Office \n In this service you are provided the office address for various activites such as registration of your company ");
	    		  }
	    		  else if(service=="CUSTOM OFFICE")
	    		  {
	    			  JOptionPane.showMessageDialog(logPanel,"Custom Office \n In this service you are provided the office space according to your choice.");
	    		  }
    
    
	    	  }
	    	  
	    	  catch(Exception arg){System.out.println(arg);}
	      }
    });
    logPanel.add(b);
    logPanel.setBounds(300, 200, 900, 735);
    logPanel.setOpaque(false);
    Cursor cur = new Cursor(Cursor.HAND_CURSOR);
	b.setCursor(cur);
		layer.add(logPanel, Integer.valueOf(2));
		add(layer);  
    
}  
}  
