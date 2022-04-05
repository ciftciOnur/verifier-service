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
	private int id;
	private String algorithm;
	private int precisionNumber;
	private String beaconId;

}
