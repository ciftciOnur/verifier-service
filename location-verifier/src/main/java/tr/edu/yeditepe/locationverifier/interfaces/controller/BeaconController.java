package tr.edu.yeditepe.locationverifier.interfaces.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.yeditepe.locationverifier.application.BeaconService;
import tr.edu.yeditepe.locationverifier.interfaces.dto.CreateBeaconRequestDTO;
import tr.edu.yeditepe.locationverifier.interfaces.dto.CreateBeaconResponseDTO;


@RestController
@RequestMapping("/api/beacons")
public class BeaconController {
	
	@Autowired
	BeaconService beaconService;
	
    @RequestMapping(value = "/create-beacon", method = RequestMethod.POST)
    ResponseEntity<CreateBeaconResponseDTO> createBeacon(@RequestBody CreateBeaconRequestDTO request) throws IOException {
        return new ResponseEntity<CreateBeaconResponseDTO>(beaconService.crateBeacon(request.getTime()), HttpStatus.CREATED);
    }

}
