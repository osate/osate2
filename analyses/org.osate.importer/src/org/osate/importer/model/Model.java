package org.osate.importer.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.importer.statemachine.StateMachine;

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
