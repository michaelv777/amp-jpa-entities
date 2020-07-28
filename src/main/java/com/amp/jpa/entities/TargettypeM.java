package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the targettype_m database table.
 * 
 */
@Entity
@Table(name="targettype_m")
@NamedQuery(name="TargettypeM.findAll", query="SELECT t FROM TargettypeM t")
public class TargettypeM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long targettypeid;

	@Column(length=256)
	private String desciption;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to Target
	@OneToMany(mappedBy="targettypeM")
	private Set<Target> targets;

	public TargettypeM() {
	}

	public long getTargettypeid() {
		return this.targettypeid;
	}

	public void setTargettypeid(long targettypeid) {
		this.targettypeid = targettypeid;
	}

	public String getDesciption() {
		return this.desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Target> getTargets() {
		return this.targets;
	}

	public void setTargets(Set<Target> targets) {
		this.targets = targets;
	}

	public Target addTarget(Target target) {
		getTargets().add(target);
		target.setTargettypeM(this);

		return target;
	}

	public Target removeTarget(Target target) {
		getTargets().remove(target);
		target.setTargettypeM(null);

		return target;
	}

}