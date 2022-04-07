package tr.edu.yeditepe.locationverifier.application.impl;

import java.time.LocalDate;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import tr.edu.yeditepe.locationverifier.application.PasswordService;
import tr.edu.yeditepe.locationverifier.application.UserService;
import tr.edu.yeditepe.locationverifier.domail.model.user.User;
import tr.edu.yeditepe.locationverifier.domail.model.user.UserRepository;
import tr.edu.yeditepe.locationverifier.interfaces.dto.CreateUserResponseDTO;

@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordService passwordService;
	
	@Transactional
	@Override
	public CreateUserResponseDTO createUser(String password) {
		byte[] passwordSalt = passwordService.getNextSalt();
		byte[] aesSalt = passwordService.getNextSalt();
		UUID userId = UUID.randomUUID();
		UUID pseudoId = UUID.randomUUID();
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		userRepository.save(User.builder()
				.passwordSalt(passwordSalt)
				.password(passwordService.hash(password.toCharArray(), passwordSalt))
				.userId(userId.toString())
				.aesSalt(aesSalt)
				.pseudoId(pseudoId.toString())
				.expirationDate(tomorrow)
				.build()
				);
		return CreateUserResponseDTO.builder()
				.aesSalt(Base64.getEncoder().encodeToString(aesSalt))
				.pseudoId(pseudoId.toString())
				.userId(userId.toString())
				.build();
		
	}
	@Transactional
	@Override
	public String updatePseudoId(String userId, String password) {
		
		User user = userRepository.findByUserId(userId);
		if(passwordService.isExpectedPassword(password.toCharArray(), user.getPasswordSalt(), user.getPassword())) {
			UUID pseudoId = UUID.randomUUID();
			LocalDate today = LocalDate.now();
			LocalDate tomorrow = today.plusDays(1);
			user.setPseudoId(pseudoId.toString());
			user.setExpirationDate(tomorrow);
			userRepository.save(user);
			return pseudoId.toString();
		}
		return null;	
	}
	@Override
	public byte[] findPseudoId(String pseudoId) {
		if(!userRepository.existsByPseudoId(pseudoId)) {
			return null;
		}
		User user = userRepository.findByPseudoId(pseudoId);
		if(user.getExpirationDate().isBefore(LocalDate.now())) {
			return null;
		}
		return user.getAesSalt();
	}
	
	@Override
	public User findUserId(String userId) {
		if(!userRepository.existsByUserId(userId)) {
			return null;
		}
		return userRepository.findByUserId(userId);
	}

}
