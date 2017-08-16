package data;

public class MailBuiler
{
	private String fromUser;
	private String toUser;
	private String mailSubject;
	private String messageBody;
	
	public MailBuiler from(final String address){
		fromUser = address;
		return this;
	}
	
	public MailBuiler to(final String address){
		toUser = address;
		return this;
	}
	
	public MailBuiler subject(final String line){
		mailSubject = line;
		return this;
	}
	
	public MailBuiler body(final String message){
		messageBody = message;
		return this;
	}
	
	public void send() {
		System.out.println(">>> sending...\n" + " - from(" + fromUser + ") \n" + " - to(" + toUser + ") \n"
				+ " - subjet(" + mailSubject + ") \n" + " - message(" + messageBody + ")\n");
	}
}
