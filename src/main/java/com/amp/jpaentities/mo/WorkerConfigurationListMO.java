package com.amp.jpaentities.mo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WorkerConfigurationListMO 
{
	public ArrayList<WorkerConfigurationMO> cSourceConfiguration = 
			new ArrayList<WorkerConfigurationMO>();
	
	
	public WorkerConfigurationListMO()
	{
		
	}
}
