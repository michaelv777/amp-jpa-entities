/**
 * 
 */
package com.amp.jpaentities.mo;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import com.amp.jpa.entities.Category;

import com.amp.amazon.webservices.rest.Item;

/**
 * @author MVEKSLER
 *
 */
public class CategoryMO implements Comparable<CategoryMO>
{
	protected Category cCategory = new Category();

	protected LinkedList<NodeMO> cCategoryNodes = 
			new LinkedList<NodeMO>();
			
	protected LinkedHashMap<Long, LinkedList<Item>> cItems = 
			new LinkedHashMap<Long , LinkedList<Item>>();
	
	public LinkedHashMap<Long, LinkedList<Item>> getcItems() {
		return cItems;
	}

	public void setcItems(LinkedHashMap<Long, LinkedList<Item>> cItems) {
		this.cItems = cItems;
	}

	public LinkedList<NodeMO> getcCategoryNodes() {
		return cCategoryNodes;
	}

	public void setcCategoryNodes(LinkedList<NodeMO> cCategoryNodes) {
		this.cCategoryNodes = cCategoryNodes;
	}

	public CategoryMO(Category cCategory) 
	{
		try
		{
			this.setcCategory(cCategory);
		}
		catch( Exception e)
		{
			
		}
	}

	public CategoryMO(String cCategoryName) 
	{
		try
		{
			this.getcCategory().setName(cCategoryName);
		}
		catch( Exception e)
		{
			
		}
	}
	
	public CategoryMO() 
	{
		try
		{
			
		}
		catch( Exception e)
		{
			
		}
	}

	public Category getcCategory() {
		return cCategory;
	}

	public void setcCategory(Category cCategory) {
		this.cCategory = cCategory;
	}
	
	public String getName()
	{
		try
		{
			if ( this.cCategory != null )
			{
				return this.cCategory.getName();
			}
			else 
			{
				return "";
			}
		}
		catch( Exception e)
		{
			return "";
		}
	}
	
	public String getSearchIndex()
	{
		try
		{
			if ( this.cCategory != null )
			{
				return this.cCategory.getSearchindex();
			}
			else 
			{
				return "";
			}
		}
		catch( Exception e)
		{
			return "";
		}
	}
	
	public long getCategoryid()
	{
		try
		{
			if ( this.cCategory != null )
			{
				return this.cCategory.getCategoryid();
			}
			else 
			{
				return -1L;
			}
		}
		catch( Exception e)
		{
			return -1L;
		}
	}
	
	public String getRootbrowsenode()
	{
		try
		{
			if ( this.cCategory != null )
			{
				return this.cCategory.getRootbrowsenode();
			}
			else 
			{
				return "";
			}
		}
		catch( Exception e)
		{
			return "";
		}
	}

	@Override
	public int compareTo(CategoryMO cObject)
	{
		try
		{
			if ( cObject != null )
			{
				return this.getRootbrowsenode().compareTo(cObject.getRootbrowsenode());
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
