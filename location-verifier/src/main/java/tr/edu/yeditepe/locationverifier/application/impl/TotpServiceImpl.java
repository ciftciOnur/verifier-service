package tr.edu.yeditepe.locationverifier.application.impl;

import java.security.Key;
import java.time.Instant;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;

import tr.edu.yeditepe.locationverifier.application.TotpService;

@Component
public class TotpServiceImpl implements TotpService{
	
	
	TimeBasedOneTimePasswordGenerator totpGenerator;
	
	@Override
	public String GenerateTotp() {
		
		final Instant now = Instant.now();
		final Instant later = now.plus(totpGenerator.getTimeStep());
		try {		
		final Key key;
			{
			    final KeyGenerator keyGenerator = KeyGenerator.getInstance(totpGenerator.getAlgorithm());

				    // Key length should match the length of the HMAC output (160 bits for SHA-1, 256 bits
				    // for SHA-256, and 512 bits for SHA-512). Note that while Mac#getMacLength() returns a
				    // length in _bytes,_ KeyGenerator#init(int) takes a key length in _bits._
				    int macLengthInBytes;
	
					macLengthInBytes = Mac.getInstance(totpGenerator.getAlgorithm()).getMacLength();
	
			    keyGenerator.init(macLengthInBytes * 8);
	
			    key = keyGenerator.generateKey();
	
			}
	
			System.out.println("Current password: " + totpGenerator.generateOneTimePasswordString(key, now));
			System.out.println("Future password:  " + totpGenerator.generateOneTimePasswordString(key, later));
		} 
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return null;
	}
}
