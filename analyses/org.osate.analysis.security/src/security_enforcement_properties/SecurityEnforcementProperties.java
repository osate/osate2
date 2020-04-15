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
