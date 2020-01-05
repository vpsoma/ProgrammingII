/**
 * JavaMail accepts three String[] arrays. The first arrays contains mails,
 * the second names and the third products.
 * Then proceeds to send mails with the sendMail method of 
 * the SendEmail class.
 * <p>
 * JavaMail extends the Thread class.
 */

public class JavaMail extends Thread {
	
	public String[] partOfClients;
	public String[] partOfNames;
	public String[] partOfProducts;
	
	public JavaMail(String[] partOfClients, String[] partOfNames, String[] partOfProducts) {
		/**
		 * Initializes the three arrays.
		 */
		super();
		this.partOfClients = partOfClients;
		this.partOfNames = partOfNames;
		this.partOfProducts = partOfProducts;
	}


	public void run(){
		/**
		 * This method uses the sendMail method of the SendEmail class 
		 * with the three arrays as parameters.
		 * 
		 * @param partOfClients a String array of email addresses.
		 * 		  partOfNames   a String array of names.
		 * 		  partOfProducts a String array of products.
		 * @returns Nothing.
		 * @throws InterruptedException and Exception.
		 * @see InterruptedException and Exception.
		 */
    	try {
    		SendEmail.sendMail(partOfClients, partOfNames, partOfProducts );
    		
    	}catch(InterruptedException e) {
    		System.out.println("An interruption occured.");
    	} catch(Exception e) {
    		System.out.println("An exception occured.");
    	}
	}
}
