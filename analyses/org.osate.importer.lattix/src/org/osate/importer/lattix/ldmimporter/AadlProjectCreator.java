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

package org.osate.importer.lattix.ldmimporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.Preferences;
import org.osate.importer.lattix.common.Matrix;
import org.osate.importer.model.Component;


public class AadlProjectCreator {

	public static void createDirectories (String outputPath)
	{
		String outputPathFunctional;
		String outputPathRuntime;
		File ftmp;
		
		outputPathFunctional = outputPath + File.separatorChar + "functional";
		outputPathRuntime = outputPath + File.separatorChar + "runtime";
		
		ftmp = new File (outputPathFunctional);
		
		if (ftmp.exists() && ftmp.isFile())
		{
			OsateDebug.osateDebug ("Error, the following path is a file" + outputPathFunctional);
		}
		
		if (! ftmp.exists())
		{
			ftmp.mkdir();
		}
		

		ftmp = new File (outputPathRuntime);
		
		if (ftmp.exists() && ftmp.isFile())
		{
			OsateDebug.osateDebug ("Error, the following path is a file" + outputPathRuntime);
		}
		
		if (! ftmp.exists())
		{
			ftmp.mkdir();
		}
	}
	

	public static void createAadlFunctions (String outputFile, Matrix matrix)
	{
		FileWriter fstream;
		BufferedWriter out;
		

		try
		{	 
			  fstream = new FileWriter(outputFile);
			  out = new BufferedWriter(fstream);
			  
			  out.write ("package imported::functions\n");

			  out.write ("public\n");

			  out.write ("with SEI;\n");
			  out.write ("with ARINC653;\n");

			  
			  for (Component e : matrix.getModules())
			  {
				  out.write ("abstract "+e.getAadlName()+"\n");
				  if ( (e.getIncomingDependencies().size() > 0) ||
					   (e.getOutgoingDependencies().size() > 0))
				  {
					  out.write ("features\n");
					  for (Component e2 : e.getIncomingDependencies())
					  {
						  out.write ("   from_"+e2.getAadlName()+" : in event port;\n");
					  }
					  for (Component e2 : e.getOutgoingDependencies())
					  {
						  out.write ("   to_" + e2.getAadlName()+" : out event port;\n");
					  }
				  }
				  out.write ("properties\n");
				  out.write ("   SEI::nsloc => 100;\n");
				  out.write ("end "+ e.getAadlName() + ";\n");
			  }
			  
			  out.write ("end imported::functions;\n");

			  out.close();
			  fstream.close();
			 
		}
		catch (Exception e)
		{
			OsateDebug.osateDebug("Error: " + e.getMessage());
			  e.printStackTrace();
		}
		
		

	}
	
	
	public static void createAadlRuntime (String outputFile, Matrix matrix)
	{
		FileWriter fstream;
		BufferedWriter out;
		int tmp;
		boolean connectionPreamble;
		
		connectionPreamble = false;

		try
		{	 
			  fstream = new FileWriter(outputFile);
			  out = new BufferedWriter(fstream);
			  
			  out.write ("package imported::runtime\n");

			  out.write ("public\n");
			  out.write ("with runtime::common;\n");
			  out.write ("with imported::functions;\n");
			  out.write ("with SEI;\n");
			  out.write ("with ARINC653;\n\n\n");
			  
			  out.write ("data generictype\nend generictype;\n\n\n");
			  

			  
			  for (Component e : matrix.getModules())
			  {
				  //out.write ("subprogram "+e.getAadlName()+" extends imported::functions::"+e.getAadlName()+"\n");
				 // out.write ("features\n");
				 // out.write ("   comm_data : out event port;\n");
				  out.write ("subprogram "+e.getAadlName()+"\n");
				  if ( (e.getIncomingDependencies().size() > 0 )||
					   (e.getOutgoingDependencies().size() > 0 )||
					   ((e.getSubEntities().size() > 0) && (((e.getSubEntities().get(0).getIncomingDependencies().size() > 0) 
							   								||
							   								(e.getSubEntities().get(0).getOutgoingDependencies().size() > 0)))))
				{
				  out.write ("features\n");
				}
				  for (Component etmp : e.getSubEntities())
				  {
					  for (Component e2 : etmp.getIncomingDependencies())
					  {
						  if (! e.contains(e2))
						  {
							  out.write ("   to_" + etmp.getAadlName() + "_from_"+e2.getAadlName()+" : in parameter generictype;\n");
					  
						  }
					  }
					  for (Component e2 : etmp.getOutgoingDependencies())
					  {
						  if (! e.contains(e2))
						  {
							  out.write ("   from_" + etmp.getAadlName() +"_to_" + e2.getAadlName()+" : out parameter generictype;\n");
						  }
					  }
				  }
				  for (Component e2 : e.getIncomingDependencies())
				  {
					  out.write ("   to_"+e.getAadlName()+"_from_"+e2.getAadlName()+" : in parameter generictype;\n");
				  }
				  for (Component e2 : e.getOutgoingDependencies())
				  {
					  out.write ("   from_"+e.getAadlName()+"_to_" + e2.getAadlName()+" : out parameter generictype;\n");
				  }
				  out.write ("end "+ e.getAadlName() + ";\n\n");
				  
				  
				  
				  
				  out.write ("subprogram implementation "+e.getAadlName()+".i\n");
				  if (e.isContainer())
				  {
					  out.write ("calls\n");
	
					  out.write ("   mycall : {\n");
					  for (Component etmp : e.getSubEntities())
					  {
						  out.write ("      call_"+etmp.getAadlName()+" : subprogram "+etmp.getAadlName() + ".i;\n");
					  }
					  out.write ("};\n");
					  
					  out.write ("connections\n");
					  int connId = 0;
					  for (Component etmp : e.getSubEntities())
					  {
						  for (Component e2 : etmp.getIncomingDependencies())
						  {
							  if (e.contains(e2))
							  {
								  out.write ("   c" + connId + ": parameter "+"call_"+etmp.getAadlName()+".to_" + etmp.getAadlName() + "_from_"+e2.getAadlName() +" -> call_"+e2.getAadlName()+"to_" + etmp.getAadlName() + "_from_"+e2.getAadlName()+";\n");

							  }
							  else
							  {
								  out.write ("   c" + connId + ": parameter "+"call_"+etmp.getAadlName()+".to_" + etmp.getAadlName() + "_from_"+e2.getAadlName() +" -> to_" + etmp.getAadlName() + "_from_"+e2.getAadlName()+";\n");
							  }
							  connId++;
						  }
						  for (Component e2 : etmp.getOutgoingDependencies())
						  {
							  if (e.contains(e2))
							  {
								  out.write ("   c" + connId + ": parameter call_"+e2.getAadlName()+ "to_" + etmp.getAadlName() + "_from_"+e2.getAadlName() +" -> "+"call_"+etmp.getAadlName()+".to_" + etmp.getAadlName() + "_from_"+e2.getAadlName()+";\n");
							  }
							  connId++;
						  }
					  }
				  }
				  out.write ("end "+ e.getAadlName() + ".i;\n\n");
				  
				  if (e.getParent() == null)
				  {
					  out.write ("thread thr_"+e.getAadlName() + "\n");
					  if ( (e.getIncomingDependencies().size() > 0 )||
							   (e.getOutgoingDependencies().size() > 0 )||
							   ((e.getSubEntities().size() > 0) && (((e.getSubEntities().get(0).getIncomingDependencies().size() > 0) 
									   								||
									   								(e.getSubEntities().get(0).getOutgoingDependencies().size() > 0)))))
						{
					  out.write ("features\n");
						}
					  for (Component etmp : e.getSubEntities())
					  {
						  for (Component e2 : etmp.getIncomingDependencies())
						  {
							  if (! e.contains(e2))
							  {
								  out.write ("   to_" + etmp.getAadlName() + "_from_"+e2.getAadlName()+" : in parameter generictype;\n");
						  
							  }
						  }
						  for (Component e2 : etmp.getOutgoingDependencies())
						  {
							  if (! e.contains(e2))
							  {
								  out.write ("   from_" + etmp.getAadlName() +"_to_" + e2.getAadlName()+" : out parameter generictype;\n");
							  }
						  }
					  }
		
					  for (Component e2 : e.getIncomingDependencies())
					  {
						  out.write ("   from_"+e2.getAadlName()+" : in event data port generictype;\n");
					  }
					  for (Component e2 : e.getOutgoingDependencies())
					  {
						  out.write ("   to_" + e2.getAadlName()+" : out event data port generictype;\n");
					  }
					  out.write ("end thr_"+ e.getAadlName() + ";\n\n");
					 
					  out.write ("thread implementation thr_"+e.getAadlName() + ".i\n");
					  out.write ("calls\n");
	
					  out.write ("   mycall : {\n");
					  out.write ("      call1 : subprogram "+e.getAadlName() + ";\n");
					  out.write ("};\n");
					  if ( (e.getIncomingDependencies().size() > 0 )||
							   (e.getOutgoingDependencies().size() > 0 )||
							   ((e.getSubEntities().size() > 0) && (((e.getSubEntities().get(0).getIncomingDependencies().size() > 0) 
									   								||
									   								(e.getSubEntities().get(0).getOutgoingDependencies().size() > 0)))))
						{
					  out.write ("connections\n");
						}
					  int connId = 0;
					  for (Component e2 : e.getIncomingDependencies())
					  {
						  out.write ("   c" + connId + ": parameter from_"+e2.getAadlName()+" -> call1.to_"+e.getAadlName()+"_from_"+e2.getAadlName()+";\n");
						  connId++;
					  }
					  for (Component e2 : e.getOutgoingDependencies())
					  {
						  out.write ("   c" + connId + ": parameter call1.from_"+e.getAadlName()+"_to_"+e2.getAadlName()+" -> to_"+e2.getAadlName()+";\n");
						  connId++;
					  }
					  out.write ("end thr_"+ e.getAadlName() + ".i;\n\n");
					  
					  out.write ("process pr_"+e.getAadlName()+"\n");
					  if ( (e.getIncomingDependencies().size() > 0 )||
							   (e.getOutgoingDependencies().size() > 0 )||
							   ((e.getSubEntities().size() > 0) && (((e.getSubEntities().get(0).getIncomingDependencies().size() > 0) 
									   								||
									   								(e.getSubEntities().get(0).getOutgoingDependencies().size() > 0)))))
						{
					  out.write ("features\n");
						}
					  for (Component e2 : e.getIncomingDependencies())
					  {
						  out.write ("   from_"+e2.getAadlName()+" : in event data port generictype;\n");
					  }
					  for (Component e2 : e.getOutgoingDependencies())
					  {
						  out.write ("   to_" + e2.getAadlName()+" : out event data port generictype;\n");
					  }
					  out.write ("end pr_"+ e.getAadlName() + ";\n\n");
					  
					  out.write ("process implementation pr_"+e.getAadlName()+".i\n");
					  out.write ("subcomponents\n");
					  out.write ("   t_"+e.getAadlName()+" : thread thr_"+ e.getAadlName() + ".i;\n\n");
					  if ( (e.getIncomingDependencies().size() > 0 )||
							   (e.getOutgoingDependencies().size() > 0 )||
							   ((e.getSubEntities().size() > 0) && (((e.getSubEntities().get(0).getIncomingDependencies().size() > 0) 
									   								||
									   								(e.getSubEntities().get(0).getOutgoingDependencies().size() > 0)))))
						{
					  out.write ("connections\n");
						}
					  for (Component e2 : e.getIncomingDependencies())
					  {
						  out.write ("   c" + connId + ": port from_"+e2.getAadlName()+" -> t_"+e.getAadlName()+".from_"+e2.getAadlName()+";\n");
						  connId++;
					  }
					  for (Component e2 : e.getOutgoingDependencies())
					  {
						  out.write ("   c" + connId + ": port t_"+e.getAadlName()+".to_"+e2.getAadlName()+" -> to_"+e2.getAadlName()+";\n");
						  connId++;
					  }
					  out.write ("end pr_"+ e.getAadlName() + ".i;\n\n");
				  }
			  }
			  

			  out.write ("processor module extends runtime::common::module\n");
			  out.write ("end module;\n");

			  out.write ("processor implementation module.i\n");
			  if (Preferences.useArinc())
			  {
				  out.write ("subcomponents\n");
				  for (Component e : matrix.getModules())
				  {
					  if (e.getParent() == null)
					  {
						  out.write ("	"+e.getAadlName()+" : virtual processor runtime::common::partition.i {ARINC653::Criticality => LEVEL_C;};\n");
					  }
				  }
				  out.write ("properties\n");
				  out.write ("	ARINC653::Module_Major_Frame => "+matrix.getModules().size() + 100+"ms;\n");
				  out.write ("	ARINC653::Partition_Slots => (");
				  boolean firstWritten = false;
				  for (Component e : matrix.getModules())
				  {

					  if (e.getParent() == null)
					  {
						  if (firstWritten)
						  {
							  out.write (",");
						  }
						  out.write ("100ms");
						  firstWritten = true;
					  }
				  }
				  out.write (");\n");
				  out.write ("	ARINC653::Slots_Allocation => (");
				  
				  tmp = 0;
				  for (Component e : matrix.getModules())
				  {
					  if (e.getParent() == null)
					  {
						  if (tmp > 0)
						  {
							  out.write (",");
						  }
						  out.write ("reference("+ e.getAadlName() +")");
						  tmp++;
					  }
				  }
				 out.write (");\n");
			  }
			 out.write ("end module.i;\n");
			  
			 out.write ("memory ram extends runtime::common::ram\n");
			 out.write ("end ram;\n");

			 out.write ("memory implementation ram.i\n");
			  if (Preferences.useArinc())
			  {
				 out.write ("subcomponents\n");
				 for (Component e : matrix.getModules())
				  {
					  if (e.getParent() == null)
					  {
						  out.write ("   "+e.getAadlName()+" : memory runtime::common::segment.i;\n");
				  
					  }
				  }
			  }
			 out.write ("end ram.i;\n");
			  		
			 
			  out.write("system mainsystem\n");
			  out.write("end mainsystem;\n");
			  
			  out.write("system implementation mainsystem.i\n");
			  out.write("subcomponents\n");
				 for (Component e : matrix.getModules())
				  {
					  if (e.getParent() == null)
					  {
						  out.write ("   "+e.getAadlName()+" : process pr_"+e.getAadlName()+".i;\n");
				  
					  }
				  }
				 
			  if (Preferences.useArinc())
			  {
				  out.write("	module : processor module.i;\n");
				  out.write("	ram    : memory ram.i;\n");
			  }
			  else
			  {
				  out.write("	cpu : processor module.i;\n");
				  out.write("	ram    : memory ram.i;\n");
			  }
			  

			  int connId = 0;
			  for (Component e : matrix.getModules())
			  {
				  if (e.getParent() != null)
				  {
					  continue;
				  }

				  for (Component e2 : e.getOutgoingDependencies())
				  {
					  if (!connectionPreamble)
					  {
						  connectionPreamble = true;
						  out.write("connections\n");
					  }
					  out.write("   c" + connId + ": port " + e.getAadlName() + ".to_" + e2.getAadlName() + "->" +  e2.getAadlName() + ".from_" + e.getAadlName() +";\n");
					  connId++;
				  }
			  }
			  
			  out.write("properties\n");
			  for (Component e : matrix.getModules())
			  {
				  if(e.getParent() != null)
				  {
					  continue;
				  }
				  
				  if (Preferences.useArinc()) 
				  {
					  out.write("	Actual_Processor_Binding => (reference (module."+e.getAadlName()+")) applies to "+e.getAadlName()+";\n");
					  out.write("	Actual_Memory_Binding    => (reference (ram."+e.getAadlName()+")) applies to "+e.getAadlName()+";\n");
				  }
				  else
				  {
					  out.write("	Actual_Processor_Binding => (reference (cpu)) applies to "+e.getAadlName()+";\n");
					  out.write("	Actual_Memory_Binding    => (reference (ram)) applies to "+e.getAadlName()+";\n");
				  }
			  }
			  
			  
			  
			  out.write("end mainsystem.i; \n");
			  

			  out.write("end imported::runtime; \n");
			 
			  out.close();
			  fstream.close();
			 
		}
		catch (Exception e)
		{
			  System.err.println("Error: " + e.getMessage());
		}
		
		

	}
	
