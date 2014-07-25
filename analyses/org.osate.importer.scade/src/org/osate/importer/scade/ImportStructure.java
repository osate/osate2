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

import org.osate.importer.model.Component;
import org.osate.importer.model.Component.ComponentType;
import org.osate.importer.model.Component.PortType;
import org.osate.importer.model.Connection;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ImportStructure {

	/**
	 * Analyze all variables modified by a function call.
	 * @param currentNode      - the XML node that corresponds to the lefts part of the equation
	 * @param operator         - the XML node of the main operator
	 * @param mainComponent    - the component that contains the call
	 * @param calledComponent  - the component that is called
	 */
	public static void processCallReturns(Node currentNode, Node operator, Component mainComponent,
			Component calledComponent) {
		NodeList nList;
		Node attrName;

		if (currentNode == null) {
			return;
		}

		nList = currentNode.getChildNodes();
		attrName = null;

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("variableref")) {
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null) {
					/**
					 * varName here is the name of the internal SCADE variable
					 * which is like _l2, _v2, etc.
					 */
					String varName = attrName.getNodeValue().toString();
//					OsateDebug.osateDebug("[ImportModel/SCADE]Try to resolve " + varName);

					/**
					 * Here, we try to see what is the port related to the output variable.
					 * With that information, we can then make a connection. The resolve
					 * pass transforms the internal SCADE notation into the internal/external
					 * ports with human-required names.
					 */
					String resolve = resolveVariabletoOutput(varName, operator, calledComponent);
					if (resolve != null) {
//						OsateDebug.osateDebug("[ImportModel/SCADE]Resolved to  " + resolve);

						Component sc = mainComponent.findSubcomponent(resolve);
						if (sc != null) {
							/**
							 * If we find a variable name, then, we add
							 * an external output to the component and add
							 * a connection.
							 */
							Component ctmp = new Component(sc.getName());
							ctmp.setPortType(ctmp.getPortType());
							ctmp.setType(ComponentType.EXTERNAL_OUTPORT);
							calledComponent.addSubsystem(ctmp);
							Connection conn = new Connection(calledComponent, sc);
							mainComponent.addConnection(conn);

						} else {
							/**
							 * If we do not find a corresponding port, we are
							 * trying to see if the output variable
							 * is connecting to the input of another block. We then
							 * try to find all the components called that may use this variable.
							 */
//							OsateDebug.osateDebug("[ImportModel/SCADE] Did not found the port for " + resolve);

							/**
							 * We use 4 times parent because the data nodes is located 4 levels
							 * up from the operator node.
							 */
							Node dataNode = operator.getParentNode().getParentNode().getParentNode().getParentNode();

							/**
							 * Here, we retrieved all the components that use this variable.
							 */
							List<Component> calledComponents = new ArrayList<Component>();
							getComponentsUsingVariable(dataNode, mainComponent, calledComponents, varName);
							for (Component c : calledComponents) {
								/**
								 * Then, introduce a connection between subcomponents.
								 * We add external ports to these components then.
								 */
//								OsateDebug.osateDebug("[ImportModel/SCADE] internal connection to " + c);
//								Connection conn = new Connection (calledComponent,c);
//								mainComponent.addConnection(conn);
//								OsateDebug.osateDebug("[ImportModel/SCADE] connect from " + calledComponent.getName() + " to " + c.getName() + " in " + mainComponent.getName());

								Component ctmp = new Component(varName);
								ctmp.setPortType(ctmp.getPortType());
								ctmp.setType(ComponentType.EXTERNAL_OUTPORT);
								ctmp.setParent(calledComponent);
								calledComponent.addSubsystem(ctmp);

								Component ctmp2 = new Component(varName);
								ctmp2.setPortType(ctmp.getPortType());
								ctmp2.setType(ComponentType.EXTERNAL_INPORT);
								ctmp2.setParent(c);
								c.addSubsystem(ctmp2);

								Connection conn = new Connection(ctmp, ctmp2);
								mainComponent.addConnection(conn);

							}
						}
					}
//					else
//					{
//						OsateDebug.osateDebug("[ImportModel/SCADE] Cannot resolve temp var " + varName);
//					}
				}

			}
		}
	}

	/**
	 * Get the list of all components that use a given variable
	 * @param  - varName the name of the input variable
	 * @return - a list of component that use this variable name
	 */
	public static void getComponentsUsingVariable(Node currentNode, Component mainComponent,
			List<Component> components, String varName) {
		NodeList nList = currentNode.getChildNodes();
		Node attrName = null;
		String foundName;

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("ConstVarRef")) {
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null) {
					foundName = attrName.getNodeValue().toString().toLowerCase();

					if (foundName.equalsIgnoreCase(varName)) {
						Node tmpNode = nNode.getParentNode().getParentNode().getParentNode().getParentNode();
						if (tmpNode.getNodeName().equalsIgnoreCase("callexpression")) {
							String operatorStr = ImportModel.getCallExpressionOperator(tmpNode);
							Component ctmp = mainComponent.getSubEntity(operatorStr);
							if (ctmp == null) {
//								OsateDebug.osateDebug("[ImportModel] getComponentsUsingVariable() ctmp is null, creating component " + operatorStr);

								ctmp = new Component(operatorStr);
								ctmp.setType(ComponentType.BLOCK);
								ctmp.setParent(mainComponent);
								mainComponent.addSubsystem(ctmp);
							}
							components.add(ctmp);
							// OsateDebug.osateDebug("[ImportModel] Found operator " + operatorStr);
						}
					}
				}
			} else {
				getComponentsUsingVariable(nNode, mainComponent, components, varName);
			}
		}
	}

	/**
	 * Process the call parameters. This is the variables passed to the called
	 * block.
	 * @param currentNode     - the current node that contains all parameters
	 * @param operator        - the current operator that initiate the call 
	 * @param mainComponent   - the main component that contain the component added
	 * @param calledComponent - the component that is called
	 */
	public static void processCallParameters(Node currentNode, Node operator, Component mainComponent,
			Component calledComponent) {

		NodeList nList;

		if (currentNode == null) {
			return;
		}

		nList = currentNode.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("idexpression")) {
				String name = Utils.getExpressionName(nNode);
				String resolve = resolveVariabletoInput(name, operator, calledComponent);
				if (resolve != null) {
					Component sc = mainComponent.findSubcomponent(resolve);
					if (sc != null) {
						Connection conn = new Connection(sc, calledComponent);

						Component ctmp = new Component(sc.getName());
						ctmp.setPortType(ctmp.getPortType());
						ctmp.setType(ComponentType.EXTERNAL_INPORT);
						calledComponent.addSubsystem(ctmp);

						mainComponent.addConnection(conn);
					}
				}
			}
		}
	}

	/**
	 * Find the human-readable name of a variable for an internal
	 * local SCADE variable. This function returns the human-readable
	 * name in the SCADE model from the name of the internal variable
	 * name. It will retrieve the name of the port according
	 * to the name of the local variable. 
	 * @param varName         - name of the local variable (such as _v2 or _l2, etc.)
	 * @param operator        - the operator that contains the call containing
	 * @param calledComponent - the component that was called
	 * @return
	 */
	public static String resolveVariabletoOutput(String varName, Node operator, Component calledComponent) {
		NodeList nList = Utils.getFirstNode(operator, "data").getChildNodes();
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("equation")) {
				if (equationContains(Utils.getFirstNode(nNode, "right"), varName)
						&& (!equationContainsCallExpression(nNode))) {
					return findVarRef(Utils.getFirstNode(nNode, "lefts"));
				}

			}
		}
		return null;

	}

	/**
	 * Find the human-readable name of a variable for an internal
	 * local SCADE variable. This function returns the human-readable
	 * name in the SCADE model from the name of the internal variable
	 * name. It will retrieve the name of the port according
	 * to the name of the local variable. 
	 * @param varName         - name of the local variable (such as _v2 or _l2, etc.)
	 * @param operator        - the operator that contains the call containing
	 * @param calledComponent - the component that was called
	 * @return
	 */
	public static String resolveVariabletoInput(String varName, Node operator, Component calledComponent) {
		NodeList nList = Utils.getFirstNode(operator, "data").getChildNodes();
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("equation")) {
				if (equationContains(Utils.getFirstNode(nNode, "lefts"), varName)) {
					return findConstVarRef(Utils.getFirstNode(nNode, "right"));
				}
			}
		}
		return null;

	}

	/**
	 * Try to find a node with the name constvarref and 
	 * return the value of the name attribute.
	 * @param node - The XML node with the constvarref name
	 * @return     - Value of the name attribute.
	 */
	public static String findConstVarRef(Node node) {
		Node attrName = null;
		NodeList nList = node.getChildNodes();
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("constvarref")) {
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null) {
					return attrName.getNodeValue().toString();
				}
			}
			String strtmp = findConstVarRef(nNode);

			if (strtmp != null) {
				return strtmp;
			}
		}
		return null;
	}

	/**
	 * Try to find a node with the name varref and 
	 * return the value of the name attribute.
	 * @param node - The XML node with the varref name
	 * @return     - Value of the name attribute.
	 */
	public static String findVarRef(Node node) {
		Node attrName = null;
		NodeList nList = node.getChildNodes();
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("variableref")) {
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null) {
					return attrName.getNodeValue().toString();
				}
			}
			String strtmp = findVarRef(nNode);

			if (strtmp != null) {
				return strtmp;
			}
		}
		return null;
	}

	/**
	 * returns true or false depending if an equation contains
	 * a certain variable.
	 * @param node  - the node that contains the equation
	 * @param var   - the name of the variable we are looking for.
	 * @return true if the equation contains a variable with such a name
	 */
	public static boolean equationContains(Node node, String var) {
		Node attrName;
		NodeList nList;

		if (node == null) {
			return false;
		}

		attrName = null;
		nList = node.getChildNodes();
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("variableref")) {
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null) {
					if (attrName.getNodeValue().toString().equalsIgnoreCase(var)) {
						return true;
					}
				}
			}
			if (nNode.getNodeName().equalsIgnoreCase("constvarref")) {
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null) {
					if (attrName.getNodeValue().toString().equalsIgnoreCase(var)) {
						return true;
					}
				}
			}

			boolean ret = equationContains(nNode, var);
			if (ret == true) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return true or false - if an equation contains a call expression
	 * @param node  - the node that contain the equation XML node.
	 * @return true if the equation contains a call expression
	 */
	public static boolean equationContainsCallExpression(Node node) {
		NodeList nList = node.getChildNodes();
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("callexpression")) {
				return true;
			}
			boolean ret = equationContainsCallExpression(nNode);
			if (ret == true) {
				return true;
			}
		}
		return false;
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

}
