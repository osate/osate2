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

	public static void processModel (Node model, Model produced, String rootName)
		{
			NodeList nList = model.getChildNodes();
			
	
			for (int temp = 0; temp < nList.getLength(); temp++) 
			{
				Node nNode = nList.item(temp);
				if (nNode.getNodeName().equalsIgnoreCase("system"))
				{
					processSystem (nNode, produced, rootName);
				}
			}
		}

	public static void processSystem (Node system, Model model, String rootName)
		{
			Node attrName = null;
			String direction;
			NodeList nList = system.getChildNodes();
			
	
			for (int temp = 0; temp < nList.getLength(); temp++) 
			{
				Node nNode = nList.item(temp);
				if (nNode.getNodeName().equalsIgnoreCase("block"))
				{
					
					attrName = Utils.getAttribute(nNode, "Name");
					
					if (attrName == null)
					{
						continue;
					}
					
					String blockName = attrName.getNodeValue().toString();
					
					attrName = Utils.getAttribute(nNode, "BlockType");
					
					if (attrName == null)
					{
						continue;
					}
					String blockType = attrName.getNodeValue().toString();
										
					attrName = Utils.getAttribute(nNode, "SID");
					
					if (attrName == null)
					{
						continue;
					}
					String sidStr = attrName.getNodeValue().toString();
					
					if (sidStr.contains(":"))
					{
						sidStr = sidStr.substring(sidStr.lastIndexOf(":")+1);
					}
					
					
					int sidValue = Integer.parseInt(sidStr);
					Component c = new Component(blockName);
					c.setIdentifier (sidValue);
					
					if (blockType.equalsIgnoreCase("inport"))
					{
						c.setType(ComponentType.EXTERNAL_INPORT);
					}
					if (blockType.equalsIgnoreCase("outport"))
					{
						c.setType(ComponentType.EXTERNAL_OUTPORT);
					}
					if (blockType.equalsIgnoreCase("reference"))
					{
						c.setType(ComponentType.BLOCK);
						if (blockName.equalsIgnoreCase(rootName))
						{
							String referenceSource = Utils.getSourceBlock (nNode);
							OsateDebug.osateDebug(referenceSource);
							if (referenceSource != null)
							{
								String[] strs = referenceSource.split("/");
								String sourceFile = strs[0];
								String sourceBlock = strs[1];
//								OsateDebug.osateDebug("file=" + sourceFile);
//								OsateDebug.osateDebug("block=" + sourceBlock);
								c.setType(ComponentType.BLOCK);
								FileImport.loadComponentFromLibrary (c, model, DoImportModel.getWorkingDirectory() + File.separator +  sourceFile + ".slx", sourceBlock);
							}
						}
					}
					if (blockType.equalsIgnoreCase("subsystem"))
					{
						c.setType(ComponentType.BLOCK);
					}
					
					if ((c.getType() != ComponentType.UNKNOWN) && (DoImportModel.filterSystem() == false))
					{
						model.addComponent(c);
					}
					
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
					srcString = null;
					dstString = null;
					NodeList children = nNode.getChildNodes();
					for (int temp2 = 0 ; temp2 < children.getLength() ; temp2++)
					{
						tmpNode = children.item(temp2);
						if (tmpNode.getNodeName().equalsIgnoreCase("p"))
						{
							attrName = Utils.getAttribute(tmpNode, "Name");
							
							if (attrName == null)
							{
								continue;
							}
							direction = attrName.getNodeValue().toString();
	//						OsateDebug.osateDebug("direction="+direction);
							if (direction.equalsIgnoreCase("src"))
							{
								srcString = tmpNode.getTextContent();
	//							OsateDebug.osateDebug("srcString="+srcString);
								addConnection (srcString, dstString, model);
							}
							
							if (direction.equalsIgnoreCase("dst"))
							{
								dstString = tmpNode.getTextContent();
	//							OsateDebug.osateDebug("dstString="+dstString);
								addConnection (srcString, dstString, model);
							}
						}
						if (tmpNode.getNodeName().equalsIgnoreCase("branch"))
						{
							NodeList children4 = tmpNode.getChildNodes();
							for (int temp4 = 0 ; temp4 < children4.getLength() ; temp4++)
							{
								Node tmpNode4 = children4.item(temp4);
								if (tmpNode4.getNodeName().equalsIgnoreCase("p"))
								{
									Node attrName2 = Utils.getAttribute(tmpNode4, "Name");
									
									if (attrName2 == null)
									{
										continue;
									}
									String direction2 = attrName2.getNodeValue().toString();
	//								OsateDebug.osateDebug("direction="+direction);
									if (direction2.equalsIgnoreCase("src"))
									{
										srcString = tmpNode4.getTextContent();
	//									OsateDebug.osateDebug("srcString="+srcString);
										srcBlockIndex = Utils.getConnectionPointInformation(srcString, Utils.CONNECTION_FIELD_BLOCK_INDEX);
										addConnection (srcString, dstString, model);
									}
									
									if (direction2.equalsIgnoreCase("dst"))
									{
										dstString = tmpNode4.getTextContent();
	//									OsateDebug.osateDebug("dstString="+dstString);
										dstBlockIndex = Utils.getConnectionPointInformation(dstString, Utils.CONNECTION_FIELD_BLOCK_INDEX);
										addConnection (srcString, dstString, model);
									}
								}
							}
						}
					}
				}
			}
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
