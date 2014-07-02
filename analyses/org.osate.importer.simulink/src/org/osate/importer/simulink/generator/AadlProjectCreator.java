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

package org.osate.importer.simulink.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.stream.FileImageInputStream;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.Preferences;
import org.osate.importer.model.Component;
import org.osate.importer.model.Model;
import org.osate.importer.model.Component.ComponentType;
import org.osate.importer.model.sm.State;
import org.osate.importer.model.sm.StateMachine;
import org.osate.importer.model.sm.Transition;
import org.osate.importer.simulink.FileImport;
import org.osate.importer.simulink.StateFlowInstance;


public class AadlProjectCreator
{

	/**
	 * Create all directories required to store the model
	 * and the necessary files.
	 * @param outputPath the path that will contain all the model
	 * and related resources.
	 */
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







	public static void createAadlFunctions (String outputFile, Model genericModel)
	{
		FileWriter fstream;
		BufferedWriter out;


		try
		{	 
			fstream = new FileWriter(outputFile);
			out = new BufferedWriter(fstream);

			out.write ("package "+Preferences.getPackagePrefix()+"imported::functions\n");

			out.write ("public\n");

			out.write ("with SEI;\n");
			out.write ("with ARINC653;\n");


			for (Component e : genericModel.getComponents())
			{
				if (e.getType() == Component.ComponentType.BLOCK)
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
			}

			out.write ("end "+Preferences.getPackagePrefix()+"imported::functions;\n");

			out.close();
			fstream.close();

		}
		catch (Exception e)
		{
			OsateDebug.osateDebug("Error: " + e.getMessage());
			e.printStackTrace();
		}



	}


