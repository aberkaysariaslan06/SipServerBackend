package sipserver.sipwebserver.entities.concretes;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "calls")
@Data 
public class Call {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "call_id")	
	private int callId;	

	/*
	@Column(name = "domain_id")
	private int domainId;
*/
	@Column(name = "call_name")
	private String callName;

	@Column (name = "duration_sec")	
	private int durationSecond;

	@Column(name = "status")
	private String callStatus;

	@Column(name = "start_time")
	private LocalDateTime startTime;

	@Column(name = "end_time")
	private LocalDateTime endTime;
	
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name="domain_id")
	private Domain domain;

	//@JoinColumn(name = "domain_id")
	/*
	@Column (name = "user_id")	
	private long userId; //aramayi yapan kullanicin	in kimligi
	/*
	@Column (name = "calle_id")	
	private long calleeId; //aranılan kullanicinin kimligi
	*/
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE) //bir user silindiginde onun yaptigi tum aramalar silinecek
	@JsonIgnore
	private User user;	
	*/

}