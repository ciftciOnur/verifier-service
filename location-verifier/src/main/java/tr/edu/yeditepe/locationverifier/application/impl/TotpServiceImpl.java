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
	public String GenerateTotpAlgorithm() {
		return totpGenerator.getAlgorithm();
	}
	
	@Override
	public String GenerateTotpWithTime(long time,String algorithm,long precision) {
		
		time = (time/precision)*precision;
        Instant instant = Instant.ofEpochMilli(time);
		try {		
		final Key key;
			{
			    final KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
				    int macLengthInBytes;
					macLengthInBytes = Mac.getInstance(algorithm).getMacLength();
			    keyGenerator.init(macLengthInBytes * 8);
			    key = keyGenerator.generateKey();
			}
	
			return totpGenerator.generateOneTimePasswordString(key, instant);
		} 
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return null;
	}
	
}
