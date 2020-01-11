package com.progII.gifthub;

import static org.junit.Assert.*;

import org.junit.Test;

public class SendEmailTest {

	@Test
	public void test() throws Exception {
		String mails [] = { "katerina.dimatou@gmail.com"};
		String names [] = {"Katerina Dimatou"};
		String prods [] = {"002"};
		
		InfoMail a = new InfoMail(mails,names,prods);
		
		SendEmail.sendMail(a);
	}

}


