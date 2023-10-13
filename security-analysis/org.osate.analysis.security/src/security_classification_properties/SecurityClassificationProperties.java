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
package security_classification_properties;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;

import security_type_specifications.CaveatType;
import security_type_specifications.LevelType;

public class SecurityClassificationProperties {
	public static Optional<LevelType> getSecurityClearance(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Security_Clearance";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(new LevelType(propertyExpression));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSecurityClearance_EObject(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Security_Clearance";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getSecurityClearanceSupplement(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Security_Clearance_Supplement";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(((StringLiteral) propertyExpression).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSecurityClearanceSupplement_EObject(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Security_Clearance_Supplement";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<LevelType> getSecondarySecurityClearance(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Secondary_Security_Clearance";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(new LevelType(propertyExpression));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSecondarySecurityClearance_EObject(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Secondary_Security_Clearance";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getSecondarySecurityClearanceSupplement(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Secondary_Security_Clearance_Supplement";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(((StringLiteral) propertyExpression).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSecondarySecurityClearanceSupplement_EObject(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Secondary_Security_Clearance_Supplement";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<LevelType> getInformationSecurityLevel(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Information_Security_Level";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(new LevelType(propertyExpression));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getInformationSecurityLevel_EObject(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Information_Security_Level";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<CaveatType>> getInformationSecurityCaveats(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Information_Security_Caveats";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
				return new CaveatType(element1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getInformationSecurityCaveats_EObject(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Information_Security_Caveats";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<LevelType> getSecurityLevel(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Security_Level";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(new LevelType(propertyExpression));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSecurityLevel_EObject(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Security_Level";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<CaveatType>> getSecurityLevelCaveats(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Security_Level_Caveats";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
				return new CaveatType(element1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSecurityLevelCaveats_EObject(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Security_Level_Caveats";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<Boolean> getTrusted(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Trusted";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(((BooleanLiteral) propertyExpression).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getTrusted_EObject(NamedElement namedElement) {
		String name = "Security_Classification_Properties::Trusted";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
}
