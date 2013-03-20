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
package org.osate.importer.lattix.common;

import java.util.ArrayList;
import java.util.List; 

import org.osate.aadl2.util.OsateDebug;

public class Module implements Comparable {

	private String name;
	private List<ModuleConnection> connections;
	private List<Module> subEntities;
	private Module parent;
	
	
	public Module (String n)
	{
		this.name = n;
		this.connections = new ArrayList<ModuleConnection>();
		this.subEntities  = new ArrayList<Module>();
		this.parent = null;
	}
	
	public Module getParent ()
	{
		return this.parent;
	}
	
	public void setParent (Module e)
	{
		this.parent = e;
	}
	
	public List<Module> getSubEntities()
	{
		return this.subEntities;
	}
	
	public boolean isContainer ()
	{
		return (! this.subEntities.isEmpty());
	}
	
	public boolean contains (Module e)
	{
		return this.subEntities.contains(e);
	}
	
	public void addOutgoingDependency (Module destination, int s)
	{
		ModuleConnection conn = new ModuleConnection (this, destination, s);
		connections.add(conn);
	}
	
	public void addIncomingDependency (Module source, int s)
	{
		ModuleConnection conn = new ModuleConnection (source, this, s);
		connections.add(conn);
	}
	
	
	public void addSubsystem (Module s)
	{
		for (Module e : subEntities)
		{
			if (e.getName().equals(s.getName()))
			{
				return;
			}
		}
		this.subEntities.add(s);
	}
	
	public boolean equalsTo (Module e)
	{
		if (e.getName().equals(this.name))
		{
			return true;
		}
		return false;
	}
	
	public String getName ()
	{
		return this.name;
	}
	
	public String getAadlName()
	{
		String result;

		result = this.name.replaceAll("root", "");
		result = result.replace('$', ' ');
		result = result.replace('.', ' ');
		result = result.replaceAll(" ", "");
		return result;
	}
	
	public List<Module> getIncomingDependencies ()
	{
		List<Module> result;
		
		result = new ArrayList<Module>();
		
		for (ModuleConnection ec : connections)
		{
			if ((ec.getDestination().getName() == this.getName()) &&
			    (! result.contains(ec.getSource())))
			{
				result.add(ec.getSource());
			}
		}
		
		return result;
	}
	
	public List<Module> getOutgoingDependencies ()
	{
		List<Module> result;
		
		result = new ArrayList<Module>();
		
		for (ModuleConnection ec : connections)
		{
			if ((ec.getSource().getName() == this.getName()) &&
				(! result.contains (ec.getDestination())))
			{
				result.add(ec.getDestination());
			}
		}
		
		return result;	
	}
	
	
	public List<ModuleConnection> getConnections ()
	{
		return this.connections;
	}
	
	
	public void addConnection (ModuleConnection ec)
	{
		for (ModuleConnection c : connections)
		{
			if ((c.getSource().getName() == ec.getSource().getName()) &&
				(c.getDestination().getName() == ec.getDestination().getName()))
			{
				return;
			}
		}
		this.connections.add (ec);
	}


	public boolean equalsTo(Object arg0) {
		return this.compareTo(arg0)==0;
	}
	
	public int compareTo(Object arg0) {
		if (arg0 instanceof Module)
		{
			return (this.name.equalsIgnoreCase(((Module)arg0).getName()))?0:1 ;
		}
		return -1;
	}
}
