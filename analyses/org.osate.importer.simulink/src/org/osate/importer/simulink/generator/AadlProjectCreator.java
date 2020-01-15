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

package org.osate.importer.simulink.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.model.Component;
import org.osate.importer.model.Component.ComponentType;
import org.osate.importer.model.Connection;
import org.osate.importer.model.Model;
import org.osate.importer.model.sm.State;
import org.osate.importer.model.sm.StateMachine;
import org.osate.importer.simulink.FileImport;
import org.osate.importer.simulink.StateFlowInstance;

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

		try {
			fstream = new FileWriter(outputFile);
			out = new BufferedWriter(fstream);

			out.write("package " + genericModel.getName() + "::imported::functions\n");

			out.write("public\n");

			out.write("with SEI;\n");
			out.write("with ARINC653;\n");

			for (Component e : genericModel.getComponents()) {
				if (e.getType() == Component.ComponentType.BLOCK) {
					out.write("abstract " + e.getAadlName() + "\n");
					if ((e.getIncomingDependencies().size() > 0) || (e.getOutgoingDependencies().size() > 0)) {
						out.write("features\n");
						for (Component e2 : e.getIncomingDependencies()) {
							out.write("   from_" + e2.getAadlName() + " : in event port;\n");
						}
						for (Component e2 : e.getOutgoingDependencies()) {
							out.write("   to_" + e2.getAadlName() + " : out event port;\n");
						}
					}
					out.write("end " + e.getAadlName() + ";\n");
				}
			}

			out.write("end " + genericModel.getName() + "::imported::functions;\n");

			out.close();
			fstream.close();

		} catch (Exception e) {
			OsateDebug.osateDebug("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void createAadlRuntime(String outputFile, Model genericModel) {
		FileWriter fstream;
		BufferedWriter out;
		int tmp;
		boolean connectionPreamble;
		boolean subComponentsPreambleWritten;
		StateMachine sm;
		StateFlowInstance sfi;
		connectionPreamble = false;
		subComponentsPreambleWritten = false;
		try {
			fstream = new FileWriter(outputFile);
			out = new BufferedWriter(fstream);

			out.write("package " + genericModel.getName() + "::imported::runtime\n");

			out.write("public\n");
			out.write("with " + genericModel.getName() + "::imported::functions;\n");
			out.write("with SEI;\n");
			out.write("with Data_Model;\n");

			List<String> importedPackages = new ArrayList<String>();

			/**
			 * We import all the packages that are used by referenced components
			 */
			for (Component c : genericModel.getComponents()) {
				if (c.getType() == ComponentType.REFERENCE) {
					String pkgName = c.getAadlReferencedModel();
					boolean found = false;

					for (String pkgTmp : importedPackages) {
						OsateDebug.osateDebug("AadlProjectCreator", "pkg=" + pkgTmp);
						if (pkgTmp.equalsIgnoreCase(pkgName)) {
							found = true;
						}
					}

					if (!found) {
						out.write("with " + pkgName + "::imported::runtime;\n");
						importedPackages.add(pkgName);
					}
				}
			}

			out.write("\n\n");

			out.write(
					"data generictype\nproperties\n   Data_Model::Data_Representation => integer;\nend generictype;\n\n\n");

			out.write(
					"data generictype_boolean\nproperties\n   Data_Model::Data_Representation => boolean;\nend generictype_boolean;\n\n\n");

			for (Component e : genericModel.getComponents()) {
				if (e.getType() != Component.ComponentType.BLOCK) {
					continue;
				}

				/**
				 * Try to find if we have a corresponding state machine
				 * for this component.
				 */
				sm = null;
				sfi = FileImport.getStateFlowImport(e.getAadlName());

				if (sfi != null) {
					OsateDebug.osateDebug("AadlProjectCreator", "machine-id=" + sfi.getMachineId());
					sm = genericModel.getStateMachine(sfi.getMachineId());
				}

				/**
				 * Let's generate the subprogram for the nested state
				 * machines of the current component.
				 */
				if ((sm != null) && (sm.hasNestedStateMachines())) {
					for (State s : sm.getStates()) {
						if (!s.getInternalStateMachine().isEmpty()) {
							out.write("system " + s.getName() + "\n");
							if (s.getInternalStateMachine().hasVariables()) {
								out.write("features\n");
								for (String var : s.getInternalStateMachine().getVariables()) {
									out.write("   ");
									out.write(var);
									out.write(" : requires data access ");
									if (s.getInternalStateMachine()
											.getVariableType(var) == StateMachine.VARIABLE_TYPE_BOOL) {
										out.write("generictype_boolean");
									} else {
										out.write("generictype");
									}
									out.write(";\n");
								}
							}
							out.write("end " + s.getName() + ";\n\n\n");

							out.write("system implementation " + s.getName() + ".i\n");
							Utils.writeBehaviorAnnex(s.getInternalStateMachine(), out);
							out.write("end " + s.getName() + ".i;\n\n\n");
						}
					}
				}

				/**
				 * Write the main system component.
				 */
				out.write("system s_" + e.getAadlName() + "\n");
				// if ( (e.getIncomingDependencies().size() > 0 )||
				// (e.getOutgoingDependencies().size() > 0 )||
				// ((e.getSubEntities().size() > 0) && (((e.getSubEntities().get(0).getIncomingDependencies().size() >
// 0)
				// ||
				// (e.getSubEntities().get(0).getOutgoingDependencies().size() > 0)))))

				if (e.hasInterfaces()) {
					out.write("features\n");
				}
				for (Component e2 : e.getIncomingDependencies()) {
					out.write("   from_" + e2.getAadlName() + " : in event data port generictype;\n");
				}

				for (Component e2 : e.getOutgoingDependencies()) {
					out.write("   to_" + e2.getAadlName() + " : out event data port generictype;\n");
				}

				for (Component e2 : e.getSubcomponents(ComponentType.EXTERNAL_OUTPORT)) {
					out.write("   " + e2.getAadlName() + " : out event data port generictype;\n");
				}

				for (Component e2 : e.getSubcomponents(ComponentType.EXTERNAL_INPORT)) {
					out.write("   " + e2.getAadlName() + " : in event data port generictype;\n");
				}

				out.write("end s_" + e.getAadlName() + ";\n\n");

				out.write("system implementation s_" + e.getAadlName() + ".i\n");

				/**
				 * Add all the subcomponents of the current component.
				 * We consider subcomponents are sub-entities that have 
				 * the type "block".
				 */
				if (e.hasSubcomponents()) {
					out.write("subcomponents\n");
					subComponentsPreambleWritten = true;
					for (Component c : e.getSubcomponents(ComponentType.BLOCK)) {
						out.write("   " + c.getAadlName() + " : system s_" + c.getAadlName() + ".i;\n");
					}
					for (Component c : e.getSubcomponents(ComponentType.REFERENCE)) {
						out.write("   " + c.getAadlName() + " : system " + c.getAadlReferencedModel()
								+ "::imported::runtime::s_" + c.getAadlReferencedComponent() + ".i;\n");
					}
				}

				int connectionId = 0;
				connectionPreamble = false;
				/**
				 * Here, we try to catch all connections with our external features.
				 */

				for (Connection conn : genericModel.getConnections()) {
					/**
					 * Case of an IN port connected to a subcomponent.
					 */
					if ((conn.getSource().getParent() != null) && (conn.getSource().getParent() == e)
							&& (conn.getDestination().getParent() != null)
							&& (conn.getDestination().getParent().getParent() != null)
							&& (conn.getDestination().getParent().getParent() == e)) {
						if (!connectionPreamble) {
							connectionPreamble = true;
							out.write("connections\n");
						}
						out.write("   cin" + connectionId++ + "  : port " + conn.getSource().getAadlName() + "->"
								+ conn.getDestination().getParent().getAadlName() + "."
								+ conn.getDestination().getAadlName() + ";\n");

					}

					/**
					 * Case of an OUT port connected to a subcomponent.
					 */
					if ((conn.getDestination().getParent() != null) && (conn.getDestination().getParent() == e)
							&& (conn.getSource().getParent() != null)
							&& (conn.getSource().getParent().getParent() != null)
							&& (conn.getSource().getParent().getParent() == e)) {
						if (!connectionPreamble) {
							connectionPreamble = true;
							out.write("connections\n");
						}
						out.write("   cout" + connectionId++ + " : port " + conn.getSource().getParent().getAadlName()
								+ "." + conn.getSource().getAadlName() + "->" + conn.getDestination().getAadlName()
								+ ";\n");

					}
				}

//				
//				for (Component subco : e.getSubcomponents(ComponentType.EXTERNAL_OUTPORT))
//				{
//					for (Connection conn : genericModel.getConnections())
//					{
//						if (conn.getDestination() == subco) 
//						{
//							if (!connectionPreamble)
//							{
//								connectionPreamble = true;
//								out.write("connections\n");
//							}
//							out.write("   c" + connectionId++ +" : port " +  conn.getDestination().getParent().getAadlName() + "." + conn.getDestination().getAadlName() + " -> " + subco.getAadlName() + ";\n");
//
//						}
//					}
//				}

				if (sm != null) {

					Utils.writeSubprogramSubcomponents(sm, e, out, new ArrayList<String>(),
							subComponentsPreambleWritten);

					/**
					 * Let's call the other subprogram that contains
					 * the sub state machines. Then, if these
					 * state machines share data, we need to
					 * add data components and connect them. 
					 */

					if (sm.hasNestedStateMachines()) {

						for (State s : sm.getStates()) {
							if (!s.getInternalStateMachine().isEmpty()) {
								out.write("      call_" + s.getName() + " : system " + s.getName() + ".i;\n");

							}
						}
					}

					/**
					 * 
					 * Connect the data components shared among the different subprograms
					 * using data access connections.
					 */
					if (sm.nestedStateMachinehasVariables()) {

						out.write("connections\n");
						for (State state : sm.getStates()) {
							for (String var : state.getInternalStateMachine().getVariables()) {
								/**
								 * Generate the data access if there is a data (in other words,
								 * if we do not have an existing feature that represent the data).
								 */
								if (e.getSubEntity(var.toLowerCase()) == null) {
									out.write("   c" + connectionId++ + " : data access " + var + "-> call_"
											+ state.getName() + "." + var + ";\n");
								}
							}
						}
					}
				}
				if (sm != null) {
					Utils.writeBehaviorAnnex(sm, out);
				}
				out.write("end s_" + e.getAadlName() + ".i;\n\n");
			}
			/**
			 * End of generating the main system component.
			 */

			out.write("system mainsystem\n");
			boolean featuresDeclared = false;
			for (Component e : genericModel.getComponents()) {
				if (e.getParent() != null) {
					continue;
				}

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
			connectionPreamble = false;
			/**
			 * Here, we try to catch all connections with our external features.
			 */
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

				}
			}

			/**
			 * Here, we try to catch all potential connections
			 * between subcomponents
			 */
			for (Connection c : genericModel.getConnections()) {
				if ((c.getSource().getType() == ComponentType.EXTERNAL_OUTPORT) && (c.getSource().getParent() != null)
						&& (c.getSource().getParent().getParent() == null)
						&& (c.getDestination().getType() == ComponentType.EXTERNAL_INPORT)
						&& (c.getDestination().getParent() != null)
						&& (c.getDestination().getParent().getParent() == null)) {
					if (!connectionPreamble) {
						connectionPreamble = true;
						out.write("connections\n");
					}
					out.write("   c" + connectionId++ + " : port " + c.getSource().getParent().getAadlName() + "."
							+ c.getSource().getAadlName() + "->" + c.getDestination().getParent().getAadlName() + "."
							+ c.getDestination().getAadlName() + ";\n");

				}
			}

			out.write("end mainsystem.i; \n");

			out.write("end " + genericModel.getName() + "::imported::runtime; \n");

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
		String outputFileGenericRuntime;

		outputPathFunctional = outputPath + File.separatorChar + "functional";
		outputPathRuntime = outputPath + File.separatorChar + "runtime";
		outputFileFunctional = outputPathFunctional + File.separatorChar + "functional.aadl";
		outputFileRuntime = outputPathRuntime + File.separatorChar + "runtime.aadl";

		createDirectories(outputPath);

//		OsateDebug.osateDebug ("Create AADL functional project in " + outputFileFunctional);
		createAadlFunctions(outputFileFunctional, genericModel);

//		OsateDebug.osateDebug ("Create AADL runtime  project in " + outputFileRuntime);
		createAadlRuntime(outputFileRuntime, genericModel);

	}

}
