import java.awt.EventQueue;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 


public class allsev extends JInternalFrame {
	private JTable table;
	

	void put()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/cars?user=root&password=popo009@");
	        String str="Select * from service ";
			PreparedStatement st=cn.prepareStatement(str);
			ResultSet rs=st.executeQuery();
			DefaultTableModel dm=new DefaultTableModel();
			dm.addColumn("cuname");
			dm.addColumn("phno");
			dm.addColumn("addr");
			dm.addColumn("cars");
			dm.addColumn("CarNum");
			String ar1[]={"Customer name","Ph no","address","car","Car no."};
			dm.addRow(ar1);
			while(rs.next())
			{
			String ar[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
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
	public allsev() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0,0,450,300);
		getContentPane().setLayout(null);
		
		
		table = new JTable();
		table.setBounds(0, 0, 434, 270);
		getContentPane().add(table);
put();
	}
}
