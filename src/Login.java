import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.awt.Color;

public class Login extends JFrame{

	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private int w,h;
	private BufferedImage image;
	private JLabel Error;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Login() 
	{
		
	   
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 346, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/*PicPanel mainPanel = new PicPanel("e:/image.jpg");
	    mainPanel.setBounds(0,0,632,286);
	   getContentPane().add(mainPanel);
	contentPane.add(mainPanel);
	
	contentPane.invalidate();
	contentPane.repaint();
	contentPane.revalidate();
*/
	
		
	JLabel lblEnterUsername = new JLabel("ENTER USERNAME");
		lblEnterUsername.setForeground(Color.BLUE);
		lblEnterUsername.setBounds(52, 64, 107, 14);
		contentPane.add(lblEnterUsername);
		
		lblEnterUsername.addNotify();
		textField = new JTextField();
		textField.setBounds(169, 61, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setBounds(52, 113, 76, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 110, 150, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{
			try
			{
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/cars?user=root&password=popo009@");
                String str="Select * from login where un=? and pass=?";
				PreparedStatement st=cn.prepareStatement(str);
				st.setString(1,textField.getText());
				st.setString(2,passwordField.getText());
				ResultSet rs=st.executeQuery();
				if(rs.next())
				{
				Home h=new Home();
				h.setVisible(true);
				contentPane.disable();
				}
				else
				{
					Error.setText("Invalid login ");
				}
				cn.close();
			}
			catch(Exception E)
			{
			System.out.println(E.getMessage());	
			}
			}
		});
		btnLogin.setBounds(196, 154, 89, 23);
		contentPane.add(btnLogin);
		
		Error= new JLabel("");
		Error.setForeground(Color.MAGENTA);
		Error.setBounds(169, 188, 131, 14);
		contentPane.add(Error);
	}
}
