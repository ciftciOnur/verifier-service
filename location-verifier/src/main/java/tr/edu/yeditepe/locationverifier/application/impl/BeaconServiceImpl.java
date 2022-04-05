package tr.edu.yeditepe.locationverifier.application.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tr.edu.yeditepe.locationverifier.application.BeaconService;
import tr.edu.yeditepe.locationverifier.domail.model.beacon.Beacon;
import tr.edu.yeditepe.locationverifier.domail.model.beacon.BeaconRepository;

@Component
public class BeaconServiceImpl implements BeaconService{
	
	@Autowired
	BeaconRepository beaconRepository;
	
	@Override
	public String crateBeacon(String algorithm, Integer precision) {
		UUID beaconId = UUID.randomUUID();
		beaconRepository.save(Beacon.builder()
				.algorithm(algorithm)
				.beaconId(beaconId.toString())
				.precisionNumber(precision)
				.build());
		return beaconId.toString();
	}
	
	@Override
	public Beacon findByBeaconId(String beaconId) {
		if(beaconRepository.existsByBeaconId(beaconId))
			return beaconRepository.findByBeaconId(beaconId);
		return null;
	}

}
