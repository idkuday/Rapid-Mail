package appgui;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class ShowUpdate {

	private JFrame frmNitgRapidMail;
	public JLabel lblNewLabel;
	public JProgressBar progressBar;
	private int bar;
	private String update;
	private JLabel lblNewLabel_1;
	public ShowUpdate(int proglimit) {
		initialize(proglimit);
		frmNitgRapidMail.setVisible(true);
		bar =0;
	}
	public void update(String message,int progress) {
        update = message;
        bar= progress;
		
	}
	public void setMessage(String message) {
		update = message;
		lblNewLabel.setText(update);
		
	}
	public int getProgress(){
		return bar;
	}
	public String getUpdate() {
		return update;
	}
	public void complete(boolean x) {
		if(x) 
		lblNewLabel_1.setText("Process Complete!");
		else
			lblNewLabel_1.setText("Operation Failed.");
		
	}
	
	

	private void initialize(int proglimit) {
		frmNitgRapidMail = new JFrame();
		frmNitgRapidMail.setTitle("Rapid Mail");
		frmNitgRapidMail.setBounds(100, 100, 730, 604);
		frmNitgRapidMail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmNitgRapidMail.getContentPane().setLayout(springLayout);
		
		progressBar = new JProgressBar(0,proglimit);
		progressBar.setBackground(Color.BLACK);
		progressBar.setForeground(Color.GREEN);
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 29));
		springLayout.putConstraint(SpringLayout.NORTH, progressBar, 93, SpringLayout.NORTH, frmNitgRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, progressBar, 35, SpringLayout.WEST, frmNitgRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, progressBar, 134, SpringLayout.NORTH, frmNitgRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, progressBar, -35, SpringLayout.EAST, frmNitgRapidMail.getContentPane());
		frmNitgRapidMail.getContentPane().add(progressBar);
		
		lblNewLabel = new JLabel("Opening Session......");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 26, SpringLayout.SOUTH, progressBar);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 54, SpringLayout.WEST, frmNitgRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -64, SpringLayout.EAST, frmNitgRapidMail.getContentPane());
		frmNitgRapidMail.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setForeground(new Color(32, 178, 170));
		lblNewLabel_1.setFont(new Font("FreeSans", Font.BOLD, 29));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 134, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 64, SpringLayout.WEST, frmNitgRapidMail.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 189, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		frmNitgRapidMail.getContentPane().add(lblNewLabel_1);
	}
}