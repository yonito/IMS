import java.sql.SQLException;


public class worker extends user
{
	database db = database.callDB();
	public int addToDB(user u)
	{
		worker w = (worker) u;
		String insert = "INSERT INTO LOGIN(Username,Password) VALUES ('" + w.username + "','" + w.code +"')";
		try {
			(db.st).executeUpdate(insert);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

}
