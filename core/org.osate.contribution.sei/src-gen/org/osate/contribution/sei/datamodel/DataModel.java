/*******************************************************************************
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party
 * beneficiaries to this license with respect to the terms applicable to their Third Party Software. Third Party
 * Software licenses only apply to the Third Party Software and not any other portion of this program or this program
 * as a whole.
 *******************************************************************************/
package org.osate.contribution.sei.datamodel;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

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
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerRange;
import org.osate.pluginsupport.properties.RealRange;

/**
 * @since 1.2
 */
public class DataModel {
	public static final String DATA_MODEL__NAME = "Data_Model";

	public static final String BASE_TYPE__NAME = "Base_Type";
	public static final String CODE_SET__NAME = "Code_Set";
	public static final String DATA_DIGITS__NAME = "Data_Digits";
	public static final String DATA_SCALE__NAME = "Data_Scale";
	public static final String DATA_REPRESENTATION__NAME = "Data_Representation";
	public static final String MYDIMENSION__NAME = "MyDimension";
	public static final String DIMENSION__NAME = "Dimension";
	public static final String ELEMENT_NAMES__NAME = "Element_Names";
	public static final String ENUMERATORS__NAME = "Enumerators";
	public static final String IEEE754_PRECISION__NAME = "IEEE754_Precision";
	public static final String INITIAL_VALUE__NAME = "Initial_Value";
	public static final String INTEGER_RANGE__NAME = "Integer_Range";
	public static final String MEASUREMENT_UNIT__NAME = "Measurement_Unit";
	public static final String NUMBER_REPRESENTATION__NAME = "Number_Representation";
	public static final String REAL_RANGE__NAME = "Real_Range";
	public static final String REPRESENTATION__NAME = "Representation";

	public static Optional<List<Classifier>> getBaseType(NamedElement lookupContext) {
		return getBaseType(lookupContext, Optional.empty());
	}

	public static Optional<List<Classifier>> getBaseType(NamedElement lookupContext, Mode mode) {
		return getBaseType(lookupContext, Optional.of(mode));
	}

