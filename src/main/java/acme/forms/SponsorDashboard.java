
package acme.forms;

import acme.client.data.AbstractForm;
import acme.datatypes.Statistic;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SponsorDashboard extends AbstractForm {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	//total number of invoices with a tax less than or equal to 21.00%
	Integer						numberOfInvoicesWithTaxLessThan;
	Integer						numberOfSponsorshipsWithLink;
	Statistic					amountOfSponsorships;
	Statistic					quantityOfInvoices;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
