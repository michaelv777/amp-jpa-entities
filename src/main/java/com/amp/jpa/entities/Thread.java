package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the thread database table.
 * 
 */
@Entity
@Table(name="thread")
@NamedQuery(name="Thread.findAll", query="SELECT t FROM Thread t")
public class Thread implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long threadid;

	@Column(length=100)
	private String description;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to ThreadConfiguration
	@OneToMany(mappedBy="thread", fetch=FetchType.EAGER)
	private Set<ThreadConfiguration> threadConfigurations;

	//bi-directional many-to-one association to WorkerThread
	@OneToMany(mappedBy="thread", fetch=FetchType.EAGER)
	private Set<WorkerThread> workerThreads;

	public Thread() {
	}

	public long getThreadid() {
		return this.threadid;
	}

	public void setThreadid(long threadid) {
		this.threadid = threadid;
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

	public Set<ThreadConfiguration> getThreadConfigurations() {
		return this.threadConfigurations;
	}

	public void setThreadConfigurations(Set<ThreadConfiguration> threadConfigurations) {
		this.threadConfigurations = threadConfigurations;
	}

	public ThreadConfiguration addThreadConfiguration(ThreadConfiguration threadConfiguration) {
		getThreadConfigurations().add(threadConfiguration);
		threadConfiguration.setThread(this);

		return threadConfiguration;
	}

	public ThreadConfiguration removeThreadConfiguration(ThreadConfiguration threadConfiguration) {
		getThreadConfigurations().remove(threadConfiguration);
		threadConfiguration.setThread(null);

		return threadConfiguration;
	}

	public Set<WorkerThread> getWorkerThreads() {
		return this.workerThreads;
	}

	public void setWorkerThreads(Set<WorkerThread> workerThreads) {
		this.workerThreads = workerThreads;
	}

	public WorkerThread addWorkerThread(WorkerThread workerThread) {
		getWorkerThreads().add(workerThread);
		workerThread.setThread(this);

		return workerThread;
	}

	public WorkerThread removeWorkerThread(WorkerThread workerThread) {
		getWorkerThreads().remove(workerThread);
		workerThread.setThread(null);

		return workerThread;
	}

}