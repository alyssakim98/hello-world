package data;

public class Mail {
	private String fromUser;
	private String toUser;
	private String mailSubject;
	private String messageBody;
	
	public void from(final String address){
		fromUser = address;
	}

	public void to(final String address){
		toUser = address;
	}

	public void subject(final String line){
		mailSubject = line;
	}

	public void body(final String message){
		messageBody = "Mail: "+message;
	}

	public void send(){
		System.out.println(">>> sending...\n"
				+ " - from("+fromUser+") \n"
				+ " - to("+toUser+") \n"
				+ " - subjet("+mailSubject+") \n"
				+ " - message("+messageBody+")\n");
	}
}
