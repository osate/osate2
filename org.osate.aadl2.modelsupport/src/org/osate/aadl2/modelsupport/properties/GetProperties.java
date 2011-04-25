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
package org.osate.aadl2.modelsupport.properties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
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
import org.osate.aadl2.modelsupport.eclipseinterface.OsateResourceManager;
import org.osate.aadl2.modelsupport.util.ConnectionBindingUtil;
import org.osate.aadl2.properties.PropertyLookupException;
import org.osate.contribution.sei.names.SEI;
import org.osate.workspace.names.standard.AadlProject;
import org.osate.workspace.names.standard.CommunicationProperties;
import org.osate.workspace.names.standard.DeploymentProperties;
import org.osate.workspace.names.standard.MemoryProperties;
import org.osate.workspace.names.standard.ThreadProperties;
import org.osate.workspace.names.standard.TimingProperties;


public class GetProperties {
	// Predeclared property declarations
	private static Property actualProcessorBinding;
	private static Property actualMemoryBinding;
	private static Property actualConnectionBinding;

	private static Property byteCount;
	
	private static UnitLiteral microSecond;
	private static UnitLiteral milliSecond;
	private static UnitLiteral second;

	private static Property MIPSCapacity;
	private static Property MIPSBudget;
	private static Property RAMCapacity;
	private static Property RAMBudget;
	private static Property ROMCapacity;
	private static Property ROMBudget;
	private static Property RAMActual;
	private static Property ROMActual;
	private static Property BandWidthCapacity;
	private static Property BandWidthBudget;

	private static Property SourceDataSize;
	private static Property SourceStackSize;
	private static Property SourceCodeSize;
	private static Property TransmissionTime;

	private static UnitLiteral MIPS;
	private static UnitLiteral Bytes;
	private static UnitLiteral KBytes;
	private static UnitLiteral MBytes;
	private static UnitLiteral GBytes;
	private static UnitLiteral Kbps;

	private static Property referenceProcessor;
	private static PropertyConstant referenceCycleTime;
	private static Property cycleTime;

	//Properties specific to this analysis
	private static Property computeExecutionTime;
	private static Property period;
	private static Property dispatchProtocol;

	private static Property powerCapacity;
	private static Property powerBudget;
	private static Property powerSupply;
	private static UnitLiteral mWatt;

	private static Property SaviSupplyPD;

	private static Property deadline;
	private static Property priority;
	private static Property schedulingprotocol;
	private static Property partitionLatency;
	private static Property isPartition;
	private static Property deviceDispatchProtocol;
	private static Property Latency;
	private static Property expectedLatency;
	private static Property actualLatency;
	private static Property queuesize;
	
