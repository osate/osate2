/**
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.instance.textual.serializer;

import static org.eclipse.xtext.EcoreUtil2.getContainerOfType;

import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemInstance;

public class InstanceCrossReferenceSerializer extends CrossReferenceSerializer {
	private static final InstancePackage INSTANCE_PACKAGE = InstancePackage.eINSTANCE;
	private static final Aadl2Package AADL2_PACKAGE = Aadl2Package.eINSTANCE;

	@Override
	public String serializeCrossRef(EObject semanticObject, CrossReference crossref, EObject target, INode node,
			Acceptor errors) {
		var reference = GrammarUtil.getReference(crossref, semanticObject.eClass());
		if (INSTANCE_PACKAGE.getSystemInstance_ComponentImplementation().equals(reference)
				|| INSTANCE_PACKAGE.getComponentInstance_Classifier().equals(reference)
				|| AADL2_PACKAGE.getPropertyAssociation_Property().equals(reference)
				|| AADL2_PACKAGE.getClassifierValue_Classifier().equals(reference)) {
			return ((NamedElement) target).getQualifiedName();
		} else if (INSTANCE_PACKAGE.getFeatureInstance_Feature().equals(reference)
				|| INSTANCE_PACKAGE.getComponentInstance_Subcomponent().equals(reference)
				|| INSTANCE_PACKAGE.getConnectionReference_Connection().equals(reference)
				|| INSTANCE_PACKAGE.getFlowSpecificationInstance_FlowSpecification().equals(reference)
				|| INSTANCE_PACKAGE.getEndToEndFlowInstance_EndToEndFlow().equals(reference)
				|| INSTANCE_PACKAGE.getModeInstance_Mode().equals(reference)
				|| AADL2_PACKAGE.getContainmentPathElement_NamedElement().equals(reference)) {
			return getContainerOfType(target, Classifier.class).getQualifiedName() + ':'
					+ ((NamedElement) target).getName();
		} else if (INSTANCE_PACKAGE.getComponentInstance_InMode().equals(reference)
				|| INSTANCE_PACKAGE.getConnectionInstance_InSystemOperationMode().equals(reference)
				|| INSTANCE_PACKAGE.getFlowSpecificationInstance_InMode().equals(reference)
				|| INSTANCE_PACKAGE.getEndToEndFlowInstance_InSystemOperationMode().equals(reference)
				|| INSTANCE_PACKAGE.getModeInstance_Parent().equals(reference)
				|| INSTANCE_PACKAGE.getModeTransitionInstance_Source().equals(reference)
				|| INSTANCE_PACKAGE.getModeTransitionInstance_Destination().equals(reference)
				|| AADL2_PACKAGE.getNumberValue_Unit().equals(reference)
				|| AADL2_PACKAGE.getBasicPropertyAssociation_Property().equals(reference)
				|| AADL2_PACKAGE.getModalElement_InMode().equals(reference)) {
			return ((NamedElement) target).getName();
		} else if (INSTANCE_PACKAGE.getConnectionInstance_Source().equals(reference)
				|| INSTANCE_PACKAGE.getConnectionInstance_Destination().equals(reference)
				|| INSTANCE_PACKAGE.getConnectionReference_Source().equals(reference)
				|| INSTANCE_PACKAGE.getConnectionReference_Destination().equals(reference)
				|| INSTANCE_PACKAGE.getFlowSpecificationInstance_Source().equals(reference)
				|| INSTANCE_PACKAGE.getFlowSpecificationInstance_Destination().equals(reference)
				|| INSTANCE_PACKAGE.getEndToEndFlowInstance_FlowElement().equals(reference)
				|| INSTANCE_PACKAGE.getSystemOperationMode_CurrentMode().equals(reference)
				|| INSTANCE_PACKAGE.getModeTransitionInstance_Trigger().equals(reference)) {
			return serializeChainedInstanceReference(target,
					getContainerOfType(semanticObject, ComponentInstance.class));
		} else if (INSTANCE_PACKAGE.getConnectionInstance_InModeTransition().equals(reference)
				|| INSTANCE_PACKAGE.getFlowSpecificationInstance_InModeTransition().equals(reference)) {
			return "transition#"
					+ getContainerOfType(target, ComponentInstance.class).getModeTransitionInstances().indexOf(target);
		} else if (INSTANCE_PACKAGE.getConnectionReference_Context().equals(reference)) {
			var rootComponent = getContainerOfType(semanticObject, ComponentInstance.class);
			if (rootComponent.equals(target)) {
				return "parent";
			} else {
				return serializeChainedInstanceReference(target, rootComponent);
			}
		} else if (INSTANCE_PACKAGE.getModeTransitionInstance_ModeTransition().equals(reference)) {
			var classifier = getContainerOfType(target, ComponentClassifier.class);
			var transition = (ModeTransition) target;
			var transitionName = transition.getName();
			if (transitionName == null) {
				transitionName = "transition#" + classifier.getOwnedModeTransitions().indexOf(transition);
			}
			return classifier.getQualifiedName() + ':' + transitionName;
		} else if (INSTANCE_PACKAGE.getPropertyAssociationInstance_PropertyAssociation().equals(reference)) {
			var classifier = getContainerOfType(target, Classifier.class);
			var builder = new StringBuilder(classifier.getQualifiedName());
			builder.append(':');
			if (target.eContainer().equals(classifier)) {
				builder.append("property#");
				builder.append(classifier.getOwnedPropertyAssociations().indexOf(target));
			} else {
				var parent = (NamedElement) target.eContainer();
				if (parent instanceof ModeTransition && parent.getName() == null) {
					builder.append("transition#");
					builder.append(((ComponentClassifier) classifier).getOwnedModeTransitions().indexOf(parent));
				} else {
					builder.append(parent.getName());
				}
				builder.append(":property#");
				builder.append(parent.getOwnedPropertyAssociations().indexOf(target));
			}
			return builder.toString();
		} else if (INSTANCE_PACKAGE.getInstanceReferenceValue_ReferencedInstanceObject().equals(reference)) {
			return serializeChainedInstanceReference(target, getContainerOfType(semanticObject, SystemInstance.class));
		} else if (AADL2_PACKAGE.getNamedValue_NamedValue().equals(reference)) {
			if (target instanceof EnumerationLiteral enumLiteral) {
				return enumLiteral.getName();
			} else if (target instanceof Property property) {
				return property.getQualifiedName();
			} else if (target instanceof PropertyConstant constant) {
				return constant.getQualifiedName();
			} else {
				throw new RuntimeException("Unexpected target: " + target);
			}
		} else {
			return super.serializeCrossRef(semanticObject, crossref, target, node, errors);
		}
	}

	private static String serializeChainedInstanceReference(EObject target, ComponentInstance rootComponent) {
		var result = new StringBuilder(serializeChainSegment(target));
		var currentContainer = target.eContainer();
		while (currentContainer != rootComponent) {
			result.insert(0, ".");
			result.insert(0, serializeChainSegment(currentContainer));
			currentContainer = currentContainer.eContainer();
		}
		return result.toString();
	}

	private static String serializeChainSegment(EObject segment) {
		if (segment instanceof ComponentInstance component) {
			return component.getName()
					+ component.getIndices().stream().map(index -> "[" + index + ']').collect(Collectors.joining());
		} else if (segment instanceof FeatureInstance feature) {
			if (feature.getIndex() == 0) {
				return feature.getName();
			} else {
				return feature.getName() + '[' + feature.getIndex() + ']';
			}
		} else if (segment instanceof ConnectionInstance connection) {
			return "connection#" + getContainerOfType(connection, ComponentInstance.class).getConnectionInstances()
					.indexOf(connection);
		} else if (segment instanceof InstanceObject instanceObject) {
			return instanceObject.getName();
		} else {
			throw new RuntimeException("Unexpected segment: " + segment);
		}
	}
}
