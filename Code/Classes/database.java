import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class database
{
	Connection con;
	Statement st;
	ResultSet rs;
	public database()
	{
		connect();
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
		}
		catch(Exception ex){}
	}
	
	public boolean isManagerExist(String user)
	{
		String sql = "select Username,Password from Login where Username='"+user;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		catch(Exception ex){}
		return false;
	}
}
