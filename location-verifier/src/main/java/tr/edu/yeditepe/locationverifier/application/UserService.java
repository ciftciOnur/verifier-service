package tr.edu.yeditepe.locationverifier.application;

import tr.edu.yeditepe.locationverifier.domail.model.user.User;
import tr.edu.yeditepe.locationverifier.interfaces.dto.CreateUserResponseDTO;

public interface UserService {

	CreateUserResponseDTO createUser(String password);

	String updatePseudoId(String userId, String password);

	byte[] findPseudoId(String pseudoId);

	User findUserId(String userId);

}
