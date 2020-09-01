package org.osate.properties.security;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.contrib.aadlproject.SizeUnits;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerWithUnits;
import org.osate.properties.security.types.CaveatType;
import org.osate.properties.security.types.DataSecurityTypes;
import org.osate.properties.security.types.LevelType;
import org.osate.properties.security.types.SecuritySpecificationType;
import org.osate.properties.security.types.SubjectAuthenticationType;

public class Security {
	public static final String SECURITY__NAME = "Security";
	
	public static final String SECURITY_CLEARANCE__NAME = "Security_Clearance";
	public static final String SECURITY_CLEARANCE_SUPPLEMENT__NAME = "Security_Clearance_Supplement";
	public static final String SECONDARY_SECURITY_CLEARANCE__NAME = "Secondary_Security_Clearance";
	public static final String SECONDARY_SECURITY_CLEARANCE_SUPPLEMENT__NAME = "Secondary_Security_Clearance_Supplement";
	public static final String INFORMATION_SECURITY_LEVEL__NAME = "Information_Security_Level";
	public static final String INFORMATION_SECURITY_CAVEATS__NAME = "Information_Security_Caveats";
	public static final String LEVEL__NAME = "Level";
	public static final String LEVEL_CAVEATS__NAME = "Level_Caveats";
	public static final String TRUSTED__NAME = "Trusted";
	public static final String DOWNGRADING__NAME = "Downgrading";
	public static final String UPGRADING__NAME = "Upgrading";
	public static final String DATA_SECURITY__NAME = "Data_Security";
	public static final String DATA_SECURITY_SPECIFICATION__NAME = "Data_Security_Specification";
	public static final String ENCRYPTION_KEYS__NAME = "Encryption_Keys";
	public static final String ENCRYTION_KEY_CLASSIFIERS__NAME = "Encrytion_Key_Classifiers";
	public static final String AUTHENTICATION_KEYS__NAME = "Authentication_Keys";
	public static final String AUTHENTICATION_KEY_CLASSIFIERS__NAME = "Authentication_Key_Classifiers";
	public static final String KEY_LENGTH__NAME = "Key_Length";
	public static final String BLOCK_SIZE__NAME = "Block_Size";
	public static final String TEXT_TYPE__NAME = "Text_Type";
	public static final String CRYPTO_PERIOD__NAME = "Crypto_Period";
	public static final String KEY_DISTRIBITION_METHOD__NAME = "Key_Distribition_Method";
	public static final String SUBJECT_AUTHENTICATION__NAME = "Subject_Authentication";
	public static final String SECURE_FLOW__NAME = "Secure_Flow";
	
	public static Optional<LevelType> getSecurityClearance(NamedElement lookupContext) {
		return getSecurityClearance(lookupContext, Optional.empty());
	}
	
	public static Optional<LevelType> getSecurityClearance(NamedElement lookupContext, Mode mode) {
		return getSecurityClearance(lookupContext, Optional.of(mode));
	}
	
