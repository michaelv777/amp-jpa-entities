package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the worker database table.
 * 
 */
@Entity
@Table(name="worker")
@NamedQuery(name="Worker.findAll", query="SELECT w FROM Worker w")
public class Worker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long workerid;

	@Column(length=100)
	private String description;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to WorkerConfiguration
	@OneToMany(mappedBy="worker", fetch=FetchType.EAGER)
	private Set<WorkerConfiguration> workerConfigurations;

	//bi-directional many-to-one association to WorkerThread
	@OneToMany(mappedBy="worker", fetch=FetchType.EAGER)
	private Set<WorkerThread> workerThreads;

	public Worker() {
	}

	public long getWorkerid() {
		return this.workerid;
	}

	public void setWorkerid(long workerid) {
		this.workerid = workerid;
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

	public Set<WorkerConfiguration> getWorkerConfigurations() {
		return this.workerConfigurations;
	}

	public void setWorkerConfigurations(Set<WorkerConfiguration> workerConfigurations) {
		this.workerConfigurations = workerConfigurations;
	}

	public WorkerConfiguration addWorkerConfiguration(WorkerConfiguration workerConfiguration) {
		getWorkerConfigurations().add(workerConfiguration);
		workerConfiguration.setWorker(this);

		return workerConfiguration;
	}

	public WorkerConfiguration removeWorkerConfiguration(WorkerConfiguration workerConfiguration) {
		getWorkerConfigurations().remove(workerConfiguration);
		workerConfiguration.setWorker(null);

		return workerConfiguration;
	}

	public Set<WorkerThread> getWorkerThreads() {
		return this.workerThreads;
	}

	public void setWorkerThreads(Set<WorkerThread> workerThreads) {
		this.workerThreads = workerThreads;
	}

	public WorkerThread addWorkerThread(WorkerThread workerThread) {
		getWorkerThreads().add(workerThread);
		workerThread.setWorker(this);

		return workerThread;
	}

	public WorkerThread removeWorkerThread(WorkerThread workerThread) {
		getWorkerThreads().remove(workerThread);
		workerThread.setWorker(null);

		return workerThread;
	}

}