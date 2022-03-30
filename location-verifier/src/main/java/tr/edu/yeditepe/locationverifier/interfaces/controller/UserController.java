package tr.edu.yeditepe.locationverifier.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.yeditepe.locationverifier.application.UserService;
import tr.edu.yeditepe.locationverifier.interfaces.dto.CreateUserRequestDTO;
import tr.edu.yeditepe.locationverifier.interfaces.dto.CreateUserResponseDTO;
import tr.edu.yeditepe.locationverifier.interfaces.dto.PseudoIdUpdateDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    ResponseEntity<CreateUserResponseDTO> createUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) {
    	CreateUserResponseDTO createUserResponseDTO = userService.createUser(createUserRequestDTO.getPassword());
        return new ResponseEntity<CreateUserResponseDTO>(createUserResponseDTO, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/update-pseudoid", method = RequestMethod.PUT)
    ResponseEntity<String> updatePseudoId(@RequestBody PseudoIdUpdateDTO pseudoIdUpdateDTO) {
        return new ResponseEntity<String>(userService
        		.updatePseudoId(pseudoIdUpdateDTO.getUserId(), pseudoIdUpdateDTO.getPassword()), HttpStatus.OK);
    }
    

}
