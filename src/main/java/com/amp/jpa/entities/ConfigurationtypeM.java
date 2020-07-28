package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the configurationtype_m database table.
 * 
 */
@Entity
@Table(name="configurationtype_m")
@NamedQuery(name="ConfigurationtypeM.findAll", query="SELECT c FROM ConfigurationtypeM c")
public class ConfigurationtypeM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long configurationtypeid;

	@Column(nullable=false, length=100)
	private String description;

	@Column(length=100)
	private String target;

	//bi-directional many-to-one association to Credential
	@OneToMany(mappedBy="configurationtypeM")
	private Set<Credential> credentials;

	//bi-directional many-to-one association to ThreadConfiguration
	@OneToMany(mappedBy="configurationtypeM")
	private Set<ThreadConfiguration> threadConfigurations;

	//bi-directional many-to-one association to WorkerConfiguration
	@OneToMany(mappedBy="configurationtypeM")
	private Set<WorkerConfiguration> workerConfigurations;

	public ConfigurationtypeM() {
	}

	public long getConfigurationtypeid() {
		return this.configurationtypeid;
	}

	public void setConfigurationtypeid(long configurationtypeid) {
		this.configurationtypeid = configurationtypeid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Set<Credential> getCredentials() {
		return this.credentials;
	}

	public void setCredentials(Set<Credential> credentials) {
		this.credentials = credentials;
	}

	public Credential addCredential(Credential credential) {
		getCredentials().add(credential);
		credential.setConfigurationtypeM(this);

		return credential;
	}

	public Credential removeCredential(Credential credential) {
		getCredentials().remove(credential);
		credential.setConfigurationtypeM(null);

		return credential;
	}

	public Set<ThreadConfiguration> getThreadConfigurations() {
		return this.threadConfigurations;
	}

	public void setThreadConfigurations(Set<ThreadConfiguration> threadConfigurations) {
		this.threadConfigurations = threadConfigurations;
	}

	public ThreadConfiguration addThreadConfiguration(ThreadConfiguration threadConfiguration) {
		getThreadConfigurations().add(threadConfiguration);
		threadConfiguration.setConfigurationtypeM(this);

		return threadConfiguration;
	}

	public ThreadConfiguration removeThreadConfiguration(ThreadConfiguration threadConfiguration) {
		getThreadConfigurations().remove(threadConfiguration);
		threadConfiguration.setConfigurationtypeM(null);

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
		workerConfiguration.setConfigurationtypeM(this);

		return workerConfiguration;
	}

	public WorkerConfiguration removeWorkerConfiguration(WorkerConfiguration workerConfiguration) {
		getWorkerConfigurations().remove(workerConfiguration);
		workerConfiguration.setConfigurationtypeM(null);

		return workerConfiguration;
	}

}