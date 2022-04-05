package tr.edu.yeditepe.locationverifier.application.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Objects;

import tr.edu.yeditepe.locationverifier.application.BeaconService;
import tr.edu.yeditepe.locationverifier.application.LocationVerifierService;
import tr.edu.yeditepe.locationverifier.application.NtpService;
import tr.edu.yeditepe.locationverifier.application.TotpService;
import tr.edu.yeditepe.locationverifier.application.UserService;
import tr.edu.yeditepe.locationverifier.domail.model.beacon.Beacon;
import tr.edu.yeditepe.locationverifier.domail.model.request.Request;
import tr.edu.yeditepe.locationverifier.domail.model.request.RequestRepository;
import tr.edu.yeditepe.locationverifier.domail.model.user.User;

@Component
public class LocationVerifierServiceImpl implements LocationVerifierService{
	
	@Autowired
	NtpService ntpService;
	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired 
	TotpService totpService;
	
	@Autowired 
	BeaconService beaconService;
	
	@Override
	public boolean requestHandler(String crypedMessage) throws IOException {
		long timeStamp = ntpService.getTime();
		String[] crypedMessages = crypedMessage.split("###");
		User test = userService.findUserId(crypedMessages[0]);
		Beacon beacon = beaconService.findByBeaconId("BeaconId");
		User prover = userService.findUserId(crypedMessages[0]);
		requestRepository.save(Request.builder()
				.beaconId("BeaconId")
				.otp(totpService.GenerateTotpWithTime(timeStamp, beacon.getAlgorithm(),beacon.getPrecision()))
				.time(timeStamp)
				.user(prover)
				.proverOtp(totpService.GenerateTotpWithTime(timeStamp, prover.getPseudoId(),beacon.getPrecision()))
				.build());
		return true;
		
	}

}
