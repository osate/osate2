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
