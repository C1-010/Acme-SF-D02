
package acme.entities.codeAudits;

public enum MarkType {

	A_PLUS("A+"), A("A"), B("B"), C("C"), F("F"), F_MINUS("F-");


	private final String mark;


	MarkType(final String mark) {
		this.mark = mark;
	}

	public String getCalificacion() {
		return this.mark;
	}

}
