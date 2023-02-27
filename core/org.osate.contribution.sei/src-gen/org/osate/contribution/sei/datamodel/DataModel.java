/*******************************************************************************
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file). 
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.contribution.sei.datamodel;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerRange;
import org.osate.pluginsupport.properties.RealRange;

public final class DataModel {
	public static final String DATA_MODEL__NAME = "Data_Model";
	
	private DataModel() {}
	
	// Lookup methods for Data_Model::Base_Type
	
	public static final String BASE_TYPE__NAME = "Base_Type";
	
	public static boolean acceptsBaseType(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getBaseType_Property(lookupContext));
	}
	
	public static Optional<List<Classifier>> getBaseType(NamedElement lookupContext) {
		return getBaseType(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Classifier>> getBaseType(NamedElement lookupContext, Mode mode) {
		return getBaseType(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Classifier>> getBaseType(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getBaseType_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((ClassifierValue) resolved1).getClassifier();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getBaseType_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + BASE_TYPE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getBaseType_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getBaseType_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::Code_Set
	
	public static final String CODE_SET__NAME = "Code_Set";
	
	public static boolean acceptsCodeSet(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getCodeSet_Property(lookupContext));
	}
	
	public static OptionalLong getCodeSet(NamedElement lookupContext) {
		return getCodeSet(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getCodeSet(NamedElement lookupContext, Mode mode) {
		return getCodeSet(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getCodeSet(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getCodeSet_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getCodeSet_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + CODE_SET__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getCodeSet_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getCodeSet_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::Data_Digits
	
	public static final String DATA_DIGITS__NAME = "Data_Digits";
	
	public static boolean acceptsDataDigits(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDataDigits_Property(lookupContext));
	}
	
	public static OptionalLong getDataDigits(NamedElement lookupContext) {
		return getDataDigits(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getDataDigits(NamedElement lookupContext, Mode mode) {
		return getDataDigits(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getDataDigits(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDataDigits_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getDataDigits_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + DATA_DIGITS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDataDigits_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDataDigits_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::Data_Scale
	
	public static final String DATA_SCALE__NAME = "Data_Scale";
	
	public static boolean acceptsDataScale(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDataScale_Property(lookupContext));
	}
	
	public static OptionalLong getDataScale(NamedElement lookupContext) {
		return getDataScale(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getDataScale(NamedElement lookupContext, Mode mode) {
		return getDataScale(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getDataScale(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDataScale_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getDataScale_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + DATA_SCALE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDataScale_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDataScale_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::Data_Representation
	
	public static final String DATA_REPRESENTATION__NAME = "Data_Representation";
	
	public static boolean acceptsDataRepresentation(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDataRepresentation_Property(lookupContext));
	}
	
	public static Optional<DataRepresentation> getDataRepresentation(NamedElement lookupContext) {
		return getDataRepresentation(lookupContext, Optional.empty());
	}
	
	public static Optional<DataRepresentation> getDataRepresentation(NamedElement lookupContext, Mode mode) {
		return getDataRepresentation(lookupContext, Optional.of(mode));
	}
	
	public static Optional<DataRepresentation> getDataRepresentation(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDataRepresentation_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(DataRepresentation.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDataRepresentation_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + DATA_REPRESENTATION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDataRepresentation_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDataRepresentation_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::MyDimension
	
	public static final String MYDIMENSION__NAME = "MyDimension";
	
	public static boolean acceptsMydimension(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getMydimension_Property(lookupContext));
	}
	
	public static OptionalLong getMydimension(NamedElement lookupContext) {
		return getMydimension(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getMydimension(NamedElement lookupContext, Mode mode) {
		return getMydimension(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getMydimension(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getMydimension_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getMydimension_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + MYDIMENSION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getMydimension_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getMydimension_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::Dimension
	
	public static final String DIMENSION__NAME = "Dimension";
	
	public static boolean acceptsDimension(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getDimension_Property(lookupContext));
	}
	
	public static Optional<List<Long>> getDimension(NamedElement lookupContext) {
		return getDimension(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Long>> getDimension(NamedElement lookupContext, Mode mode) {
		return getDimension(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Long>> getDimension(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getDimension_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((IntegerLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getDimension_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + DIMENSION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getDimension_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getDimension_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::Element_Names
	
	public static final String ELEMENT_NAMES__NAME = "Element_Names";
	
	public static boolean acceptsElementNames(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getElementNames_Property(lookupContext));
	}
	
	public static Optional<List<String>> getElementNames(NamedElement lookupContext) {
		return getElementNames(lookupContext, Optional.empty());
	}
	
	public static Optional<List<String>> getElementNames(NamedElement lookupContext, Mode mode) {
		return getElementNames(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<String>> getElementNames(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getElementNames_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((StringLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getElementNames_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + ELEMENT_NAMES__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getElementNames_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getElementNames_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::Enumerators
	
	public static final String ENUMERATORS__NAME = "Enumerators";
	
	public static boolean acceptsEnumerators(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getEnumerators_Property(lookupContext));
	}
	
	public static Optional<List<String>> getEnumerators(NamedElement lookupContext) {
		return getEnumerators(lookupContext, Optional.empty());
	}
	
	public static Optional<List<String>> getEnumerators(NamedElement lookupContext, Mode mode) {
		return getEnumerators(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<String>> getEnumerators(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getEnumerators_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((StringLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getEnumerators_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + ENUMERATORS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getEnumerators_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getEnumerators_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::IEEE754_Precision
	
	public static final String IEEE754_PRECISION__NAME = "IEEE754_Precision";
	
	public static boolean acceptsIeee754Precision(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getIeee754Precision_Property(lookupContext));
	}
	
	public static Optional<Ieee754Precision> getIeee754Precision(NamedElement lookupContext) {
		return getIeee754Precision(lookupContext, Optional.empty());
	}
	
	public static Optional<Ieee754Precision> getIeee754Precision(NamedElement lookupContext, Mode mode) {
		return getIeee754Precision(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Ieee754Precision> getIeee754Precision(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getIeee754Precision_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(Ieee754Precision.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getIeee754Precision_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + IEEE754_PRECISION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getIeee754Precision_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getIeee754Precision_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::Initial_Value
	
	public static final String INITIAL_VALUE__NAME = "Initial_Value";
	
	public static boolean acceptsInitialValue(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getInitialValue_Property(lookupContext));
	}
	
	public static Optional<List<String>> getInitialValue(NamedElement lookupContext) {
		return getInitialValue(lookupContext, Optional.empty());
	}
	
	public static Optional<List<String>> getInitialValue(NamedElement lookupContext, Mode mode) {
		return getInitialValue(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<String>> getInitialValue(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getInitialValue_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((StringLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getInitialValue_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + INITIAL_VALUE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getInitialValue_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getInitialValue_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::Integer_Range
	
	public static final String INTEGER_RANGE__NAME = "Integer_Range";
	
	public static boolean acceptsIntegerRange(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getIntegerRange_Property(lookupContext));
	}
	
	public static Optional<IntegerRange> getIntegerRange(NamedElement lookupContext) {
		return getIntegerRange(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerRange> getIntegerRange(NamedElement lookupContext, Mode mode) {
		return getIntegerRange(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerRange> getIntegerRange(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getIntegerRange_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRange(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getIntegerRange_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + INTEGER_RANGE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getIntegerRange_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getIntegerRange_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::Measurement_Unit
	
	public static final String MEASUREMENT_UNIT__NAME = "Measurement_Unit";
	
	public static boolean acceptsMeasurementUnit(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getMeasurementUnit_Property(lookupContext));
	}
	
	public static Optional<String> getMeasurementUnit(NamedElement lookupContext) {
		return getMeasurementUnit(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getMeasurementUnit(NamedElement lookupContext, Mode mode) {
		return getMeasurementUnit(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getMeasurementUnit(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getMeasurementUnit_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getMeasurementUnit_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + MEASUREMENT_UNIT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getMeasurementUnit_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getMeasurementUnit_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::Number_Representation
	
	public static final String NUMBER_REPRESENTATION__NAME = "Number_Representation";
	
	public static boolean acceptsNumberRepresentation(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getNumberRepresentation_Property(lookupContext));
	}
	
	public static Optional<NumberRepresentation> getNumberRepresentation(NamedElement lookupContext) {
		return getNumberRepresentation(lookupContext, Optional.empty());
	}
	
	public static Optional<NumberRepresentation> getNumberRepresentation(NamedElement lookupContext, Mode mode) {
		return getNumberRepresentation(lookupContext, Optional.of(mode));
	}
	
	public static Optional<NumberRepresentation> getNumberRepresentation(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getNumberRepresentation_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(NumberRepresentation.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getNumberRepresentation_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + NUMBER_REPRESENTATION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getNumberRepresentation_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getNumberRepresentation_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::Real_Range
	
	public static final String REAL_RANGE__NAME = "Real_Range";
	
	public static boolean acceptsRealRange(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRealRange_Property(lookupContext));
	}
	
	public static Optional<RealRange> getRealRange(NamedElement lookupContext) {
		return getRealRange(lookupContext, Optional.empty());
	}
	
	public static Optional<RealRange> getRealRange(NamedElement lookupContext, Mode mode) {
		return getRealRange(lookupContext, Optional.of(mode));
	}
	
	public static Optional<RealRange> getRealRange(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRealRange_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealRange(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getRealRange_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + REAL_RANGE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getRealRange_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRealRange_Property(lookupContext));
	}
	
	// Lookup methods for Data_Model::Representation
	
	public static final String REPRESENTATION__NAME = "Representation";
	
	public static boolean acceptsRepresentation(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRepresentation_Property(lookupContext));
	}
	
	public static Optional<List<String>> getRepresentation(NamedElement lookupContext) {
		return getRepresentation(lookupContext, Optional.empty());
	}
	
	public static Optional<List<String>> getRepresentation(NamedElement lookupContext, Mode mode) {
		return getRepresentation(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<String>> getRepresentation(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRepresentation_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((StringLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getRepresentation_Property(EObject lookupContext) {
		String name = DATA_MODEL__NAME + "::" + REPRESENTATION__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getRepresentation_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRepresentation_Property(lookupContext));
	}
}
