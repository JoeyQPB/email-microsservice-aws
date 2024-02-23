package emailservice.adapters;

public interface IEmailSenderGatway {
	
	void sendEmail(String to, String subject, String body);

}
