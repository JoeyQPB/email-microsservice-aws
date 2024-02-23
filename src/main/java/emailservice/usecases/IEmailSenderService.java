package emailservice.usecases;

public interface IEmailSenderService {
	
	void sendEmail(String to, String subject, String body);

}
