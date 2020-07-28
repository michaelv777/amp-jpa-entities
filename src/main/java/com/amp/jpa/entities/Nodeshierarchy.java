package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nodeshierarchy database table.
 * 
 */
@Entity
@Table(name="nodeshierarchy")
@NamedQuery(name="Nodeshierarchy.findAll", query="SELECT n FROM Nodeshierarchy n")
public class Nodeshierarchy implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NodeshierarchyPK id;

	public Nodeshierarchy() {
	}

	public NodeshierarchyPK getId() {
		return this.id;
	}

	public void setId(NodeshierarchyPK id) {
		this.id = id;
	}

}