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

package org.osate.importer.scade.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.model.Component;
import org.osate.importer.model.Component.ComponentType;
import org.osate.importer.model.Component.PortType;
import org.osate.importer.model.Connection;
import org.osate.importer.model.Model;
import org.osate.importer.model.sm.State;
import org.osate.importer.model.sm.StateMachine;

public class AadlProjectCreator {

	/**
	 * Create all directories required to store the model
	 * and the necessary files.
	 * @param outputPath the path that will contain all the model
	 * and related resources.
	 */
	public static void createDirectories(String outputPath) {
		String outputPathFunctional;
		String outputPathRuntime;
		File ftmp;

		outputPathFunctional = outputPath + File.separatorChar + "functional";
		outputPathRuntime = outputPath + File.separatorChar + "runtime";

		ftmp = new File(outputPathFunctional);

		if (ftmp.exists() && ftmp.isFile()) {
			OsateDebug.osateDebug("Error, the following path is a file" + outputPathFunctional);
		}

		if (!ftmp.exists()) {
			ftmp.mkdir();
		}

		ftmp = new File(outputPathRuntime);

		if (ftmp.exists() && ftmp.isFile()) {
			OsateDebug.osateDebug("Error, the following path is a file" + outputPathRuntime);
		}

		if (!ftmp.exists()) {
			ftmp.mkdir();
		}
	}

