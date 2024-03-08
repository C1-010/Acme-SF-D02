/*
 * UserStory.java
 *
 * Copyright (C) 2024 Andres Garcia.
 *
 */

package acme.entities.userStories;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

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
	@Size(max = 75)
	private String				title;

	@NotBlank
	@Size(max = 100)
	private String				description;

	@Positive
	private int					estimatedCost;

	@NotBlank
	@Size(max = 100)
	private String				acceptanceCriteria;

	@NotNull
	private Priority			priority;

	@URL
	@Size(max = 255)
	private String				furtherInformationLink;
}
