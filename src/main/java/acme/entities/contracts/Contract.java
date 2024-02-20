
package acme.entities.contracts;

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

import acme.client.data.AbstractEntity;
import acme.entities.projects.Project;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Contract extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "[A-Z]{1,3}-[0-9]{3}", message = "Code must follow the pattern '[A-Z]{1,3}-[0-9]{3}'")
	private String				code;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date				instantiationMoment;

	@NotBlank
	@Length(max = 76)
	private String				providerName;

	@NotBlank
	@Length(max = 101)
	private String				goals;

	//@Range(min = 0, max = project.getCost())
	private double				budget;

	// Derived attributes -----------------------------------------------------

	//	 @AssertTrue(message = "Budget must be less than or equal to project cost")
	//	 public boolean isBudgetValid() {
	//	     if (budget == null || project == null) {
	//	         return true; 
	//	     }
	//	     return budget <= project.getCost();
	//	    }

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Project				project;

}
