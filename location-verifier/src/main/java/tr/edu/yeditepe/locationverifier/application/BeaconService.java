package tr.edu.yeditepe.locationverifier.application;

import tr.edu.yeditepe.locationverifier.domail.model.beacon.Beacon;

public interface BeaconService {

	void crateBeacon(String algorithm, String beaconId, Integer precision);

	Beacon findByBeaconId(String BeaconId);

}
