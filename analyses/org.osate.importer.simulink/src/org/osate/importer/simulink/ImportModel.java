package org.osate.importer.simulink;

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
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ImportModel {

	public static void processModel (Node model, Model produced)
		{
			NodeList nList = model.getChildNodes();
			
	
			for (int temp = 0; temp < nList.getLength(); temp++) 
			{
				Node nNode = nList.item(temp);
				if (nNode.getNodeName().equalsIgnoreCase("system"))
				{
					processSystem (nNode, produced);
				}
			}
		}

	public static void processSystem (Node system, Model model)
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
					}
					model.addComponent(c);
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
