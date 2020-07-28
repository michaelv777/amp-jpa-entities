package com.amp.jpa.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the nodetype_m database table.
 * 
 */
@Entity
@Table(name="nodetype_m")
@NamedQuery(name="NodetypeM.findAll", query="SELECT n FROM NodetypeM n")
public class NodetypeM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long nodetypeid;

	private long iscategoryroot;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to Node
	@OneToMany(mappedBy="nodetypeM")
	private Set<Node> nodes;

	public NodetypeM() {
	}

	public long getNodetypeid() {
		return this.nodetypeid;
	}

	public void setNodetypeid(long nodetypeid) {
		this.nodetypeid = nodetypeid;
	}

	public long getIscategoryroot() {
		return this.iscategoryroot;
	}

	public void setIscategoryroot(long iscategoryroot) {
		this.iscategoryroot = iscategoryroot;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Node> getNodes() {
		return this.nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

	public Node addNode(Node node) {
		getNodes().add(node);
		node.setNodetypeM(this);

		return node;
	}

	public Node removeNode(Node node) {
		getNodes().remove(node);
		node.setNodetypeM(null);

		return node;
	}

}