import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;


public class parts extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;

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
	
	public parts() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblPartName = new JLabel("Part name");
		lblPartName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPartName.setBounds(48, 99, 89, 14);
		getContentPane().add(lblPartName);
		
		JLabel lblOrderPart = new JLabel("Order Part");
		lblOrderPart.setForeground(Color.GREEN);
		lblOrderPart.setFont(new Font("Monotype Corsiva", Font.PLAIN, 82));
		lblOrderPart.setBounds(48, 11, 414, 62);
		getContentPane().add(lblOrderPart);
		
		textField = new JTextField();
		textField.setBounds(149, 98, 231, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCarName = new JLabel("Car name");
		lblCarName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCarName.setBounds(48, 140, 68, 14);
		getContentPane().add(lblCarName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(48, 179, 68, 14);
		getContentPane().add(lblDate);
		
		JButton btnSave = new JButton("Order");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String stra=comboBox.getSelectedItem().toString().split("-")[1];
				try
				
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/cars?user=root&password=popo009@");
		            String str="insert into parts (pname,odate,car) values(?,?,?)";
					PreparedStatement st=cn.prepareStatement(str);
					st.setString(1,textField.getText());
					st.setString(3,stra);
					st.setString(2,textField_1.getText());
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
		btnSave.setBounds(238, 225, 89, 23);
		getContentPane().add(btnSave);
		
		  comboBox = new JComboBox();
		comboBox.setBounds(149, 139, 231, 20);
		getContentPane().add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(149, 178, 231, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
put();
	}
}
