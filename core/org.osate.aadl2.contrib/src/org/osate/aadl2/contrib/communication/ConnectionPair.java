/*******************************************************************************
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file). 
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

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;

public class ConnectionPair extends GeneratedRecord {
	public static final String SRC__NAME = "src";
	public static final String DST__NAME = "dst";
	public static final URI SRC__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.0/@ownedField.0");
	public static final URI DST__URI = URI.createURI("platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.0/@ownedField.1");
	
	private final Optional<List<Long>> src;
	private final Optional<List<Long>> dst;
	
	public ConnectionPair(
			Optional<List<Long>> src,
			Optional<List<Long>> dst
	) {
		this.src = src;
		this.dst = dst;
	}
	
	public ConnectionPair(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<List<Long>> src_local;
		try {
			src_local = findFieldValue(recordValue, SRC__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
					PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
					return ((IntegerLiteral) resolved1).getValue();
				}).collect(Collectors.toList());
			});
		} catch (PropertyNotPresentException e) {
			src_local = Optional.empty();
		}
		this.src = src_local;
		
		Optional<List<Long>> dst_local;
		try {
			dst_local = findFieldValue(recordValue, DST__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
					PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
					return ((IntegerLiteral) resolved1).getValue();
				}).collect(Collectors.toList());
			});
		} catch (PropertyNotPresentException e) {
			dst_local = Optional.empty();
		}
		this.dst = dst_local;
	}
	
	public ConnectionPair(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		Optional<List<Long>> src_local;
		try {
			src_local = findFieldValue(recordValue, SRC__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
					PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
					return ((IntegerLiteral) resolved1).getValue();
				}).collect(Collectors.toList());
			});
		} catch (PropertyNotPresentException e) {
			src_local = Optional.empty();
		}
		this.src = src_local;
		
		Optional<List<Long>> dst_local;
		try {
			dst_local = findFieldValue(recordValue, DST__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
					PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
					return ((IntegerLiteral) resolved1).getValue();
				}).collect(Collectors.toList());
			});
		} catch (PropertyNotPresentException e) {
			dst_local = Optional.empty();
		}
		this.dst = dst_local;
	}
	
	public Optional<List<Long>> getSrc() {
		return src;
	}
	
	public Optional<List<Long>> getDst() {
		return dst;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!src.isPresent()
				&& !dst.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		src.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, SRC__URI, SRC__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
				return CodeGenUtil.toPropertyExpression(element1);
			}));
		});
		dst.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, DST__URI, DST__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
				return CodeGenUtil.toPropertyExpression(element1);
			}));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				src,
				dst
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ConnectionPair)) {
			return false;
		}
		ConnectionPair other = (ConnectionPair) obj;
		return Objects.equals(this.src, other.src)
				&& Objects.equals(this.dst, other.dst);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.src.ifPresent(field -> {
			builder.append(SRC__NAME);
			builder.append(" => ");
			builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
			builder.append(';');
		});
		this.dst.ifPresent(field -> {
			builder.append(DST__NAME);
			builder.append(" => ");
			builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
}
