import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Box.Filler;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Search extends JInternalFrame {
	private JTextField textField;
	private JLabel Error;
	private JTable table;

	void put()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/cars?user=root&password=popo009@");
            String str="Select * from cars where cname=? ";
			PreparedStatement st=cn.prepareStatement(str);
			st.setString(1,textField.getText());
			ResultSet rs=st.executeQuery();
			DefaultTableModel dm=new DefaultTableModel();
			dm.addColumn("cid");
			dm.addColumn("cname");
			dm.addColumn("cyear");
			dm.addColumn("km");
			dm.addColumn("price");
			dm.addColumn("qty");
			while(rs.next())
			{
			String ar[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
			dm.addRow(ar);
			}
			table.setModel(dm);
			cn.close();
		}
		catch(Exception E)
		{
		System.out.println(E.getMessage());	
		}
	}
	
	public Search() {
		setBounds(0,0, 443, 334);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 343, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Find");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/cars?user=root&password=popo009@");
		            String str="Select * from cars where cname=?";
					PreparedStatement st=cn.prepareStatement(str);
					st.setString(1,textField.getText());
					ResultSet rs=st.executeQuery();
					DefaultTableModel dm=new DefaultTableModel();
					dm.addColumn("cid");
					dm.addColumn("cname");
					dm.addColumn("cyear");
					dm.addColumn("km");
					dm.addColumn("price");
					dm.addColumn("qty");
					String ar1[]={"CarID","Car Name","Year","Price","Qty",};
					dm.addRow(ar1);
					if((rs.next()))
					{
						String ar[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
					dm.addRow(ar);
					while(rs.next())
					{
						
					String ar11[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
					dm.addRow(ar11);
					}
					table.setModel(dm);
					cn.close();				
					}
					
				else
				{
					Error.setText("No such Car");
				}
			}
				catch(Exception E)
				{
				System.out.println(E.getMessage());	
				}
			}
		});
	
		btnNewButton.setBounds(345, -1, 89, 23);
		getContentPane().add(btnNewButton);
		
		Error = new JLabel("");
		Error.setBounds(0, 22, 130, 20);
		getContentPane().add(Error);
		
		table = new JTable();
		table.setBounds(0, 63, 417, 239);
		getContentPane().add(table);
		put();

	}
}
