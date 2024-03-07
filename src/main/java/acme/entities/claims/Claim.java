/*
 * Claim.java
 *
 * Copyright (C) 2024 Andres Garcia.
 *
 */

package acme.entities.claims;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
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
public class Claim extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^C-[0-9]{4}$", message = "{validation.claim.code}")
	private String				code;

	@Past
	@Temporal(TemporalType.TIMESTAMP)
	private Date				instantiationMoment;

	@NotBlank
	@Max(75)
	private String				heading;

	@NotBlank
	@Max(100)
	private String				description;

	@NotBlank
	@Max(100)
	private String				department;

	@Email
	@Max(255)
	private String				optionalEmail;

	@URL
	@Max(255)
	private String				optionalLink;
}
