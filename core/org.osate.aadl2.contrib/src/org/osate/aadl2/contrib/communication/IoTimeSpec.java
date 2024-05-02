/*******************************************************************************
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.aadl2.contrib.communication;

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

public class IoTimeSpec extends GeneratedRecord {
	public static final String OFFSET__NAME = "Offset";
	public static final String TIME__NAME = "Time";
	public static final URI OFFSET__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.1/@ownedField.0");
	public static final URI TIME__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.1/@ownedField.1");
	
	private final Optional<IntegerRangeWithUnits<TimeUnits>> offset;
	private final Optional<IoReferenceTime> time;
	
	public IoTimeSpec(
			Optional<IntegerRangeWithUnits<TimeUnits>> offset,
			Optional<IoReferenceTime> time
	) {
		this.offset = offset;
		this.time = time;
	}
	
	public IoTimeSpec(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<IntegerRangeWithUnits<TimeUnits>> offset_local;
		try {
			offset_local = findFieldValue(recordValue, OFFSET__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return new IntegerRangeWithUnits<>(resolved, TimeUnits.class, lookupContext, mode);
			});
		} catch (PropertyNotPresentException e) {
			offset_local = Optional.empty();
		}
		this.offset = offset_local;
		
		Optional<IoReferenceTime> time_local;
		try {
			time_local = findFieldValue(recordValue, TIME__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return IoReferenceTime.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			time_local = Optional.empty();
		}
		this.time = time_local;
	}
	
	public IoTimeSpec(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<IntegerRangeWithUnits<TimeUnits>> offset_local;
		try {
			offset_local = findFieldValue(recordValue, OFFSET__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return new IntegerRangeWithUnits<>(resolved, TimeUnits.class);
			});
		} catch (PropertyNotPresentException e) {
			offset_local = Optional.empty();
		}
		this.offset = offset_local;
		
		Optional<IoReferenceTime> time_local;
		try {
			time_local = findFieldValue(recordValue, TIME__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return IoReferenceTime.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			time_local = Optional.empty();
		}
		this.time = time_local;
	}
	
	public Optional<IntegerRangeWithUnits<TimeUnits>> getOffset() {
		return offset;
	}
	
	public Optional<IoReferenceTime> getTime() {
		return time;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!offset.isPresent()
				&& !time.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		offset.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, OFFSET__URI, OFFSET__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		time.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, TIME__URI, TIME__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				offset,
				time
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof IoTimeSpec)) {
			return false;
		}
		IoTimeSpec other = (IoTimeSpec) obj;
		return Objects.equals(this.offset, other.offset)
				&& Objects.equals(this.time, other.time);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.offset.ifPresent(field -> {
			builder.append(OFFSET__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.time.ifPresent(field -> {
			builder.append(TIME__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
}
