/*
 * Copyright 2014 Carnegie Mellon University
 * 

 * Any opinions, findings and conclusions or recommendations expressed in this 
 * Material are those of the author(s) and do not necessarily reflect the 
 * views of the United States Department of Defense. 

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING 
 * INSTITUTE MATERIAL IS FURNISHED ON AN �AS-IS� BASIS. CARNEGIE MELLON 
 * UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, 
 * AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR 
 * PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF 
 * THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF 
 * ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT 
 * INFRINGEMENT.
 * 
 * This Material has been approved for public release and unlimited 
 * distribution except as restricted below. 
 * 
 * This Material is provided to you under the terms and conditions of the 
 * Eclipse Public License Version 1.0 ("EPL"). A copy of the EPL is 
 * provided with this Content and is also available at 
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Carnegie Mellon is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 * 
 */

package org.osate.importer.scade;

import org.osate.importer.model.Component;
import org.osate.importer.model.Component.PortType;
import org.osate.importer.model.sm.State;
import org.osate.importer.model.sm.StateMachine;
import org.osate.importer.model.sm.Transition;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ImportStateMachine {

	/**
	 * Process the XML node StateMachine in the SCADE model
	 * and complete the stateMachine abstract/generic object
	 * @param smNode        - the XML node that contains the State Machine in the SCADE model
	 * @param stateMachine  - the state machine that will be completed with this function
	 * @param component     - the mapped component that will contain the state machine
	 */
	public static void processStateMachine(Node smNode, StateMachine stateMachine, Component comp) {
		String smName = Utils.getNodeName(smNode);

//		OsateDebug.osateDebug("[ImportModel] state machine name=" + smName);

		stateMachine.setName(smName);

		NodeList nList = smNode.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("states")) {
				processStateMachineStates(nNode, smNode, stateMachine, comp);
			}
		}
	}

	public static void processStateMachineStates(Node states, Node smNode, StateMachine stateMachine, Component comp) {
		NodeList nList = states.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("state")) {

				processStateMachineState(nNode, smNode, stateMachine, comp);
			}
		}
	}

	public static void processStateMachineState(Node state, Node smNode, StateMachine stateMachine, Component comp) {
		NodeList nList = state.getChildNodes();
		String stateName = Utils.getNodeName(state);

//		OsateDebug.osateDebug("[ImportModel] state name=" + stateName);
		State s = stateMachine.getState(stateName);

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			processStateMachineStateTransition(nNode, state, smNode, s, comp);
			processStateMachineStateData(nNode, state, smNode, s, comp);

		}
//		OsateDebug.osateDebug("[ImportStateMachine] add state " + s.getName());
		stateMachine.addState(s);
	}

	/**
	 * Map a state machine transition from SCADE into our generic State Machine
	 * 
	 * @param currentNode        - the current XML node in the SCADE file
	 * @param stateNode          - the state Node in the SCADE file
	 * @param stateMachineNode   - the XML node for the state machine
	 * @param state              - the current state
	 * @param comp               - the component that contain the state machine
	 */
	public static void processStateMachineStateTransition(Node currentNode, Node stateNode, Node stateMachineNode,
			State state, Component comp) {
		NodeList nList = currentNode.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("transition")) {
				Node targetNode = Utils.getFirstNode(nNode, "target");
				Node stateRefNode = Utils.getFirstNode(targetNode, "stateref");

				/**
				 * Get the target state name
				 */
				String targetStateName = Utils.getNodeName(stateRefNode);
//				OsateDebug.osateDebug("[ImportModel] target state name=" + targetStateName);
				State targetState = state.getParentStateMachine().getState(targetStateName);

				/**
				 * Get the condition string
				 */
				Node condNode = Utils.getFirstNodeRec(nNode, "condition");
				for (String condVar : Utils.getAllReferencedVar(condNode)) {
					int type = StateMachine.VARIABLE_TYPE_BOOL;

					for (Component c : comp.getSubEntities()) {
						if (c.getName().equalsIgnoreCase(condVar)) {
							if (c.getPortType() != PortType.BOOL) {
								type = StateMachine.VARIABLE_TYPE_INTEGER;

							}
						}
					}
					state.getParentStateMachine().addVariable(condVar, type);

				}

				String conditionString = Utils.mapConditionToString(condNode);

				Transition t = new Transition();
				t.setSrcState(state);
				t.setDstState(targetState);
				t.setCondition(conditionString);
				state.getParentStateMachine().addTransition(t);
//				OsateDebug.osateDebug("[ImportModel] add transition=" + t);

			}
			if (nNode.getNodeName().equalsIgnoreCase("unless")) {
				processStateMachineStateTransition(nNode, stateNode, stateMachineNode, state, comp);
			}
		}
	}

	/**
	 * process the <data/> node for a state machine.
	 * 
	 * @param currentNode        - the current XML node
	 * @param stateNode          - the node containing the state
	 * @param stateMachineNode   - the state machine node containing the data
	 * @param parentActivestate  - the active states containing the data if any
	 * @param comp               - the component that contains the state machine
	 */
	public static void processStateMachineStateData(Node currentNode, Node stateNode, Node stateMachineNode,
			State parentActivestate, Component comp) {
		NodeList nList = currentNode.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("statemachine")) {
//				OsateDebug.osateDebug("[ImportStateMachine] Add state machine to state" + parentActivestate.getName());
				processStateMachine(nNode, parentActivestate.getInternalStateMachine(), comp);
			}
			if (nNode.getNodeName().equalsIgnoreCase("data")) {
				processStateMachineStateData(nNode, stateNode, stateMachineNode, parentActivestate, comp);
			}
		}
	}

}
