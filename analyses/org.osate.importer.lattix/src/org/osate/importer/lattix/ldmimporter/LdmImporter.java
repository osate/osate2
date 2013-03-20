/*
 * Copyright 2013 Carnegie Mellon University
 * 
 * The AADL/DSM Bridge (org.osate.importer.lattix ) (the “Content” or “Material”) 
 * is based upon work funded and supported by the Department of Defense under 
 * Contract No. FA8721-05-C-0003 with Carnegie Mellon University for the operation 
 * of the Software Engineering Institute, a federally funded research and development 
 * center.

 * Any opinions, findings and conclusions or recommendations expressed in this 
 * Material are those of the author(s) and do not necessarily reflect the 
 * views of the United States Department of Defense. 

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING 
 * INSTITUTE MATERIAL IS FURNISHED ON AN “AS-IS” BASIS. CARNEGIE MELLON 
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
 * Carnegie Mellon® is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 * 
 * DM-0000232
 * 
 */

package org.osate.importer.lattix.ldmimporter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.lattix.common.Matrix;
import org.osate.importer.lattix.common.Module;
import org.osate.importer.lattix.vdid.Preferences;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class LdmImporter {

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

	private static String cleanPartitionName (String s)
	{
		String r;
		//System.out.println ("str1=" + s);
		r = s.replaceAll("root", "");
		r = r.replace('$', '/');
		
		if (r.contains ("/"))
		{
			String[] substrs = r.split("/");
			r = substrs[substrs.length - 1];
		}
		//System.out.println ("str2=" + r);


		return r;
	}
	private static Node getAttribute (Node node, String attr)
	{
		return node.getAttributes().getNamedItem(attr);
	}

	public static Matrix loadFile (String inputFile)
	{
		return loadFile(inputFile, null);
	}

	
	public static Matrix loadFile (String inputFile, List<String> modulesList)
	{
		Matrix matrix;
		Node nNode;
		Node attrName;
		Node depName;
		NodeList nList;
		String systemName;
		String fileName;
		Module currentModule;
		String depNameString;
		InputStream in;
		ZipFile zipFile;
		
		zipFile = null;
		
		matrix = new Matrix ("unknown");
		try 
		{
			if (inputFile.contains(".ldz"))
			{
				fileName = inputFile.replace(".ldz", ".ldm");
				if (fileName.contains("\\"))	
				{
					int idx = fileName.lastIndexOf('\\');
					fileName = fileName.substring(idx + 1);
				}
				new File(inputFile);
				zipFile = new ZipFile(inputFile);
	
				in = zipFile.getInputStream(zipFile.getEntry(fileName));
			}
			else
			{
				in = new FileInputStream (inputFile);
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
			
			
			nList = doc.getElementsByTagName("base");
			 

			for (int temp = 0; temp < nList.getLength(); temp++) 
			{
				nNode = nList.item(temp);
				

				attrName = getAttribute(nNode, "name");
				
				if (attrName == null)
				{
					continue;
				}
				systemName = attrName.getNodeValue().toString();

				/**
				 * If only a subset of module must be included,
				 * then, we filter the name of the module.
				 */
				if ((modulesList != null) && ( ! modulesList.contains(systemName)))
				{
					continue;
				}
				currentModule = matrix.addModule(new Module (systemName));	
				
				/**
				 * We generate the dependency information
				 * from the DSM matrix. We extract that using
				 * the uses tag in the XML document.
				 */
				for (int childIndex = 0 ; childIndex < nNode.getChildNodes().getLength() ; childIndex++)
				{
					if (nNode.getChildNodes().item(childIndex).getNodeName().equals("uses"))
					{
						Node child = nNode.getChildNodes().item(childIndex);
						depName = getAttribute(child, "name");

						depNameString = depName.getNodeValue().toString();
						
						/**
						 * If only a subset of module must be included,
						 * then, we filter the name of the module.
						 */
						if ((modulesList != null) && ( ! modulesList.contains(depNameString)))
						{
							continue;
						}
						matrix.addModule(new Module (depNameString));
						
						matrix.getModule(systemName).addOutgoingDependency(matrix.getModule(depNameString));
						matrix.getModule(depNameString).addIncomingDependency(matrix.getModule(systemName));
					}
				}
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		return matrix;
	}
	
	
	public static void convert (String inputFile, String outputDirectory, List<String> modules)
	{
		try
		{ 
			/**
			 * We create the matrix with the modules names
			 * listed in the modules arguments.
			 */
			Matrix matrix = loadFile (inputFile, modules);
			AadlProjectCreator.createProject (outputDirectory, matrix);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}


	}
}
