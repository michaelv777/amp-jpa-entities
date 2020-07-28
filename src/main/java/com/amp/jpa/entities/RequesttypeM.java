package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the requesttype_m database table.
 * 
 */
@Entity
@Table(name="requesttype_m")
@NamedQuery(name="RequesttypeM.findAll", query="SELECT r FROM RequesttypeM r")
public class RequesttypeM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long requesttypeid;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to OperationtypeM
	@ManyToOne
	@JoinColumn(name="REQUESTTYPE2OPERATIONTYPE", nullable=false)
	private OperationtypeM operationtypeM;

	//bi-directional many-to-one association to RequesttypeParameter
	@OneToMany(mappedBy="requesttypeM")
	private Set<RequesttypeParameter> requesttypeParameters;

	//bi-directional many-to-one association to SourcetypeRequesttypeM
	@OneToMany(mappedBy="requesttypeM")
	private Set<SourcetypeRequesttypeM> sourcetypeRequesttypeMs;

	public RequesttypeM() {
	}

	public long getRequesttypeid() {
		return this.requesttypeid;
	}

	public void setRequesttypeid(long requesttypeid) {
		this.requesttypeid = requesttypeid;
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

	public Set<RequesttypeParameter> getRequesttypeParameters() {
		return this.requesttypeParameters;
	}

	public void setRequesttypeParameters(Set<RequesttypeParameter> requesttypeParameters) {
		this.requesttypeParameters = requesttypeParameters;
	}

	public RequesttypeParameter addRequesttypeParameter(RequesttypeParameter requesttypeParameter) {
		getRequesttypeParameters().add(requesttypeParameter);
		requesttypeParameter.setRequesttypeM(this);

		return requesttypeParameter;
	}

	public RequesttypeParameter removeRequesttypeParameter(RequesttypeParameter requesttypeParameter) {
		getRequesttypeParameters().remove(requesttypeParameter);
		requesttypeParameter.setRequesttypeM(null);

		return requesttypeParameter;
	}

	public Set<SourcetypeRequesttypeM> getSourcetypeRequesttypeMs() {
		return this.sourcetypeRequesttypeMs;
	}

	public void setSourcetypeRequesttypeMs(Set<SourcetypeRequesttypeM> sourcetypeRequesttypeMs) {
		this.sourcetypeRequesttypeMs = sourcetypeRequesttypeMs;
	}

	public SourcetypeRequesttypeM addSourcetypeRequesttypeM(SourcetypeRequesttypeM sourcetypeRequesttypeM) {
		getSourcetypeRequesttypeMs().add(sourcetypeRequesttypeM);
		sourcetypeRequesttypeM.setRequesttypeM(this);

		return sourcetypeRequesttypeM;
	}

	public SourcetypeRequesttypeM removeSourcetypeRequesttypeM(SourcetypeRequesttypeM sourcetypeRequesttypeM) {
		getSourcetypeRequesttypeMs().remove(sourcetypeRequesttypeM);
		sourcetypeRequesttypeM.setRequesttypeM(null);

		return sourcetypeRequesttypeM;
	}

}