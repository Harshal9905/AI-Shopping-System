package Numetry.AIShoping.AI.Bazaar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendOtpMail(String to, int otp) {
		 SimpleMailMessage message = new SimpleMailMessage();
	     message.setTo(to);
	     message.setSubject("OTP Verification");
	     message.setText("Your OTP for registration is: " + otp);
	     mailSender.send(message);
	}
}
