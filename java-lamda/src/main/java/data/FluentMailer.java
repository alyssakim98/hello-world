package data;

import java.util.function.Consumer;

public class FluentMailer
{
	private String fromUser;
	private String toUser;
	private String mailSubject;
	private String messageBody;
	
	private FluentMailer(){
	}
	
	public FluentMailer from(final String address){
		fromUser = address;
		return this;
	}
	
	public FluentMailer to(final String address){
		toUser = address;
		return this;
	}
	
	public FluentMailer subject(final String line){
		mailSubject = line;
		return this;
	}
	
	public FluentMailer body(final String message){
		messageBody = message;
		return this;
	}
	
	public static void send(final Consumer<FluentMailer> block){
		final FluentMailer mailer = new FluentMailer();
		block.accept(mailer);
		System.out.println(">>> sending...\n"
				+ " - from("+mailer.fromUser+") \n"
				+ " - to("+mailer.toUser+") \n"
				+ " - subjet("+mailer.mailSubject+") \n"
				+ " - message("+mailer.messageBody+")\n");
	}
}
