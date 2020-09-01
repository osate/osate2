package org.osate.properties.security.types;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.contrib.aadlproject.SizeUnits;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedEnumeration;
import org.osate.pluginsupport.properties.GeneratedRecord;
import org.osate.pluginsupport.properties.IntegerWithUnits;

public class DataAuthenticationType extends GeneratedRecord {
	public static final String AUTHENTICATION_ALGORITHM__NAME = "authentication_algorithm";
	public static final String AUTHENTICATION_KEY_TYPE__NAME = "authentication_key_type";
	public static final String HASH_ALGORITHM__NAME = "hash_algorithm";
	public static final String HASH_LENGTH__NAME = "hash_length";
	public static final URI AUTHENTICATION_ALGORITHM__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0");
	public static final URI AUTHENTICATION_KEY_TYPE__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.1");
	public static final URI HASH_ALGORITHM__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.2");
	public static final URI HASH_LENGTH__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.3");
	
	private final Optional<AuthenticationAlgorithm_FieldType> authenticationAlgorithm;
	private final Optional<List<Classifier>> authenticationKeyType;
	private final Optional<HashAlgorithm_FieldType> hashAlgorithm;
	private final Optional<IntegerWithUnits<SizeUnits>> hashLength;
	
	public DataAuthenticationType(
			Optional<AuthenticationAlgorithm_FieldType> authenticationAlgorithm,
			Optional<List<Classifier>> authenticationKeyType,
			Optional<HashAlgorithm_FieldType> hashAlgorithm,
			Optional<IntegerWithUnits<SizeUnits>> hashLength
	) {
		this.authenticationAlgorithm = authenticationAlgorithm;
		this.authenticationKeyType = authenticationKeyType;
		this.hashAlgorithm = hashAlgorithm;
		this.hashLength = hashLength;
	}
	
