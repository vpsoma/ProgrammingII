import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendUserEmail {
	public static void sendUserMail(String nameOfUser, String emailOfUser, InfoMail object) throws Exception {
		
		String[] names = object.getNamesOfCustomersForGifts();
		String[] productsToOffer = object.getNamesOfProductsAsGifts();

		int numOfGifts = productsToOffer.length;
		
		String peopleOfOffer = String.join(", ", names);
		String productsOfOffer = String.join(", ", productsToOffer);
		
		
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
		
			Message message = prepareMessage(session, myAccount, nameOfUser, emailOfUser, numOfGifts, peopleOfOffer, productsOfOffer) ;
			Transport.send(message);
		

		System.out.println("Message sent succesfully");
	}
	

	/**
	 * Method that is given the account of the sender and the account of the
	 * recepient, the subject and the message of the mail and returns the whole detailed 
	 * message to be sent
	 */
	private static Message prepareMessage(Session session, String myAccount, String nameOfUser, String emailOfUser, int numOfGifts, String peopleOfOffer, String productsOfOffer) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccount));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailOfUser));
			message.setSubject("You have given out presents!");
			message.setText("Dear" + " " + nameOfUser + "," + System.lineSeparator() + System.lineSeparator()
					+ "We are pleased to announce that "
					+ "you have rewarded your most valuable clients for their loyalty with a present. More specifically you have "
					+ " given out " + numOfGifts + " presents which where products that had passed their period of sale!"
					+ " More specifically, a more detailed reference to the generous offer you made lies underneath:" + System.lineSeparator() + System.lineSeparator()
					+ "Clients Rewarded: " + peopleOfOffer + System.lineSeparator() + "Products Given Out: " + productsOfOffer + System.lineSeparator() + System.lineSeparator()
					+ " This was a very good gesture on your behalf in order to show to your clients that you value them!" 
					+ System.lineSeparator() + System.lineSeparator() + "Keep up the good work, " + "always with love, "
					+ System.lineSeparator() + "DetGifthub team");
			return message;
			} catch (Exception ex) {
			Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
			}
		return null;
		
}
}




