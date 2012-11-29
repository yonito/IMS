import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;


public class addProductGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Create the dialog.
	 */
	public addProductGUI() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Product identity number :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 66, 179, 14);
		contentPanel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 85, 179, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNamesProduct = new JLabel("Name's product :");
		lblNamesProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNamesProduct.setBounds(10, 116, 179, 14);
		contentPanel.add(lblNamesProduct);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 135, 179, 20);
		contentPanel.add(textField_1);
		
		JLabel lblPricesProduct = new JLabel("Price's product :");
		lblPricesProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPricesProduct.setBounds(10, 166, 179, 14);
		contentPanel.add(lblPricesProduct);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 187, 179, 20);
		contentPanel.add(textField_2);
		
		JLabel lblNamesSupplier = new JLabel("Name's supplier :");
		lblNamesSupplier.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNamesSupplier.setBounds(10, 218, 179, 14);
		contentPanel.add(lblNamesSupplier);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 235, 179, 20);
		contentPanel.add(comboBox);
		
		JLabel lblQuantityBefore = new JLabel("Quantity before first warning alert :");
		lblQuantityBefore.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantityBefore.setBounds(10, 274, 243, 14);
		contentPanel.add(lblQuantityBefore);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(251, 272, 58, 20);
		contentPanel.add(textField_3);
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
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
