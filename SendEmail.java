/* SendEmail class
 */

import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

/**
 * SendEmail is responsible to send emails to the customer that are entitled to
 * an offer
 * 
 * SendEmail gets an array of recepients' mails and names and the products the
 * company is to offer It contacts the gmail server, logs into the gmail account
 * of the company and then prepares and sends a personalized message to each
 * customer
 * 
 * @author Katerina Dimatou
 *
 */
public class SendEmail {

	public void sendMail(String [] recepients,String [] names,String [] productsToOffer) throws Exception{

		System.out.println("Ready to send email");
		Properties properties = new Properties();

		/*
		 * Contacting the gmail server
		 */
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		/*
		 * Giving access to the gmail account of our team
		 */

		String myAccount = "detgifthub";
		String password = "promotionmail";

		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccount, password);
			}
		});

		/**
		 * sending the email by calling the prepareMessage method in order to create the
		 * message and by using the for loop to send the email to every email on the
		 * array
		 */
		for (int i = 0; i < recepients.length; i++) {
			Message message = prepareMessage(session, myAccount, recepients[i], names[i], productsToOffer[i]);
			Transport.send(message);
		}

		System.out.println("Message sent succesfully");
	}

	/**
	 * Method that is given the account of the sender and the account of the
	 * recepient, the subject and the message of the mail and returns the whole
	 * message to be sent
	 */
	private static Message prepareMessage(Session session, String myAccount, String recepients, String names,
			String productToOffer) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccount));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepients));
			message.setSubject("Ξ�Ο�Ξ± Ξ³ΞΉΞ± Ξ΄Ο�Ο�Ξ±!");
			message.setText("Ξ‘Ξ³Ξ±Ο€Ξ·Ο„Ξ­/Ξ®" + " " + names + "," + System.lineSeparator() + System.lineSeparator()
					+ "Ξ•Ξ―ΞΌΞ±ΟƒΟ„Ξµ ΟƒΟ„Ξ·Ξ½ ΞµΟ…Ο‡Ξ¬Ο�ΞΉΟƒΟ„Ξ· ΞΈΞ­ΟƒΞ· Ξ½Ξ± ΟƒΞ±Ο‚ ΞµΞ½Ξ·ΞΌΞµΟ�Ο�ΟƒΞΏΟ…ΞΌΞµ Ο�Ο„ΞΉ "
					+ "Ξ­Ο†Ο„Ξ±ΟƒΞµ Ξ· Ο�Ο�Ξ± Ξ½Ξ± ΟƒΞ±Ο‚ ΞµΟ€ΞΉΞ²Ο�Ξ±Ξ²ΞµΟ�ΟƒΞΏΟ…ΞΌΞµ Ξ³ΞΉΞ± Ο„Ξ·Ξ½ Ο€Ο�ΞΏΟ„Ξ―ΞΌΞ·ΟƒΞ· Ο€ΞΏΟ… ΞΌΞ±Ο‚ Ξ΄ΞµΞ―Ο‡Ξ½ΞµΟ„Ξµ ΞΌΞµ Ξ­Ξ½Ξ± Ξ΄Ο�Ο�ΞΏ Ξ³ΞΉΞ± ΞµΟƒΞ¬Ο‚, Ξ­Ξ½Ξ± Ο€Ο�ΞΏΟ�Ο�Ξ½ ΞµΞ½Ο„ΞµΞ»Ο�Ο‚ Ξ΄Ο‰Ο�ΞµΞ¬Ξ½. "
					+ "Ξ”ΞΉΞΊΞ±ΞΉΞΏΟ�ΟƒΟ„Ξµ Ο„ΞΏ Ο€Ο�ΞΏΟ�Ο�Ξ½ ΞΌΞµ Ο„ΞΏΞ½ ΞΊΟ‰Ξ΄ΞΉΞΊΟ� " + productToOffer
					+ " ΞΊΞ±ΞΉ ΞΌΟ€ΞΏΟ�ΞµΞ―Ο„Ξµ Ξ½Ξ± Ο„ΞΏ Ο€Ξ±Ο�Ξ±Ξ»Ξ¬Ξ²ΞµΟ„Ξµ ΟƒΟ„ΞΏ ΞΊΞ±Ο„Ξ¬ΟƒΟ„Ξ·ΞΌΞ± Ο„Ξ·Ο‚ ΞµΟ€ΞΉΞ»ΞΏΞ³Ξ®Ο‚ "
					+ "ΟƒΞ±Ο‚ ΞΌΞµ Ο„ΞΏ Ο�Ξ½ΞΏΞΌΞ¬ ΟƒΞ±Ο‚ ΞΊΞ±ΞΉ Ο„ΞΏΞ½ ΞΊΟ‰Ξ΄ΞΉΞΊΟ� Ο„ΞΏΟ… Ο€Ο�ΞΏΟ�Ο�Ξ½Ο„ΞΏΟ‚ Ο€ΞΏΟ… ΟƒΞ±Ο‚ Ξ±Ο€ΞΏΟƒΟ„Ξ­Ξ»Ξ»ΞµΟ„Ξ±ΞΉ." + System.lineSeparator()
					+ System.lineSeparator() + "Ξ�Ξµ ΞµΞΊΟ„Ξ―ΞΌΞ·ΟƒΞ·, " + "Ο€Ξ¬Ξ½Ο„Ξ± Ξ±Ο€Ο� ΞµΞΌΞ¬Ο‚ Ξ³ΞΉΞ± ΞµΟƒΞ¬Ο‚!");
			return message;
		} catch (Exception ex) {
			Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
