import java.sql.SQLException;


public abstract class user
{
	protected String username;
	protected String code;
	protected String role; // worker or manager
	database db = database.callDB();
	
	public abstract int addToDB(user u);
	//public abstract int removeFromDB(user u);
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
}
