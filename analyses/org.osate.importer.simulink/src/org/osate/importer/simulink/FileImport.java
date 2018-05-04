
/*
 * Copyright 2013-2014 Carnegie Mellon University
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
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.model.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileImport {

	public static List<Model> models;

	public static void init() {
		models = new ArrayList<Model>();
	}

	private static String SIMULINK_ENTRYFILE = "simulink/blockdiagram.xml";

	private static List<StateFlowInstance> stateFlowInstances;

	public static List<StateFlowInstance> getStateFlowInstances() {
		return stateFlowInstances;
	}

	public static void addStateFlowInstance(StateFlowInstance sfi) {
		stateFlowInstances.add(sfi);
	}

	public static StateFlowInstance getStateFlowImport(String s) {
		for (StateFlowInstance sfi : stateFlowInstances) {
			if (org.osate.importer.Utils.toAadl(sfi.getName()).equalsIgnoreCase(s)) {
				return sfi;
			}
		}
		return null;
	}

	public static Document loadXMLZip(String inputFile) {

		InputStream in;
		ZipFile zipFile;

		zipFile = null;

		try {
//			OsateDebug.osateDebug("[FileImport] Try to load " + inputFile);
			/*
			 * In fact, the simulink model (slx file) is a zip file
			 * like openfocument file. We parse the zip and extract
			 * the file that contains all interesting information
			 * (blockdiagram.xml).
			 */
			if (inputFile.contains(".slx")) {
				zipFile = new ZipFile(inputFile);
				in = zipFile.getInputStream(zipFile.getEntry(SIMULINK_ENTRYFILE));
			} else {
				OsateDebug.osateDebug("[FileImport] Not a Simulink model");
				return null;
			}

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(in);
			if (zipFile != null) {
				zipFile.close();
			}
			in.close();
			return doc;
		} catch (Exception e) {
//			OsateDebug.osateDebug("[FileImport] Exception in loadXMLZip()");
//			e.printStackTrace();
		}
		return null;
	}

	public static Model getModel(String n) {
		for (Model m : models) {
			if (m.getName().equalsIgnoreCase(n)) {
				return m;
			}
		}
		return null;
	}

	/**
	 * Load a file, either a model or a library. Return a generic model.
	 * If we are not able to load the file, it just returns null.
	 * 
	 * @param file      		- the file that contains the model or library
	 */
	public static Model loadFile(String inputFile) {
		Node nNode;
		Model producedModel;

		producedModel = getModel(inputFile);

		if (producedModel != null) {
			return producedModel;
		}

		producedModel = new Model(Utils.getModelName(inputFile));
		models.add(producedModel);
		stateFlowInstances = new ArrayList<StateFlowInstance>();

		try {
			Document doc = loadXMLZip(inputFile);

			/**
			 * if doc is null, it means (most of the case) that the
			 * file does not exist.
			 */
			if (doc == null) {
				return null;
			}

			doc.getDocumentElement().normalize();

			NodeList modelInformationNodes = doc.getElementsByTagName("ModelInformation");
			for (int s = 0; s < modelInformationNodes.getLength(); s++) {
				nNode = modelInformationNodes.item(s);
				NodeList children = nNode.getChildNodes();

				for (int t = 0; t < children.getLength(); t++) {
					Node tNode = children.item(t);

					/**
					 * The model node contains the structure of the
					 * simulink model (the block diagrams). We parse
					 * it to map it into an AADL architecture model.
					 */
					if (tNode.getNodeName().equalsIgnoreCase("model")) {
						ImportModel.processComponents(tNode, producedModel, null);
					}

					if (tNode.getNodeName().equalsIgnoreCase("library")) {
						ImportModel.processComponents(tNode, producedModel, null);
					}

				}
			}

			for (int s = 0; s < modelInformationNodes.getLength(); s++) {
				nNode = modelInformationNodes.item(s);
				NodeList children = nNode.getChildNodes();

				for (int t = 0; t < children.getLength(); t++) {
					Node tNode = children.item(t);

					/**
					 * The model node contains the structure of the
					 * simulink model (the block diagrams). We parse
					 * it to map it into an AADL architecture model.
					 */
					if (tNode.getNodeName().equalsIgnoreCase("model")) {
						ImportModel.processNodeConnections(tNode, producedModel);
					}

					if (tNode.getNodeName().equalsIgnoreCase("library")) {
						ImportModel.processNodeConnections(tNode, producedModel);
					}

				}
			}

			/**
			 * The stateflow information are separated from the model. Then,
			 * we associate a stateflow with the component by name matching:
			 * if the stateflow instance matches the block name, we add
			 * the state machine into the component description.
			 */
			for (int s = 0; s < modelInformationNodes.getLength(); s++) {
				nNode = modelInformationNodes.item(s);
				NodeList children = nNode.getChildNodes();

				for (int t = 0; t < children.getLength(); t++) {
					Node tNode = children.item(t);
					if (tNode.getNodeName().equalsIgnoreCase("stateflow")) {
						ImportStateFlow.processStateFlow(tNode, producedModel);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return producedModel;
	}

}
