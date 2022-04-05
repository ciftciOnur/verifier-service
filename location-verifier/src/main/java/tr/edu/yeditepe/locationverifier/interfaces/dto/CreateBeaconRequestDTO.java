package tr.edu.yeditepe.locationverifier.interfaces.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBeaconRequestDTO {
	
	private String algorithm;
	private int precision;

}
