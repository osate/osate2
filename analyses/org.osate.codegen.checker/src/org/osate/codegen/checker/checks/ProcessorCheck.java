/**
 * <copyright>
 * Copyright 2016 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract FA8721-05-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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
