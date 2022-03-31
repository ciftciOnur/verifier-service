package tr.edu.yeditepe.locationverifier.interfaces.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.yeditepe.locationverifier.application.LocationVerifierService;
import tr.edu.yeditepe.locationverifier.interfaces.dto.RequestDTO;


@RestController
@RequestMapping("/api/verify")
public class VerifyController {
	
	@Autowired
	LocationVerifierService locationVerifierSerice;
	
	
    @RequestMapping(value = "/request", method = RequestMethod.POST)
    ResponseEntity<Boolean> saveInitialRequest(@RequestBody RequestDTO requestDTO) throws IOException {
        return new ResponseEntity<Boolean>(locationVerifierSerice.requestHandler(requestDTO.getEncryptedString()), HttpStatus.OK);
    }
	

}
