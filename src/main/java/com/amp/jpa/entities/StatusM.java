package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the status_m database table.
 * 
 */
@Entity
@Table(name="status_m")
@NamedQuery(name="StatusM.findAll", query="SELECT s FROM StatusM s")
public class StatusM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long statusid;

	@Column(length=512)
	private String description;

	@Column(nullable=false, length=100)
	private String name;

	public StatusM() {
	}

	public long getStatusid() {
		return this.statusid;
	}

	public void setStatusid(long statusid) {
		this.statusid = statusid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}