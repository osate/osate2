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

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.model.Component.PortType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Utils {

	public static final int CONNECTION_FIELD_BLOCK_INDEX = 1;
	public static final int CONNECTION_FIELD_PORT_DIRECTION = 2;
	public static final int CONNECTION_FIELD_PORT_INDEX = 3;

	public static final int CONNECTION_FIELD_PORT_IN = 1;
	public static final int CONNECTION_FIELD_PORT_OUT = 2;

	/**
	 * Get all the referenced variables from a condition node.
	 * @param condition - the XML node that references the condition in the SCADE XML file.
	 * @return          - a list of variable names referenced in the condition.
	 */
	public static List<String> getAllReferencedVar(Node condition) {
		List<String> vars = new ArrayList<String>();
		List<Node> nodes = new ArrayList<Node>();

		getAllNodes(nodes, condition, "constvarref");

		for (Node n : nodes) {
			vars.add(Utils.getNodeName(n));
		}

		return vars;
	}

	/**
	 * Map the <condition/> XML node into a string that can
	 * be used with the behavior annex
	 * 
	 * @param condition - the XML node that contains the condition in the SCADE model
	 * @return          - a string representing the condition in the behavior annex
	 */
	public static String mapConditionToString(Node condition) {
		Node operand = getFirstNode(condition, "binaryop");
		if (operand == null) {
			Node varref = getFirstNodeRec(condition, "constvarref");
			if (varref != null) {
				return getNodeName(varref);
			}
		} else {
			String operandString = getNodeAttribute(operand, "operator");
			List<Node> varrefs = new ArrayList<Node>();
			getAllNodes(varrefs, condition, "constvarref");
			if (varrefs.size() > 1) {
				return getNodeName(varrefs.get(0)) + operandString + getNodeName(varrefs.get(1));
			}
		}
		return "unknown_condition";
	}

	/**
	 * Get all sub nodes that have a particular names and add them
	 * in a list.
	 * @param list - The list that will contain the result
	 * @param n    - the top node that is used to browse the XML tree
	 * @param name - the name of the node we are looking for.
	 */
	public static void getAllNodes(List<Node> list, Node n, String name) {
		NodeList nList = n.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase(name)) {
				list.add(nNode);
			}
			getAllNodes(list, nNode, name);
		}
	}

	public static String getTagValue(String sTag, Element eElement) {
		NodeList nlList;
		Node nValue;

		try {
			nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

			nValue = (Node) nlList.item(0);

			return nValue.getNodeValue();
		} catch (NullPointerException npe) {
			return null;
		}
	}

	/**
	 * Get the value of a specific attribute on an XML node
	 * @param node  - the XML node that contains the attribute.
	 * @param attr  - the name of the attribute
	 * @return      - a node containing the attribute.
	 */
	public static Node getAttribute(Node node, String attr) {
		return node.getAttributes().getNamedItem(attr);
	}

	public static String getSourceBlock(Node node) {
		NodeList nList = node.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("p")) {
				Node attrName = Utils.getAttribute(nNode, "Name");
				if (attrName != null) {
					OsateDebug.osateDebug("name=" + attrName.getNodeValue().toString());
				}
				if ((attrName != null) && (attrName.getNodeValue().toString().equalsIgnoreCase("sourceblock"))) {
					return nNode.getTextContent();
				}
			}
		}
		return null;
	}

	public static String getActionFromLabel(String label) {
		String result = label;
		if (result.contains("{") && result.contains("}")) {
			result = result.substring(result.indexOf('{') + 1, result.indexOf('}'));
		} else {
			return "";
		}

		if (result.contains(".")) {
			result = result.substring(result.indexOf('.') + 1, result.length());
		}

		if (!(result.contains("="))) {
			result = result + " := true";
		}

		return result;
	}

	/**
	 * In Simulink, after the state name, there is the string
	 * "entry:" following by statement to execute when we switch
	 * to this state.
	 */
	public static String getStatementsFromStateLabelString(String label) {
		String result = label.replace('\n', ' ');
		if (result.contains("entry:")) {
			result = result.substring(result.indexOf("entry:") + 6);
			return result;
		}
		return null;
	}

	/*
	 * try to extract the part of the label that is only related
	 * to a condition so that we can import it into an AADL model.
	 */
	public static String getConditionFromLabel(String label) {
		String result = label;
		if (result.contains("[") && result.contains("]")) {
			result = result.substring(result.indexOf('[') + 1, result.indexOf(']'));
		}
		return result;
	}

	/*
	 * We consider that a condition is a simple condition
	 * if the label is a pure boolean/signal and does not
	 * have a complex expression. In simulink, this is
	 * done with a condition that has no bracket.
	 */
	public static boolean isSimpleConditionLabel(String label) {
		if (label.contains("[") && label.contains("]")) {
			return false;
		}
		return true;
	}

	/*
	 * TODO: should do the same as for the condition but for action.
	 */
	public static boolean isSimpleActionLabel(String label) {
		return true;
	}

	/*
	 * Get a list of all variables referenced/contained in a condition
	 * or an action (block realized after a condition. For now, we assume
	 * that variables are separated by spaces.
	 */
	public static List<String> getVariablesFromConditionOrAction(String label) {
		List<String> result = new ArrayList<String>();

		if (label == null) {
			return result;
		}

		String[] tmp = label.split(" ");
		for (String s : tmp) {
			if (s.equalsIgnoreCase("true")) {
				continue;
			}

			if (s.equalsIgnoreCase("false")) {
				continue;
			}

			if (s.matches("[a-zA-Z0-9_]+")) {
				result.add(s);
			}
			if (s.contains(".")) {
				result.add(s.substring(s.indexOf("." + 1)));
			}

		}
		return result;
	}

	public static List<String> getVariablesFromTransitionLabel(String label) {
		String condition;
		String action;
		List<String> result = new ArrayList<String>();

		condition = getConditionFromLabel(label);
		action = getActionFromLabel(label);
		result.addAll(getVariablesFromConditionOrAction(condition));
		result.addAll(getVariablesFromConditionOrAction(action));

		return result;
	}

	/**
	 * Find the mapping type for a SCADE data.
	 * @param node - the XML node that contain the variable definition
	 * @return the appropriate PortType value or PortType.UNKNOWN if the
	 *         type cannot be found
	 */
	public static PortType getVariableType(Node node) {
		Node attrName = null;
		NodeList nList = node.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("TypeRef")) {
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null) {
					if (attrName.getNodeValue().toString().equalsIgnoreCase("bool")) {
						return PortType.BOOL;
					}
				}
			}

			PortType ptret = getVariableType(nNode);
			if (ptret != PortType.UNKNOWN) {
				return ptret;
			}
		}
		return PortType.UNKNOWN;
	}

	public static Node getFirstNode(Node node, String name) {
		NodeList nList = node.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase(name)) {
				return nNode;
			}
		}
		return null;
	}

	public static Node getFirstNodeRec(Node node, String name) {
		NodeList nList = node.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase(name)) {
				return nNode;
			}
			Node ntmp = getFirstNodeRec(nNode, name);
			if (ntmp != null) {
				return ntmp;
			}
		}
		return null;
	}

	public static String getExpressionName(Node node) {
		NodeList nList = node.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("constvarref")) {
				Node attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null) {
					return (attrName.getNodeValue().toString());
				}
			}

			String strtmp = getExpressionName(nNode);
			if (strtmp != null) {
				return strtmp;
			}
		}
		return null;
	}

	/**
	 * A state name is also associated with its entrypoint and
	 * other information/statement. This functions
	 * aims at extracting the name of the state from the label
	 * that may contain many other information.
	 */
	public static String filterStateName(String s) {
		String label = s;
		if (label.indexOf('\n') != -1) {
			label = label.substring(0, label.indexOf('\n')).replaceAll("entry", "");
		}

		if (label.indexOf(':') != -1) {
			label = label.substring(0, label.indexOf(':')).replaceAll("entry", "");
		}
		return label;
	}

	/**
	 * return the name attribute for a node
	 * @param smNode - the XML node that contains the node with the name attribute
	 * @return       - the name attribute as a string
	 */
	public static String getNodeName(Node node) {
		return getNodeAttribute(node, "name");
	}

	/**
	 * return the string value for an XML attribute on a node
	 * @param node - the XML node
	 * @param attr - the attribute on the node
	 * @return     - the value of the attribute, null if undefined
	 */
	public static String getNodeAttribute(Node node, String attr) {
		Node attrName = null;

		attrName = Utils.getAttribute(node, attr);
		if (attrName != null) {
			return (attrName.getNodeValue().toString());
		}
		return null;
	}

	/*
	 * A connection point contains several informations about the port, either
	 * the index/identifier (id) of the block, the port direction (in or out)
	 * and the index of the connected port. This function parses the connection
	 * string label and extract the appropriate information according
	 * to the value of the field argument:
	 * - CONNECTION_FIELD_BLOCK_INDEX: retrieves the block index
	 * of the connected component.
	 * - CONNECTION_FIELD_PORT_DIRECTION: direction of the port (in
	 * or out)
	 * - CONNECTION_FIELD_PORT_INDEX: index of the port within the connected
	 * component.
	 */
	public static int getConnectionPointInformation(String connection, int field) {
		int idx1;
		int idx2;
		String blockIndex;
		String portDirection;
		String portIndex;

		try {
			idx1 = connection.indexOf("#");
			idx2 = connection.indexOf(":");
//				OsateDebug.osateDebug("conn=" + connection);
//				OsateDebug.osateDebug("idx1=" + idx1);
//				OsateDebug.osateDebug("idx2=" + idx2);
			blockIndex = connection.substring(0, idx1);
			portDirection = connection.substring(idx1 + 1, idx2);
			portIndex = connection.substring(idx2 + 1);
		} catch (Exception e) {
//				OsateDebug.osateDebug("[Utils] invalid string");
			return 0;
		}
		switch (field) {
		case CONNECTION_FIELD_BLOCK_INDEX: {
			return Integer.parseInt(blockIndex);
		}

		case CONNECTION_FIELD_PORT_DIRECTION: {
			if (portDirection.equalsIgnoreCase("out")) {
				return CONNECTION_FIELD_PORT_OUT;
			}
			return CONNECTION_FIELD_PORT_IN;
		}

		case CONNECTION_FIELD_PORT_INDEX: {
			return Integer.parseInt(portIndex);
		}

		default: {
			return 0;
		}
		}
	}

	public static String getModelName(String fileName) {
		String name;
		int idx1;
		int idx2;

		idx1 = fileName.lastIndexOf("\\") + 1;

		if (idx1 == 0) {
			idx1 = fileName.lastIndexOf('/');
		}

		if (idx1 == -1) {
			idx1 = 0;
		} else {
			idx1 = idx1 + 1;
		}

		idx2 = fileName.lastIndexOf(".");

		return fileName.substring(idx1, idx2);
	}
}
