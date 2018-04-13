package testHibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Licence {

	@Id
	@GeneratedValue
	@Column(name="licence_id")
	private int id;
	
	private String licenceNumber;

	private Date issueDate;
	
	@OneToOne
	@JoinColumn(name="person_id")
	private Person person; // direction
}

