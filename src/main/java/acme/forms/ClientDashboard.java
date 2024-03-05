
package acme.forms;

import acme.client.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDashboard extends AbstractForm {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	Double						progressLogsRateBelow25;
	Integer						progressLogsWithCompletenessBelow25Percent;
	Integer						progressLogsWithCompleteness25To50Percent;
	Integer						progressLogsWithCompleteness50To75Percent;
	Integer						progressLogsWithCompletenessAbove75Percent;

	Double						averageContractBudget;
	Double						deviationContractBudget;
	Double						minContractBudget;
	Double						maxContractBudget;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------
}
