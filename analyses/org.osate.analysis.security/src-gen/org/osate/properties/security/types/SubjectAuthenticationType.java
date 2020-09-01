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
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedEnumeration;
import org.osate.pluginsupport.properties.GeneratedRecord;

public class SubjectAuthenticationType extends GeneratedRecord {
	public static final String DESCRIPTION__NAME = "description";
	public static final String AUTHENTICATION_ACCESS_TYPE__NAME = "authentication_access_type";
	public static final String TWO_AND_MULTI_LAYERED_FACTORS__NAME = "two_and_multi_layered_factors";
	public static final String AUTHENTICATION_PROTOCOL__NAME = "authentication_protocol";
	public static final String AUTHENTICATION_ROLE__NAME = "authentication_role";
	public static final URI DESCRIPTION__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.6/@ownedField.0");
	public static final URI AUTHENTICATION_ACCESS_TYPE__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.6/@ownedField.1");
	public static final URI TWO_AND_MULTI_LAYERED_FACTORS__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.6/@ownedField.2");
	public static final URI AUTHENTICATION_PROTOCOL__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.6/@ownedField.3");
	public static final URI AUTHENTICATION_ROLE__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.6/@ownedField.4");
	
	private final Optional<String> description;
	private final Optional<String> authenticationAccessType;
	private final Optional<List<String>> twoAndMultiLayeredFactors;
	private final Optional<String> authenticationProtocol;
	private final Optional<AuthenticationRole_FieldType> authenticationRole;
	
	public SubjectAuthenticationType(
			Optional<String> description,
			Optional<String> authenticationAccessType,
			Optional<List<String>> twoAndMultiLayeredFactors,
			Optional<String> authenticationProtocol,
			Optional<AuthenticationRole_FieldType> authenticationRole
	) {
		this.description = description;
		this.authenticationAccessType = authenticationAccessType;
		this.twoAndMultiLayeredFactors = twoAndMultiLayeredFactors;
		this.authenticationProtocol = authenticationProtocol;
		this.authenticationRole = authenticationRole;
	}
	
	public SubjectAuthenticationType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<String> description_local;
		try {
			description_local = findFieldValue(recordValue, DESCRIPTION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			description_local = Optional.empty();
		}
		this.description = description_local;
		
		Optional<String> authenticationAccessType_local;
		try {
			authenticationAccessType_local = findFieldValue(recordValue, AUTHENTICATION_ACCESS_TYPE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			authenticationAccessType_local = Optional.empty();
		}
		this.authenticationAccessType = authenticationAccessType_local;
		
		Optional<List<String>> twoAndMultiLayeredFactors_local;
		try {
			twoAndMultiLayeredFactors_local = findFieldValue(recordValue, TWO_AND_MULTI_LAYERED_FACTORS__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
					PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
					return ((StringLiteral) resolved1).getValue();
				}).collect(Collectors.toList());
			});
		} catch (PropertyNotPresentException e) {
			twoAndMultiLayeredFactors_local = Optional.empty();
		}
		this.twoAndMultiLayeredFactors = twoAndMultiLayeredFactors_local;
		
		Optional<String> authenticationProtocol_local;
		try {
			authenticationProtocol_local = findFieldValue(recordValue, AUTHENTICATION_PROTOCOL__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			authenticationProtocol_local = Optional.empty();
		}
		this.authenticationProtocol = authenticationProtocol_local;
		
		Optional<AuthenticationRole_FieldType> authenticationRole_local;
		try {
			authenticationRole_local = findFieldValue(recordValue, AUTHENTICATION_ROLE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return AuthenticationRole_FieldType.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			authenticationRole_local = Optional.empty();
		}
		this.authenticationRole = authenticationRole_local;
	}
	
	public Optional<String> getDescription() {
		return description;
	}
	
	public Optional<String> getAuthenticationAccessType() {
		return authenticationAccessType;
	}
	
	public Optional<List<String>> getTwoAndMultiLayeredFactors() {
		return twoAndMultiLayeredFactors;
	}
	
	public Optional<String> getAuthenticationProtocol() {
		return authenticationProtocol;
	}
	
	public Optional<AuthenticationRole_FieldType> getAuthenticationRole() {
		return authenticationRole;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!description.isPresent()
				&& !authenticationAccessType.isPresent()
				&& !twoAndMultiLayeredFactors.isPresent()
				&& !authenticationProtocol.isPresent()
				&& !authenticationRole.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		description.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, DESCRIPTION__URI, DESCRIPTION__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		authenticationAccessType.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, AUTHENTICATION_ACCESS_TYPE__URI, AUTHENTICATION_ACCESS_TYPE__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		twoAndMultiLayeredFactors.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, TWO_AND_MULTI_LAYERED_FACTORS__URI, TWO_AND_MULTI_LAYERED_FACTORS__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
				return CodeGenUtil.toPropertyExpression(element1);
			}));
		});
		authenticationProtocol.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, AUTHENTICATION_PROTOCOL__URI, AUTHENTICATION_PROTOCOL__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		authenticationRole.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, AUTHENTICATION_ROLE__URI, AUTHENTICATION_ROLE__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				description,
				authenticationAccessType,
				twoAndMultiLayeredFactors,
				authenticationProtocol,
				authenticationRole
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SubjectAuthenticationType)) {
			return false;
		}
		SubjectAuthenticationType other = (SubjectAuthenticationType) obj;
		return Objects.equals(this.description, other.description)
				&& Objects.equals(this.authenticationAccessType, other.authenticationAccessType)
				&& Objects.equals(this.twoAndMultiLayeredFactors, other.twoAndMultiLayeredFactors)
				&& Objects.equals(this.authenticationProtocol, other.authenticationProtocol)
				&& Objects.equals(this.authenticationRole, other.authenticationRole);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.description.ifPresent(field -> {
			builder.append(DESCRIPTION__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.authenticationAccessType.ifPresent(field -> {
			builder.append(AUTHENTICATION_ACCESS_TYPE__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.twoAndMultiLayeredFactors.ifPresent(field -> {
			builder.append(TWO_AND_MULTI_LAYERED_FACTORS__NAME);
			builder.append(" => ");
			builder.append(field.stream().map(element1 -> {
				return '\"' + element1 + '\"';
			}).collect(Collectors.joining(", ", "(", ")")));
			builder.append(';');
		});
		this.authenticationProtocol.ifPresent(field -> {
			builder.append(AUTHENTICATION_PROTOCOL__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.authenticationRole.ifPresent(field -> {
			builder.append(AUTHENTICATION_ROLE__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
	
	public enum AuthenticationRole_FieldType implements GeneratedEnumeration {
		NO_AUTHENTICATION("no_authentication", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.6/@ownedField.4/@ownedPropertyType/@ownedLiteral.0"),
		AUTHENTICATOR("authenticator", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.6/@ownedField.4/@ownedPropertyType/@ownedLiteral.1"),
		ACCESSOR("accessor", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.6/@ownedField.4/@ownedPropertyType/@ownedLiteral.2"),
		PROVIDER("provider", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.6/@ownedField.4/@ownedPropertyType/@ownedLiteral.3"),
		REQUIRER("requirer", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.6/@ownedField.4/@ownedPropertyType/@ownedLiteral.4"),
		MUTUAL("mutual", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.6/@ownedField.4/@ownedPropertyType/@ownedLiteral.5");
		
		private final String originalName;
		private final URI uri;
		
		private AuthenticationRole_FieldType(String originalName, String uri) {
			this.originalName = originalName;
			this.uri = URI.createURI(uri);
		}
		
		public static AuthenticationRole_FieldType valueOf(PropertyExpression propertyExpression) {
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