	public static void initialize() {
		if (actualProcessorBinding != null && actualProcessorBinding.eResource() != null && // AadlProperties is non-null and has resoruce
				MIPSBudget != null && MIPSBudget.eResource() != null && // SEI is non-null and has resoruce
				KBytes != null && KBytes.eResource() != null && // AadlProject is non-null and has resoruce
				SaviSupplyPD != null && SaviSupplyPD.eResource() != null)
			return; // SAVI is non-null and has resoruce
		actualProcessorBinding = lookupPropertyDefinition(DeploymentProperties._NAME,
				DeploymentProperties.ACTUAL_PROCESSOR_BINDING);
		actualMemoryBinding = lookupPropertyDefinition(DeploymentProperties._NAME,
				DeploymentProperties.ACTUAL_MEMORY_BINDING);
		actualConnectionBinding = lookupPropertyDefinition(DeploymentProperties._NAME,
				DeploymentProperties.ACTUAL_CONNECTION_BINDING);
		byteCount = lookupPropertyDefinition(MemoryProperties._NAME,
				MemoryProperties.BYTE_COUNT);
		MIPSCapacity = lookupPropertyDefinition(SEI._NAME, SEI.MIPS_CAPACITY);
		MIPSBudget = lookupPropertyDefinition(SEI._NAME, SEI.MIPS_BUDGET);
		RAMCapacity = lookupPropertyDefinition(SEI._NAME, SEI.RAM_CAPACITY);
		RAMBudget = lookupPropertyDefinition(SEI._NAME, SEI.RAM_BUDGET);
		ROMCapacity = lookupPropertyDefinition(SEI._NAME, SEI.ROM_CAPACITY);
		ROMBudget = lookupPropertyDefinition(SEI._NAME, SEI.ROM_BUDGET);
		RAMActual = lookupPropertyDefinition(SEI._NAME, SEI.RAM_ACTUAL);
		ROMActual = lookupPropertyDefinition(SEI._NAME, SEI.ROM_ACTUAL);
		BandWidthCapacity = lookupPropertyDefinition(SEI._NAME, SEI.BANDWIDTH_CAPACITY);
		BandWidthBudget = lookupPropertyDefinition(SEI._NAME, SEI.BANDWIDTH_BUDGET);
		referenceProcessor = lookupPropertyDefinition(SEI._NAME, SEI.REFERENCE_PROCESSOR);
		referenceCycleTime = OsateResourceManager.findPropertyConstant(SEI._NAME, SEI.REFERENCE_CYCLE_TIME);
		cycleTime = lookupPropertyDefinition(SEI._NAME, SEI.CYCLE_TIME);
		period = lookupPropertyDefinition(TimingProperties._NAME, TimingProperties.PERIOD);
		
		SourceDataSize = lookupPropertyDefinition(MemoryProperties._NAME, MemoryProperties.SOURCE_DATA_SIZE);
		SourceStackSize = lookupPropertyDefinition(MemoryProperties._NAME, MemoryProperties.SOURCE_STACK_SIZE);
		SourceCodeSize = lookupPropertyDefinition(MemoryProperties._NAME, MemoryProperties.SOURCE_CODE_SIZE);
		
		TransmissionTime = lookupPropertyDefinition(CommunicationProperties._NAME,
				CommunicationProperties.TRANSMISSION_TIME);
		partitionLatency = lookupPropertyDefinition(SEI._NAME, SEI.PARTITION_LATENCY);
		isPartition = lookupPropertyDefinition(SEI._NAME, SEI.IS_PARTITION);
		Latency = lookupPropertyDefinition(CommunicationProperties._NAME, CommunicationProperties.LATENCY);
		//expectedLatency = lookupPropertyDefinition(CommunicationProperties._NAME, CommunicationProperties.EXPECTED_LATENCY);
		actualLatency = lookupPropertyDefinition(CommunicationProperties._NAME, CommunicationProperties.ACTUAL_LATENCY);
		queuesize = lookupPropertyDefinition(CommunicationProperties._NAME, CommunicationProperties.QUEUE_SIZE);

		milliSecond = lookupUnitLiteral(AadlProject._NAME, AadlProject.TIME_UNITS, AadlProject.MS_LITERAL);
		microSecond = lookupUnitLiteral(AadlProject._NAME, AadlProject.TIME_UNITS, AadlProject.US_LITERAL);
		second = lookupUnitLiteral(AadlProject._NAME, AadlProject.TIME_UNITS, AadlProject.SEC_LITERAL);
		MIPS = lookupUnitLiteral(SEI._NAME, SEI.PROCESSOR_SPEED_UNITS, SEI.MIPS_LITERAL);
		KBytes = lookupUnitLiteral(AadlProject._NAME, AadlProject.SIZE_UNITS, AadlProject.KB_LITERAL);
		MBytes = lookupUnitLiteral(AadlProject._NAME, AadlProject.SIZE_UNITS, AadlProject.MB_LITERAL);
		GBytes = lookupUnitLiteral(AadlProject._NAME, AadlProject.SIZE_UNITS, AadlProject.GB_LITERAL);
		Kbps = lookupUnitLiteral(SEI._NAME, SEI.DATA_VOLUME_UNITS, SEI.KBPS_LITERAL);
		Bytes = lookupUnitLiteral(AadlProject._NAME, AadlProject.SIZE_UNITS, AadlProject.B_LITERAL);

		computeExecutionTime = lookupPropertyDefinition(TimingProperties._NAME, TimingProperties.COMPUTE_EXECUTION_TIME);
		dispatchProtocol = lookupPropertyDefinition(ThreadProperties._NAME, ThreadProperties.DISPATCH_PROTOCOL);

		powerCapacity = lookupPropertyDefinition(SEI._NAME, SEI.POWER_CAPACITY);
		powerBudget = lookupPropertyDefinition(SEI._NAME, SEI.POWER_BUDGET);
		powerSupply = lookupPropertyDefinition(SEI._NAME, SEI.POWER_SUPPLY);
		SaviSupplyPD = OsateResourceManager.findProperty("SAVI", SEI.POWER_SUPPLY);
		mWatt = lookupUnitLiteral(SEI._NAME, SEI.POWER_UNITS, SEI.MW_LITERAL);

		deadline = lookupPropertyDefinition(TimingProperties._NAME, TimingProperties.DEADLINE);
		priority = lookupPropertyDefinition(SEI._NAME, SEI.PRIORITY);
		schedulingprotocol = lookupPropertyDefinition(DeploymentProperties._NAME, DeploymentProperties.SCHEDULING_PROTOCOL);

	}

