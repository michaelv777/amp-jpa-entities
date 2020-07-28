package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the operationtype_m database table.
 * 
 */
@Entity
@Table(name="operationtype_m")
@NamedQuery(name="OperationtypeM.findAll", query="SELECT o FROM OperationtypeM o")
public class OperationtypeM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long operationtypeid;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to RequesttypeM
	@OneToMany(mappedBy="operationtypeM")
	private Set<RequesttypeM> requesttypeMs;

	//bi-directional many-to-one association to ResponsetypeM
	@OneToMany(mappedBy="operationtypeM")
	private Set<ResponsetypeM> responsetypeMs;

	public OperationtypeM() {
	}

	public long getOperationtypeid() {
		return this.operationtypeid;
	}

	public void setOperationtypeid(long operationtypeid) {
		this.operationtypeid = operationtypeid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<RequesttypeM> getRequesttypeMs() {
		return this.requesttypeMs;
	}

	public void setRequesttypeMs(Set<RequesttypeM> requesttypeMs) {
		this.requesttypeMs = requesttypeMs;
	}

	public RequesttypeM addRequesttypeM(RequesttypeM requesttypeM) {
		getRequesttypeMs().add(requesttypeM);
		requesttypeM.setOperationtypeM(this);

		return requesttypeM;
	}

	public RequesttypeM removeRequesttypeM(RequesttypeM requesttypeM) {
		getRequesttypeMs().remove(requesttypeM);
		requesttypeM.setOperationtypeM(null);

		return requesttypeM;
	}

	public Set<ResponsetypeM> getResponsetypeMs() {
		return this.responsetypeMs;
	}

	public void setResponsetypeMs(Set<ResponsetypeM> responsetypeMs) {
		this.responsetypeMs = responsetypeMs;
	}

	public ResponsetypeM addResponsetypeM(ResponsetypeM responsetypeM) {
		getResponsetypeMs().add(responsetypeM);
		responsetypeM.setOperationtypeM(this);

		return responsetypeM;
	}

	public ResponsetypeM removeResponsetypeM(ResponsetypeM responsetypeM) {
		getResponsetypeMs().remove(responsetypeM);
		responsetypeM.setOperationtypeM(null);

		return responsetypeM;
	}

}