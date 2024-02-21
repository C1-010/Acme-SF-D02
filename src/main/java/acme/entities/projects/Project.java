/*
 * Project.java
 *
 * Copyright (C) 2012-2024 Andres Garcia.
 *
 */

package acme.entities.projects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Project extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Column(unique = true)
	@Pattern(regexp = "[A-Z]{3}-[0-9]{4}", message = "Code must follow the pattern '[A-Z]{3}-[0-9]{4}'")
	@NotBlank
	private String				code;

	@NotBlank
	@Max(75)
	private String				title;

	@NotBlank
	@Max(100)
	@Column(name = "abstract")
	private String				abstractInfo;

	private boolean				hasFatalErrors;

	@PositiveOrZero
	private double				cost;

	@URL
	private String				furtherInformationLink;

	// Relationships ----------------------------------------------------------

}
