/*
 * UserStory.java
 *
 * Copyright (C) 2024 Andres Garcia.
 *
 */

package acme.entities.userStories;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserStory extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Max(75)
	private String				title;

	@NotBlank
	@Max(100)
	private String				description;

	@Positive
	private int					estimatedCost;

	@NotBlank
	@Max(100)
	private String				acceptanceCriteria;

	@NotNull
	private Priority			priority;

	@URL
	@Max(255)
	private String				furtherInformationLink;
}
