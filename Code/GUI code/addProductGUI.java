import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;


public class addProductGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIDprod;
	private JTextField txtNameProd;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	private JTextField txtFieldResQuantity;
	private database db = database.callDB();
	
	public addProductGUI()
	{
		setAlwaysOnTop(true);
		setTitle("Add product");
		setBounds(100, 100, 449, 414);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fill this form to add a product to the inventory");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 21, 350, 25);
		contentPanel.add(lblNewLabel);
		
		JLabel lblIDproduct = new JLabel("Product identity number :");
		lblIDproduct.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIDproduct.setBounds(10, 66, 179, 14);
		contentPanel.add(lblIDproduct);
		
		txtIDprod = new JTextField();
		txtIDprod.setBounds(10, 85, 179, 20);
		contentPanel.add(txtIDprod);
		txtIDprod.setColumns(10);
		
		JLabel lblNamesProduct = new JLabel("Name's product :");
		lblNamesProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNamesProduct.setBounds(10, 116, 179, 14);
		contentPanel.add(lblNamesProduct);
		
		txtIDprod = new JTextField();
		txtIDprod.setColumns(10);
		txtIDprod.setBounds(10, 135, 179, 20);
		contentPanel.add(txtIDprod);
		
		JLabel lblPricesProduct = new JLabel("Price's product :");
		lblPricesProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPricesProduct.setBounds(10, 166, 179, 14);
		contentPanel.add(lblPricesProduct);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(10, 187, 179, 20);
		contentPanel.add(txtPrice);
		
		JLabel lblNamesSupplier = new JLabel("Name's supplier :");
		lblNamesSupplier.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNamesSupplier.setBounds(10, 218, 179, 14);
		contentPanel.add(lblNamesSupplier);
		
		JComboBox<String> comboBox = new JComboBox<String>(db.getSupplierList());
		comboBox.setBounds(10, 235, 179, 20);
		contentPanel.add(comboBox);
		
		JLabel lblQuantityBefore = new JLabel("Quantity before first warning alert :");
		lblQuantityBefore.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantityBefore.setBounds(10, 298, 243, 14);
		contentPanel.add(lblQuantityBefore);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(251, 296, 58, 20);
		contentPanel.add(txtQuantity);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 331, 433, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0)
					{
						int idProduct = Integer.parseInt(txtIDprod.getText());
						String nameProd = txtNameProd.getText();
						int priceProd = Integer.parseInt(txtPrice.getText());
						int reservQuantity = Integer.parseInt(txtFieldResQuantity.getText());
						int alertQuantity = Integer.parseInt(txtQuantity.getText());
						//product p = new product(idProduct, nameProd, priceProd, alertQuantity);
						//addProduct(p);
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
				JButton btnAddSupplier = new JButton("Add supplier");
				btnAddSupplier.setBounds(199, 234, 110, 23);
				contentPanel.add(btnAddSupplier);
				
				JLabel lblQuantityInThe = new JLabel("Quantity in the reservation :");
				lblQuantityInThe.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblQuantityInThe.setBounds(10, 269, 243, 14);
				contentPanel.add(lblQuantityInThe);
				
				txtFieldResQuantity = new JTextField();
				txtFieldResQuantity.setColumns(10);
				txtFieldResQuantity.setBounds(251, 267, 58, 20);
				contentPanel.add(txtFieldResQuantity);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0)
					{
						dispose();
					}
				});
			}
		}
	}
	
	public boolean isNumber(String price)
	{
		int iPrice;
		try{
			iPrice = Integer.parseInt(price);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		return true;
	}
	
	public boolean isValidInputName(String name)
	{
		for(int i = 0; i < name.length(); i++)
		{
			if((name.charAt(i) >= 48 && name.charAt(i) <= 57) ||
					(name.charAt(i) >= 65 && name.charAt(i) <= 90) ||
						(name.charAt(i) >= 97 && name.charAt(i) <= 122))
			{
				continue;
			}
			return false;
		}
		return true;
	}
}

