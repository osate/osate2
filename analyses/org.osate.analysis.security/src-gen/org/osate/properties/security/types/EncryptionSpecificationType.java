package org.osate.properties.security.types;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedEnumeration;
import org.osate.pluginsupport.properties.GeneratedRecord;

public class EncryptionSpecificationType extends GeneratedRecord {
	public static final String ALGORITHM_NAME__NAME = "algorithm_name";
	public static final String ENCRYPTION_MODE__NAME = "encryption_mode";
	public static final String PADDING__NAME = "padding";
	public static final String KEY_CLASSIFIER__NAME = "key_classifier";
	public static final URI ALGORITHM_NAME__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.0");
	public static final URI ENCRYPTION_MODE__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.1");
	public static final URI PADDING__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.2");
	public static final URI KEY_CLASSIFIER__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.3");
	
	private final Optional<AlgorithmName_FieldType> algorithmName;
	private final Optional<EncryptionMode_FieldType> encryptionMode;
	private final Optional<Padding_FieldType> padding;
	private final Optional<Classifier> keyClassifier;
	
	public EncryptionSpecificationType(
			Optional<AlgorithmName_FieldType> algorithmName,
			Optional<EncryptionMode_FieldType> encryptionMode,
			Optional<Padding_FieldType> padding,
			Optional<Classifier> keyClassifier
	) {
		this.algorithmName = algorithmName;
		this.encryptionMode = encryptionMode;
		this.padding = padding;
		this.keyClassifier = keyClassifier;
	}
	
	public EncryptionSpecificationType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<AlgorithmName_FieldType> algorithmName_local;
		try {
			algorithmName_local = findFieldValue(recordValue, ALGORITHM_NAME__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return AlgorithmName_FieldType.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			algorithmName_local = Optional.empty();
		}
		this.algorithmName = algorithmName_local;
		
		Optional<EncryptionMode_FieldType> encryptionMode_local;
		try {
			encryptionMode_local = findFieldValue(recordValue, ENCRYPTION_MODE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return EncryptionMode_FieldType.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			encryptionMode_local = Optional.empty();
		}
		this.encryptionMode = encryptionMode_local;
		
		Optional<Padding_FieldType> padding_local;
		try {
			padding_local = findFieldValue(recordValue, PADDING__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return Padding_FieldType.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			padding_local = Optional.empty();
		}
		this.padding = padding_local;
		
		Optional<Classifier> keyClassifier_local;
		try {
			keyClassifier_local = findFieldValue(recordValue, KEY_CLASSIFIER__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((ClassifierValue) resolved).getClassifier();
			});
		} catch (PropertyNotPresentException e) {
			keyClassifier_local = Optional.empty();
		}
		this.keyClassifier = keyClassifier_local;
	}
	
	public Optional<AlgorithmName_FieldType> getAlgorithmName() {
		return algorithmName;
	}
	
	public Optional<EncryptionMode_FieldType> getEncryptionMode() {
		return encryptionMode;
	}
	
	public Optional<Padding_FieldType> getPadding() {
		return padding;
	}
	
	public Optional<Classifier> getKeyClassifier() {
		return keyClassifier;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!algorithmName.isPresent()
				&& !encryptionMode.isPresent()
				&& !padding.isPresent()
				&& !keyClassifier.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		algorithmName.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, ALGORITHM_NAME__URI, ALGORITHM_NAME__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		encryptionMode.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, ENCRYPTION_MODE__URI, ENCRYPTION_MODE__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		padding.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, PADDING__URI, PADDING__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		keyClassifier.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, KEY_CLASSIFIER__URI, KEY_CLASSIFIER__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				algorithmName,
				encryptionMode,
				padding,
				keyClassifier
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EncryptionSpecificationType)) {
			return false;
		}
		EncryptionSpecificationType other = (EncryptionSpecificationType) obj;
		return Objects.equals(this.algorithmName, other.algorithmName)
				&& Objects.equals(this.encryptionMode, other.encryptionMode)
				&& Objects.equals(this.padding, other.padding)
				&& Objects.equals(this.keyClassifier, other.keyClassifier);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.algorithmName.ifPresent(field -> {
			builder.append(ALGORITHM_NAME__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.encryptionMode.ifPresent(field -> {
			builder.append(ENCRYPTION_MODE__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.padding.ifPresent(field -> {
			builder.append(PADDING__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.keyClassifier.ifPresent(field -> {
			builder.append(KEY_CLASSIFIER__NAME);
			builder.append(" => classifier (");
			builder.append(field.getQualifiedName());
			builder.append(");");
		});
		builder.append(']');
		return builder.toString();
	}
	
	public enum AlgorithmName_FieldType implements GeneratedEnumeration {
		OTP("OTP", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.0/@ownedPropertyType/@ownedLiteral.0"),
		DES("DES", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.0/@ownedPropertyType/@ownedLiteral.1"),
		TRIPLEDES("TripleDES", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.0/@ownedPropertyType/@ownedLiteral.2"),
		AES("AES", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.0/@ownedPropertyType/@ownedLiteral.3"),
		BLOWFISH("Blowfish", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.0/@ownedPropertyType/@ownedLiteral.4"),
		TWOFISH("TwoFish", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.0/@ownedPropertyType/@ownedLiteral.5"),
		RSA("RSA", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.0/@ownedPropertyType/@ownedLiteral.6"),
		ECC("ECC", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.0/@ownedPropertyType/@ownedLiteral.7"),
		CHACHA20("ChaCha20", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.0/@ownedPropertyType/@ownedLiteral.8"),
		SALSA20("Salsa20", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.0/@ownedPropertyType/@ownedLiteral.9");
		
		private final String originalName;
		private final URI uri;
		
		private AlgorithmName_FieldType(String originalName, String uri) {
			this.originalName = originalName;
			this.uri = URI.createURI(uri);
		}
		
		public static AlgorithmName_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public URI getURI() {
			return uri;
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
	
	public enum EncryptionMode_FieldType implements GeneratedEnumeration {
		ECB("ECB", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.1/@ownedPropertyType/@ownedLiteral.0"),
		CBC("CBC", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.1/@ownedPropertyType/@ownedLiteral.1"),
		CFB("CFB", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.1/@ownedPropertyType/@ownedLiteral.2"),
		CTR("CTR", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.1/@ownedPropertyType/@ownedLiteral.3"),
		GCM("GCM", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.1/@ownedPropertyType/@ownedLiteral.4");
		
		private final String originalName;
		private final URI uri;
		
		private EncryptionMode_FieldType(String originalName, String uri) {
			this.originalName = originalName;
			this.uri = URI.createURI(uri);
		}
		
		public static EncryptionMode_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public URI getURI() {
			return uri;
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
	
	public enum Padding_FieldType implements GeneratedEnumeration {
		NO_PADDING("no_padding", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.2/@ownedPropertyType/@ownedLiteral.0"),
		FIXED("fixed", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.2/@ownedPropertyType/@ownedLiteral.1"),
		OAEP("OAEP", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.4/@ownedField.2/@ownedPropertyType/@ownedLiteral.2");
		
		private final String originalName;
		private final URI uri;
		
		private Padding_FieldType(String originalName, String uri) {
			this.originalName = originalName;
			this.uri = URI.createURI(uri);
		}
		
		public static Padding_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public URI getURI() {
			return uri;
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
}
