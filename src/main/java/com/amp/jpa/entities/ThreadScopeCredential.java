package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the thread_scope_credential database table.
 * 
 */
@Entity
@Table(name="thread_scope_credential")
@NamedQuery(name="ThreadScopeCredential.findAll", query="SELECT t FROM ThreadScopeCredential t")
public class ThreadScopeCredential implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long threadcredentialid;

	//bi-directional many-to-one association to Credential
	@ManyToOne
	@JoinColumn(name="THREADCREDENTIAL2CREDENTIAL", nullable=false)
	private Credential credential;

	//bi-directional many-to-one association to WorkerThreadScope
	@ManyToOne
	@JoinColumn(name="THREADCREDENTIAL2THREADSCOPE", nullable=false)
	private WorkerThreadScope workerThreadScope;

	public ThreadScopeCredential() {
	}

	public long getThreadcredentialid() {
		return this.threadcredentialid;
	}

	public void setThreadcredentialid(long threadcredentialid) {
		this.threadcredentialid = threadcredentialid;
	}

	public Credential getCredential() {
		return this.credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	public WorkerThreadScope getWorkerThreadScope() {
		return this.workerThreadScope;
	}

	public void setWorkerThreadScope(WorkerThreadScope workerThreadScope) {
		this.workerThreadScope = workerThreadScope;
	}

}