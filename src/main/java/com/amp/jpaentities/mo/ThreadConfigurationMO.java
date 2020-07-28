/**
 * 
 */
package com.amp.jpaentities.mo;

import com.amp.jpa.entities.ThreadConfiguration;

/**
 * @author MVEKSLER
 *
 */
public class ThreadConfigurationMO implements Comparable<ThreadConfigurationMO>
{
	public ThreadConfiguration cThreadConfiguration = 
			new ThreadConfiguration();

	public ThreadConfiguration getcThreadConfiguration() {
		return cThreadConfiguration;
	}

	public void setcThreadConfiguration(ThreadConfiguration cThreadConfiguration) {
		this.cThreadConfiguration = cThreadConfiguration;
	}
	
	public ThreadConfigurationMO()
	{
		
	}
	
	public ThreadConfigurationMO(ThreadConfiguration cThreadConfiguration)
	{
		this.setcThreadConfiguration(cThreadConfiguration);
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
		ThreadConfigurationMO other = (ThreadConfigurationMO) obj;
		if (this.cThreadConfiguration == null) {
			if (other.cThreadConfiguration != null)
				return false;
		} 
		else if ( cThreadConfiguration.getThread().getThreadid() != 
			other.cThreadConfiguration.getThread().getThreadid())
			return false;
		
		return true;
	}

	@Override
	public int compareTo(ThreadConfigurationMO obj) 
	{
		if (this == obj)
			return -1;
		if (obj == null)
			return -1;
		if (getClass() != obj.getClass())
			return -1;
		ThreadConfigurationMO other = (ThreadConfigurationMO) obj;
		if (this.cThreadConfiguration == null) {
			if (other.cThreadConfiguration != null)
				return -1;
		} 
		return new Long(cThreadConfiguration.getThread().getThreadid()).compareTo(
			new Long(other.cThreadConfiguration.getThread().getThreadid()));
			
	}
}
