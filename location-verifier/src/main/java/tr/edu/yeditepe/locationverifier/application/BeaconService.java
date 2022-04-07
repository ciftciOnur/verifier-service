package tr.edu.yeditepe.locationverifier.application;

import java.io.IOException;

import tr.edu.yeditepe.locationverifier.domail.model.beacon.Beacon;
import tr.edu.yeditepe.locationverifier.interfaces.dto.CreateBeaconResponseDTO;

public interface BeaconService {

	Beacon findByBeaconId(String BeaconId);

	CreateBeaconResponseDTO crateBeacon(Long beaconTime) throws IOException;

}
