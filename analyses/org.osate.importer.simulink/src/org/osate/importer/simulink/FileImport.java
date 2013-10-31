


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
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.model.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileImport {

	private static String SIMULINK_ENTRYFILE = "simulink/blockdiagram.xml";
	private static Model producedModel;
	private static List<StateFlowInstance> stateFlowInstances;
	
	public Model getModel()
	{
		return this.producedModel;
	}
	
	public static List<StateFlowInstance> getStateFlowInstances ()
	{
		return stateFlowInstances;
	}
	
	public static void addStateFlowInstance (StateFlowInstance sfi)
	{
		stateFlowInstances.add(sfi);
	}
	
	public static StateFlowInstance getStateFlowImport (String s)
	{
		for (StateFlowInstance sfi : stateFlowInstances)
		{
			if (sfi.getName().equalsIgnoreCase(s))
			{
				return sfi;
			}
		}
		return null;
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
//		OsateDebug.osateDebug("try to load" + inputFile);
		
		producedModel = new Model();
		stateFlowInstances = new ArrayList<StateFlowInstance> ();
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
//				OsateDebug.osateDebug("ModelInformation passed");

				nNode = modelInformationNodes.item(s);
				NodeList children = nNode.getChildNodes();
				
				for (int t = 0 ; t < children.getLength() ; t++)
				{
					Node tNode = children.item (t);
					if (tNode.getNodeName().equalsIgnoreCase("model"))
					{
//						OsateDebug.osateDebug("Model passed");
						ImportModel.processModel (tNode, producedModel);
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
//						OsateDebug.osateDebug("stateflow");
						ImportStateFlow.processStateFlow (tNode, producedModel);
					}
				}
			}
			
			/*
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
			}*/
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return producedModel;
	}
	

}
