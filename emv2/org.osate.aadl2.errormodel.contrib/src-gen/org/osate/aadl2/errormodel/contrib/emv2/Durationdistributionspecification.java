package org.osate.aadl2.errormodel.contrib.emv2;

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

public class Durationdistributionspecification extends GeneratedRecord {
	public static final String DURATION__NAME = "Duration";
	public static final String DISTRIBUTION__NAME = "Distribution";
	public static final URI DURATION__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.2/@ownedField.0");
	public static final URI DISTRIBUTION__URI = URI.createURI("platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.2/@ownedField.1");
	
	private final Optional<IntegerRangeWithUnits<TimeUnits>> duration;
	private final Optional<Distributionfunction> distribution;
	
	public Durationdistributionspecification(
			Optional<IntegerRangeWithUnits<TimeUnits>> duration,
			Optional<Distributionfunction> distribution
	) {
		this.duration = duration;
		this.distribution = distribution;
	}
	
	public Durationdistributionspecification(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<IntegerRangeWithUnits<TimeUnits>> duration_local;
		try {
			duration_local = findFieldValue(recordValue, DURATION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode);
			});
		} catch (PropertyNotPresentException e) {
			duration_local = Optional.empty();
		}
		this.duration = duration_local;
		
		Optional<Distributionfunction> distribution_local;
		try {
			distribution_local = findFieldValue(recordValue, DISTRIBUTION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return Distributionfunction.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			distribution_local = Optional.empty();
		}
		this.distribution = distribution_local;
	}
	
	public Optional<IntegerRangeWithUnits<TimeUnits>> getDuration() {
		return duration;
	}
	
	public Optional<Distributionfunction> getDistribution() {
		return distribution;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!duration.isPresent()
				&& !distribution.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		duration.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, DURATION__URI, DURATION__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		distribution.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, DISTRIBUTION__URI, DISTRIBUTION__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				duration,
				distribution
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Durationdistributionspecification)) {
			return false;
		}
		Durationdistributionspecification other = (Durationdistributionspecification) obj;
		return Objects.equals(this.duration, other.duration)
				&& Objects.equals(this.distribution, other.distribution);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.duration.ifPresent(field -> {
			builder.append(DURATION__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.distribution.ifPresent(field -> {
			builder.append(DISTRIBUTION__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
}
