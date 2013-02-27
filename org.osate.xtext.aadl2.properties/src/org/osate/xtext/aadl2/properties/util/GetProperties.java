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
package org.osate.xtext.aadl2.properties.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyIsListException;
import org.osate.aadl2.properties.PropertyIsModalException;
import org.osate.aadl2.properties.PropertyLookupException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.contribution.sei.names.SEI;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;


public class GetProperties {


	/**
	 * find property definition for given name. The property may be qualified by the property set name via the ps parameter
	 * For predeclared properties this is not required
	 * @param context EObject the model object that references the property definition
	 * @param ps String property set name, which may be null
	 * @param name String Property Definition name
	 * @return Property or null
	 */
	public static Property lookupPropertyDefinition(EObject context,String ps, String name) {
		return EMFIndexRetrieval.getPropertyDefinitionInWorkspace(context,((ps != null&& !ps.isEmpty())?(ps+ "::" +name):name));
	}


	/**
	 * find property type for given name. The property may be qualified by the property set name via the ps parameter
	 * For predeclared properties this is not required
	 * @param context EObject the model object that references the property definition
	 * @param ps String property set name, which may be null
	 * @param name String Property Type name
	 * @return PropertyType or null
	 */
	public static PropertyType lookupPropertyType(EObject context,String ps, String name) {
		return EMFIndexRetrieval.getPropertyTypeInWorkspace(context,((ps != null&& !ps.isEmpty())?(ps+ "::" +name):name));
	}

	/**
	 * find property type for given name. The property may be qualified by the property set name via the ps parameter
	 * For predeclared properties this is not required
	 * @param context EObject the model object that references the property definition
	 * @param qname String Property Type qualified name
	 * @return PropertyType or null
	 */
	public static PropertyType lookupPropertyType(EObject context, String qname) {
		return EMFIndexRetrieval.getPropertyTypeInWorkspace(context,qname);
	}


	/**
	 * find property constant for given name. The property may be qualified by the property set name via the ps parameter
	 * For predeclared properties this is not required
	 * @param context EObject the model object that references the property definition
	 * @param ps String property set name, which may be null
	 * @param name String Property Constant name
	 * @return PropertyConstant or null
	 */
	public static PropertyConstant lookupPropertyConstant(EObject context,String ps, String name) {
		return EMFIndexRetrieval.getPropertyConstantInWorkspace(context,((ps != null&& !ps.isEmpty())?(ps+ "::" +name):name));
	}

	/**
	 * find property constant for given name. The property may be qualified by the property set name via the ps parameter
	 * For predeclared properties this is not required
	 * @param context EObject the model object that references the property definition
	 * @param ps String property set name, which may be null
	 * @param name String Property Constant name
	 * @return PropertyConstant or null
	 */
	public static PropertyConstant lookupPropertyConstant(EObject context, String qname) {
		return EMFIndexRetrieval.getPropertyConstantInWorkspace(context,qname);
	}

	/**
	 * Retrieve the unit literal given a unit string for a property It is useful
	 * when calling getScaledValue methods that require the literal as object
	 * @param pd Property Definition
	 * @param literalname String
	 * @return UnitLiteral or null if the unit literal could not be found or the
	 *         definition does not have a unit
	 */
	public static UnitLiteral findUnitLiteral(Property pd, String literalname) {
		return PropertiesLinkingService.findUnitLiteral(pd, literalname);
	}
	
	public static UnitLiteral findUnitLiteral(Element context,String unitsType, String literal){
		PropertyType pt = lookupPropertyType(context,unitsType);
		if (pt == null || ! (pt instanceof UnitsType)) return null;
		return (UnitLiteral) ((UnitsType)pt).findNamedElement(literal);
	}
	
	public static EnumerationLiteral findEnumerationLiteral(Property pd, String literalname) {
		return PropertiesLinkingService.findEnumerationLiteral(pd, literalname);
	}
	
	public static EnumerationLiteral findEnumerationLiteral(Element context,String enumerationType, String literal){
		PropertyType pt = lookupPropertyType(context,enumerationType);
		if (pt == null || ! (pt instanceof EnumerationType)) return null;
		return (EnumerationLiteral) ((EnumerationType)pt).findNamedElement(literal);
	}
	