	public static Property lookupPropertyDefinition(String ps, String name) {
		return OsateResourceManager.findProperty(ps, name);
	}

	public static UnitLiteral lookupUnitLiteral(final String ps, final String unitType, final String literalName) {
		final UnitsType type = (UnitsType) OsateResourceManager.findPropertyType(ps, unitType);
		if (type != null) {
			final UnitLiteral literal = type.findLiteral(literalName);
			return literal;
		} else {
			return null;
		}
	}

	public static List<ComponentInstance> getActualProcessorBinding(final InstanceObject io) {
		initialize();
		List<? extends PropertyExpression> propertyValues = io.getPropertyValueList(actualProcessorBinding);
		ArrayList<ComponentInstance> components = new ArrayList<ComponentInstance>();
		for (PropertyExpression propertyExpression : propertyValues)
			components.add((ComponentInstance)((InstanceReferenceValue)propertyExpression).getReferencedInstanceObject());
		return components;
	}

	public static List<ComponentInstance> getActualMemoryBinding(final InstanceObject io) {
		initialize();
		List<? extends PropertyExpression> propertyValues = io.getPropertyValueList(actualMemoryBinding);
		ArrayList<ComponentInstance> components = new ArrayList<ComponentInstance>();
		for (PropertyExpression propertyExpression : propertyValues)
			components.add((ComponentInstance)((InstanceReferenceValue)propertyExpression).getReferencedInstanceObject());
		return components;
	}

	public static List getActualConnectionBinding(final NamedElement ne) {
		initialize();
		try {
			return ne.getPropertyValueList(actualConnectionBinding);
		} catch (Throwable e) {
			return null;
		}
	}

	public static double getMIPSCapacityInMIPS(final NamedElement ne, final double defaultValue) {
		initialize();
		try {
			return PropertyUtils.getScaledNumberValue(ne, MIPSCapacity, MIPS, defaultValue);
		} catch (Throwable e) {
			return defaultValue;
		}
	}

	public static double getMIPSBudgetInMIPS(final NamedElement ne, final double defaultValue) {
		initialize();
		try {
			return PropertyUtils.getScaledNumberValue(ne, MIPSBudget, MIPS, defaultValue);
		} catch (Throwable e) {
			return defaultValue;
		}
	}

	public static UnitLiteral getMIPSUnitLiteral() {
		initialize();
		return MIPS;
	}

	public static UnitLiteral getMSUnitLiteral() {
		initialize();
		return microSecond;
	}

	public static Property getActualConnectionBinding() {
		initialize();
		return actualConnectionBinding;
	}

	public static Property getTransmissionTime() {
		initialize();
		return TransmissionTime;
	}

	public static Property getMIPSCapacityPD() {
		initialize();
		return MIPSCapacity;
	}

	public static Property getMIPSBudgetPD() {
		initialize();
		return MIPSBudget;
	}

	public static Property getRAMCapacityPD() {
		initialize();
		return RAMCapacity;
	}

	public static Property getRAMBudgetPD() {
		initialize();
		return RAMBudget;
	}

	public static Property getROMCapacityPD() {
		initialize();
		return ROMCapacity;
	}

	public static Property getROMBudgetPD() {
		initialize();
		return ROMBudget;
	}

	public static Property getRAMActualPD() {
		initialize();
		return RAMActual;
	}

	public static Property getROMActualPD() {
		initialize();
		return ROMActual;
	}

	public static double getBandWidthCapacityInKbps(final NamedElement ne, final double defaultValue) {
		initialize();
		try {
			return PropertyUtils.getScaledNumberValue(ne, BandWidthCapacity, Kbps, defaultValue);
		} catch (Throwable e) {
			return defaultValue;
		}
	}

