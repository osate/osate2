


/*
 * Copyright 2013 Carnegie Mellon University
 * 
 * The AADL/DSM Bridge (org.osate.importer.lattix ) (the �Content� or �Material�) 
 * is based upon work funded and supported by the Department of Defense under 
 * Contract No. FA8721-05-C-0003 with Carnegie Mellon University for the operation 
 * of the Software Engineering Institute, a federally funded research and development 
 * center.

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
 * Carnegie Mellon� is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 * 
 * DM-0000232
 * 
 */

package org.osate.importer.simulink;

import java.io.InputStream;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.model.Component;
import org.osate.importer.model.Connection;
import org.osate.importer.model.Model;
import org.osate.importer.statemachine.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileImport {

	private static String SIMULINK_ENTRYFILE = "simulink/blockdiagram.xml";
	private static Model producedModel;
	
	private static String getTagValue(String sTag, Element eElement)
	{
		NodeList nlList;
		Node nValue;

		try
		{
			nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

			nValue = (Node) nlList.item(0);

			return nValue.getNodeValue();
		}
		catch (NullPointerException npe)
		{
			return null;
		}
	}


	private static Node getAttribute (Node node, String attr)
	{
		return node.getAttributes().getNamedItem(attr);
	}

	private static void processModel (Node model)
	{
		NodeList nList = model.getChildNodes();
		

		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("system"))
			{
				OsateDebug.osateDebug("System passed");
				processSystem (nNode);
			}
		}
	}
	
	private static void processStateFlow (Node sf)
	{
		NodeList nList = sf.getChildNodes();
		

		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("machine"))
			{
				OsateDebug.osateDebug("machine");
				processStateFlowMachine (nNode);
			}
		}
	}
	

	
	public static final int CONNECTION_FIELD_BLOCK_INDEX 			= 1;
	public static final int CONNECTION_FIELD_PORT_DIRECTION 		= 2;
	public static final int CONNECTION_FIELD_PORT_INDEX 			= 3;
	
	public static final int CONNECTION_FIELD_PORT_IN 		= 1;
	public static final int CONNECTION_FIELD_PORT_OUT 		= 2;
	
	private static int getConnectionPointInformation (String connection, int field)
	{
		int idx1;
		int idx2;
		String blockIndex;
		String portDirection;
		String portIndex;
		
		idx1 = connection.indexOf("#");
		idx2 = connection.indexOf(":");
		blockIndex = connection.substring(0, idx1);
		portDirection = connection.substring(idx1+1, idx2);
		portIndex = connection.substring(idx2+1);
		OsateDebug.osateDebug("blockIndex="+ blockIndex);
		OsateDebug.osateDebug("portDirection="+ portDirection);
		OsateDebug.osateDebug("portIndex="+ portIndex);
		
		switch (field)
		{
			case CONNECTION_FIELD_BLOCK_INDEX:
			{
				return Integer.parseInt(blockIndex);
			}

			case CONNECTION_FIELD_PORT_DIRECTION:
			{
				if (portDirection.equalsIgnoreCase("out"))
				{
					return CONNECTION_FIELD_PORT_OUT;
				}
				return CONNECTION_FIELD_PORT_IN;
			}			
			
			case CONNECTION_FIELD_PORT_INDEX:
			{
				return Integer.parseInt(portIndex);
			}
			
			default:
			{
				return 0;
			}
		}
	}

	private static void processStateFlowChild (Node child, StateMachine sm)
	{
		NodeList 		nList;
	
		/**
		 * Process all the nodes.
		 */
		nList = child.getChildNodes();
		
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("state"))
			{
				processStateFlowState(nNode,sm);
			}
			if (nNode.getNodeName().equalsIgnoreCase("chart"))
			{
				processStateFlowChart(nNode,sm);
			}
			if (nNode.getNodeName().equalsIgnoreCase("transition"))
			{
				processStateFlowTransition(nNode,sm);
			}
		}	
	}
	
	private static void processStateFlowChart (Node chart, StateMachine sm)
	{
		NodeList 		nList;
	
		/**
		 * Process all the nodes.
		 */
		nList = chart.getChildNodes();
		
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("children"))
			{
				processStateFlowChild(nNode, sm);
			}
		}	
	}
	
	private static void processStateFlowTransition (Node transition, StateMachine sm)
	{
		NodeList 		nList;
		NodeList		nList2;
		Node			attrName;
		String			attrValue;
		Transition		newTransition;
		
		newTransition = new Transition ();
		
		OsateDebug.osateDebug("[FileImport] Parsing transition");
		
		/**
		 * Check the identifier of the state.
		 */
		attrName = getAttribute(transition, "SSID");
		attrValue = attrName.getNodeValue().toString();
		newTransition.setIdentifier(Integer.parseInt(attrValue));
		OsateDebug.osateDebug("[FileImport] SSID value="+attrName);
		
		
		/**
		 * Process all the nodes.
		 */
		nList = transition.getChildNodes();
		
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("src"))
			{
				nList2 = nNode.getChildNodes();
				for (int temp2 = 0; temp2 < nList2.getLength(); temp2++) 
				{
					Node nNode2 = nList2.item(temp2);
					if (nNode2.getNodeName().equalsIgnoreCase("p"))
					{
						attrName = getAttribute(nNode2, "Name");
						attrValue = attrName.getNodeValue().toString();
						
						if (attrValue.equalsIgnoreCase("ssid"))
						{
							int srcId = Integer.parseInt(nNode2.getTextContent());
							newTransition.setSrcStateIdentifier(srcId);
							newTransition.setSrcState (sm.findStateByIdentifier(srcId));
						}
					}
				}
			}
			
			if (nNode.getNodeName().equalsIgnoreCase("dst"))
			{
				nList2 = nNode.getChildNodes();
				for (int temp2 = 0; temp2 < nList2.getLength(); temp2++) 
				{
					Node nNode2 = nList2.item(temp2);
					if (nNode2.getNodeName().equalsIgnoreCase("p"))
					{
						attrName = getAttribute(nNode2, "Name");
						attrValue = attrName.getNodeValue().toString();
						
						if (attrValue.equalsIgnoreCase("ssid"))
						{
							int dstId = Integer.parseInt(nNode2.getTextContent());
							newTransition.setDstStateIdentifier(dstId);
							newTransition.setDstState (sm.findStateByIdentifier(dstId));
						}
					}
				}
			}
		}	
		
		if (newTransition != null)
		{
			sm.addTransition (newTransition);
		}
	}
	
	private static void processStateFlowState (Node state, StateMachine sm)
	{
		Node			attrName;
		String			attrValue;
		NodeList 		nList;
		State			newState;
		
		newState = new State();
		OsateDebug.osateDebug("[FileImport] Parsing state");
		
		/**
		 * Check the identifier of the state.
		 */
		attrName = getAttribute(state, "SSID");
		attrValue = attrName.getNodeValue().toString();
		newState.setIdentifier(Integer.parseInt(attrValue));
		
		OsateDebug.osateDebug("[FileImport] SSID value="+attrName);
		
		
		/**
		 * Process all the nodes.
		 */
		nList = state.getChildNodes();
		
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("children"))
			{
				processStateFlowChild(nNode, sm);
			}

			if (nNode.getNodeName().equalsIgnoreCase("p"))
			{
				attrName = getAttribute(nNode, "Name");
				attrValue = attrName.getNodeValue().toString();
				
				if (attrValue.equalsIgnoreCase("labelstring"))
				{
					String label = nNode.getTextContent();
					newState.setName(label);
					OsateDebug.osateDebug("[FileImport] Label="+label);
				}
			}
		}
		
		if (newState != null)
		{
			sm.addState(newState);
		}
	}
	
	
	private static void processStateFlowMachine (Node machine)
	{
		StateMachine 	sm;
		Node 			attrName;
		String 			attrValue;
		NodeList 		nList;
		
		
		sm 			=	new StateMachine ();
		attrName 	= 	null;
		
		/**
		 * Check the identifier if the node.
		 */
		attrName = getAttribute(machine, "id");
		
		attrValue = attrName.getNodeValue().toString();
		OsateDebug.osateDebug("[FileImport] id=" + attrValue);
		sm.setIdentifier(Integer.parseInt(attrValue));
		
		/**
		 * Process all the nodes.
		 */
		nList = machine.getChildNodes();
		
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("children"))
			{
				processStateFlowChild(nNode, sm);
			}
		}

		producedModel.addStateMachine(sm);
	}	
	
	
	private static void processSystem (Node system)
	{
		Node attrName = null;
		String direction;
		NodeList nList = system.getChildNodes();
		

		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("block"))
			{
				attrName = getAttribute(nNode, "Name");
				
				if (attrName == null)
				{
					continue;
				}
				String blockName = attrName.getNodeValue().toString();
				OsateDebug.osateDebug("block name="+ blockName);
				
				attrName = getAttribute(nNode, "BlockType");
				
				if (attrName == null)
				{
					continue;
				}
				String blockType = attrName.getNodeValue().toString();
				OsateDebug.osateDebug("block name="+ blockType);
				
				
				attrName = getAttribute(nNode, "SID");
				
				if (attrName == null)
				{
					continue;
				}
				String sidStr = attrName.getNodeValue().toString();
				OsateDebug.osateDebug("sid="+ blockType);
				int sidValue = Integer.parseInt(sidStr);
				Component c = new Component(blockName);
				c.setIdentifier (sidValue);
				c.setType(blockType);
				producedModel.addComponent(c);
			}
		}
		
		
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			String srcString;
			String dstString;
			int srcBlockIndex;
			int dstBlockIndex;
			int srcPortIndex;
			int dstPortIndex;
			
			Node tmpNode;
			
			srcBlockIndex = -1;
			dstBlockIndex = -1;
			
			Node nNode = nList.item(temp);
			if (nNode.getNodeName().equalsIgnoreCase("Line"))
			{
				OsateDebug.osateDebug("Line passed");

				srcString = null;
				dstString = null;
				NodeList children = nNode.getChildNodes();
				for (int temp2 = 0 ; temp2 < children.getLength() ; temp2++)
				{
					tmpNode = children.item(temp2);
					if (tmpNode.getNodeName().equalsIgnoreCase("p"))
					{
						OsateDebug.osateDebug("p passed");

						attrName = getAttribute(tmpNode, "Name");
						
						if (attrName == null)
						{
							continue;
						}
						direction = attrName.getNodeValue().toString();
						OsateDebug.osateDebug("direction="+direction);
						if (direction.equalsIgnoreCase("src"))
						{
							srcString = tmpNode.getTextContent();
							OsateDebug.osateDebug("srcString="+srcString);
							srcBlockIndex = getConnectionPointInformation(srcString, CONNECTION_FIELD_BLOCK_INDEX);

						}
						
						if (direction.equalsIgnoreCase("dst"))
						{
							dstString = tmpNode.getTextContent();
							OsateDebug.osateDebug("dstString="+dstString);
							dstBlockIndex = getConnectionPointInformation(dstString, CONNECTION_FIELD_BLOCK_INDEX);
						}
					}
				}
				
				if ((dstString != null) && (srcString != null))
				{
					OsateDebug.osateDebug("[FileImport] src=" + srcString +"|dst="+dstString);
					Component srcComponent = producedModel.findComponentById(srcBlockIndex);
					Component dstComponent = producedModel.findComponentById(dstBlockIndex);
					
					if ((srcComponent != null) && (dstComponent != null))
					{
						Connection c = new Connection(srcComponent, dstComponent);
						srcComponent.addConnection(c);
						dstComponent.addConnection(c);
						producedModel.addConnection(c);
					}
				}
			}
		}
	}
	
	public static Model loadFile (String inputFile)
	{
		Node nNode;
		Node attrName;
		Node depName;
		Node depStrength;
		NodeList nList;
		String systemName;
		String fileName;
		String depNameString;
		InputStream in;
		ZipFile zipFile;
		int strength;
		
		zipFile = null;
		OsateDebug.osateDebug("try to load" + inputFile);
		
		producedModel = new Model();
		
		try 
		{
			if (inputFile.contains(".slx"))
			{
//				fileName = inputFile.replace(".ldz", ".ldm");
//				if (fileName.contains("\\"))	
//				{
//					int idx = fileName.lastIndexOf('\\');
//					fileName = fileName.substring(idx + 1);
//				}
//				new File(inputFile);
				zipFile = new ZipFile(inputFile);
//				Enumeration<? extends ZipEntry> entries = zipFile.entries();
//				while (entries.hasMoreElements())
//				{
//					ZipEntry ze = entries.nextElement();
//					OsateDebug.osateDebug("entry " + ze);
//				}
//	
				in = zipFile.getInputStream(zipFile.getEntry(SIMULINK_ENTRYFILE));
			}
			else
			{
				OsateDebug.osateDebug("[FileImport] Not a Simulink model");
				return null;
			}
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(in);
			doc.getDocumentElement().normalize();
			
			if (zipFile != null)
			{
				zipFile.close();
			}
			in.close();
			
			
			NodeList modelInformationNodes = doc.getElementsByTagName("ModelInformation");
			for (int s = 0 ; s < modelInformationNodes.getLength() ; s++)
			{
				OsateDebug.osateDebug("ModelInformation passed");

				nNode = modelInformationNodes.item(s);
				NodeList children = nNode.getChildNodes();
				
				for (int t = 0 ; t < children.getLength() ; t++)
				{
					Node tNode = children.item (t);
					if (tNode.getNodeName().equalsIgnoreCase("model"))
					{
						OsateDebug.osateDebug("Model passed");
						processModel (tNode);
					}
				}
			}
			
			for (int s = 0 ; s < modelInformationNodes.getLength() ; s++)
			{
				nNode = modelInformationNodes.item(s);
				NodeList children = nNode.getChildNodes();
				
				for (int t = 0 ; t < children.getLength() ; t++)
				{
					Node tNode = children.item (t);
					if (tNode.getNodeName().equalsIgnoreCase("stateflow"))
					{
						OsateDebug.osateDebug("stateflow");
						processStateFlow (tNode);
					}
				}
			}
			
			for (Component c : producedModel.getComponents())
			{
				OsateDebug.osateDebug("[FileImport] component=" + c);
			}
			
			for (Connection c : producedModel.getConnections())
			{
				OsateDebug.osateDebug("[FileImport] connection=" + c);
			}
			
			for (StateMachine sm : producedModel.getStateMachines())
			{
				OsateDebug.osateDebug("[FileImport] state machine=" + sm);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return producedModel;
	}
	

}
