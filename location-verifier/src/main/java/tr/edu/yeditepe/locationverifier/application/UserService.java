package tr.edu.yeditepe.locationverifier.application;

import tr.edu.yeditepe.locationverifier.interfaces.dto.CreateUserResponseDTO;

public interface UserService {

	CreateUserResponseDTO createUser(String password);

	String updatePseudoId(String userId, String password);

}
