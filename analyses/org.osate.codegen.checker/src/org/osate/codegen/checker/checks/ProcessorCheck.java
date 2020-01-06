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
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.codegen.checker.report.ErrorReport;
import org.osate.codegen.checker.utils.PokProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class ProcessorCheck extends AbstractCheck {

	@Override
	public void perform(SystemInstance si) {

		/**
		 * processor needs to define their schedule
		 */
		if (vxworks() || deos()) {
			final List<ComponentInstance> badProcessors = si.getAllComponentInstances().stream()
					.filter(comp -> comp.getCategory() == ComponentCategory.PROCESSOR)
					.filter(cpu -> GetProperties.getModuleSchedule(cpu).size() == 0).collect(Collectors.toList());

			for (ComponentInstance cpu : badProcessors) {
				addError(new ErrorReport(cpu, "Processor must define the property ARINC653::Module_Schedule"));
			}
		}

		/**
		 * For vxworks, we need to check that the Source_Name property is
		 * defined on each virtual processor.
		 */
		if (vxworks()) {
			final List<ComponentInstance> virtualProcessorsWithoutSourceName = si
					.getAllComponentInstances(ComponentCategory.VIRTUAL_PROCESSOR).stream()
					.filter(comp -> ((comp.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
							&& (GetProperties.getSourceName(comp) == null)))
					.collect(Collectors.toList());
			for (ComponentInstance vp : virtualProcessorsWithoutSourceName) {
				addError(new ErrorReport(vp,
						"Virtual Processor must define the property Programming_Properties::Source_Name"));
			}
		}

		/**
		 * For vxworks, we need to check that the Source_Name property is
		 * defined on each virtual processor.
		 */
		if (deos()) {
			final List<ComponentInstance> virtualProcessorsWithoutExecutionTime = si
					.getAllComponentInstances(ComponentCategory.VIRTUAL_PROCESSOR).stream()
					.filter(comp -> ((comp.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
							&& (GetProperties.getExecutionTimeInMS(comp) == 0)))
					.collect(Collectors.toList());
			for (ComponentInstance vp : virtualProcessorsWithoutExecutionTime) {
				addError(new ErrorReport(vp,
						"Virtual processor must define the property Timing_Properties::Execution_Time"));
			}

			final List<ComponentInstance> virtualProcessorsWithoutPeriod = si
					.getAllComponentInstances(ComponentCategory.VIRTUAL_PROCESSOR).stream()
					.filter(comp -> ((comp.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
							&& (GetProperties.getPeriodinMS(comp) == 0)))
					.collect(Collectors.toList());
			for (ComponentInstance vp : virtualProcessorsWithoutPeriod) {
				addError(new ErrorReport(vp, "Virtual processor must define the property Timing_Properties::Period"));
			}
		}

		if (pok()) {
			OsateDebug.osateDebug("pok case");

			/**
			 * For each CPU, we check that every virtual processor contained in
			 * the cpu is correctly referenced in the schedule slots
			 */
			for (ComponentInstance cpu : si.getComponentInstances().stream()
					.filter(comp -> comp.getCategory() == ComponentCategory.PROCESSOR).collect(Collectors.toList())) {
				final List<ComponentInstance> unreferencedVirtualProcessors = cpu.getComponentInstances().stream()
						.filter(comp -> ((comp.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
								&& (PokProperties.getSlotsAllocation(cpu).contains(comp) == false)))
						.collect(Collectors.toList());
				for (ComponentInstance vp : unreferencedVirtualProcessors) {
					addError(new ErrorReport(vp,
							"Virtual processor must be declared in the containing processor's POK::Slots_Allocation property"));
				}

				int slotsAllocationSize = PokProperties.getSlotsAllocation(cpu).size();
				int slotsSize = PokProperties.getTimeSlotInMs(cpu).size();
				if (slotsAllocationSize != slotsSize) {
					addError(new ErrorReport(cpu, "Property POK::Slots_Allocation has " + slotsAllocationSize
							+ " elements, but property POK::Slots has " + slotsSize + "elements"));
				}
			}

			// List<ComponentInstance> badProcessors = (List<ComponentInstance>)
			// si.getAllComponentInstances().stream()
			// .filter( comp -> comp.getCategory() ==
			// ComponentCategory.PROCESSOR).filter( cpu ->
			// GetProperties.getModuleSchedule(cpu).size() ==
			// 0).collect(Collectors.toList());
			//
			// for (ComponentInstance cpu : badProcessors)
			// {
			// addError (new ErrorReport (cpu, "Need to define the processor
			// schedule"));
			// }
		}
	}

}
