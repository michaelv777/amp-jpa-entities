/**
 * 
 */
package com.amp.jpa.entities.test;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amp.jpa.entities.manager.PersistenceManager;

/**
 * @author MVEKSLER
 *
 */
public class PersistenceManagerTest
{
	private static final Logger LOG = 
			LoggerFactory.getLogger(PersistenceManager.class);
	
	protected EntityManager entityManager = null;
	
	protected PersistenceManager pm = null;
	
	protected EntityManagerFactory fact = null;
	
	protected String dbServerURI = "jdbc:mysql://127.0.0.1:3377/allmarket";
	/**
	 * @param name
	 */
	public PersistenceManagerTest() {
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception 
	{
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception 
	{
		try
		{
			if (this.fact != null )
			{
				this.fact.close();
			}
			
			if (this.pm != null )
			{
				this.pm.close();
			}
		}
		catch( Exception e)
		{
			LOG.error(e.getMessage(), e);
		}
	}
	
	@Ignore
	@Test
	public final void checkNodepersistence() 
	{
		
		boolean cRes = true;
		
		try
		{
			if ( cRes )
			{		
				this.pm = PersistenceManager.getInstance();
				
				if ( null == this.pm )
				{
					cRes = false;
				}
			}
			
			if ( cRes )
			{
				cRes = this.pm.configure(this.dbServerURI, "root", "root", false);
			}
		
			if ( cRes )
			{
				this.fact = pm.getEntityManagerFactory();
				
				if ( null == this.fact )
				{
					cRes = false;
				}
			}
			
			if ( cRes )
			{
				this.entityManager = fact.createEntityManager();
				
				if ( null == this.entityManager )
				{
					cRes = false;
				}
			}
			
			if ( !cRes )
			{
				fail("cRes = false");
			}
		}
		catch( Exception e )
		{
			LOG.error(e.getMessage(), e);
			
			cRes = false;
			
			fail("cRes = false");
		}
	}
}
