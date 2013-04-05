package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.List;

import org.osate2.aadl2.errormodel.analysis.prism.expression.Expression;
import org.osate2.aadl2.errormodel.analysis.prism.expression.Terminal;

/**
 * This class implements a command for PRISM
 * Typically, a command is what is inserted for switching between
 * states in a PRISM module. It is composed of one condition
 * (why the command should be performed) and several transitions.
 * Each transition has a fixed probability associated that designates
 * if the transition shall be activated or not.
 * 
 * @author jdelange
 *
 */
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
