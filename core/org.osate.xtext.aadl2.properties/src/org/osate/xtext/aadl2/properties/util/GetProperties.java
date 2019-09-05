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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.impl.BooleanLiteralImpl;
import org.osate.aadl2.impl.ClassifierValueImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.aadl2.properties.PropertyLookupException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.contribution.sei.names.DataModel;
import org.osate.contribution.sei.names.SEI;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;

public class GetProperties {

	/**
	 * returns true if property is explicitly assigned
	 *
	 * @param element  NamedELement
	 * @param pn Property definition
	 * @return
	 */
	public static boolean isAssignedPropertyValue(NamedElement element, Property pn) {
		try {
			final PropertyAcc propertyAccumulator = element.getPropertyValue(pn);
			PropertyAssociation firstAssociation = propertyAccumulator.first();
			return firstAssociation != null;
		} catch (org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException exception) {
			return false;
		}

	}

	public static String getPlatform(final NamedElement ne) {
		try {
			Property sn = lookupPropertyDefinition(ne, SEI._NAME, SEI.PLATFORM);

			PropertyAcc pacc = ne.getPropertyValue(sn);
			if (pacc.getAssociations().size() > 0) {
				ModalPropertyValue mdv = pacc.getAssociations().get(0).getOwnedValues().get(0);
				PropertyExpression pe = mdv.getOwnedValue();
				StringLiteral sl = (StringLiteral) pe;
				return sl.getValue();

			}
			return null;
		} catch (PropertyLookupException e) {
			return null;
		}
	}

	public static String getSourceName(final NamedElement ne) {
		try {
			Property sn = lookupPropertyDefinition(ne, ProgrammingProperties._NAME, ProgrammingProperties.SOURCE_NAME);

			PropertyAcc pacc = ne.getPropertyValue(sn);
			if (pacc.getAssociations().size() > 0) {
				ModalPropertyValue mdv = pacc.getAssociations().get(0).getOwnedValues().get(0);
				PropertyExpression pe = mdv.getOwnedValue();
//				System.out.println("pe=" + pe);
				StringLiteral sl = (StringLiteral) pe;
				return sl.getValue();

			}
//			System.out.println("pacc" + pacc.getAssociations().get(0).getOwnedValues().get(0));
			return null;
		} catch (PropertyLookupException e) {
			return null;
		}
	}

	public static List<String> getDataEnumerators(final NamedElement ne) {
		List<String> res;
		res = new ArrayList<String>();
		try {
			Property st = lookupPropertyDefinition(ne, DataModel._NAME, DataModel.Enumerators);

			List<? extends PropertyExpression> propertyValues = ne.getPropertyValueList(st);
			for (PropertyExpression propertyExpression : propertyValues) {
//				System.out.println("pe=" + propertyExpression);
				StringLiteral sl = (StringLiteral) propertyExpression;
				res.add(sl.getValue());
			}
			return res;

		} catch (PropertyLookupException e) {
			return null;
		}
	}

	public static List<String> getSourceText(final NamedElement ne) {
		List<String> res;
		res = new ArrayList<String>();
		try {
			Property st = lookupPropertyDefinition(ne, ProgrammingProperties._NAME, ProgrammingProperties.SOURCE_TEXT);

			List<? extends PropertyExpression> propertyValues = ne.getPropertyValueList(st);
			for (PropertyExpression propertyExpression : propertyValues) {
//				System.out.println("pe=" + propertyExpression);
				StringLiteral sl = (StringLiteral) propertyExpression;
				res.add(sl.getValue());
			}
			return res;

		} catch (PropertyLookupException e) {
			return null;
		}
	}

	/**
	 * returns true if property is explicitly assigned
	 *
	 * @param element
	 *            NamedELement
	 * @param pn
	 *            Property definition
	 * @return
	 */
	public static boolean hasAssignedPropertyValue(NamedElement element, String pname) {
		Property pn = GetProperties.lookupPropertyDefinition(element, pname);
		return isAssignedPropertyValue(element, pn);
	}

	/**
	 * find property definition for given name. The property may be qualified by
	 * the property set name via the ps parameter For predeclared properties
	 * this is not required
	 *
	 * @param context
	 *            EObject the model object that references the property
	 *            definition
	 * @param ps
	 *            String property set name, which may be null
	 * @param name
	 *            String Property Definition name
	 * @return Property or null
	 */
	public static Property lookupPropertyDefinition(EObject context, String ps, String name) {
		return Aadl2GlobalScopeUtil.get(context, Aadl2Package.eINSTANCE.getProperty(),
				((ps != null && !ps.isEmpty()) ? (ps + "::" + name) : name));
	}

	/**
	 * find property definition for given name. The property may be qualified by
	 * the property set name via the ps parameter For predeclared properties
	 * this is not required
	 *
	 * @param context
	 *            EObject the model object that references the property
	 *            definition
	 * @param qpname
	 *            String qualified Property Definition name
	 * @return Property or null
	 */
	public static Property lookupPropertyDefinition(EObject context, String qpname) {
		return Aadl2GlobalScopeUtil.get(context, Aadl2Package.eINSTANCE.getProperty(), qpname);
	}

	/**
	 * find property type for given name. The property may be qualified by the
	 * property set name via the ps parameter For predeclared properties this is
	 * not required
	 *
	 * @param context
	 *            EObject the model object that references the property
	 *            definition
	 * @param ps
	 *            String property set name, which may be null
	 * @param name
	 *            String Property Type name
	 * @return PropertyType or null
	 */
	public static PropertyType lookupPropertyType(EObject context, String ps, String name) {
		return Aadl2GlobalScopeUtil.get(context, Aadl2Package.eINSTANCE.getPropertyType(),
				((ps != null && !ps.isEmpty()) ? (ps + "::" + name) : name));
	}

	/**
	 * find property type for given name. The property may be qualified by the
	 * property set name via the ps parameter For predeclared properties this is
	 * not required
	 *
	 * @param context
	 *            EObject the model object that references the property
	 *            definition
	 * @param qname
	 *            String Property Type qualified name
	 * @return PropertyType or null
	 */
	public static PropertyType lookupPropertyType(EObject context, String qname) {
		return Aadl2GlobalScopeUtil.get(context, Aadl2Package.eINSTANCE.getPropertyType(), qname);
	}

	/**
	 * find property constant for given name. The property may be qualified by
	 * the property set name via the ps parameter For predeclared properties
	 * this is not required
	 *
	 * @param context
	 *            EObject the model object that references the property
	 *            definition
	 * @param ps
	 *            String property set name, which may be null
	 * @param name
	 *            String Property Constant name
	 * @return PropertyConstant or null
	 */
	public static PropertyConstant lookupPropertyConstant(EObject context, String ps, String name) {
		return Aadl2GlobalScopeUtil.get(context, Aadl2Package.eINSTANCE.getPropertyConstant(),
				((ps != null && !ps.isEmpty()) ? (ps + "::" + name) : name));
	}

	/**
	 * find property constant for given name. The property may be qualified by
	 * the property set name via the ps parameter For predeclared properties
	 * this is not required
	 *
	 * @param context
	 *            EObject the model object that references the property
	 *            definition
	 * @param ps
	 *            String property set name, which may be null
	 * @param name
	 *            String Property Constant name
	 * @return PropertyConstant or null
	 */
	public static PropertyConstant lookupPropertyConstant(EObject context, String qname) {
		return Aadl2GlobalScopeUtil.get(context, Aadl2Package.eINSTANCE.getPropertyConstant(), qname);
	}

	/**
	 * Retrieve the unit literal given a unit string for a property It is useful
	 * when calling getScaledValue methods that require the literal as object
	 *
	 * @param pd
	 *            Property Definition
	 * @param literalname
	 *            String
	 * @return UnitLiteral or null if the unit literal could not be found or the
	 *         definition does not have a unit
	 */
	public static UnitLiteral findUnitLiteral(Property pd, String literalname) {
		return PropertiesLinkingService.findUnitLiteral(pd, literalname);
	}

	public static UnitLiteral findUnitLiteral(Element context, String unitsType, String literal) {
		PropertyType pt = lookupPropertyType(context, unitsType);
		if (pt == null || !(pt instanceof UnitsType)) {
			return null;
		}
		return (UnitLiteral) ((UnitsType) pt).findNamedElement(literal);
	}

	public static EnumerationLiteral findEnumerationLiteral(Property pd, String literalname) {
		return PropertiesLinkingService.findEnumerationLiteral(pd, literalname);
	}

	public static EnumerationLiteral findEnumerationLiteral(Element context, String enumerationType, String literal) {
		PropertyType pt = lookupPropertyType(context, enumerationType);
		if (pt == null || !(pt instanceof EnumerationType)) {
			return null;
		}
		return (EnumerationLiteral) ((EnumerationType) pt).findNamedElement(literal);
	}

	public static UnitLiteral getKBytespsUnitLiteral(NamedElement context) {
		return findUnitLiteral(context, AadlProject.DATA_RATE_UNITS, AadlProject.KBYTESPS_LITERAL);
	}

	public static UnitLiteral getKbitspsUnitLiteral(NamedElement context) {
		return findUnitLiteral(context, AadlProject.DATA_RATE_UNITS, AadlProject.KBITSPS_LITERAL);
	}

	public static UnitLiteral getKBUnitLiteral(NamedElement context) {
		return findUnitLiteral(context, AadlProject.SIZE_UNITS, AadlProject.KB_LITERAL);
	}

	public static UnitLiteral getMSUnitLiteral(NamedElement context) {
		return findUnitLiteral(context, AadlProject.TIME_UNITS, AadlProject.MS_LITERAL);
	}

	public static UnitLiteral getUSUnitLiteral(NamedElement context) {
		return findUnitLiteral(context, AadlProject.TIME_UNITS, AadlProject.US_LITERAL);
	}

