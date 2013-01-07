import java.sql.SQLException;


public abstract class user
{
	protected String username;
	protected String code;
	protected String role; // worker or manager
	database db = database.callDB();
	
	public int addToDB(user u)
	{
		String insert = "INSERT INTO LOGIN(Username,Password, Role) VALUES ('" + u.username + "','" + u.code + "','" + u.role + "')";
		try {
			(db.st).executeUpdate(insert);
		} catch (SQLException e) {

			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	public boolean isUserExist(user u)
	{
		String sql = "select Username,Password from Login where Username='"+u.username+"'";
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
	
	public boolean removeFromDB(user u)
	{
		String request = "delete Username, Password, Role where Username ='"+u.username+"'"; //// complete the request
		try {
			db.rs = db.st.executeQuery(request);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
