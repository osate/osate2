package org.osate.importer.model.sm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.Utils;
import org.osate.importer.model.Component;

public class StateMachine {
	private Component associatedComponent;
	private int identifier;
	private String name;
	private List<Transition> transitions;
	private List<State> states;
	private HashMap<String, Integer> variables;

	public final static int VARIABLE_TYPE_INTEGER = 0;
	public final static int VARIABLE_TYPE_BOOL = 1;

	public StateMachine() {
		this.identifier = Utils.INVALID_ID;
		this.name = null;
		this.associatedComponent = null;
		this.states = new ArrayList<State>();
		this.transitions = new ArrayList<Transition>();
		this.variables = new HashMap<String, Integer>();
	}

	public boolean isInitialState(State s) {
		for (Transition t : this.transitions) {
			if ((t.getSrcState() == null) && (t.getDstState() != null)) {
				if (t.getDstState().getName().equalsIgnoreCase(s.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hasVariables() {
		return (this.variables.size() > 0);
	}

	public boolean nestedStateMachinehasVariables() {
		for (State s : this.states) {
			if (s.getInternalStateMachine().hasVariables()) {
				return true;
			}
		}
		return false;
	}

	public List<String> getVariables() {
		List<String> result = new ArrayList<String>();
		for (String varName : this.variables.keySet()) {
			boolean isStateName = false;

			for (State state : this.states) {
				if (state.getName().equalsIgnoreCase(varName)) {
					isStateName = true;
				}
			}
			if (!isStateName) {
				result.add(varName);
			}
		}

		return result;
	}

	public int getVariableType(String s) {
		return this.variables.get(s);
	}

	public void addVariable(String v, int type) {
		this.variables.put(v, type);
	}

	public void setIdentifier(int i) {
		this.identifier = i;
	}

	public void setName(String n) {
		String s = n.replace('\n', '_');
		this.name = s;
	}

	public Transition findTransitionByIdentifier(int i) {
		for (Transition t : this.transitions) {
			if (t.getIdentifier() == i) {
				return t;
			}
		}
		return null;
	}

	public State findStateByIdentifier(int i) {
		for (State s : this.states) {
			if (s.getIdentifier() == i) {
				return s;
			}
		}
		return null;
	}

	public List<State> getStates() {
		return this.states;
	}

	public List<Transition> getTransitions() {
		return this.transitions;
	}

	public State findStateByName(String n) {
		for (State s : this.states) {
			if ((s.getName() != null) && (s.getName().equalsIgnoreCase(n))) {
				return s;
			}
		}
		return null;
	}

	public State getState(String name) {
		for (State s : this.states) {
			if (s.getName().equalsIgnoreCase(name)) {
				return s;
			}
		}
		State s = new State();
		s.setName(name);
		s.setParentStateMachine(this);
		this.addState(s);
		return s;
	}

	public void addState(State s) {
		for (State stmp : this.states) {
			if (s.getName().equalsIgnoreCase(stmp.getName())) {
				return;
			}
		}
		// OsateDebug.osateDebug("[StateMachine] add state " + s.getName() + " in state machine " + s.getParentStateMachine().getName());
		this.states.add(s);
	}

	public void addTransition(Transition s) {
		this.transitions.add(s);
	}

	public void setAssociatedComponent(Component c) {
		this.associatedComponent = c;
	}

	public Component getAssociatedComponent() {
		return this.associatedComponent;
	}

	public int getIndentifier() {
		return this.identifier;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		String res;
		res = "";

		if (this.name != null) {
			res += "name=" + name;
		}

		if (this.identifier != Utils.INVALID_ID) {
			res += "|id=" + this.identifier;
		}

		res += "\n";

		for (State s : this.states) {
			res += "   state " + s + "\n";
		}

		for (Transition t : this.transitions) {
			res += "   transition " + t + "\n";
		}

		return res;
	}

	public boolean isEmpty() {
		return (this.states.size() == 0);
	}

	public boolean hasNestedStateMachines() {
		for (State s : this.states) {
			if (!s.getInternalStateMachine().isEmpty()) {
				return true;
			}
		}
		return false;
	}

}
