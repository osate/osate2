/*******************************************************************************
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.contribution.sei.arinc653;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;
import org.osate.pluginsupport.properties.IntegerWithUnits;

public class ScheduleWindow extends GeneratedRecord {
	public static final String PARTITION__NAME = "Partition";
	public static final String DURATION__NAME = "Duration";
	public static final String PERIODIC_PROCESSING_START__NAME = "Periodic_Processing_Start";
	public static final URI PARTITION__URI = URI.createURI("platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.8/@ownedField.0");
	public static final URI DURATION__URI = URI.createURI("platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.8/@ownedField.1");
	public static final URI PERIODIC_PROCESSING_START__URI = URI.createURI("platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.8/@ownedField.2");
	
	private final Optional<InstanceObject> partition;
	private final Optional<IntegerWithUnits<TimeUnits>> duration;
	private final Optional<Boolean> periodicProcessingStart;
	
	public ScheduleWindow(
			Optional<InstanceObject> partition,
			Optional<IntegerWithUnits<TimeUnits>> duration,
			Optional<Boolean> periodicProcessingStart
	) {
		this.partition = partition;
		this.duration = duration;
		this.periodicProcessingStart = periodicProcessingStart;
	}
	
	public ScheduleWindow(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<InstanceObject> partition_local;
		try {
			partition_local = findFieldValue(recordValue, PARTITION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
			});
		} catch (PropertyNotPresentException e) {
			partition_local = Optional.empty();
		}
		this.partition = partition_local;
		
		Optional<IntegerWithUnits<TimeUnits>> duration_local;
		try {
			duration_local = findFieldValue(recordValue, DURATION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return new IntegerWithUnits<>(resolved, TimeUnits.class);
			});
		} catch (PropertyNotPresentException e) {
			duration_local = Optional.empty();
		}
		this.duration = duration_local;
		
		Optional<Boolean> periodicProcessingStart_local;
		try {
			periodicProcessingStart_local = findFieldValue(recordValue, PERIODIC_PROCESSING_START__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((BooleanLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			periodicProcessingStart_local = Optional.empty();
		}
		this.periodicProcessingStart = periodicProcessingStart_local;
	}
	
	public ScheduleWindow(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<InstanceObject> partition_local;
		try {
			partition_local = findFieldValue(recordValue, PARTITION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return ((InstanceReferenceValue) resolved).getReferencedInstanceObject();
			});
		} catch (PropertyNotPresentException e) {
			partition_local = Optional.empty();
		}
		this.partition = partition_local;
		
		Optional<IntegerWithUnits<TimeUnits>> duration_local;
		try {
			duration_local = findFieldValue(recordValue, DURATION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return new IntegerWithUnits<>(resolved, TimeUnits.class);
			});
		} catch (PropertyNotPresentException e) {
			duration_local = Optional.empty();
		}
		this.duration = duration_local;
		
		Optional<Boolean> periodicProcessingStart_local;
		try {
			periodicProcessingStart_local = findFieldValue(recordValue, PERIODIC_PROCESSING_START__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return ((BooleanLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			periodicProcessingStart_local = Optional.empty();
		}
		this.periodicProcessingStart = periodicProcessingStart_local;
	}
	
	public Optional<InstanceObject> getPartition() {
		return partition;
	}
	
	public Optional<IntegerWithUnits<TimeUnits>> getDuration() {
		return duration;
	}
	
	public Optional<Boolean> getPeriodicProcessingStart() {
		return periodicProcessingStart;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!partition.isPresent()
				&& !duration.isPresent()
				&& !periodicProcessingStart.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		partition.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, PARTITION__URI, PARTITION__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		duration.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, DURATION__URI, DURATION__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		periodicProcessingStart.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, PERIODIC_PROCESSING_START__URI, PERIODIC_PROCESSING_START__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				partition,
				duration,
				periodicProcessingStart
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ScheduleWindow)) {
			return false;
		}
		ScheduleWindow other = (ScheduleWindow) obj;
		return Objects.equals(this.partition, other.partition)
				&& Objects.equals(this.duration, other.duration)
				&& Objects.equals(this.periodicProcessingStart, other.periodicProcessingStart);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.partition.ifPresent(field -> {
			builder.append(PARTITION__NAME);
			builder.append(" => reference (");
			builder.append(field.getName());
			builder.append(");");
		});
		this.duration.ifPresent(field -> {
			builder.append(DURATION__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.periodicProcessingStart.ifPresent(field -> {
			builder.append(PERIODIC_PROCESSING_START__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
}
