package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.List;

import org.osate2.aadl2.errormodel.analysis.prism.expression.*;

public class Command 
{
	private Expression condition;
	private List<Transition> transitions;
	
	public Command ()
	{
		this.condition 		= new Terminal ("unknown_condition");
		this.transitions 	= new ArrayList<Transition> ();
	}
	
	public void setCondition (Expression e)
	{
		this.condition = e;
	}
	
	public Expression getCondition ()
	{
		return this.condition;
	}
	
	public void addTransition (Transition t)
	{
		this.transitions.add(t);
	}
	
	public List<Transition> getTransitions ()
	{
		return this.transitions;
	}
}
