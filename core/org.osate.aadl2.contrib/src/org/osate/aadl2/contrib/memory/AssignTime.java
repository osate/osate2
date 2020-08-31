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
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;
import org.osate.pluginsupport.properties.IntegerRangeWithUnits;

public class AssignTime extends GeneratedRecord {
	public static final String FIXED__NAME = "Fixed";
	public static final String PERBYTE__NAME = "PerByte";
	public static final URI FIXED__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Memory_Properties.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedField.0");
	public static final URI PERBYTE__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Memory_Properties.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedField.1");
	
	private final Optional<IntegerRangeWithUnits<TimeUnits>> fixed;
	private final Optional<IntegerRangeWithUnits<TimeUnits>> perbyte;
	
	public AssignTime(
			Optional<IntegerRangeWithUnits<TimeUnits>> fixed,
			Optional<IntegerRangeWithUnits<TimeUnits>> perbyte
	) {
		this.fixed = fixed;
		this.perbyte = perbyte;
	}
	
	public AssignTime(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<IntegerRangeWithUnits<TimeUnits>> fixed_local;
		try {
			fixed_local = findFieldValue(recordValue, FIXED__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode);
			});
		} catch (PropertyNotPresentException e) {
			fixed_local = Optional.empty();
		}
		this.fixed = fixed_local;
		
		Optional<IntegerRangeWithUnits<TimeUnits>> perbyte_local;
		try {
			perbyte_local = findFieldValue(recordValue, PERBYTE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode);
			});
		} catch (PropertyNotPresentException e) {
			perbyte_local = Optional.empty();
		}
		this.perbyte = perbyte_local;
	}
	
	public Optional<IntegerRangeWithUnits<TimeUnits>> getFixed() {
		return fixed;
	}
	
	public Optional<IntegerRangeWithUnits<TimeUnits>> getPerbyte() {
		return perbyte;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!fixed.isPresent()
				&& !perbyte.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		fixed.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, FIXED__URI, FIXED__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		perbyte.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, PERBYTE__URI, PERBYTE__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				fixed,
				perbyte
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AssignTime)) {
			return false;
		}
		AssignTime other = (AssignTime) obj;
		return Objects.equals(this.fixed, other.fixed)
				&& Objects.equals(this.perbyte, other.perbyte);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.fixed.ifPresent(field -> {
			builder.append(FIXED__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.perbyte.ifPresent(field -> {
			builder.append(PERBYTE__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
}
