package co.edu.uqvirtual.proyectofinal.controllers;

import java.awt.HeadlessException;
import java.security.NoSuchProviderException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class EnvioCorreos extends javax.swing.JFrame {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String emailFrom = "santiagomaring05@gmail.com";
	    private static String passwordFrom = "xvdmltpsrjmknzrw";
	    private String emailTo;
	    private String subject;
	    private String content;

	    private Properties mProperties;
	    private Session mSession;
	    private MimeMessage mCorreo;

	    
	    
	    public EnvioCorreos() throws HeadlessException {
			super();
			mProperties = new Properties();
		}

		

	    public void createEmail(String para,String encabezado,String mensaje) {
	        emailTo = para;
	        subject = encabezado;
	        content = mensaje;
	        
	         // Simple mail transfer protocol
	        mProperties.put("mail.smtp.host", "smtp.gmail.com");
	        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	        mProperties.setProperty("mail.smtp.starttls.enable", "true");
	        mProperties.setProperty("mail.smtp.port", "587");
	        mProperties.setProperty("mail.smtp.user",emailFrom);
	        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
	        mProperties.setProperty("mail.smtp.auth", "true");
	        
	        mSession = Session.getDefaultInstance(mProperties);
	        
	        
	        try {
	            mCorreo = new MimeMessage(mSession);
	            mCorreo.setFrom(new InternetAddress(emailFrom));
	            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
	            mCorreo.setSubject(subject);
	            mCorreo.setText(content, "ISO-8859-1", "html");
	                     
	            
	        } catch (AddressException ex) {
	            Logger.getLogger(EnvioCorreos.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (MessagingException ex) {
	            Logger.getLogger(EnvioCorreos.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    public void sendEmail() {
	        try {
	            Transport mTransport = mSession.getTransport("smtp");
	            mTransport.connect(emailFrom, passwordFrom);
	            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
	            mTransport.close();
	            
	            JOptionPane.showMessageDialog(null, "Correo enviado");
	        } catch (MessagingException ex) {
	            Logger.getLogger(EnvioCorreos.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
}