/**
 * 
 */
package com.amp.jpaentities.mo;

import com.amp.jpa.entities.Source;
import com.amp.jpa.entities.Worker;

/**
 * @author MVEKSLER
 *
 */
public class SourceWorkerMO implements Comparable<SourceWorkerMO>
{

	protected Source cSource = new Source();
	
	protected Worker cWorker = new Worker();
	
	public Worker getcWorker() {
		return cWorker;
	}

	public void setcWorker(Worker cWorker) {
		this.cWorker = cWorker;
	}

	public Source getcSource() {
		return cSource;
	}

	public void setcSource(Source cSource) {
		this.cSource = cSource;
	}

	public SourceWorkerMO(Source cSource,
						  Worker cWorker) 
	{
		try
		{
			this.setcSource(cSource);
			
			this.setcWorker(cWorker);
		}
		catch( Exception e)
		{
			
		}
	}
	
	public SourceWorkerMO(Source cSource) 
	{
		try
		{
			this.setcSource(cSource);
		}
		catch( Exception e)
		{
			
		}
	}
	

	public SourceWorkerMO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(SourceWorkerMO cObject) 
	{
		try
		{
			if ( cObject != null )
			{
				return this.getcSource().getName().compareTo(
						cObject.getcSource().getName());
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cSource == null) ? 0 : cSource.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SourceWorkerMO other = (SourceWorkerMO) obj;
		if (cSource == null) {
			if (other.cSource != null)
				return false;
		} 
		else if (!cSource.getName().equals(other.cSource.getName()))
			return false;
		return true;
	}
	
	
}
