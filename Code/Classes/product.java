import java.io.ObjectInputStream.GetField;
import java.sql.SQLException;


public class product
{
	private String name;
	private int id;
	private int price;
	private int quantityReservation;
	private int quantityAlert;
	private int quantityCurrent;
	private supplier sup;
	static database db = database.callDB();
	static int counterID = getNewID();
	
	public product(String n, int p, int res_quantity, int cur_quantity, int alert_quantity, supplier s)
	{
		name = n;
		id = counterID;
		price = p;
		quantityReservation = res_quantity;
		quantityAlert = alert_quantity;
		quantityCurrent = cur_quantity;
		sup = s;
	}
	
	public int addProduct()
	{
		String insert = "INSERT INTO Product(id, Name, Price, Supplier, Reservation_Quantity, Current_Quantity, Alert_Quantity)" +
						"VALUES ('" + id + "','" + name + "','" + price + "','" + sup.name + "','" + quantityReservation + "','" +
						quantityReservation + "','" + quantityAlert + "')";
		try {
			(db.st).executeUpdate(insert);
		} catch (SQLException e) {System.out.println(e.getErrorCode() + '\n' + e.getMessage()); return -1;}
		
		counterID++;
		return 0;
	}
	
	public static int getNewID()
	{
		int iResult = -1;
		String request = "select id from Product";
		try {
			db.rs = db.st.executeQuery(request);
		}
		catch (SQLException e){}
		try {
				int counter = 1;
				int numOfLine = 0;
				try {
					while(db.rs.next())
						numOfLine++;
				} catch (SQLException e) {}
				db.rs = db.st.executeQuery(request);
				while(db.rs.next())
				{
					if(counter == numOfLine)
					{
						String sResult = db.rs.getString("id");
						iResult = Integer.parseInt(sResult);
					}
					counter++;
				}
		} catch (SQLException e) {System.out.println(e.getMessage());}
		return iResult+1;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantityReservation() {
		return quantityReservation;
	}

	public void setQuantityReservation(int quantityReservation) {
		this.quantityReservation = quantityReservation;
	}

	public int getQuantityAlert() {
		return quantityAlert;
	}

	public void setQuantityAlert(int quantityAlert) {
		this.quantityAlert = quantityAlert;
	}

	public int getQuantityCurrent() {
		return quantityCurrent;
	}

	public void setQuantityCurrent(int quantityCurrent) {
		this.quantityCurrent = quantityCurrent;
	}

	public supplier getSup() {
		return sup;
	}

	public void setSup(supplier sup) {
		this.sup = sup;
	}
	
	
}
