package org.osate.properties.security.types;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicPropertyAssociation;
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

public class SecuritySpecificationType extends GeneratedRecord {
	public static final String ENCRYPTION__NAME = "encryption";
	public static final String AUTHENTICATION__NAME = "authentication";
	public static final String AUTHENTICATED_ENCRYPTION_FORM__NAME = "authenticated_encryption_form";
	public static final URI ENCRYPTION__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.3/@ownedField.0");
	public static final URI AUTHENTICATION__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.3/@ownedField.1");
	public static final URI AUTHENTICATED_ENCRYPTION_FORM__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.3/@ownedField.2");
	
	private final Optional<EncryptionSpecificationType> encryption;
	private final Optional<DataAuthenticationType> authentication;
	private final Optional<AuthenticatedEncryptionForm_FieldType> authenticatedEncryptionForm;
	
	public SecuritySpecificationType(
			Optional<EncryptionSpecificationType> encryption,
			Optional<DataAuthenticationType> authentication,
			Optional<AuthenticatedEncryptionForm_FieldType> authenticatedEncryptionForm
	) {
		this.encryption = encryption;
		this.authentication = authentication;
		this.authenticatedEncryptionForm = authenticatedEncryptionForm;
	}
	
	public SecuritySpecificationType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<EncryptionSpecificationType> encryption_local;
		try {
			encryption_local = findFieldValue(recordValue, ENCRYPTION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return new EncryptionSpecificationType(resolved, lookupContext, mode);
			});
		} catch (PropertyNotPresentException e) {
			encryption_local = Optional.empty();
		}
		this.encryption = encryption_local;
		
		Optional<DataAuthenticationType> authentication_local;
		try {
			authentication_local = findFieldValue(recordValue, AUTHENTICATION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return new DataAuthenticationType(resolved, lookupContext, mode);
			});
		} catch (PropertyNotPresentException e) {
			authentication_local = Optional.empty();
		}
		this.authentication = authentication_local;
		
		Optional<AuthenticatedEncryptionForm_FieldType> authenticatedEncryptionForm_local;
		try {
			authenticatedEncryptionForm_local = findFieldValue(recordValue, AUTHENTICATED_ENCRYPTION_FORM__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return AuthenticatedEncryptionForm_FieldType.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			authenticatedEncryptionForm_local = Optional.empty();
		}
		this.authenticatedEncryptionForm = authenticatedEncryptionForm_local;
	}
	
	public Optional<EncryptionSpecificationType> getEncryption() {
		return encryption;
	}
	
	public Optional<DataAuthenticationType> getAuthentication() {
		return authentication;
	}
	
	public Optional<AuthenticatedEncryptionForm_FieldType> getAuthenticatedEncryptionForm() {
		return authenticatedEncryptionForm;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!encryption.isPresent()
				&& !authentication.isPresent()
				&& !authenticatedEncryptionForm.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		encryption.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, ENCRYPTION__URI, ENCRYPTION__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		authentication.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, AUTHENTICATION__URI, AUTHENTICATION__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		authenticatedEncryptionForm.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, AUTHENTICATED_ENCRYPTION_FORM__URI, AUTHENTICATED_ENCRYPTION_FORM__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				encryption,
				authentication,
				authenticatedEncryptionForm
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SecuritySpecificationType)) {
			return false;
		}
		SecuritySpecificationType other = (SecuritySpecificationType) obj;
		return Objects.equals(this.encryption, other.encryption)
				&& Objects.equals(this.authentication, other.authentication)
				&& Objects.equals(this.authenticatedEncryptionForm, other.authenticatedEncryptionForm);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.encryption.ifPresent(field -> {
			builder.append(ENCRYPTION__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.authentication.ifPresent(field -> {
			builder.append(AUTHENTICATION__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.authenticatedEncryptionForm.ifPresent(field -> {
			builder.append(AUTHENTICATED_ENCRYPTION_FORM__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
	
	public enum AuthenticatedEncryptionForm_FieldType implements GeneratedEnumeration {
		GCM("GCM", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.3/@ownedField.2/@ownedPropertyType/@ownedLiteral.0"),
		CBC_MAC("CBC_MAC", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.3/@ownedField.2/@ownedPropertyType/@ownedLiteral.1"),
		ENCRYPT_THEN_MAC("encrypt_then_MAC", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.3/@ownedField.2/@ownedPropertyType/@ownedLiteral.2"),
		MAC_THEN_ENCRYPT("MAC_then_encrypt", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.3/@ownedField.2/@ownedPropertyType/@ownedLiteral.3"),
		ENCRYPT_AND_MAC("encrypt_and_MAC", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.3/@ownedField.2/@ownedPropertyType/@ownedLiteral.4"),
		SIGNCRYPTION("signcryption", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.3/@ownedField.2/@ownedPropertyType/@ownedLiteral.5");
		
		private final String originalName;
		private final URI uri;
		
		private AuthenticatedEncryptionForm_FieldType(String originalName, String uri) {
			this.originalName = originalName;
			this.uri = URI.createURI(uri);
		}
		
		public static AuthenticatedEncryptionForm_FieldType valueOf(PropertyExpression propertyExpression) {
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
