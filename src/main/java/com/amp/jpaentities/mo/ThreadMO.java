/**
 * 
 */
package com.amp.jpaentities.mo;

/**
 * @author MVEKSLER
 *
 */
public class ThreadMO implements Comparable<ThreadMO>
{

	protected com.amp.jpa.entities.Thread cThread = new com.amp.jpa.entities.Thread();
	
	public com.amp.jpa.entities.Thread getcThread() {
		return cThread;
	}

	public void setcThread(com.amp.jpa.entities.Thread cThread) {
		this.cThread = cThread;
	}

	public ThreadMO(com.amp.jpa.entities.Thread cThread) 
	{
		try
		{
			this.setcThread(cThread);
		}
		catch( Exception e)
		{
			
		}
	}
	

	public ThreadMO() {
		// TODO Auto-generated constructor stub
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
		ThreadMO other = (ThreadMO) obj;
		if (this.getcThread() == null) {
			if (other.cThread != null)
				return false;
		} 
		else if (!cThread.getName().equals(other.cThread.getName()))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(ThreadMO obj) 
	{
		if (this == obj)
			return -1;
		if (obj == null)
			return -1;
		if (getClass() != obj.getClass())
			return -1;
		ThreadMO other = (ThreadMO) obj;
		if (this.getcThread() == null) {
			if (other.cThread != null)
				return -1;
		} 
		
		return new Long(this.cThread.getThreadid()).compareTo(
			new Long(other.cThread.getThreadid()));
			
	}
}
