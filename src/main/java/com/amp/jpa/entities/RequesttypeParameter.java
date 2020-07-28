package com.amp.jpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the requesttype_parameters database table.
 * 
 */
@Entity
@Table(name="requesttype_parameters")
@NamedQuery(name="RequesttypeParameter.findAll", query="SELECT r FROM RequesttypeParameter r")
public class RequesttypeParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long requesttypeparameterid;

	@Column(nullable=false)
	private long required;

	@Column(nullable=false)
	private long sequence;

	//bi-directional many-to-one association to Parameter
	@ManyToOne
	@JoinColumn(name="REQUESTTYPEPARAM2PARAMETER", nullable=false)
	private Parameter parameter;

	//bi-directional many-to-one association to RequesttypeM
	@ManyToOne
	@JoinColumn(name="REQUESTTYPEPARAM2REQUESTTYPE", nullable=false)
	private RequesttypeM requesttypeM;

	public RequesttypeParameter() {
	}

	public long getRequesttypeparameterid() {
		return this.requesttypeparameterid;
	}

	public void setRequesttypeparameterid(long requesttypeparameterid) {
		this.requesttypeparameterid = requesttypeparameterid;
	}

	public long getRequired() {
		return this.required;
	}

	public void setRequired(long required) {
		this.required = required;
	}

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public Parameter getParameter() {
		return this.parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public RequesttypeM getRequesttypeM() {
		return this.requesttypeM;
	}

	public void setRequesttypeM(RequesttypeM requesttypeM) {
		this.requesttypeM = requesttypeM;
	}

}