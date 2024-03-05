
package acme.entities.codeAudits;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.entities.projects.Project;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CodeAudits extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Column(unique = true)
	@Pattern(regexp = "[A-Z]{1,3}-[0-9]{3}", message = "Code must follow the pattern '[A-Z]{1,3}-[0-9]{3}'")
	@NotBlank
	private String				code;

	@Temporal(TemporalType.DATE)
	@Past(message = "Execution date must be in the past")
	private Date				executionDate;

	@Pattern(regexp = "^(Static|Dynamic)$", message = "Type must be either 'Static' or 'Dynamic'")
	private String				type;

	@NotBlank
	@Length(max = 100)
	private String				correctiveActions;

	//computed as the mode of the marks in the corresponding auditing records;
	//ties must be broken arbitrarily if necessary.

	@NotBlank
	@Length(max = 100)
	private Double				mark;

	@URL
	private String				optionalLink;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Project				project;
}
