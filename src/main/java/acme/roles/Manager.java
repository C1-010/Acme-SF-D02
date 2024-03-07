/*
 * Manager.java
 *
 * Copyright (C) 2024 Andres Garcia.
 *
 */

package acme.roles;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Manager extends AbstractRole {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Max(75)
	private String				degree;

	@NotBlank
	@Max(100)
	private String				overview;

	@NotBlank
	@Max(100)
	private String				certifications;

	@URL
	@Max(255)
	private String				optionalLink;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
