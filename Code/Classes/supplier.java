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

	public supplier(supplier other)
	{
		name = other.name;
		emailAdr = other.emailAdr;
	}

	public String getEmailAdr() {
		return emailAdr;
	}

	public void setEmailAdr(String emailAdr) {
		this.emailAdr = emailAdr;
	}
	
	public String getName() {
		return Neme;
	}
	

}
