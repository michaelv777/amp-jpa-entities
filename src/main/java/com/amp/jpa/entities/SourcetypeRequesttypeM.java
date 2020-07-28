package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sourcetype_requesttype_m database table.
 * 
 */
@Entity
@Table(name="sourcetype_requesttype_m")
@NamedQuery(name="SourcetypeRequesttypeM.findAll", query="SELECT s FROM SourcetypeRequesttypeM s")
public class SourcetypeRequesttypeM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long sourcetyperequesttypeid;

	//bi-directional many-to-one association to RequesttypeM
	@ManyToOne
	@JoinColumn(name="SRCTYPEREQTYPE2REQUESTTYPE", nullable=false)
	private RequesttypeM requesttypeM;

	//bi-directional many-to-one association to SourcetypeM
	@ManyToOne
	@JoinColumn(name="SRCTYPEREQTYPE2SOURCETYPE", nullable=false)
	private SourcetypeM sourcetypeM;

	public SourcetypeRequesttypeM() {
	}

	public long getSourcetyperequesttypeid() {
		return this.sourcetyperequesttypeid;
	}

	public void setSourcetyperequesttypeid(long sourcetyperequesttypeid) {
		this.sourcetyperequesttypeid = sourcetyperequesttypeid;
	}

	public RequesttypeM getRequesttypeM() {
		return this.requesttypeM;
	}

	public void setRequesttypeM(RequesttypeM requesttypeM) {
		this.requesttypeM = requesttypeM;
	}

	public SourcetypeM getSourcetypeM() {
		return this.sourcetypeM;
	}

	public void setSourcetypeM(SourcetypeM sourcetypeM) {
		this.sourcetypeM = sourcetypeM;
	}

}