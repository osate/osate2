package org.osate.importer.model.sm;

import java.util.ArrayList;
import java.util.List;

import org.osate.importer.Utils;
import org.osate.importer.model.Component;

public class StateMachine {
	private Component 			associatedComponent;
	private int 				identifier;
	private String				name;
	private List<Transition>	transitions;
	private List<State>			states;
	
	public StateMachine ()
	{
		this.identifier 			= Utils.INVALID_ID;
		this.name					= null;
		this.associatedComponent 	= null;
		this.states					= new ArrayList<State>();
		this.transitions			= new ArrayList<Transition>();
	}
	
	public void setIdentifier (int i)
	{
		this.identifier = i;
	}
	
	public void setName (String n)
	{
		String s = n.replace('\n', '_');
		this.name = s;
	}
	
	public Transition findTransitionByIdentifier (int i)
	{
		for (Transition t : this.transitions)
		{
			if (t.getIdentifier() == i)
			{
				return t;
			}
		}
		return null;
	}
	
	public State findStateByIdentifier (int i)
	{
		for (State s : this.states)
		{
			if (s.getIdentifier() == i)
			{
				return s;
			}
		}
		return null;
	}
	
	public List<State> getStates ()
	{
		return this.states;
	}
	
	public State findStateByName (String n)
	{
		for (State s : this.states)
		{
			if ((s.getName() != null) && (s.getName().equalsIgnoreCase(n)))
			{
				return s;
			}
		}
		return null;
	}
	
	public void addState (State s)
	{
		this.states.add (s);
	}
	
	public void addTransition (Transition s)
	{
		this.transitions.add (s);
	}
	
	public void setAssociatedComponent (Component c)
	{
		this.associatedComponent = c;
	}
	
	public Component getAssociatedComponent ()
	{
		return this.associatedComponent;
	}
	
	public int getIndentifier ()
	{
		return this.identifier;
	}
	
	public String getName ()
	{
		return this.name;
	}
	
	public String toString ()
	{
		String res;
		res = "";
		
		if (this.name != null)
		{
			res += "name=" + name;
		}
		
		if (this.identifier != Utils.INVALID_ID)
		{
			res += "|id=" + this.identifier;
		}
		
		res += "\n";
		
		for (State s : this.states)
		{
			res += "   state " + s + "\n";
		}
		
		for (Transition t : this.transitions)
		{
			res += "   transition " + t + "\n";
		}
		
		return res;
	}

}