	public static void createAadlFunctions(String outputFile, Model genericModel) {
		FileWriter fstream;
		BufferedWriter out;
		String aadlPackagePrefix;

		aadlPackagePrefix = "";

		if (genericModel.getPackageName() != null) {
			aadlPackagePrefix = genericModel.getPackageName() + "::";
		}

		try {
			fstream = new FileWriter(outputFile);
			out = new BufferedWriter(fstream);

			out.write("package " + aadlPackagePrefix + "imported::functions\n");

			out.write("public\n");

			out.write("with SEI;\n");
			out.write("with ARINC653;\n");

			for (Component e : genericModel.getComponents()) {
				if (e.getType() == Component.ComponentType.BLOCK) {
					out.write("abstract " + e.getAadlName() + "\n");
					if (e.hasInterfaces()) {
						out.write("features\n");
						for (Component e2 : e.getSubEntities()) {
							if (e2.getType() == ComponentType.EXTERNAL_INPORT) {
								out.write("   " + e2.getAadlName() + " : in event port;\n");
							}
							if (e2.getType() == ComponentType.EXTERNAL_OUTPORT) {
								out.write("   " + e2.getAadlName() + " : out event port;\n");
							}
						}
						for (Component e2 : e.getIncomingDependencies()) {
							out.write("   from_" + e2.getAadlName() + " : in event port;\n");
						}
						for (Component e2 : e.getOutgoingDependencies()) {
							out.write("   to_" + e2.getAadlName() + " : out event port;\n");
						}
					}
					out.write("properties\n");
					out.write("   SEI::nsloc => 100;\n");
					out.write("end " + e.getAadlName() + ";\n");
				}
			}

			out.write("end " + aadlPackagePrefix + "imported::functions;\n");

			out.close();
			fstream.close();

		} catch (Exception e) {
			OsateDebug.osateDebug("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void writeInnerStateMachine(StateMachine sm, BufferedWriter out) throws IOException {

		for (State s : sm.getStates()) {
			if (!s.getInternalStateMachine().isEmpty()) {
				out.write("system " + s.getName() + "\n");
				if (s.getInternalStateMachine().hasVariables()) {
					out.write("features\n");
					for (String var : s.getInternalStateMachine().getVariables()) {
						out.write("   ");
						out.write(var);
						out.write(" : in event data port ");
						if (s.getInternalStateMachine().getVariableType(var) == StateMachine.VARIABLE_TYPE_BOOL) {
							out.write("generictype_boolean");
						} else {
							out.write("generictype");
						}
						out.write(";\n");
					}
				}
				out.write("end " + s.getName() + ";\n\n\n");

				out.write("system implementation " + s.getName() + ".i\n");
				if (!s.getInternalStateMachine().isEmpty()) {
					boolean subcomponentSectionWritten = false;

					for (State s2 : s.getInternalStateMachine().getStates()) {
						if (!s2.getInternalStateMachine().isEmpty()) {
							if (!subcomponentSectionWritten) {
								out.write("subcomponents\n");
								subcomponentSectionWritten = true;
							}
							out.write("   " + s2.getName() + " : system " + s2.getName() + ".i;\n");
						}
					}
				}
				Utils.writeBehaviorAnnex(s.getInternalStateMachine(), out);
				out.write("end " + s.getName() + ".i;\n\n\n");

				writeInnerStateMachine(s.getInternalStateMachine(), out);

			}
		}

	}

	public static void createAadlRuntime(String outputFile, Model genericModel) {
		FileWriter fstream;
		BufferedWriter out;
		int tmp;
		String aadlPackagePrefix;
		boolean connectionPreamble;
		connectionPreamble = false;
		aadlPackagePrefix = "";
		try {
			fstream = new FileWriter(outputFile);
			out = new BufferedWriter(fstream);

			if (genericModel.getPackageName() != null) {
				aadlPackagePrefix = genericModel.getPackageName() + "::";
			}

			out.write("package " + aadlPackagePrefix + "imported::runtime\n");

			out.write("public\n");
			out.write("with " + aadlPackagePrefix + "imported::functions;\n");
			out.write("with SEI;\n");
			out.write("with Data_Model;\n");

			out.write("data generictype\nproperties\n   Data_Model::Data_Representation => integer;\nend generictype;\n\n\n");

			out.write("data generictype_boolean\nproperties\n   Data_Model::Data_Representation => boolean;\nend generictype_boolean;\n\n\n");

			for (Component e : genericModel.getComponents()) {
				StateMachine stateMachine = null;

				if (e.getStateMachines().size() > 0) {
					stateMachine = e.getStateMachines().get(0);
				}

				if (e.getType() != Component.ComponentType.BLOCK) {
					continue;
				}

				/**
				 * Try to find if we have a corresponding state machine
				 * for this component.
				 */

				/**
				 * Let's generate the subprogram for the nested state
				 * machines of the current component.
				 */
				if (e.getStateMachines().size() > 0) {
					StateMachine sm = e.getStateMachines().get(0);
					if (sm != null) {
						writeInnerStateMachine(sm, out);
					}
				}

				if (e.getParent() == null) {
					out.write("system s_" + e.getAadlName() + "\n");
					if ((e.hasInterfaces())
							|| ((e.getSubEntities().size() > 0) && (((e.getSubEntities().get(0)
									.getIncomingDependencies().size() > 0) || (e.getSubEntities().get(0)
									.getOutgoingDependencies().size() > 0))))) {
						out.write("features\n");
					}
					for (Component e2 : e.getSubEntities()) {
						String direction = "";
						String type = "generictype";
						if ((e2.getType() == ComponentType.EXTERNAL_INPORT)
								|| (e2.getType() == ComponentType.EXTERNAL_OUTPORT)) {
							if (e2.getType() == ComponentType.EXTERNAL_INPORT) {
								direction = " in ";
							}
							if (e2.getType() == ComponentType.EXTERNAL_OUTPORT) {
								direction = " out ";
							}
							if (e2.getPortType() == PortType.BOOL) {
								type = "generictype_boolean";
							}

							out.write("   " + e2.getAadlName() + " : " + direction + " event data port " + type + ";\n");
						}
					}
					for (Component e2 : e.getIncomingDependencies()) {
						out.write("   from_" + e2.getAadlName() + " : in event data port generictype;\n");
					}
					for (Component e2 : e.getOutgoingDependencies()) {
						out.write("   to_" + e2.getAadlName() + " : out event data port generictype;\n");
					}

					out.write("end s_" + e.getAadlName() + ";\n\n");

					out.write("system implementation s_" + e.getAadlName() + ".i\n");

					int connectionId = 0;
					if (((e.getSubEntities().size() > 0) && (((e.getSubEntities().get(0).getIncomingDependencies()
							.size() > 0) || (e.getSubEntities().get(0).getOutgoingDependencies().size() > 0))))) {
						out.write("connections\n");
					}
					// for (Component e2 : e.getIncomingDependencies())
					// {
					// out.write ("   c" + connectionId++
// +" : port from_"+e2.getAadlName()+" -> t_"+e.getAadlName()+".from_"+e2.getAadlName()+";\n");
					// }
					// for (Component e2 : e.getOutgoingDependencies())
					// {
					// out.write ("   c" + connectionId++
// +" : port t_"+e.getAadlName()+".to_"+e2.getAadlName()+" -> to_"+e2.getAadlName()+";\n");
					//
					// }
					boolean subcomponentSectionWritten = false;
					if (e.hasSubcomponents()) {
						if (!subcomponentSectionWritten) {
							out.write("subcomponents\n");
							subcomponentSectionWritten = true;
						}
						for (Component ctmp : e.getSubEntities()) {
							if (ctmp.getType() == ComponentType.BLOCK) {
								out.write("   " + ctmp.getAadlName() + " : system s_" + ctmp.getAadlName() + ";\n");
							}
						}
					}

					if (stateMachine != null) {
						for (State s : stateMachine.getStates()) {
							if (!s.getInternalStateMachine().isEmpty()) {

								if (!subcomponentSectionWritten) {
									out.write("subcomponents\n");
									subcomponentSectionWritten = true;
								}
								out.write("   " + s.getName() + " : system " + s.getName() + ".i;\n");

							}
						}
					}

					boolean connectionsSectionWritten = false;
					int connIdentifier = 0;
					if (e.getConnections().size() > 0) {
						out.write("connections\n");
						connectionsSectionWritten = true;

						for (Connection conn : e.getConnections()) {

							/**
							 * Connection between sub-components.
							 */
							if ((conn.getSource().getType() == ComponentType.EXTERNAL_OUTPORT)
									&& (conn.getDestination().getType() == ComponentType.EXTERNAL_INPORT)) {
								out.write("   conn" + connIdentifier + " : port "
										+ conn.getSource().getParent().getAadlName() + "."
										+ conn.getSource().getAadlName() + " -> "
										+ conn.getDestination().getParent().getAadlName() + "."
										+ conn.getSource().getAadlName() + ";\n");
							}

							/**
							 * Connection from external interfaces to internal sub-components.
							 */
							if (conn.getDestination().getType() == ComponentType.EXTERNAL_OUTPORT) {
								out.write("   conn" + connIdentifier + " : port " + conn.getSource().getAadlName()
										+ "." + conn.getDestination().getAadlName() + " -> "
										+ conn.getDestination().getAadlName() + ";\n");
							}

							/**
							 * Connection from internal sub-components to external interfaces.
							 */
							if (conn.getSource().getType() == ComponentType.EXTERNAL_INPORT) {
								out.write("   conn" + connIdentifier + " : port " + conn.getSource().getAadlName()
										+ " -> " + conn.getDestination().getAadlName() + "."
										+ conn.getSource().getAadlName() + ";\n");
							}

							connIdentifier++;
						}
					}

					if (stateMachine != null) {
						for (State s : stateMachine.getStates()) {
							if (!s.getInternalStateMachine().isEmpty()) {
								for (Component subComponent : e.getSubEntities()) {
									String varName = subComponent.getAadlName();
									if (Utils.needConnection(s.getInternalStateMachine(), varName)) {
										if (!connectionsSectionWritten) {
											out.write("connections\n");
											connectionsSectionWritten = true;
										}

										out.write("   conn" + connIdentifier + " : port " + varName + " -> "
												+ s.getName() + "." + varName + ";\n");
										connIdentifier++;
									}
								}

							}
						}
					}

					if (stateMachine != null) {
						Utils.writeBehaviorAnnex(stateMachine, out);

						// if (stateMachine.hasVariables() || stateMachine.nestedStateMachinehasVariables() ||
// stateMachine.hasNestedStateMachines())
						// {
						// out.write ("subcomponents\n");
						// }
						//
						// Utils.writeSubprogramSubcomponents (stateMachine, out, new ArrayList<String>());
						//
						/**
						 * Let's call the other subprogram that contains
						 * the sub state machines. Then, if these
						 * state machines share data, we need to
						 * add data components and connect them. 
						 */

						// if (sm.hasNestedStateMachines())
						// {
						//
						// for (State s : sm.getStates())
						// {
						// if (! s.getStateMachine().isEmpty())
						// {
						// out.write ("      call_"+s.getName()+" : system "+s.getName() + ".i;\n");
						//
						// }
						// }
						// }

						/**
						 * 
						 * Connect the data components shared among the different subprograms
						 * using data access connections.
						 */
						// if (sm.nestedStateMachinehasVariables())
						// {
						//
						// out.write ("connections\n");
						// for (State state : sm.getStates())
						// {
						// for (String var : state.getStateMachine().getVariables())
						// {
						// out.write ("   c" + connectionId++ + " : data access "+ var + "-> call_"+state.getName()+"."
// + var + ";\n");
						//
						// }
						// }
						// }
					}
					out.write("end s_" + e.getAadlName() + ".i;\n\n");
				}
			}

			out.write("system mainsystem\n");
			boolean featuresDeclared = false;
			for (Component e : genericModel.getComponents()) {
				if (e.getType() == Component.ComponentType.EXTERNAL_INPORT) {
					if (!featuresDeclared) {
						out.write("features\n");
						featuresDeclared = true;
					}
					out.write("   " + e.getAadlName() + " : in event data port generictype;\n");
				}
				if (e.getType() == Component.ComponentType.EXTERNAL_OUTPORT) {
					if (!featuresDeclared) {
						out.write("features\n");
						featuresDeclared = true;
					}
					out.write("   " + e.getAadlName() + " : out event data port generictype;\n");
				}
			}
			out.write("end mainsystem;\n\n\n");

			out.write("system implementation mainsystem.i\n");
			out.write("subcomponents\n");
			for (Component e : genericModel.getComponents()) {
				if ((e.getParent() == null) && (e.getType() == Component.ComponentType.BLOCK)) {
					out.write("   " + e.getAadlName() + " : system s_" + e.getAadlName() + ".i;\n");

				}
			}

			int connectionId = 0;
			for (Component e : genericModel.getComponents()) {
				if (e.getParent() != null) {
					continue;
				}
				for (Component e2 : e.getOutgoingDependencies()) {
					if (!connectionPreamble) {
						connectionPreamble = true;
						out.write("connections\n");
					}
					if ((e.getType() == Component.ComponentType.BLOCK)
							&& (e2.getType() == Component.ComponentType.BLOCK)) {
						out.write("   c" + connectionId++ + " : port " + e.getAadlName() + ".to_" + e2.getAadlName()
								+ "->" + e2.getAadlName() + ".from_" + e.getAadlName() + ";\n");
					}
					if ((e.getType() == Component.ComponentType.EXTERNAL_INPORT)
							&& (e2.getType() == Component.ComponentType.BLOCK)) {
						out.write("   c" + connectionId++ + " : port " + e.getAadlName() + "->" + e2.getAadlName()
								+ ".from_" + e.getAadlName() + ";\n");
					}
					if ((e.getType() == Component.ComponentType.BLOCK)
							&& (e2.getType() == Component.ComponentType.EXTERNAL_OUTPORT)) {
						out.write("   c" + connectionId++ + " : port " + e.getAadlName() + ".to_" + e2.getAadlName()
								+ "->" + e2.getAadlName() + ";\n");
					}
				}
			}

			out.write("end mainsystem.i; \n");

			out.write("end " + aadlPackagePrefix + "imported::runtime; \n");

			out.close();
			fstream.close();

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void createProject(String outputPath, Model genericModel) {
		String outputPathFunctional;
		String outputPathRuntime;
		String outputFileFunctional;
		String outputFileRuntime;
		String prefix = "";
		prefix = genericModel.getPackageName() + "-";
		outputPathFunctional = outputPath + File.separatorChar + "functional";
		outputPathRuntime = outputPath + File.separatorChar + "runtime";
		outputFileFunctional = outputPathFunctional + File.separatorChar + prefix + "functional.aadl";
		outputFileRuntime = outputPathRuntime + File.separatorChar + prefix + "runtime.aadl";

		createDirectories(outputPath);

//		OsateDebug.osateDebug("Create AADL functional project in " + outputFileFunctional);
		createAadlFunctions(outputFileFunctional, genericModel);

//		OsateDebug.osateDebug("Create AADL runtime  project in " + outputFileRuntime);
		createAadlRuntime(outputFileRuntime, genericModel);

	}

}