	public static UnitLiteral getKBUnitLiteral(NamedElement context){
		return findUnitLiteral(context,AadlProject.SIZE_UNITS, AadlProject.KB_LITERAL);
	}
	
	public static UnitLiteral getMSUnitLiteral(NamedElement context){
		return findUnitLiteral(context,AadlProject.TIME_UNITS, AadlProject.MS_LITERAL);
	}
	
	public static UnitLiteral getUSUnitLiteral(NamedElement context){
		return findUnitLiteral(context,AadlProject.TIME_UNITS, AadlProject.US_LITERAL);
	}
	
	public static UnitLiteral getSecUnitLiteral(NamedElement context){
		return findUnitLiteral(context,AadlProject.TIME_UNITS, AadlProject.SEC_LITERAL);
	}
	
	public static UnitLiteral getMIPSUnitLiteral(NamedElement context){
		return findUnitLiteral(context,"SEI::"+SEI.PROCESSOR_SPEED_UNITS, SEI.MIPS_LITERAL);
	}
	
	
	public static Property getActualProcessorBindingProperty(final ComponentInstance io) {
	return lookupPropertyDefinition(io, DeploymentProperties._NAME,
			DeploymentProperties.ACTUAL_PROCESSOR_BINDING);
	}

	public static List<ComponentInstance> getActualProcessorBinding(final ComponentInstance io) {
		Property actualProcessorBinding = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ACTUAL_PROCESSOR_BINDING);
		List<? extends PropertyExpression> propertyValues = io.getPropertyValueList(actualProcessorBinding);
		ArrayList<ComponentInstance> components = new ArrayList<ComponentInstance>();
		for (PropertyExpression propertyExpression : propertyValues){
			InstanceObject obj = ((InstanceReferenceValue)propertyExpression).getReferencedInstanceObject();
			components.add((ComponentInstance)obj);
		}
		return components;
	}

	public static List<ComponentInstance> getActualConnectionBinding(final ComponentInstance io) {
		Property actualConnectionBinding = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ACTUAL_CONNECTION_BINDING);
		List<? extends PropertyExpression> propertyValues = io.getPropertyValueList(actualConnectionBinding);
		ArrayList<ComponentInstance> components = new ArrayList<ComponentInstance>();
		for (PropertyExpression propertyExpression : propertyValues)
			components.add((ComponentInstance)((InstanceReferenceValue)propertyExpression).getReferencedInstanceObject());
		return components;
	}


	public static List<ComponentInstance> getAllowedProcessorBinding(final ComponentInstance io) {
		Property allowedProcessorBinding = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ALLOWED_PROCESSOR_BINDING);
		List<? extends PropertyExpression> propertyValues = io.getPropertyValueList(allowedProcessorBinding);
		ArrayList<ComponentInstance> components = new ArrayList<ComponentInstance>();
		for (PropertyExpression propertyExpression : propertyValues)
			components.add((ComponentInstance)((InstanceReferenceValue)propertyExpression).getReferencedInstanceObject());
		return components;
	}


	public static List<ComponentClassifier> getAllowedProcessorBindingClass(final ComponentInstance io) {
		Property allowedProcessorBindingClass = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ALLOWED_PROCESSOR_BINDING_CLASS);
		List<? extends PropertyExpression> propertyValues = io.getPropertyValueList(allowedProcessorBindingClass);
		ArrayList<ComponentClassifier> components = new ArrayList<ComponentClassifier>();
		for (PropertyExpression propertyExpression : propertyValues)
			components.add((ComponentClassifier)((InstanceReferenceValue)propertyExpression).getReferencedInstanceObject());
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
			Property actualConnectionBinding = lookupPropertyDefinition(ne,DeploymentProperties._NAME,
					DeploymentProperties.ACTUAL_CONNECTION_BINDING);
			return ne.getPropertyValueList(actualConnectionBinding);
	}

	public static double getMIPSCapacityInMIPS(final NamedElement ne, final double defaultValue) {
			Property MIPSCapacity = lookupPropertyDefinition(ne,SEI._NAME, SEI.MIPS_CAPACITY);
			UnitLiteral MIPS = findUnitLiteral(MIPSCapacity, SEI.MIPS_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, MIPSCapacity, MIPS, defaultValue);
	}

	public static double getMIPSBudgetInMIPS(final NamedElement ne, final double defaultValue) {
			Property MIPSBudget = lookupPropertyDefinition(ne,SEI._NAME, SEI.MIPS_BUDGET);
			UnitLiteral MIPS = findUnitLiteral(MIPSBudget, SEI.MIPS_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, MIPSBudget, MIPS, defaultValue);
	}

	public static double getRAMCapacityInKB(final NamedElement ne, final double defaultValue) {
			Property RAMCapacity = lookupPropertyDefinition(ne,SEI._NAME, SEI.RAM_CAPACITY);
			UnitLiteral kb = findUnitLiteral(RAMCapacity, AadlProject.KB_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, RAMCapacity, kb, defaultValue);
	}

	public static double getRAMBudgetInKB(final NamedElement ne, final double defaultValue) {
			Property RAMBudget = lookupPropertyDefinition(ne,SEI._NAME, SEI.RAM_BUDGET);
			UnitLiteral kb = findUnitLiteral(RAMBudget, AadlProject.KB_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, RAMBudget, kb, defaultValue);
	}

	public static double getRAMActualInKB(final NamedElement ne, final double defaultValue) {
			Property RAMActual = lookupPropertyDefinition(ne,SEI._NAME, SEI.RAM_ACTUAL);
			UnitLiteral kb = findUnitLiteral(RAMActual, AadlProject.KB_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, RAMActual, kb, defaultValue);
	}

	public static double getROMCapacityInKB(final NamedElement ne, final double defaultValue) {
			Property ROMCapacity = lookupPropertyDefinition(ne,SEI._NAME, SEI.ROM_CAPACITY);
			UnitLiteral kb = findUnitLiteral(ROMCapacity, AadlProject.KB_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, ROMCapacity, kb, defaultValue);
	}

	public static double getROMBudgetInKB(final NamedElement ne, final double defaultValue) {
			Property ROMBudget = lookupPropertyDefinition(ne,SEI._NAME, SEI.ROM_BUDGET);
			UnitLiteral kb = findUnitLiteral(ROMBudget, AadlProject.KB_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, ROMBudget, kb, defaultValue);
	}

	public static double getROMActualInKB(final NamedElement ne, final double defaultValue) {
			Property ROMActual = lookupPropertyDefinition(ne,SEI._NAME, SEI.ROM_ACTUAL);
			UnitLiteral kb = findUnitLiteral(ROMActual, AadlProject.KB_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, ROMActual, kb, defaultValue);
	}

	public static double getBandWidthCapacityInKbps(final NamedElement ne, final double defaultValue) {
			Property BandWidthCapacity = lookupPropertyDefinition(ne,SEI._NAME, SEI.BANDWIDTH_CAPACITY);
			UnitLiteral Kbps = findUnitLiteral(BandWidthCapacity, AadlProject.KBYTESPS_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, BandWidthCapacity, Kbps, defaultValue);
	}

	public static double getBandWidthBudgetInKbps(final NamedElement ne, final double defaultValue) {
			Property BandWidthBudget = lookupPropertyDefinition(ne,SEI._NAME, SEI.BANDWIDTH_BUDGET);
			UnitLiteral Kbps = findUnitLiteral(BandWidthBudget, AadlProject.KBYTESPS_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, BandWidthBudget, Kbps, defaultValue);
	}

	public static ComponentClassifier getReferenceProcessor(final NamedElement ne) {
			Property referenceProcessor = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.REFERENCE_PROCESSOR);
			if (referenceProcessor == null) return null;
			try {
				PropertyExpression pv = ne.getSimplePropertyValue(referenceProcessor);
				if (pv != null)
					return (ComponentClassifier) ((ClassifierValue) pv).getClassifier();
			} catch (Exception e) {
			}
			return null;
	}
	

	/**
	 * instruction execution time of processor
	 * This is calculated from the MIPSCapacity.
	 * This function acts as replacement for the cycle_time property
	 * @param proc processor component instance
	 * @return
	 */
	public static double getInstructionExecutionTimeinUS(final ComponentInstance proc) {
		return 1/getProcessorMIPS(proc);
	}
	/**
	 * instruction execution time of processor
	 * This is calculated from the MIPSCapacity.
	 * This function acts as replacement for the cycle_time property
	 * @param proc processor component instance
	 * @return
	 */
	public static double getInstructionExecutionTimeinSec(final ComponentInstance proc) {
		return 1/(getProcessorMIPS(proc)*1e6);
	}
	
	
	public static double getPartitionLatencyInMilliSec(final NamedElement ph, final double defaultValue)
	{
			Property pl =lookupPropertyDefinition(ph,SEI._NAME, SEI.PARTITION_LATENCY);
			return PropertyUtils.getScaledNumberValue(ph, pl, 
					findUnitLiteral(pl, AadlProject.MS_LITERAL), defaultValue);
	}
	
	public static double getPartitionLatencyInMicroSec(final NamedElement ph, final double defaultValue)
	{
			Property pl =lookupPropertyDefinition(ph,SEI._NAME, SEI.PARTITION_LATENCY);
			return PropertyUtils.getScaledNumberValue(ph, pl, 
					findUnitLiteral(pl, AadlProject.US_LITERAL), defaultValue);
	}


	public static double scaleValueToMicroSecond(final NumberValue nv) {
		UnitLiteral microSecond = PropertiesLinkingService.findUnitLiteral(nv, AadlProject.US_LITERAL);
		return nv.getScaledValue(microSecond);
	}

	public static double scaleValueToSecond(final NumberValue nv) {
		UnitLiteral second = PropertiesLinkingService.findUnitLiteral(nv, AadlProject.SEC_LITERAL);
		return nv.getScaledValue(second);
	}

	

	public static RecordValue getTransmissionTime(final NamedElement ne) {
		Property xmissionTime = lookupPropertyDefinition(ne,CommunicationProperties._NAME, CommunicationProperties.TRANSMISSION_TIME);
		try {
		return (RecordValue) PropertyUtils.getSimplePropertyValue(ne, xmissionTime);
		} catch (PropertyLookupException e) {
			return null;
		}
	}


	
	public static double fromMStoSec(NamedElement ne, double value){
		return convertToScale(value, getMSUnitLiteral(ne), getSecUnitLiteral(ne));
	}
	
	public static double fromUStoSec(NamedElement ne, double value){
		return convertToScale(value, getUSUnitLiteral(ne), getSecUnitLiteral(ne));
	}

	/**
	 * calculate the scaling factor from the MIPSCapacity of the two processors.
	 * The default value is 1
	 * @param thread
	 * @return double scaling factor of processor speed
	 */
	public static double getProcessorScalingFactor(final ComponentInstance thread) {
		double refmipspersec = getReferenceMIPS(thread);
		double mipspersec = getBoundProcessorMIPS(thread);
		if (refmipspersec == 0 || mipspersec == 0 )
			return 1;
		return refmipspersec / mipspersec;
	}

	/**
	 * Get the MIPS per sec of the reference processor. First tries to find the
	 * MIPS capacity. It then tries an explicit reference processor. If it finds
	 * it, then it gets the cycle time of that processor. 
	 */
	public static double getReferenceMIPS(final ComponentInstance thread) {
		ComponentClassifier pci = getReferenceProcessor(thread);
		if (pci != null) {
			return getMIPSCapacityInMIPS(pci, 0.0);
		}
		return 0.0;
	}
	/**
	 * Get the MIPS per sec of the bound processor. First tries to find the
	 * MIPS capacity.  If it does not find
	 * it, then it gets the cycle time of that processor. 
	 * Failing that, it returns a
	 * value corresponding to a 1GIPS processor.
	 */
	public static double getBoundProcessorMIPS(final ComponentInstance thread) {
		List<ComponentInstance> pciList = getActualProcessorBinding(thread);
		ComponentInstance pci = pciList.isEmpty() ? null : pciList.get(0);
		if (pci != null) {
			return getMIPSCapacityInMIPS(pci, 0);
		}
		return 0.0;
	}
	
	/**
	 * Get the MIPS of the  processor from the MIPSCapacity.  
	 */
	public static double getProcessorMIPS(final ComponentInstance processor) {
		return getMIPSCapacityInMIPS(processor, 0);
	}
	
	
	/**
	 * compute MIPS for thread based on instructions per dispatch; 
	 * @param threadinstance thread instance
	 * @return MIPS or 0.0
	 */
	public static double getThreadExecutionIPDinMIPS(ComponentInstance threadinstance) {
		double period = getPeriodInSeconds(threadinstance, 0.0);
		double mipd = getSpecifiedThreadInstructionsinMIPD(threadinstance);
		if (mipd > 0 && period > 0) {
			double mips = mipd / period;
			return mips;
		}
		return 0.0;
	}
	
	/**
	 * compute MIPS for thread based on instructions per dispatch; or based on specified execution time
	 * @param threadinstance thread instance
	 * @return MIPS or 0.0
	 */
	public static double getThreadExecutioninMIPS(ComponentInstance threadinstance) {
		double mips = getThreadExecutionIPDinMIPS(threadinstance);
		if (mips == 0){
			double period = getPeriodInSeconds(threadinstance, 0.0);
			double exectimeval = getSpecifiedComputeExecutionTimeinSec(threadinstance);
			if (exectimeval > 0 && period > 0) {
				double mipspersec = getReferenceMIPS(threadinstance);
				double time = exectimeval / period;
				mips = time * mipspersec;
			}
		}
		return mips;
	}

	
	/**
	 * compute Execution time for actual processor from instructions per dispatch; or based on specified execution time
	 * @param threadinstance thread instance
	 * @return double scaled execution time in Sec
	 */
	public static double getThreadExecutioninSec(ComponentInstance threadinstance) {
		double mipd = getSpecifiedThreadInstructionsinMIPD(threadinstance);
		double actualProcMips = getBoundProcessorMIPS(threadinstance);
		if (mipd > 0 && actualProcMips > 0) {
			return mipd / actualProcMips;
		}
		return getScaledComputeExecutionTimeinSec(threadinstance);
	}
	
	/**
	 * compute Execution time for actual processor from instructions per dispatch; or based on specified execution time
	 * @param threadinstance thread instance
	 * @return double scaled execution time in Sec
	 */
	public static double getThreadExecutioninMilliSec(ComponentInstance threadinstance) {
		double mipd = getSpecifiedThreadInstructionsinMIPD(threadinstance);
		double actualProcMips = getBoundProcessorMIPS(threadinstance);
		if (mipd > 0 && actualProcMips > 0) {
			// adjust from sec to milli sec
			return (mipd / actualProcMips)*1000;
		}
		return getScaledComputeExecutionTimeinMS(threadinstance);
	}

	/**
	 * get execution time scaled in terms of the processor the thread is bound to
	 * If it is not bound then return the specified execution time
	 * @param ne thread component instance
	 * @return scaled time or 0.0
	 */
	public static double getScaledComputeExecutionTimeinMS(final NamedElement ne) {
		Property computeExecutionTime = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.COMPUTE_EXECUTION_TIME);
		UnitLiteral milliSecond = findUnitLiteral(computeExecutionTime, AadlProject.MS_LITERAL);
		double time = PropertyUtils.getScaledRangeMaximum(ne, computeExecutionTime, milliSecond, 0.0);
		if (ne instanceof ComponentInstance) {
			double scale = getProcessorScalingFactor((ComponentInstance) ne);
			return time * scale;
		}
		return time;
	}

	/**
	 * get execution time scaled in terms of the processor the thread is bound to
	 * If it is not bound then return the specified execution time
	 * @param ne thread component instance
	 * @return scaled time or 0.0
	 */
	public static double getScaledComputeExecutionTimeinSec(final NamedElement ne) {
		Property computeExecutionTime = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.COMPUTE_EXECUTION_TIME);
		UnitLiteral second = findUnitLiteral(computeExecutionTime, AadlProject.SEC_LITERAL);
		double time = PropertyUtils.getScaledRangeMaximum(ne, computeExecutionTime, second, 0.0);
		if (ne instanceof ComponentInstance) {
			double scale = getProcessorScalingFactor((ComponentInstance) ne);
			return time * scale;
		}
		return time;
	}

	/**
	 * get execution time as specified - not adjusted for different processor speeds
	 * @param ne thread component instance
	 * @return specified time or 0.0
	 */
	public static double getSpecifiedComputeExecutionTimeinSec(final NamedElement ne) {
		Property computeExecutionTime = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.COMPUTE_EXECUTION_TIME);
		UnitLiteral second = findUnitLiteral(computeExecutionTime, AadlProject.SEC_LITERAL);
		double time = PropertyUtils.getScaledRangeMaximum(ne, computeExecutionTime, second, 0.0);
		return time;
	}

	/**
	 * get specified instructions per dispatch as MIPD
	 * @param ne thread component instance
	 * @return double MIPD
	 */
	public static double getSpecifiedThreadInstructionsinMIPD(final NamedElement ne) {
		Property ipd = lookupPropertyDefinition(ne,SEI._NAME, SEI.INSTRUCTIONSPERDISPATCH);
		UnitLiteral mipdunit = findUnitLiteral(ipd, SEI.MIPD_LITERAL);
		double mipd = PropertyUtils.getScaledRangeMaximum(ne, ipd, mipdunit, 0.0);
		return mipd;
	}

	/**
	 * get specified instructions per dispatch as IPD
	 * @param ne thread component instance
	 * @return double IPD
	 */
	public static double getSpecifiedThreadInstructionsinIPD(final NamedElement ne) {
		Property ipd = lookupPropertyDefinition(ne,SEI._NAME, SEI.INSTRUCTIONSPERDISPATCH);
		UnitLiteral mipdunit = findUnitLiteral(ipd, SEI.IPD_LITERAL);
		double mipd = PropertyUtils.getScaledRangeMaximum(ne, ipd, mipdunit, 0.0);
		return mipd;
	}

	public static double getPowerCapacity(final NamedElement ne, final double defaultValue) {
		Property powerCapacity = lookupPropertyDefinition(ne,SEI._NAME, SEI.POWER_CAPACITY);
		UnitLiteral mWatt = findUnitLiteral(powerCapacity, SEI.MW_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, powerCapacity, mWatt, defaultValue);
	}

	public static double getPowerBudget(final NamedElement ne, final double defaultValue) {
		Property powerBudget = lookupPropertyDefinition(ne,SEI._NAME, SEI.POWER_BUDGET);
		UnitLiteral mWatt = findUnitLiteral(powerBudget, SEI.MW_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, powerBudget, mWatt, defaultValue);
	}

	public static double getPowerSupply(final NamedElement ne, final double defaultValue) {
		Property powerSupply = lookupPropertyDefinition(ne,SEI._NAME, SEI.POWER_SUPPLY);
		UnitLiteral mWatt = findUnitLiteral(powerSupply, SEI.MW_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, powerSupply, mWatt, defaultValue);
	}

	public static double getPeriodinMS(final NamedElement ne) {
		Property period = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.PERIOD);
		UnitLiteral milliSecond = findUnitLiteral(period, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, period, milliSecond, 0.0);
	}

	public static double getPeriodinMicroSec(final NamedElement ne) {
		Property period = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.PERIOD);
		UnitLiteral microSecond = findUnitLiteral(period, AadlProject.US_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, period, microSecond, 0.0);
	}

	public static double getPeriodinNS(final NamedElement ne) {
		Property period = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.PERIOD);
		UnitLiteral microSecond = findUnitLiteral(period, AadlProject.NS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, period, microSecond, 0.0);
	}

	public static double getActualLatencyinMS(final NamedElement ne) {
		Property actualLatency = lookupPropertyDefinition(ne,CommunicationProperties._NAME, CommunicationProperties.ACTUAL_LATENCY);
		UnitLiteral milliSecond = findUnitLiteral(actualLatency, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, actualLatency, milliSecond, 0.0);
	}

	public static double getActualLatencyinMicroSec(final NamedElement ne) {
		Property actualLatency = lookupPropertyDefinition(ne,CommunicationProperties._NAME, CommunicationProperties.ACTUAL_LATENCY);
		UnitLiteral microSecond = findUnitLiteral(actualLatency, AadlProject.US_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, actualLatency, microSecond, 0.0);
	}

	public static long getQueueSize(final NamedElement ne) {
		Property queuesize = lookupPropertyDefinition(ne,CommunicationProperties._NAME, CommunicationProperties.QUEUE_SIZE);
		return PropertyUtils.getIntegerValue(ne, queuesize, 0);
	}

	public static double getMIPSBudgetInMIPS(final NamedElement ne) {
		return getMIPSBudgetInMIPS(ne, 0.0);
	}

	public static double getDeadlineinSec(final NamedElement ne) {
		Property deadline = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.DEADLINE);
		UnitLiteral second = findUnitLiteral(deadline, AadlProject.SEC_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, deadline, second, 0.0);
	}

	public static double getDeadlineinMilliSec(final NamedElement ne) {
		Property deadline = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.DEADLINE);
		UnitLiteral milliSecond = findUnitLiteral(deadline, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, deadline, milliSecond, 0.0);
	}

	public static double getDeadlineinMicroSec(final NamedElement ne) {
		Property deadline = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.DEADLINE);
		UnitLiteral microSecond = findUnitLiteral(deadline, AadlProject.US_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, deadline, microSecond, 0.0);
	}

	public static double getDeadlineinNS(final NamedElement ne) {
		Property deadline = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.DEADLINE);
		UnitLiteral nanoSecond = findUnitLiteral(deadline, AadlProject.NS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, deadline, nanoSecond, 0.0);
	}


	public static double getPeriodInSeconds(final NamedElement ne, final double defaultValue) {
		Property period = lookupPropertyDefinition(ne,TimingProperties._NAME, TimingProperties.PERIOD);
		UnitLiteral second = findUnitLiteral(period, AadlProject.SEC_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, period, second, defaultValue);
	}

	public static long getPriority(final NamedElement ne, final long defaultValue) {
		Property priority = lookupPropertyDefinition(ne,ThreadProperties._NAME, ThreadProperties.PRIORITY);
		return PropertyUtils.getIntegerValue(ne, priority, defaultValue);
	}

	public static String getSchedulingProtocol(final NamedElement ne) {
		try {
			Property schedulingprotocol = lookupPropertyDefinition(ne,DeploymentProperties._NAME, DeploymentProperties.SCHEDULING_PROTOCOL);
			return PropertyUtils.getEnumLiteral(ne, schedulingprotocol).getName();
		} catch (PropertyLookupException e) {
			return null;
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
			Property SourceDataSize = lookupPropertyDefinition(ne,MemoryProperties._NAME, MemoryProperties.SOURCE_DATA_SIZE);
			UnitLiteral Bytes = findUnitLiteral(SourceDataSize, AadlProject.B_LITERAL);
			double res = PropertyUtils.getScaledNumberValue(ne, SourceDataSize, Bytes, 0.0);
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
	}
	
	public static double getSourceCodeSizeInBytes(final NamedElement ne) {
			Property SourceCodeSize = lookupPropertyDefinition(ne,MemoryProperties._NAME, MemoryProperties.SOURCE_CODE_SIZE);
			UnitLiteral Bytes = findUnitLiteral(SourceCodeSize, AadlProject.B_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, SourceCodeSize, Bytes,0.0);
	}
	
	public static double getSourceStackSizeInBytes(final NamedElement ne) {
			Property SourceStackSize = lookupPropertyDefinition(ne,MemoryProperties._NAME, MemoryProperties.SOURCE_STACK_SIZE);
			UnitLiteral Bytes = findUnitLiteral(SourceStackSize, AadlProject.B_LITERAL);
			return PropertyUtils.getScaledNumberValue(ne, SourceStackSize, Bytes,0.0);
	}


	public static boolean getIsPartition(final NamedElement ne) {
		try {
			Property isPartition = lookupPropertyDefinition(ne,SEI._NAME, SEI.IS_PARTITION);
			return PropertyUtils.getBooleanValue(ne, isPartition);
		} catch (PropertyLookupException e) {
			return false;
		}
	}

	public static double getLatencyinMilliSec(final NamedElement ne) {
			Property Latency = lookupPropertyDefinition(ne,CommunicationProperties._NAME, CommunicationProperties.LATENCY);
			UnitLiteral milliSecond = PropertiesLinkingService.findUnitLiteral(Latency, AadlProject.MS_LITERAL);
			return PropertyUtils.getScaledRangeMaximum(ne, Latency, milliSecond,0.0);
	}

	public static double getLatencyinMicroSec(final NamedElement ne) {
			Property Latency = lookupPropertyDefinition(ne,CommunicationProperties._NAME, CommunicationProperties.LATENCY);
			UnitLiteral microSecond = PropertiesLinkingService.findUnitLiteral(Latency, AadlProject.US_LITERAL);
			return PropertyUtils.getScaledRangeMaximum(ne, Latency, microSecond,0.0);
	}

	public static double getAccessLatencyinMilliSec(final ComponentInstance HWcomp, final ComponentInstance bus) {
		ConnectionInstance aci = ConnectionBindingUtil.getBusAccessConnection(HWcomp, bus);
		if (aci == null)
			return 0.0;
			Property Latency = lookupPropertyDefinition(aci,CommunicationProperties._NAME, CommunicationProperties.LATENCY);
			UnitLiteral milliSecond = PropertiesLinkingService.findUnitLiteral(Latency, AadlProject.MS_LITERAL);
			return PropertyUtils.getScaledRangeMaximum(aci, Latency, milliSecond,0.0);
	}

	public static double getAccessLatencyinMicroSec(final ComponentInstance HWcomp, final ComponentInstance bus) {
		ConnectionInstance aci = ConnectionBindingUtil.getBusAccessConnection(HWcomp, bus);
		if (aci == null)
			return 0.0;
			Property Latency = lookupPropertyDefinition(aci,CommunicationProperties._NAME, CommunicationProperties.LATENCY);
			UnitLiteral microSecond = PropertiesLinkingService.findUnitLiteral(Latency, AadlProject.US_LITERAL);
			return PropertyUtils.getScaledRangeMaximum(aci, Latency, microSecond,0.0);
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
			Property requiredConnection = lookupPropertyDefinition(ne,CommunicationProperties._NAME, DeploymentProperties.REQUIRED_CONNECTION);
			return PropertyUtils.getBooleanValue(ne, requiredConnection);
		} catch (PropertyLookupException e) {
			return false;
		}
	}


	public static RecordValue getNotCollocated(final NamedElement ne) {
		try {
			Property nocoll = lookupPropertyDefinition(ne,DeploymentProperties._NAME, DeploymentProperties.NOT_COLLOCATED);
				return (RecordValue) PropertyUtils.getSimplePropertyValue(ne, nocoll);
		} catch (PropertyLookupException e) {
			return null;
		}
	}

	public static EnumerationLiteral getConnectionTiming(final PortConnection pc) {
		try {
			Property timing = lookupPropertyDefinition(pc,CommunicationProperties._NAME, CommunicationProperties.TIMING);
				return PropertyUtils.getEnumLiteral(pc, timing);
		} catch (PropertyLookupException e) {
			return null;
		}
	}
	public static UnitLiteral getDelayedUnitLiteral(PortConnection pc){
		Property timing = lookupPropertyDefinition(pc,CommunicationProperties._NAME, CommunicationProperties.TIMING);
		return findUnitLiteral(timing, CommunicationProperties.DELAYED);
	}
	public static EnumerationLiteral getImmediateUnitLiteral(PortConnection pc){
		Property timing = lookupPropertyDefinition(pc,CommunicationProperties._NAME, CommunicationProperties.TIMING);
		return findEnumerationLiteral(timing, CommunicationProperties.IMMEDIATE);
	}
	

	public static double getNetWeight(final NamedElement ne, final double defaultValue) {
		Property netWeight = lookupPropertyDefinition(ne,SEI._NAME, SEI.NETWEIGHT);
		return PropertyUtils.getRealValue(ne, netWeight, 0.0);
	}

	public static double getGrossWeight(final NamedElement ne, final double defaultValue) {
		Property netWeight = lookupPropertyDefinition(ne,SEI._NAME, SEI.GROSSWEIGHT);
		return PropertyUtils.getRealValue(ne, netWeight, 0.0);
	}

	public static double getWeightLimit(final NamedElement ne, final double defaultValue) {
		Property netWeight = lookupPropertyDefinition(ne,SEI._NAME, SEI.WEIGHTLIMIT);
		return PropertyUtils.getRealValue(ne, netWeight, 0.0);
	}


}