	public static void createGenericRuntime (String outputFile)
	{
		FileWriter fstream;
		BufferedWriter out;
		

		try
		{	 
			  fstream = new FileWriter(outputFile);
			  out = new BufferedWriter(fstream);

			  out.write("package runtime::common\n");

			  out.write("public\n");

			  out.write("with ARINC653;\n");
			  out.write("with SEI;\n");

			  out.write("virtual processor partition\n");
			  out.write("end partition;\n");

			  out.write("virtual processor implementation partition.i\n");
			  out.write("end partition.i;\n");

			  out.write("processor module\n");
			  out.write("end module;\n");


			  out.write("memory ram\n");
			  out.write("end ram;\n");

			  out.write("memory segment\n");
			  out.write("end segment;\n");

			  out.write("memory implementation segment.i\n");
			  out.write("end segment.i;\n");



			  out.write("end runtime::common;\n");
			  
			  
			  
			  
			  
			  out.close();
			  fstream.close();
			 
		}
		catch (Exception e)
		{
			  System.err.println("Error: " + e.getMessage());
		}
		
		

	}
	
	
	public static void createProject (String outputPath, Matrix matrix)
	{
		String outputPathFunctional;
		String outputPathRuntime;
		String outputFileFunctional;
		String outputFileRuntime;
		String outputFileGenericRuntime;
		
		outputPathFunctional = outputPath + File.separatorChar + "functional";
		outputPathRuntime = outputPath + File.separatorChar + "runtime";
		outputFileFunctional = outputPathFunctional + File.separatorChar + "functional.aadl";
		outputFileRuntime    = outputPathRuntime + File.separatorChar + "runtime.aadl";
		outputFileGenericRuntime = outputPathRuntime + File.separatorChar + "runtime-generic.aadl";
		
		createDirectories(outputPath);
		
		OsateDebug.osateDebug ("Create Generic Runtime in " + outputFileGenericRuntime);
		createGenericRuntime (outputFileGenericRuntime);
		
		OsateDebug.osateDebug ("Create AADL functional project in " + outputFileFunctional);
		createAadlFunctions (outputFileFunctional, matrix);
		
		OsateDebug.osateDebug ("Create AADL runtime  project in " + outputFileRuntime);
		createAadlRuntime (outputFileRuntime,matrix);

	}
	
}
