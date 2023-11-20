package mailutils;
import appgui.*;
import excelutil.ExcelStoreData;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.SwingWorker;
import java.io.*;

public class GenerateEmail implements Runnable, Serializable{

	private static final long serialVersionUID = 1L;
	private static ExcelStoreData obj;
	private static String eid, update, smtp, tls,host,port,pass;
	private String smtp1, tls1,host1,port1;
	private static ShowUpdate win;
	private static String path, sheet, sub;
	private static Session session;
	private static Thread t;
	public int d;
	public void saveData() {
		smtp1=smtp;
		tls1=tls;
		host1=host;
		port1=port;
	}
	public void restoreData() {
		smtp=smtp1;
		tls=tls1;
		host=host1;
		port=port1;
	}
	public void setSmtp(String val) {
		smtp=val;
	}
	
	public void setTls(String val) {
		tls=val;
	}
	public void setHost(String val) {
		host =val;
	}
	public void setPort(String val) {
		port=val;
	}
	public void setEmail(String email, String password) {
		eid =email;
		pass=password;
	}
	
	 public static void background() {
	    	SwingWorker<Void, Void> W = new SwingWorker<Void, Void>(){
	    		@Override
	    		protected Void doInBackground() throws Exception {
	    			Thread.sleep(50);
	    			win.lblNewLabel.setText(win.getUpdate());
	    			win.progressBar.setValue(win.getProgress());
					return null;
	    			
	    		}
	    		
	    	};
	    	W.execute();
	    }
	public static void sendMail(String path1,String sheet1, String sub1) throws Exception
	{
		
		Properties properties= new Properties();
		properties.put("mail.smtp.auth", smtp);
		properties.put("mail.smtp.starttls.enable", tls);
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		path=path1;
		sheet=sheet1;
		sub = sub1;

		final String pwd = pass;

		session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(eid, pwd);
			}

		});
		Runnable r = new GenerateEmail();
		t=new Thread(r);
		t.start();
	}
				

	private static Message getMessage(Session s, String recipient, String arr[][],String sub, String text)
	{
		Message m = new MimeMessage(s);
		try {
			m.setFrom(new InternetAddress(eid));
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			m.setSubject(sub);
			m.setText(text);
			return m;

		} catch (Exception e) {
			win.setMessage("Failed to send email to "+recipient+"\n");
			e.printStackTrace();

			return null;}

	}

	@Override

	public  void run() {
		String text;
		try {
		obj = new ExcelStoreData(path, sheet);
		}
		catch(NullPointerException e) {
			ShowUpdate object = new ShowUpdate(0);
			object.setMessage("Invalid Sheet Name");
			object.complete(false);
			
			
		}
		String arr[][]= obj.student();
		win = new ShowUpdate(obj.total);

		for(int i=0;i<obj.total;i++)
		{
			
			text=arr[i][0]+" - "+arr[i][1]+"\n\n";
			for(int j=3;j<obj.a.length;j++)
				text+=obj.a[j]+" : "+arr[i][j]+"\n\n";
			Message m = getMessage(session, arr[i][2], arr,sub,text);
			try {
				Transport.send(m);
			} catch (MessagingException e) {
				win.setMessage("Transport Failed to "+arr[i][1]);
				e.printStackTrace();
				continue;
			}
			update ="Email sent to "+arr[i][0]+" - "+arr[i][1]+"."+"\n";
			win.update(update , i+1);
			background();
			
		}
		win.complete(true);


	}
		 
}

		
		





