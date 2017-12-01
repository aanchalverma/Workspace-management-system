import java.awt.event.*;  
import java.sql.*;
import javax.swing.*;  
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
public class LoginCustomer extends JFrame {  

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
		new LoginCustomer().setVisible(true);
	}
	LoginCustomer()
	{
		background1();
		CustomerLogin();
	}
	public void background1()
	{	
		setTitle("LogIn");
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
public void CustomerLogin() {  
	logPanel = new JPanel();
	logPanel.setBackground(Color.WHITE);
	logPanel.setLayout(null);
	JTextField t1;
	JLabel l2,l3;
	l2=new JLabel("USERID:");  
    l2.setBounds(175,100, 300,30);  
    l2.setFont(new Font("Tahoma",Font.PLAIN,20));
    t1=new JTextField();  
    t1.setBounds(350,100, 200,30);  
    l3=new JLabel("PASSWORD:");
    l3.setBounds(175,150,300,30);
    l3.setFont(new Font("Tahoma",Font.PLAIN,20));
    JPasswordField t2 = new JPasswordField(); 
    t2.setBounds(350,150,200,30);  
    t1.setFont(new Font("Tahoma",Font.PLAIN,20));
    t2.setFont(new Font("Tahoma",Font.PLAIN,20));
    logPanel.add(t1); logPanel.add(t2);  
    logPanel.add(l2);logPanel.add(l3);  
    JButton b=new JButton("Login");  
    b.setBounds(300,250,200,50); 
    b.setFont(new Font("Tahoma",Font.PLAIN,20));
    b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		try{
			Connection con=DB.getConnection();
			String q1,pw;
			String id=t1.getText();
			String password=String.valueOf(t2.getPassword());
			q1="SELECT CMP_PWD FROM COMPANY WHERE C_ID="+id;
			Statement s=con.createStatement();
			ResultSet result=s.executeQuery(q1);
			if(result.next()==true)
			{
				pw=result.getString(1);
				if(password.equals(pw))
				{
					Customer.main(new String[]{});
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(logPanel, "Sorry, UserID or Password Error");
					t1.setText("");
					t2.setText("");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(logPanel, "Sorry, UserID or Password Error");
				t1.setText("");
				t2.setText("");
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