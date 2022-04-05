package tr.edu.yeditepe.locationverifier.domail.model.beacon;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "beacon")
public class Beacon {
	
	@Id
	int id;
	String algorithm;
	int precision;
	String beaconId;

}
