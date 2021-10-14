package org.osate.aadl2.errormodel.contrib.emv2;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;
import org.osate.pluginsupport.properties.IntegerWithUnits;

public class Hazardallocation extends GeneratedRecord {
	public static final String ASSUMEDPROBABILITY__NAME = "AssumedProbability";
	public static final String EXPOSURETIME__NAME = "ExposureTime";
	public static final String NOTES__NAME = "Notes";
	public static final URI ASSUMEDPROBABILITY__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedProperty.14/@ownedPropertyType/@ownedField.0");
	public static final URI EXPOSURETIME__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedProperty.14/@ownedPropertyType/@ownedField.1");
	public static final URI NOTES__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedProperty.14/@ownedPropertyType/@ownedField.2");
	
	private final OptionalDouble assumedprobability;
	private final Optional<IntegerWithUnits<TimeUnits>> exposuretime;
	private final Optional<String> notes;
	
	public Hazardallocation(
			OptionalDouble assumedprobability,
			Optional<IntegerWithUnits<TimeUnits>> exposuretime,
			Optional<String> notes
	) {
		this.assumedprobability = assumedprobability;
		this.exposuretime = exposuretime;
		this.notes = notes;
	}
	
	public Hazardallocation(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		OptionalDouble assumedprobability_local;
		try {
			assumedprobability_local = findFieldValue(recordValue, ASSUMEDPROBABILITY__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((RealLiteral) resolved).getValue();
			}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
		} catch (PropertyNotPresentException e) {
			assumedprobability_local = OptionalDouble.empty();
		}
		this.assumedprobability = assumedprobability_local;
		
		Optional<IntegerWithUnits<TimeUnits>> exposuretime_local;
		try {
			exposuretime_local = findFieldValue(recordValue, EXPOSURETIME__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return new IntegerWithUnits<>(resolved, TimeUnits.class);
			});
		} catch (PropertyNotPresentException e) {
			exposuretime_local = Optional.empty();
		}
		this.exposuretime = exposuretime_local;
		
		Optional<String> notes_local;
		try {
			notes_local = findFieldValue(recordValue, NOTES__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			notes_local = Optional.empty();
		}
		this.notes = notes_local;
	}
	
	public OptionalDouble getAssumedprobability() {
		return assumedprobability;
	}
	
	public Optional<IntegerWithUnits<TimeUnits>> getExposuretime() {
		return exposuretime;
	}
	
	public Optional<String> getNotes() {
		return notes;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!assumedprobability.isPresent()
				&& !exposuretime.isPresent()
				&& !notes.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		assumedprobability.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, ASSUMEDPROBABILITY__URI, ASSUMEDPROBABILITY__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		exposuretime.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, EXPOSURETIME__URI, EXPOSURETIME__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		notes.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, NOTES__URI, NOTES__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				assumedprobability,
				exposuretime,
				notes
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Hazardallocation)) {
			return false;
		}
		Hazardallocation other = (Hazardallocation) obj;
		return Objects.equals(this.assumedprobability, other.assumedprobability)
				&& Objects.equals(this.exposuretime, other.exposuretime)
				&& Objects.equals(this.notes, other.notes);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.assumedprobability.ifPresent(field -> {
			builder.append(ASSUMEDPROBABILITY__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.exposuretime.ifPresent(field -> {
			builder.append(EXPOSURETIME__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.notes.ifPresent(field -> {
			builder.append(NOTES__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		builder.append(']');
		return builder.toString();
	}
}