	public static double getBandWidthBudgetInKbps(final NamedElement ne, final double defaultValue) {
		initialize();
		try {
			return PropertyUtils.getScaledNumberValue(ne, BandWidthBudget, Kbps, defaultValue);
		} catch (Throwable e) {
			return defaultValue;
		}
	}

	public static ComponentClassifier getReferenceProcessor(final NamedElement ne) {
		initialize();
		PropertyExpression pv = null;
		;
		try {
			pv = ne.getSimplePropertyValue(referenceProcessor);
		} catch (Exception e) {
		}
		if (pv == null)
			return null;
		return (ComponentClassifier) ((ClassifierValue) pv).getClassifier();

	}

	public static double getCycleTimeinMS(final NamedElement ne) {
		initialize();
		return PropertyUtils.getScaledNumberValue(ne, cycleTime, microSecond, 0.0);
	}

	public static double scaleValueToMicroSecond(final NumberValue nv) {
		initialize();
		return nv.getScaledValue(microSecond);
	}

	public static UnitLiteral getBytesUnitLiteral() {
		initialize();
		return Bytes;
	}

	public static UnitLiteral getKBUnitLiteral() {
		initialize();
		return KBytes;
	}

	public static UnitLiteral getMBUnitLiteral() {
		initialize();
		return MBytes;
	}

	public static UnitLiteral getGBUnitLiteral() {
		initialize();
		return GBytes;
	}

	public static UnitLiteral getKbpsUnitLiteral() {
		initialize();
		return Kbps;
	}

	public static double getActualMIPS(ComponentInstance bci) {
		initialize();
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
		initialize();
		double cycleTime = 0.0;
		ComponentClassifier pci = null;
		pci = getReferenceProcessor(thread);
		if (pci != null) {
			cycleTime = getCycleTimeinMS(pci);
		}
		if (cycleTime == 0.0) {
			cycleTime = getReferenceCycleTimeConstantinMS();
		}
		return cycleTime;
	}

	public static double getReferenceCycleTimeConstantinMS() {
		initialize();
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
		initialize();
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
		initialize();
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
		initialize();
		double cycleTime = getCycleTimeinMS(curprocessor);
		if (cycleTime != 0.0) {
			// time for MIPS therefore microsec (10E-6)
			// 1 / cycletime => # of MIPS in terms of one instruction per cycle
			return (1 / cycleTime);
		} else
			return 0;
	}

	public static double getPowerCapacity(final NamedElement ne, final double defaultValue) {
		initialize();
		return PropertyUtils.getScaledNumberValue(ne, powerCapacity, mWatt, defaultValue);
	}

	public static double getPowerBudget(final NamedElement ne, final double defaultValue) {
		initialize();
		return PropertyUtils.getScaledNumberValue(ne, powerBudget, mWatt, defaultValue);
	}

	public static double getPowerSupply(final NamedElement ne, final double defaultValue) {
		initialize();
		if (SaviSupplyPD != null) {
			double savisupply = PropertyUtils.getScaledNumberValue(ne, SaviSupplyPD, mWatt, -1);
			if (savisupply >= 0) {
				return savisupply;
			}
		}
		return PropertyUtils.getScaledNumberValue(ne, powerSupply, mWatt, defaultValue);
	}

	public static double getPeriodinMS(final NamedElement ne) {
		initialize();
		return PropertyUtils.getScaledNumberValue(ne, period, microSecond, 0.0);
	}

	public static double getActualLatencyinMS(final NamedElement ne) {
		initialize();
		return PropertyUtils.getScaledNumberValue(ne, actualLatency, microSecond, 0.0);
	}

	public static long getQueueSize(final NamedElement ne) {
		initialize();
		return PropertyUtils.getIntegerValue(ne, queuesize, 0);
	}

	public static double getMIPSBudget(final NamedElement ne) {
		initialize();
		return PropertyUtils.getScaledNumberValue(ne, MIPSBudget, MIPS, 0.0);
	}

	public static double getDeadlineinMS(final NamedElement ne) {
		initialize();
		return PropertyUtils.getScaledNumberValue(ne, deadline, microSecond, 0.0);
	}

