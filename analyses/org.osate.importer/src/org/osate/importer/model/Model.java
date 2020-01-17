/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
