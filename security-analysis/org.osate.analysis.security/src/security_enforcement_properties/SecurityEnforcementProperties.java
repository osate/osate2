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
package security_enforcement_properties;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;

import aadl_project.Size;
import aadl_project.Time;
import security_type_specifications.SecuritySpecificationType;
import security_type_specifications.SubjectAuthenticationType;

public class SecurityEnforcementProperties {
	public static Optional<DataSecurity> getDataSecurity(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Data_Security";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(new DataSecurity(propertyExpression));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDataSecurity_EObject(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Data_Security";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<SecuritySpecificationType>> getDataSecuritySpecification(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Data_Security_Specification";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
				return new SecuritySpecificationType(element1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDataSecuritySpecification_EObject(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Data_Security_Specification";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<KeyInstances>> getEncryptionKeys(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Encryption_Keys";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
				return new KeyInstances(element1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getEncryptionKeys_EObject(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Encryption_Keys";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<Classifier>> getEncrytionKeyClassifiers(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Encrytion_Key_Classifiers";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
				return ((ClassifierValue) element1).getClassifier();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getEncrytionKeyClassifiers_EObject(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Encrytion_Key_Classifiers";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<KeyInstances>> getAuthenticationKeys(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Authentication_Keys";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
				return new KeyInstances(element1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getAuthenticationKeys_EObject(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Authentication_Keys";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<Classifier>> getAuthenticationKeyClassifiers(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Authentication_Key_Classifiers";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
				return ((ClassifierValue) element1).getClassifier();
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getAuthenticationKeyClassifiers_EObject(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Authentication_Key_Classifiers";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<Size> getKeyLength(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Key_Length";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(new Size(propertyExpression));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getKeyLength_EObject(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Key_Length";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<TextType> getTextType(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Text_Type";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(TextType.valueOf(propertyExpression));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getTextType_EObject(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Text_Type";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<Time> getCryptoPeriod(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Crypto_Period";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(new Time(propertyExpression));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getCryptoPeriod_EObject(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Crypto_Period";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<SubjectAuthenticationType> getSubjectAuthentication(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Subject_Authentication";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(new SubjectAuthenticationType(propertyExpression));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSubjectAuthentication_EObject(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Subject_Authentication";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<Boolean> getSecureFlow(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Secure_Flow";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(((BooleanLiteral) propertyExpression).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSecureFlow_EObject(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Secure_Flow";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
	
	public static Optional<KeyDistribitionMethod> getKeyDistribitionMethod(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Key_Distribition_Method";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
			return Optional.of(KeyDistribitionMethod.valueOf(propertyExpression));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getKeyDistribitionMethod_EObject(NamedElement namedElement) {
		String name = "Security_Enforcement_Properties::Key_Distribition_Method";
		Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
		return namedElement.getNonModalPropertyValue(property);
	}
}
