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

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.Utils;
import org.osate.importer.model.sm.StateMachine;

public class Component implements Comparable {

	public enum ComponentType {
		EXTERNAL_INPORT, EXTERNAL_OUTPORT, BLOCK, REFERENCE, UNKNOWN
	};

	public enum PortType {
		BOOL, FLOAT, DOUBLE, INT, UNKNOWN
	};

	private String name;
	private ComponentType type;
	private int identifier;
	private List<Connection> connections;
	private List<Component> subEntities;
	private Component parent;
	private List<StateMachine> stateMachines;
	private PortType portType;
	private String referencedModel;
	private String referencedComponent;

	/**
	 * These two lists are here to keep track of the order of the
	 * ports.
	 */
	public List<Component> inports;
	public List<Component> outports;

	public final int COMPONENT_TYPE_EXTERNAL_INPORT = 1;
	public final int COMPONENT_TYPE_EXTERNAL_OUTPORT = 2;
	public final int COMPONENT_TYPE_BLOCK = 3;

	public Component copy() {
		Component instance = new Component(this.name);
		instance.setIdentifier(this.identifier);
		instance.setParent(this.parent);
		instance.setPortType(this.getPortType());
		instance.setType(this.type);

		for (Connection c : this.connections) {
			instance.addConnection(c);
		}
		for (Component c : this.subEntities) {
			instance.addSubsystem(c);
		}
		for (StateMachine sm : this.stateMachines) {
			instance.addStateMachine(sm);
		}
		return instance;
	}

	public Component(String n) {
		this.name = n;
		this.connections = new ArrayList<Connection>();
		this.subEntities = new ArrayList<Component>();
		this.inports = new ArrayList<Component>();
		this.outports = new ArrayList<Component>();
		this.stateMachines = new ArrayList<StateMachine>();
		this.parent = null;
		this.identifier = Utils.INVALID_ID;
		this.type = ComponentType.UNKNOWN;
		this.referencedComponent = null;
		this.referencedModel = null;
	}

	public String getReferencedComponent() {
		return this.referencedComponent;
	}

	public String getReferencedModel() {
		return this.referencedModel;
	}

	public String getAadlReferencedModel() {
		return Utils.toAadl(this.referencedModel);
	}

	public String getAadlReferencedComponent() {
		return Utils.toAadl(this.referencedComponent);
	}

	public void setReferencedModel(String m) {
		this.referencedModel = m;
	}

	public void setReferencedComponent(String c) {
		this.referencedComponent = c;
	}

	/**
	 * get a list of sub components having the type given
	 * in parameter.
	 * @param type - the expected type of the subcomponent
	 * @return a list of all subcomponents having the type passed as parameter.
	 */
	public List<Component> getSubcomponents(ComponentType type) {
		List<Component> result;

		result = new ArrayList<Component>();
		for (Component c : this.subEntities) {
			if (c.getType() == type) {
				result.add(c);
			}
		}

		return result;

	}

