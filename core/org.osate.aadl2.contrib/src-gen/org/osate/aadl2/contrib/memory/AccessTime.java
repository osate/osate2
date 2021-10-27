package org.osate.aadl2.contrib.memory;

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
import org.osate.aadl2.contrib.communication.IoTimeSpec;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;

public class AccessTime extends GeneratedRecord {
	public static final String FIRST__NAME = "First";
	public static final String LAST__NAME = "Last";
	public static final URI FIRST__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Memory_Properties.aadl#/0/@ownedProperty.1/@ownedPropertyType/@ownedField.0");
	public static final URI LAST__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Memory_Properties.aadl#/0/@ownedProperty.1/@ownedPropertyType/@ownedField.1");
	
	private final Optional<IoTimeSpec> first;
	private final Optional<IoTimeSpec> last;
	
	public AccessTime(
			Optional<IoTimeSpec> first,
			Optional<IoTimeSpec> last
	) {
		this.first = first;
		this.last = last;
	}
	
	public AccessTime(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<IoTimeSpec> first_local;
		try {
			first_local = findFieldValue(recordValue, FIRST__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return new IoTimeSpec(resolved, lookupContext, mode);
			});
		} catch (PropertyNotPresentException e) {
			first_local = Optional.empty();
		}
		this.first = first_local;
		
		Optional<IoTimeSpec> last_local;
		try {
			last_local = findFieldValue(recordValue, LAST__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return new IoTimeSpec(resolved, lookupContext, mode);
			});
		} catch (PropertyNotPresentException e) {
			last_local = Optional.empty();
		}
		this.last = last_local;
	}
	
	public Optional<IoTimeSpec> getFirst() {
		return first;
	}
	
	public Optional<IoTimeSpec> getLast() {
		return last;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!first.isPresent()
				&& !last.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		first.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, FIRST__URI, FIRST__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		last.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, LAST__URI, LAST__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				first,
				last
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AccessTime)) {
			return false;
		}
		AccessTime other = (AccessTime) obj;
		return Objects.equals(this.first, other.first)
				&& Objects.equals(this.last, other.last);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.first.ifPresent(field -> {
			builder.append(FIRST__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.last.ifPresent(field -> {
			builder.append(LAST__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
}
