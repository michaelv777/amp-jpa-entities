package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the target database table.
 * 
 */
@Entity
@Table(name="target")
@NamedQuery(name="Target.findAll", query="SELECT t FROM Target t")
public class Target implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long targetid;

	@Column(nullable=false, length=100)
	private String company;

	@Column(length=512)
	private String description;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to TargettypeM
	@ManyToOne
	@JoinColumn(name="TARGET2TARGETTYPE", nullable=false)
	private TargettypeM targettypeM;

	public Target() {
	}

	public long getTargetid() {
		return this.targetid;
	}

	public void setTargetid(long targetid) {
		this.targetid = targetid;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public TargettypeM getTargettypeM() {
		return this.targettypeM;
	}

	public void setTargettypeM(TargettypeM targettypeM) {
		this.targettypeM = targettypeM;
	}

}