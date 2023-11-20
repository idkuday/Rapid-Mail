package appgui;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileFilter;

import mailutils.GenerateEmail;

import javax.swing.JLabel;
import javax.swing.JTextField;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class EmailWindow {

	private static SpringLayout springLayout;
	private static JFrame frmNitRapidEmail;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JButton btnfilepath, btnSendMails;
	
	
	
	public static void SelectionWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start();
					initialize();
					frmNitRapidEmail.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
					
				}
			}
		});
	}


	public static void start() {
		frmNitRapidEmail = new JFrame();
		frmNitRapidEmail.setTitle("RAPID MAIL");
		frmNitRapidEmail.setBounds(100, 100, 1089, 638);
		frmNitRapidEmail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		springLayout = new SpringLayout();
		frmNitRapidEmail.getContentPane().setLayout(springLayout);
		
		
	}
	
	
	private static void setButton() {
		btnSendMails = new JButton("SEND EMAILS!");
		springLayout.putConstraint(SpringLayout.WEST, btnSendMails, 436, SpringLayout.WEST, frmNitRapidEmail.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnSendMails, -116, SpringLayout.SOUTH, frmNitRapidEmail.getContentPane());
		btnSendMails.setFont(new Font("FreeMono", Font.BOLD, 22));
		frmNitRapidEmail.getContentPane().add(btnSendMails);
		frmNitRapidEmail.setVisible(true);
		btnSendMails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
     			String path = textField.getText();
				String sheet = textField_1.getText();
				String subject = textField_2.getText();
				
					
					try {
						frmNitRapidEmail.dispose();
						start();
						new GenerateEmail();
						GenerateEmail.sendMail(path, sheet, subject);
					}
					catch (Exception e) {
						(new ShowUpdate(0)).setMessage("Mail Operation Failed or Invalid Sheet Name");
					}
					
				
			
		}});
	}
	
	
	private static void initialize() {
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 171, SpringLayout.NORTH, frmNitRapidEmail.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 531, SpringLayout.WEST, frmNitRapidEmail.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 204, SpringLayout.NORTH, frmNitRapidEmail.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, -282, SpringLayout.EAST, frmNitRapidEmail.getContentPane());
		frmNitRapidEmail.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblSheetName = new JLabel("Sheet Name :");
		springLayout.putConstraint(SpringLayout.NORTH, lblSheetName, 248, SpringLayout.NORTH, frmNitRapidEmail.getContentPane());
		lblSheetName.setFont(new Font("FreeMono", Font.BOLD, 24));
		frmNitRapidEmail.getContentPane().add(lblSheetName);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblSheetName, -49, SpringLayout.WEST, textField_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, 7, SpringLayout.SOUTH, lblSheetName);
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 43, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		frmNitRapidEmail.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		
		JLabel lblEmailSubject = new JLabel("Email Subject :");
		springLayout.putConstraint(SpringLayout.NORTH, lblEmailSubject, 54, SpringLayout.SOUTH, lblSheetName);
		lblEmailSubject.setFont(new Font("FreeMono", Font.BOLD, 24));
		frmNitRapidEmail.getContentPane().add(lblEmailSubject);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblEmailSubject, -49, SpringLayout.WEST, textField_2);
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, -1, SpringLayout.NORTH, lblEmailSubject);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, 79, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		frmNitRapidEmail.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		btnfilepath = new JButton("Choose Spreadsheet ");
		btnfilepath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser("");
				chooser.addChoosableFileFilter(new FileFilter() {

					@Override
					public boolean accept(File f) {
						if(f.isDirectory())
						return  true;
						else if(f.getName().toLowerCase().endsWith(".xlsx"))
							return true;
						else 
							return f.getName().toLowerCase().endsWith(".xls");
					}

					@Override
					public String getDescription() {
						return "Spreadsheet Files (*.xls ,  *.xlsx)";
					}
					
				});
				File file;
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int resp = chooser.showOpenDialog(null);
				file = chooser.getSelectedFile();
				if((resp==JFileChooser.APPROVE_OPTION) && ((file.getName().toLowerCase().endsWith(".xlsx"))||(file.getName().toLowerCase().endsWith(".xls"))) ) {
					textField.setText(file.getAbsolutePath());	
					setButton();
				}
				else {
					textField.setText("PLEASE CHOOSE A SPREADSHEET.");
					frmNitRapidEmail.getContentPane().remove(btnSendMails);
					
				}						
			}
		});
		
		springLayout.putConstraint(SpringLayout.NORTH, btnfilepath, 0, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, btnfilepath, -224, SpringLayout.WEST, lblSheetName);
		springLayout.putConstraint(SpringLayout.SOUTH, btnfilepath, -44, SpringLayout.NORTH, lblSheetName);
		springLayout.putConstraint(SpringLayout.EAST, btnfilepath, -69, SpringLayout.WEST, textField);
		btnfilepath.setFont(new Font("FreeMono", Font.BOLD, 24));
		frmNitRapidEmail.getContentPane().add(btnfilepath);
	}
	
}