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
import org.osate.aadl2.VirtualProcessor;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.codegen.checker.report.ErrorReport;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class ProcessCheck extends AbstractCheck {

	public void perform(SystemInstance si) {

		/**
		 * Get processes that do not have thread
		 */
		final List<ComponentInstance> processWithoutThread = si.getAllComponentInstances().stream()
				.filter(c -> c.getCategory() == ComponentCategory.PROCESS)
				.filter(pr -> pr.getComponentInstances().stream()
						.filter(subco -> subco.getCategory() == ComponentCategory.THREAD).collect(Collectors.toList())
						.size() == 0)
				.collect(Collectors.toList());

		for (ComponentInstance process : processWithoutThread) {
			addError(new ErrorReport(process, "Every Process needs to have at least one thread subcomponent"));
		}

		/**
		 * 
		 * Get Processes that are not bound to a virtual processor/runtime
		 */
		final List<ComponentInstance> processWithoutRuntime = si.getAllComponentInstances().stream()
				.filter(comp -> comp.getCategory() == ComponentCategory.PROCESS
						&& !(GetProperties.getBoundProcessor(comp) instanceof VirtualProcessor))
				.collect(Collectors.toList());

		for (ComponentInstance process : processWithoutRuntime) {
			addError(new ErrorReport(process,
					"Process must be bound to a Virtual Processor through the property Deployment_Properties::Actual_Processor_Binding"));
		}

		/**
		 * Get processes that are not bound to a memory
		 */

		final List<ComponentInstance> processWithoutMemory = si.getAllComponentInstances().stream()
				.filter(comp -> (comp.getCategory() == ComponentCategory.PROCESS)
						&& (GetProperties.getActualMemoryBinding(comp) == null))
				.collect(Collectors.toList());

		for (ComponentInstance process : processWithoutMemory) {
			addError(new ErrorReport(process,
					"Process must define the property Deployment_Properties::Actual_Memory_Binding"));
		}
	}

}
