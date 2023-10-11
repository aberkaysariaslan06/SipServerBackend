package sipserver.sipwebserver.entities.concretes;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "domains")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Domain {
	@Id
	@Column(name = "domain_id")
	private int domainId;

	@Column(name = "domain_name")
	private String domainName;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "domain")
	private List<Call> calls;
	
	/*	
	@Column(name = "user_id")
	private long userId;

	@Column(name = "call_id")
	private long callId;
	*/
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE) //bir user silindiginde onun yaptigi tum aramalar silinecek
	@JsonIgnore
	private User user;
	*/
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "call_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE) //bir user silindiginde onun yaptigi tum aramalar silinecek
	@JsonIgnore
	private Call call;
	*/



	/*
	@Column(name = "start_time")
	private LocalDateTime startTime;

	@Column(name = "end_time")
	private LocalDateTime endTime;
*/

}
