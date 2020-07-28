package com.amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the credential database table.
 * 
 */
@Entity
@Table(name="credential")
@NamedQuery(name="Credential.findAll", query="SELECT c FROM Credential c")
public class Credential implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long credentialid;

	@Column(name="AWS_ACCESS_KEY_ID", length=256)
	private String awsAccessKeyId;

	@Column(name="AWS_ASSOCIATE_TAG", length=256)
	private String awsAssociateTag;

	@Column(name="AWS_ENDPOINT", length=256)
	private String awsEndpoint;

	@Column(name="AWS_SECRET_KEY", length=256)
	private String awsSecretKey;

	@Column(length=256)
	private String description;

	//bi-directional many-to-one association to ConfigurationtypeM
	@ManyToOne
	@JoinColumn(name="CREDENTIAL2CONFIGTYPE", nullable=false)
	private ConfigurationtypeM configurationtypeM;

	//bi-directional many-to-one association to ThreadScopeCredential
	@OneToMany(mappedBy="credential")
	private Set<ThreadScopeCredential> threadScopeCredentials;

	public Credential() {
	}

	public long getCredentialid() {
		return this.credentialid;
	}

	public void setCredentialid(long credentialid) {
		this.credentialid = credentialid;
	}

	public String getAwsAccessKeyId() {
		return this.awsAccessKeyId;
	}

	public void setAwsAccessKeyId(String awsAccessKeyId) {
		this.awsAccessKeyId = awsAccessKeyId;
	}

	public String getAwsAssociateTag() {
		return this.awsAssociateTag;
	}

	public void setAwsAssociateTag(String awsAssociateTag) {
		this.awsAssociateTag = awsAssociateTag;
	}

	public String getAwsEndpoint() {
		return this.awsEndpoint;
	}

	public void setAwsEndpoint(String awsEndpoint) {
		this.awsEndpoint = awsEndpoint;
	}

	public String getAwsSecretKey() {
		return this.awsSecretKey;
	}

	public void setAwsSecretKey(String awsSecretKey) {
		this.awsSecretKey = awsSecretKey;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ConfigurationtypeM getConfigurationtypeM() {
		return this.configurationtypeM;
	}

	public void setConfigurationtypeM(ConfigurationtypeM configurationtypeM) {
		this.configurationtypeM = configurationtypeM;
	}

	public Set<ThreadScopeCredential> getThreadScopeCredentials() {
		return this.threadScopeCredentials;
	}

	public void setThreadScopeCredentials(Set<ThreadScopeCredential> threadScopeCredentials) {
		this.threadScopeCredentials = threadScopeCredentials;
	}

	public ThreadScopeCredential addThreadScopeCredential(ThreadScopeCredential threadScopeCredential) {
		getThreadScopeCredentials().add(threadScopeCredential);
		threadScopeCredential.setCredential(this);

		return threadScopeCredential;
	}

	public ThreadScopeCredential removeThreadScopeCredential(ThreadScopeCredential threadScopeCredential) {
		getThreadScopeCredentials().remove(threadScopeCredential);
		threadScopeCredential.setCredential(null);

		return threadScopeCredential;
	}

}