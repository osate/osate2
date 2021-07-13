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
package org.osate.contribution.sei.codegenerationproperties;

import java.util.Optional;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;

/**
 * @since 1.2
 */
public class CodeGenerationProperties {
	public static final String CODE_GENERATION_PROPERTIES__NAME = "Code_Generation_Properties";

	public static final String CONVENTION__NAME = "Convention";
	public static final String PARAMETER_USAGE__NAME = "Parameter_Usage";
	public static final String RETURN_PARAMETER__NAME = "Return_Parameter";

	public static Optional<Convention> getConvention(NamedElement lookupContext) {
		return getConvention(lookupContext, Optional.empty());
	}

	public static Optional<Convention> getConvention(NamedElement lookupContext, Mode mode) {
		return getConvention(lookupContext, Optional.of(mode));
	}

	public static Optional<Convention> getConvention(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Code_Generation_Properties::Convention";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(Convention.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getConvention_EObject(NamedElement lookupContext) {
		String name = "Code_Generation_Properties::Convention";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<ParameterUsage> getParameterUsage(NamedElement lookupContext) {
		return getParameterUsage(lookupContext, Optional.empty());
	}

	public static Optional<ParameterUsage> getParameterUsage(NamedElement lookupContext, Mode mode) {
		return getParameterUsage(lookupContext, Optional.of(mode));
	}

	public static Optional<ParameterUsage> getParameterUsage(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Code_Generation_Properties::Parameter_Usage";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(ParameterUsage.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getParameterUsage_EObject(NamedElement lookupContext) {
		String name = "Code_Generation_Properties::Parameter_Usage";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}

	public static Optional<Boolean> getReturnParameter(NamedElement lookupContext) {
		return getReturnParameter(lookupContext, Optional.empty());
	}

	public static Optional<Boolean> getReturnParameter(NamedElement lookupContext, Mode mode) {
		return getReturnParameter(lookupContext, Optional.of(mode));
	}

	public static Optional<Boolean> getReturnParameter(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Code_Generation_Properties::Return_Parameter";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static PropertyExpression getReturnParameter_EObject(NamedElement lookupContext) {
		String name = "Code_Generation_Properties::Return_Parameter";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
