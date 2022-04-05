package tr.edu.yeditepe.locationverifier.application;

import tr.edu.yeditepe.locationverifier.domail.model.beacon.Beacon;

public interface BeaconService {

	Beacon findByBeaconId(String BeaconId);

	String crateBeacon(String algorithm, Integer precision);

}
