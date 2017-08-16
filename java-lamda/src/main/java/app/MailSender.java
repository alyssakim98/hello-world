package app;

import data.FluentMailer;
import data.Mail;
import data.MailBuiler;

public class MailSender implements Runnable {
	public static void main(String[] args) {
		Thread thread = new Thread(new MailSender());
		thread.start();
	}

	@Override
	public void run() {
		Mail mail = new Mail();
		mail.from("alyssa");
		mail.to("keumju");
		mail.subject("hello");
		mail.body("nice to meet you!!!");
		mail.send();
		
		new MailBuiler()
		.from("keumju")
		.to("alyssa")
		.subject("RE: hello")
		.body("nice to meet you too!!!")
		.send();
		
		FluentMailer.send(mailer 
				-> mailer.from("alyssa.kim98")
				.to("alyssa.kim")
				.subject("who are you??")
				.body("we know each other??")
				);
	}
}
