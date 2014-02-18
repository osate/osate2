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

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.model.Component;
import org.osate.importer.model.Model;
import org.osate.importer.scade.actions.DoImportModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileImport {

	
	private static List<StateFlowInstance> stateFlowInstances;
	
	
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
	


//	private static void loadComponentFromLibraryBrowseLibrary (Node n, Model producedModel, String rootName)
//	{
//		NodeList list = n.getChildNodes();
//		for (int s = 0 ; s < list.getLength() ; s++)
//		{
//			Node child = list.item (s);
//			if (child.getNodeName().toString().equalsIgnoreCase("block"))
//			{
//				Node attrName = Utils.getAttribute(child, "Name");
//				
//				if (attrName == null)
//				{
//					continue;
//				}
//				
//				String blockName = attrName.getNodeValue().toString();
//				
//				if (! blockName.equalsIgnoreCase(rootName))
//				{
//					continue;
//				}
//				DoImportModel.setFilterSystem(false);
//				NodeList children = child.getChildNodes();
//				for (int s2 = 0 ; s2 < children.getLength() ; s2++)
//				{
////					OsateDebug.osateDebug("[FileImport] Import from library block " + blockName);
//					Node tmp = children.item(s2);
//					if (tmp.getNodeName().toString().equalsIgnoreCase("system"))
//					{
//						ImportModel.processSystem(tmp, producedModel, rootName);
//					}
//				}
//				DoImportModel.setFilterSystem(true);
//			}
//			else
//			{
//				loadComponentFromLibraryBrowseLibrary(child, producedModel, rootName);
//			}
//		}
//	}
//	
	
	
	
	
	public static Model loadFile (String inputFile, Model producedModel)
	{
		Node 		nNode;
		
			
		try 
		{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new FileInputStream (inputFile));
			doc.getDocumentElement().normalize();			

			NodeList declarations = doc.getElementsByTagName("declarations");
			for (int s = 0 ; s < declarations.getLength() ; s++)
			{
				nNode = declarations.item(s);
				NodeList children = nNode.getChildNodes();
				
				for (int t = 0 ; t < children.getLength() ; t++)
				{
					Node tNode = children.item (t);
					
					/**
					 * The model node contains the structure of the
					 * simulink model (the block diagrams). We parse
					 * it to map it into an AADL architecture model.
					 */
					if (tNode.getNodeName().equalsIgnoreCase("package"))
					{
						ImportModel.process (tNode, producedModel);
					}

				}
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return producedModel;
	}
	

}
