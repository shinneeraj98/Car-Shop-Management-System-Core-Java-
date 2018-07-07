import java.awt.EventQueue;

import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Color;


public class serv extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JTextField textField_3;

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
	public serv() {
		setBounds(0,0, 450, 309);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer name");
		lblCustomerName.setBounds(10, 43, 97, 14);
		getContentPane().add(lblCustomerName);
		
		JLabel lblCustomerPhno = new JLabel("Customer phno");
		lblCustomerPhno.setBounds(10, 81, 97, 14);
		getContentPane().add(lblCustomerPhno);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 117, 97, 14);
		getContentPane().add(lblAddress);
		
		JLabel lblCarName = new JLabel("Car name");
		lblCarName.setBounds(10, 152, 63, 14);
		getContentPane().add(lblCarName);
		JButton btnAddService = new JButton("Add Service");
		btnAddService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String stra=comboBox.getSelectedItem().toString().split("-")[1];
				try
				
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/cars?user=root&password=popo009@");
		            String str="insert into service (cucname,phno,addr,car,CarNum) values(?,?,?,?,?)";
					PreparedStatement st=cn.prepareStatement(str);
					st.setString(1,textField.getText());
					st.setString(2,textField_1.getText());
					st.setString(3,textField_2.getText());
					st.setString(4,textField_3.getText());
					st.setString(5,stra);
					st.executeUpdate();
		            JOptionPane.showMessageDialog(null,"Data Save"); 
			        cn.close();
				}
				catch(Exception E)
				{
				System.out.println(E.getMessage());	
				}
			}
		});
		
		btnAddService.setBounds(250, 225, 104, 23);
		getContentPane().add(btnAddService);
		
		textField = new JTextField();
		textField.setBounds(117, 40, 237, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 78, 237, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(117, 114, 237, 20);
		getContentPane().add(textField_2);
		
		comboBox = new JComboBox();
		comboBox.setBounds(117, 153, 237, 23);
		getContentPane().add(comboBox);
		
		JLabel lblAddAService = new JLabel("Add a Service");
		lblAddAService.setForeground(Color.MAGENTA);
		lblAddAService.setFont(new Font("Monotype Corsiva", Font.PLAIN, 26));
		lblAddAService.setBounds(133, 0, 200, 50);
		getContentPane().add(lblAddAService);
		
		JLabel lblCarNumber = new JLabel("Car Number");
		lblCarNumber.setBounds(10, 193, 97, 14);
		getContentPane().add(lblCarNumber);
		
		textField_3 = new JTextField();
		textField_3.setBounds(117, 190, 237, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		put();
	}
}
