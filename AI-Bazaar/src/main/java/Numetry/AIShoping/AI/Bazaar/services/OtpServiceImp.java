package Numetry.AIShoping.AI.Bazaar.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class OtpServiceImp implements OtpService{
	
	private Map<String, Integer> otpData = new HashMap<>();
	
	@Override
	public int generateOtp(String email) {
		int otp = new Random().nextInt(900000) + 100000; // 6-digit OTP
        otpData.put(email, otp);
        return otp;
		
	}

	@Override
	public boolean verifyOtp(String email, int otp) {
		Integer storedOtp = otpData.get(email);
        if (storedOtp != null && storedOtp.equals(otp)) {
            otpData.remove(email);
            return true;
        }
        return false;
		
	}
	
}
