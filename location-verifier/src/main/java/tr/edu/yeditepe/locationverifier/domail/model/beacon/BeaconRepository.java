package tr.edu.yeditepe.locationverifier.domail.model.beacon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BeaconRepository extends JpaRepository<Beacon,Integer>{
	
	
	public Beacon findByBeaconId(String beaconId);
	
	public boolean existsByBeaconId(String beaconId);
}
