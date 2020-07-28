package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Table(name="client")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long clientid;

	@Column(nullable=false, length=100)
	private String name;

	public Client() {
	}

	public long getClientid() {
		return this.clientid;
	}

	public void setClientid(long clientid) {
		this.clientid = clientid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}