package emailservice.application;

import org.springframework.stereotype.Service;

import emailservice.adapters.IEmailSenderGatway;
import emailservice.usecases.IEmailSenderService;

@Service
public class EmailSenderService implements IEmailSenderService {

	private IEmailSenderGatway emailSenderGatway;
	
	public EmailSenderService(IEmailSenderGatway emailSenderGatway) {
		this.emailSenderGatway = emailSenderGatway;
	}
	
	@Override
	public void sendEmail(String to, String subject, String body) {
		this.emailSenderGatway.sendEmail(to, subject, body);
	}

}
