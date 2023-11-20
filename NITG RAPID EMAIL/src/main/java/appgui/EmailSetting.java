package appgui;

import mailutils.GenerateEmail;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmailSetting {

	private static JFrame frmRapidMail;
	private static JTextField textField_1;
	private static JButton btnNewButton;
	private static JPasswordField passwordField;
//Second Window
	public static void EmailSet() {
		try {
			initialize();
			frmRapidMail.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void initialize() {
		frmRapidMail = new JFrame();
		frmRapidMail.setTitle("Rapid Mail");
		frmRapidMail.setBounds(100, 100, 542, 306);
		frmRapidMail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmRapidMail.getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel(" Email Address:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 68, SpringLayout.NORTH, frmRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 95, SpringLayout.WEST, frmRapidMail.getContentPane());
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		frmRapidMail.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 17));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 41, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 131, SpringLayout.WEST, frmRapidMail.getContentPane());
		frmRapidMail.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, -178, SpringLayout.SOUTH, frmRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 24, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 236, SpringLayout.EAST, lblNewLabel);
		frmRapidMail.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("NEXT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRapidMail.dispose();
				GenerateEmail ob = new GenerateEmail();
				ob.setEmail(textField_1.getText(),String.valueOf(passwordField.getPassword()));
				EmailWindow.SelectionWindow();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 214, SpringLayout.WEST, frmRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -33, SpringLayout.SOUTH, frmRapidMail.getContentPane());
		frmRapidMail.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 17));
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 41, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 30, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, textField_1);
		frmRapidMail.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("*Less Secure App Access has to be enabled for the email being used.");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 83, SpringLayout.WEST, frmRapidMail.getContentPane());
		frmRapidMail.getContentPane().add(lblNewLabel_2);
	}
}
