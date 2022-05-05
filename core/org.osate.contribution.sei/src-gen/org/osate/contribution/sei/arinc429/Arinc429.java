/*******************************************************************************
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.contribution.sei.arinc429;

import java.util.Optional;
import java.util.OptionalLong;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;

public final class Arinc429 {
	public static final String ARINC429__NAME = "ARINC429";
	
	private Arinc429() {}
	
	// Lookup methods for ARINC429::WordID
	
	public static final String WORDID__NAME = "WordID";
	
	public static boolean acceptsWordid(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getWordid_Property(lookupContext));
	}
	
	public static OptionalLong getWordid(NamedElement lookupContext) {
		return getWordid(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getWordid(NamedElement lookupContext, Mode mode) {
		return getWordid(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getWordid(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getWordid_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getWordid_Property(EObject lookupContext) {
		String name = ARINC429__NAME + "::" + WORDID__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getWordid_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getWordid_Property(lookupContext));
	}
	
	// Lookup methods for ARINC429::FirstBit
	
	public static final String FIRSTBIT__NAME = "FirstBit";
	
	public static boolean acceptsFirstbit(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getFirstbit_Property(lookupContext));
	}
	
	public static OptionalLong getFirstbit(NamedElement lookupContext) {
		return getFirstbit(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getFirstbit(NamedElement lookupContext, Mode mode) {
		return getFirstbit(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getFirstbit(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getFirstbit_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getFirstbit_Property(EObject lookupContext) {
		String name = ARINC429__NAME + "::" + FIRSTBIT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getFirstbit_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getFirstbit_Property(lookupContext));
	}
	
	// Lookup methods for ARINC429::NumberBits
	
	public static final String NUMBERBITS__NAME = "NumberBits";
	
	public static boolean acceptsNumberbits(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getNumberbits_Property(lookupContext));
	}
	
	public static OptionalLong getNumberbits(NamedElement lookupContext) {
		return getNumberbits(lookupContext, Optional.empty());
	}
	
	public static OptionalLong getNumberbits(NamedElement lookupContext, Mode mode) {
		return getNumberbits(lookupContext, Optional.of(mode));
	}
	
	public static OptionalLong getNumberbits(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getNumberbits_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}
	
	public static Property getNumberbits_Property(EObject lookupContext) {
		String name = ARINC429__NAME + "::" + NUMBERBITS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getNumberbits_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getNumberbits_Property(lookupContext));
	}
}
