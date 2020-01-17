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
package org.osate.importer.model.sm;

import java.util.ArrayList;
import java.util.List;

import org.osate.importer.Utils;

public class State {
	private String name;
	private int identifier;
	private List<Transition> incomingTransitions;
	private List<Transition> outgoingTransitions;

	/**
	 * The internal state machine is the state machine
	 * used when being in this state.
	 */
	private StateMachine internalStateMachine;

	/**
	 * The parent state machine is the state machine
	 * where the state belongs to.
	 */
	private StateMachine parentStateMachine;
	private String entrypoint;

	public State() {
		this.identifier = Utils.INVALID_ID;
		this.name = null;
		this.incomingTransitions = new ArrayList<Transition>();
		this.outgoingTransitions = new ArrayList<Transition>();
		this.internalStateMachine = new StateMachine();
		this.parentStateMachine = null;
		this.entrypoint = null;
	}

	public String getEntrypoint() {
		return this.entrypoint;
	}

	public boolean hasEntrypoint() {
		return (entrypoint != null);
	}

	public void setEntrypoint(String ep) {
		String t = null;
		if (ep != null) {
			t = ep.replace(';', ' ').replaceAll("=", ":=");
		}
		this.entrypoint = t;
	}

	public StateMachine getParentStateMachine() {
		return this.parentStateMachine;
	}

	public StateMachine getInternalStateMachine() {
		return this.internalStateMachine;
	}

	public void setParentStateMachine(StateMachine sm) {
		this.parentStateMachine = sm;
	}

	public void setInternalStateMachine(StateMachine sm) {
		this.internalStateMachine = sm;
	}

	public State(String n) {
		this();
		this.setName(n);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String n) {
		String s = n.toLowerCase();
		if (s.equalsIgnoreCase("on")) {
			s = "son";
		}
		if (s.equalsIgnoreCase("off")) {
			s = "soff";
		}
		s = s.replace('\n', '_');
		this.name = s;
	}

	public boolean isValid() {
		if (name.contains("=")) {
			return false;
		}
		return true;
	}

	public void setIdentifier(int i) {
		this.identifier = i;
	}

	public int getIdentifier() {
		return this.identifier;
	}

	public void addIncomingTransition(Transition t) {
		this.incomingTransitions.add(t);
	}

	public void addOutgoingTransition(Transition t) {
		this.outgoingTransitions.add(t);
	}

	public List<Transition> getIncomingTransitions() {
		return this.incomingTransitions;
	}

	public List<Transition> getOutgoingTransitions() {
		return this.outgoingTransitions;
	}

	public String toString() {
		String res;
		res = "State ";

		if (this.name != null) {
			res += "name=" + name;
		}

		if (this.identifier != Utils.INVALID_ID) {
			res += "|id=" + this.identifier;
		}

		return res;
	}

}
