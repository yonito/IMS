import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class manager extends user {

	//addmanager();
	Connection con;
	Statement st;
	ResultSet rs;

	JFrame f = new JFrame("User Login");
	JLabel n = new JLabel("Username:");
	JLabel m = new JLabel("Password:");
	JTextField t = new JTextField(10);//הגדרת גודל התווים של רישום היוזר והסיסמא
	JTextField t1 = new JTextField(10);
	
	JButton b = new JButton("Login");

	public manager()
	{
		connect();
		frame();
	}

	public void connect()
	{
		try
		{
			String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
			Class.forName(driver);


			String db = "jdbc:odbc:Login_DSN";
			con = DriverManager.getConnection(db);
			st = con.createStatement();
			
			/////////////////////////////////////////insert
			
		/*	String newuser = "sxsh";
			int newPassword = 4231 ; 
			
			String insert = "INSERT INTO LOGIN VALUES ('" + newuser + "' , " + newPassword +")";
			st.executeUpdate(insert);*/
			
			
		}
		catch(Exception ex)
		{

		}
	}

	public void frame()
	{
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		JPanel p = new JPanel();
		p.add(n);
		p.add(t);
		p.add(m);
		p.add(t1);
		p.add(b);

		f.add(p);

		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
				String user = t.getText().trim();
				String pass = t1.getText().trim();
				
				String sql = "select Username,Password from Login where Username='"+user+"'and Password='"+pass+"'";
				rs = st.executeQuery(sql);
				
				int count = 0 ;
				while(rs.next())
				{
					count = count + 1;
				}
				
				if(count == 1)
				{
					JOptionPane.showMessageDialog(null, "User Found , Access Granted");
				}
				else if (count > 1)
				{
					JOptionPane.showConfirmDialog(null, "Duplicate user , access denied!");
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "User not Found!");
					
				}
				
				}
				
				catch(Exception ex)
				{
					
				}

			}




		});
	}
}
