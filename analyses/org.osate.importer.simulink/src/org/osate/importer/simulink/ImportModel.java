package org.osate.importer.simulink;

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
import org.osate.importer.simulink.actions.DoImportModel;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ImportModel {

//	public static void processModel (Node model, Model produced, String rootName)
//	{
//		NodeList nList = model.getChildNodes();
//
//
//		for (int temp = 0; temp < nList.getLength(); temp++) 
//		{
//			Node nNode = nList.item(temp);
//			if (nNode.getNodeName().equalsIgnoreCase("system"))
//			{
//				processNode (nNode, produced, null, rootName);
//			}
//		}
//	}

	public static void processNode (Node node, Model model, Component currentComponent, String rootName)
	{
		Node 			attrName;
		String 			blockName;
		String 			direction;
		NodeList 		nList;
		Node 			nNode;
		String 			sidStr;
		Component 		newComponent;
		String 			blockType;
		int 			sidValue;
		Node 			tmpNode;

		attrName 		= null;
		tmpNode  		= null;
		sidValue 		= 0;
		blockType 		= null;
		newComponent 	= null;
		sidStr 			= null;
		nNode 			= null;
		nList 			= null;
		direction 		= null;
		blockName 		= null;

		nList = node.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
			nNode = nList.item(temp);
			
			/**
			 * If we are in a system we browse recursively the xml sub items.
			 */
			if (nNode.getNodeName().equalsIgnoreCase("system"))
			{
				processNode(nNode, model, currentComponent, rootName);
			}
			
			if (nNode.getNodeName().equalsIgnoreCase("block"))
			{

				/**
				 * 
				 * Get the name of the block
				 */
				attrName = Utils.getAttribute(nNode, "Name");

				if (attrName == null)
				{
					continue;
				}

				blockName = attrName.getNodeValue().toString();


				/**
				 * Get its type - means if this is a port, a subsystem, etc.
				 */
				attrName = Utils.getAttribute(nNode, "BlockType");

				if (attrName == null)
				{
					continue;
				}
				blockType = attrName.getNodeValue().toString();

				attrName = Utils.getAttribute(nNode, "SID");

				if (attrName == null)
				{
					continue;
				}
				sidStr = attrName.getNodeValue().toString();

				if (sidStr.contains(":"))
				{
					sidStr = sidStr.substring(sidStr.lastIndexOf(":")+1);
				}


				sidValue = Integer.parseInt(sidStr);
				
				/**
				 * Create a new component, and then, define
				 * its type.
				 */
				
				newComponent = new Component(blockName);
				
				OsateDebug.osateDebug("ImportModel", "Create a new component with name " + blockName);
				
				newComponent.setIdentifier (sidValue);

				if (blockType.equalsIgnoreCase("inport"))
				{
					newComponent.setType(ComponentType.EXTERNAL_INPORT);
					if (currentComponent != null)
					{
						OsateDebug.osateDebug("ImportModel", "Add the component as an inport of " + currentComponent.getName());
						currentComponent.addSubsystem(newComponent);
						newComponent.setParent(currentComponent);
					}
				}
				
				
				if (blockType.equalsIgnoreCase("outport"))
				{
					newComponent.setType(ComponentType.EXTERNAL_OUTPORT);
					if (currentComponent != null)
					{
						OsateDebug.osateDebug("ImportModel", "Add the component as an outport of " + currentComponent.getName());
						currentComponent.addSubsystem(newComponent);
						newComponent.setParent(currentComponent);
					}
				}
				
				
				if (blockType.equalsIgnoreCase("reference"))
				{
					newComponent.setType(ComponentType.BLOCK);
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
							newComponent.setType(ComponentType.BLOCK);
							FileImport.loadComponentFromLibrary (newComponent, model, DoImportModel.getWorkingDirectory() + File.separator +  sourceFile + ".slx", sourceBlock);
						}
					}
				}
				if (blockType.equalsIgnoreCase("subsystem"))
				{
					newComponent.setType(ComponentType.BLOCK);
					
					if (currentComponent != null)
					{
						OsateDebug.osateDebug("ImportModel", "Add the component as a sub-component of " + currentComponent.getName());
						currentComponent.addSubsystem(newComponent);
						newComponent.setParent(currentComponent);
					}
					
					/**
					 * Try to find recursively new systems.
					 */
					processNode (nNode, model, newComponent, rootName);
				}

				/**
				 * Finally, we add the component to the model.
				 */
				if ((newComponent.getType() != ComponentType.UNKNOWN) && (DoImportModel.filterSystem() == false))
				{
					/**
					 * Check if the component has already been added.
					 */
					if (! model.containsComponent (blockName))
					{
						model.addComponent(newComponent);
					}
					
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



			srcBlockIndex = -1;
			dstBlockIndex = -1;

			nNode = nList.item(temp);
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
