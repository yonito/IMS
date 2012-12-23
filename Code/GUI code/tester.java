import java.awt.EventQueue;
public class Tester
{

	/**
	 * @param args
	 */
	static loginThread login_thread;
	public static void main(String[] args)
	{

		/*Connection con;
		Statement st;
		ResultSet rs;


		try
		{
			String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
			Class.forName(driver);


			String db = "jdbc:odbc:Login_DSN";
			con = DriverManager.getConnection(db);
			st = con.createStatement();

			/////////////////////////////////////////

			String newuser = "sxsh";
			int newPassword = 4231 ; 

			String insert = "INSERT INTO LOGIN VALUES ('" + newuser + "' , " + newPassword +")";
			st.executeUpdate(insert);


		}
		catch(Exception ex)
		{

		}*/

		//////////////////////////////////////////////////////////////////////////////////////////////		

		//		try
		//		{
		//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//			Connection con = DriverManager.getConnection("jdbc:odbc:Login_DSN");
		//			Statement st = con.createStatement();
		//			Scanner scan = new Scanner (System.in);
		//			System.out.println("Please enter a username");
		//			String t = scan.next();
		//
		//			//String a = "sharonyar";
		//			//String b = "yonito";
		//
		//			String s = "select Username from Login where Username='"+t+"'";
		//			ResultSet rs = st.executeQuery(s);
		//			if(rs.next())
		//			{
		//				System.out.println("Valid User");
		//			}
		//			else
		//			{
		//				System.out.println("Invalid User");
		//			}
		//
		//
		//		}
		//		catch(Exception e)
		//		{
		//			System.out.println(e);
		//		}


		new manager();

		login_thread = new loginThread(null);//мод рам????
		login_thread.run();
		mainWindows mainWin = new mainWindows();




	}

}