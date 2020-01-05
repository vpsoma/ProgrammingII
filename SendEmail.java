
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

public class SendEmail {

	public static void sendMail(String[] recepients, String [] names, String [] products_to_offer ) throws Exception {

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

		/*
		 * sending the email by calling the prepareMessage method in order to create the
		 * message and by using the for loop to send the email to every email on the
		 * array
		 */
		for (int i = 0; i < recepients.length; i++) {
			Message message = prepareMessage(session, myAccount, recepients[i], names[i], products_to_offer[i]);
			Transport.send(message);
		}

		System.out.println("Message sent succesfully");
	}

	/*
	 * Method that is given the account of the sender and the account of the
	 * recepient, the subject and the message of the mail and returns the whole
	 * message to be sent
	 */
	private static Message prepareMessage(Session session, String myAccount, String recepients, String names, String products_to_offer) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccount));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepients));
			message.setSubject("Ώρα για δώρα!");
			message.setText("Αγαπητέ/ή" + " " + names + "," + System.lineSeparator() + System.lineSeparator() + "Είμαστε στην ευχάριστη θέση να σας ενημερώσουμε ότι "
					+ "έφτασε η ώρα να σας επιβραβεύσουμε για την προτίμηση που μας δείχνετε με ένα δώρο για εσάς, ένα προϊόν εντελώς δωρεάν. "
					+ "Δικαιούστε το προϊόν με τον κωδικό "+ products_to_offer + " και μπορείτε να το παραλάβετε στο κατάστημα της επιλογής "
					+ "σας με το όνομά σας και τον κωδικό του προϊόντος που σας αποστέλλεται." + System.lineSeparator() + System.lineSeparator() + "Με εκτίμηση, "
					+ "πάντα από εμάς για εσάς!");
			return message;
		} catch (Exception ex) {
			Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
