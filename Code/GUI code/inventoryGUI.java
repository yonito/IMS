	import javax.swing.JDialog;
import javax.swing.JFrame;
	import javax.swing.JPanel;
import javax.swing.JScrollPane;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import java.awt.Font;
	import javax.swing.JButton;
	import java.awt.Color;
	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
	import javax.swing.border.TitledBorder;
	import javax.swing.ListSelectionModel;
	import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class inventoryGUI extends JDialog
{
	private JPanel contentPane;
	private JTextField txtSearchAProduct;
	private JTable table;
	private database db = database.callDB();
	private inventory stock = new inventory();
	String[] columnNames = {"ID", "Product name", "Product price", "Quantity", "Supplier"};
		
	public inventoryGUI()
	{
		setTitle("Your inventory");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 426, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Reservation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(61, 392, 111, 23);
		contentPane.add(btnNewButton);
			
		JButton btnCancel = new JButton("Modify");
		btnCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
		});
		btnCancel.setBounds(61, 350, 111, 23);
		contentPane.add(btnCancel);
			
		txtSearchAProduct = new JTextField();
		txtSearchAProduct.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtSearchAProduct.setForeground(new Color(128, 128, 128));
		txtSearchAProduct.setText("Search a product");
		txtSearchAProduct.setBounds(28, 40, 246, 20);
		contentPane.add(txtSearchAProduct);
		txtSearchAProduct.setColumns(10);
			
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(284, 39, 100, 23);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{	
				String productNameSearched = txtSearchAProduct.getText();
				stock.findProduct(productNameSearched);
				String[][] data = stock.findProduct(productNameSearched);
				//System.out.println("l : "  + data[0].length);
				//System.out.println(data[0][3]);
				//System.out.println(data[0][4]);
				
				//System.out.println(data.toString());
				myTableModel researchModel = new myTableModel(columnNames, data);
				table.setModel(researchModel);
			}
		});
		
			
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(227, 392, 111, 23);
		contentPane.add(btnDelete);
			
		JButton btnDetail = new JButton("Detail");
		btnDetail.setBounds(227, 350, 111, 23);
		contentPane.add(btnDetail);
		
		
		
		String[][] data = stock.getInventory();

		table = new JTable(new myTableModel(columnNames, data));
		table.setAutoCreateRowSorter(true); // sort the columns
		JScrollPane scroll = new JScrollPane(table);
		scroll.setLocation(10, 71);
        scroll.setSize(390,268);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBounds(12, 71, 388, 251);
		contentPane.add(scroll);
	}
}