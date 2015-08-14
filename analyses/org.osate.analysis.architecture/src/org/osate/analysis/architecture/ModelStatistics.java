/*
 * Created on July 7, 2004
 *
 * <copyright>
 * Copyright  2004-2013 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
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
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * @version $Id: ModelStatistics.java,v 1.17 2009-11-11 19:14:00 jseibel Exp $
 */
package org.osate.analysis.architecture;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DataType;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.util.Aadl2Switch;

/**
 * @author phf
 */
/*
 * Class should be final but Andrew Weaver of Freemont Associates really wants
 * to extend it. See Bug 543.
 */
public/* final */class ModelStatistics extends AadlProcessingSwitchWithProgress {
	/*
	 * Counters to keep track of occurrences of different objects in the model.
	 */
	private int typeCount = 0;
	private int componentTypeCount = 0;
	private int compImplCount = 0;
	private int threadCount = 0;
	private int processCount = 0;
	private int processorCount = 0;
	private int virtualProcessorCount = 0;
	private int busCount = 0;
	private int virtualBusCount = 0;
	private int deviceCount = 0;
	private int memoryCount = 0;
	private int componentCount = 0;
	private int connectionCount = 0;
	private int flowCount = 0;
	private int endToEndFlowCount = 0;
	private int ETEFICount = 0;

	public ModelStatistics(final IProgressMonitor monitor) {
		super(monitor, PROCESS_PRE_ORDER_ALL);
	}

	public ModelStatistics(final IProgressMonitor monitor, AnalysisErrorReporterManager errmgr) {
		super(monitor, PROCESS_PRE_ORDER_ALL, errmgr);
	}

	protected final void initSwitches() {
		/*
		 * We overwrite the case method for a class in the meta model specific
		 * switches.
		 */

		aadl2Switch = new Aadl2Switch<String>() {
			/*
			 * We want to count all component type declarations. Thus, we count
			 * instances of the abstract ComponentType class.
			 */
			public String caseComponentType(ComponentType obj) {
//				monitor.subTask("Visiting " + obj.getQualifiedName());
				typeCount++;
				// Only count those that are not DataType
				if (!(obj instanceof DataType))
					componentTypeCount++;
				return DONE;
			}

			public String caseComponentImplementation(ComponentImplementation ci) {
//				monitor.subTask("Visiting " + ci.getQualifiedName());
				compImplCount++;
//				EList cl = ci.getAllSubcomponents();
//				System.out.println("case "+ci.getName()+" "+cl.size());
				return DONE;
			}

			public String caseFlowSpecification(FlowSpecification obj) {
				flowCount++;
				return DONE;
			}

			public String caseEndToEndFlow(EndToEndFlow obj) {
				endToEndFlowCount++;
				return DONE;
			}
		};

		// We want to count instance model objects.
		instanceSwitch = new InstanceSwitch<String>() {
			public String caseComponentInstance(ComponentInstance obj) {
				componentCount++;
				/*
				 * We want to count category specific instances. We retrieve the
				 * category and branch on its numeric representation.
				 */
				switch (obj.getCategory()) {
				case THREAD:
					threadCount++;
					return DONE;
				case PROCESS:
					processCount++;
					return DONE;
				case PROCESSOR:
					processorCount++;
					return DONE;
				case VIRTUAL_PROCESSOR:
					virtualProcessorCount++;
					return DONE;
				case MEMORY:
					memoryCount++;
					return DONE;
				case BUS:
					busCount++;
					return DONE;
				case VIRTUAL_BUS:
					virtualBusCount++;
					return DONE;
				case DEVICE:
					deviceCount++;
					return DONE;
				}
				return DONE;
			}

			public String caseConnectionInstance(ConnectionInstance ci) {
				connectionCount++;
				return DONE;
			}

			public String caseEndToEndFlowInstance(EndToEndFlowInstance ci) {
				ETEFICount++;
				return DONE;
			}
		};

		/*
		 * Note: we did not redefine processing of elements from the features or
		 * components packages.
		 */
	}

	public void countClassifier(EClass cl) {
		if (Aadl2Package.eINSTANCE.getComponentType().isSuperTypeOf(cl)) {
			typeCount++;
		} else if (Aadl2Package.eINSTANCE.getComponentImplementation().isSuperTypeOf(cl)) {
			compImplCount++;
		}
	}

	public String getModelResult() {
		return "Model Statistics: " + componentTypeCount + " component type declarations, " + compImplCount
				+ " component implementation declarations, " + (typeCount - componentTypeCount)
				+ " data type declarations.  ";
	}

	public String getFlowResult() {
		return "Flow Statistics: " + flowCount + " flow specifications, " + endToEndFlowCount + " end-to-end flows.  ";
	}

	public String getApplicationResult() {
		if (componentCount > 0) {
			return "Application statistics: " + threadCount + " threads, " + processCount + " processes, "
					+ connectionCount + " semantic connections, " + ETEFICount + " end-to-end flow instances.  ";
		}
		return null;
	}

	public String getExecutionPlatformResult() {
		if (componentCount > 0) {
			return "Execution platform statistics: " + processorCount + " processors, " + virtualProcessorCount
					+ " virtual processors, " + memoryCount + " memory units, " + busCount + " buses, "
					+ virtualBusCount + " virtual buses, " + deviceCount + " devices.  ";
		}
		return null;
	}
}
