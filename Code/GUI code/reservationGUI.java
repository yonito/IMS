import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Dialog.ModalityType;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.DropMode;


public class reservationGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the dialog.
	 */
	public reservationGUI() {
		setTitle("New reservation");
		setAlwaysOnTop(true);
		setBounds(100, 100, 523, 502);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);


		JLabel lblNamesProduct = new JLabel("Name's product :");
		lblNamesProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNamesProduct.setBounds(10, 83, 118, 14);
		contentPanel.add(lblNamesProduct);

		textField = new JTextField();
		textField.setBounds(10, 102, 146, 20);
		contentPanel.add(textField);
		textField.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantity.setBounds(10, 133, 118, 14);
		contentPanel.add(lblQuantity);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 152, 73, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblChooseASupplier = new JLabel("Choose a supplier :");
		lblChooseASupplier.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChooseASupplier.setBounds(10, 35, 146, 14);
		contentPanel.add(lblChooseASupplier);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 52, 146, 20);
		contentPanel.add(comboBox);

		JTextArea txtrMessageForThe = new JTextArea();
		txtrMessageForThe.setToolTipText("");
		txtrMessageForThe.setText("Your message...");
		txtrMessageForThe.setBounds(10, 202, 486, 205);
		contentPanel.add(txtrMessageForThe);

		JLabel lblNewLabel = new JLabel("Email content for the supplier :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 183, 203, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Send reservation");
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