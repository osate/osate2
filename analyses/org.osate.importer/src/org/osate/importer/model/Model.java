package org.osate.importer.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.importer.model.sm.StateMachine;

public class Model {
	private String packageName;
	private List<Component> components;
	private List<Connection> connections;
	private List<StateMachine> stateMachines;
	public static final String DEFAULT_NAME = "unknown";
	private String name;

	public Model() {
		this.name = null;
		this.packageName = DEFAULT_NAME;
		this.components = new ArrayList<Component>();
		this.connections = new ArrayList<Connection>();
		this.stateMachines = new ArrayList<StateMachine>();
	}

	public Model(String p_name) {
		this();
		this.name = p_name;
	}

	public void setName(String n) {
		this.name = n;
	}

	public String getName() {
		return this.name;
	}

	public void setPackageName(String s) {
		String tmp;
		tmp = s.toLowerCase();
		if (tmp.equalsIgnoreCase("system")) {
			tmp = "system_pkg";
		}
		this.packageName = tmp;
	}

	public String getPackageName() {
		return this.packageName;
	}

	/**
	 * Check is a component with the name passed
	 * as parameter already exists or not.
	 * @param name  - the name of the component
	 * @return      - true if it exists
	 */
	public boolean containsComponent(String name) {
//		OsateDebug.osateDebug("Model" , "Try to find a component with the name " + name);
		for (Component c : components) {
//			OsateDebug.osateDebug("Model" , "   already have " + c.getName());
			if (c.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}

		return false;
	}

	public void addStateMachine(StateMachine sm) {
		this.stateMachines.add(sm);
	}

	public void addComponent(Component c) {
		this.components.add(c);
	}

	public void addConnection(Connection c) {
//		OsateDebug.osateDebug("Model" , "Add connection between src=" + c.getSource().getName() + ";dst=" + c.getDestination().getName());
		this.connections.add(c);
	}

	public List<Component> getComponents() {
		return this.components;
	}

	public StateMachine getStateMachine(int identifier) {
		for (StateMachine sm : stateMachines) {
			if (sm.getIndentifier() == identifier) {
				return sm;
			}
		}
		return null;
	}

	public StateMachine getStateMachine(String name) {
		for (StateMachine sm : stateMachines) {
			if (sm.getName().equalsIgnoreCase(name)) {
				return sm;
			}
		}
		return null;
	}

	public List<StateMachine> getStateMachines() {
		return this.stateMachines;
	}

	public List<Connection> getConnections() {
		return this.connections;
	}

	public Component findComponentById(int id) {
		Component sub;
		for (Component c : this.getComponents()) {
			if (c.getIdentifier() == id) {
				return c;
			}

			sub = c.findSubcomponentById(id);
			if (sub != null) {
				return sub;
			}
		}
		return null;
	}

	public Component findComponentByName(String n) {
		Component sub;
		for (Component c : this.getComponents()) {
			if (c.getName().equalsIgnoreCase(n)) {
				return c;
			}

			sub = c.findSubcomponentByName(n);
			if (sub != null) {
				return sub;
			}
		}
		return null;
	}

}
