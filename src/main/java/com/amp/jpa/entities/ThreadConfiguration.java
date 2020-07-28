package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the thread_configuration database table.
 * 
 */
@Entity
@Table(name="thread_configuration")
@NamedQuery(name="ThreadConfiguration.findAll", query="SELECT t FROM ThreadConfiguration t")
public class ThreadConfiguration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long threadconfigid;

	@Column(nullable=false, length=100)
	private String configkey;

	@Column(length=512)
	private String configvalue;

	@Column(length=100)
	private String unit;

	//bi-directional many-to-one association to ConfigurationtypeM
	@ManyToOne
	@JoinColumn(name="THREADCONFIG2CONFIGTYPE", nullable=false)
	private ConfigurationtypeM configurationtypeM;

	//bi-directional many-to-one association to Source
	@ManyToOne
	@JoinColumn(name="THREADCONFIG2SOURCE", nullable=false)
	private Source source;

	//bi-directional many-to-one association to Thread
	@ManyToOne
	@JoinColumn(name="THREADCONFIG2THREAD", nullable=false)
	private Thread thread;

	public ThreadConfiguration() {
	}

	public long getThreadconfigid() {
		return this.threadconfigid;
	}

	public void setThreadconfigid(long threadconfigid) {
		this.threadconfigid = threadconfigid;
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

	public Thread getThread() {
		return this.thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

}