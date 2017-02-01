package org.osate.importer.simulink;

import java.util.HashMap;

import org.osate.importer.model.Component;
import org.osate.importer.model.Component.ComponentType;
import org.osate.importer.model.Connection;
import org.osate.importer.model.Model;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ImportModel {

//	public static void processComponents(Node node, Model model, Component currentComponent) {
//		processComponents(node, model, currentComponent, new HashMap<String,Component> ());
//	}
//	
	public static void processComponents(Node node, Model model, Component currentComponent) {
		Node attrName;
		String blockName;
		NodeList nList;
		Node nNode;
		String sidStr;
		Component newComponent;
		String blockType;
		int sidValue;

		attrName = null;
		sidValue = 0;
		blockType = null;
		newComponent = null;
		sidStr = null;
		nNode = null;
		nList = null;
		blockName = null;

		nList = node.getChildNodes();

		/**
		 * First of all, we handle the sub-components declared
		 * in the block/system. Later (see below), we handle
		 * the connections.
		 */
		for (int temp = 0; temp < nList.getLength(); temp++) {
			nNode = nList.item(temp);

			/**
			 * If we are in a system we browse recursively the xml sub items.
			 */
			if (nNode.getNodeName().equalsIgnoreCase("system")) {
				processComponents(nNode, model, currentComponent);
			}

			if (nNode.getNodeName().equalsIgnoreCase("block")) {

				/**
				 * 
				 * Get the name of the block
				 */
				attrName = Utils.getAttribute(nNode, "Name");

				if (attrName == null) {
					continue;
				}

				blockName = attrName.getNodeValue().toString();
				
				Component parent = currentComponent;
				while (parent != null)
				{
					blockName = parent.getName() + "_" + blockName;
					parent = parent.getParent();
				}

				/**
				 * Get its type - means if this is a port, a subsystem, etc.
				 */
				attrName = Utils.getAttribute(nNode, "BlockType");

				if (attrName == null) {
					continue;
				}
				blockType = attrName.getNodeValue().toString();

				attrName = Utils.getAttribute(nNode, "SID");

				if (attrName == null) {
					continue;
				}
				sidStr = attrName.getNodeValue().toString();

				if (sidStr.contains(":")) {
					sidStr = sidStr.substring(sidStr.lastIndexOf(":") + 1);
				}

				sidValue = Integer.parseInt(sidStr);

				/**
				 * Create a new component, and then, define
				 * its type.
				 */

				newComponent = new Component(blockName);
				newComponent.setIdentifier(sidValue);

//				OsateDebug.osateDebug("ImportModel", "Create a new component with (name,sid)=(" + blockName +","+sidValue+")");

				if (blockType.equalsIgnoreCase("from")) {
					newComponent.setType(ComponentType.EXTERNAL_INPORT);
					if (currentComponent != null) {
//						OsateDebug.osateDebug("ImportModel", "Add the component as an inport of " + currentComponent.getName());
						currentComponent.addSubsystem(newComponent);
						newComponent.setParent(currentComponent);
					}
				}

				if (blockType.equalsIgnoreCase("inport")) {
					newComponent.setType(ComponentType.EXTERNAL_INPORT);
					if (currentComponent != null) {
//						OsateDebug.osateDebug("ImportModel", "Add the component as an inport of " + currentComponent.getName());
						currentComponent.addSubsystem(newComponent);
						newComponent.setParent(currentComponent);
					}
				}

				if (blockType.equalsIgnoreCase("outport")) {
					newComponent.setType(ComponentType.EXTERNAL_OUTPORT);
					if (currentComponent != null) {
//						OsateDebug.osateDebug("ImportModel", "Add the component as an outport of " + currentComponent.getName());
						currentComponent.addSubsystem(newComponent);
						newComponent.setParent(currentComponent);
					}
				}

				if (blockType.equalsIgnoreCase("subsystem")) {
					newComponent.setType(ComponentType.BLOCK);

					if (currentComponent != null) {
//						OsateDebug.osateDebug("ImportModel", "Add the component as a sub-component of " + currentComponent.getName());
						currentComponent.addSubsystem(newComponent);
						newComponent.setParent(currentComponent);
					}

					/**
					 * Try to find recursively new systems.
					 */
					processComponents(nNode, model, newComponent);
				}

				if (blockType.equalsIgnoreCase("reference")) {

					String referenceSource = Utils.getSourceBlock(nNode);
					// OsateDebug.osateDebug(referenceSource);
					if (referenceSource != null) {
						String[] strs = referenceSource.split("/");
						String sourceFile = strs[0];
						String sourceBlock = strs[1];
//						OsateDebug.osateDebug("ImportModel", "file=" + sourceFile);
//						OsateDebug.osateDebug("ImportModel", "block=" + sourceBlock);
						newComponent.setType(ComponentType.REFERENCE);
						newComponent.setReferencedModel(sourceFile);
						newComponent.setReferencedComponent(sourceBlock);

						/**
						 * If we reference a simulink basic block, we do not include it
						 */
						if (sourceFile.equalsIgnoreCase("simulink")) {
							newComponent = null;
						} else {
							if (currentComponent != null) {
//								OsateDebug.osateDebug("ImportModel", "Add the component as a sub-component of " + currentComponent.getAadlName() + "reference=" + sourceBlock + " package " + sourceFile);
								currentComponent.addSubsystem(newComponent);
								newComponent.setParent(currentComponent);
							}
						}

					}
				}

				/**
				 * Finally, we add the component to the model.
				 */
				if ((newComponent != null) && (newComponent.getType() != ComponentType.UNKNOWN)) {
					/**
					 * Check if the component has already been added.
					 */
					if (!model.containsComponent(blockName)) {
						model.addComponent(newComponent);
					}

				}

			}
		}
	}

	public static void processNodeConnections(Node node, Model model) {
		Node attrName;
		String direction;
		NodeList nList;
		Node nNode;
		Node tmpNode;
		attrName = null;
		tmpNode = null;
		nNode = null;
		nList = null;
		direction = null;

		nList = node.getChildNodes();

		/**
		 * Now, we handle the connection between the sub-components.
		 */
		for (int temp = 0; temp < nList.getLength(); temp++) {
			String srcString;
			String dstString;

			nNode = nList.item(temp);

			processNodeConnections(nNode, model);

			if (nNode.getNodeName().equalsIgnoreCase("Line")) {
				srcString = null;
				dstString = null;
				NodeList children = nNode.getChildNodes();
				for (int temp2 = 0; temp2 < children.getLength(); temp2++) {
					tmpNode = children.item(temp2);
					if (tmpNode.getNodeName().equalsIgnoreCase("p")) {
						attrName = Utils.getAttribute(tmpNode, "Name");

						if (attrName == null) {
							continue;
						}
						direction = attrName.getNodeValue().toString();
						// OsateDebug.osateDebug("direction="+direction);
						if (direction.equalsIgnoreCase("src")) {
							srcString = tmpNode.getTextContent();
							// OsateDebug.osateDebug("srcString="+srcString);
							addConnection(srcString, dstString, model);
						}

						if (direction.equalsIgnoreCase("dst")) {
							dstString = tmpNode.getTextContent();
							// OsateDebug.osateDebug("dstString="+dstString);
							addConnection(srcString, dstString, model);
						}
					}
					if (tmpNode.getNodeName().equalsIgnoreCase("branch")) {
						NodeList children4 = tmpNode.getChildNodes();
						for (int temp4 = 0; temp4 < children4.getLength(); temp4++) {
							Node tmpNode4 = children4.item(temp4);
							if (tmpNode4.getNodeName().equalsIgnoreCase("p")) {
								Node attrName2 = Utils.getAttribute(tmpNode4, "Name");

								if (attrName2 == null) {
									continue;
								}

								String direction2 = attrName2.getNodeValue().toString();
								// OsateDebug.osateDebug("direction="+direction);
								if (direction2.equalsIgnoreCase("src")) {
									srcString = tmpNode4.getTextContent();
									// OsateDebug.osateDebug("srcString="+srcString);
									addConnection(srcString, dstString, model);
								}

								if (direction2.equalsIgnoreCase("dst")) {
									dstString = tmpNode4.getTextContent();
									// OsateDebug.osateDebug("dstString="+dstString);
									addConnection(srcString, dstString, model);
								}
							}
						}
					}
				}
			}
		}
	}

	private static boolean addConnection(String srcString, String dstString, Model model) {
		if ((dstString != null) && (srcString != null)) {
			int srcBlockIndex;
			int dstBlockIndex;
			int dstInterfaceIndex;
			int srcInterfaceIndex;

			srcBlockIndex = Utils.getConnectionPointInformation(srcString, Utils.CONNECTION_FIELD_BLOCK_INDEX);
			dstBlockIndex = Utils.getConnectionPointInformation(dstString, Utils.CONNECTION_FIELD_BLOCK_INDEX);
			srcInterfaceIndex = Utils.getConnectionPointInformation(srcString, Utils.CONNECTION_FIELD_PORT_INDEX);
			dstInterfaceIndex = Utils.getConnectionPointInformation(dstString, Utils.CONNECTION_FIELD_PORT_INDEX);

//			OsateDebug.osateDebug("[FileImport] connection src=" + srcString +"|dst="+dstString);
//			OsateDebug.osateDebug("[FileImport] connection srcBlockIndex=" + srcBlockIndex +"|dstBlockIndex="+dstBlockIndex);
//			OsateDebug.osateDebug("[FileImport] connection srcInterfaceIndex=" + srcInterfaceIndex +"|dstInterfaceIndex="+dstInterfaceIndex);

			Component srcComponent = model.findComponentById(srcBlockIndex);
			Component dstComponent = model.findComponentById(dstBlockIndex);

//			if (dstString.contains("372") || srcString.contains("372"))
//			{
//				OsateDebug.osateDebug("FileImport" , "372 (srcIndex=" + srcBlockIndex + ";dstIndex="+dstBlockIndex+")");
//
//			}

			if ((srcComponent == null) || (dstComponent == null)) {
//				OsateDebug.osateDebug("ImportModel" , "null components (srcIndex=" + srcBlockIndex + ";dstIndex="+dstBlockIndex+")");

				return false;
			}

			if ((srcComponent.getType() == ComponentType.BLOCK) && (srcInterfaceIndex > 0)) {
				srcComponent = srcComponent.getOutPort(srcInterfaceIndex - 1);
			}

			if ((dstComponent.getType() == ComponentType.BLOCK) && (dstInterfaceIndex > 0)) {
				dstComponent = dstComponent.getInPort(dstInterfaceIndex - 1);
			}

			if ((srcComponent != null) && (dstComponent != null)) {
				Connection c = new Connection(srcComponent, dstComponent);
				srcComponent.addConnection(c);
				dstComponent.addConnection(c);
				model.addConnection(c);
				return true;
			} else {
//				OsateDebug.osateDebug("FileImport" , "Not adding a connection, null component");

			}
		}
		return false;
	}

}
