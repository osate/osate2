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
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.model.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileImport {

	/**
	 * Load the SCADE file and fill the Model producedModel passed
	 * as argument.
	 * @param inputFile     - the SCADE model
	 * @param producedModel - the model supposed to be produced
	 * @return              - the model that is completed. Similar at the second parameter.
	 */
	public static Model loadXscadeFile(String inputFile, Model producedModel) {
		OsateDebug.osateDebug("FileImport", "Try to load XSCADE file " + inputFile);
		producedModel.setName(Utils.getModelName(inputFile));
		producedModel.setPackageName(Utils.getModelName(inputFile));
		try {
			/**
			 * Instantiate the XML file.
			 */
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new FileInputStream(inputFile));
			doc.getDocumentElement().normalize();

			/**
			 * Recursively parse the model and fill the main SCADE model.
			 */
			ImportModel.process(doc, producedModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return producedModel;
	}

	/**
	 * Load all the models referenced in a project file and
	 * return them.
	 * @param inputFile - the project that contains all the models
	 * @return - list of all the models
	 */
	public static List<Model> loadProjectFile(String inputFile, String workingDirectory) {
		List<Model> allModels = new ArrayList<Model>();
		List<String> modelFileNames = new ArrayList<String>();

		OsateDebug.osateDebug("FileImport", "Try to load ETP file " + inputFile);

		try {
			/**
			 * Instantiate the XML file.
			 */
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new FileInputStream(inputFile));
			doc.getDocumentElement().normalize();

			/**
			 * Recursively parse the model and fill the main SCADE model.
			 */

			getProjectFiles(doc, modelFileNames);

			for (String s : modelFileNames) {
				Model newModel = new Model();
				loadXscadeFile(workingDirectory + File.separator + s, newModel);

				if (newModel != null) {
					allModels.add(newModel);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allModels;
	}

	public static void getProjectFiles(Node node, List<String> modelFilesNames) {
		String extension;
		if (node.getNodeName().equalsIgnoreCase("fileref")) {
			Node attrName = null;
			attrName = Utils.getAttribute(node, "persistAs");

			if (attrName != null) {
				String attrStr = attrName.getNodeValue().toString();
				OsateDebug.osateDebug("FileImport", "attr=" + attrStr);

				if (attrStr.contains(".")) {
					extension = attrStr.substring(attrStr.lastIndexOf(".") + 1);
					if (extension.equalsIgnoreCase("xscade")) {
						modelFilesNames.add(attrStr);
					}
				}

			}
		}

		NodeList nList = node.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			getProjectFiles(nList.item(temp), modelFilesNames);
		}
	}
}
