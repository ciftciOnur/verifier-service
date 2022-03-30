package tr.edu.yeditepe.locationverifier.domail.model.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User {
	
    @Id
    private int id;
    
    private String userId;
    private String pseudoId;
    private byte[] aesSalt;
    private	byte[] password;
    private byte[] passwordSalt;
    private LocalDate expirationDate;

}
