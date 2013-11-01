/*
 * Copyright 2013 Carnegie Mellon University
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

package org.osate.importer.simulink;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.util.OsateDebug;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Utils {
	
	public static final int CONNECTION_FIELD_BLOCK_INDEX 			= 1;
	public static final int CONNECTION_FIELD_PORT_DIRECTION 		= 2;
	public static final int CONNECTION_FIELD_PORT_INDEX 			= 3;
	
	public static final int CONNECTION_FIELD_PORT_IN 		= 1;
	public static final int CONNECTION_FIELD_PORT_OUT 		= 2;
	
	
	public static String getTagValue(String sTag, Element eElement)
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


	public static Node getAttribute (Node node, String attr)
	{
		return node.getAttributes().getNamedItem(attr);
	}



	
	
	public static String getActionFromLabel (String label)
	{
		String result = label;
		if (result.contains("{") && result.contains("}"))
		{
			result = result.substring(result.indexOf('{') + 1, result.indexOf('}'));
		}
		else
		{
			return "";
		}
		
		if (result.contains("."))
		{
			result = result.substring(result.indexOf('.') + 1, result.length());
		}
		
		if (! (result.contains("=")))
		{
			result = result + " := true";
		}
		
		return result;
	}
	
	
	
	public static String getStatementsFromStateLabelString (String label)
	{
		String result = label.replace('\n', ' ');
		if (result.contains("entry:"))
		{
			result = result.substring(result.indexOf("entry:") + 6);
			return result;
		}
		return null;
	}
	
	public static String getConditionFromLabel (String label)
	{
		String result = label;
		if (result.contains("[") && result.contains("]"))
		{
			result = result.substring(result.indexOf('[') + 1, result.indexOf(']'));
		}
		return result;
	}
	
	public static boolean isSimpleConditionLabel (String label)
	{
		if (label.contains("[") && label.contains("]"))
		{
			return false;
		}
		return true;
	}
	
	
	public static boolean isSimpleActionLabel (String label)
	{

		return true;
	}
	

	
	public static List<String> getVariablesFromConditionOrAction (String label)
	{
		List<String> result = new ArrayList<String>();
	
		if (label == null)
		{
			return result;
		}
		
		String[] tmp = label.split(" ");
		for (String s : tmp)
		{
			if (s.equalsIgnoreCase("true"))
			{
				continue;
			}
			
			if (s.equalsIgnoreCase("false"))
			{
				continue;
			}
			
			if (s.matches("[a-zA-Z0-9_]+"))
			{
				result.add(s);
			}
			if (s.contains("."))
			{
				result.add (s.substring(s.indexOf("." + 1)));
			}
			
	
		}
		return result;
	}
	
	public static List<String> getVariablesFromTransitionLabel (String label)
	{
		String condition;
		String action;
		List<String> result = new ArrayList<String>();
	
		condition = getConditionFromLabel(label);
		action = getActionFromLabel(label);
		result.addAll(getVariablesFromConditionOrAction(condition));
		result.addAll(getVariablesFromConditionOrAction(action));

		return result;
	}
	

	
	public static String filterStateName (String s)
	{
		String label = s;
		if (label.indexOf('\n') != -1)
		{
			label = label.substring(0, label.indexOf('\n')).replaceAll("entry", "");
		}
		
		if (label.indexOf(':') != -1)
		{
			label = label.substring(0, label.indexOf(':')).replaceAll("entry", "");
		}
		return label;
	}


	public static int getConnectionPointInformation (String connection, int field)
		{
			int idx1;
			int idx2;
			String blockIndex;
			String portDirection;
			String portIndex;
			
			idx1 = connection.indexOf("#");
			idx2 = connection.indexOf(":");
			blockIndex = connection.substring(0, idx1);
			portDirection = connection.substring(idx1+1, idx2);
			portIndex = connection.substring(idx2+1);
	//		OsateDebug.osateDebug("blockIndex="+ blockIndex);
	//		OsateDebug.osateDebug("portDirection="+ portDirection);
	//		OsateDebug.osateDebug("portIndex="+ portIndex);
			
			switch (field)
			{
				case CONNECTION_FIELD_BLOCK_INDEX:
				{
					return Integer.parseInt(blockIndex);
				}
	
				case CONNECTION_FIELD_PORT_DIRECTION:
				{
					if (portDirection.equalsIgnoreCase("out"))
					{
						return CONNECTION_FIELD_PORT_OUT;
					}
					return CONNECTION_FIELD_PORT_IN;
				}			
				
				case CONNECTION_FIELD_PORT_INDEX:
				{
					return Integer.parseInt(portIndex);
				}
				
				default:
				{
					return 0;
				}
			}
		}
}
