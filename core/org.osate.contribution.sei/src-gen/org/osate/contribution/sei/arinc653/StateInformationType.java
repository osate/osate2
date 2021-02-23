package org.osate.contribution.sei.arinc653;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalLong;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;

/**
 * @since 1.2
 */
public class StateInformationType extends GeneratedRecord {
	public static final String IDENTIFIER__NAME = "Identifier";
	public static final String DESCRIPTION__NAME = "Description";
	public static final URI IDENTIFIER__URI = URI.createURI("platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.6/@ownedField.0");
	public static final URI DESCRIPTION__URI = URI.createURI("platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.6/@ownedField.1");

	private final OptionalLong identifier;
	private final Optional<String> description;

	public StateInformationType(
			OptionalLong identifier,
			Optional<String> description
	) {
		this.identifier = identifier;
		this.description = description;
	}

	public StateInformationType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;

		OptionalLong identifier_local;
		try {
			identifier_local = findFieldValue(recordValue, IDENTIFIER__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((IntegerLiteral) resolved).getValue();
			}).map(OptionalLong::of).orElse(OptionalLong.empty());
		} catch (PropertyNotPresentException e) {
			identifier_local = OptionalLong.empty();
		}
		this.identifier = identifier_local;

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
	}

	public OptionalLong getIdentifier() {
		return identifier;
	}

	public Optional<String> getDescription() {
		return description;
	}

	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!identifier.isPresent()
				&& !description.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		identifier.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, IDENTIFIER__URI, IDENTIFIER__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		description.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, DESCRIPTION__URI, DESCRIPTION__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		return recordValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				identifier,
				description
		);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof StateInformationType)) {
			return false;
		}
		StateInformationType other = (StateInformationType) obj;
		return Objects.equals(this.identifier, other.identifier)
				&& Objects.equals(this.description, other.description);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.identifier.ifPresent(field -> {
			builder.append(IDENTIFIER__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.description.ifPresent(field -> {
			builder.append(DESCRIPTION__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		builder.append(']');
		return builder.toString();
	}
}
