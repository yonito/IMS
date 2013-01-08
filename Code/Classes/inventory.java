import java.sql.Array;
import java.sql.SQLException;


public class inventory
{
	database db = database.callDB();
	
	public String[][] getInventory()
	{
		String request = "SELECT id, Name, Price, Reservation_Quantity, Supplier FROM Product";
		try {
			db.rs = db.st.executeQuery(request);
		}
		catch (SQLException e){}
		int numOfLine = 0;
		int numOfColumn = 0;
		try{
			numOfColumn = db.rs.getMetaData().getColumnCount();
			while(db.rs.next())
				numOfLine++;
		}
		catch(Exception e){};
		String[][] table = new String[numOfLine++][numOfColumn];
		try {
				int i = 0;
				db.rs = db.st.executeQuery(request);
				while(db.rs.next())
				{
					table[i][0] = Integer.toString(db.rs.getInt("id")); // id of product
					//System.out.println(table[i][0]);
					table[i][1] = db.rs.getString("Name"); //name of product
					//System.out.println(table[i][1]);
					table[i][2] = Integer.toString(db.rs.getInt("Price")); // price
					//System.out.println(table[i][2]);
					table[i][3] = Integer.toString(db.rs.getInt("Reservation_Quantity")); // reservation_quantity
					//System.out.println(table[i][3]);
					table[i][4] = db.rs.getString("Supplier"); //name of supplier
					//System.out.println(table[i][4]);
					i++;
				}
					
		} catch (SQLException e) {System.out.println(e.getErrorCode() + '\n' + e.getMessage());}
		return table;
	}
	
	public String[][] findProduct(String nameProduct)
	{
		String request = "SELECT id, Name, Price, Reservation_Quantity, Supplier FROM Product WHERE Name='" + nameProduct + "'";
		try {
			db.rs = db.st.executeQuery(request);
		}
		catch (SQLException e){}
		int numOfLine = 0;
		int numOfColumn = 0;
		try{
			numOfColumn = db.rs.getMetaData().getColumnCount();
			while(db.rs.next())
				numOfLine++;
		}
		catch(Exception e){};
		//System.out.println("Nombre de ligne : " + numOfLine);
		String[][] table = new String[numOfLine][numOfColumn];
		int i = 0;
		try
		{
			db.rs = db.st.executeQuery(request);
			while(db.rs.next())
			{
				table[i][0] = Integer.toString(db.rs.getInt("id")); // id of product
				System.out.println(table[i][0]);
				table[i][1] = db.rs.getString("Name"); //name of product
				System.out.println(table[i][1]);
				table[i][2] = Integer.toString(db.rs.getInt("Price")); // price
				System.out.println(table[i][2]);
				table[i][3] = Integer.toString(db.rs.getInt("Reservation_Quantity")); // Current_quantity
				System.out.println(table[i][3]);
				table[i][4] = db.rs.getString("Supplier"); //name of supplier
				System.out.println(table[i][4]);
				i++;
			}
		} catch (SQLException e) {System.out.println(e.getErrorCode() + '\n' + e.getMessage());}
		return table;
	}
}
