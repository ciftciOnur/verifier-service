package tr.edu.yeditepe.locationverifier.interfaces.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateBeaconResponseDTO {
	
	String totpKey;
	String beaconId;
	Long precision;

}
