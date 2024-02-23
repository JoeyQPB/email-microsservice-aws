package infra.ses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

import adapters.IEmailSenderGatway;
import exceptions.EmailServiceException;

@Service
public class SesEmailSender implements IEmailSenderGatway {

	private AmazonSimpleEmailService amazonSimpleEmailService;
	
	@Autowired
	public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
		this.amazonSimpleEmailService = amazonSimpleEmailService;
	}
	
	
	@Override
	public void sendEmail(String to, String subject, String body) {
		SendEmailRequest request = new SendEmailRequest()
				.withSource("joeyquadros5@gmail.com")
				.withDestination(new Destination().withToAddresses(to))
				.withMessage(new Message().withSubject(new Content(body)));
		
		try {
			this.amazonSimpleEmailService.sendEmail(request);
		} catch (AmazonServiceException e) {
			 throw new EmailServiceException("Error while sent email!", e.getMessage(), e);
		}
	}

}
