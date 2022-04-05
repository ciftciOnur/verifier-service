package tr.edu.yeditepe.locationverifier.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.yeditepe.locationverifier.application.BeaconService;
import tr.edu.yeditepe.locationverifier.interfaces.dto.CreateBeaconRequestDTO;


@RestController
@RequestMapping("/api/beacons")
public class BeaconController {
	
	@Autowired
	BeaconService beaconService;
	
    @RequestMapping(value = "/create-beacon", method = RequestMethod.POST)
    ResponseEntity<String> createBeacon(@RequestBody CreateBeaconRequestDTO request) {
        return new ResponseEntity<String>(beaconService
        		.crateBeacon(request.getAlgorithm(),  request.getPrecision()), HttpStatus.CREATED);
    }

}