	public static void createAadlRuntime (String outputFile, Model genericModel)
	{
		FileWriter fstream;
		BufferedWriter out;
		int tmp;
		boolean connectionPreamble;
		StateMachine sm;
		StateFlowInstance sfi;
		connectionPreamble = false;

		try
		{	 
			fstream = new FileWriter(outputFile);
			out = new BufferedWriter(fstream);

			out.write ("package "+Preferences.getPackagePrefix()+"imported::runtime\n");

			out.write ("public\n");
			out.write ("with "+Preferences.getPackagePrefix()+"runtime::common;\n");
			out.write ("with "+Preferences.getPackagePrefix()+"imported::functions;\n");
			out.write ("with SEI;\n");
			out.write ("with Data_Model;\n");
			out.write ("with ARINC653;\n\n\n");

			out.write ("data generictype\nproperties\n   Data_Model::Data_Representation => integer;\nend generictype;\n\n\n");

			out.write ("data generictype_boolean\nproperties\n   Data_Model::Data_Representation => boolean;\nend generictype_boolean;\n\n\n");


			for (Component e : genericModel.getComponents())
			{
				if (e.getType() != Component.ComponentType.BLOCK)
				{
					continue;
				}

				/**
				 * Try to find if we have a corresponding state machine
				 * for this component.
				 */
				sm = null;
				sfi = FileImport.getStateFlowImport (e.getAadlName());

				if (sfi != null) 
				{
					sm = genericModel.getStateMachine (sfi.getMachineId());
				}

				/**
				 * Let's generate the subprogram for the nested state
				 * machines of the current component.
				 */
				if ((sm != null ) && (sm.hasNestedStateMachines()))
				{
					for (State s : sm.getStates())
					{
						if (! s.getInternalStateMachine().isEmpty())
						{
							out.write ("system "+s.getName()+"\n");
							if (s.getInternalStateMachine().hasVariables())
							{
								out.write("features\n");
								for (String var : s.getInternalStateMachine().getVariables())
								{
									out.write("   ");
									out.write(var);
									out.write(" : requires data access ");
									if (s.getInternalStateMachine().getVariableType(var) == StateMachine.VARIABLE_TYPE_BOOL)
									{
										out.write("generictype_boolean");
									}
									else
									{
										out.write("generictype");
									}
									out.write(";\n");
								}
							}
							out.write ("end " + s.getName() + ";\n\n\n");


							out.write ("system implementation "+s.getName()+".i\n");
							Utils.writeBehaviorAnnex (s.getInternalStateMachine(), out);
							out.write ("end " + s.getName() + ".i;\n\n\n");
						}
					}
				}


				/**
				 * Write the main system component.
				 */
				out.write ("system s_"+e.getAadlName()+"\n");
				//					if ( (e.getIncomingDependencies().size() > 0 )||
				//							(e.getOutgoingDependencies().size() > 0 )||
				//							((e.getSubEntities().size() > 0) && (((e.getSubEntities().get(0).getIncomingDependencies().size() > 0) 
				//									||
				//									(e.getSubEntities().get(0).getOutgoingDependencies().size() > 0)))))

				if (e.hasInterfaces())
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
				
				for (Component e2 : e.getSubcomponents(ComponentType.EXTERNAL_OUTPORT))
				{
					out.write ("   " + e2.getAadlName()+" : out event data port generictype;\n");
				}
				
				for (Component e2 : e.getSubcomponents(ComponentType.EXTERNAL_INPORT))
				{
					out.write ("   " + e2.getAadlName()+" : in event data port generictype;\n");
				}
				
				out.write ("end s_"+ e.getAadlName() + ";\n\n");

				out.write ("system implementation s_"+e.getAadlName()+".i\n");

				int connectionId = 0;

				/**
				 * Add all the subcomponents of the current component.
				 * We consider subcomponents are sub-entities that have 
				 * the type "block".
				 */
				if (e.hasSubcomponents())
				{
					out.write ("subcomponents\n");
					for (Component c : e.getSubcomponents(ComponentType.BLOCK))
					{
						out.write ("   " + c.getAadlName() + " : system s_" + c.getAadlName() + ".i;\n");
					}
				}


				if (sm != null)
				{


					if (sm.hasVariables() || sm.nestedStateMachinehasVariables() || sm.hasNestedStateMachines())
					{
						out.write ("subcomponents\n");
					}

					Utils.writeSubprogramSubcomponents (sm, out, new ArrayList<String>());

					/**
					 * Let's call the other subprogram that contains
					 * the sub state machines. Then, if these
					 * state machines share data, we need to
					 * add data components and connect them. 
					 */

					if (sm.hasNestedStateMachines())
					{

						for (State s : sm.getStates())
						{
							if (! s.getInternalStateMachine().isEmpty())
							{
								out.write ("      call_"+s.getName()+" : system "+s.getName() + ".i;\n");

							}
						}
					}


					/**
					 * 
					 * Connect the data components shared among the different subprograms
					 * using data access connections.
					 */
					if (sm.nestedStateMachinehasVariables())
					{

						out.write ("connections\n");
						for (State state : sm.getStates())
						{
							for (String var : state.getInternalStateMachine().getVariables())
							{
								out.write ("   c" + connectionId++ + " : data access "+ var + "-> call_"+state.getName()+"." + var + ";\n");

							}
						}
					}
				}
				out.write ("end s_"+ e.getAadlName() + ".i;\n\n");
			}
			/**
			 * End of generating the main system component.
			 */


			out.write ("processor module extends "+Preferences.getPackagePrefix()+"runtime::common::module\n");
			out.write ("end module;\n");

			out.write ("processor implementation module.i\n");
			if (Preferences.useArinc())
			{
				out.write ("subcomponents\n");
				for (Component e : genericModel.getComponents())
				{
					if (e.getParent() == null)
					{
						out.write ("	"+e.getAadlName()+" : virtual processor runtime::common::partition.i {ARINC653::Criticality => LEVEL_C;};\n");
					}
				}
				out.write ("properties\n");
				out.write ("	ARINC653::Module_Major_Frame => "+genericModel.getComponents() + 100+"ms;\n");
				out.write ("	ARINC653::Partition_Slots => (");
				boolean firstWritten = false;
				for (Component e : genericModel.getComponents())
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
				for (Component e : genericModel.getComponents())
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

			out.write ("memory ram extends "+Preferences.getPackagePrefix()+"runtime::common::ram\n");
			out.write ("end ram;\n");

			out.write ("memory implementation ram.i\n");
			if (Preferences.useArinc())
			{
				out.write ("subcomponents\n");
				for (Component e : genericModel.getComponents())
				{
					if (e.getParent() == null)
					{
						out.write ("   "+e.getAadlName()+" : memory runtime::common::segment.i;\n");

					}
				}
			}
			out.write ("end ram.i;\n");


			out.write("system mainsystem\n");
			boolean featuresDeclared = false;
			for (Component e : genericModel.getComponents())
			{
				if (e.getType() == Component.ComponentType.EXTERNAL_INPORT)
				{
					if (! featuresDeclared)
					{
						out.write("features\n");
						featuresDeclared = true;
					}
					out.write ("   "+e.getAadlName()+" : in event data port generictype;\n");
				}
				if (e.getType() == Component.ComponentType.EXTERNAL_OUTPORT)
				{
					if (! featuresDeclared)
					{
						out.write("features\n");
						featuresDeclared = true;
					}
					out.write ("   "+e.getAadlName()+" : out event data port generictype;\n");
				}
			}
			out.write("end mainsystem;\n\n\n");

			out.write("system implementation mainsystem.i\n");
			out.write("subcomponents\n");
			for (Component e : genericModel.getComponents())
			{
				if ((e.getParent() == null) && (e.getType() == Component.ComponentType.BLOCK))
				{
					out.write ("   "+e.getAadlName()+" : system s_"+e.getAadlName()+".i;\n");

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

			int connectionId = 0;
			for (Component e : genericModel.getComponents())
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
					if ((e.getType() == Component.ComponentType.BLOCK) && (e2.getType() == Component.ComponentType.BLOCK))
					{
						out.write("   c" + connectionId++ +" : port " + e.getAadlName() + ".to_" + e2.getAadlName() + "->" +  e2.getAadlName() + ".from_" + e.getAadlName() +";\n");
					}
					if ((e.getType() == Component.ComponentType.EXTERNAL_INPORT) && (e2.getType() == Component.ComponentType.BLOCK))
					{
						out.write("   c" + connectionId++ +" : port " + e.getAadlName() + "->" +  e2.getAadlName() + ".from_" + e.getAadlName() +";\n");
					}
					if ((e.getType() == Component.ComponentType.BLOCK) && (e2.getType() == Component.ComponentType.EXTERNAL_OUTPORT))
					{
						out.write("   c" + connectionId++ +" : port " + e.getAadlName() + ".to_" + e2.getAadlName() + "->" +  e2.getAadlName() +";\n");
					}
				}
			}

			out.write("properties\n");
			for (Component e : genericModel.getComponents())
			{
				if((e.getParent() != null) || (e.getType() != Component.ComponentType.BLOCK))
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


			out.write("end "+Preferences.getPackagePrefix()+"imported::runtime; \n");

			out.close();
			fstream.close();

		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
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

			out.write("package "+Preferences.getPackagePrefix()+"runtime::common\n");

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

			out.write("end "+Preferences.getPackagePrefix()+"runtime::common;\n");

			out.close();
			fstream.close();

		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}



	}


	public static void createProject (String outputPath, Model genericModel)
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
		createAadlFunctions (outputFileFunctional, genericModel);

		OsateDebug.osateDebug ("Create AADL runtime  project in " + outputFileRuntime);
		createAadlRuntime (outputFileRuntime,genericModel);

	}

}
