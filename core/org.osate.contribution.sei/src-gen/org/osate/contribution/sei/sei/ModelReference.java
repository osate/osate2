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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party
 * beneficiaries to this license with respect to the terms applicable to their Third Party Software. Third Party
 * Software licenses only apply to the Third Party Software and not any other portion of this program or this program
 * as a whole.
 *******************************************************************************/
package org.osate.contribution.sei.sei;

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
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;

/**
 * @since 1.2
 */
public class ModelReference extends GeneratedRecord {
	public static final String MODEL_TYPE__NAME = "Model_Type";
	public static final String KIND__NAME = "Kind";
	public static final String FILENAME__NAME = "Filename";
	public static final String ARTIFACT__NAME = "Artifact";
	public static final URI MODEL_TYPE__URI = URI.createURI("platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.8/@ownedField.0");
	public static final URI KIND__URI = URI.createURI("platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.8/@ownedField.1");
	public static final URI FILENAME__URI = URI.createURI("platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.8/@ownedField.2");
	public static final URI ARTIFACT__URI = URI.createURI("platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.8/@ownedField.3");

	private final Optional<ModelSourceType> modelType;
	private final Optional<ReferenceKindType> kind;
	private final Optional<String> filename;
	private final Optional<String> artifact;

	public ModelReference(
			Optional<ModelSourceType> modelType,
			Optional<ReferenceKindType> kind,
			Optional<String> filename,
			Optional<String> artifact
	) {
		this.modelType = modelType;
		this.kind = kind;
		this.filename = filename;
		this.artifact = artifact;
	}

	public ModelReference(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;

		Optional<ModelSourceType> modelType_local;
		try {
			modelType_local = findFieldValue(recordValue, MODEL_TYPE__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ModelSourceType.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			modelType_local = Optional.empty();
		}
		this.modelType = modelType_local;

		Optional<ReferenceKindType> kind_local;
		try {
			kind_local = findFieldValue(recordValue, KIND__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ReferenceKindType.valueOf(resolved);
			});
		} catch (PropertyNotPresentException e) {
			kind_local = Optional.empty();
		}
		this.kind = kind_local;

		Optional<String> filename_local;
		try {
			filename_local = findFieldValue(recordValue, FILENAME__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			filename_local = Optional.empty();
		}
		this.filename = filename_local;

		Optional<String> artifact_local;
		try {
			artifact_local = findFieldValue(recordValue, ARTIFACT__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((StringLiteral) resolved).getValue();
			});
		} catch (PropertyNotPresentException e) {
			artifact_local = Optional.empty();
		}
		this.artifact = artifact_local;
	}

	public Optional<ModelSourceType> getModelType() {
		return modelType;
	}

	public Optional<ReferenceKindType> getKind() {
		return kind;
	}

	public Optional<String> getFilename() {
		return filename;
	}

	public Optional<String> getArtifact() {
		return artifact;
	}

	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!modelType.isPresent()
				&& !kind.isPresent()
				&& !filename.isPresent()
				&& !artifact.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		modelType.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, MODEL_TYPE__URI, MODEL_TYPE__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		kind.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, KIND__URI, KIND__NAME));
			fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
		});
		filename.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, FILENAME__URI, FILENAME__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		artifact.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, ARTIFACT__URI, ARTIFACT__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		return recordValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				modelType,
				kind,
				filename,
				artifact
		);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ModelReference)) {
			return false;
		}
		ModelReference other = (ModelReference) obj;
		return Objects.equals(this.modelType, other.modelType)
				&& Objects.equals(this.kind, other.kind)
				&& Objects.equals(this.filename, other.filename)
				&& Objects.equals(this.artifact, other.artifact);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.modelType.ifPresent(field -> {
			builder.append(MODEL_TYPE__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.kind.ifPresent(field -> {
			builder.append(KIND__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		this.filename.ifPresent(field -> {
			builder.append(FILENAME__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.artifact.ifPresent(field -> {
			builder.append(ARTIFACT__NAME);
			builder.append(" => \"");
			builder.append(field);
			builder.append("\";");
		});
		builder.append(']');
		return builder.toString();
	}
}
