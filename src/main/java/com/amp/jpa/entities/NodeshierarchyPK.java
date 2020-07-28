package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the nodeshierarchy database table.
 * 
 */
@Embeddable
public class NodeshierarchyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, length=100)
	private String node2childbrowsenode;

	@Column(unique=true, nullable=false, length=100)
	private String node2parentbrowsenode;

	public NodeshierarchyPK() {
	}
	public String getNode2childbrowsenode() {
		return this.node2childbrowsenode;
	}
	public void setNode2childbrowsenode(String node2childbrowsenode) {
		this.node2childbrowsenode = node2childbrowsenode;
	}
	public String getNode2parentbrowsenode() {
		return this.node2parentbrowsenode;
	}
	public void setNode2parentbrowsenode(String node2parentbrowsenode) {
		this.node2parentbrowsenode = node2parentbrowsenode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NodeshierarchyPK)) {
			return false;
		}
		NodeshierarchyPK castOther = (NodeshierarchyPK)other;
		return 
			this.node2childbrowsenode.equals(castOther.node2childbrowsenode)
			&& this.node2parentbrowsenode.equals(castOther.node2parentbrowsenode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.node2childbrowsenode.hashCode();
		hash = hash * prime + this.node2parentbrowsenode.hashCode();
		
		return hash;
	}
}