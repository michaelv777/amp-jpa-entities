package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the source database table.
 * 
 */
@Entity
@Table(name="source")
@NamedQuery(name="Source.findAll", query="SELECT s FROM Source s")
public class Source implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long sourceid;

	@Column(nullable=false, length=100)
	private String company;

	@Column(length=256)
	private String description;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy="source")
	private Set<Category> categories;

	//bi-directional many-to-one association to Node
	@OneToMany(mappedBy="source")
	private Set<Node> nodes;

	//bi-directional many-to-one association to SourcetypeM
	@ManyToOne
	@JoinColumn(name="SOURCE2SOURCETYPE", nullable=false)
	private SourcetypeM sourcetypeM;

	//bi-directional many-to-one association to ThreadConfiguration
	@OneToMany(mappedBy="source")
	private Set<ThreadConfiguration> threadConfigurations;

	//bi-directional many-to-one association to WorkerConfiguration
	@OneToMany(mappedBy="source")
	private Set<WorkerConfiguration> workerConfigurations;

	public Source() {
	}

	public long getSourceid() {
		return this.sourceid;
	}

	public void setSourceid(long sourceid) {
		this.sourceid = sourceid;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		category.setSource(this);

		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.setSource(null);

		return category;
	}

	public Set<Node> getNodes() {
		return this.nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

	public Node addNode(Node node) {
		getNodes().add(node);
		node.setSource(this);

		return node;
	}

	public Node removeNode(Node node) {
		getNodes().remove(node);
		node.setSource(null);

		return node;
	}

	public SourcetypeM getSourcetypeM() {
		return this.sourcetypeM;
	}

	public void setSourcetypeM(SourcetypeM sourcetypeM) {
		this.sourcetypeM = sourcetypeM;
	}

	public Set<ThreadConfiguration> getThreadConfigurations() {
		return this.threadConfigurations;
	}

	public void setThreadConfigurations(Set<ThreadConfiguration> threadConfigurations) {
		this.threadConfigurations = threadConfigurations;
	}

	public ThreadConfiguration addThreadConfiguration(ThreadConfiguration threadConfiguration) {
		getThreadConfigurations().add(threadConfiguration);
		threadConfiguration.setSource(this);

		return threadConfiguration;
	}

	public ThreadConfiguration removeThreadConfiguration(ThreadConfiguration threadConfiguration) {
		getThreadConfigurations().remove(threadConfiguration);
		threadConfiguration.setSource(null);

		return threadConfiguration;
	}

	public Set<WorkerConfiguration> getWorkerConfigurations() {
		return this.workerConfigurations;
	}

	public void setWorkerConfigurations(Set<WorkerConfiguration> workerConfigurations) {
		this.workerConfigurations = workerConfigurations;
	}

	public WorkerConfiguration addWorkerConfiguration(WorkerConfiguration workerConfiguration) {
		getWorkerConfigurations().add(workerConfiguration);
		workerConfiguration.setSource(this);

		return workerConfiguration;
	}

	public WorkerConfiguration removeWorkerConfiguration(WorkerConfiguration workerConfiguration) {
		getWorkerConfigurations().remove(workerConfiguration);
		workerConfiguration.setSource(null);

		return workerConfiguration;
	}

}