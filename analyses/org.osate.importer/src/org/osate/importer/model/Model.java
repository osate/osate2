package org.osate.importer.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.importer.model.sm.StateMachine;

public class Model {
	private List<Component> 	components;
	private List<Connection> 	connections;
	private List<StateMachine> 	stateMachines; 
	
	
	public Model ()
	{
		this.components 	= new ArrayList<Component>();
		this.connections 	= new ArrayList<Connection>();
		this.stateMachines	= new ArrayList<StateMachine>();
	}
	
	public void addStateMachine (StateMachine sm)
	{
		this.stateMachines.add (sm);
	}
	
	public void addComponent (Component c)
	{
		this.components.add (c);
	}
	
	public void addConnection (Connection c)
	{
		this.connections.add(c);
	}
	
	public List<Component> getComponents ()
	{
		return this.components;
	}
	
	public StateMachine getStateMachine (int identifier)
	{
		for (StateMachine sm : stateMachines)
		{
			if (sm.getIndentifier() == identifier)
			{
				return sm;
			}
		}
		return null;
	}
	
	public StateMachine getStateMachine (String name)
	{
		for (StateMachine sm : stateMachines)
		{
			if (sm.getName().equalsIgnoreCase(name))
			{
				return sm;
			}
		}
		return null;
	}
	
	public List<StateMachine> getStateMachines ()
	{
		return this.stateMachines;
	}
	
	public List<Connection> getConnections ()
	{
		return this.connections;
	}
	
	public Component findComponentById (int id)
	{
		for (Component c : this.components)
		{
			if (c.getIdentifier() == id)
			{
				return c;
			}
		}
		return null;
	}
	
}