	public static Optional<LevelType> getSecurityClearance(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Security_Clearance";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(LevelType.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSecurityClearance_EObject(NamedElement lookupContext) {
		String name = "Security::Security_Clearance";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getSecurityClearanceSupplement(NamedElement lookupContext) {
		return getSecurityClearanceSupplement(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getSecurityClearanceSupplement(NamedElement lookupContext, Mode mode) {
		return getSecurityClearanceSupplement(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getSecurityClearanceSupplement(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Security_Clearance_Supplement";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSecurityClearanceSupplement_EObject(NamedElement lookupContext) {
		String name = "Security::Security_Clearance_Supplement";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<LevelType> getSecondarySecurityClearance(NamedElement lookupContext) {
		return getSecondarySecurityClearance(lookupContext, Optional.empty());
	}
	
	public static Optional<LevelType> getSecondarySecurityClearance(NamedElement lookupContext, Mode mode) {
		return getSecondarySecurityClearance(lookupContext, Optional.of(mode));
	}
	
	public static Optional<LevelType> getSecondarySecurityClearance(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Secondary_Security_Clearance";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(LevelType.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSecondarySecurityClearance_EObject(NamedElement lookupContext) {
		String name = "Security::Secondary_Security_Clearance";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<String> getSecondarySecurityClearanceSupplement(NamedElement lookupContext) {
		return getSecondarySecurityClearanceSupplement(lookupContext, Optional.empty());
	}
	
	public static Optional<String> getSecondarySecurityClearanceSupplement(NamedElement lookupContext, Mode mode) {
		return getSecondarySecurityClearanceSupplement(lookupContext, Optional.of(mode));
	}
	
	public static Optional<String> getSecondarySecurityClearanceSupplement(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Secondary_Security_Clearance_Supplement";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((StringLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSecondarySecurityClearanceSupplement_EObject(NamedElement lookupContext) {
		String name = "Security::Secondary_Security_Clearance_Supplement";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<LevelType> getInformationSecurityLevel(NamedElement lookupContext) {
		return getInformationSecurityLevel(lookupContext, Optional.empty());
	}
	
	public static Optional<LevelType> getInformationSecurityLevel(NamedElement lookupContext, Mode mode) {
		return getInformationSecurityLevel(lookupContext, Optional.of(mode));
	}
	
	public static Optional<LevelType> getInformationSecurityLevel(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Information_Security_Level";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(LevelType.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getInformationSecurityLevel_EObject(NamedElement lookupContext) {
		String name = "Security::Information_Security_Level";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<CaveatType>> getInformationSecurityCaveats(NamedElement lookupContext) {
		return getInformationSecurityCaveats(lookupContext, Optional.empty());
	}
	
	public static Optional<List<CaveatType>> getInformationSecurityCaveats(NamedElement lookupContext, Mode mode) {
		return getInformationSecurityCaveats(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<CaveatType>> getInformationSecurityCaveats(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Information_Security_Caveats";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return CaveatType.valueOf(resolved1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getInformationSecurityCaveats_EObject(NamedElement lookupContext) {
		String name = "Security::Information_Security_Caveats";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<LevelType> getLevel(NamedElement lookupContext) {
		return getLevel(lookupContext, Optional.empty());
	}
	
	public static Optional<LevelType> getLevel(NamedElement lookupContext, Mode mode) {
		return getLevel(lookupContext, Optional.of(mode));
	}
	
	public static Optional<LevelType> getLevel(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Level";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(LevelType.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getLevel_EObject(NamedElement lookupContext) {
		String name = "Security::Level";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<CaveatType>> getLevelCaveats(NamedElement lookupContext) {
		return getLevelCaveats(lookupContext, Optional.empty());
	}
	
	public static Optional<List<CaveatType>> getLevelCaveats(NamedElement lookupContext, Mode mode) {
		return getLevelCaveats(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<CaveatType>> getLevelCaveats(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Level_Caveats";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return CaveatType.valueOf(resolved1);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getLevelCaveats_EObject(NamedElement lookupContext) {
		String name = "Security::Level_Caveats";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Boolean> getTrusted(NamedElement lookupContext) {
		return getTrusted(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getTrusted(NamedElement lookupContext, Mode mode) {
		return getTrusted(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getTrusted(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Trusted";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getTrusted_EObject(NamedElement lookupContext) {
		String name = "Security::Trusted";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Boolean> getDowngrading(NamedElement lookupContext) {
		return getDowngrading(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getDowngrading(NamedElement lookupContext, Mode mode) {
		return getDowngrading(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getDowngrading(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Downgrading";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDowngrading_EObject(NamedElement lookupContext) {
		String name = "Security::Downgrading";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Boolean> getUpgrading(NamedElement lookupContext) {
		return getUpgrading(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getUpgrading(NamedElement lookupContext, Mode mode) {
		return getUpgrading(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getUpgrading(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Upgrading";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getUpgrading_EObject(NamedElement lookupContext) {
		String name = "Security::Upgrading";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<DataSecurityTypes> getDataSecurity(NamedElement lookupContext) {
		return getDataSecurity(lookupContext, Optional.empty());
	}
	
	public static Optional<DataSecurityTypes> getDataSecurity(NamedElement lookupContext, Mode mode) {
		return getDataSecurity(lookupContext, Optional.of(mode));
	}
	
	public static Optional<DataSecurityTypes> getDataSecurity(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Data_Security";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(DataSecurityTypes.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDataSecurity_EObject(NamedElement lookupContext) {
		String name = "Security::Data_Security";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<SecuritySpecificationType>> getDataSecuritySpecification(NamedElement lookupContext) {
		return getDataSecuritySpecification(lookupContext, Optional.empty());
	}
	
	public static Optional<List<SecuritySpecificationType>> getDataSecuritySpecification(NamedElement lookupContext, Mode mode) {
		return getDataSecuritySpecification(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<SecuritySpecificationType>> getDataSecuritySpecification(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Data_Security_Specification";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new SecuritySpecificationType(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getDataSecuritySpecification_EObject(NamedElement lookupContext) {
		String name = "Security::Data_Security_Specification";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<KeyInstances>> getEncryptionKeys(NamedElement lookupContext) {
		return getEncryptionKeys(lookupContext, Optional.empty());
	}
	
	public static Optional<List<KeyInstances>> getEncryptionKeys(NamedElement lookupContext, Mode mode) {
		return getEncryptionKeys(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<KeyInstances>> getEncryptionKeys(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Encryption_Keys";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new KeyInstances(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getEncryptionKeys_EObject(NamedElement lookupContext) {
		String name = "Security::Encryption_Keys";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<Classifier>> getEncrytionKeyClassifiers(NamedElement lookupContext) {
		return getEncrytionKeyClassifiers(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Classifier>> getEncrytionKeyClassifiers(NamedElement lookupContext, Mode mode) {
		return getEncrytionKeyClassifiers(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Classifier>> getEncrytionKeyClassifiers(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Encrytion_Key_Classifiers";
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
	
	public static PropertyExpression getEncrytionKeyClassifiers_EObject(NamedElement lookupContext) {
		String name = "Security::Encrytion_Key_Classifiers";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<KeyInstances>> getAuthenticationKeys(NamedElement lookupContext) {
		return getAuthenticationKeys(lookupContext, Optional.empty());
	}
	
	public static Optional<List<KeyInstances>> getAuthenticationKeys(NamedElement lookupContext, Mode mode) {
		return getAuthenticationKeys(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<KeyInstances>> getAuthenticationKeys(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Authentication_Keys";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new KeyInstances(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getAuthenticationKeys_EObject(NamedElement lookupContext) {
		String name = "Security::Authentication_Keys";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<List<Classifier>> getAuthenticationKeyClassifiers(NamedElement lookupContext) {
		return getAuthenticationKeyClassifiers(lookupContext, Optional.empty());
	}
	
	public static Optional<List<Classifier>> getAuthenticationKeyClassifiers(NamedElement lookupContext, Mode mode) {
		return getAuthenticationKeyClassifiers(lookupContext, Optional.of(mode));
	}
	
	public static Optional<List<Classifier>> getAuthenticationKeyClassifiers(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Authentication_Key_Classifiers";
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
	
	public static PropertyExpression getAuthenticationKeyClassifiers_EObject(NamedElement lookupContext) {
		String name = "Security::Authentication_Key_Classifiers";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getKeyLength(NamedElement lookupContext) {
		return getKeyLength(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getKeyLength(NamedElement lookupContext, Mode mode) {
		return getKeyLength(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getKeyLength(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Key_Length";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getKeyLength_EObject(NamedElement lookupContext) {
		String name = "Security::Key_Length";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getBlockSize(NamedElement lookupContext) {
		return getBlockSize(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getBlockSize(NamedElement lookupContext, Mode mode) {
		return getBlockSize(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<SizeUnits>> getBlockSize(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Block_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, SizeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getBlockSize_EObject(NamedElement lookupContext) {
		String name = "Security::Block_Size";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<TextType> getTextType(NamedElement lookupContext) {
		return getTextType(lookupContext, Optional.empty());
	}
	
	public static Optional<TextType> getTextType(NamedElement lookupContext, Mode mode) {
		return getTextType(lookupContext, Optional.of(mode));
	}
	
	public static Optional<TextType> getTextType(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Text_Type";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(TextType.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getTextType_EObject(NamedElement lookupContext) {
		String name = "Security::Text_Type";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getCryptoPeriod(NamedElement lookupContext) {
		return getCryptoPeriod(lookupContext, Optional.empty());
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getCryptoPeriod(NamedElement lookupContext, Mode mode) {
		return getCryptoPeriod(lookupContext, Optional.of(mode));
	}
	
	public static Optional<IntegerWithUnits<TimeUnits>> getCryptoPeriod(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Crypto_Period";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getCryptoPeriod_EObject(NamedElement lookupContext) {
		String name = "Security::Crypto_Period";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<KeyDistribitionMethod> getKeyDistribitionMethod(NamedElement lookupContext) {
		return getKeyDistribitionMethod(lookupContext, Optional.empty());
	}
	
	public static Optional<KeyDistribitionMethod> getKeyDistribitionMethod(NamedElement lookupContext, Mode mode) {
		return getKeyDistribitionMethod(lookupContext, Optional.of(mode));
	}
	
	public static Optional<KeyDistribitionMethod> getKeyDistribitionMethod(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Key_Distribition_Method";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(KeyDistribitionMethod.valueOf(resolved));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getKeyDistribitionMethod_EObject(NamedElement lookupContext) {
		String name = "Security::Key_Distribition_Method";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<SubjectAuthenticationType> getSubjectAuthentication(NamedElement lookupContext) {
		return getSubjectAuthentication(lookupContext, Optional.empty());
	}
	
	public static Optional<SubjectAuthenticationType> getSubjectAuthentication(NamedElement lookupContext, Mode mode) {
		return getSubjectAuthentication(lookupContext, Optional.of(mode));
	}
	
	public static Optional<SubjectAuthenticationType> getSubjectAuthentication(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Subject_Authentication";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new SubjectAuthenticationType(resolved, lookupContext, mode));
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSubjectAuthentication_EObject(NamedElement lookupContext) {
		String name = "Security::Subject_Authentication";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
	
	public static Optional<Boolean> getSecureFlow(NamedElement lookupContext) {
		return getSecureFlow(lookupContext, Optional.empty());
	}
	
	public static Optional<Boolean> getSecureFlow(NamedElement lookupContext, Mode mode) {
		return getSecureFlow(lookupContext, Optional.of(mode));
	}
	
	public static Optional<Boolean> getSecureFlow(NamedElement lookupContext, Optional<Mode> mode) {
		String name = "Security::Secure_Flow";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}
	
	public static PropertyExpression getSecureFlow_EObject(NamedElement lookupContext) {
		String name = "Security::Secure_Flow";
		Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
		return lookupContext.getNonModalPropertyValue(property);
	}
}
