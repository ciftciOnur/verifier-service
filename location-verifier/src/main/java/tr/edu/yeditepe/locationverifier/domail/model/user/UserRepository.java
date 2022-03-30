package tr.edu.yeditepe.locationverifier.domail.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	User findByPseudoId(String pseudoId);
	
	User findByUserId(String userId);
	
	boolean existsByPseudoId(String pseudoId);
}
