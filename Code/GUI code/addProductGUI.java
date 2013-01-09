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
	public static addProductGUI thisFrame;
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
		
		JLabel lblIDprod = new JLabel(""+product.counterID);
		lblIDprod.setBounds(10, 85, 179, 20);
		contentPanel.add(lblIDprod);
		
		JLabel lblNamesProduct = new JLabel("Name's product :");
		lblNamesProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNamesProduct.setBounds(10, 116, 179, 14);
		contentPanel.add(lblNamesProduct);
		
		txtNameProd = new JTextField();
		txtNameProd.setColumns(10);
		txtNameProd.setBounds(10, 135, 179, 20);
		contentPanel.add(txtNameProd);
		
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
		
		
		supplier[] s = db.getSupplierList();
		int lengthListSupllier = s.length;
		String[] nameSupplierList = new String[lengthListSupllier];
		for(int i = 0; i < lengthListSupllier; i++)
		{
			if(i == 0)
				nameSupplierList[i] = " ";
			else
				nameSupplierList[i] = s[i].name;
		}
		final JComboBox<String> comboBoxSupplier = new JComboBox<String> (nameSupplierList);
		comboBoxSupplier.setBounds(10, 235, 179, 20);
		contentPanel.add(comboBoxSupplier);
		
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
					public void actionPerformed(ActionEvent e)
					{
						String nameProd = "";
						int priceProd = -1, reservQuantity = -1, alertQuantity = -1;
						if(isValidInputName(txtNameProd.getText()) == true)
							nameProd = txtNameProd.getText();
						if(isNumber(txtPrice.getText()) == true)
							priceProd = Integer.parseInt(txtPrice.getText());
						if(isNumber(txtFieldResQuantity.getText()) == true)
							reservQuantity = Integer.parseInt(txtFieldResQuantity.getText());
						if(isNumber(txtQuantity.getText()) == true)
							alertQuantity = Integer.parseInt(txtQuantity.getText());
						if(priceProd == -1 || reservQuantity == -1 || alertQuantity == -1 || nameProd == "")
							JOptionPane.showInternalMessageDialog(addProductGUI.getAddProductGUI(), "Error in information's format", "Error", JOptionPane.ERROR_MESSAGE);
						else // the input is valid
						{
							Object selectedSupplierName = comboBoxSupplier.getSelectedItem();
							String mailOfSelectedSupplier = db.emailOfSupplier((String)selectedSupplierName);
							supplier sup = new supplier((String) selectedSupplierName, mailOfSelectedSupplier);
							product newProd = new product(nameProd, priceProd, reservQuantity, reservQuantity, alertQuantity, sup);
							int res = newProd.addProduct();
							if(res != 0)
								JOptionPane.showInternalMessageDialog(addProductGUI.getAddProductGUI(), "The product wasn't added", "Error", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showInternalMessageDialog(addProductGUI.getAddProductGUI(), "The product was added !", "Successful", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
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
	
	public static addProductGUI getAddProductGUI()
	{
		if(thisFrame == null)
			return new addProductGUI();
		return thisFrame;
	}
}

