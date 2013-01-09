import java.sql.SQLException;

//addToDB doesn't work
public abstract class user
{
	protected String username;
	protected String code;
	protected String role; // worker or manager
	static database db = database.callDB();
	
	public int addToDB()
	{
		String insert = "INSERT INTO Login (Username,Password, Role) VALUES ('" + username + "','" + code + "','" + role + "')";
		System.out.println(insert);
		try {
			(db.st).executeUpdate(insert);
		} catch (SQLException e) {

			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	public boolean isUserExist()
	{
		String sql = "select Username from Login where Username='"+username+"'";
		try {
			db.rs = db.st.executeQuery(sql);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		try
		{
			int count = 0 ;
			while(db.rs.next())
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
	
	public boolean removeFromDB()
	{
		String request = "DELETE FROM Login WHERE Username ='"+username+"'";
		try {
			db.st.executeUpdate(request);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
