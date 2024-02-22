
package acme.entities.projects;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
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
	@Max(100)
	private List<String>		correctiveActions;

	@NotBlank
	@Max(100)
	private List<Integer>		mark;


	public int calculateMark() {
		if (this.mark.isEmpty())
			return 0; // No marks available, return 0

		int[] occurrences = new int[101];

		for (int mark : this.mark)
			occurrences[mark]++;

		int maxOccurrences = 0;
		int mode = 0;

		for (int i = 0; i < occurrences.length; i++)
			if (occurrences[i] > maxOccurrences) {
				maxOccurrences = occurrences[i];
				mode = i;
			}
		return mode;
	}


	@URL
	private String furtherInformationLink;

}
