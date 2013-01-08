import java.sql.SQLException;


public class product
{
	private String name;
	private int id;
	private double price;
	private int quantityReservation;
	private int quantityAlert;
	private supplier sup;
	database db = database.callDB();
	
	public product(String n, int identity, int p, int res_quantity, int alert_quantity, supplier s)
	{
		name = n;
		id = identity;
		price = p;
		quantityReservation = res_quantity;
		quantityAlert = alert_quantity;
		sup = s;
	}
	
	/*public int addProduct(product p)
	{
		String sql = "select Username,Password from Login where Username='"+username+"'and Password='"+pass+"'";
		try {
			db.rs = db.st.executeQuery(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	*/
}
