package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exceptions.EmailServiceException;
import usecases.IEmailSenderService;
import usecases.DTO.EmailResquestDTO;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {

	private IEmailSenderService emailSenderService;

	@Autowired
	public EmailSenderController(IEmailSenderService emailSender) {
		this.emailSenderService = emailSender;
	}

	@PostMapping("/")
	public ResponseEntity<String> sendEmail(@RequestBody EmailResquestDTO emailRequst) {
		try {
			this.emailSenderService.sendEmail(emailRequst.to(), emailRequst.subject(), emailRequst.body());
			return ResponseEntity.ok("Email send successfully");

		} catch (EmailServiceException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email!");
		}
	}
}
