package tr.edu.yeditepe.locationverifier.domail.model.request;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "request")
public class Request {
    
	@Id
    private int id;

    private String beaconId;
    private String otp;
    private Long time;
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Witness> witnesses;
    
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
