package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the worker_configuration database table.
 * 
 */
@Entity
@Table(name="worker_configuration")
@NamedQuery(name="WorkerConfiguration.findAll", query="SELECT w FROM WorkerConfiguration w")
public class WorkerConfiguration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long workerconfigid;

	@Column(nullable=false, length=100)
	private String configkey;

	@Column(length=512)
	private String configvalue;

	@Column(length=100)
	private String unit;

	//bi-directional many-to-one association to ConfigurationtypeM
	@ManyToOne
	@JoinColumn(name="WORKERCONFIG2CONFIGTYPE", nullable=false)
	private ConfigurationtypeM configurationtypeM;

	//bi-directional many-to-one association to Source
	@ManyToOne
	@JoinColumn(name="WORKERCONFIG2SOURCE", nullable=false)
	private Source source;

	//bi-directional many-to-one association to Worker
	@ManyToOne
	@JoinColumn(name="WORKERCONFIG2WORKER", nullable=false)
	private Worker worker;

	public WorkerConfiguration() {
	}

	public long getWorkerconfigid() {
		return this.workerconfigid;
	}

	public void setWorkerconfigid(long workerconfigid) {
		this.workerconfigid = workerconfigid;
	}

	public String getConfigkey() {
		return this.configkey;
	}

	public void setConfigkey(String configkey) {
		this.configkey = configkey;
	}

	public String getConfigvalue() {
		return this.configvalue;
	}

	public void setConfigvalue(String configvalue) {
		this.configvalue = configvalue;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public ConfigurationtypeM getConfigurationtypeM() {
		return this.configurationtypeM;
	}

	public void setConfigurationtypeM(ConfigurationtypeM configurationtypeM) {
		this.configurationtypeM = configurationtypeM;
	}

	public Source getSource() {
		return this.source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Worker getWorker() {
		return this.worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

}