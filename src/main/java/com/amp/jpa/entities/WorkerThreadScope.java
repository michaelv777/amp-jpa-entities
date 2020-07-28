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
import javax.persistence.Table;


/**
 * The persistent class for the worker_thread_scope database table.
 * 
 */
@Entity
@Table(name="worker_thread_scope")
@NamedQuery(name="WorkerThreadScope.findAll", query="SELECT w FROM WorkerThreadScope w")
public class WorkerThreadScope implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long workerthreadscopeid;

	@Column(nullable=false)
	private long isprimaryscope;

	@Column(length=100)
	private String nodesortvalue;

	//bi-directional many-to-one association to Node
	@ManyToOne
	@JoinColumn(name="WORKERTHREADSCOPE2NODE", nullable=false)
	private Node node;

	//bi-directional many-to-one association to WorkerThread
	@ManyToOne
	@JoinColumn(name="WORKERTHREADSCOPE2WORKERTHREAD", nullable=false)
	private WorkerThread workerThread;

	//bi-directional many-to-one association to ThreadScopeCredential
	@OneToMany(mappedBy="workerThreadScope", fetch=FetchType.EAGER)
	private Set<ThreadScopeCredential> threadScopeCredentials;

	public WorkerThreadScope() {
	}

	public long getWorkerthreadscopeid() {
		return this.workerthreadscopeid;
	}

	public void setWorkerthreadscopeid(long workerthreadscopeid) {
		this.workerthreadscopeid = workerthreadscopeid;
	}

	public long getIsprimaryscope() {
		return this.isprimaryscope;
	}

	public void setIsprimaryscope(long isprimaryscope) {
		this.isprimaryscope = isprimaryscope;
	}

	public String getNodesortvalue() {
		return this.nodesortvalue;
	}

	public void setNodesortvalue(String nodesortvalue) {
		this.nodesortvalue = nodesortvalue;
	}

	public Node getNode() {
		return this.node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public WorkerThread getWorkerThread() {
		return this.workerThread;
	}

	public void setWorkerThread(WorkerThread workerThread) {
		this.workerThread = workerThread;
	}

	public Set<ThreadScopeCredential> getThreadScopeCredentials() {
		return this.threadScopeCredentials;
	}

	public void setThreadScopeCredentials(Set<ThreadScopeCredential> threadScopeCredentials) {
		this.threadScopeCredentials = threadScopeCredentials;
	}

	public ThreadScopeCredential addThreadScopeCredential(ThreadScopeCredential threadScopeCredential) {
		getThreadScopeCredentials().add(threadScopeCredential);
		threadScopeCredential.setWorkerThreadScope(this);

		return threadScopeCredential;
	}

	public ThreadScopeCredential removeThreadScopeCredential(ThreadScopeCredential threadScopeCredential) {
		getThreadScopeCredentials().remove(threadScopeCredential);
		threadScopeCredential.setWorkerThreadScope(null);

		return threadScopeCredential;
	}

}