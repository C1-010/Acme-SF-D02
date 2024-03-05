
package acme.entities.objectives;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Objective extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date				instantiationMoment;

	@NotBlank
	@Length(max = 75)
	private String				title;

	@NotBlank
	@Length(max = 100)
	private String				description;

	private Priority			priority;

	//If status=1 the objective is critical, if not the objective is not critical
	private boolean				status;

	//TODO the objective must start at any moment after the instantiation moment
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				duration;

	@URL
	@Length(max = 255)
	private String				optionalLink;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------
}
