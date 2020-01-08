
public class InfoMail {
	private String [] namesOfCustomersForGifts;
	private String [] mailsOfCustomersForGifts;
	private String [] namesOfProductsAsGifts;
	
	
	public InfoMail (String [] mailsOfCustomersForGifts, String [] namesOfCustomersForGifts, String [] namesOfProductsAsGifts ) {
		this.setMailsOfCustomersForGifts(mailsOfCustomersForGifts);
		this.setNamesOfCustomersForGifts(namesOfCustomersForGifts);
		this.setNamesOfProductsAsGifts(namesOfProductsAsGifts);
	}


	public String [] getNamesOfCustomersForGifts() {
		return namesOfCustomersForGifts;
	}


	public void setNamesOfCustomersForGifts(String [] namesOfCustomersForGifts) {
		this.namesOfCustomersForGifts = namesOfCustomersForGifts;
	}


	public String [] getMailsOfCustomersForGifts() {
		return mailsOfCustomersForGifts;
	}


	public void setMailsOfCustomersForGifts(String [] mailsOfCustomersForGifts) {
		this.mailsOfCustomersForGifts = mailsOfCustomersForGifts;
	}


	public String [] getNamesOfProductsAsGifts() {
		return namesOfProductsAsGifts;
	}


	public void setNamesOfProductsAsGifts(String [] namesOfProductsAsGifts) {
		this.namesOfProductsAsGifts = namesOfProductsAsGifts;
	}
}
