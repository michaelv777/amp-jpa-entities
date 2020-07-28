package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the parameter database table.
 * 
 */
@Entity
@Table(name="parameter")
@NamedQuery(name="Parameter.findAll", query="SELECT p FROM Parameter p")
public class Parameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long parameterid;

	@Column(length=100)
	private String defaultvalue;

	@Column(length=100)
	private String definition;

	@Column(length=512)
	private String description;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to ParametertypeM
	@ManyToOne
	@JoinColumn(name="PARAMETER2PARAMETERTYPE", nullable=false)
	private ParametertypeM parametertypeM;

	//bi-directional many-to-one association to RequesttypeParameter
	@OneToMany(mappedBy="parameter")
	private Set<RequesttypeParameter> requesttypeParameters;

	//bi-directional many-to-one association to ResponsetypeParameter
	@OneToMany(mappedBy="parameter")
	private Set<ResponsetypeParameter> responsetypeParameters;

	public Parameter() {
	}

	public long getParameterid() {
		return this.parameterid;
	}

	public void setParameterid(long parameterid) {
		this.parameterid = parameterid;
	}

	public String getDefaultvalue() {
		return this.defaultvalue;
	}

	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	public String getDefinition() {
		return this.definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
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

	public ParametertypeM getParametertypeM() {
		return this.parametertypeM;
	}

	public void setParametertypeM(ParametertypeM parametertypeM) {
		this.parametertypeM = parametertypeM;
	}

	public Set<RequesttypeParameter> getRequesttypeParameters() {
		return this.requesttypeParameters;
	}

	public void setRequesttypeParameters(Set<RequesttypeParameter> requesttypeParameters) {
		this.requesttypeParameters = requesttypeParameters;
	}

	public RequesttypeParameter addRequesttypeParameter(RequesttypeParameter requesttypeParameter) {
		getRequesttypeParameters().add(requesttypeParameter);
		requesttypeParameter.setParameter(this);

		return requesttypeParameter;
	}

	public RequesttypeParameter removeRequesttypeParameter(RequesttypeParameter requesttypeParameter) {
		getRequesttypeParameters().remove(requesttypeParameter);
		requesttypeParameter.setParameter(null);

		return requesttypeParameter;
	}

	public Set<ResponsetypeParameter> getResponsetypeParameters() {
		return this.responsetypeParameters;
	}

	public void setResponsetypeParameters(Set<ResponsetypeParameter> responsetypeParameters) {
		this.responsetypeParameters = responsetypeParameters;
	}

	public ResponsetypeParameter addResponsetypeParameter(ResponsetypeParameter responsetypeParameter) {
		getResponsetypeParameters().add(responsetypeParameter);
		responsetypeParameter.setParameter(this);

		return responsetypeParameter;
	}

	public ResponsetypeParameter removeResponsetypeParameter(ResponsetypeParameter responsetypeParameter) {
		getResponsetypeParameters().remove(responsetypeParameter);
		responsetypeParameter.setParameter(null);

		return responsetypeParameter;
	}

}