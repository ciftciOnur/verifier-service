package tr.edu.yeditepe.locationverifier.application.impl;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tr.edu.yeditepe.locationverifier.application.BeaconService;
import tr.edu.yeditepe.locationverifier.application.NtpService;
import tr.edu.yeditepe.locationverifier.application.TotpService;
import tr.edu.yeditepe.locationverifier.domail.model.beacon.Beacon;
import tr.edu.yeditepe.locationverifier.domail.model.beacon.BeaconRepository;
import tr.edu.yeditepe.locationverifier.interfaces.dto.CreateBeaconResponseDTO;

@Component
public class BeaconServiceImpl implements BeaconService{
	
	@Autowired
	BeaconRepository beaconRepository;
	
	@Autowired
	NtpService ntpService;
	
	@Autowired
	TotpService totpService;
	
	@Override
	public CreateBeaconResponseDTO crateBeacon(Long beaconTime) throws IOException {
		Long verifierTime = ntpService.getTime();
		String algorithm = totpService.GenerateTotpAlgorithm();
		
		UUID beaconId = UUID.randomUUID();
		beaconRepository.save(Beacon.builder()
				.algorithm(algorithm)
				.beaconId(beaconId.toString())
				.precisionNumber(verifierTime-beaconTime)
				.build());
		return CreateBeaconResponseDTO.builder()
				.algorithm(algorithm)
				.beaconId(beaconId.toString())
				.precision(verifierTime-beaconTime)
				.build();
				
	}
	
	@Override
	public Beacon findByBeaconId(String beaconId) {
		if(beaconRepository.existsByBeaconId(beaconId))
			return beaconRepository.findByBeaconId(beaconId);
		return null;
	}

}
