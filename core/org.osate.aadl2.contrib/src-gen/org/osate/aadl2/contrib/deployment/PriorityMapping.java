package org.osate.aadl2.contrib.deployment;

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
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;

public class PriorityMapping extends GeneratedRecord {
	public static final String AADL_PRIORITY__NAME = "Aadl_Priority";
	public static final String RTOS_PRIORITY__NAME = "RTOS_Priority";
	public static final URI AADL_PRIORITY__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedPropertyType.0/@ownedField.0");
	public static final URI RTOS_PRIORITY__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedPropertyType.0/@ownedField.1");
	
	private final OptionalLong aadlPriority;
	private final OptionalLong rtosPriority;
	
	public PriorityMapping(
			OptionalLong aadlPriority,
			OptionalLong rtosPriority
	) {
		this.aadlPriority = aadlPriority;
		this.rtosPriority = rtosPriority;
	}
	
	public PriorityMapping(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		OptionalLong aadlPriority_local;
		try {
			aadlPriority_local = findFieldValue(recordValue, AADL_PRIORITY__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((IntegerLiteral) resolved).getValue();
			}).map(OptionalLong::of).orElse(OptionalLong.empty());
		} catch (PropertyNotPresentException e) {
			aadlPriority_local = OptionalLong.empty();
		}
		this.aadlPriority = aadlPriority_local;
		
		OptionalLong rtosPriority_local;
		try {
			rtosPriority_local = findFieldValue(recordValue, RTOS_PRIORITY__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((IntegerLiteral) resolved).getValue();
			}).map(OptionalLong::of).orElse(OptionalLong.empty());
		} catch (PropertyNotPresentException e) {
			rtosPriority_local = OptionalLong.empty();
		}
		this.rtosPriority = rtosPriority_local;
	}
	
	public OptionalLong getAadlPriority() {
		return aadlPriority;
	}
	
	public OptionalLong getRtosPriority() {
		return rtosPriority;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!aadlPriority.isPresent()
				&& !rtosPriority.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		aadlPriority.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, AADL_PRIORITY__URI, AADL_PRIORITY__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		rtosPriority.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, RTOS_PRIORITY__URI, RTOS_PRIORITY__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				aadlPriority,
				rtosPriority
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PriorityMapping)) {
			return false;
		}
		PriorityMapping other = (PriorityMapping) obj;
		return Objects.equals(this.aadlPriority, other.aadlPriority)
				&& Objects.equals(this.rtosPriority, other.rtosPriority);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.aadlPriority.ifPresent(field -> {
			builder.append(AADL_PRIORITY__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.rtosPriority.ifPresent(field -> {
			builder.append(RTOS_PRIORITY__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
}
