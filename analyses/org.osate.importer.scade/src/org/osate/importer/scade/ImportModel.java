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

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.model.Component;
import org.osate.importer.model.Component.ComponentType;
import org.osate.importer.model.Component.PortType;
import org.osate.importer.model.Connection;
import org.osate.importer.model.Model;
import org.osate.importer.model.sm.State;
import org.osate.importer.model.sm.StateMachine;
import org.osate.importer.model.sm.Transition;
import org.osate.importer.scade.actions.DoImportModel;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ImportModel {

	public static void process (Node node, Model produced)
	{
		if (node.getNodeName().equalsIgnoreCase("package"))
		{
			Node attrName = null;
			attrName = Utils.getAttribute(node, "name");
			
			if (attrName != null)
			{
				String attrStr = attrName.getNodeValue().toString();
				produced.setPackageName (attrStr);
			}
		}
		
		NodeList nList = node.getChildNodes();
	
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("operator"))
			{
				processOperator (nNode, produced);
			}
			else
			{
				process (nNode, produced);
			}
		}
	}

	public static void processOperator (Node operator, Model model)
	{
		Node attrName = null;
		String direction;
		NodeList nList = operator.getChildNodes();

		attrName = Utils.getAttribute(operator, "name");
		if (attrName == null)
		{
			return;
		}
		String componentName = attrName.getNodeValue().toString();
		Component c = new Component(componentName);
		c.setType(ComponentType.BLOCK);

		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("inputs"))
			{
				processInterfaces (nNode, c, ComponentType.EXTERNAL_INPORT);
			}
			if (nNode.getNodeName().equalsIgnoreCase("outputs"))
			{
				processInterfaces (nNode, c, ComponentType.EXTERNAL_OUTPORT);
			}
			if (nNode.getNodeName().equalsIgnoreCase("data"))
			{
				processOperatorData (operator, nNode, c);
			}
		}
		
		model.addComponent(c);
	}
	
	public static String getCallExpressionOperator (Node tmp)
	{
		Node attrName = null;
		String operatorRefName = null;
		
		NodeList nList = tmp.getChildNodes();


		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("operatorref"))
			{
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null)
				{
					return (attrName.getNodeValue().toString());
				}
			}
			
			if (operatorRefName == null)
			{
				String strtmp = getCallExpressionOperator (nNode);
				if (strtmp != null)
				{
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
	public static void processOperatorData (Node operatorNode, Node currentNode, Component comp)
	{

		NodeList nList = currentNode.getChildNodes();


		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			/**
			 * Here we get a callexpression node. This corresponds
			 * to a call to another block. So, we first create a new
			 * component that corresponds to this block. Then, 
			 * we try to add the call parameters and establish connections.
			 */
			if (nNode.getNodeName().equalsIgnoreCase("callexpression"))
			{
				String operatorRef = getCallExpressionOperator (nNode);
				Component subComponent = new Component(operatorRef);
				subComponent.setType(ComponentType.BLOCK);
				subComponent.setParent(comp);
				comp.addSubsystem(subComponent);
				
				/**
				 * Call parameters for the INPUTS.
				 */
				processCallParameters (Utils.getFirstNode (nNode, "callparameters"), operatorNode, comp, subComponent);
				
				/**
				 * Call parameters for the OUTPUTS.
				 */
				processCallReturns (Utils.getFirstNode (nNode.getParentNode().getParentNode(), "lefts"),operatorNode, comp, subComponent);
			}
			else
			{
				/**
				 * If the current node does not need to be mapped, then, browse the XML
				 * file recursively.
				 */
				processOperatorData (operatorNode, nNode, comp);
			}
		}
	}
	
	/**
	 * Analyze all variables modified by a function call.
	 * @param currentNode      - the XML node that corresponds to the lefts part of the equation
	 * @param operator         - the operator that contains the expression
	 * @param mainComponent    - the component that contains the call
	 * @param calledComponent  - the component that is called
	 */
	public static void processCallReturns (Node currentNode, Node operator, Component mainComponent, Component calledComponent)
	{
		NodeList nList = currentNode.getChildNodes();
		Node attrName = null;

		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("variableref"))
			{
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null)
				{
					String varName = attrName.getNodeValue().toString();
					OsateDebug.osateDebug("[ImportModel/SCADE]Try to resolve " + varName);

					String resolve = resolveVariabletoOutput (varName, operator, calledComponent);
					if (resolve != null)
					{
						OsateDebug.osateDebug("[ImportModel/SCADE]Resolved to  " + resolve);

						Component sc = mainComponent.findSubcomponent (resolve);
						if (sc != null)
						{
							Component ctmp = new Component(sc.getName());
							ctmp.setPortType(ctmp.getPortType());
							ctmp.setType(ComponentType.EXTERNAL_OUTPORT);
							calledComponent.addSubsystem(ctmp);
							Connection conn = new Connection (calledComponent,sc);
							mainComponent.addConnection(conn);
							
						}
						else
						{
							OsateDebug.osateDebug("[ImportModel/SCADE] Did not found the port for " + resolve);
						}
					}
					else
					{
						OsateDebug.osateDebug("[ImportModel/SCADE] Cannot resolve temp var " + varName);
					}
				}
				
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
	public static void processCallParameters (Node currentNode, Node operator, Component mainComponent, Component calledComponent)
	{
		NodeList nList = currentNode.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("idexpression"))
			{
				String name = Utils.getExpressionName (nNode);
				String resolve = resolveVariabletoInput (name, operator, calledComponent);
				if (resolve != null)
				{
					Component sc = mainComponent.findSubcomponent (resolve);
					if (sc != null)
					{
						Connection conn = new Connection (sc, calledComponent);
						
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
	
	
	public static String resolveVariabletoOutput (String varName, Node operator, Component calledComponent)
	{
		NodeList nList = Utils.getFirstNode(operator, "data").getChildNodes();
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("equation"))
			{
				if (equationContains (Utils.getFirstNode(nNode, "right"), varName) && ( ! equationContainsCallExpression (nNode)))
				{
					return findVarRef (Utils.getFirstNode(nNode, "lefts"));
				}
				
			}
		}	
		return null;
		
	}
	
	public static String resolveVariabletoInput (String varName, Node operator, Component calledComponent)
	{
		NodeList nList = Utils.getFirstNode(operator, "data").getChildNodes();
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("equation"))
			{
				if (equationContains (Utils.getFirstNode(nNode, "lefts"), varName))
				{
					return findConstVarRef (Utils.getFirstNode(nNode, "right"));
				}
			}
		}	
		return null;
		
	}
	
	public static String findConstVarRef (Node node)
	{
		Node attrName = null;
		NodeList nList = node.getChildNodes();
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("constvarref"))
			{
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null)
				{
					return attrName.getNodeValue().toString();
				}
			}
			String strtmp = findConstVarRef (nNode);
			
			if (strtmp != null)
			{
				return strtmp;
			}
		}
		return null;
	}
	
	public static String findVarRef (Node node)
	{
		Node attrName = null;
		NodeList nList = node.getChildNodes();
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("variableref"))
			{
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null)
				{
					return attrName.getNodeValue().toString();
				}
			}
			String strtmp = findConstVarRef (nNode);
			
			if (strtmp != null)
			{
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
	public static boolean equationContains (Node node, String var)
	{
		Node attrName = null;
		NodeList nList = node.getChildNodes();
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("variableref"))
			{
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null)
				{
					if (attrName.getNodeValue().toString().equalsIgnoreCase(var))
					{
						return true;
					}
				}
			}
			if (nNode.getNodeName().equalsIgnoreCase("constvarref"))
			{
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null)
				{
					if (attrName.getNodeValue().toString().equalsIgnoreCase(var))
					{
						return true;
					}
				}
			}
			
			boolean ret =  equationContains (nNode,var);
			if (ret == true)
			{
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
	public static boolean equationContainsCallExpression (Node node)
	{
		Node attrName = null;
		NodeList nList = node.getChildNodes();
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("callexpression"))
			{
				return true;
			}
			boolean ret =  equationContainsCallExpression (nNode);
			if (ret == true)
			{
				return true;
			}
		}	
		return false;
	}


	
	public static void processInterfaces (Node inputs, Component comp, ComponentType ct)
	{
		Node attrName = null;
		String direction;
		NodeList nList = inputs.getChildNodes();


		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("variable"))
			{
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName == null)
				{
					return;
				}
				
				String componentName = attrName.getNodeValue().toString();
				Component c = new Component(componentName);
				c.setPortType(getVariableType (nNode));
				c.setType(ct);
				comp.addSubsystem(c);
			}
		}
	}
	
	public static PortType getVariableType (Node node)
	{
		Node attrName = null;
		String direction;
		NodeList nList = node.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("TypeRef"))
			{
				attrName = Utils.getAttribute(nNode, "name");
				if (attrName != null)
				{
					if (attrName.getNodeValue().toString().equalsIgnoreCase("bool"))
					{
						return PortType.BOOL;
					}
				}
			}
			
			PortType ptret = getVariableType (nNode);
			if (ptret != PortType.UNKNOWN)
			{
				return ptret;
			}
		}
		return PortType.UNKNOWN;
	}

	private static boolean addConnection (String srcString, String dstString, Model model)
	{
		if ((dstString != null) && (srcString != null))
		{
			int srcBlockIndex = Utils.getConnectionPointInformation(srcString, Utils.CONNECTION_FIELD_BLOCK_INDEX);
			int dstBlockIndex = Utils.getConnectionPointInformation(dstString, Utils.CONNECTION_FIELD_BLOCK_INDEX);
			
			OsateDebug.osateDebug("[FileImport] connection src=" + srcString +"|dst="+dstString);
			Component srcComponent = model.findComponentById(srcBlockIndex);
			Component dstComponent = model.findComponentById(dstBlockIndex);
			
			if ((srcComponent != null) && (dstComponent != null))
			{
				Connection c = new Connection(srcComponent, dstComponent);
				srcComponent.addConnection(c);
				dstComponent.addConnection(c);
				model.addConnection(c);
				return true;
			}
		}
		return false;
	}



}
