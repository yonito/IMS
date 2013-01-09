

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainWindows extends JFrame
{
		private JPanel contentPane;
		
		public static void main(String[] args)
		{
			presentationWindows pres = new presentationWindows();
			//inventory  i = new inventory();
			//i.getInventory();
			loginThread login_thread;
			
			//
			//mainWin.setVisible(false);
			// open = new presentationWindows();
			mainWindows mainWin = new mainWindows();
			login_thread = new loginThread(mainWin);
			
			login_thread.run();
			mainWin.setVisible(true);
		}
		public mainWindows()
		{
			setVisible(false);
			this.setLocationRelativeTo(null);
			setForeground(Color.WHITE);
			setTitle("IMS : Inventory Manager Software");
			setAlwaysOnTop(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 604, 581);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 152, 153)); //color of background
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			/*Button add product*/
			JButton btnAddProduct = new JButton("ADD PRODUCT");
			btnAddProduct.setFont(new Font("Data", Font.PLAIN, 18));
			btnAddProduct.setBounds(41, 226, 215, 103);
			contentPane.add(btnAddProduct);
			btnAddProduct.setToolTipText("Add product into the inventory.");
			btnAddProduct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					new Thread(new Runnable() {
						public void run() {
							addProductGUI addProdWin = new addProductGUI();
							addProdWin.setVisible(true);
							addProdWin.setAlwaysOnTop(true); // tjrs au dessus des autres fenetres
						} // end of run()	 
					  }).start();
				}
			});
			
			/*Button Reservation*/
			JButton btnReservation = new JButton("RESERVATION");
			btnReservation.setFont(new Font("Data", Font.PLAIN, 18));
			btnReservation.setBounds(330, 226, 215, 103);
			btnReservation.setToolTipText("Send a new reservation.");
			contentPane.add(btnReservation);
			btnReservation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					new Thread(new Runnable() {
						public void run() {
							reservationGUI reservationWin = new reservationGUI();
							reservationWin.setVisible(true);
							reservationWin.setAlwaysOnTop(true); // tjrs au dessus des autres fenetres
						} // end of run()	 
					  }).start();
				}
			});
			
			/*Button Inventory*/
			JButton btnInventory = new JButton("INVENTORY");
			btnInventory.setFont(new Font("Data", Font.PLAIN, 18));
			btnInventory.setBounds(41, 388, 504, 103);
			btnInventory.setToolTipText("Get the detail of the inventory.");
			contentPane.add(btnInventory);
			btnInventory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					new Thread(new Runnable() {
						public void run() {
							inventoryGUI inventoryWin = new inventoryGUI();
							inventoryWin.setVisible(true);
							inventoryWin.setAlwaysOnTop(true); // tjrs au dessus des autres fenetres
						} // end of run()	 
					  }).start();
				}
			});
			
			JLabel lblNewLabel = new JLabel("Welcome to IMS");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Data", Font.PLAIN, 46));
			lblNewLabel.setBounds(108, 28, 374, 78);
			contentPane.add(lblNewLabel);
			
			JLabel lblYourInventor = new JLabel("Your inventory is in good situation !");
			lblYourInventor.setFont(new Font("Data", Font.PLAIN, 20));
			lblYourInventor.setBounds(118, 105, 342, 56);
			contentPane.add(lblYourInventor);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(0, 184, 588, 12);
			contentPane.add(separator);
			
			//setVisible(true);
		}
}