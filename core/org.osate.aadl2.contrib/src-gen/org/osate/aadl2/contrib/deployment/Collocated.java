package org.osate.aadl2.contrib.deployment;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;

public class Collocated extends GeneratedRecord {
	public static final String TARGETS__NAME = "Targets";
	public static final String LOCATION__NAME = "Location";
	public static final URI TARGETS__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.19/@ownedPropertyType/@ownedField.0");
	public static final URI LOCATION__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.19/@ownedPropertyType/@ownedField.1");
	
	private final Optional<List<InstanceObject>> targets;
	private final Optional<Classifier> location;
	
	public Collocated(
			Optional<List<InstanceObject>> targets,
			Optional<Classifier> location
	) {
		this.targets = targets;
		this.location = location;
	}
	
	public Collocated(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<List<InstanceObject>> targets_local;
		try {
			targets_local = findFieldValue(recordValue, TARGETS__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
					PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
					return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
				}).collect(Collectors.toList());
			});
		} catch (PropertyNotPresentException e) {
			targets_local = Optional.empty();
		}
		this.targets = targets_local;
		
		Optional<Classifier> location_local;
		try {
			location_local = findFieldValue(recordValue, LOCATION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((ClassifierValue) resolved).getClassifier();
			});
		} catch (PropertyNotPresentException e) {
			location_local = Optional.empty();
		}
		this.location = location_local;
	}
	
	public Optional<List<InstanceObject>> getTargets() {
		return targets;
	}
	
	public Optional<Classifier> getLocation() {
		return location;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!targets.isPresent()
				&& !location.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		targets.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, TARGETS__URI, TARGETS__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
				return CodeGenUtil.toPropertyExpression(element1);
			}));
		});
		location.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, LOCATION__URI, LOCATION__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				targets,
				location
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Collocated)) {
			return false;
		}
		Collocated other = (Collocated) obj;
		return Objects.equals(this.targets, other.targets)
				&& Objects.equals(this.location, other.location);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.targets.ifPresent(field -> {
			builder.append(TARGETS__NAME);
			builder.append(" => ");
			builder.append(field.stream().map(element1 -> {
				return "reference (" + element1.getName() + ")";
			}).collect(Collectors.joining(", ", "(", ")")));
			builder.append(';');
		});
		this.location.ifPresent(field -> {
			builder.append(LOCATION__NAME);
			builder.append(" => classifier (");
			builder.append(field.getQualifiedName());
			builder.append(");");
		});
		builder.append(']');
		return builder.toString();
	}
}
