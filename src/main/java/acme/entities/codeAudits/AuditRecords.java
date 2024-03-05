
package acme.entities.codeAudits;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.entities.codeAudits.codeAudits;
	
public class AuditRecords extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	@Column(unique = true)
	@Pattern(regexp = "AU-[0-9]{4}-[0-9]{3}", message = "Code must follow the pattern 'AU-[0-9]{4}-[0-9]{3}'")
	@NotBlank

	private String				code;

	//at least one hour long
	@Past
	private Date				period;

	@NotNull
	private MarkType			mark;

	@URL
	private String				furtherInformationLink;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private CodeAudits			CodeAudit;
}
