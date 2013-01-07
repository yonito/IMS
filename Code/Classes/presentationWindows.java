import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.JProgressBar;
import javax.swing.plaf.ProgressBarUI;
import java.awt.Font;


public class presentationWindows extends JDialog
{
	static JProgressBar progressBar; 
	Image logoIMS;
	public presentationWindows()
	{		
		//setUndecorated(false);
		setBounds(100, 100, 809, 430);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setVisible(true);
		
		progressBar = new JProgressBar(0,100);
		progressBar.setStringPainted(true);
		progressBar.setBounds(200, 346, 370, 14);
		getContentPane().add(progressBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Yoni\\Desktop\\Projet\\power point\\IMS.gif"));
		lblNewLabel.setBounds(168, 11, 430, 324);
		getContentPane().add(lblNewLabel);
		
		JLabel lblLoading = new JLabel("Loading...");
		lblLoading.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoading.setBounds(345, 323, 100, 19);
		getContentPane().add(lblLoading);
		//progressBar.setIndeterminate(true);
		
		for(int i = 0; i <= 100; i++)
		{
			final int percent = i;
			try{
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						updateBar(percent);
					}
				});
				Thread.sleep(60);
			} catch(InterruptedException e){}
		}
		//toFront();
		setVisible(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
				
		    
	}
	
	public void updateBar(int newValue)
	{
	    progressBar.setValue(newValue);
	}
}

