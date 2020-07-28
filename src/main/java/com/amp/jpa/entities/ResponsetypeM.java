package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the responsetype_m database table.
 * 
 */
@Entity
@Table(name="responsetype_m")
@NamedQuery(name="ResponsetypeM.findAll", query="SELECT r FROM ResponsetypeM r")
public class ResponsetypeM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long responsetypeid;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to OperationtypeM
	@ManyToOne
	@JoinColumn(name="RESPONSETYPE2OPERATIONTYPE", nullable=false)
	private OperationtypeM operationtypeM;

	//bi-directional many-to-one association to ResponsetypeParameter
	@OneToMany(mappedBy="responsetypeM")
	private Set<ResponsetypeParameter> responsetypeParameters;

	//bi-directional many-to-one association to SourcetypeResponsetypeM
	@OneToMany(mappedBy="responsetypeM")
	private Set<SourcetypeResponsetypeM> sourcetypeResponsetypeMs;

	public ResponsetypeM() {
	}

	public long getResponsetypeid() {
		return this.responsetypeid;
	}

	public void setResponsetypeid(long responsetypeid) {
		this.responsetypeid = responsetypeid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OperationtypeM getOperationtypeM() {
		return this.operationtypeM;
	}

	public void setOperationtypeM(OperationtypeM operationtypeM) {
		this.operationtypeM = operationtypeM;
	}

	public Set<ResponsetypeParameter> getResponsetypeParameters() {
		return this.responsetypeParameters;
	}

	public void setResponsetypeParameters(Set<ResponsetypeParameter> responsetypeParameters) {
		this.responsetypeParameters = responsetypeParameters;
	}

	public ResponsetypeParameter addResponsetypeParameter(ResponsetypeParameter responsetypeParameter) {
		getResponsetypeParameters().add(responsetypeParameter);
		responsetypeParameter.setResponsetypeM(this);

		return responsetypeParameter;
	}

	public ResponsetypeParameter removeResponsetypeParameter(ResponsetypeParameter responsetypeParameter) {
		getResponsetypeParameters().remove(responsetypeParameter);
		responsetypeParameter.setResponsetypeM(null);

		return responsetypeParameter;
	}

	public Set<SourcetypeResponsetypeM> getSourcetypeResponsetypeMs() {
		return this.sourcetypeResponsetypeMs;
	}

	public void setSourcetypeResponsetypeMs(Set<SourcetypeResponsetypeM> sourcetypeResponsetypeMs) {
		this.sourcetypeResponsetypeMs = sourcetypeResponsetypeMs;
	}

	public SourcetypeResponsetypeM addSourcetypeResponsetypeM(SourcetypeResponsetypeM sourcetypeResponsetypeM) {
		getSourcetypeResponsetypeMs().add(sourcetypeResponsetypeM);
		sourcetypeResponsetypeM.setResponsetypeM(this);

		return sourcetypeResponsetypeM;
	}

	public SourcetypeResponsetypeM removeSourcetypeResponsetypeM(SourcetypeResponsetypeM sourcetypeResponsetypeM) {
		getSourcetypeResponsetypeMs().remove(sourcetypeResponsetypeM);
		sourcetypeResponsetypeM.setResponsetypeM(null);

		return sourcetypeResponsetypeM;
	}

}