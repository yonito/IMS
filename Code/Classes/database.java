import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ComboBoxModel;

/*Design pattern : SingleTon*/
public class database
{
	private static database db;
	Connection con;
	Statement st;
	ResultSet rs;
	private database()
	{
		connect();
	}

	public static database callDB()
	{
		if(db == null)
			return new database();
		else
			return db;
	}

	public void connect()
	{
		try
		{
			String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String db = "jdbc:odbc:IMS";
			con = DriverManager.getConnection(db);
			st = con.createStatement();
		}
		catch(SQLException ex){System.out.println("error");}
	}

	/*Check if the user exist in IMS in the login window. True = entrance; False = close*/
	public boolean isUserInSystem(String username,String pass)
	{
		String sql = "select Username,Password from Login where Username='"+username+"'and Password='"+pass+"'";
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try
		{
			int count = 0 ;
			while(rs.next())
				count++;

			if(count > 0)
			{
				return true;
			}
			else
				return false;
		}
		catch(Exception ex){return false;}

	}

	public supplier[] getSupplierList()
	{
		int numOfLine = 0;
		String request = "select name, email_address from Supplier";
		try {
			rs = st.executeQuery(request);
		}
		catch (SQLException e){System.out.println("error in request");}
		try {
			while(rs.next())
				numOfLine++;
		} catch (SQLException e) {}
		supplier[] listSupplier = new supplier[numOfLine+1];
		listSupplier[0] = null;
		int i = 1;
		try
		{
			rs = st.executeQuery(request);
			while(rs.next())
			{
				listSupplier[i] = new supplier(rs.getString("Name"), rs.getString("email_address"));
				//System.out.println(listSupplier[i]);
				i++;
			}
		}catch(SQLException e){};
		return listSupplier;
	}

	public String emailOfSupplier(String nameSupplier)
	{
		String email = "";
		String request = "select email_address from Supplier where name='" + nameSupplier + "'";
		try {
			rs = st.executeQuery(request);
			while(rs.next())
				email = rs.getString("email_address");
			System.out.println(email);
		}
		catch (SQLException e){System.out.println("error in request : " + e.getMessage());}
		return email;
	}

	//////////////
	public boolean delete(int id)
	{
		String sql = "DELETE from Product where id='"+id+"'";
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try
		{
			int count = 0 ;
			while(rs.next())
				count++;

			if(count > 0)
			{
				return true;
			}
			else
				return false;
		}
		catch(Exception ex){return false;}

	}

}