	public static double getComputeExecutionTimeinMS(final NamedElement ne) {
		initialize();
		double time = PropertyUtils.getScaledRangeMaximum(ne, computeExecutionTime, microSecond, 0.0);
		if (ne instanceof ComponentInstance) {
			double scale = getProcessorScalingFactor((ComponentInstance) ne);
			return time * scale;
		}
		return time;
	}

	public static double getComputeExecutionTimeInSec(final NamedElement ne, final double defaultValue) {
		initialize();
		try {
			return PropertyUtils.getScaledRangeMaximum(ne, computeExecutionTime, second, defaultValue);
		} catch (Throwable e) {
			return defaultValue;
		}
	}

	public static double getPeriodInSeconds(final NamedElement ne, final double defaultValue) {
		initialize();
		return PropertyUtils.getScaledNumberValue(ne, period, second, defaultValue);
	}

	public static long getPriority(final NamedElement ne, final long defaultValue) {
		initialize();
		return PropertyUtils.getIntegerValue(ne, priority, defaultValue);
	}

	public static String getSchedulingProtocol(final NamedElement ne, final String defaultValue) {
		initialize();
		try {
			return PropertyUtils.getEnumLiteral(ne, schedulingprotocol).getName();
		} catch (PropertyLookupException e) {
			return defaultValue;
		}
	}

	public static EnumerationLiteral getDispatchProtocol(final NamedElement ne) {
		initialize();
		try {
			return PropertyUtils.getEnumLiteral(ne, dispatchProtocol);
		} catch (final PropertyLookupException e) {
			return null;
		}
	}

	public static double getSourceDataSizeInBytes(final NamedElement ne) {
		initialize();
		try {
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
		initialize();
		try {
			return PropertyUtils.getScaledNumberValue(ne, SourceCodeSize, Bytes);
		} catch (PropertyLookupException e) {
			return 0.0;
		}
	}
	
	public static double getSourceStackSizeInBytes(final NamedElement ne) {
		initialize();
		try 
		{
			return PropertyUtils.getScaledNumberValue(ne, SourceStackSize, Bytes);
		}
		catch (PropertyLookupException e)
		{
			return 0.0;
		}
	}

	public static EnumerationLiteral getDeviceDispatchProtocol(final NamedElement ne) {
		initialize();
		try {
			return PropertyUtils.getEnumLiteral(ne, deviceDispatchProtocol);
		} catch (PropertyLookupException e) {
			return null;
		}
	}

	public static double getPartitionLatencyInMS(final NamedElement ne, final double defaultValue) {
		initialize();
		try {
			return PropertyUtils.getScaledNumberValue(ne, partitionLatency, microSecond, defaultValue);
		} catch (PropertyLookupException e) {
			return defaultValue;
		}
	}

	public static boolean getIsPartition(final NamedElement ne) {
		initialize();
		try {
			return PropertyUtils.getBooleanValue(ne, isPartition);
		} catch (PropertyLookupException e) {
			return false;
		}
	}

	public static double getLatencyinMS(final NamedElement ne) {
		initialize();
		try {
			return PropertyUtils.getScaledNumberValue(ne, Latency, microSecond);
		} catch (PropertyLookupException e) {
			return 0.0;
		}
	}

	public static double getAccessLatencyinMS(final ComponentInstance HWcomp, final ComponentInstance bus) {
		initialize();
		ConnectionInstance aci = ConnectionBindingUtil.getBusAccessConnection(HWcomp, bus);
		if (aci == null)
			return 0.0;
		try {
			return PropertyUtils.getScaledNumberValue(aci, Latency, microSecond);
		} catch (PropertyLookupException e) {
			return 0.0;
		}
	}

	public static double getExpectedLatencyinMS(final NamedElement ne) {
		initialize();
		try {
			return PropertyUtils.getScaledNumberValue(ne, expectedLatency, microSecond);
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
		initialize();
		return PropertyUtils.getIntegerValue(ne, byteCount, 0);
	}
	
	public static UnitLiteral getMilliSecondUnit ()
	{
		initialize();
		return milliSecond;
	}
	
	public static UnitLiteral getMicroSecondUnit ()
	{
		initialize();
		return microSecond;
	}
	
	public static UnitLiteral getSecondUnit ()
	{
		initialize();
		return second;
	}
}