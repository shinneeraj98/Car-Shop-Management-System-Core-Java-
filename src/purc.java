import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class purc extends JInternalFrame {

	private JTable table;
	
	void put()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/cars?user=root&password=popo009@");
	        String str="Select * from customer ";
			PreparedStatement st=cn.prepareStatement(str);
			ResultSet rs=st.executeQuery();
			DefaultTableModel dm=new DefaultTableModel();
			
			dm.addColumn("coname");
			dm.addColumn("phno");
			dm.addColumn("adre");
			dm.addColumn("cname");
			dm.addColumn("Price");
			dm.addColumn("Price");
			String ar1[]={"CoID","Co name","Phno","Address","Price","Car name",};
			dm.addRow(ar1);
		
		
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
	public purc() {
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
