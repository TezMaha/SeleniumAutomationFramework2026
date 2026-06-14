package utils;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailUtils {

	public static void sendTestReport(String reportpath) {

		final String senderEmail = "tejasvinigaikwad241@gmail.com";
		final String appPassword = "kppygjspflswsxqk";
		final String receiverEmail = "tejasvinigaikwad241@gmail.com";

		// SMTP server properties

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");

		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, appPassword);

			}
		});

		session.setDebug(true);
		try {
			// create email message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
			message.setSubject("Test Email From QA Automation");
			// message.setText("Hello \n This is a test mail from Java \n Regards, \nQA
			// Team");

			// Email Body Part
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hello   \n This is a test mail from Java    \n Regards, \nQA Team");

			// Attachment Part

			MimeBodyPart attachmentPart = new MimeBodyPart();
			String filePath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
			System.out.println("Attachment path is-" + reportpath);
			attachmentPart.attachFile(new File(reportpath));

			// Combine email body and attachment parts

			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(attachmentPart);
			message.setContent(multipart);

			// send email message

			Transport.send(message);
			System.out.println("Email Sent Successfully***");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
