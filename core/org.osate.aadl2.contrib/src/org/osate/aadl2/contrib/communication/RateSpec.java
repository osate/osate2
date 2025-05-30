/*******************************************************************************
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file). 
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
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.contrib.aadlproject.SupportedDistributions;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedEnumeration;
import org.osate.pluginsupport.properties.GeneratedRecord;
import org.osate.pluginsupport.properties.RealRange;

public class RateSpec extends GeneratedRecord {
	public static final String VALUE_RANGE__NAME = "Value_Range";
	public static final String RATE_UNIT__NAME = "Rate_Unit";
	public static final String RATE_DISTRIBUTION__NAME = "Rate_Distribution";
	public static final URI VALUE_RANGE__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.3/@ownedField.0");
	public static final URI RATE_UNIT__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.3/@ownedField.1");
	public static final URI RATE_DISTRIBUTION__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.3/@ownedField.2");
	
	private final Optional<RealRange> valueRange;
	private final Optional<RateUnit_FieldType> rateUnit;
	private final Optional<SupportedDistributions> rateDistribution;
	
	public RateSpec(
			Optional<RealRange> valueRange,
			Optional<RateUnit_FieldType> rateUnit,
			Optional<SupportedDistributions> rateDistribution
	) {
		this.valueRange = valueRange;
		this.rateUnit = rateUnit;
		this.rateDistribution = rateDistribution;
	}
	
	public RateSpec(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<RealRange> valueRange_local;
		try {
			valueRange_local = findFieldValue(recordValue, VALUE_RANGE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return new RealRange(resolved, lookupContext, mode);
			});
		} catch (PropertyNotPresentException e) {
			valueRange_local = Optional.empty();
		}
		this.valueRange = valueRange_local;
		
		Optional<RateUnit_FieldType> rateUnit_local;
		try {
			rateUnit_local = findFieldValue(recordValue, RATE_UNIT__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return RateUnit_FieldType.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			rateUnit_local = Optional.empty();
		}
		this.rateUnit = rateUnit_local;
		
		Optional<SupportedDistributions> rateDistribution_local;
		try {
			rateDistribution_local = findFieldValue(recordValue, RATE_DISTRIBUTION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return SupportedDistributions.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			rateDistribution_local = Optional.empty();
		}
		this.rateDistribution = rateDistribution_local;
	}
	
	public RateSpec(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<RealRange> valueRange_local;
		try {
			valueRange_local = findFieldValue(recordValue, VALUE_RANGE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return new RealRange(resolved);
			});
		} catch (PropertyNotPresentException e) {
			valueRange_local = Optional.empty();
		}
		this.valueRange = valueRange_local;
		
		Optional<RateUnit_FieldType> rateUnit_local;
		try {
			rateUnit_local = findFieldValue(recordValue, RATE_UNIT__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return RateUnit_FieldType.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			rateUnit_local = Optional.empty();
		}
		this.rateUnit = rateUnit_local;
		
		Optional<SupportedDistributions> rateDistribution_local;
		try {
			rateDistribution_local = findFieldValue(recordValue, RATE_DISTRIBUTION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return SupportedDistributions.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			rateDistribution_local = Optional.empty();
		}
		this.rateDistribution = rateDistribution_local;
	}
	
	public Optional<RealRange> getValueRange() {
		return valueRange;
	}
	
	public Optional<RateUnit_FieldType> getRateUnit() {
		return rateUnit;
	}
	
	public Optional<SupportedDistributions> getRateDistribution() {
		return rateDistribution;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!valueRange.isPresent()
				&& !rateUnit.isPresent()
				&& !rateDistribution.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		valueRange.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, VALUE_RANGE__URI, VALUE_RANGE__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression());
		});
		rateUnit.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, RATE_UNIT__URI, RATE_UNIT__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		rateDistribution.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, RATE_DISTRIBUTION__URI, RATE_DISTRIBUTION__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				valueRange,
				rateUnit,
				rateDistribution
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RateSpec)) {
			return false;
		}
		RateSpec other = (RateSpec) obj;
		return Objects.equals(this.valueRange, other.valueRange)
				&& Objects.equals(this.rateUnit, other.rateUnit)
				&& Objects.equals(this.rateDistribution, other.rateDistribution);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.valueRange.ifPresent(field -> {
			builder.append(VALUE_RANGE__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.rateUnit.ifPresent(field -> {
			builder.append(RATE_UNIT__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.rateDistribution.ifPresent(field -> {
			builder.append(RATE_DISTRIBUTION__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
	
	public enum RateUnit_FieldType implements GeneratedEnumeration {
		PERSECOND("PerSecond", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.3/@ownedField.1/@ownedPropertyType/@ownedLiteral.0"),
		PERDISPATCH("PerDispatch", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.3/@ownedField.1/@ownedPropertyType/@ownedLiteral.1");
		
		private final String originalName;
		private final URI uri;
		
		private RateUnit_FieldType(String originalName, String uri) {
			this.originalName = originalName;
			this.uri = URI.createURI(uri);
		}
		
		public static RateUnit_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public URI getURI() {
			return uri;
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
}
