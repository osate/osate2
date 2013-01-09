/**
 * <copyright>
 * Copyright  2013 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 * 
 * NO WARRANTY
 * 
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
 * </copyright>
 * 
 */
package org.osate.analysis.arinc653;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.impl.ContainmentPathElementImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.aadl2.util.OsateDebug;
import org.osate.analysis.arinc653.helpers.SchedulingSlotsHelper;
import org.osate.validation.*;
import org.osate.validation.lute.utils.*;


public class ConfigurationValidation extends AadlProcessingSwitchWithProgress
{
	private boolean validationSuccess;
	private String errorMessage;
	private String errorTitle;
	private Element errorElement;

	public ConfigurationValidation(final IProgressMonitor monitor) 
	{
		super(monitor, PROCESS_PRE_ORDER_ALL);
		this.validationSuccess = true;
		this.errorTitle = "Unknown";
		this.errorMessage = "Unknown";
		this.errorElement = null;
	}

	public ConfigurationValidation(final IProgressMonitor monitor, AnalysisErrorReporterManager errmgr) 
	{
		super(monitor, PROCESS_PRE_ORDER_ALL, errmgr);
		this.validationSuccess = true;
		this.errorTitle = "Unknown";
		this.errorMessage = "Unknown";
		this.errorElement = null;
	}

	public Element getErrorElement ()
	{
		return this.errorElement;
	}
	
	public boolean isSuccessful ()
	{
		return this.validationSuccess;
	}
	
	public String getErrorMessage ()
	{
		return this.errorMessage;
	}
	