	public static Optional<List<Classifier>> getBaseType(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Base_Type";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((ClassifierValue) resolved1).getClassifier();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getBaseType_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Base_Type";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static OptionalLong getCodeSet(NamedElement lookupContext) {
		return getCodeSet(lookupContext, Optional.empty());
	}

	public static OptionalLong getCodeSet(NamedElement lookupContext, Mode mode) {
		return getCodeSet(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getCodeSet(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Code_Set";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}

	public static PropertyExpression getCodeSet_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Code_Set";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static OptionalLong getDataDigits(NamedElement lookupContext) {
		return getDataDigits(lookupContext, Optional.empty());
	}

	public static OptionalLong getDataDigits(NamedElement lookupContext, Mode mode) {
		return getDataDigits(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getDataDigits(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Data_Digits";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}

	public static PropertyExpression getDataDigits_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Data_Digits";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static OptionalLong getDataScale(NamedElement lookupContext) {
		return getDataScale(lookupContext, Optional.empty());
	}

	public static OptionalLong getDataScale(NamedElement lookupContext, Mode mode) {
		return getDataScale(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getDataScale(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Data_Scale";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}

	public static PropertyExpression getDataScale_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Data_Scale";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<DataRepresentation> getDataRepresentation(NamedElement lookupContext) {
		return getDataRepresentation(lookupContext, Optional.empty());
	}

	public static Optional<DataRepresentation> getDataRepresentation(NamedElement lookupContext, Mode mode) {
		return getDataRepresentation(lookupContext, Optional.of(mode));
	}

	public static Optional<DataRepresentation> getDataRepresentation(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Data_Representation";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(DataRepresentation.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getDataRepresentation_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Data_Representation";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static OptionalLong getMydimension(NamedElement lookupContext) {
		return getMydimension(lookupContext, Optional.empty());
	}

	public static OptionalLong getMydimension(NamedElement lookupContext, Mode mode) {
		return getMydimension(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getMydimension(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::MyDimension";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return OptionalLong.empty();
		}
	}

	public static PropertyExpression getMydimension_EObject(NamedElement lookupContext) {
		String name = "Data_Model::MyDimension";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<List<Long>> getDimension(NamedElement lookupContext) {
		return getDimension(lookupContext, Optional.empty());
	}

	public static Optional<List<Long>> getDimension(NamedElement lookupContext, Mode mode) {
		return getDimension(lookupContext, Optional.of(mode));
	}

	public static Optional<List<Long>> getDimension(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Dimension";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((IntegerLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getDimension_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Dimension";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<List<String>> getElementNames(NamedElement lookupContext) {
		return getElementNames(lookupContext, Optional.empty());
	}

	public static Optional<List<String>> getElementNames(NamedElement lookupContext, Mode mode) {
		return getElementNames(lookupContext, Optional.of(mode));
	}

	public static Optional<List<String>> getElementNames(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Element_Names";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((StringLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getElementNames_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Element_Names";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<List<String>> getEnumerators(NamedElement lookupContext) {
		return getEnumerators(lookupContext, Optional.empty());
	}

	public static Optional<List<String>> getEnumerators(NamedElement lookupContext, Mode mode) {
		return getEnumerators(lookupContext, Optional.of(mode));
	}

	public static Optional<List<String>> getEnumerators(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Enumerators";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((StringLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getEnumerators_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Enumerators";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<Ieee754Precision> getIeee754Precision(NamedElement lookupContext) {
		return getIeee754Precision(lookupContext, Optional.empty());
	}

	public static Optional<Ieee754Precision> getIeee754Precision(NamedElement lookupContext, Mode mode) {
		return getIeee754Precision(lookupContext, Optional.of(mode));
	}

	public static Optional<Ieee754Precision> getIeee754Precision(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::IEEE754_Precision";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(Ieee754Precision.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getIeee754Precision_EObject(NamedElement lookupContext) {
		String name = "Data_Model::IEEE754_Precision";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<List<String>> getInitialValue(NamedElement lookupContext) {
		return getInitialValue(lookupContext, Optional.empty());
	}

	public static Optional<List<String>> getInitialValue(NamedElement lookupContext, Mode mode) {
		return getInitialValue(lookupContext, Optional.of(mode));
	}

	public static Optional<List<String>> getInitialValue(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Initial_Value";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((StringLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getInitialValue_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Initial_Value";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<IntegerRange> getIntegerRange(NamedElement lookupContext) {
		return getIntegerRange(lookupContext, Optional.empty());
	}

	public static Optional<IntegerRange> getIntegerRange(NamedElement lookupContext, Mode mode) {
		return getIntegerRange(lookupContext, Optional.of(mode));
	}

	public static Optional<IntegerRange> getIntegerRange(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Integer_Range";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerRange(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getIntegerRange_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Integer_Range";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<String> getMeasurementUnit(NamedElement lookupContext) {
		return getMeasurementUnit(lookupContext, Optional.empty());
	}

	public static Optional<String> getMeasurementUnit(NamedElement lookupContext, Mode mode) {
		return getMeasurementUnit(lookupContext, Optional.of(mode));
	}

	public static Optional<String> getMeasurementUnit(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Measurement_Unit";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getMeasurementUnit_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Measurement_Unit";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<NumberRepresentation> getNumberRepresentation(NamedElement lookupContext) {
		return getNumberRepresentation(lookupContext, Optional.empty());
	}

	public static Optional<NumberRepresentation> getNumberRepresentation(NamedElement lookupContext, Mode mode) {
		return getNumberRepresentation(lookupContext, Optional.of(mode));
	}

	public static Optional<NumberRepresentation> getNumberRepresentation(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Number_Representation";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(NumberRepresentation.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getNumberRepresentation_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Number_Representation";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<RealRange> getRealRange(NamedElement lookupContext) {
		return getRealRange(lookupContext, Optional.empty());
	}

	public static Optional<RealRange> getRealRange(NamedElement lookupContext, Mode mode) {
		return getRealRange(lookupContext, Optional.of(mode));
	}

	public static Optional<RealRange> getRealRange(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Real_Range";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new RealRange(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getRealRange_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Real_Range";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<List<String>> getRepresentation(NamedElement lookupContext) {
		return getRepresentation(lookupContext, Optional.empty());
	}

	public static Optional<List<String>> getRepresentation(NamedElement lookupContext, Mode mode) {
		return getRepresentation(lookupContext, Optional.of(mode));
	}

	public static Optional<List<String>> getRepresentation(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Data_Model::Representation";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return ((StringLiteral) resolved1).getValue();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getRepresentation_EObject(NamedElement lookupContext) {
		String name = "Data_Model::Representation";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
