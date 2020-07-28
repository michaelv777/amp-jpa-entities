package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long categoryid;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false, length=100)
	private String rootbrowsenode;

	@Column(nullable=false, length=100)
	private String searchindex;

	//bi-directional many-to-one association to Source
	@ManyToOne
	@JoinColumn(name="CATEGORY2SOURCE", nullable=false)
	private Source source;

	public Category() {
	}

	public long getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRootbrowsenode() {
		return this.rootbrowsenode;
	}

	public void setRootbrowsenode(String rootbrowsenode) {
		this.rootbrowsenode = rootbrowsenode;
	}

	public String getSearchindex() {
		return this.searchindex;
	}

	public void setSearchindex(String searchindex) {
		this.searchindex = searchindex;
	}

	public Source getSource() {
		return this.source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

}