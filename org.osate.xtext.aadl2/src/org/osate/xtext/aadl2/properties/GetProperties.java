/*
 * <copyright>
 * Copyright  2006 by Carnegie Mellon University, all rights reserved.
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
 * </copyright>
 */
package org.osate.xtext.aadl2.properties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.properties.PropertyLookupException;
import org.osate.contribution.sei.names.SEI;
import org.osate.xtext.aadl2.linking.Aadl2LinkingService;
import org.osate.xtext.aadl2.util.ConnectionBindingUtil;


public class GetProperties {

	public static Property lookupPropertyDefinition(EObject context,String ps, String name) {
		return Aadl2LinkingService.eInstance.findPropertyDefinition(context,ps != null?(ps+ "::" +name):name);
	}

	public static List<ComponentInstance> getActualProcessorBinding(final ComponentInstance io) {
		Property actualProcessorBinding = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ACTUAL_PROCESSOR_BINDING);
		List<? extends PropertyExpression> propertyValues = io.getPropertyValueList(actualProcessorBinding);
		ArrayList<ComponentInstance> components = new ArrayList<ComponentInstance>();
		for (PropertyExpression propertyExpression : propertyValues)
			components.add((ComponentInstance)((InstanceReferenceValue)propertyExpression).getReferencedInstanceObject());
		return components;
	}

	public static List<ComponentInstance> getActualMemoryBinding(final InstanceObject io) {
		Property actualMemoryBinding = lookupPropertyDefinition(io,DeploymentProperties._NAME,
				DeploymentProperties.ACTUAL_MEMORY_BINDING);
		List<? extends PropertyExpression> propertyValues = io.getPropertyValueList(actualMemoryBinding);
		ArrayList<ComponentInstance> components = new ArrayList<ComponentInstance>();
		for (PropertyExpression propertyExpression : propertyValues)
			components.add((ComponentInstance)((InstanceReferenceValue)propertyExpression).getReferencedInstanceObject());
		return components;
	}

	public static List getActualConnectionBinding(final NamedElement ne) {
		try {
			Property actualConnectionBinding = lookupPropertyDefinition(ne,DeploymentProperties._NAME,
					DeploymentProperties.ACTUAL_CONNECTION_BINDING);
			return ne.getPropertyValueList(actualConnectionBinding);
		} catch (Throwable e) {
			return null;
		}
	}

	public static double getMIPSCapacityInMIPS(final NamedElement ne, final double defaultValue) {
		try {
			Property MIPSCapacity = lookupPropertyDefinition(ne,SEI._NAME, SEI.MIPS_CAPACITY);
			UnitLiteral MIPS = Aadl2LinkingService.eInstance.findUnitLiteral(MIPSCapacity, SEI.MIPS_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, MIPSCapacity, MIPS, defaultValue);
		} catch (Throwable e) {
			return defaultValue;
		}
	}

	public static double getMIPSBudgetInMIPS(final NamedElement ne, final double defaultValue) {
		try {
			Property MIPSBudget = lookupPropertyDefinition(ne,SEI._NAME, SEI.MIPS_BUDGET);
			UnitLiteral MIPS = Aadl2LinkingService.eInstance.findUnitLiteral(MIPSBudget, SEI.MIPS_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, MIPSBudget, MIPS, defaultValue);
		} catch (Throwable e) {
			return defaultValue;
		}
	}

	public static double getBandWidthCapacityInKbps(final NamedElement ne, final double defaultValue) {
		try {
			Property BandWidthCapacity = lookupPropertyDefinition(ne,SEI._NAME, SEI.BANDWIDTH_CAPACITY);
			UnitLiteral Kbps = Aadl2LinkingService.eInstance.findUnitLiteral(BandWidthCapacity, SEI.KBPS_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, BandWidthCapacity, Kbps, defaultValue);
		} catch (Throwable e) {
			return defaultValue;
		}
	}

	public static double getBandWidthBudgetInKbps(final NamedElement ne, final double defaultValue) {
		try {
			Property BandWidthBudget = lookupPropertyDefinition(ne,SEI._NAME, SEI.BANDWIDTH_BUDGET);
			UnitLiteral Kbps = Aadl2LinkingService.eInstance.findUnitLiteral(BandWidthBudget, SEI.KBPS_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, BandWidthBudget, Kbps, defaultValue);
		} catch (Throwable e) {
			return defaultValue;
		}
	}

	public static ComponentClassifier getReferenceProcessor(final NamedElement ne) {
		PropertyExpression pv = null;
		;
		Property referenceProcessor = lookupPropertyDefinition(ne,SEI._NAME, SEI.REFERENCE_PROCESSOR);
		try {
			pv = ne.getSimplePropertyValue(referenceProcessor);
		} catch (Exception e) {
		}
		if (pv == null)
			return null;
		return (ComponentClassifier) ((ClassifierValue) pv).getClassifier();

	}

	public static double getCycleTimeinMS(final NamedElement ne) {
		Property cycleTime = lookupPropertyDefinition(ne,SEI._NAME, SEI.CYCLE_TIME);
		UnitLiteral microSecond = Aadl2LinkingService.eInstance.findUnitLiteral(cycleTime, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, cycleTime, microSecond, 0.0);
	}

	public static double scaleValueToMicroSecond(final NumberValue nv) {
		UnitLiteral microSecond = Aadl2LinkingService.eInstance.findUnitLiteral(nv, AadlProject.MS_LITERAL);
		return nv.getScaledValue(microSecond);
	}

	public static double getActualMIPS(ComponentInstance bci) {
		double exectimeval = getComputeExecutionTimeInSec(bci, 0.0);
		double period = getPeriodInSeconds(bci, 0.0);
		if (exectimeval > 0 && period > 0) {
			double mipspersec = getReferenceMIPS(bci);
			double time = exectimeval / period;
			double mips = time * mipspersec;
			return mips;
		}
		return 0.0;
	}

	/**
	 * get cycle time that is the reference for the execution time of the thread
	 * This value is determined based on the reference processor, or the
	 * ReferenceCycleTime constant
	 * 
	 * @param thread
	 * @return double cycle time in micro sec.
	 */
	public static double getReferenceCycleTimeinMS(final ComponentInstance thread) {
		double cycleTime = 0.0;
		ComponentClassifier pci = null;
		pci = getReferenceProcessor(thread);
		if (pci != null) {
			cycleTime = getCycleTimeinMS(pci);
		}
		if (cycleTime == 0.0) {
			cycleTime = getReferenceCycleTimeConstantinMS(thread);
		}
		return cycleTime;
	}

	public static double getReferenceCycleTimeConstantinMS(EObject context) {
		PropertyConstant referenceCycleTime = Aadl2LinkingService.eInstance.findPropertyConstant(context,SEI._NAME+ "::" +SEI.REFERENCE_CYCLE_TIME);
		if (referenceCycleTime == null)
			return 0.0;
		return scaleValueToMicroSecond((NumberValue) referenceCycleTime.getConstantValue());
	}

	/**
	 * get the scaling factor between the processor the thread is bound to and
	 * the reference processor used to specify the cycle time
	 * 
	 * @param thread
	 * @return double scaling factor of processor speed
	 */
	public static double getProcessorScalingFactor(final ComponentInstance thread) {
		List<ComponentInstance> processorList = getActualProcessorBinding(thread);
		ComponentInstance processor = processorList.isEmpty() ? null : processorList.get(0);
		double procCycleTime = getCycleTimeinMS(processor);
		double refCycleTime = getReferenceCycleTimeinMS(thread);
		if (refCycleTime == 0.0)
			return 1.0;
		return procCycleTime / refCycleTime;
	}

	/**
	 * Get the MIPS per sec of the reference processor. First tries to find the
	 * MIPS capacity. It then tries an explicit reference processor. If it finds
	 * it, then it gets the cycle time of that processor. Otherwise it tries to
	 * find an explicit reference_cycle_time value. Failing that, it returns a
	 * value corresponding to a 1GIPS processor.
	 */
	public static double getReferenceMIPS(final ComponentInstance thread) {
		double cycleTime = getReferenceCycleTimeinMS(thread);
		if (cycleTime != 0.0) {
			// time for MIPS therefore microsec (10E-6)
			// 1 / cycletime => # of MIPS in terms of one instruction per cycle
			return (1 / cycleTime);
		}
		List<ComponentInstance> pciList = getActualProcessorBinding(thread);
		ComponentInstance pci = pciList.isEmpty() ? null : pciList.get(0);
		if (pci != null) {
			double mipscap = getMIPSCapacityInMIPS(pci, 0.0);
			if (mipscap > 0)
				return mipscap;
		}
		return 1000;
	}

	/**
	 * return cycletime in terms of MIPS, zero if no cycle timee
	 * 
	 * @param curprocessor
	 * @return MIPS
	 */
	public static double getCycletimeasMIPS(final ComponentInstance curprocessor) {
		double cycleTime = getCycleTimeinMS(curprocessor);
		if (cycleTime != 0.0) {
			// time for MIPS therefore microsec (10E-6)
			// 1 / cycletime => # of MIPS in terms of one instruction per cycle
			return (1 / cycleTime);
		} else
			return 0;
	}

	public static double getPowerCapacity(final NamedElement ne, final double defaultValue) {
		Property powerCapacity = lookupPropertyDefinition(ne,SEI._NAME, SEI.POWER_CAPACITY);
		UnitLiteral mWatt = Aadl2LinkingService.eInstance.findUnitLiteral(powerCapacity, SEI.MW_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, powerCapacity, mWatt, defaultValue);
	}

	public static double getPowerBudget(final NamedElement ne, final double defaultValue) {
		Property powerBudget = lookupPropertyDefinition(ne,SEI._NAME, SEI.POWER_BUDGET);
		UnitLiteral mWatt = Aadl2LinkingService.eInstance.findUnitLiteral(powerBudget, SEI.MW_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, powerBudget, mWatt, defaultValue);
	}

	public static double getPowerSupply(final NamedElement ne, final double defaultValue) {
//		if (SaviSupplyPD != null) {
//			double savisupply = PropertyUtils.getScaledNumberValue(ne, SaviSupplyPD, mWatt, -1);
//			if (savisupply >= 0) {
//				return savisupply;
//			}
//		}
		Property powerSupply = lookupPropertyDefinition(ne,SEI._NAME, SEI.POWER_SUPPLY);
		UnitLiteral mWatt = Aadl2LinkingService.eInstance.findUnitLiteral(powerSupply, SEI.MW_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, powerSupply, mWatt, defaultValue);
	}

	public static double getPeriodinMS(final NamedElement ne) {
		Property period = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.PERIOD);
		UnitLiteral microSecond = Aadl2LinkingService.eInstance.findUnitLiteral(period, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, period, microSecond, 0.0);
	}

	public static double getActualLatencyinMS(final NamedElement ne) {
		Property actualLatency = lookupPropertyDefinition(ne,CommunicationProperties._NAME, CommunicationProperties.ACTUAL_LATENCY);
		UnitLiteral microSecond = Aadl2LinkingService.eInstance.findUnitLiteral(actualLatency, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, actualLatency, microSecond, 0.0);
	}

	public static long getQueueSize(final NamedElement ne) {
		Property queuesize = lookupPropertyDefinition(ne,CommunicationProperties._NAME, CommunicationProperties.QUEUE_SIZE);
		return PropertyUtils.getIntegerValue(ne, queuesize, 0);
	}

	public static double getMIPSBudgetInMIPS(final NamedElement ne) {
		return getMIPSBudgetInMIPS(ne, 0.0);
	}

	public static double getDeadlineinMS(final NamedElement ne) {
		Property deadline = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.DEADLINE);
		UnitLiteral microSecond = Aadl2LinkingService.eInstance.findUnitLiteral(deadline, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, deadline, microSecond, 0.0);
	}

	public static double getComputeExecutionTimeinMS(final NamedElement ne) {
		Property computeExecutionTime = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.COMPUTE_EXECUTION_TIME);
		UnitLiteral microSecond = Aadl2LinkingService.eInstance.findUnitLiteral(computeExecutionTime, AadlProject.MS_LITERAL);
		double time = PropertyUtils.getScaledRangeMaximum(ne, computeExecutionTime, microSecond, 0.0);
		if (ne instanceof ComponentInstance) {
			double scale = getProcessorScalingFactor((ComponentInstance) ne);
			return time * scale;
		}
		return time;
	}

	public static double getComputeExecutionTimeInSec(final NamedElement ne, final double defaultValue) {
		Property computeExecutionTime = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.COMPUTE_EXECUTION_TIME);
		UnitLiteral second = Aadl2LinkingService.eInstance.findUnitLiteral(computeExecutionTime, AadlProject.SEC_LITERAL);
		try {
			return PropertyUtils.getScaledRangeMaximum(ne, computeExecutionTime, second, defaultValue);
		} catch (Throwable e) {
			return defaultValue;
		}
	}

	public static double getPeriodInSeconds(final NamedElement ne, final double defaultValue) {
		Property period = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.PERIOD);
		UnitLiteral second = Aadl2LinkingService.eInstance.findUnitLiteral(period, AadlProject.SEC_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, period, second, defaultValue);
	}

	public static long getPriority(final NamedElement ne, final long defaultValue) {
		Property priority = lookupPropertyDefinition(ne,ThreadProperties._NAME, ThreadProperties.PRIORITY);
		return PropertyUtils.getIntegerValue(ne, priority, defaultValue);
	}

	public static String getSchedulingProtocol(final NamedElement ne, final String defaultValue) {
		try {
			Property schedulingprotocol = lookupPropertyDefinition(ne,DeploymentProperties._NAME, DeploymentProperties.SCHEDULING_PROTOCOL);
			return PropertyUtils.getEnumLiteral(ne, schedulingprotocol).getName();
		} catch (PropertyLookupException e) {
			return defaultValue;
		}
	}

	public static EnumerationLiteral getDispatchProtocol(final NamedElement ne) {
		try {
			Property dispatchProtocol = lookupPropertyDefinition(ne,ThreadProperties._NAME, ThreadProperties.DISPATCH_PROTOCOL);
			return PropertyUtils.getEnumLiteral(ne, dispatchProtocol);
		} catch (final PropertyLookupException e) {
			return null;
		}
	}

	public static double getSourceDataSizeInBytes(final NamedElement ne) {
		try {
			Property SourceDataSize = lookupPropertyDefinition(ne,MemoryProperties._NAME, MemoryProperties.SOURCE_DATA_SIZE);
			UnitLiteral Bytes = Aadl2LinkingService.eInstance.findUnitLiteral(SourceDataSize, AadlProject.B_LITERAL);
			double res = PropertyUtils.getScaledNumberValue(ne, SourceDataSize, Bytes);
			if (res == 0.0 && ne instanceof FeatureGroupType) {
				EList fl = ((FeatureGroupType) ne).getAllFeatures();
				for (Object f : fl) {
					Classifier c = ((Feature) f).getAllClassifier();
					if (c == null) {
						res = res + 1.0;
					} else {
						res = res + getSourceDataSizeInBytes(c);
					}
				}
			}
			return res;
		} catch (PropertyLookupException e) {
			return 0.0;
		}
	}
	
	public static double getSourceCodeSizeInBytes(final NamedElement ne) {
		try {
			Property SourceCodeSize = lookupPropertyDefinition(ne,MemoryProperties._NAME, MemoryProperties.SOURCE_CODE_SIZE);
			UnitLiteral Bytes = Aadl2LinkingService.eInstance.findUnitLiteral(SourceCodeSize, AadlProject.B_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, SourceCodeSize, Bytes);
		} catch (PropertyLookupException e) {
			return 0.0;
		}
	}
	
	public static double getSourceStackSizeInBytes(final NamedElement ne) {
		try 
		{
			Property SourceStackSize = lookupPropertyDefinition(ne,MemoryProperties._NAME, MemoryProperties.SOURCE_STACK_SIZE);
			UnitLiteral Bytes = Aadl2LinkingService.eInstance.findUnitLiteral(SourceStackSize, AadlProject.B_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, SourceStackSize, Bytes);
		}
		catch (PropertyLookupException e)
		{
			return 0.0;
		}
	}


	public static double getPartitionLatencyInMS(final NamedElement ne, final double defaultValue) {
		try {
			Property partitionLatency = lookupPropertyDefinition(ne,SEI._NAME, SEI.PARTITION_LATENCY);
			UnitLiteral microSecond = Aadl2LinkingService.eInstance.findUnitLiteral(partitionLatency, AadlProject.MS_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, partitionLatency, microSecond, defaultValue);
		} catch (PropertyLookupException e) {
			return defaultValue;
		}
	}

	public static boolean getIsPartition(final NamedElement ne) {
		try {
			Property isPartition = lookupPropertyDefinition(ne,SEI._NAME, SEI.IS_PARTITION);
			return PropertyUtils.getBooleanValue(ne, isPartition);
		} catch (PropertyLookupException e) {
			return false;
		}
	}

	public static double getLatencyinMS(final NamedElement ne) {
		try {
			Property Latency = lookupPropertyDefinition(ne,CommunicationProperties._NAME, CommunicationProperties.LATENCY);
			UnitLiteral microSecond = Aadl2LinkingService.eInstance.findUnitLiteral(Latency, AadlProject.MS_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, Latency, microSecond);
		} catch (PropertyLookupException e) {
			return 0.0;
		}
	}

	public static double getAccessLatencyinMS(final ComponentInstance HWcomp, final ComponentInstance bus) {
		ConnectionInstance aci = ConnectionBindingUtil.getBusAccessConnection(HWcomp, bus);
		if (aci == null)
			return 0.0;
		try {
			Property Latency = lookupPropertyDefinition(aci,CommunicationProperties._NAME, CommunicationProperties.LATENCY);
			UnitLiteral microSecond = Aadl2LinkingService.eInstance.findUnitLiteral(Latency, AadlProject.MS_LITERAL);
			return PropertyUtils.getScaledNumberValue(aci, Latency, microSecond);
		} catch (PropertyLookupException e) {
			return 0.0;
		}
	}


	/**
	 * Converts the value from the original unit to the target unit
	 */
	public static double convertToScale(double origvalue, UnitLiteral original, UnitLiteral target) {
		final double factor = original.getAbsoluteFactor(target);
		return origvalue * factor;
	}

	/**
	 * Determines the target unit from the original unit to scale the value to a
	 * higher unit The goal is
	 */
	public static UnitLiteral scaleupUnit(double origvalue, UnitLiteral original) {
		if (origvalue < 10)
			return original;
		UnitsType ut = (UnitsType) original.eContainer();
		boolean looking = true;
		UnitLiteral target = null;
		UnitLiteral previous = null;
		for (Iterator it = ut.getOwnedLiterals().iterator(); it.hasNext();) {
			target = (UnitLiteral) it.next();
			if (looking) {
				if (target == original) {
					looking = false;
					previous = target;
				}
			} else {
				double factor = ((IntegerLiteral) target.getFactor()).getValue();
				origvalue = origvalue / factor;
				if (origvalue < 1)
					return previous;
				previous = target;
			}
		}
		if (target != null)
			return target;
		return original;
	}

	public static String toStringScaled(double value, UnitLiteral unit) {
		UnitLiteral targetliteral = scaleupUnit(value, unit);
		double result = value;
		if (targetliteral != unit) {
			result = convertToScale(value, unit, targetliteral);
		}
		return String.format("%.3f " + targetliteral.getName(), result);
	}
	
	public static long getByteCount(final NamedElement ne) {
		Property byteCount = lookupPropertyDefinition(ne,MemoryProperties._NAME, MemoryProperties.BYTE_COUNT);
		return PropertyUtils.getIntegerValue(ne, byteCount, 0);
	}

	public static double getStreamMissRate(final NamedElement ne) {
		return PropertyUtils.getRealValue(ne, GetProperties.lookupPropertyDefinition(ne,SEI._NAME, SEI.STREAM_MISS_RATE));
	}
	
	public static boolean getRequiredConnection(final NamedElement ne) {
		try {
			Property requiredConnection = lookupPropertyDefinition(ne,DeploymentProperties._NAME, DeploymentProperties.REQUIRED_CONNECTION);
			return PropertyUtils.getBooleanValue(ne, requiredConnection);
		} catch (PropertyLookupException e) {
			return false;
		}
	}

}