package org.osate.properties.security;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;

public class KeyInstances extends GeneratedRecord {
	public static final String PRIVATE_KEY__NAME = "private_key";
	public static final String PUBLIC_KEY__NAME = "public_key";
	public static final String SINGLE_KEY__NAME = "single_key";
	public static final URI PRIVATE_KEY__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security.aadl#/0/@ownedPropertyType.0/@ownedField.0");
	public static final URI PUBLIC_KEY__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security.aadl#/0/@ownedPropertyType.0/@ownedField.1");
	public static final URI SINGLE_KEY__URI = URI.createURI("platform:/resource/SecurityPropertiesUpdate/Property_Files/Security.aadl#/0/@ownedPropertyType.0/@ownedField.2");
	
	private final Optional<InstanceObject> privateKey;
	private final Optional<InstanceObject> publicKey;
	private final Optional<InstanceObject> singleKey;
	
	public KeyInstances(
			Optional<InstanceObject> privateKey,
			Optional<InstanceObject> publicKey,
			Optional<InstanceObject> singleKey
	) {
		this.privateKey = privateKey;
		this.publicKey = publicKey;
		this.singleKey = singleKey;
	}
	
	public KeyInstances(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<InstanceObject> privateKey_local;
		try {
			privateKey_local = findFieldValue(recordValue, PRIVATE_KEY__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
			});
		} catch (PropertyNotPresentException e) {
			privateKey_local = Optional.empty();
		}
		this.privateKey = privateKey_local;
		
		Optional<InstanceObject> publicKey_local;
		try {
			publicKey_local = findFieldValue(recordValue, PUBLIC_KEY__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
			});
		} catch (PropertyNotPresentException e) {
			publicKey_local = Optional.empty();
		}
		this.publicKey = publicKey_local;
		
		Optional<InstanceObject> singleKey_local;
		try {
			singleKey_local = findFieldValue(recordValue, SINGLE_KEY__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
			});
		} catch (PropertyNotPresentException e) {
			singleKey_local = Optional.empty();
		}
		this.singleKey = singleKey_local;
	}
	
	public Optional<InstanceObject> getPrivateKey() {
		return privateKey;
	}
	
	public Optional<InstanceObject> getPublicKey() {
		return publicKey;
	}
	
	public Optional<InstanceObject> getSingleKey() {
		return singleKey;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!privateKey.isPresent()
				&& !publicKey.isPresent()
				&& !singleKey.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		privateKey.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, PRIVATE_KEY__URI, PRIVATE_KEY__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		publicKey.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, PUBLIC_KEY__URI, PUBLIC_KEY__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		singleKey.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, SINGLE_KEY__URI, SINGLE_KEY__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				privateKey,
				publicKey,
				singleKey
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof KeyInstances)) {
			return false;
		}
		KeyInstances other = (KeyInstances) obj;
		return Objects.equals(this.privateKey, other.privateKey)
				&& Objects.equals(this.publicKey, other.publicKey)
				&& Objects.equals(this.singleKey, other.singleKey);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.privateKey.ifPresent(field -> {
			builder.append(PRIVATE_KEY__NAME);
			builder.append(" => reference (");
			builder.append(field.getName());
			builder.append(");");
		});
		this.publicKey.ifPresent(field -> {
			builder.append(PUBLIC_KEY__NAME);
			builder.append(" => reference (");
			builder.append(field.getName());
			builder.append(");");
		});
		this.singleKey.ifPresent(field -> {
			builder.append(SINGLE_KEY__NAME);
			builder.append(" => reference (");
			builder.append(field.getName());
			builder.append(");");
		});
		builder.append(']');
		return builder.toString();
	}
}