	public static UnitLiteral getSecUnitLiteral(NamedElement context) {
		return findUnitLiteral(context, AadlProject.TIME_UNITS, AadlProject.SEC_LITERAL);
	}

	public static UnitLiteral getMIPSUnitLiteral(NamedElement context) {
		return findUnitLiteral(context, "SEI::" + SEI.PROCESSOR_SPEED_UNITS, SEI.MIPS_LITERAL);
	}

	public static Property getActualProcessorBindingProperty(final ComponentInstance io) {
		return lookupPropertyDefinition(io, DeploymentProperties._NAME, DeploymentProperties.ACTUAL_PROCESSOR_BINDING);
	}

	// /**
	// * this method only picks up the first element, which may not be a bus
	// * @param connection Connection Instance
	// * @return
	// */
	// public static ComponentInstance getBoundBus(final ConnectionInstance
	// connection) {
	// List<ComponentInstance> ret = getActualConnectionBinding(connection);
	// ComponentInstance ci = ret.isEmpty() ? null : ret.get(0);
	// if (ci != null) {
	// return ci;
	// }
	// return null;
	// }

	public static List<ComponentInstance> getActualProcessorBinding(final ComponentInstance io) {
		ArrayList<ComponentInstance> components = new ArrayList<ComponentInstance>();
		Property actualProcessorBinding = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ACTUAL_PROCESSOR_BINDING);
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = io.getPropertyValueList(actualProcessorBinding);
		} catch (Exception e) {
			return components;
		}
		for (PropertyExpression propertyExpression : propertyValues) {
			if (propertyExpression != null) {
				InstanceObject obj = ((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject();
				components.add((ComponentInstance) obj);
			}
		}
		return components;
	}

	public static List<ComponentInstance> getActualConnectionBinding(final InstanceObject io) {
		ArrayList<ComponentInstance> components = new ArrayList<ComponentInstance>();
		Property actualConnectionBinding = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ACTUAL_CONNECTION_BINDING);
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = io.getPropertyValueList(actualConnectionBinding);
		} catch (Exception e) {
			return components;
		}
		for (PropertyExpression propertyExpression : propertyValues) {
			components.add(
					(ComponentInstance) ((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject());
		}
		return components;
	}

	public static List<ComponentInstance> getAllowedConnectionBinding(final InstanceObject io) {
		ArrayList<ComponentInstance> components = new ArrayList<ComponentInstance>();
		Property allowedConnectionBinding = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ALLOWED_CONNECTION_BINDING);
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = io.getPropertyValueList(allowedConnectionBinding);
		} catch (Exception e) {
			return components;
		}
		for (PropertyExpression propertyExpression : propertyValues) {
			components.add(
					(ComponentInstance) ((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject());
		}
		return components;
	}

	public static List<Classifier> getAllowedConnectionBindingClass(final InstanceObject io) {
		Property allowedConnectionBindingClass = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ALLOWED_CONNECTION_BINDING_CLASS);
		ArrayList<Classifier> components = new ArrayList<>();
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = io.getPropertyValueList(allowedConnectionBindingClass);
		} catch (Exception e) {
			return components;
		}
		for (PropertyExpression propertyExpression : propertyValues) {
			components.add(((ClassifierValue) propertyExpression).getClassifier());
		}
		return components;
	}

	public static List<EnumerationLiteral> getProvidedConnectionQualityOfService(NamedElement ne) {
		try {
			List<EnumerationLiteral> res = new ArrayList<>();
			Property providedConnQos = lookupPropertyDefinition(ne, DeploymentProperties._NAME,
					DeploymentProperties.PROVIDED_CONNECTION_QUALITY_OF_SERVICE);
			List<? extends PropertyExpression> propertyValues = ne.getPropertyValueList(providedConnQos);
			for (PropertyExpression propertyExpression : propertyValues) {
				res.add((EnumerationLiteral) ((NamedValue) propertyExpression).getNamedValue());
			}
			return res;
		} catch (PropertyLookupException e) {
			return Collections.emptyList();
		}
	}

	public static List<EnumerationLiteral> getRequiredConnectionQualityOfService(NamedElement ne) {
		try {
			List<EnumerationLiteral> res = new ArrayList<>();
			Property requiredConnQos = lookupPropertyDefinition(ne, DeploymentProperties._NAME,
					DeploymentProperties.REQUIRED_CONNECTION_QUALITY_OF_SERVICE);
			List<? extends PropertyExpression> propertyValues = ne.getPropertyValueList(requiredConnQos);
			for (PropertyExpression propertyExpression : propertyValues) {
				res.add((EnumerationLiteral) ((NamedValue) propertyExpression).getNamedValue());
			}
			return res;
		} catch (PropertyLookupException e) {
			return Collections.emptyList();
		}
	}

	public static List<ComponentInstance> getAllowedProcessorBinding(final ComponentInstance io) {
		Property allowedProcessorBinding = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ALLOWED_PROCESSOR_BINDING);
		ArrayList<ComponentInstance> components = new ArrayList<ComponentInstance>();
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = io.getPropertyValueList(allowedProcessorBinding);
		} catch (Exception e) {
			return components;
		}
		for (PropertyExpression propertyExpression : propertyValues) {
			components.add(
					(ComponentInstance) ((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject());
		}
		return components;
	}

	public static List<Classifier> getAllowedProcessorBindingClass(final ComponentInstance io) {
		Property allowedProcessorBindingClass = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ALLOWED_PROCESSOR_BINDING_CLASS);
		ArrayList<Classifier> components = new ArrayList<Classifier>();
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = io.getPropertyValueList(allowedProcessorBindingClass);
		} catch (Exception e) {
			return components;
		}
		for (PropertyExpression propertyExpression : propertyValues) {
			components.add(((ClassifierValue) propertyExpression).getClassifier());
		}
		return components;
	}

	public static List<ComponentInstance> getActualMemoryBinding(final InstanceObject io) {
		Property actualMemoryBinding = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ACTUAL_MEMORY_BINDING);
		ArrayList<ComponentInstance> components = new ArrayList<ComponentInstance>();
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = io.getPropertyValueList(actualMemoryBinding);
		} catch (Exception e) {
			return components;
		}
		for (PropertyExpression propertyExpression : propertyValues) {
			components.add(
					(ComponentInstance) ((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject());
		}
		return components;
	}

	public static List<ComponentInstance> getAllowedMemoryBinding(final InstanceObject io) {
		Property allowedMemoryBinding = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ALLOWED_MEMORY_BINDING);
		ArrayList<ComponentInstance> components = new ArrayList<>();
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = io.getPropertyValueList(allowedMemoryBinding);
		} catch (Exception e) {
			return components;
		}
		for (PropertyExpression propertyExpression : propertyValues) {
			components.add(
					(ComponentInstance) ((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject());
		}
		return components;
	}

	public static List<Classifier> getAllowedMemoryBindingClass(final InstanceObject io) {
		Property allowedMemoryBindingClass = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ALLOWED_MEMORY_BINDING_CLASS);
		ArrayList<Classifier> components = new ArrayList<>();
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = io.getPropertyValueList(allowedMemoryBindingClass);
		} catch (Exception e) {
			return components;
		}
		for (PropertyExpression propertyExpression : propertyValues) {
			components.add(((ClassifierValue) propertyExpression).getClassifier());
		}
		return components;
	}

	public static List<ComponentInstance> getActualFunctionBinding(final InstanceObject io) {
		Property actualFunctionBinding = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.ACTUAL_FUNCTION_BINDING);
		ArrayList<ComponentInstance> components = new ArrayList<ComponentInstance>();
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = io.getPropertyValueList(actualFunctionBinding);
		} catch (Exception e) {
			return components;
		}
		for (PropertyExpression propertyExpression : propertyValues) {
			components.add(
					(ComponentInstance) ((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject());
		}
		return components;
	}

	public static List<? extends PropertyExpression> getActualConnectionBinding(final NamedElement ne) {
		Property actualConnectionBinding = lookupPropertyDefinition(ne, DeploymentProperties._NAME,
				DeploymentProperties.ACTUAL_CONNECTION_BINDING);
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = ne.getPropertyValueList(actualConnectionBinding);
		} catch (Exception e) {
			return Collections.EMPTY_LIST;
		}
		return propertyValues;
	}

	public static double getMIPSCapacityInMIPS(final NamedElement ne, final double defaultValue) {
		Property MIPSCapacity = lookupPropertyDefinition(ne, SEI._NAME, SEI.MIPS_CAPACITY);
		UnitLiteral MIPS = findUnitLiteral(MIPSCapacity, SEI.MIPS_LITERAL);
		double res = PropertyUtils.getScaledNumberValue(ne, MIPSCapacity, MIPS, defaultValue);
		if (res != defaultValue) {
			return PropertyUtils.getScaledNumberValue(ne, MIPSCapacity, MIPS, defaultValue);
		}
		MIPSCapacity = lookupPropertyDefinition(ne, TimingProperties._NAME, TimingProperties.PROCESSOR_CAPACITY);
		MIPS = findUnitLiteral(MIPSCapacity, AadlProject.MIPS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, MIPSCapacity, MIPS, defaultValue);
	}

	public static double getMIPSBudgetInMIPS(final NamedElement ne, final double defaultValue) {
		Property MIPSBudget = lookupPropertyDefinition(ne, SEI._NAME, SEI.MIPS_BUDGET);
		UnitLiteral MIPS = findUnitLiteral(MIPSBudget, SEI.MIPS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, MIPSBudget, MIPS, defaultValue);
	}

	public static double getRAMCapacityInKB(final NamedElement ne, final double defaultValue) {
		Property RAMCapacity = lookupPropertyDefinition(ne, SEI._NAME, SEI.RAM_CAPACITY);
		UnitLiteral kb = findUnitLiteral(RAMCapacity, AadlProject.KB_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, RAMCapacity, kb, defaultValue);
	}

	public static double getRAMBudgetInKB(final NamedElement ne, final double defaultValue) {
		Property RAMBudget = lookupPropertyDefinition(ne, SEI._NAME, SEI.RAM_BUDGET);
		UnitLiteral kb = findUnitLiteral(RAMBudget, AadlProject.KB_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, RAMBudget, kb, defaultValue);
	}

	public static double getRAMActualInKB(final NamedElement ne, final double defaultValue) {
		Property RAMActual = lookupPropertyDefinition(ne, SEI._NAME, SEI.RAM_ACTUAL);
		UnitLiteral kb = findUnitLiteral(RAMActual, AadlProject.KB_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, RAMActual, kb, defaultValue);
	}

	public static double getROMCapacityInKB(final NamedElement ne, final double defaultValue) {
		Property ROMCapacity = lookupPropertyDefinition(ne, SEI._NAME, SEI.ROM_CAPACITY);
		UnitLiteral kb = findUnitLiteral(ROMCapacity, AadlProject.KB_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, ROMCapacity, kb, defaultValue);
	}

	public static double getROMBudgetInKB(final NamedElement ne, final double defaultValue) {
		Property ROMBudget = lookupPropertyDefinition(ne, SEI._NAME, SEI.ROM_BUDGET);
		UnitLiteral kb = findUnitLiteral(ROMBudget, AadlProject.KB_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, ROMBudget, kb, defaultValue);
	}

	public static double getROMActualInKB(final NamedElement ne, final double defaultValue) {
		Property ROMActual = lookupPropertyDefinition(ne, SEI._NAME, SEI.ROM_ACTUAL);
		UnitLiteral kb = findUnitLiteral(ROMActual, AadlProject.KB_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, ROMActual, kb, defaultValue);
	}

	public static double getBandWidthCapacityInKBytesps(final NamedElement ne, final double defaultValue) {
		Property BandWidthCapacity = lookupPropertyDefinition(ne, SEI._NAME, SEI.BANDWIDTH_CAPACITY);
		UnitLiteral Kbps = findUnitLiteral(BandWidthCapacity, AadlProject.KBYTESPS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, BandWidthCapacity, Kbps, defaultValue);
	}

	public static double getBandWidthBudgetInKBytesps(final NamedElement ne, final double defaultValue) {
		Property BandWidthBudget = lookupPropertyDefinition(ne, SEI._NAME, SEI.BANDWIDTH_BUDGET);
		UnitLiteral Kbps = findUnitLiteral(BandWidthBudget, AadlProject.KBYTESPS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, BandWidthBudget, Kbps, defaultValue);
	}

	public static double getBandWidthCapacityInKbitsps(final NamedElement ne, final double defaultValue) {
		Property BandWidthCapacity = lookupPropertyDefinition(ne, SEI._NAME, SEI.BANDWIDTH_CAPACITY);
		UnitLiteral Kbps = findUnitLiteral(BandWidthCapacity, AadlProject.KBITSPS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, BandWidthCapacity, Kbps, defaultValue);
	}

	public static double getBandWidthBudgetInKbitsps(final NamedElement ne, final double defaultValue) {
		Property BandWidthBudget = lookupPropertyDefinition(ne, SEI._NAME, SEI.BANDWIDTH_BUDGET);
		UnitLiteral Kbps = findUnitLiteral(BandWidthBudget, AadlProject.KBITSPS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, BandWidthBudget, Kbps, defaultValue);
	}

	public static boolean isBroadcastProtocol(final NamedElement ne) {
		Property loopback = lookupPropertyDefinition(ne, SEI._NAME, SEI.BROADCAST_PROTOCOL);
		try {
			return PropertyUtils.getBooleanValue(ne, loopback);
		} catch (Exception e) {
			return false;
		}
	}

	public static ComponentClassifier getReferenceProcessor(final NamedElement ne) {
		Property referenceProcessor = lookupPropertyDefinition(ne, TimingProperties._NAME,
				TimingProperties.REFERENCE_PROCESSOR);
		if (referenceProcessor == null) {
			return null;
		}
		try {
			PropertyExpression pv = ne.getSimplePropertyValue(referenceProcessor);
			if (pv != null) {
				return (ComponentClassifier) ((ClassifierValue) pv).getClassifier();
			}
		} catch (Exception e) {
		}
		return null;
	}

	public static ComponentInstance getReferenceTime(final ComponentInstance ci) {
		Property referenceTime = lookupPropertyDefinition(ci, TimingProperties._NAME, TimingProperties.REFERENCE_TIME);
		if (referenceTime == null) {
			return null;
		}
		try {
			PropertyExpression pv = ci.getSimplePropertyValue(referenceTime);
			if (pv != null) {
				return (ComponentInstance) ((InstanceReferenceValue) pv).getReferencedInstanceObject();
			}
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * instruction execution time of processor This is calculated from the
	 * MIPSCapacity. This function acts as replacement for the cycle_time
	 * property
	 *
	 * @param proc
	 *            processor component instance
	 * @return
	 */
	public static double getInstructionExecutionTimeinUS(final ComponentInstance proc) {
		return 1 / getProcessorMIPS(proc);
	}

	/**
	 * instruction execution time of processor This is calculated from the
	 * MIPSCapacity. This function acts as replacement for the cycle_time
	 * property
	 *
	 * @param proc
	 *            processor component instance
	 * @return
	 */
	public static double getInstructionExecutionTimeinSec(final ComponentInstance proc) {
		return 1 / (getProcessorMIPS(proc) * 1e6);
	}

	public static double getPartitionLatencyInMilliSec(final NamedElement ph, final double defaultValue) {
		Property pl = lookupPropertyDefinition(ph, SEI._NAME, SEI.PARTITION_LATENCY);
		return PropertyUtils.getScaledNumberValue(ph, pl, findUnitLiteral(pl, AadlProject.MS_LITERAL), defaultValue);
	}

	public static double getPartitionLatencyInMicroSec(final NamedElement ph, final double defaultValue) {
		Property pl = lookupPropertyDefinition(ph, SEI._NAME, SEI.PARTITION_LATENCY);
		return PropertyUtils.getScaledNumberValue(ph, pl, findUnitLiteral(pl, AadlProject.US_LITERAL), defaultValue);
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
		Property xmissionTime = lookupPropertyDefinition(ne, CommunicationProperties._NAME,
				CommunicationProperties.TRANSMISSION_TIME);
		try {
			return (RecordValue) PropertyUtils.getSimplePropertyValue(ne, xmissionTime);
		} catch (PropertyLookupException e) {
			return null;
		}
	}

	public static double getMaximumTransmissionTimePerByte(final NamedElement bus) {
		RecordValue rv;
		RangeValue bpa;
		NumberValue nv;
		rv = GetProperties.getTransmissionTime(bus);
		if (rv == null) {
			return 0;
		}
		bpa = (RangeValue) PropertyUtils.getRecordFieldValue(rv, "PerByte");
		if (bpa != null) {
			nv = bpa.getMaximumValue();
			return nv.getScaledValue(GetProperties.getMSUnitLiteral(bus));
		}
		return 0;
	}

	public static double getMaximumTransmissionTimeFixed(final NamedElement bus) {
		RecordValue rv;
		RangeValue bpa;
		NumberValue nv;
		rv = GetProperties.getTransmissionTime(bus);
		if (rv == null) {
			return 0;
		}
		bpa = (RangeValue) PropertyUtils.getRecordFieldValue(rv, "Fixed");
		if (bpa != null) {
			nv = bpa.getMaximumValue();
			return nv.getScaledValue(GetProperties.getMSUnitLiteral(bus));
		}
		return 0;
	}

	public static double getMinimumTransmissionTimePerByte(final NamedElement bus) {
		RecordValue rv;
		RangeValue bpa;
		NumberValue nv;
		rv = GetProperties.getTransmissionTime(bus);
		if (rv == null) {
			return 0;
		}
		bpa = (RangeValue) PropertyUtils.getRecordFieldValue(rv, "PerByte");
		if (bpa != null) {
			nv = bpa.getMinimumValue();
			return nv.getScaledValue(GetProperties.getMSUnitLiteral(bus));
		}
		return 0;
	}

	public static double getMinimumTransmissionTimeFixed(final NamedElement bus) {
		RecordValue rv;
		RangeValue bpa;
		NumberValue nv;
		rv = GetProperties.getTransmissionTime(bus);
		if (rv == null) {
			return 0;
		}
		bpa = (RangeValue) PropertyUtils.getRecordFieldValue(rv, "Fixed");
		if (bpa != null) {
			nv = bpa.getMinimumValue();
			return nv.getScaledValue(GetProperties.getMSUnitLiteral(bus));
		}
		return 0;
	}

	public static double getMaximumTimeToTransferData(final NamedElement bus, double datasizeinbyte) {
		double speed = getMaximumTransmissionTimePerByte(bus);
		double dataTransferTime = speed * datasizeinbyte;

		double acquisitionTime = getMaximumTransmissionTimeFixed(bus);

		return dataTransferTime + acquisitionTime;
	}

	public static double getMaximumTimeToTransferData(final NamedElement bus, Classifier dataClassifier) {
		double datasizeinbyte = getDataSizeInBytes(dataClassifier);
		double speed = getMaximumTransmissionTimePerByte(bus);
		double dataTransferTime = speed * datasizeinbyte;

		double acquisitionTime = getMaximumTransmissionTimeFixed(bus);

		return dataTransferTime + acquisitionTime;
	}

	public static double getMinimumTimeToTransferData(final NamedElement bus, double datasizeinbyte) {

		double speed = getMinimumTransmissionTimePerByte(bus);
		double dataTransferTime = speed * datasizeinbyte;

		double acquisitionTime = getMinimumTransmissionTimeFixed(bus);

		return dataTransferTime + acquisitionTime;
	}

	public static double getMinimumTimeToTransferData(final NamedElement bus, Classifier dataClassifier) {
		double datasizeinbyte = getDataSizeInBytes(dataClassifier);
		double speed = getMinimumTransmissionTimePerByte(bus);
		double dataTransferTime = speed * datasizeinbyte;

		double acquisitionTime = getMinimumTransmissionTimeFixed(bus);

		return dataTransferTime + acquisitionTime;
	}

	public static double fromMStoSec(NamedElement ne, double value) {
		return convertToScale(value, getMSUnitLiteral(ne), getSecUnitLiteral(ne));
	}

	public static double fromUStoSec(NamedElement ne, double value) {
		return convertToScale(value, getUSUnitLiteral(ne), getSecUnitLiteral(ne));
	}

	/**
	 * calculate the scaling factor from the MIPSCapacity of the two processors.
	 * The default value is 1
	 *
	 * @param thread
	 * @return double scaling factor of processor speed
	 */
	public static double getProcessorScalingFactor(final ComponentInstance thread) {
		double refmipspersec = getReferenceMIPS(thread);
		double mipspersec = getBoundPhysicalProcessorMIPS(thread);
		if (refmipspersec == 0 || mipspersec == 0) {
			return 1;
		}
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
	 * Get the MIPS per sec of the bound physical processor. The MIPS
	 * capacity of the bound physical processor
	 */
	public static double getBoundPhysicalProcessorMIPS(final ComponentInstance thread) {
		Iterator<ComponentInstance> pcis = InstanceModelUtil.getBoundPhysicalProcessors(thread).iterator();
		if (pcis.hasNext()) {
			return getMIPSCapacityInMIPS(pcis.next(), 0);
		}
		return 0.0;
	}

	/**
	 * Get the MIPS capacity of the bound processor.
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
	 * Get the bound processor. It will take the first if the binding identifies
	 * more than one.
	 */
	public static ComponentInstance getBoundProcessor(final ComponentInstance processorthread) {
		List<ComponentInstance> pciList = getActualProcessorBinding(processorthread);
		ComponentInstance pci = pciList.isEmpty() ? null : pciList.get(0);
		if (pci != null) {
			return pci;
		}
		return null;
	}

	/**
	 * Get the MIPS of the processor from the MIPSCapacity.
	 */
	public static double getProcessorMIPS(final ComponentInstance processor) {
		return getMIPSCapacityInMIPS(processor, 0);
	}

	/**
	 * compute MIPS for thread based on instructions per dispatch;
	 *
	 * @param threadinstance
	 *            thread instance
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
	 * @author: Dionisio de Niz
	 *
	 *          For now we will use MIPS as a representative of cycles per
	 *          second but we will change it to a more meaningful property name
	 *
	 * @param threadInstance
	 * @return execution time in cyles
	 */
	public static double getThreadExecutionInCycles(ComponentInstance threadInstance, double defaultMIPS) {
		double cycles = 0.0;
		double exectimeval = getMaximumComputeExecutionTimeinSec(threadInstance);
		double mipspersec = getReferenceMIPS(threadInstance);
		if (mipspersec == 0) {
			mipspersec = defaultMIPS;
		}
		cycles = exectimeval * (mipspersec * 1e6);
		return cycles;
	}

	/**
	 * compute MIPS for thread based on instructions per dispatch; or based on
	 * specified execution time
	 *
	 * @param threadinstance
	 *            thread instance
	 * @return MIPS or 0.0
	 */
	public static double getThreadExecutioninMIPS(ComponentInstance threadinstance) {
		if (!InstanceModelUtil.isThread(threadinstance)) {
			return 0;
		}
		double mips = getThreadExecutionIPDinMIPS(threadinstance);
		if (mips == 0) {
			double period = getPeriodInSeconds(threadinstance, 0.0);
			double exectimeval = getMaximumComputeExecutionTimeinSec(threadinstance);
			if (exectimeval > 0 && period > 0) {
				double mipspersec = getReferenceMIPS(threadinstance);
				if (mipspersec == 0) {
					mipspersec = getBoundPhysicalProcessorMIPS(threadinstance);
				}
				double time = exectimeval / period;
				mips = time * mipspersec;
			}
		}
		return mips;
	}

	/**
	 * compute Execution time for actual processor from instructions per
	 * dispatch; or based on specified execution time
	 *
	 * @param threadinstance
	 *            thread instance
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
	 * compute Execution time for actual processor from instructions per
	 * dispatch; or based on specified execution time
	 *
	 * @param threadinstance
	 *            thread instance
	 * @return double scaled execution time in Sec
	 */
	public static double getThreadExecutioninMilliSec(ComponentInstance threadinstance) {
		double mipd = getSpecifiedThreadInstructionsinMIPD(threadinstance);
		double actualProcMips = getBoundProcessorMIPS(threadinstance);
		if (mipd > 0 && actualProcMips > 0) {
			// adjust from sec to milli sec
			return (mipd / actualProcMips) * 1000;
		}
		return getScaledMaxComputeExecutionTimeinMilliSec(threadinstance);
	}

	/**
	 * get max execution time scaled in terms of the processor the thread is
	 * bound to If it is not bound then return the specified execution time
	 *
	 * @param ne
	 *            thread component instance
	 * @return scaled time or 0.0
	 */
	public static double getScaledMaxComputeExecutionTimeinMilliSec(final NamedElement ne) {
		Property computeExecutionTime = lookupPropertyDefinition(ne, TimingProperties._NAME,
				TimingProperties.COMPUTE_EXECUTION_TIME);
		UnitLiteral milliSecond = findUnitLiteral(computeExecutionTime, AadlProject.MS_LITERAL);
		double time = PropertyUtils.getScaledRangeMaximum(ne, computeExecutionTime, milliSecond, 0.0);
		if (ne instanceof ComponentInstance) {
			double scale = getProcessorScalingFactor((ComponentInstance) ne);
			return time * scale;
		}
		return time;
	}

	/**
	 * get min execution time scaled in terms of the processor the thread is
	 * bound to If it is not bound then return the specified execution time
	 *
	 * @param ne
	 *            thread component instance
	 * @return scaled time or 0.0
	 */
	public static double getScaledMinComputeExecutionTimeinMilliSec(final NamedElement ne) {
		Property computeExecutionTime = lookupPropertyDefinition(ne, TimingProperties._NAME,
				TimingProperties.COMPUTE_EXECUTION_TIME);
		UnitLiteral milliSecond = findUnitLiteral(computeExecutionTime, AadlProject.MS_LITERAL);
		double time = PropertyUtils.getScaledRangeMinimum(ne, computeExecutionTime, milliSecond, 0.0);
		if (ne instanceof ComponentInstance) {
			double scale = getProcessorScalingFactor((ComponentInstance) ne);
			return time * scale;
		}
		return time;
	}

	/**
	 * get execution time scaled in terms of the processor the thread is bound
	 * to If it is not bound then return the specified execution time
	 *
	 * @param ne
	 *            thread component instance
	 * @return scaled time or 0.0
	 */
	public static double getScaledComputeExecutionTimeinSec(final NamedElement ne) {
		Property computeExecutionTime = lookupPropertyDefinition(ne, TimingProperties._NAME,
				TimingProperties.COMPUTE_EXECUTION_TIME);
		UnitLiteral second = findUnitLiteral(computeExecutionTime, AadlProject.SEC_LITERAL);
		double time = PropertyUtils.getScaledRangeMaximum(ne, computeExecutionTime, second, 0.0);
		if (ne instanceof ComponentInstance) {
			double scale = getProcessorScalingFactor((ComponentInstance) ne);
			return time * scale;
		}
		return time;
	}

	/**
	 * get execution time as specified in nsec - the upper bound not adjusted
	 * for different processor speeds
	 *
	 * @param ne
	 *            thread component instance
	 * @return specified time or 0.0
	 */
	public static double getMaximumComputeExecutionTimeinNsec(final NamedElement ne) {
		Property computeExecutionTime = lookupPropertyDefinition(ne, TimingProperties._NAME,
				TimingProperties.COMPUTE_EXECUTION_TIME);
		UnitLiteral nsecond = findUnitLiteral(computeExecutionTime, AadlProject.NS_LITERAL);
		double time = PropertyUtils.getScaledRangeMaximum(ne, computeExecutionTime, nsecond, 0.0);
		return time;
	}

	/**
	 * get execution time as specified in sec - the upper bound not adjusted for
	 * different processor speeds
	 *
	 * @param ne
	 *            thread component instance
	 * @return specified time or 0.0
	 */
	public static double getMaximumComputeExecutionTimeinSec(final NamedElement ne) {
		Property computeExecutionTime = lookupPropertyDefinition(ne, TimingProperties._NAME,
				TimingProperties.COMPUTE_EXECUTION_TIME);
		UnitLiteral second = findUnitLiteral(computeExecutionTime, AadlProject.SEC_LITERAL);
		double time = PropertyUtils.getScaledRangeMaximum(ne, computeExecutionTime, second, 0.0);
		return time;
	}

	/**
	 * get execution time as specified in sec - the lower bound not adjusted for
	 * different processor speeds
	 *
	 * @param ne
	 *            thread component instance
	 * @return specified time or 0.0
	 */
	public static double getMinimumComputeExecutionTimeinSec(final NamedElement ne) {
		Property computeExecutionTime = lookupPropertyDefinition(ne, TimingProperties._NAME,
				TimingProperties.COMPUTE_EXECUTION_TIME);
		UnitLiteral second = findUnitLiteral(computeExecutionTime, AadlProject.SEC_LITERAL);
		double time = PropertyUtils.getScaledRangeMinimum(ne, computeExecutionTime, second, 0.0);
		return time;
	}

	/**
	 * get execution time as specified in ms - the upper bound not adjusted for
	 * different processor speeds
	 *
	 * @param ne
	 *            thread component instance
	 * @return specified time or 0.0
	 */
	public static double getMaximumComputeExecutionTimeinMs(final NamedElement ne) {
		Property computeExecutionTime = lookupPropertyDefinition(ne, TimingProperties._NAME,
				TimingProperties.COMPUTE_EXECUTION_TIME);
		UnitLiteral millisecond = findUnitLiteral(computeExecutionTime, AadlProject.MS_LITERAL);
		double time = PropertyUtils.getScaledRangeMaximum(ne, computeExecutionTime, millisecond, 0.0);
		return time;
	}

	/**
	 * get execution time as specified in ms - the lower bound not adjusted for
	 * different processor speeds
	 *
	 * @param ne
	 *            thread component instance
	 * @return specified time or 0.0
	 */
	public static double getMinimumComputeExecutionTimeinMs(final NamedElement ne) {
		Property computeExecutionTime = lookupPropertyDefinition(ne, TimingProperties._NAME,
				TimingProperties.COMPUTE_EXECUTION_TIME);
		UnitLiteral second = findUnitLiteral(computeExecutionTime, AadlProject.MS_LITERAL);
		double time = PropertyUtils.getScaledRangeMinimum(ne, computeExecutionTime, second, 0.0);
		return time;
	}

	/**
	 * get specified instructions per dispatch as MIPD
	 *
	 * @param ne
	 *            thread component instance
	 * @return double MIPD
	 */
	public static double getSpecifiedThreadInstructionsinMIPD(final NamedElement ne) {
		Property ipd = lookupPropertyDefinition(ne, SEI._NAME, SEI.INSTRUCTIONSPERDISPATCH);
		UnitLiteral mipdunit = findUnitLiteral(ipd, SEI.MIPD_LITERAL);
		double mipd = PropertyUtils.getScaledRangeMaximum(ne, ipd, mipdunit, 0.0);
		return mipd;
	}

	/**
	 * get specified instructions per dispatch as IPD
	 *
	 * @param ne
	 *            thread component instance
	 * @return double IPD
	 */
	public static double getSpecifiedThreadInstructionsinIPD(final NamedElement ne) {
		Property ipd = lookupPropertyDefinition(ne, SEI._NAME, SEI.INSTRUCTIONSPERDISPATCH);
		UnitLiteral mipdunit = findUnitLiteral(ipd, SEI.IPD_LITERAL);
		double mipd = PropertyUtils.getScaledRangeMaximum(ne, ipd, mipdunit, 0.0);
		return mipd;
	}

	public static double getPowerCapacity(final NamedElement ne, final double defaultValue) {
		Property powerCapacity = lookupPropertyDefinition(ne, SEI._NAME, SEI.POWER_CAPACITY);
		UnitLiteral mWatt = findUnitLiteral(powerCapacity, SEI.MW_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, powerCapacity, mWatt, defaultValue);
	}

	public static double getPowerBudget(final NamedElement ne, final double defaultValue) {
		Property powerBudget = lookupPropertyDefinition(ne, SEI._NAME, SEI.POWER_BUDGET);
		UnitLiteral mWatt = findUnitLiteral(powerBudget, SEI.MW_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, powerBudget, mWatt, defaultValue);
	}

	public static double getPowerSupply(final NamedElement ne, final double defaultValue) {
		Property powerSupply = lookupPropertyDefinition(ne, SEI._NAME, SEI.POWER_SUPPLY);
		UnitLiteral mWatt = findUnitLiteral(powerSupply, SEI.MW_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, powerSupply, mWatt, defaultValue);
	}

	public static double getPeriodinMS(final NamedElement ne) {
		Property period = lookupPropertyDefinition(ne, TimingProperties._NAME, TimingProperties.PERIOD);
		UnitLiteral milliSecond = findUnitLiteral(period, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, period, milliSecond, 0.0);
	}

	public static double getExecutionTimeInMS(final NamedElement ne) {
		Property period = lookupPropertyDefinition(ne, TimingProperties._NAME, TimingProperties.EXECUTION_TIME);
		UnitLiteral milliSecond = findUnitLiteral(period, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, period, milliSecond, 0.0);
	}

	public static double getPeriodinMicroSec(final NamedElement ne) {
		Property period = lookupPropertyDefinition(ne, TimingProperties._NAME, TimingProperties.PERIOD);
		UnitLiteral microSecond = findUnitLiteral(period, AadlProject.US_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, period, microSecond, 0.0);
	}

	public static double getPeriodinNS(final NamedElement ne) {
		Property period = lookupPropertyDefinition(ne, TimingProperties._NAME, TimingProperties.PERIOD);
		UnitLiteral microSecond = findUnitLiteral(period, AadlProject.NS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, period, microSecond, 0.0);
	}

	public static double getActualLatencyinMS(final NamedElement ne) {
		Property actualLatency = lookupPropertyDefinition(ne, CommunicationProperties._NAME,
				CommunicationProperties.ACTUAL_LATENCY);
		UnitLiteral milliSecond = findUnitLiteral(actualLatency, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, actualLatency, milliSecond, 0.0);
	}

	public static double getActualLatencyinMicroSec(final NamedElement ne) {
		Property actualLatency = lookupPropertyDefinition(ne, CommunicationProperties._NAME,
				CommunicationProperties.ACTUAL_LATENCY);
		UnitLiteral microSecond = findUnitLiteral(actualLatency, AadlProject.US_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, actualLatency, microSecond, 0.0);
	}

	public static long getQueueSize(final NamedElement ne) {
		Property queuesize = lookupPropertyDefinition(ne, CommunicationProperties._NAME,
				CommunicationProperties.QUEUE_SIZE);
		return PropertyUtils.getIntegerValue(ne, queuesize, 0);
	}

	public static double getMIPSBudgetInMIPS(final NamedElement ne) {
		return getMIPSBudgetInMIPS(ne, 0.0);
	}

	public static double getDeadlineinSec(final NamedElement ne) {
		Property deadline = lookupPropertyDefinition(ne, TimingProperties._NAME, TimingProperties.DEADLINE);
		UnitLiteral second = findUnitLiteral(deadline, AadlProject.SEC_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, deadline, second, 0.0);
	}

	public static double getDeadlineinMilliSec(final NamedElement ne) {
		Property deadline = lookupPropertyDefinition(ne, TimingProperties._NAME, TimingProperties.DEADLINE);
		UnitLiteral milliSecond = findUnitLiteral(deadline, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, deadline, milliSecond, 0.0);
	}

	public static boolean isAssignedDeadline(final NamedElement ne) {
		Property deadline = lookupPropertyDefinition(ne, TimingProperties._NAME, TimingProperties.DEADLINE);
		return isAssignedPropertyValue(ne, deadline);
	}

	public static double getComputeDeadlineinMilliSec(final NamedElement ne) {
		Property deadline = lookupPropertyDefinition(ne, TimingProperties._NAME, TimingProperties.COMPUTE_DEADLINE);
		UnitLiteral milliSecond = findUnitLiteral(deadline, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, deadline, milliSecond, 0.0);
	}

	public static double getDeadlineinMicroSec(final NamedElement ne) {
		Property deadline = lookupPropertyDefinition(ne, TimingProperties._NAME, TimingProperties.DEADLINE);
		UnitLiteral microSecond = findUnitLiteral(deadline, AadlProject.US_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, deadline, microSecond, 0.0);
	}

	public static double getDeadlineinNS(final NamedElement ne) {
		Property deadline = lookupPropertyDefinition(ne, TimingProperties._NAME, TimingProperties.DEADLINE);
		UnitLiteral nanoSecond = findUnitLiteral(deadline, AadlProject.NS_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, deadline, nanoSecond, 0.0);
	}

	public static double getPeriodInSeconds(final NamedElement ne, final double defaultValue) {
		Property period = lookupPropertyDefinition(ne, TimingProperties._NAME, TimingProperties.PERIOD);
		UnitLiteral second = findUnitLiteral(period, AadlProject.SEC_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, period, second, defaultValue);
	}

	public static long getPriority(final NamedElement ne, final long defaultValue) {
		Property priority = lookupPropertyDefinition(ne, ThreadProperties._NAME, ThreadProperties.PRIORITY);
		return PropertyUtils.getIntegerValue(ne, priority, defaultValue);
	}

	public static String getSchedulingProtocol(final NamedElement ne) {
		try {
			Property schedulingprotocol = lookupPropertyDefinition(ne, DeploymentProperties._NAME,
					DeploymentProperties.SCHEDULING_PROTOCOL);
			List<? extends PropertyExpression> propertyValues = ne.getPropertyValueList(schedulingprotocol);
			for (PropertyExpression propertyExpression : propertyValues) {
				return ((EnumerationLiteral) ((NamedValue) propertyExpression).getNamedValue()).getName();
			}
			return null;
		} catch (PropertyLookupException e) {
			return null;
		}
	}

	public static List<String> getSourceLanguage(final NamedElement ne) {
		try {
			List<String> res = new ArrayList<String>();
			Property sourceLanguage = lookupPropertyDefinition(ne, ProgrammingProperties._NAME,
					ProgrammingProperties.SOURCE_LANGUAGE);
			List<? extends PropertyExpression> propertyValues = ne.getPropertyValueList(sourceLanguage);
			for (PropertyExpression propertyExpression : propertyValues) {
				String v = ((EnumerationLiteral) ((NamedValue) propertyExpression).getNamedValue()).getName();
				res.add(v);
			}
			return res;
		} catch (PropertyLookupException e) {
			return null;
		}
	}

	public static String getConcurrencyControlProtocol(final NamedElement ne) {
		try {
			Property concurrencyControlProtocol = lookupPropertyDefinition(ne, ThreadProperties._NAME,
					DeploymentProperties.CONCURRENCY_CONTROL_PROTOCOL);
			List<? extends PropertyExpression> propertyValues = ne.getPropertyValueList(concurrencyControlProtocol);
			for (PropertyExpression propertyExpression : propertyValues) {
				return ((EnumerationLiteral) ((NamedValue) propertyExpression).getNamedValue()).getName();
			}
			return null;
		} catch (PropertyLookupException e) {
			return null;
		}
	}

	public static EnumerationLiteral getDispatchProtocol(final NamedElement ne) {
		try {
			Property dispatchProtocol = lookupPropertyDefinition(ne, ThreadProperties._NAME,
					ThreadProperties.DISPATCH_PROTOCOL);
			return PropertyUtils.getEnumLiteral(ne, dispatchProtocol);
		} catch (final PropertyLookupException e) {
			return null;
		}
	}

	public static List<EnumerationLiteral> getAllowedDispatchProtocol(NamedElement ne) {
		try {
			List<EnumerationLiteral> res = new ArrayList<>();
			Property allowedDispatchProtocol = lookupPropertyDefinition(ne, DeploymentProperties._NAME,
					DeploymentProperties.ALLOWED_DISPATCH_PROTOCOL);
			List<? extends PropertyExpression> propertyValues = ne.getPropertyValueList(allowedDispatchProtocol);
			for (PropertyExpression propertyExpression : propertyValues) {
				res.add((EnumerationLiteral) ((NamedValue) propertyExpression).getNamedValue());
			}
			return res;
		} catch (PropertyLookupException e) {
			return Collections.emptyList();
		}
	}

	public static EnumerationLiteral getOverflowHandlingProtocol(final NamedElement ne) {
		try {
			Property overflowHandlingProtocol = lookupPropertyDefinition(ne, CommunicationProperties._NAME,
					CommunicationProperties.OVERFLOW_HANDLING_PROTOCOL);
			return PropertyUtils.getEnumLiteral(ne, overflowHandlingProtocol);
		} catch (final PropertyLookupException e) {
			return null;
		}
	}

	/*
	 * deprecated. Now called getDataSizeInBytes
	 */
	public static double getSourceDataSizeInBytes(final NamedElement ne) {
		return getDataSizeInBytes(ne);
	}

	public static double getDataSizeInBytes(final NamedElement ne) {
		if (ne == null) {
			return 0.0;
		}
		Property SourceDataSize = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.DATA_SIZE);
		UnitLiteral Bytes = findUnitLiteral(SourceDataSize, AadlProject.B_LITERAL);
		return getDataSize(ne, Bytes);
	}

	public static long getBaseAddress(final NamedElement ne) {
		Property ba = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.BASE_ADDRESS);
		return PropertyUtils.getIntegerValue(ne, ba);
	}

	/*
	 * deprecated. Now called getDataSize
	 */
	public static double getSourceDataSize(final NamedElement ne, UnitLiteral unit) {
		return getDataSize(ne, unit);
	}

	public static double getDataSize(final NamedElement ne, UnitLiteral unit) {
		Property DataSize = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.DATA_SIZE);
		Property SourceDataSize = lookupPropertyDefinition(ne, MemoryProperties._NAME,
				MemoryProperties.SOURCE_DATA_SIZE);
		double res = PropertyUtils.getScaledNumberValue(ne, DataSize, unit, 0.0);
		if (res == 0.0) {
			res = PropertyUtils.getScaledNumberValue(ne, SourceDataSize, unit, 0.0);
		}
		long mult = 1;
		if (ne instanceof DataSubcomponent) {
			mult = AadlUtil.getMultiplicity(ne);
		}
		if (res != 0.0) {
			return res * mult;
		}
		if (ne instanceof DataSubcomponent || ne instanceof DataImplementation) {
			// mult is one or the array size of the data subcomponent.
			return sumElementsDataSize(ne, unit, DataSize, SourceDataSize, 0) * mult;
		}
		return 0.0;
	}

	private static double getDataSize(final NamedElement ne, UnitLiteral unit, Property DataSize,
			Property SourceDataSize, int nesting) {
		double res = PropertyUtils.getScaledNumberValue(ne, DataSize, unit, 0.0);
		if (res == 0.0) {
			res = PropertyUtils.getScaledNumberValue(ne, SourceDataSize, unit, 0.0);
		}
		long mult = 1;
		if (ne instanceof DataSubcomponent) {
			mult = AadlUtil.getMultiplicity(ne);
		}
		if (res != 0.0) {
			return res * mult;
		}
		if (nesting > 10) {
			return 0.0;
		}
		if (ne instanceof DataSubcomponent || ne instanceof DataImplementation) {
			// mult is one or the array size of the data subcomponent.
			return sumElementsDataSize(ne, unit, DataSize, SourceDataSize, nesting + 1) * mult;
		}
		return 0.0;
	}

	/*
	 * return data size of elements or zero. Do this for classifier (feature
	 * group type or data implementation), feature instance, feature, data
	 * subcomponent
	 */
	public static double sumElementsDataSize(final NamedElement ne, UnitLiteral unit) {
		Property DataSize = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.DATA_SIZE);
		Property SourceDataSize = lookupPropertyDefinition(ne, MemoryProperties._NAME,
				MemoryProperties.SOURCE_DATA_SIZE);
		return sumElementsDataSize(ne, unit, DataSize, SourceDataSize, 0);
	}

	private static double sumElementsDataSize(final NamedElement ne, UnitLiteral unit, Property DataSize,
			Property SourceDataSize, int nesting) {
		double res = 0.0;
		Classifier cl = null;
		if (ne instanceof Classifier) {
			cl = (Classifier) ne;
		} else if (ne instanceof FeatureInstance) {
			cl = ((FeatureInstance) ne).getFeature().getAllClassifier();
		} else if (ne instanceof Feature) {
			cl = ((Feature) ne).getClassifier();
		} else if (ne instanceof DataSubcomponent) {
			cl = ((DataSubcomponent) ne).getClassifier();
		}
		if (cl != null) {
			if (cl instanceof FeatureGroupType) {
				EList<Feature> fl = ((FeatureGroupType) cl).getAllFeatures();
				for (Feature f : fl) {
					res = res + getDataSize(f, unit, DataSize, SourceDataSize, nesting);
				}
			} else if (cl instanceof DataImplementation) {
				for (Subcomponent ds : ((DataImplementation) cl).getAllSubcomponents()) {
					if (!AadlUtil.isSameOrExtends(cl, ds.getAllClassifier())) {
						res = res + getDataSize(ds, unit, DataSize, SourceDataSize, nesting);
					}
				}
			}
		}
		return res;
	}

	public static double getSourceCodeSizeInBytes(final NamedElement ne) {
		return getCodeSizeInBytes(ne);
	}

	public static double getCodeSizeInBytes(final NamedElement ne) {
		Property SourceCodeSize = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.CODE_SIZE);
		UnitLiteral Bytes = findUnitLiteral(SourceCodeSize, AadlProject.BYTES_LITERAL);
		return getSourceCodeSize(ne, Bytes);
	}

	public static double getSourceStackSizeInBytes(final NamedElement ne) {
		return getStackSizeInBytes(ne);
	}

	public static double getStackSizeInBytes(final NamedElement ne) {
		Property SourceStackSize = lookupPropertyDefinition(ne, MemoryProperties._NAME,
				MemoryProperties.SOURCE_STACK_SIZE);
		UnitLiteral Bytes = findUnitLiteral(SourceStackSize, AadlProject.BYTES_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, SourceStackSize, Bytes, 0.0);
	}

	public static double getSourceCodeSize(final NamedElement ne, UnitLiteral unit) {
		return getCodeSize(ne, unit);
	}

	public static double getCodeSize(final NamedElement ne, UnitLiteral unit) {
		Property SourceCodeSize = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.CODE_SIZE);
		double res = PropertyUtils.getScaledNumberValue(ne, SourceCodeSize, unit, 0.0);
		if (res == 0.0) {
			SourceCodeSize = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.SOURCE_CODE_SIZE);
			res = PropertyUtils.getScaledNumberValue(ne, SourceCodeSize, unit, 0.0);
		}
		return res;
	}

	public static double getSourceStackSize(final NamedElement ne, UnitLiteral unit) {
		return getStackSize(ne, unit);
	}

	public static double getStackSize(final NamedElement ne, UnitLiteral unit) {
		Property SourceStackSize = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.STACK_SIZE);
		double res = PropertyUtils.getScaledNumberValue(ne, SourceStackSize, unit, 0.0);
		if (res == 0.0) {
			SourceStackSize = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.SOURCE_STACK_SIZE);
			res = PropertyUtils.getScaledNumberValue(ne, SourceStackSize, unit, 0.0);
		}
		return res;
	}

	public static double getHeapSize(final NamedElement ne, UnitLiteral unit) {
		Property SourceStackSize = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.HEAP_SIZE);
		double res = PropertyUtils.getScaledNumberValue(ne, SourceStackSize, unit, 0.0);
		if (res == 0.0) {
			SourceStackSize = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.SOURCE_HEAP_SIZE);
			res = PropertyUtils.getScaledNumberValue(ne, SourceStackSize, unit, 0.0);
		}
		return res;
	}

	public static boolean getIsPartition(final NamedElement ne) {
		try {
			Property isPartition = lookupPropertyDefinition(ne, SEI._NAME, SEI.IS_PARTITION);
			return PropertyUtils.getBooleanValue(ne, isPartition);
		} catch (PropertyLookupException e) {
			return false;
		}
	}

	public static double getMaximumLatencyinMilliSec(final NamedElement ne) {
		Property Latency = lookupPropertyDefinition(ne, CommunicationProperties._NAME, CommunicationProperties.LATENCY);
		UnitLiteral milliSecond = PropertiesLinkingService.findUnitLiteral(Latency, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledRangeMaximum(ne, Latency, milliSecond, 0.0);
	}

	public static double getMinimumLatencyinMilliSec(final NamedElement ne) {
		Property Latency = lookupPropertyDefinition(ne, CommunicationProperties._NAME, CommunicationProperties.LATENCY);
		UnitLiteral milliSecond = PropertiesLinkingService.findUnitLiteral(Latency, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledRangeMinimum(ne, Latency, milliSecond, 0.0);
	}

	public static double getLatencyinMicroSec(final NamedElement ne) {
		Property Latency = lookupPropertyDefinition(ne, CommunicationProperties._NAME, CommunicationProperties.LATENCY);
		UnitLiteral microSecond = PropertiesLinkingService.findUnitLiteral(Latency, AadlProject.US_LITERAL);
		return PropertyUtils.getScaledRangeMaximum(ne, Latency, microSecond, 0.0);
	}

	public static double getAccessLatencyinMilliSec(final ComponentInstance HWcomp, final ComponentInstance bus) {
		ConnectionInstance aci = InstanceModelUtil.getBusAccessConnection(HWcomp, bus);
		if (aci == null) {
			return 0.0;
		}
		Property Latency = lookupPropertyDefinition(aci, CommunicationProperties._NAME,
				CommunicationProperties.LATENCY);
		UnitLiteral milliSecond = PropertiesLinkingService.findUnitLiteral(Latency, AadlProject.MS_LITERAL);
		return PropertyUtils.getScaledRangeMaximum(aci, Latency, milliSecond, 0.0);
	}

	public static double getAccessLatencyinMicroSec(final ComponentInstance HWcomp, final ComponentInstance bus) {
		ConnectionInstance aci = InstanceModelUtil.getBusAccessConnection(HWcomp, bus);
		if (aci == null) {
			return 0.0;
		}
		Property Latency = lookupPropertyDefinition(aci, CommunicationProperties._NAME,
				CommunicationProperties.LATENCY);
		UnitLiteral microSecond = PropertiesLinkingService.findUnitLiteral(Latency, AadlProject.US_LITERAL);
		return PropertyUtils.getScaledRangeMaximum(aci, Latency, microSecond, 0.0);
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
		if (origvalue < 10) {
			return original;
		}
		UnitsType ut = (UnitsType) original.eContainer();
		boolean looking = true;
		UnitLiteral target = null;
		UnitLiteral previous = null;
		for (Object element : ut.getOwnedLiterals()) {
			target = (UnitLiteral) element;
			if (looking) {
				if (target == original) {
					looking = false;
					previous = target;
				}
			} else {
				double factor = ((IntegerLiteral) target.getFactor()).getValue();
				origvalue = origvalue / factor;
				if (origvalue < 1) {
					return previous;
				}
				previous = target;
			}
		}
		if (target != null) {
			return target;
		}
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
		Property byteCount = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.BYTE_COUNT);
		return PropertyUtils.getIntegerValue(ne, byteCount, 0);
	}

	public static double getStreamMissRate(final NamedElement ne) {
		return PropertyUtils.getRealValue(ne,
				GetProperties.lookupPropertyDefinition(ne, SEI._NAME, SEI.STREAM_MISS_RATE));
	}

	public static boolean getRequiredConnection(final NamedElement ne) {
		try {
			Property requiredConnection = lookupPropertyDefinition(ne, CommunicationProperties._NAME,
					DeploymentProperties.REQUIRED_CONNECTION);
			return PropertyUtils.getBooleanValue(ne, requiredConnection);
		} catch (PropertyLookupException e) {
			return false;
		}
	}

	public static RecordValue getNotCollocated(final NamedElement ne) {
		try {
			Property nocoll = lookupPropertyDefinition(ne, DeploymentProperties._NAME,
					DeploymentProperties.NOT_COLLOCATED);
			return (RecordValue) PropertyUtils.getSimplePropertyValue(ne, nocoll);
		} catch (PropertyLookupException e) {
			return null;
		}
	}

	public static EnumerationLiteral getConnectionTiming(final NamedElement pc) {
		try {
			Property timing = lookupPropertyDefinition(pc, CommunicationProperties._NAME,
					CommunicationProperties.TIMING);
			return PropertyUtils.getEnumLiteral(pc, timing);
		} catch (PropertyLookupException e) {
			return getSampledUnitLiteral(pc);
		}
	}

	public static EnumerationLiteral getDelayedUnitLiteral(NamedElement pc) {
		Property timing = lookupPropertyDefinition(pc, CommunicationProperties._NAME, CommunicationProperties.TIMING);
		return findEnumerationLiteral(timing, CommunicationProperties.DELAYED);
	}

	public static EnumerationLiteral getImmediateUnitLiteral(NamedElement pc) {
		Property timing = lookupPropertyDefinition(pc, CommunicationProperties._NAME, CommunicationProperties.TIMING);
		return findEnumerationLiteral(timing, CommunicationProperties.IMMEDIATE);
	}

	public static EnumerationLiteral getSampledUnitLiteral(NamedElement pc) {
		Property timing = lookupPropertyDefinition(pc, CommunicationProperties._NAME, CommunicationProperties.TIMING);
		return findEnumerationLiteral(timing, CommunicationProperties.SAMPLED);
	}

	public static double getNetWeight(final NamedElement ne, final double defaultValue) {
		Property netWeight = lookupPropertyDefinition(ne, SEI._NAME, SEI.NETWEIGHT);
		return PropertyUtils.getRealValue(ne, netWeight, defaultValue);
	}

	public static double getGrossWeight(final NamedElement ne, final double defaultValue) {
		Property netWeight = lookupPropertyDefinition(ne, SEI._NAME, SEI.GROSSWEIGHT);
		return PropertyUtils.getRealValue(ne, netWeight, defaultValue);
	}

	public static double getWeightLimit(final NamedElement ne, final double defaultValue) {
		Property netWeight = lookupPropertyDefinition(ne, SEI._NAME, SEI.WEIGHTLIMIT);
		return PropertyUtils.getRealValue(ne, netWeight, defaultValue);
	}

	public static List<ComponentClassifier> getBaseType(final NamedElement ne) {
		Property baseType = lookupPropertyDefinition(ne, DataModel._NAME, DataModel.BASE_TYPE);
		List<ComponentClassifier> res = new BasicEList<ComponentClassifier>();
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = ne.getPropertyValueList(baseType);
		} catch (Exception e) {
			return res;
		}
		for (PropertyExpression propertyExpression : propertyValues) {
			res.add((ComponentClassifier) ((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject());
		}
		return res;
	}

	public static Classifier getSingleBaseType(final NamedElement ne) {
		Property baseType = GetProperties.lookupPropertyDefinition(ne, DataModel._NAME, DataModel.BASE_TYPE);
		if (baseType != null) {
			List<? extends PropertyExpression> srcpropertyValues;
			try {
				srcpropertyValues = ne.getPropertyValueList(baseType);
			} catch (Exception e) {
				return null;
			}
			if (srcpropertyValues.size() == 1) {
				PropertyExpression pv = srcpropertyValues.get(0);
				return ((ClassifierValueImpl) pv).getClassifier();
			}
		}
		return null;
	}

	public static String getMeasurementUnit(final NamedElement ne) {
		Property mUnit = lookupPropertyDefinition(ne, DataModel._NAME, DataModel.MEASUREMENT_UNIT);
		String propertyValue = PropertyUtils.getStringValue(ne, mUnit, "");
		return propertyValue;
	}

	public static RecordValue getOutPutRate(final NamedElement ne) {
		Property outputRate = lookupPropertyDefinition(ne, CommunicationProperties._NAME,
				CommunicationProperties.OUTPUT_RATE);
		try {
			RecordValue propertyValue = (RecordValue) ne.getSimplePropertyValue(outputRate);
			if (propertyValue != null) {
				return propertyValue;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public static RecordValue getInPutRate(final NamedElement ne) {
		Property inputRate = lookupPropertyDefinition(ne, CommunicationProperties._NAME,
				CommunicationProperties.OUTPUT_RATE);
		try {
			RecordValue propertyValue = (RecordValue) ne.getSimplePropertyValue(inputRate);
			if (propertyValue != null) {
				return propertyValue;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public static RangeValue getValueRange(final RecordValue ne) {
		EList<BasicPropertyAssociation> fields = ne.getOwnedFieldValues();
		BasicPropertyAssociation valueRange = getRecordField(fields, "Value_Range");
		return valueRange != null ? (RangeValue) valueRange.getValue() : null;
	}

	public static EnumerationLiteral getRateUnit(final RecordValue ne) {
		EList<BasicPropertyAssociation> fields = ne.getOwnedFieldValues();
		BasicPropertyAssociation rateUnit = getRecordField(fields, "Rate_Unit");
		PropertyExpression res = rateUnit.getValue();
		if (res instanceof NamedValue) {
			return (EnumerationLiteral) ((NamedValue) res).getNamedValue();
		}
		return null;
	}

	public static BasicPropertyAssociation getRecordField(EList<BasicPropertyAssociation> props, String fieldName) {
		for (BasicPropertyAssociation propertyAssociation : props) {
			BasicProperty prop = propertyAssociation.getProperty();
			String name = prop.getName();
			if (fieldName.equalsIgnoreCase(name)) {
				return propertyAssociation;
			}
		}
		return null;
	}

	public static List<? extends PropertyExpression> getModelReferences(final NamedElement ne) {
		try {
			Property modelReferences = lookupPropertyDefinition(ne, SEI._NAME, SEI.MODEL_REFERENCES);
			List<? extends PropertyExpression> values = ne.getPropertyValueList(modelReferences);

			return values;
		} catch (PropertyLookupException e) {
			return null;
		}
	}

	/**
	 * Get the module schedule for a processor
	 *
	 * @param ne
	 *            - the processor component
	 * @return - a list with all the module schedule. An empty list if not
	 *         defined.
	 */
	public static List<ARINC653ScheduleWindow> getModuleSchedule(final ComponentInstance io) {
		Property moduleScheduleProperty;
		List<ARINC653ScheduleWindow> windows;
		List<? extends PropertyExpression> propertyValues;
		RecordValue window;
		IntegerLiteral windowTime;
		BooleanLiteralImpl windowStartProcessing;
		InstanceReferenceValue windowPartition;
		ARINC653ScheduleWindow scheduleWindow;
		boolean startProcessing;
		ComponentInstance part;
		double time;
		Property period;
		UnitLiteral milliseconds;

		period = lookupPropertyDefinition(io, TimingProperties._NAME, TimingProperties.PERIOD);
		milliseconds = findUnitLiteral(period, AadlProject.MS_LITERAL);

		time = 0;
		part = null;
		startProcessing = true;

		moduleScheduleProperty = lookupPropertyDefinition(io, ARINC653Properties._NAME,
				ARINC653Properties.MODULE_SCHEDULE);
		windows = new ArrayList<ARINC653ScheduleWindow>();

		try {
			propertyValues = io.getPropertyValueList(moduleScheduleProperty);

			for (PropertyExpression propertyExpression : propertyValues) {

				if (propertyExpression != null) {

					window = (RecordValue) propertyExpression;
					windowTime = (IntegerLiteral) PropertyUtils.getRecordFieldValue(window, "duration");
					windowStartProcessing = (BooleanLiteralImpl) PropertyUtils.getRecordFieldValue(window,
							"periodic_processing_start");
					windowPartition = (InstanceReferenceValue) PropertyUtils.getRecordFieldValue(window, "partition");
					if (windowPartition != null) {
						part = (ComponentInstance) windowPartition.getReferencedInstanceObject();
					}
					if (windowTime == null) {
						time = 0;
					} else {
						time = ((NumberValue) windowTime).getScaledValue(milliseconds);
					}
					if (part != null) {
						scheduleWindow = new ARINC653ScheduleWindow(part, time, startProcessing);
						windows.add(scheduleWindow);
					}
				}
			}
		} catch (PropertyLookupException e) {
			return windows;
		}
		return windows;
	}

	/**
	 * Return the value of the property ARINC653::Module_Major_Frame
	 *
	 * @param module
	 *            - the component that represents the ARINC653 module
	 * @return - the major frame - 0 otherwise
	 */
	public static double getARINC653ModuleMajorFrame(final ComponentInstance module) {
		Property majorFrame;
		UnitLiteral milliSecond;
		double res;

		if (module == null) {
			return 0;
		}

		majorFrame = lookupPropertyDefinition(module, ARINC653Properties._NAME, ARINC653Properties.MODULE_MAJOR_FRAME);
		milliSecond = findUnitLiteral(majorFrame, AadlProject.MS_LITERAL);

		res = PropertyUtils.getScaledNumberValue(module, majorFrame, milliSecond, 0.0);

		return res;
	}

	public static List<ComponentClassifier> getProvidedVirtualBusClass(final NamedElement io) {
		Property providedVirtualBusClass;
		ArrayList<ComponentClassifier> components;

		providedVirtualBusClass = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.PROVIDED_VIRTUAL_BUS_CLASS);
		components = new ArrayList<>();
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = io.getPropertyValueList(providedVirtualBusClass);
		} catch (Exception e) {
			return components;
		}
		for (PropertyExpression propertyExpression : propertyValues) {
			components.add((ComponentClassifier) ((ClassifierValue) propertyExpression).getClassifier());
		}
		return components;
	}

	/**
	 * Get the virtual bus required for a connection, virtual bus, port, etc.
	 *
	 * @param io
	 *            - the component which has the property
	 * @return - the list of virtual bus classifier
	 */
	public static List<ComponentClassifier> getRequiredVirtualBusClass(final NamedElement io) {
		Property requiredVirtualBusClass;
		ArrayList<ComponentClassifier> components;

		requiredVirtualBusClass = lookupPropertyDefinition(io, DeploymentProperties._NAME,
				DeploymentProperties.REQUIRED_VIRTUAL_BUS_CLASS);
		components = new ArrayList<ComponentClassifier>();
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = io.getPropertyValueList(requiredVirtualBusClass);
		} catch (Exception e) {
			return components;
		}
		for (PropertyExpression propertyExpression : propertyValues) {
			components.add((ComponentClassifier) ((ClassifierValue) propertyExpression).getClassifier());
		}
		return components;
	}

	public static EnumerationLiteral getDataRepresentation(final NamedElement ne) {
		try {
			Property dataRepresentation = lookupPropertyDefinition(ne, DataModel._NAME, DataModel.Data_Representation);
			return PropertyUtils.getEnumLiteral(ne, dataRepresentation);
		} catch (final PropertyLookupException e) {
			return null;
		}
	}

	public static RangeValue getDataIntegerRange(final NamedElement ne) {
		try {
			Property integerRange = lookupPropertyDefinition(ne, DataModel._NAME, DataModel.INTEGER_RANGE);
			return (RangeValue) ne.getSimplePropertyValue(integerRange);
		} catch (final PropertyLookupException e) {
			return null;
		}
	}

	public static RangeValue getDataRealRange(final NamedElement ne) {
		try {
			Property realRange = lookupPropertyDefinition(ne, DataModel._NAME, DataModel.REAL_RANGE);
			return (RangeValue) ne.getSimplePropertyValue(realRange);
		} catch (final PropertyLookupException e) {
			return null;
		}
	}

	public static double getMaxDataRate(RecordValue rate) {
		BasicPropertyAssociation vr = GetProperties.getRecordField(rate.getOwnedFieldValues(), "Value_Range");
		if (vr == null) {
			return 0;
		}
		RangeValue rv = (RangeValue) vr.getOwnedValue();
		PropertyExpression maximum = rv.getMaximum().evaluate(null, 0).first().getValue();
		return ((NumberValue) maximum).getScaledValue();
	}

	public static double getMinDataRate(RecordValue rate) {
		BasicPropertyAssociation vr = GetProperties.getRecordField(rate.getOwnedFieldValues(), "Value_Range");
		if (vr == null) {
			return 0;
		}
		RangeValue rv = (RangeValue) vr.getOwnedValue();
		PropertyExpression minimum = rv.getMinimum().evaluate(null, 0).first().getValue();
		return ((NumberValue) minimum).getScaledValue();
	}

	public static double getMessageRatePerSecond(NamedElement ne) {
		Property dr = GetProperties.lookupPropertyDefinition(ne, SEI._NAME, SEI.DATA_RATE);
		if (dr == null) {
			dr = GetProperties.lookupPropertyDefinition(ne, SEI._NAME, SEI.MESSAGE_RATE);
		}
		if (dr == null) {
			return 0;
		}
		return PropertyUtils.getRealValue(ne, dr, 0.0);
	}

	/*
	 * Look for Message_Rate or SEI::Data_Rate first. Then pick up Output_Rate,
	 * whose default value is 1 per dispatch That rate is converted to persecond
	 * using Period. If Period is zero then the resulting data rate is zero as
	 * well.
	 */
	public static double getOutgoingMessageRatePerSecond(final NamedElement ne) {
		double res = GetProperties.getMessageRatePerSecond(ne);
		if (res > 0) {
			return res;
		}
		Property outputRate = lookupPropertyDefinition(ne, CommunicationProperties._NAME,
				CommunicationProperties.OUTPUT_RATE);
		RecordValue rec = GetProperties.getOutPutRate(ne);
		if (rec != null) {
			res = GetProperties.getMaxDataRate(rec);
			EnumerationLiteral unit = GetProperties.getRateUnit(rec);
			double period = 0;
			if (unit == null || unit.getName().equalsIgnoreCase("PerDispatch")) {
				if (ne instanceof InstanceObject) {
					period = GetProperties.getPeriodInSeconds(((InstanceObject) ne).getContainingComponentInstance(),
							0);
				} else {
					period = GetProperties.getPeriodInSeconds(ne.getContainingClassifier(), 0);
				}
				if (period == 0) {
					return 0;
				}
				res = res / period;
			}
			if (res > 0) {
				return res;
			}
		}
		double period = GetProperties.getPeriodInSeconds(ne.getContainingClassifier(), 0);
		if (period == 0) {
			return 0;
		}
		res = 1 / period;
		return res;
	}

	public static String getClassifierMatchingRuleProperty(NamedElement ne) {
		Property classifierMatchingRuleProperty = GetProperties.lookupPropertyDefinition(ne, ModelingProperties._NAME,
				ModelingProperties.CLASSIFIER_MATCHING_RULE);
		EnumerationLiteral classifierMatchingRuleValue;
		try {
			classifierMatchingRuleValue = PropertyUtils.getEnumLiteral(ne, classifierMatchingRuleProperty);
		} catch (PropertyNotPresentException e) {
			return ModelingProperties.CLASSIFIER_MATCH;
		}
		return classifierMatchingRuleValue.getName();
	}

	public static String getClassifierSubstitutionRuleProperty(NamedElement ne) {
		Property classifierMatchingRuleProperty = GetProperties.lookupPropertyDefinition(ne, ModelingProperties._NAME,
				ModelingProperties.CLASSIFIER_SUBSTITUTION_RULE);
		EnumerationLiteral classifierMatchingRuleValue;
		try {
			classifierMatchingRuleValue = PropertyUtils.getEnumLiteral(ne, classifierMatchingRuleProperty);
		} catch (PropertyNotPresentException e) {
			return ModelingProperties.CLASSIFIER_MATCH;
		}
		return classifierMatchingRuleValue.getName();
	}

	public static double getMemorySize(final NamedElement ne, UnitLiteral unit) {
		Property memorySize = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.MEMORY_SIZE);
		return PropertyUtils.getScaledNumberValue(ne, memorySize, unit, 0.0);
	}

	public static double getMemorySizeInKB(final NamedElement ne) {
		Property memorySize = lookupPropertyDefinition(ne, MemoryProperties._NAME, MemoryProperties.MEMORY_SIZE);
		UnitLiteral KBytes = findUnitLiteral(memorySize, AadlProject.KB_LITERAL);
		return PropertyUtils.getScaledNumberValue(ne, memorySize, KBytes, 0.0);
	}

	public static double getPrice(final NamedElement ne, final double defaultValue) {
		return PropertyUtils.getRealValue(ne, lookupPropertyDefinition(ne, SEI._NAME, SEI.PRICE), defaultValue);
	}

}
