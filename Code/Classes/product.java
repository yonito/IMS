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
	
	public int addProduct()
	{
		String insert = "INSERT INTO Product(id, Name, Price, Supplier, Reservation_Quantity, Current_Quantity, Alert_Quantity)" +
						"VALUES ('" + id + "','" + name + "','" + price + "','" + sup + "','" + quantityReservation + "','" +
						quantityReservation + "','" + quantityAlert + "')";
		try {
			(db.st).executeUpdate(insert);
		} catch (SQLException e) {System.out.println(e.getErrorCode() + '\n' + e.getMessage());}
		return 0;
	}
}
