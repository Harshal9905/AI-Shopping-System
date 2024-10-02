package Numetry.AIShoping.AI.Bazaar.services;

public interface OtpService {
	
	public int generateOtp(String email);
	
	public boolean verifyOtp(String email, int otp);
}
