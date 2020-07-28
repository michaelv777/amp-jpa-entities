package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sourcetype_m database table.
 * 
 */
@Entity
@Table(name="sourcetype_m")
@NamedQuery(name="SourcetypeM.findAll", query="SELECT s FROM SourcetypeM s")
public class SourcetypeM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long sourcetypeid;

	@Column(length=256)
	private String desciption;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to Source
	@OneToMany(mappedBy="sourcetypeM")
	private Set<Source> sources;

	//bi-directional many-to-one association to SourcetypeRequesttypeM
	@OneToMany(mappedBy="sourcetypeM")
	private Set<SourcetypeRequesttypeM> sourcetypeRequesttypeMs;

	//bi-directional many-to-one association to SourcetypeResponsetypeM
	@OneToMany(mappedBy="sourcetypeM")
	private Set<SourcetypeResponsetypeM> sourcetypeResponsetypeMs;

	public SourcetypeM() {
	}

	public long getSourcetypeid() {
		return this.sourcetypeid;
	}

	public void setSourcetypeid(long sourcetypeid) {
		this.sourcetypeid = sourcetypeid;
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

	public Set<Source> getSources() {
		return this.sources;
	}

	public void setSources(Set<Source> sources) {
		this.sources = sources;
	}

	public Source addSource(Source source) {
		getSources().add(source);
		source.setSourcetypeM(this);

		return source;
	}

	public Source removeSource(Source source) {
		getSources().remove(source);
		source.setSourcetypeM(null);

		return source;
	}

	public Set<SourcetypeRequesttypeM> getSourcetypeRequesttypeMs() {
		return this.sourcetypeRequesttypeMs;
	}

	public void setSourcetypeRequesttypeMs(Set<SourcetypeRequesttypeM> sourcetypeRequesttypeMs) {
		this.sourcetypeRequesttypeMs = sourcetypeRequesttypeMs;
	}

	public SourcetypeRequesttypeM addSourcetypeRequesttypeM(SourcetypeRequesttypeM sourcetypeRequesttypeM) {
		getSourcetypeRequesttypeMs().add(sourcetypeRequesttypeM);
		sourcetypeRequesttypeM.setSourcetypeM(this);

		return sourcetypeRequesttypeM;
	}

	public SourcetypeRequesttypeM removeSourcetypeRequesttypeM(SourcetypeRequesttypeM sourcetypeRequesttypeM) {
		getSourcetypeRequesttypeMs().remove(sourcetypeRequesttypeM);
		sourcetypeRequesttypeM.setSourcetypeM(null);

		return sourcetypeRequesttypeM;
	}

	public Set<SourcetypeResponsetypeM> getSourcetypeResponsetypeMs() {
		return this.sourcetypeResponsetypeMs;
	}

	public void setSourcetypeResponsetypeMs(Set<SourcetypeResponsetypeM> sourcetypeResponsetypeMs) {
		this.sourcetypeResponsetypeMs = sourcetypeResponsetypeMs;
	}

	public SourcetypeResponsetypeM addSourcetypeResponsetypeM(SourcetypeResponsetypeM sourcetypeResponsetypeM) {
		getSourcetypeResponsetypeMs().add(sourcetypeResponsetypeM);
		sourcetypeResponsetypeM.setSourcetypeM(this);

		return sourcetypeResponsetypeM;
	}

	public SourcetypeResponsetypeM removeSourcetypeResponsetypeM(SourcetypeResponsetypeM sourcetypeResponsetypeM) {
		getSourcetypeResponsetypeMs().remove(sourcetypeResponsetypeM);
		sourcetypeResponsetypeM.setSourcetypeM(null);

		return sourcetypeResponsetypeM;
	}

}