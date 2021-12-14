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
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;

public class HmErrorIdActionType extends GeneratedRecord {
	public static final String ERRORIDENTIFIER__NAME = "ErrorIdentifier";
	public static final String DESCRIPTION__NAME = "Description";
	public static final String ACTION__NAME = "Action";
	public static final URI ERRORIDENTIFIER__URI = URI.createURI("platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.5/@ownedField.0");
	public static final URI DESCRIPTION__URI = URI.createURI("platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.5/@ownedField.1");
	public static final URI ACTION__URI = URI.createURI("platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.5/@ownedField.2");
	
	private final OptionalLong erroridentifier;
	private final Optional<String> description;
	private final Optional<String> action;
	
	public HmErrorIdActionType(
			OptionalLong erroridentifier,
			Optional<String> description,
			Optional<String> action
	) {
		this.erroridentifier = erroridentifier;
		this.description = description;
		this.action = action;
	}
	
	public HmErrorIdActionType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		OptionalLong erroridentifier_local;
		try {
			erroridentifier_local = findFieldValue(recordValue, ERRORIDENTIFIER__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((IntegerLiteral) resolved).getValue();
			}).map(OptionalLong::of).orElse(OptionalLong.empty());
		} catch (PropertyNotPresentException e) {
			erroridentifier_local = OptionalLong.empty();
		}
		this.erroridentifier = erroridentifier_local;
		
		Optional<String> description_local;
		try {
			description_local = findFieldValue(recordValue, DESCRIPTION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			description_local = Optional.empty();
		}
		this.description = description_local;
		
		Optional<String> action_local;
		try {
			action_local = findFieldValue(recordValue, ACTION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			action_local = Optional.empty();
		}
		this.action = action_local;
	}
	
	public HmErrorIdActionType(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		
		OptionalLong erroridentifier_local;
		try {
			erroridentifier_local = findFieldValue(recordValue, ERRORIDENTIFIER__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return ((IntegerLiteral) resolved).getValue();
			}).map(OptionalLong::of).orElse(OptionalLong.empty());
		} catch (PropertyNotPresentException e) {
			erroridentifier_local = OptionalLong.empty();
		}
		this.erroridentifier = erroridentifier_local;
		
		Optional<String> description_local;
		try {
			description_local = findFieldValue(recordValue, DESCRIPTION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			description_local = Optional.empty();
		}
		this.description = description_local;
		
		Optional<String> action_local;
		try {
			action_local = findFieldValue(recordValue, ACTION__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			action_local = Optional.empty();
		}
		this.action = action_local;
	}
	
	public OptionalLong getErroridentifier() {
		return erroridentifier;
	}
	
	public Optional<String> getDescription() {
		return description;
	}
	
	public Optional<String> getAction() {
		return action;
	}
	
	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!erroridentifier.isPresent()
				&& !description.isPresent()
				&& !action.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		erroridentifier.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, ERRORIDENTIFIER__URI, ERRORIDENTIFIER__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		description.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, DESCRIPTION__URI, DESCRIPTION__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		action.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, ACTION__URI, ACTION__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		return recordValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				erroridentifier,
				description,
				action
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof HmErrorIdActionType)) {
			return false;
		}
		HmErrorIdActionType other = (HmErrorIdActionType) obj;
		return Objects.equals(this.erroridentifier, other.erroridentifier)
				&& Objects.equals(this.description, other.description)
				&& Objects.equals(this.action, other.action);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.erroridentifier.ifPresent(field -> {
			builder.append(ERRORIDENTIFIER__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.description.ifPresent(field -> {
			builder.append(DESCRIPTION__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.action.ifPresent(field -> {
			builder.append(ACTION__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		builder.append(']');
		return builder.toString();
	}
}
