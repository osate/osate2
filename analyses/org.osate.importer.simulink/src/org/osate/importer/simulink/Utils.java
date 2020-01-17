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

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.util.OsateDebug;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Utils {

	public static final int CONNECTION_FIELD_BLOCK_INDEX = 1;
	public static final int CONNECTION_FIELD_PORT_DIRECTION = 2;
	public static final int CONNECTION_FIELD_PORT_INDEX = 3;

	public static final int CONNECTION_FIELD_PORT_IN = 1;
	public static final int CONNECTION_FIELD_PORT_OUT = 2;
	public static final int CONNECTION_FIELD_INVALID = -1;

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

	public static Node getAttribute(Node node, String attr) {
		return node.getAttributes().getNamedItem(attr);
	}

	public static String getSourceBlock(Node node) {
		NodeList nList = node.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("p")) {
				Node attrName = Utils.getAttribute(nNode, "Name");
//				if (attrName != null)
//				{
//				OsateDebug.osateDebug("name=" + attrName.getNodeValue().toString());
//				}
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

		result = result.replaceAll("int32", " ");
		OsateDebug.osateDebug("Utils", "result=" + result);
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
			result = result.replaceAll("int32", "");
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
		result = result.replaceAll("&&", "and");
		result = result.replaceAll("\\|\\|", "or");
		result = result.replaceAll("\\~", " not ");
		result = result.replaceAll("==", "=");
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

		portDirection = null;
		portIndex = null;

		try {
			idx1 = connection.indexOf("#");
			idx2 = connection.indexOf(":");
//				OsateDebug.osateDebug("Utils", "[getConnectionPointInformation] conn=" + connection);
//				OsateDebug.osateDebug("Utils", "[getConnectionPointInformation] idx1=" + idx1);
//				OsateDebug.osateDebug("Utils", "[getConnectionPointInformation] idx2=" + idx2);

			blockIndex = connection.substring(0, idx1);

			if (idx2 > idx1) {
				portDirection = connection.substring(idx1 + 1, idx2);
				portIndex = connection.substring(idx2 + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
//				OsateDebug.osateDebug("[Utils] getConnectionPointInformation - invalid string: " + connection);
			return 0;
		}

		switch (field) {
		case CONNECTION_FIELD_BLOCK_INDEX: {

			if (blockIndex.contains("::")) {
				blockIndex = blockIndex.substring(blockIndex.lastIndexOf("::") + 2, blockIndex.length());

//						OsateDebug.osateDebug("Utils", "blockIndex=" + blockIndex);
			}
			return Integer.parseInt(blockIndex);
		}

		case CONNECTION_FIELD_PORT_DIRECTION: {
			if (portDirection == null) {
				return CONNECTION_FIELD_INVALID;
			}

			if (portDirection.equalsIgnoreCase("out")) {
				return CONNECTION_FIELD_PORT_OUT;
			} else {
				return CONNECTION_FIELD_PORT_IN;
			}
		}

		case CONNECTION_FIELD_PORT_INDEX: {
			if (portIndex == null) {
				return CONNECTION_FIELD_INVALID;
			}
			return Integer.parseInt(portIndex);
		}

		default: {
			return 0;
		}
		}
	}

	/**
	 * Return the name of the model based on the filename.
	 * The Simulink fileName is like C:\dir1\dir2\model.slx
	 * We then just return the "model" string
	 * @param fileName the filename that contains the model.
	 * @return the name of the model
	 */
	public static String getModelName(String fileName) {
		int idx1;
		int idx2;

		idx1 = fileName.lastIndexOf("\\");
		if (idx1 == -1) {
			idx1 = fileName.lastIndexOf('/');
			if (idx1 == -1) {
				idx1 = 0;
			} else {
				idx1 = idx1 + 1;
			}
		} else {
			idx1 = idx1 + 1;
		}
		idx2 = fileName.lastIndexOf('.');
		return fileName.substring(idx1, idx2);
	}
}
