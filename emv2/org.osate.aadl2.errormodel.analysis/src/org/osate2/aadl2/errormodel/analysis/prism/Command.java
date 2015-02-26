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
public class Command {
	private Expression condition;
	private List<Transition> transitions;
	private CommandType commandType;

	public Command() {
		condition = new Terminal("unknown_condition");
		transitions = new ArrayList<Transition>();
		commandType = CommandType.TRANSITION;
	}

	public CommandType getCommandType() {
		return commandType;
	}

	public void setCommandType(CommandType ct) {
		commandType = ct;
	}

	public void setCondition(Expression e) {
		condition = e;
	}

	public Expression getCondition() {
		return condition;
	}

	public void addTransition(Transition t) {
		transitions.add(t);
	}

	public List<Transition> getTransitions() {
		return transitions;
	}
}
