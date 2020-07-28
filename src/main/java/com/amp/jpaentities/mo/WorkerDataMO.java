/**
 * 
 */
package com.amp.jpaentities.mo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.amp.jpa.entities.OperationtypeM;
import com.amp.jpa.entities.Source;
import com.amp.jpa.entities.StatusM;
import com.amp.jpa.entities.Target;
import com.amp.jpa.entities.Worker;
import com.amp.jpa.entities.WorkerData;

/**
 * @author MVEKSLER
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkerDataMO implements Comparable<WorkerDataMO>, Serializable
{
	
	public WorkerData cWorkerData = new WorkerData();
	
	
	public WorkerData getcWorkerData() {
		return cWorkerData;
	}


	public void setcWorkerData(WorkerData cWorkerData) {
		this.cWorkerData = cWorkerData;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WorkerDataMO() 
	{
		try
		{
			this.cWorkerData = new WorkerData();
			this.cWorkerData.setDescription("");
			this.cWorkerData.setItemid("");
			this.cWorkerData.setOperationtypeM(new OperationtypeM());
			this.cWorkerData.setSource(new Source());
			this.cWorkerData.setStatusM(new StatusM());
			this.cWorkerData.setTarget(new Target());
			this.cWorkerData.setUpdatedate(new Date());
			this.cWorkerData.setWorker(new Worker());
			this.cWorkerData.setThread(new com.amp.jpa.entities.Thread());
			this.cWorkerData.setWorkerdatahash("");
		}
		catch( Exception e)
		{
			
		}
	}
	
	@Override
	public int compareTo(WorkerDataMO cObject) 
	{
		try
		{
			if ( cObject != null )
			{
				return this.getcWorkerData().getWorkerdatahash().
						compareTo(cObject.getcWorkerData().getWorkerdatahash());
			}
			else
			{
				return -1;
			}
		}
		catch( Exception e )
		{
			return -1;
		}
	}
}
