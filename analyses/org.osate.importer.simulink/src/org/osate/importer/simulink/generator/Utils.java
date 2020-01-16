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
import java.io.IOException;
import java.util.List;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.model.Component;
import org.osate.importer.model.sm.State;
import org.osate.importer.model.sm.StateMachine;
import org.osate.importer.model.sm.Transition;

public class Utils {

	public static void writeSubprogramSubcomponents(StateMachine sm, Component associatedComponent, BufferedWriter out,
			List<String> existingSubcomponents, boolean subComponentsPreambleWritten) throws IOException {

		if (sm.getVariables().size() > 0) {
			for (String var : sm.getVariables()) {
				if (existingSubcomponents.contains(var)) {
					continue;
				}

				if ((associatedComponent != null) && (associatedComponent.getSubEntity(var) != null)) {
					continue;
				}

				if (!subComponentsPreambleWritten) {
					out.write("subcomponents\n");
					subComponentsPreambleWritten = true;
				}

				/**
				 * Generate the data access if there is a data (in other words,
				 * if we do not have an existing feature that represent the data).
				 */
				if ((associatedComponent != null) && (associatedComponent.getSubEntity(var.toLowerCase()) != null)) {
					continue;
				}

				existingSubcomponents.add(var);
				out.write("   " + var + " : data ");

				if (sm.getVariableType(var) == StateMachine.VARIABLE_TYPE_BOOL) {
					out.write("generictype_boolean;\n");
				} else {
					out.write("generictype;\n");
				}
			}
		}

		/**
		 * Here, we try to see if we need to declare variables
		 * from the nested statemachine.
		 */
		if (sm.hasNestedStateMachines()) {
			for (State s : sm.getStates()) {
				writeSubprogramSubcomponents(s.getInternalStateMachine(), associatedComponent, out,
						existingSubcomponents, subComponentsPreambleWritten);
			}
		}
	}

	public static void writeBehaviorAnnex(StateMachine sm, BufferedWriter out) throws IOException {
//		OsateDebug.osateDebug("WE GOT TWO !");
		out.write("annex behavior_specification {**\n");

		if (sm.getStates().size() > 0) {
			boolean sectionStatesDeclared = false;

			for (State state : sm.getStates()) {
				if ((!state.getInternalStateMachine().isEmpty()) || (!state.isValid())) {
					continue;
				}

				if (sectionStatesDeclared == false) {
					out.write("states\n");
					sectionStatesDeclared = true;
				}

				if (state.isValid() && sm.isInitialState(state)) {
					out.write("   " + state.getName() + ": initial final state;\n");
				}

				if (state.isValid() && (!sm.isInitialState(state))) {
					out.write("   " + state.getName() + ": state;\n");
				}
			}
		}

		if (sm.getTransitions().size() > 0) {
			int transitionId = 0;
			out.write("transitions\n");
			for (Transition t : sm.getTransitions()) {
				State src = t.getSrcState();
				State dst = t.getDstState();
				if ((src != null) && (dst != null) && src.isValid() && dst.isValid()) {

					out.write("   t" + transitionId++ + " : " + src.getName() + "-[" + t.getCondition() + "]->"
							+ dst.getName());

					if ((dst.hasEntrypoint()) || (t.getAction().length() > 0)) {
						out.write("{");
						if (dst.hasEntrypoint()) {
							out.write(dst.getEntrypoint());
						}
						if (t.getAction().length() > 0) {
							out.write("{" + t.getAction() + "}");
						}
						out.write("}");
					}
					out.write(";\n");

				}
			}
		}
		out.write("**};\n");
	}
}
