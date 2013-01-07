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
		btnNewButton.setBounds(71, 374, 101, 23);
		contentPane.add(btnNewButton);
			
		JButton btnCancel = new JButton("Modify");
		btnCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
		});
		btnCancel.setBounds(71, 332, 101, 23);
		contentPane.add(btnCancel);
			
		txtSearchAProduct = new JTextField();
		txtSearchAProduct.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtSearchAProduct.setForeground(new Color(128, 128, 128));
		txtSearchAProduct.setText("Search a product");
		txtSearchAProduct.setBounds(28, 40, 246, 20);
		contentPane.add(txtSearchAProduct);
		txtSearchAProduct.setColumns(10);
			
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBounds(284, 39, 89, 23);
		contentPane.add(btnNewButton_1);
			
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(227, 374, 101, 23);
		contentPane.add(btnDelete);
			
		JButton btnDetail = new JButton("Detail");
		btnDetail.setBounds(227, 332, 101, 23);
		contentPane.add(btnDetail);
			
		JLabel lblNewLabel = new JLabel("Detail of the selected product");
		lblNewLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		lblNewLabel.setBounds(12, 410, 196, 14);
		contentPane.add(lblNewLabel);
		
		
		String[] columnNames = {"ID", "Product name", "Product price", "Quantity", "Supplier"};
		Object[][] data = {
			    {new Integer(01), "Malboro Light", new Integer(7), new Integer(200), new String("USSup")},
			    {new Integer(02), "Coca Cola", new Integer(2), new Integer(70), new String("Coca Compagny")}};

		table = new JTable(data, columnNames);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setLocation(10, 71);
        scroll.setSize(390,250);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBounds(12, 71, 388, 251);
		contentPane.add(scroll);
	}
}