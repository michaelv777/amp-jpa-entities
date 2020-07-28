package com.amp.jpa.entities.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amp.jpa.entities.Client;
import com.mchange.v2.c3p0.ComboPooledDataSource;


public class PersistenceManager 
{
	private static final Logger LOG = 
			LoggerFactory.getLogger(PersistenceManager.class);
	
	private static PersistenceManager pm = null;
	
	private EntityManagerFactory entityManagerFactory = null;
	
	private Map<String, String> properties = null;
	
	private ComboPooledDataSource dataSource = null;
	
	private boolean cResL = true;
	
	//---getters/setters-------------------------------------------------
	/**
	 * @return the pm
	 */
	public static PersistenceManager getPm() {
		return pm;
	}

	/**
	 * @param pm the pm to set
	 */
	public static void setPm(PersistenceManager pm) {
		PersistenceManager.pm = pm;
	}

	/**
	 * @return the dataSource
	 */
	public ComboPooledDataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(ComboPooledDataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * @return the cResL
	 */
	public boolean iscResL() {
		return cResL;
	}

	/**
	 * @param cResL the cResL to set
	 */
	public void setcResL(boolean cResL) {
		this.cResL = cResL;
	}

	/**
	 * @param entityManagerFactory the entityManagerFactory to set
	 */
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	//---class methods---------------------------------------------------
	public static PersistenceManager getInstance() 
	{
		if (pm == null) 
		{
			pm = new PersistenceManager();
		}
		return pm;
	}
	//---------------------------------------------------------------------
	public EntityManagerFactory getEntityManagerFactory() 
	{
		try
		{
			if (this.entityManagerFactory == null) 
			{
				this.entityManagerFactory = 
						Persistence.createEntityManagerFactory(
								"amp-jpa-entities-mysql-static", properties);
			}
	
			return this.entityManagerFactory;
		}
		catch( Exception e)
		{
			LOG.error(e.getMessage(), e);
			
			setcResL(false);
			
			return null;
		}
	}
	//---------------------------------------------------------------------
	public Map<String, String> getProperties() 
	{
		return properties;
	}
	//---------------------------------------------------------------------
	public void setProperties(Map<String, String> properties) 
	{
		try
		{
			if (this.entityManagerFactory != null) 
			{
				this.closeEntityManagerFactory();
			}
			
			this.properties = properties;
		}
		catch( Exception e)
		{
			//System.out.println(e.getMessage());
			setcResL(false);
			
			return;
		}
	}
	//----------------------------------------------
	public boolean configure(String url, String userName, String password, boolean autocommit) 
	{
		boolean cRes = true;
		
		try
		{
			Map<String, String> properties = new HashMap<String, String>();
			
			properties.put(JPAConstants.JPA_PROPERTY_URL, url);
			
			properties.put(JPAConstants.JPA_PROPERTY_USER, userName);
			
			properties.put(JPAConstants.JPA_PROPERTY_PASSWORD, password);
			
			properties.put(JPAConstants.JPA_PROPERTY_AUTOCOMMIT, Boolean.toString(autocommit));
			
			setProperties(properties);
			
			return cRes;
		}
		catch( Exception e )
		{
			setcResL(false);
			
			return (false);
		}
	}
	//----------------------------------------------
	public Connection getConnection()
	{
		try
		{
			if (this.dataSource == null) 
			{
				this.dataSource = new ComboPooledDataSource();
				
				this.dataSource.setJdbcUrl(properties.get(JPAConstants.JPA_PROPERTY_URL));
				
				this.dataSource.setUser(properties.get(JPAConstants.JPA_PROPERTY_USER));
				
				this.dataSource.setPassword(properties.get(JPAConstants.JPA_PROPERTY_PASSWORD));
			}
			
			return this.dataSource.getConnection();
		}
		catch( SQLException sqle)
		{
			setcResL(false);
			
			return null;
		}
		catch( Exception e)
		{
			setcResL(false);
			
			return null;
		}
	}
	
	//----------------------------------------------
	public void close() 
	{
		try
		{
			this.closeEntityManagerFactory();
			
			this.closeConnection();
		}
		catch( Exception e)
		{
			setcResL(false);
			
			return;
		}
	}
	//----------------------------------------------
	private void closeEntityManagerFactory() 
	{
		if (this.entityManagerFactory != null && this.entityManagerFactory.isOpen()) 
		{
			this.entityManagerFactory.close();
			
			this.entityManagerFactory = null;
		}
	}
	//----------------------------------------------
	public boolean closeConnection()
	{
		try
		{
			if (this.dataSource != null && !this.dataSource.getConnection().isClosed()) 
			{
				this.dataSource.getConnection().close();
			}
			
			return true;
		}
		catch(SQLException sqle)
		{
			setcResL(false);
			
			return false;
		}
	}
	
	//----------------------------------------------
	public static List<Class<? extends Object>> getPersistanceClasses()
	{
		List<Class<? extends Object>> cPersistanceClasses = new ArrayList<Class<? extends Object>>();
		
		try
		{
			
			String cPackageName = Client.class.getPackage().getName();
			
			Reflections reflections = new Reflections(cPackageName, new SubTypesScanner(false));
			
			Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);
			
			for ( Class<?> cClazz : allClasses)
			{
				cPersistanceClasses.add(cClazz);
			}
			 
			return cPersistanceClasses;
		}
		catch(Exception e)
		{
			return cPersistanceClasses;
		}
	}
	//----------------------------------------------
	
}
