package tr.edu.yeditepe.locationverifier.domail.model.request;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tr.edu.yeditepe.locationverifier.domail.model.user.User;

@Getter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "witness")
public class Witness {
	
    @Id
    private int id;
    private String witnessId;
    private Long time;
    
    @ManyToOne
    @JoinColumn(name = "requestId")
    private Request request;
    
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
