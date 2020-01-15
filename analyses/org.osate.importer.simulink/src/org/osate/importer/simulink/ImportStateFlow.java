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
package org.osate.importer.simulink;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.model.Model;
import org.osate.importer.model.sm.State;
import org.osate.importer.model.sm.StateMachine;
import org.osate.importer.model.sm.Transition;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ImportStateFlow {

	public static void processStateFlow(Node sf, Model producedModel) {
		NodeList nList = sf.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("machine")) {
				// OsateDebug.osateDebug("machine");
				processStateFlowMachine(nNode, producedModel);
			}

			if (nNode.getNodeName().equalsIgnoreCase("instance")) {
				StateFlowInstance sfi = new StateFlowInstance();
				// OsateDebug.osateDebug("machine");
				Node attrName;
				String attrValue;
				NodeList nList2 = nNode.getChildNodes();
				for (int temp2 = 0; temp2 < nList2.getLength(); temp2++) {
					Node nNode2 = nList2.item(temp2);
					if (nNode2.getNodeName().equalsIgnoreCase("p")) {
						attrName = Utils.getAttribute(nNode2, "Name");
						attrValue = attrName.getNodeValue().toString();

						if (attrValue.equalsIgnoreCase("name")) {
							sfi.setName(nNode2.getTextContent());
						}

						if (attrValue.equalsIgnoreCase("machine")) {
							sfi.setMachineId(Integer.parseInt(nNode2.getTextContent()));
						}

						if (attrValue.equalsIgnoreCase("chart")) {
							sfi.setChartId(Integer.parseInt(nNode2.getTextContent()));
						}
					}
				}
				OsateDebug.osateDebug("Add instance of stateflow");
				FileImport.addStateFlowInstance(sfi);
			}
		}
	}

	private static void processStateFlowChild(Node child, StateMachine sm) {
		NodeList nList;

		/**
		 * Process all the nodes.
		 */
		nList = child.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("state")) {
				processStateFlowState(nNode, sm);
			}
			if (nNode.getNodeName().equalsIgnoreCase("chart")) {
				processStateFlowChart(nNode, sm);
			}
			if (nNode.getNodeName().equalsIgnoreCase("transition")) {
				processStateFlowTransition(nNode, sm);
			}
		}
	}

	private static void processStateFlowChart(Node chart, StateMachine sm) {
		NodeList nList;

		/**
		 * Process all the nodes.
		 */
		nList = chart.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("children")) {
				processStateFlowChild(nNode, sm);
			}
		}
	}

	private static void processStateFlowTransition(Node transition, StateMachine sm) {
		NodeList nList;
		NodeList nList2;
		Node attrName;
		String attrValue;
		Transition newTransition;

		newTransition = new Transition();

		// OsateDebug.osateDebug("[FileImport] Parsing transition");

		/**
		 * Check the identifier of the state.
		 */
		attrName = Utils.getAttribute(transition, "SSID");
		attrValue = attrName.getNodeValue().toString();
		newTransition.setIdentifier(Integer.parseInt(attrValue));
		// OsateDebug.osateDebug("[FileImport] SSID value="+attrName);

		/**
		 * Process all the nodes.
		 */
		nList = transition.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("p")) {
				attrName = Utils.getAttribute(nNode, "Name");
				attrValue = attrName.getNodeValue().toString();

				if (attrValue.equalsIgnoreCase("labelstring")) {
					newTransition.setCondition(Utils.getConditionFromLabel(nNode.getTextContent()));
					newTransition.setAction(Utils.getActionFromLabel(nNode.getTextContent()));

					for (String var : Utils
							.getVariablesFromConditionOrAction(Utils.getConditionFromLabel(nNode.getTextContent()))) {

						int varType = StateMachine.VARIABLE_TYPE_INTEGER;
						if (Utils.isSimpleConditionLabel(nNode.getTextContent())) {
							varType = StateMachine.VARIABLE_TYPE_BOOL;
						}
						sm.addVariable(var, varType);
					}

					for (String var : Utils
							.getVariablesFromConditionOrAction(Utils.getActionFromLabel(nNode.getTextContent()))) {

						int varType = StateMachine.VARIABLE_TYPE_INTEGER;
						if (Utils.isSimpleActionLabel(nNode.getTextContent())) {
							varType = StateMachine.VARIABLE_TYPE_BOOL;
						}
						sm.addVariable(var, varType);
					}
				}
			}

			if (nNode.getNodeName().equalsIgnoreCase("src")) {
				nList2 = nNode.getChildNodes();
				for (int temp2 = 0; temp2 < nList2.getLength(); temp2++) {
					Node nNode2 = nList2.item(temp2);
					if (nNode2.getNodeName().equalsIgnoreCase("p")) {
						attrName = Utils.getAttribute(nNode2, "Name");
						attrValue = attrName.getNodeValue().toString();

						if (attrValue.equalsIgnoreCase("ssid")) {
							int srcId = Integer.parseInt(nNode2.getTextContent());
							newTransition.setSrcStateIdentifier(srcId);
							newTransition.setSrcState(sm.findStateByIdentifier(srcId));
						}
					}
				}
			}

			if (nNode.getNodeName().equalsIgnoreCase("dst")) {
				nList2 = nNode.getChildNodes();
				for (int temp2 = 0; temp2 < nList2.getLength(); temp2++) {
					Node nNode2 = nList2.item(temp2);
					if (nNode2.getNodeName().equalsIgnoreCase("p")) {
						attrName = Utils.getAttribute(nNode2, "Name");
						attrValue = attrName.getNodeValue().toString();

						if (attrValue.equalsIgnoreCase("ssid")) {
							int dstId = Integer.parseInt(nNode2.getTextContent());
							newTransition.setDstStateIdentifier(dstId);
							newTransition.setDstState(sm.findStateByIdentifier(dstId));
						}
					}
				}
			}
		}

		if (newTransition != null) {
			sm.addTransition(newTransition);
		}
	}

	private static void processStateFlowState(Node state, StateMachine sm) {
		Node attrName;
		String attrValue;
		NodeList nList;
		State newState;
		String stateType;

		newState = new State();
		stateType = "";
		// OsateDebug.osateDebug("[FileImport] Parsing state");

		/**
		 * Check the identifier of the state.
		 */
		attrName = Utils.getAttribute(state, "SSID");
		attrValue = attrName.getNodeValue().toString();
		newState.setIdentifier(Integer.parseInt(attrValue));

		// OsateDebug.osateDebug("[FileImport] SSID value="+attrName);

		/**
		 * Process all the nodes.
		 */
		nList = state.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);

			/**
			 * Here, we consider that if the state has a node
			 * called children, these nodes will then contain
			 * a sub state-machine that contains a nested 
			 * state machine. Then, we process this state machine
			 * in the sub-state machine enclosed within the state.
			 */
			if (nNode.getNodeName().equalsIgnoreCase("children")) {
				processStateFlowChild(nNode, newState.getInternalStateMachine());
			}

			if (nNode.getNodeName().equalsIgnoreCase("p")) {
				attrName = Utils.getAttribute(nNode, "Name");
				attrValue = attrName.getNodeValue().toString();

				if (attrValue.equalsIgnoreCase("labelstring")) {
					String label = nNode.getTextContent();
					newState.setName(Utils.filterStateName(label));
					newState.getInternalStateMachine().setName(Utils.filterStateName(label));
					// OsateDebug.osateDebug("[FileImport] Label="+label);

					for (String var : Utils
							.getVariablesFromConditionOrAction(Utils.getStatementsFromStateLabelString(label))) {

						int varType = StateMachine.VARIABLE_TYPE_INTEGER;
						sm.addVariable(var, varType);
					}

					newState.setEntrypoint(Utils.getStatementsFromStateLabelString(label));
				}

				if (attrValue.equalsIgnoreCase("type")) {
					stateType = nNode.getTextContent();
				}

			}
		}

		if ((newState != null) && (!stateType.equalsIgnoreCase("group_state"))) {
			sm.addState(newState);
		}
	}

	private static void processStateFlowMachine(Node machine, Model producedModel) {
		StateMachine sm;
		Node attrName;
		String attrValue;
		NodeList nList;

		sm = new StateMachine();
		attrName = null;

		/**
		 * Check the identifier if the node.
		 */
		attrName = Utils.getAttribute(machine, "id");

		attrValue = attrName.getNodeValue().toString();
		// OsateDebug.osateDebug("[FileImport] id=" + attrValue);
		sm.setIdentifier(Integer.parseInt(attrValue));

		/**
		 * Process all the nodes.
		 */
		nList = machine.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("children")) {
				processStateFlowChild(nNode, sm);
			}
		}

		producedModel.addStateMachine(sm);
	}

}
