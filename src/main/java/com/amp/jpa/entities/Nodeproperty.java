package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nodeproperties database table.
 * 
 */
@Entity
@Table(name="nodeproperties")
@NamedQuery(name="Nodeproperty.findAll", query="SELECT n FROM Nodeproperty n")
public class Nodeproperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=100)
	private String node2browsenode;

	@Column(length=100)
	private String name;

	@Column(length=256)
	private String value;

	//bi-directional one-to-one association to Node
	@OneToOne
	@JoinColumn(name="NODE2BROWSENODE", nullable=false, insertable=false, updatable=false)
	private Node node;

	public Nodeproperty() {
	}

	public String getNode2browsenode() {
		return this.node2browsenode;
	}

	public void setNode2browsenode(String node2browsenode) {
		this.node2browsenode = node2browsenode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getNode() {
		return this.node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

}