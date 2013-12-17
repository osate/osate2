/*
 * Copyright 2013 Carnegie Mellon University

 * Any opinions, findings and conclusions or recommendations expressed in this 
 * Material are those of the author(s) and do not necessarily reflect the 
 * views of the United States Department of Defense. 

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING 
 * INSTITUTE MATERIAL IS FURNISHED ON AN �AS-IS� BASIS. CARNEGIE MELLON 
 * UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, 
 * AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR 
 * PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF 
 * THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF 
 * ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT 
 * INFRINGEMENT.
 * 
 * This Material has been approved for public release and unlimited 
 * distribution except as restricted below. 
 * 
 * This Material is provided to you under the terms and conditions of the 
 * Eclipse Public License Version 1.0 ("EPL"). A copy of the EPL is 
 * provided with this Content and is also available at 
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Carnegie Mellon� is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 */
package org.osate.importer.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.importer.Utils;
import org.osate.importer.model.sm.StateMachine;

public class Component implements Comparable {

	public enum ComponentType {
		EXTERNAL_INPORT, EXTERNAL_OUTPORT, BLOCK, UNKNOWN
	};
	
	private String 				name;
	private ComponentType 		type;
	private int    				identifier;
	private List<Connection> 	connections;
	private List<Component> 	subEntities;
	private Component 			parent;
	private List<StateMachine>	stateMachines;
	
	public final int COMPONENT_TYPE_EXTERNAL_INPORT  	= 1;
	public final int COMPONENT_TYPE_EXTERNAL_OUTPORT 	= 2;
	public final int COMPONENT_TYPE_BLOCK	 			= 3;
	

	
	public Component (String n)
	{
		this.name = n;
		this.connections 		= new ArrayList<Connection>();
		this.subEntities  		= new ArrayList<Component>();
		this.stateMachines  	= new ArrayList<StateMachine>();
		this.parent 			= null;
		this.identifier 		= Utils.INVALID_ID;
		this.type 				= ComponentType.UNKNOWN;
	}
	
	public void addStateMachine (StateMachine sm)
	{
		this.stateMachines.add(sm);
	}
	
	public ComponentType getType ()
	{
		return this.type;
	}
	
	public void setType (ComponentType t)
	{
		this.type = t;
	}
	
	public Component getParent ()
	{
		return this.parent;
	}
	
	public void setIdentifier (int i)
	{
		this.identifier = i;
	}
	
	public int getIdentifier ()
	{
		return this.identifier;
	}
	
	public void setParent (Component e)
	{
		this.parent = e;
	}
	
	public List<Component> getSubEntities()
	{
		return this.subEntities;
	}
	
	public boolean isContainer ()
	{
		return (! this.subEntities.isEmpty());
	}
	
	public boolean contains (Component e)
	{
		return this.subEntities.contains(e);
	}
	
	public void addOutgoingDependency (Component destination, int s)
	{
		Connection conn = new Connection (this, destination, s);
		connections.add(conn);
	}
	
	public void addIncomingDependency (Component source, int s)
	{
		Connection conn = new Connection (source, this, s);
		connections.add(conn);
	}
	
	
	public void addSubsystem (Component s)
	{
		for (Component e : subEntities)
		{
			if (e.getName().equals(s.getName()))
			{
				return;
			}
		}
		this.subEntities.add(s);
	}
	
	public boolean equalsTo (Component e)
	{
		if (e.getName().equals(this.name))
		{
			return true;
		}
		return false;
	}
	
	public String getName ()
	{
		return this.name;
	}
	
	public String getAadlName()
	{
		String result;

		result = this.name.replaceAll("root", "");
		result = result.replace('\n', '_');
		result = result.replace('$', ' ');
		result = result.replace('.', ' ');
		result = result.replaceAll(" ", "");
		result = result.replaceAll("/", "_");
		result = result.toLowerCase();
		
		/**
		 * Check for some reserved keywords in AADL.
		 */
		if (result.equalsIgnoreCase("constant"))
		{
			return "cconstant";
		}
		return result;
	}
	
	public List<Component> getIncomingDependencies ()
	{
		List<Component> result;
		
		result = new ArrayList<Component>();
		
		for (Connection ec : connections)
		{
			if ((ec.getDestination().getName() == this.getName()) &&
			    (! result.contains(ec.getSource())))
			{
				result.add(ec.getSource());
			}
		}
		
		return result;
	}
	
	public List<Component> getOutgoingDependencies ()
	{
		List<Component> result;
		
		result = new ArrayList<Component>();
		
		for (Connection ec : connections)
		{
			if ((ec.getSource().getName() == this.getName()) &&
				(! result.contains (ec.getDestination())))
			{
				result.add(ec.getDestination());
			}
		}
		
		return result;	
	}
	
	
	public List<Connection> getConnections ()
	{
		return this.connections;
	}
	
	
	public void addConnection (Connection ec)
	{
		for (Connection c : connections)
		{
			if ((c.getSource().getName() == ec.getSource().getName()) &&
				(c.getDestination().getName() == ec.getDestination().getName()))
			{
				return;
			}
		}
		this.connections.add (ec);
	}

	
	public String toString ()
	{
		String r;
		r = "Component " + this.name;
		if (this.identifier != Utils.INVALID_ID)
		{
			r += " (id="+this.identifier+") ";
		}
		
		if (this.type != null)
		{
			r += " (type="+this.type+") ";
		}
		return r;
	}

	public boolean equalsTo(Object arg0) {
		return this.compareTo(arg0)==0;
	}
	
	public int compareTo(Object arg0) {
		if (arg0 instanceof Component)
		{
			return (this.name.equalsIgnoreCase(((Component)arg0).getName()))?0:1 ;
		}
		return -1;
	}
}
