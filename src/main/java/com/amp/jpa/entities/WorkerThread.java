package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the worker_thread database table.
 * 
 */
@Entity
@Table(name="worker_thread")
@NamedQuery(name="WorkerThread.findAll", query="SELECT w FROM WorkerThread w")
public class WorkerThread implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long workerthreadid;

	//bi-directional many-to-one association to Thread
	@ManyToOne
	@JoinColumn(name="WORKERTHREAD2THREAD", nullable=false)
	private Thread thread;

	//bi-directional many-to-one association to Worker
	@ManyToOne
	@JoinColumn(name="WORKERTHREAD2WORKER", nullable=false)
	private Worker worker;

	//bi-directional many-to-one association to WorkerThreadScope
	@OneToMany(mappedBy="workerThread", fetch=FetchType.EAGER)
	private Set<WorkerThreadScope> workerThreadScopes;

	public WorkerThread() {
	}

	public long getWorkerthreadid() {
		return this.workerthreadid;
	}

	public void setWorkerthreadid(long workerthreadid) {
		this.workerthreadid = workerthreadid;
	}

	public Thread getThread() {
		return this.thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public Worker getWorker() {
		return this.worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Set<WorkerThreadScope> getWorkerThreadScopes() {
		return this.workerThreadScopes;
	}

	public void setWorkerThreadScopes(Set<WorkerThreadScope> workerThreadScopes) {
		this.workerThreadScopes = workerThreadScopes;
	}

	public WorkerThreadScope addWorkerThreadScope(WorkerThreadScope workerThreadScope) {
		getWorkerThreadScopes().add(workerThreadScope);
		workerThreadScope.setWorkerThread(this);

		return workerThreadScope;
	}

	public WorkerThreadScope removeWorkerThreadScope(WorkerThreadScope workerThreadScope) {
		getWorkerThreadScopes().remove(workerThreadScope);
		workerThreadScope.setWorkerThread(null);

		return workerThreadScope;
	}

}