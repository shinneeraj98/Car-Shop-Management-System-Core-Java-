import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Add extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

		void put()
		{try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/cars?user=root&password=neeraj123@");
            String str="select * from cars";
			cn.close();
		}
		catch(Exception E)
		{
		System.out.println(E.getMessage());	
		}
		}
	public Add()
	{
		
setBounds(0, 0, 450, 300);
setMaximizable(true);
setIconifiable(true);
setClosable(true);
getContentPane().setLayout(null);
JLabel lblName = new JLabel("Name");
lblName.setBounds(58, 46, 200, 50);
getContentPane().add(lblName);
textField = new JTextField();
textField.setBounds(95, 61, 200, 20);
getContentPane().add(textField);
textField.setColumns(10);
JLabel lblAddACar = new JLabel("Add A Car");
lblAddACar.setForeground(Color.BLUE);
lblAddACar.setFont(new Font("Monotype Corsiva", Font.PLAIN, 32));
lblAddACar.setBounds(139, 11, 200, 50);
getContentPane().add(lblAddACar);
JLabel lblNewLabel = new JLabel("Km");
lblNewLabel.setBounds(58, 97, 200, 50);
getContentPane().add(lblNewLabel);
JLabel lblYear = new JLabel("Year");
lblYear.setBounds(58, 143, 200, 50);
getContentPane().add(lblYear);
JLabel lblPrice = new JLabel("Price");
lblPrice.setBounds(58, 189, 200, 50);
getContentPane().add(lblPrice);
JButton btnSave = new JButton("Save");
btnSave.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/cars?user=root&password=popo009@");
            String str="insert into cars (cname,km,year,price) values(?,?,?,?)";
			PreparedStatement st=cn.prepareStatement(str);
			st.setString(1,textField.getText());
			st.setFloat(2,Float.parseFloat(textField_1.getText()));
			st.setString(3,textField_2.getText());
			st.setFloat(4,Float.parseFloat(textField_3.getText()));
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
btnSave.setBounds(307, 236, 89, 23);
getContentPane().add(btnSave);
textField_1 = new JTextField();
textField_1.setBounds(95, 112, 200, 20);
getContentPane().add(textField_1);
textField_1.setColumns(10);
textField_2 = new JTextField();
textField_2.setBounds(95, 158, 200, 20);
getContentPane().add(textField_2);
textField_2.setColumns(10);
textField_3 = new JTextField();
textField_3.setBounds(95, 204, 200, 23);
getContentPane().add(textField_3);
textField_3.setColumns(10);

put();

	}

}
