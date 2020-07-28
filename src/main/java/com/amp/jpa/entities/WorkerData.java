package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the worker_data database table.
 * 
 */
@Entity
@Table(name="worker_data")
@NamedQuery(name="WorkerData.findAll", query="SELECT w FROM WorkerData w")
public class WorkerData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=256)
	private String workerdatahash;

	@Column(length=256)
	private String description;

	@Column(nullable=false, length=100)
	private String itemid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date updatedate;

	//uni-directional many-to-one association to OperationtypeM
	@ManyToOne
	@JoinColumn(name="WORKERDATA2OPTYPE", nullable=false)
	private OperationtypeM operationtypeM;

	//uni-directional many-to-one association to Source
	@ManyToOne
	@JoinColumn(name="WORKERDATA2SOURCE", nullable=false)
	private Source source;

	//uni-directional many-to-one association to StatusM
	@ManyToOne
	@JoinColumn(name="WORKERDATA2STATUS", nullable=false)
	private StatusM statusM;

	//uni-directional many-to-one association to Target
	@ManyToOne
	@JoinColumn(name="WORKERDATA2TARGET", nullable=false)
	private Target target;

	//uni-directional many-to-one association to Thread
	@ManyToOne
	@JoinColumn(name="WORKERDATA2THREAD", nullable=false)
	private Thread thread;

	//uni-directional many-to-one association to Worker
	@ManyToOne
	@JoinColumn(name="WORKERDATA2WORKER", nullable=false)
	private Worker worker;

	public WorkerData() {
	}

	public String getWorkerdatahash() {
		return this.workerdatahash;
	}

	public void setWorkerdatahash(String workerdatahash) {
		this.workerdatahash = workerdatahash;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public Date getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public OperationtypeM getOperationtypeM() {
		return this.operationtypeM;
	}

	public void setOperationtypeM(OperationtypeM operationtypeM) {
		this.operationtypeM = operationtypeM;
	}

	public Source getSource() {
		return this.source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public StatusM getStatusM() {
		return this.statusM;
	}

	public void setStatusM(StatusM statusM) {
		this.statusM = statusM;
	}

	public Target getTarget() {
		return this.target;
	}

	public void setTarget(Target target) {
		this.target = target;
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

}