	public String getErrorTitle ()
	{
		return this.errorTitle;
	}
	
	
	protected final void initSwitches() {


		aadl2Switch = new Aadl2Switch<String>() {

			public String caseComponentType(ComponentType obj) {

				return DONE;
			}

			public String caseComponentImplementation(ComponentImplementation ci) {

				return DONE;
			}
			
			public String caseFlowSpecification(FlowSpecification obj) {

				return DONE;
			}

			public String caseEndToEndFlow(EndToEndFlow obj) {

				return DONE;
			}
		};


		
		instanceSwitch = new InstanceSwitch<String>() {
			public String caseComponentInstance(ComponentInstance obj) {
				ListValue slotsList;
				ListValue slotsAllocationList;
				int slotsListSize;
				int slotsAllocationListSize;
				long slotsSum;
				long majorFrame;
				List<String> scheduledPartitions;
				List<String> containedPartitions;
				
				switch (obj.getCategory()) 
				{
				case THREAD:
					return DONE;
				case PROCESS:
					return DONE;
				case PROCESSOR:
					scheduledPartitions = new ArrayList<String>();
					containedPartitions = new ArrayList<String>();
					slotsListSize = 0;
					slotsAllocationListSize = 0;
					slotsSum = 0;
					
					slotsList = SchedulingSlotsHelper.getSlots(obj);
					slotsAllocationList = SchedulingSlotsHelper.getSlotsAllocation(obj);
					
					/*
					 * First, we get the Major Frame of the Processor.
					 * If undefined, it will be 0.
					 */
					majorFrame = SchedulingSlotsHelper.getMajorFrame(obj);
					
					/*
					 * Then, we retrieve the name of all contained virtual
					 * processors, the partitions executed on the module.
					 */
					for (Element e : obj.getChildren())
					{
						
						if (e instanceof ComponentInstance)
						{
							ComponentInstance sci = (ComponentInstance) e;
							if (sci.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
							{
								containedPartitions.add(sci.getName());
							}
						}
					}
					
					/*
					 * We inspect the slots list, check the size and make a sum
					 * to check with the major frame.
					 */
					for (Element e : slotsList.getChildren())
					{
						if (e instanceof IntegerLiteral)
						{
							IntegerLiteral il = (IntegerLiteral) e;
							slotsSum = slotsSum + il.getValue();
							slotsListSize = slotsListSize + 1;
						}
						
					}
					
					
					/*
					 * We check the allocation list and add the name of each
					 * scheduled partition in a list.
					 */
					for (Element e : slotsAllocationList.getChildren())
					{

						if (e instanceof ReferenceValue)
						{
							ReferenceValue rv = (ReferenceValue) e;
							System.out.println("rv=" + rv);
							for (Element e2 : rv.getChildren())
							{
								if (e2 instanceof ContainmentPathElementImpl)
								{
									ContainmentPathElementImpl cpei = (ContainmentPathElementImpl) e2;
									System.out.println("e2=" + cpei.getNamedElement());
									if (cpei.getNamedElement() instanceof VirtualProcessorSubcomponent)
									{
										VirtualProcessorSubcomponent vp = (VirtualProcessorSubcomponent) cpei.getNamedElement();
										System.out.println ("name=" + vp.getName());
										scheduledPartitions.add(vp.getName());
										slotsAllocationListSize = slotsAllocationListSize + 1;

									}
								}
									
							}
						}
					}
					
					System.out.println("slots sum" + slotsSum);
					System.out.println("major frame" + majorFrame);
					
					/*
					 * Checking that the major frame (declared
					 * with the ARINC653::Module_Major_Frame is basically the same
					 * than the sum of all partitions slots. Otherwise, we would
					 * have a partition inconsistency.
					 */
					if (slotsSum != majorFrame)
					{
						errorTitle = "Inconsistency between Major Frame and Slots";
						errorMessage = "The value of the major frame (" + majorFrame + ") is not consistent with the sum of the partition slots (" + slotsSum +")";
						validationSuccess = false;
						errorElement = obj;
					}
					
					/*
					 * Also, we must check that the major frame is valid and
					 * more than 0.
					 */
					if (majorFrame == 0)
					{
						errorTitle = "Definition of Major Frame";
						errorMessage = "The Major Frame property is not defined on the processor. Please define the value";
						validationSuccess = false;
						errorElement = obj;
					}
					
					/*
					 * Check that we schedule at least one partition.
					 */
					if (slotsAllocationListSize == 0)
					{
						errorTitle = "Definition of partitions slots allocation";
						errorMessage = "Allocation of partitions slots is not defined. Please define it.";
						validationSuccess = false;
						errorElement = obj;
					}
					
					if (slotsListSize == 0)
					{
						errorTitle = "Definition of partitions slots";
						errorMessage = "Partitions slots are not defined. Please define it.";
						validationSuccess = false;
						errorElement = obj;
					}
					
					/*
					 * Verify that all partitions hosted on the processor
					 * are being scheduled.
					 */
					for (String p : containedPartitions)
					{
						if (! scheduledPartitions.contains(p))
						{
							errorTitle = "Scheduling of partitions";
							errorMessage = "Partition " + p + " is not scheduled. Please add it in the allocation list.";
							validationSuccess = false;
							errorElement = obj;
						}
					}
					
					return DONE;
				case VIRTUAL_PROCESSOR:
					return DONE;
				case MEMORY:
					return DONE;
				case BUS:
					return DONE;
				case VIRTUAL_BUS:
					return DONE;
				case DEVICE:
					return DONE;
				}
				return DONE;
			}

			public String caseConnectionInstance(ConnectionInstance ci) 
			{
				
				
				return DONE;
			}

			public String caseEndToEndFlowInstance(EndToEndFlowInstance ci) {
				return DONE;
			}
		};

	}
	
	public void applyTheorems (SystemInstance systemInstance)
	{
		Logger luteLogger;

		luteLogger = new Logger (Logger.INFO);
		
		OsateDebug.osateDebug("[ConfigurationValidation] Call applyTheorems on " + systemInstance);
		Invoke.invoke (systemInstance, ConfigurationValidation.class.getResourceAsStream("/resource/configuration-memory-segments.lute"), luteLogger); 
		return;
	}
	
}
