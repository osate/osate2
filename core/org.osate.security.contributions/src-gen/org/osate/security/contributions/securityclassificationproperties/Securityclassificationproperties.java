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
package org.osate.security.contributions.securityclassificationproperties;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;

public final class Securityclassificationproperties {
	public static final String SECURITYCLASSIFICATIONPROPERTIES__NAME = "SecurityClassificationProperties";
	
	private Securityclassificationproperties() {}
	
	// Lookup methods for SecurityClassificationProperties::Security_Level
	
	public static final String SECURITY_LEVEL__NAME = "Security_Level";
	
	public static boolean acceptsSecurityLevel(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSecurityLevel_Property(lookupContext));
	}
	
	public static Optional<SecurityLevel> getSecurityLevel(NamedElement lookupContext) {
		return getSecurityLevel(lookupContext, Optional.empty());
	}
	
	public static Optional<SecurityLevel> getSecurityLevel(NamedElement lookupContext, Mode mode) {
		return getSecurityLevel(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SecurityLevel> getSecurityLevel(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSecurityLevel_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(SecurityLevel.valueOf(resolved));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSecurityLevel_Property(EObject lookupContext) {
		String name = SECURITYCLASSIFICATIONPROPERTIES__NAME + "::" + SECURITY_LEVEL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSecurityLevel_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSecurityLevel_Property(lookupContext));
	}
	
	// Lookup methods for SecurityClassificationProperties::Security_Level_Caveats
	
	public static final String SECURITY_LEVEL_CAVEATS__NAME = "Security_Level_Caveats";
	
	public static boolean acceptsSecurityLevelCaveats(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getSecurityLevelCaveats_Property(lookupContext));
	}
	
	public static Optional<List<SecurityLevelCaveats>> getSecurityLevelCaveats(NamedElement lookupContext) {
		return getSecurityLevelCaveats(lookupContext, Optional.empty());
	}
	
	public static Optional<List<SecurityLevelCaveats>> getSecurityLevelCaveats(NamedElement lookupContext, Mode mode) {
		return getSecurityLevelCaveats(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<SecurityLevelCaveats>> getSecurityLevelCaveats(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getSecurityLevelCaveats_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return SecurityLevelCaveats.valueOf(resolved1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getSecurityLevelCaveats_Property(EObject lookupContext) {
		String name = SECURITYCLASSIFICATIONPROPERTIES__NAME + "::" + SECURITY_LEVEL_CAVEATS__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getSecurityLevelCaveats_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getSecurityLevelCaveats_Property(lookupContext));
	}
	
	// Lookup methods for SecurityClassificationProperties::Trusted
	
	public static final String TRUSTED__NAME = "Trusted";
	
	public static boolean acceptsTrusted(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getTrusted_Property(lookupContext));
	}
	
	public static Optional<Boolean> getTrusted(NamedElement lookupContext) {
		return getTrusted(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getTrusted(NamedElement lookupContext, Mode mode) {
		return getTrusted(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getTrusted(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getTrusted_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}
	
	public static Property getTrusted_Property(EObject lookupContext) {
		String name = SECURITYCLASSIFICATIONPROPERTIES__NAME + "::" + TRUSTED__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}
	
	public static PropertyExpression getTrusted_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getTrusted_Property(lookupContext));
	}
}
