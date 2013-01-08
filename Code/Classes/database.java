import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}