	public DataAuthenticationType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<AuthenticationAlgorithm_FieldType> authenticationAlgorithm_local;
		try {
			authenticationAlgorithm_local = findFieldValue(recordValue, AUTHENTICATION_ALGORITHM__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return AuthenticationAlgorithm_FieldType.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			authenticationAlgorithm_local = Optional.empty();
		}
		this.authenticationAlgorithm = authenticationAlgorithm_local;
		
		Optional<List<Classifier>> authenticationKeyType_local;
		try {
			authenticationKeyType_local = findFieldValue(recordValue, AUTHENTICATION_KEY_TYPE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
					PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
					return ((ClassifierValue) resolved1).getClassifier();
				}).collect(Collectors.toList());
			});
		} catch (PropertyNotPresentException e) {
			authenticationKeyType_local = Optional.empty();
		}
		this.authenticationKeyType = authenticationKeyType_local;
		
		Optional<HashAlgorithm_FieldType> hashAlgorithm_local;
		try {
			hashAlgorithm_local = findFieldValue(recordValue, HASH_ALGORITHM__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return HashAlgorithm_FieldType.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			hashAlgorithm_local = Optional.empty();
		}
		this.hashAlgorithm = hashAlgorithm_local;
		
		Optional<IntegerWithUnits<SizeUnits>> hashLength_local;
		try {
			hashLength_local = findFieldValue(recordValue, HASH_LENGTH__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return new IntegerWithUnits<>(resolved, SizeUnits.class);
			});
		} catch (PropertyNotPresentException e) {
			hashLength_local = Optional.empty();
		}
		this.hashLength = hashLength_local;
	}
	
	public Optional<AuthenticationAlgorithm_FieldType> getAuthenticationAlgorithm() {
		return authenticationAlgorithm;
	}
	
	public Optional<List<Classifier>> getAuthenticationKeyType() {
		return authenticationKeyType;
	}
	
	public Optional<HashAlgorithm_FieldType> getHashAlgorithm() {
		return hashAlgorithm;
	}
	
	public Optional<IntegerWithUnits<SizeUnits>> getHashLength() {
		return hashLength;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!authenticationAlgorithm.isPresent()
				&& !authenticationKeyType.isPresent()
				&& !hashAlgorithm.isPresent()
				&& !hashLength.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		authenticationAlgorithm.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, AUTHENTICATION_ALGORITHM__URI, AUTHENTICATION_ALGORITHM__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		authenticationKeyType.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, AUTHENTICATION_KEY_TYPE__URI, AUTHENTICATION_KEY_TYPE__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
				return CodeGenUtil.toPropertyExpression(element1);
			}));
		});
		hashAlgorithm.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, HASH_ALGORITHM__URI, HASH_ALGORITHM__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		hashLength.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, HASH_LENGTH__URI, HASH_LENGTH__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				authenticationAlgorithm,
				authenticationKeyType,
				hashAlgorithm,
				hashLength
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DataAuthenticationType)) {
			return false;
		}
		DataAuthenticationType other = (DataAuthenticationType) obj;
		return Objects.equals(this.authenticationAlgorithm, other.authenticationAlgorithm)
				&& Objects.equals(this.authenticationKeyType, other.authenticationKeyType)
				&& Objects.equals(this.hashAlgorithm, other.hashAlgorithm)
				&& Objects.equals(this.hashLength, other.hashLength);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.authenticationAlgorithm.ifPresent(field -> {
			builder.append(AUTHENTICATION_ALGORITHM__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.authenticationKeyType.ifPresent(field -> {
			builder.append(AUTHENTICATION_KEY_TYPE__NAME);
			builder.append(" => ");
			builder.append(field.stream().map(element1 -> {
				return "classifier (" + element1.getQualifiedName() + ")";
			}).collect(Collectors.joining(", ", "(", ")")));
			builder.append(';');
		});
		this.hashAlgorithm.ifPresent(field -> {
			builder.append(HASH_ALGORITHM__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.hashLength.ifPresent(field -> {
			builder.append(HASH_LENGTH__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
	
	public enum AuthenticationAlgorithm_FieldType implements GeneratedEnumeration {
		RSA("RSA", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.0"),
		ELGAMAL("ElGamal", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.1"),
		DSA("DSA", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.2"),
		ECC("ECC", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.3"),
		ECDSA("ECDSA", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.4"),
		AES_CBC_MAC("AES_CBC_MAC", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.5"),
		AES_GCM("AES_GCM", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.6"),
		HMAC_SHA1("HMAC_SHA1", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.7"),
		AES_CMAC("AES_CMAC", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.8"),
		AES_OMAC("AES_OMAC", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.9"),
		AES_UMAC("AES_UMAC", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.10"),
		POLY1305_AES("Poly1305_AES", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.11"),
		CHACHA20_POLY1305("ChaCha20_Poly1305", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.12"),
		SALSA20_POLY1305("Salsa20_Poly1305", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.0/@ownedPropertyType/@ownedLiteral.13");
		
		private final String originalName;
		private final URI uri;
		
		private AuthenticationAlgorithm_FieldType(String originalName, String uri) {
			this.originalName = originalName;
			this.uri = URI.createURI(uri);
		}
		
		public static AuthenticationAlgorithm_FieldType valueOf(PropertyExpression propertyExpression) {
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
	
	public enum HashAlgorithm_FieldType implements GeneratedEnumeration {
		MD5("MD5", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.2/@ownedPropertyType/@ownedLiteral.0"),
		SHA1("SHA1", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.2/@ownedPropertyType/@ownedLiteral.1"),
		SHA2("SHA2", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.2/@ownedPropertyType/@ownedLiteral.2"),
		SHA3("SHA3", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.2/@ownedPropertyType/@ownedLiteral.3"),
		RIPEMD("RIPEMD", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.2/@ownedPropertyType/@ownedLiteral.4"),
		WHIRLPOOL("Whirlpool", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.2/@ownedPropertyType/@ownedLiteral.5"),
		BLAKE("BLAKE", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.2/@ownedPropertyType/@ownedLiteral.6"),
		BLAKE2("BLAKE2", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.5/@ownedField.2/@ownedPropertyType/@ownedLiteral.7");
		
		private final String originalName;
		private final URI uri;
		
		private HashAlgorithm_FieldType(String originalName, String uri) {
			this.originalName = originalName;
			this.uri = URI.createURI(uri);
		}
		
		public static HashAlgorithm_FieldType valueOf(PropertyExpression propertyExpression) {
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
