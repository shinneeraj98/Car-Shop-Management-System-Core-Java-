import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Addc extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JTextField textField_3;
	
int update(int carid)
	{ 
		int a=0;
		try
		{
			System.out.println("Carid==:"+carid);
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/cars?user=root&password=popo009@");
			String str1="update cars set qty=qty-1 where cid=? and qty>0";
			PreparedStatement strr=cn.prepareStatement(str1);
			strr.setInt(1,carid);
			a=strr.executeUpdate();
			cn.close();
			
		}
		catch(Exception E)
		{
		System.out.println(E.getMessage());	
		}
		return a;
	}
	void put()
	{
		try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/cars?user=root&password=popo009@");
	    String str1="select * from cars";
		PreparedStatement strr=cn.prepareStatement(str1);
		DefaultComboBoxModel cb=new DefaultComboBoxModel();
		ResultSet rs=strr.executeQuery();
		while (rs.next()) {
		cb.addElement(rs.getString(1)+"-"+rs.getString(2));	
		}
		comboBox.setModel(cb); 
		cn.close();
	}
	catch(Exception E)
	{
	System.out.println(E.getMessage());	
	}
	}	
	public Addc() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0,0, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(49, 70, 46, 14);
		getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(112, 67, 265, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone no.");
		lblPhoneNo.setBounds(49, 109, 65, 14);
		getContentPane().add(lblPhoneNo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 106, 265, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(49, 150, 65, 14);
		getContentPane().add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setBounds(112, 147, 265, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddCustomer = new JLabel("Add Customer ");
		lblAddCustomer.setFont(new Font("Monotype Corsiva", Font.PLAIN, 38));
		lblAddCustomer.setForeground(Color.GREEN);
		lblAddCustomer.setBounds(106, 17, 248, 39);
		getContentPane().add(lblAddCustomer);
		
		JLabel lblCarName = new JLabel("Car name");
		lblCarName.setBounds(49, 192, 65, 14);
		getContentPane().add(lblCarName);
		 comboBox = new JComboBox();
		comboBox.setBounds(112, 192, 265, 20);
		getContentPane().add(comboBox);
		
		
		
		
		JButton btnAdd = new JButton("Add ");
		btnAdd.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				int carid=Integer.parseInt(comboBox.getSelectedItem().toString().split("-")[0]);
				String stra=comboBox.getSelectedItem().toString().split("-")[1];
				
			if(update(carid)>=1)
			    {
					try
					
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/cars?user=root&password=popo009@");
		            String str="insert into customer (coname,phno,adre,cname,Price) values(?,?,?,?,?)";
					PreparedStatement st=cn.prepareStatement(str);
					st.setString(1,textField.getText());
					st.setString(2,textField_1.getText());
					st.setString(3,textField_2.getText());
					st.setString(4,stra);
					st.setString(5,textField_3.getText());
					st.executeUpdate();
		            JOptionPane.showMessageDialog(null,"Data Save"); 
			        cn.close();
				}
				catch(Exception E)
				{
				System.out.println(E.getMessage());	
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"car not available");
			}
		}
					});
		btnAdd.setBounds(335, 236, 89, 23);
		getContentPane().add(btnAdd);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(49, 240, 46, 14);
		getContentPane().add(lblPrice);
		
		textField_3 = new JTextField();
		textField_3.setBounds(112, 237, 213, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		put();
	}
}
