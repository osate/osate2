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
