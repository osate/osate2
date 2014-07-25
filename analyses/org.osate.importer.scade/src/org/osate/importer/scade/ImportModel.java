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
import org.osate.importer.model.Component.ComponentType;
import org.osate.importer.model.Model;
import org.osate.importer.model.sm.StateMachine;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ImportModel {

	/**
	 * Process all the interfaces (inputs/outputs) of the operator
	 * @param ifs  - the inputs XML node. The subnodes 
	 * contain then the different inputs/outputs
	 * @param comp - the components where we can add the interfaces
	 * @param ct - the type of the component
	 */
	public static void processInterfaces(Node ifs, Component comp, ComponentType ct) {
		Node attrName = null;
		NodeList nList = ifs.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("variable")) {
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName == null) {
					return;
				}

				String componentName = attrName.getNodeValue().toString();
				Component c = new Component(componentName);
				c.setPortType(Utils.getVariableType(nNode));
				c.setType(ct);
				comp.addSubsystem(c);
			}
		}
	}

	/**
	 * Main entry method to parse the SCADE model.
	 * @param node		 - the main XML node. Is currently the top node.
	 * @param produced   - The model that will be populated when parsing the SCADE document.
	 */
	public static void process(Node node, Model produced) {
		if (node.getNodeName().equalsIgnoreCase("package")) {
			Node attrName = null;
			attrName = Utils.getAttribute(node, "name");

			if (attrName != null) {
				String attrStr = attrName.getNodeValue().toString();
				produced.setPackageName(attrStr);
			}
		}

		if (node.getNodeName().equalsIgnoreCase("operator")) {
			Node attrName = null;
			attrName = Utils.getAttribute(node, "name");

			if (attrName != null) {
				String attrStr = attrName.getNodeValue().toString();
				if (produced.getPackageName().equals(Model.DEFAULT_NAME)) {
					produced.setPackageName(attrStr);
				}
			}
			processOperator(node, produced);
		}

		NodeList nList = node.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			process(nList.item(temp), produced);
		}
	}

	/**
	 * Process the operator XML mode.
	 * @param operator - XML node with the type operator
	 * @param model    - the model that is being populated.
	 */
	public static void processOperator(Node operator, Model model) {
		Node attrName = null;
		NodeList nList = operator.getChildNodes();

		attrName = Utils.getAttribute(operator, "name");
		if (attrName == null) {
			return;
		}
		String componentName = attrName.getNodeValue().toString();
		Component c = new Component(componentName);
		c.setType(ComponentType.BLOCK);

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("inputs")) {
				processInterfaces(nNode, c, ComponentType.EXTERNAL_INPORT);
			}
			if (nNode.getNodeName().equalsIgnoreCase("outputs")) {
				processInterfaces(nNode, c, ComponentType.EXTERNAL_OUTPORT);
			}
			if (nNode.getNodeName().equalsIgnoreCase("data")) {
				processOperatorData(operator, nNode, c, model);
			}
		}

		model.addComponent(c);
	}

	/**
	 * Get the name of the operator being called by the SCADE model.
	 * 
	 * @param tmp - XML node with the type callexpression
	 * @return    - name of the operator
	 */
	public static String getCallExpressionOperator(Node tmp) {
		Node attrName = null;
		String operatorRefName = null;

		NodeList nList = tmp.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("operatorref")) {
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null) {
					return (attrName.getNodeValue().toString());
				}
			}

			if (operatorRefName == null) {
				String strtmp = getCallExpressionOperator(nNode);
				if (strtmp != null) {
					return strtmp;
				}
			}
		}
		return null;
	}

	/**
	 * Process the <data/> node of the operator node.
	 * The data nodes contains local variable, call expression, etc.
	 * This function is used to process the data and generate appropriate artifacts.
	 * @param operatorNode - XML node that contains the operator
	 * @param currentNode  - current processing node. In fact, we browse recursively
	 *                       the XML tree in order to find nodes we can parse
	 * @param comp         - the component that contains the operator.
	 */
	public static void processOperatorData(Node operatorNode, Node currentNode, Component comp, Model model) {

		NodeList nList = currentNode.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			/**
			 * Here we get a callexpression node. This corresponds
			 * to a call to another block. So, we first create a new
			 * component that corresponds to this block. Then, 
			 * we try to add the call parameters and establish connections.
			 */
			if (nNode.getNodeName().equalsIgnoreCase("callexpression")) {
				String operatorRef = getCallExpressionOperator(nNode);

				Component subComponent = comp.getSubEntity(operatorRef);

				if (subComponent == null) {
//					OsateDebug.osateDebug("[ImportModel] processOperatorData() subComponent is null, creating component " + operatorRef);

					subComponent = new Component(operatorRef);
					subComponent.setType(ComponentType.BLOCK);
					subComponent.setParent(comp);
					comp.addSubsystem(subComponent);
				}

				/**
				 * Call parameters for the INPUTS.
				 */
				ImportStructure.processCallParameters(Utils.getFirstNode(nNode, "callparameters"), operatorNode, comp,
						subComponent);

				/**
				 * Call parameters for the OUTPUTS.
				 */
				ImportStructure.processCallReturns(Utils.getFirstNode(nNode.getParentNode().getParentNode(), "lefts"),
						operatorNode, comp, subComponent);
			} else if (nNode.getNodeName().equalsIgnoreCase("statemachine")) {
				/**
				 * Here, we have a state machine at the root operator.
				 */

				StateMachine stateMachine = new StateMachine();
				ImportStateMachine.processStateMachine(nNode, stateMachine, comp);
				comp.addStateMachine(stateMachine);
				model.addStateMachine(stateMachine);
			} else {
				/**
				 * If the current node does not need to be mapped, then, browse the XML
				 * file recursively.
				 */
				processOperatorData(operatorNode, nNode, comp, model);
			}
		}
	}
}