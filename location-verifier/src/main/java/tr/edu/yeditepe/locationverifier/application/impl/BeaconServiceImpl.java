package tr.edu.yeditepe.locationverifier.application.impl;

import org.springframework.beans.factory.annotation.Autowired;

import tr.edu.yeditepe.locationverifier.application.BeaconService;
import tr.edu.yeditepe.locationverifier.domail.model.beacon.Beacon;
import tr.edu.yeditepe.locationverifier.domail.model.beacon.BeaconRepository;

public class BeaconServiceImpl implements BeaconService{
	
	@Autowired
	BeaconRepository beaconRepository;
	
	@Override
	public void crateBeacon(String algorithm,String beaconId, Integer precision) {
		beaconRepository.save(Beacon.builder()
				.algorithm(algorithm)
				.beaconId(beaconId)
				.precision(precision)
				.build());
	}
	
	@Override
	public Beacon findByBeaconId(String beaconId) {
		if(beaconRepository.existsByBeaconId(beaconId))
			return beaconRepository.findByBeaconId(beaconId);
		return null;
	}

}
