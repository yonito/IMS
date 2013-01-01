import java.sql.SQLException;

/* we must add the role to the SQL request */
public class manager extends user
{
	database db = database.callDB();
	public int addToDB(user u)
	{
		manager m = (manager) u;
		String insert = "INSERT INTO LOGIN(Username,Password) VALUES ('" + m.username + "','" + m.code +"')";
		try {
			(db.st).executeUpdate(insert);
		} catch (SQLException e) {

			e.printStackTrace();
			return -1;
		}
		return 0;
	}
}
