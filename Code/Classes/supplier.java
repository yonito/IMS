import java.sql.SQLException;


public class supplier
{
	private String name;
	private String emailAdr;
	database db = database.callDB();
	
	public supplier(String n, String adr)
	{
		name = n;
		emailAdr = adr;
	}

}