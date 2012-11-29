	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import java.awt.Font;
	import javax.swing.JButton;
	import java.awt.Color;
	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;
	import javax.swing.border.TitledBorder;
	import javax.swing.ListSelectionModel;
	import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class inventoryGUI extends JFrame
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
			
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"ID Product", "Name's product", "Price (ILS)", "Supplier", "Current Quantity", "Quantity alert"
				}
			));
		table.getColumnModel().getColumn(0).setPreferredWidth(89);
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		table.getColumnModel().getColumn(2).setPreferredWidth(89);
		table.getColumnModel().getColumn(4).setPreferredWidth(94);
		table.getColumnModel().getColumn(5).setPreferredWidth(84);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBounds(28, 80, 344, 239);
		contentPane.add(table);
			
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
	}


}
