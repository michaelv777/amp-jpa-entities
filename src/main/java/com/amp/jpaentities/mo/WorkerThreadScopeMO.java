/**
 * 
 */
package com.amp.jpaentities.mo;

import com.amp.jpa.entities.WorkerThreadScope;

/**
 * @author MVEKSLER
 *
 */
public class WorkerThreadScopeMO implements Comparable<WorkerThreadScopeMO>
{
	public WorkerThreadScope cWorkerThreadScope = new
			WorkerThreadScope();

	public WorkerThreadScopeMO(WorkerThreadScope cWorkerThreadScope2) 
	{
		this.setcWorkerThreadScope(cWorkerThreadScope2);
	}

	public WorkerThreadScope getcWorkerThreadScope() {
		return cWorkerThreadScope;
	}

	public void setcWorkerThreadScope(WorkerThreadScope cWorkerThreadScope) {
		this.cWorkerThreadScope = cWorkerThreadScope;
	}

	@Override
	public int compareTo(WorkerThreadScopeMO cObject) 
	{
		
		try
		{
			if ( cObject != null )
			{
				
				return new Long (this.getcWorkerThreadScope().getWorkerthreadscopeid()).compareTo(
						new Long (cObject.getcWorkerThreadScope().getWorkerthreadscopeid()));
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
