/**
 * JavaMail accepts three String[] arrays. The first arrays contains mails,
 * the second names and the third products.
 * Then proceeds to send mails with the sendMail method of 
 * the SendEmail class.
 * <p>
 * JavaMail extends the Thread class.
 * @author vpsoma
 */

public class JavaMail extends Thread {
<<<<<<< HEAD
	private String[] partOfClients;
	private String[] partOfNames;
	private String[] partOfProducts;
	//Initializes a SendMail object.
	SendEmail objectOfSendEmailClass = new SendEmail();
	/**
	 * Initializes the three arrays.
	 */
	public JavaMail(String[] partOfClients, String[] partOfNames, String[] partOfProducts) {
=======
	public String[] partOfClients;
	public String[] partOfNames;
	public String[] partOfProducts;
	public JavaMail(InfoMail object) {
		/**
		 * Initializes the three arrays.
		 */
>>>>>>> dc8e93ba4bbb96085fdf07afc6829915a569fa14
		super();
		this.partOfClients = object.getMailsOfCustomersForGifts();
		this.partOfNames = object.getNamesOfCustomersForGifts();
		this.partOfProducts = object.getNamesOfProductsAsGifts();
	}
<<<<<<< HEAD
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
=======
	InfoMail o = new InfoMail(partOfClients, partOfNames, partOfProducts);
>>>>>>> dc8e93ba4bbb96085fdf07afc6829915a569fa14
	public void run(){
    	try {
<<<<<<< HEAD
    		//Calls the sendMail method in order to send mails.
    		objectOfSendEmailClass.sendMail(partOfClients, partOfNames, partOfProducts);
=======
    		SendEmail.sendMail(o);
>>>>>>> dc8e93ba4bbb96085fdf07afc6829915a569fa14
    	}catch(InterruptedException e) {
    		System.out.println("An interruption occured.");
    	} catch(Exception e) {
    		System.out.println("An exception occured.");
    	}
	}
}
