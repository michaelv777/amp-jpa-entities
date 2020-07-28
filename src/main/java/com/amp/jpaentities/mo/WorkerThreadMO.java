/**
 * 
 */
package com.amp.jpaentities.mo;

import com.amp.jpa.entities.Worker;

/**
 * @author MVEKSLER
 *
 */
public class WorkerThreadMO implements Comparable<WorkerThreadMO>
{

	protected com.amp.jpa.entities.Thread cThread = new com.amp.jpa.entities.Thread();
	
	protected Worker cWorker = new Worker();
	
	public Worker getcWorker() {
		return cWorker;
	}

	public void setcWorker(Worker cWorker) {
		this.cWorker = cWorker;
	}

	

	public com.amp.jpa.entities.Thread getcThread() {
		return cThread;
	}

	public void setcThread(com.amp.jpa.entities.Thread cThread) {
		this.cThread = cThread;
	}

	public WorkerThreadMO(com.amp.jpa.entities.Thread cThread,
						  Worker cWorker) 
	{
		try
		{
			this.setcThread(cThread);
			
			this.setcWorker(cWorker);
		}
		catch( Exception e)
		{
			
		}
	}
	
	public WorkerThreadMO(com.amp.jpa.entities.Thread cThread) 
	{
		try
		{
			this.setcThread(cThread);
		}
		catch( Exception e)
		{
			
		}
	}
	

	public WorkerThreadMO() {
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public int compareTo(WorkerThreadMO cObject) 
	{
		try
		{
			if ( cObject != null )
			{
				return this.getcThread().getName().compareTo(
						cObject.getcThread().getName());
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
		result = prime * result + ((this.getcThread() == null) ? 0 : this.getcThread().hashCode());
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
		WorkerThreadMO other = (WorkerThreadMO) obj;
		if (this.getcThread() == null) {
			if (other.cThread != null)
				return false;
		} 
		else if ( !cWorker.getName().equals(other.cWorker.getName()) || 
				  !cThread.getName().equals(other.cThread.getName()))
			return false;
		return true;
	}
	
	
}
