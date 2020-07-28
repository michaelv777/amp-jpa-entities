/**
 * 
 */
package com.amp.jpaentities.mo;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import com.amp.jpa.entities.Node;

import com.amp.amazon.webservices.rest.Item;

/**
 * @author MVEKSLER
 *
 */
public class NodeMO implements Comparable<NodeMO>
{
	protected Node cRootNode = new Node();
	
	protected Node cNode = new Node();
	
	protected LinkedList<NodeMO> cSubNodes = 
			new LinkedList<NodeMO>();

	protected LinkedHashMap<Long , LinkedList<Item>> cItems = 
			new LinkedHashMap<Long , LinkedList<Item>>();
	
	public LinkedHashMap<Long, LinkedList<Item>> getcItems() {
		return cItems;
	}

	public void setcItems(LinkedHashMap<Long, LinkedList<Item>> cItems) {
		this.cItems = cItems;
	}

	public LinkedList<NodeMO> getcSubNodes() {
		return cSubNodes;
	}

	public void setcSubNodes(LinkedList<NodeMO> cSubNodes) {
		this.cSubNodes = cSubNodes;
	}

	public Node getcNode() {
		return cNode;
	}

	public void setcNode(Node cNode) {
		this.cNode = cNode;
	}

	public Node getcRootNode() {
		return cRootNode;
	}

	public void setcRootNode(Node cRootNode) {
		this.cRootNode = cRootNode;
	}

	public NodeMO(Node cNode) 
	{
		try
		{
			this.setcNode(cNode);
			
			if ( cNode.getNodes() != null )
			{
				for( Node cChildNode : cNode.getNodes() )
				{
					this.cSubNodes.add(new NodeMO(cChildNode, cNode));
				}
			}
		}
		catch( Exception e)
		{
			
		}
	}

	public NodeMO(Node cNode, Node cRootNode) 
	{
		try
		{
			this.setcNode(cNode);
			
			this.setcRootNode(cRootNode);
			
			if ( cNode.getNodes() != null )
			{
				/*
				for( Node cChildNode : cNode.getNodes() )
				{
					this.cSubNodes.add(new NodeMO(cChildNode, cRootNode));
				}
				*/
			}
		}
		catch( Exception e)
		{
			
		}
	}
	
	public NodeMO() 
	{
		try
		{
			
		}
		catch( Exception e)
		{
			
		}
	}
	
	public String getName()
	{
		try
		{
			if ( this.cNode != null )
			{
				return this.cNode.getName();
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
	
	public String getBrowsenodeid()
	{
		try
		{
			if ( this.cNode != null )
			{
				return this.cNode.getBrowsenodeid();
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
	public int compareTo(NodeMO cObject) 
	{
		try
		{
			if ( cObject != null )
			{
				return this.getBrowsenodeid().compareTo(cObject.getBrowsenodeid());
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
