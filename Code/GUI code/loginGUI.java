import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JInternalFrame;


public class loginGUI extends JDialog
{

  private final JPanel contentPanel= new JPanel();
  private JPasswordField passwordField;
  private JTextField textFieldUsername;
  

	public loginGUI(mainWindows m)
	{
		super(m, true);
		setTitle("Identification");
		setBounds(100, 100, 464, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(12, 225, 226, 21);
		contentPanel.add(passwordField);

		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblUsername.setBounds(12, 125, 150, 30);
		contentPanel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPassword.setBounds(13, 199, 163, 20);
		contentPanel.add(lblPassword);

		JLabel lblLogIn = new JLabel("Enter your username and your password for identification :");
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogIn.setBounds(20, 84, 428, 30);
		contentPanel.add(lblLogIn);

		JButton btnAddNewUser = new JButton("Add New User");
		btnAddNewUser.setBounds(262, 282, 136, 51);
		contentPanel.add(btnAddNewUser);

		JButton btnAddNewManager = new JButton("Add New Manager");
		btnAddNewManager.setBounds(52, 283, 136, 51);
		contentPanel.add(btnAddNewManager);
		
		JLabel lblWelcomToIms = new JLabel("Welcome to IMS");
		lblWelcomToIms.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblWelcomToIms.setBounds(72, 11, 343, 47);
		contentPanel.add(lblWelcomToIms);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 69, 448, 17);
		contentPanel.add(separator);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(12, 156, 226, 20);
		contentPanel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						String getUsername = textFieldUsername.getText();
						char[] getPassword = passwordField.getPassword();
						String res = "";
						for(int i = 0; i < getPassword.length; i++)
						{
							res = res + getPassword[i];
//							System.out.println(res);
						}
						if(isValidInput(getUsername, getPassword) == true)
						{
							database db = new database();
							/*if(db.isManagerExist(getUsername) == true)
							{
								JOptionPane.showMessageDialog(null, "Username already exist !", "Username already exist", JOptionPane.WARNING_MESSAGE);
							}*/
							if(db.isUserInSystem(getUsername,res) == true)
								dispose();
							else
								JOptionPane.showMessageDialog(null, "You are not in the IMS", "Warning", JOptionPane.WARNING_MESSAGE);
							manager man = new manager(getUsername, res, "manager");
							//db.addManager(man);
							 // close the jdialog	*/ 
						}
					}
				});
			}
			
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0); // close the application when click on cancel button
				}
				});
			}
			setVisible(true);
		}
	}
	/*Check the validity of the username and password input - valid = numbers or letters*/
	public boolean isValidInput(String username, char[] password)
	{
		boolean input_username = true;
		boolean input_password = true;
		for(int i = 0; i < username.length(); i++)
		{
			if((username.charAt(i) >= 48 && username.charAt(i) <= 57) ||
					(username.charAt(i) >= 65 && username.charAt(i) <= 90) ||
						(username.charAt(i) >= 97 && username.charAt(i) <= 122))
			{
				continue;
			}
			input_username = false;
			break;
		}
		for(int i = 0; i < password.length; i++)
		{
			if((password[i] >= 48 && password[i] <= 57) ||
					(password[i] >= 65 && password[i] <= 90) ||
						(password[i] >= 97 && password[i] <= 122))
			{
				continue;
			}
			input_password = false;
			break;
		}
		
		if(input_username == false && input_password == false)
		{
			System.out.println("bad username and password !");
			JOptionPane.showMessageDialog(this, "Bad input username and password !", "Error Input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(input_username == true && input_password == false)
		{
			System.out.println("bad password !");
			JOptionPane.showMessageDialog(this, "Bad password !", "Error Input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(input_username == false && input_password == true)
		{
			System.out.println("bad username !");
			JOptionPane.showMessageDialog(this, "Bad Username !", "Error Input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}