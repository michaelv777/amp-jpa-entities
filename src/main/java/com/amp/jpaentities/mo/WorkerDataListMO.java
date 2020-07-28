package com.amp.jpaentities.mo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WorkerDataListMO 
{
	public ArrayList<WorkerDataMO> cWorkerData = 
			new ArrayList<WorkerDataMO>();
	
	public WorkerDataListMO()
	{
		
	}
}
