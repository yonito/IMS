import java.sql.SQLException;

/* we must add the role to the SQL request */
public class manager extends user
{
	database db = database.callDB();
	//public int addToDB(user u)
	
	public manager(String name, String password, String r)
	{
		username = name;
		code = password;
		role = r;
	}

	
}
