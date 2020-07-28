package com.amp.jpaentities.mo;

public class WorkerConfigurationMO
{
	//--source configuration
	protected long sourceconfigid;

	protected String configkey;

	protected String configvalue;

	protected String unit;
	
	//---source worker
	private long sourceworkerid;
	
	private String worker_name;
	
	//---configuration type
	protected long configurationtypeid;
	
	protected String target;
	
	//---source
	protected long sourceid;

	protected String company;

	protected String source_name;
	
	//---source type
	protected long sourcetypeid;

	protected String sourcetype_name;

	public long getSourceconfigid() {
		return sourceconfigid;
	}

	public void setSourceconfigid(long sourceconfigid) {
		this.sourceconfigid = sourceconfigid;
	}

	public String getConfigkey() {
		return configkey;
	}

	public void setConfigkey(String configkey) {
		this.configkey = configkey;
	}

	public String getConfigvalue() {
		return configvalue;
	}

	public void setConfigvalue(String configvalue) {
		this.configvalue = configvalue;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public long getConfigurationtypeid() {
		return configurationtypeid;
	}

	public void setConfigurationtypeid(long configurationtypeid) {
		this.configurationtypeid = configurationtypeid;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public long getSourceid() {
		return sourceid;
	}

	public void setSourceid(long sourceid) {
		this.sourceid = sourceid;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSource_name() {
		return source_name;
	}

	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}

	public long getSourcetypeid() {
		return sourcetypeid;
	}

	public void setSourcetypeid(long sourcetypeid) {
		this.sourcetypeid = sourcetypeid;
	}

	public String getSourcetype_name() {
		return sourcetype_name;
	}

	public void setSourcetype_name(String sourcetype_name) {
		this.sourcetype_name = sourcetype_name;
	}

	public long getSourceworkerid() {
		return sourceworkerid;
	}

	public void setSourceworkerid(long sourceworkerid) {
		this.sourceworkerid = sourceworkerid;
	}

	public String getWorker_name() {
		return worker_name;
	}

	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}
	
	
}
