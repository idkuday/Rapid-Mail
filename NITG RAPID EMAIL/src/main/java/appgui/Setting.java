package appgui;

import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import mailutils.GenerateEmail;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class Setting  {

	private static JFrame frmNitgRapidMail;
	private static JTextField textField;
	private static JTextField textField_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

		try {
			initialize();
			Setting.frmNitgRapidMail.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
			}
		});
			
	}

	private static void initialize() {
			    
		
		frmNitgRapidMail = new JFrame();
		frmNitgRapidMail.setResizable(false);
		frmNitgRapidMail.setTitle("Rapid Mail");
		frmNitgRapidMail.setBounds(100, 100, 660, 402);
		frmNitgRapidMail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmNitgRapidMail.getContentPane().setLayout(springLayout);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("SMTP Enabled");
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox, 182, SpringLayout.WEST, frmNitgRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, chckbxNewCheckBox, -227, SpringLayout.SOUTH, frmNitgRapidMail.getContentPane());
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setToolTipText("");
		frmNitgRapidMail.getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_2 = new JLabel("Host :");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 171, SpringLayout.WEST, frmNitgRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -130, SpringLayout.SOUTH, frmNitgRapidMail.getContentPane());
		frmNitgRapidMail.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 274, SpringLayout.WEST, frmNitgRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -31, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 235, SpringLayout.NORTH, frmNitgRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField, 215, SpringLayout.NORTH, frmNitgRapidMail.getContentPane());
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		frmNitgRapidMail.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Port Number:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 25, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 139, SpringLayout.WEST, frmNitgRapidMail.getContentPane());
		frmNitgRapidMail.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, -16, SpringLayout.WEST, textField_1);
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 0, SpringLayout.NORTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		frmNitgRapidMail.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("TLS Encryption Enabled");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 13, SpringLayout.SOUTH, chckbxNewCheckBox_1);
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_1, 6, SpringLayout.SOUTH, chckbxNewCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_1, 0, SpringLayout.WEST, chckbxNewCheckBox);
		springLayout.putConstraint(SpringLayout.SOUTH, chckbxNewCheckBox_1, -172, SpringLayout.SOUTH, frmNitgRapidMail.getContentPane());
		frmNitgRapidMail.getContentPane().add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel = new JLabel("Configurations:");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox, 39, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, chckbxNewCheckBox, 0, SpringLayout.EAST, lblNewLabel);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 30));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 38, SpringLayout.NORTH, frmNitgRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 123, SpringLayout.WEST, frmNitgRapidMail.getContentPane());
		frmNitgRapidMail.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Use Above Config.");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -30, SpringLayout.NORTH, btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNitgRapidMail.dispose();				
				GenerateEmail ob =new GenerateEmail();
				ob.setSmtp(String.valueOf(chckbxNewCheckBox.isSelected()));
				ob.setTls(String.valueOf(chckbxNewCheckBox_1.isSelected()));
				ob.setHost(textField.getText());
				ob.setPort(textField_1.getText());
				EmailSetting.EmailSet();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -29, SpringLayout.SOUTH, frmNitgRapidMail.getContentPane());
		frmNitgRapidMail.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Use Default Config.");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 274, SpringLayout.WEST, frmNitgRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -28, SpringLayout.WEST, btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNitgRapidMail.dispose();
				try(FileInputStream fos= new FileInputStream("./Set.bin")) {
					ObjectInputStream oos = new ObjectInputStream(fos);
					GenerateEmail ob = (GenerateEmail) oos.readObject();
					ob.restoreData();
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
     			EmailSetting.EmailSet();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, btnNewButton);
		frmNitgRapidMail.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Set as Default Configuration");
		springLayout.putConstraint(SpringLayout.EAST, textField, -74, SpringLayout.WEST, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.EAST, chckbxNewCheckBox_1, -98, SpringLayout.WEST, btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName= "./Set.bin";
				try (FileOutputStream fos= new FileOutputStream(fileName)) {
					GenerateEmail ob =new GenerateEmail();
					ob.setSmtp(String.valueOf(chckbxNewCheckBox.isSelected()));
					ob.setTls(String.valueOf(chckbxNewCheckBox_1.isSelected()));
					ob.setHost(textField.getText());
					ob.setPort(textField_1.getText());
					ob.saveData();
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(ob);
				    oos.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -155, SpringLayout.SOUTH, frmNitgRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -10, SpringLayout.EAST, frmNitgRapidMail.getContentPane());
		frmNitgRapidMail.getContentPane().add(btnNewButton_2);
	}
}
