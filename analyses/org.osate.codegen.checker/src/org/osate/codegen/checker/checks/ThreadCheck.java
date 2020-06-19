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

package org.osate.codegen.checker.checks;

import java.util.List;
import java.util.stream.Collectors;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.codegen.checker.report.ErrorReport;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class ThreadCheck extends AbstractCheck {

	@Override
	public void perform(SystemInstance si) {

		final List<ComponentInstance> allThreads = si.getAllComponentInstances()
				.stream()
				.filter(comp -> (comp.getCategory() == ComponentCategory.THREAD))
				.collect(Collectors.toList());

		/**
		 * Each thread needs to specify the dispatch protocol "periodic" or
		 * "sporadic"
		 */
		allThreads.stream().filter(comp -> {
			EnumerationLiteral protocol = GetProperties.getDispatchProtocol(comp);
			return protocol == null || !(protocol.toString().equalsIgnoreCase(AadlProject.PERIODIC_LITERAL)
					|| protocol.toString().equalsIgnoreCase(AadlProject.SPORADIC_LITERAL));
		})
				.forEach(thr -> addError(new ErrorReport(thr,
						"Thread needs a Thread_Properties::Dispatch_Protocol property of 'Periodic' or 'Sporadic'")));

		/**
		 * Each thread needs to specify period
		 */
		final List<ComponentInstance> threadMissingPeriod = allThreads.stream()
				.filter(comp -> (GetProperties.getPeriodinMS(comp) == 0.0))
				.collect(Collectors.toList());
		for (ComponentInstance thr : threadMissingPeriod) {
			addError(new ErrorReport(thr, "Thread must define the property Timing_Properties::Period"));
		}

		final List<ComponentInstance> threadMissingDeadline = allThreads.stream()
				.filter(comp -> (GetProperties.getDeadlineinMilliSec(comp) == 0.0))
				.collect(Collectors.toList());
		for (ComponentInstance thr : threadMissingDeadline) {
			addError(new ErrorReport(thr, "Thread must define the property Timing_Properties::Deadline"));
		}

		for (ComponentInstance ci : allThreads) {
			ComponentClassifier cc = ci.getComponentClassifier();
			if (cc instanceof ThreadImplementation) {
				ThreadImplementation ti = (ThreadImplementation) cc;
				for (SubprogramCall sc : ti.getSubprogramCalls()) {
					NamedElement cs = (NamedElement) sc.getCalledSubprogram();

					if (GetProperties.getSourceName(cs) == null) {
						addError(new ErrorReport(cs,
								"Subprogram must define the property Programming_Properties::Source_Name"));
					}

					if (GetProperties.getSourceText(cs).size() == 0) {
						addError(new ErrorReport(cs,
								"Subprogram must define the property Programming_Properties::Source_Text"));
					}

					if (GetProperties.getSourceLanguage(cs).size() == 0) {
						addError(new ErrorReport(cs,
								"Subprogram must define the property Programming_Properties::Source_Language"));
					}
				}
			}

		}

		/**
		 * FIXME JD Each thread needs to specify execution time
		 */
		// List<ComponentInstance> threadMissingExecutionTime =
		// (List<ComponentInstance>) si.getAllComponentInstances().stream().
		// filter( comp -> (comp.getCategory() == ComponentCategory.THREAD) &&
		// (GetProperties.get > 0.0));
		// for (ComponentInstance thr : threadMissingPeriod)
		// {
		// addError (new ErrorReport (thr, "Thread needs to define a period"));
		// }
	}

}
