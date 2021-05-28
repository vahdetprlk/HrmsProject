package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmailVerification;

@RestController
@RequestMapping(name = "/api/email-verifications")
public class EmailVerificationsController {
	private EmailVerificationService emailVerificationService;

	@Autowired
	public EmailVerificationsController(EmailVerificationService emailVerificationService) {
		super();
		this.emailVerificationService = emailVerificationService;
	}

	@GetMapping("/getall")
	public DataResult<List<EmailVerification>> getAll() {

		return this.emailVerificationService.getAll();

	}

	@PostMapping("/send-code-to-email")
	public Result sendCodeToEmail(@RequestBody EmailVerification emailVerification) {

		return this.emailVerificationService.sendCodeToEmail(emailVerification);

	}

}
