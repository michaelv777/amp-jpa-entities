package com.amp.jpa.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the node database table.
 * 
 */
@Entity
@Table(name="node")
@NamedQuery(name="Node.findAll", query="SELECT n FROM Node n")
public class Node implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=100)
	private String browsenodeid;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false)
	private long nodelevel;

	//bi-directional many-to-one association to Node
	@ManyToOne
	@JoinColumn(name="NODE2PARENTBROWSENODE")
	private Node node;

	//bi-directional many-to-one association to Node
	@OneToMany(mappedBy="node", fetch=FetchType.EAGER)
	private Set<Node> nodes;

	//bi-directional many-to-one association to NodetypeM
	@ManyToOne
	@JoinColumn(name="BROWSENODE2NODETYPE", nullable=false)
	private NodetypeM nodetypeM;

	//bi-directional many-to-one association to Source
	@ManyToOne
	@JoinColumn(name="NODE2SOURCE", nullable=false)
	private Source source;

	//bi-directional one-to-one association to Nodeproperty
	@OneToOne(mappedBy="node")
	private Nodeproperty nodeproperty;

	//bi-directional many-to-one association to WorkerThreadScope
	@OneToMany(mappedBy="node")
	private Set<WorkerThreadScope> workerThreadScopes;

	public Node() {
	}

	public String getBrowsenodeid() {
		return this.browsenodeid;
	}

	public void setBrowsenodeid(String browsenodeid) {
		this.browsenodeid = browsenodeid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNodelevel() {
		return this.nodelevel;
	}

	public void setNodelevel(long nodelevel) {
		this.nodelevel = nodelevel;
	}

	public Node getNode() {
		return this.node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public Set<Node> getNodes() {
		return this.nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

	public Node addNode(Node node) {
		getNodes().add(node);
		node.setNode(this);

		return node;
	}

	public Node removeNode(Node node) {
		getNodes().remove(node);
		node.setNode(null);

		return node;
	}

	public NodetypeM getNodetypeM() {
		return this.nodetypeM;
	}

	public void setNodetypeM(NodetypeM nodetypeM) {
		this.nodetypeM = nodetypeM;
	}

	public Source getSource() {
		return this.source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Nodeproperty getNodeproperty() {
		return this.nodeproperty;
	}

	public void setNodeproperty(Nodeproperty nodeproperty) {
		this.nodeproperty = nodeproperty;
	}

	public Set<WorkerThreadScope> getWorkerThreadScopes() {
		return this.workerThreadScopes;
	}

	public void setWorkerThreadScopes(Set<WorkerThreadScope> workerThreadScopes) {
		this.workerThreadScopes = workerThreadScopes;
	}

	public WorkerThreadScope addWorkerThreadScope(WorkerThreadScope workerThreadScope) {
		getWorkerThreadScopes().add(workerThreadScope);
		workerThreadScope.setNode(this);

		return workerThreadScope;
	}

	public WorkerThreadScope removeWorkerThreadScope(WorkerThreadScope workerThreadScope) {
		getWorkerThreadScopes().remove(workerThreadScope);
		workerThreadScope.setNode(null);

		return workerThreadScope;
	}

}