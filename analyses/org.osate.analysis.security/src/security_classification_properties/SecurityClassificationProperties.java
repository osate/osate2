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
