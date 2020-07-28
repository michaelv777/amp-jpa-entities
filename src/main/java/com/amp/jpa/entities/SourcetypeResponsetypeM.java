package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sourcetype_responsetype_m database table.
 * 
 */
@Entity
@Table(name="sourcetype_responsetype_m")
@NamedQuery(name="SourcetypeResponsetypeM.findAll", query="SELECT s FROM SourcetypeResponsetypeM s")
public class SourcetypeResponsetypeM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long sourcetyperesponsetypeid;

	//bi-directional many-to-one association to ResponsetypeM
	@ManyToOne
	@JoinColumn(name="SRCTYPERESPTYPE2RESPONSETYPE", nullable=false)
	private ResponsetypeM responsetypeM;

	//bi-directional many-to-one association to SourcetypeM
	@ManyToOne
	@JoinColumn(name="SRCTYPERESPTYPE2SOURCETYPE", nullable=false)
	private SourcetypeM sourcetypeM;

	public SourcetypeResponsetypeM() {
	}

	public long getSourcetyperesponsetypeid() {
		return this.sourcetyperesponsetypeid;
	}

	public void setSourcetyperesponsetypeid(long sourcetyperesponsetypeid) {
		this.sourcetyperesponsetypeid = sourcetyperesponsetypeid;
	}

	public ResponsetypeM getResponsetypeM() {
		return this.responsetypeM;
	}

	public void setResponsetypeM(ResponsetypeM responsetypeM) {
		this.responsetypeM = responsetypeM;
	}

	public SourcetypeM getSourcetypeM() {
		return this.sourcetypeM;
	}

	public void setSourcetypeM(SourcetypeM sourcetypeM) {
		this.sourcetypeM = sourcetypeM;
	}

}