	/**
	 * returns a value is the component has any interface
	 * with another system - either through a port
	 * or using dependencies.
	 * @return - a boolean that indicates if the component
	 *           has any dependency or not.
	 */
	public boolean hasInterfaces() {
		if (this.getIncomingDependencies().size() > 0) {
			return true;
		}
		if (this.getOutgoingDependencies().size() > 0) {
			return true;
		}

		for (Component c : subEntities) {
			if ((c.getType() == ComponentType.EXTERNAL_INPORT) || (c.getType() == ComponentType.EXTERNAL_OUTPORT)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * indicate if the current component has block
	 * subcomponents.
	 * 
	 * @return - true if the components has subcomponents that are block. false otherwise
	 */
	public boolean hasSubcomponents() {
		for (Component c : subEntities) {
			if ((c.getType() == ComponentType.BLOCK) || (c.getType() == ComponentType.REFERENCE)) {
				return true;
			}
		}

		return false;
	}

	public boolean hasIncomingDependencies() {
		return (this.getIncomingDependencies().size() > 0);
	}

	public boolean hasOutgoingDependencies() {
		return (this.getOutgoingDependencies().size() > 0);
	}

	public void setPortType(PortType pt) {
		this.portType = pt;
	}

	public PortType getPortType() {
		return this.portType;
	}

	public void addStateMachine(StateMachine sm) {
		this.stateMachines.add(sm);
	}

	public List<StateMachine> getStateMachines() {
		return (this.stateMachines);
	}

	public ComponentType getType() {
		return this.type;
	}

	public Component findSubcomponent(String n) {
		for (Component c : subEntities) {
			if (c.getName().equalsIgnoreCase(n)) {
				return c;
			}
		}
		return null;
	}

	public Component findSubcomponentById(int id) {
		Component tmp;

		for (Component c : subEntities) {
			if (c.getIdentifier() == id) {
				return c;
			}

			tmp = c.findSubcomponentById(id);

			if (tmp != null) {
				return tmp;
			}
		}
		return null;
	}

	public Component findSubcomponentByName(String n) {
		Component tmp;

		for (Component c : subEntities) {
			if (c.getName().equalsIgnoreCase(n)) {
				return c;
			}

			tmp = c.findSubcomponentByName(n);

			if (tmp != null) {
				return tmp;
			}
		}
		return null;
	}

	public void setType(ComponentType t) {
		this.type = t;
	}

	public Component getParent() {
		return this.parent;
	}

	public void setIdentifier(int i) {
		this.identifier = i;
	}

	public int getIdentifier() {
		return this.identifier;
	}

	public void setParent(Component e) {
		this.parent = e;
	}

	public List<Component> getSubEntities() {
		return this.subEntities;
	}

	public boolean isContainer() {
		return (!this.subEntities.isEmpty());
	}

	public boolean contains(Component e) {
		return this.subEntities.contains(e);
	}

	public void addOutgoingDependency(Component destination, int s) {
		Connection conn = new Connection(this, destination, s);
		connections.add(conn);
	}

	public void addIncomingDependency(Component source, int s) {
		Connection conn = new Connection(source, this, s);
		connections.add(conn);
	}

	public void addSubsystem(Component s) {
		for (Component e : subEntities) {
			if ((e.getName().equals(s.getName())) && s.getType() == e.getType()) {
				return;
			}
		}

		if (s.getType() == ComponentType.EXTERNAL_INPORT) {
			this.inports.add(s);
		}

		if (s.getType() == ComponentType.EXTERNAL_OUTPORT) {
			this.outports.add(s);
		}

		this.subEntities.add(s);
	}

	public Component getInPort(int i) {
		if (i >= this.inports.size()) {
			return null;
		}

		return this.inports.get(i);
	}

	public Component getOutPort(int i) {
		if (i >= this.outports.size()) {
			return null;
		}

		return this.outports.get(i);
	}

	public int getInportIndex(Component s) {
		int index = 0;

		for (int i = 0; i < this.inports.size(); i++) {
			if (this.inports.get(i) == s) {
				index = i;
			}
		}

		return index;
	}

	public int getOutportIndex(Component s) {
		int index = 0;

		for (int i = 0; i < this.outports.size(); i++) {
			if (this.outports.get(i) == s) {
				index = i;
			}
		}

		return index;
	}

	public boolean equalsTo(Component e) {
		if (e.getName().equals(this.name)) {
			return true;
		}
		return false;
	}

	public String getName() {
		return this.name;
	}

	public String getAadlName() {
		return Utils.toAadl(this.name);
	}

	public List<Component> getIncomingDependencies() {
		List<Component> result;

		result = new ArrayList<Component>();

		for (Connection ec : connections) {
			if ((ec.getDestination().getName() == this.getName()) && (!result.contains(ec.getSource()))) {
				result.add(ec.getSource());
			}
		}

		return result;
	}

	public List<Component> getOutgoingDependencies() {
		List<Component> result;

		result = new ArrayList<Component>();

		for (Connection ec : connections) {
			if ((ec.getSource().getName() == this.getName()) && (!result.contains(ec.getDestination()))) {
				result.add(ec.getDestination());
			}
		}

		return result;
	}

	public List<Connection> getConnections() {
		return this.connections;
	}

	public void addConnection(Connection ec) {
		for (Connection c : connections) {
			if ((c.getSource().getName() == ec.getSource().getName())
					&& (c.getDestination().getName() == ec.getDestination().getName())) {
				OsateDebug.osateDebug("[Component] not adding the connection");
				return;
			}
		}
		this.connections.add(ec);
	}

	public String toString() {
		String r;
		r = "Component " + this.name;
		if (this.identifier != Utils.INVALID_ID) {
			r += " (id=" + this.identifier + ") ";
		}

		if (this.type != null) {
			r += " (type=" + this.type + ") ";
		}
		return r;
	}

	public boolean equalsTo(Object arg0) {
		return this.compareTo(arg0) == 0;
	}

	public Component getSubEntity(String name) {
		for (Component c : subEntities) {
			if (c.getName().equalsIgnoreCase(name)) {
				return c;
			}
		}
		return null;
	}

	public int compareTo(Object arg0) {
		if (arg0 instanceof Component) {
			return (this.name.equalsIgnoreCase(((Component) arg0).getName())) ? 0 : 1;
		}
		return -1;
	}
}
