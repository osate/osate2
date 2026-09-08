/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.properties.ui.contentassist;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.ClassifierType;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.ListType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;

import com.google.common.base.Predicate;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class PropertiesProposalProvider extends AbstractPropertiesProposalProvider {
	/*
	 * The filters are declared as com.google.common.base.Predicate because lookupCrossReference is overloaded for a
	 * Guava Predicate and a Guava Function, so an inline lambda would be ambiguous.
	 */

	@Override
	public void completeOptionalModalPropertyValue_InMode(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		Predicate<IEObjectDescription> unusedMode = description -> {
			var proposedObj = EcoreUtil.resolve(description.getEObjectOrProxy(), model);
			var propertyAssoc = (PropertyAssociation) model.eContainer();
			/* Do not propose a mode that one of the sibling values already uses. */
			return propertyAssoc.getOwnedValues()
					.stream()
					.flatMap(ownedValue -> ownedValue.getInModes().stream())
					.noneMatch(mode -> Objects.equals(mode, proposedObj));
		};
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, unusedMode);
	}

	@Override
	public void completeLiteralorReferenceTerm_NamedValue(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		Predicate<IEObjectDescription> visible = description -> showCrossReference(description, model);
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, visible);
	}

	@Override
	public void completeConstantValue_NamedValue(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Predicate<IEObjectDescription> visible = description -> showCrossReference(description, model);
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, visible);
	}

	@Override
	public void completeComponentClassifierTerm_Classifier(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		var propertyType = AadlUtil.getBasePropertyType(getPropertyType((ClassifierValue) model));
		Predicate<IEObjectDescription> allowedClassifier = description -> {
			var proposedObj = EcoreUtil.resolve(description.getEObjectOrProxy(), model);
			if (!(propertyType instanceof ClassifierType classifierType)) {
				return false;
			}
			var classifierReferences = classifierType.getClassifierReferences();
			/* Without any metaclass reference every classifier is acceptable. */
			return classifierReferences == null || classifierReferences.isEmpty()
					|| classifierReferences.stream()
							.anyMatch(reference -> reference.getMetaclass().isSuperTypeOf(proposedObj.eClass()));
		};
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, allowedClassifier);
	}

	@Override
	public void completeFieldPropertyAssociation_Property(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		Predicate<IEObjectDescription> unusedField = description -> {
			var proposedObj = EcoreUtil.resolve(description.getEObjectOrProxy(), model);
			if (model instanceof RecordValue recordValue) {
				/* Do not propose a record field that already has a value. */
				return recordValue.getOwnedFieldValues()
						.stream()
						.noneMatch(fieldValue -> Objects.equals(fieldValue.getProperty(), proposedObj));
			}
			return true;
		};
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, unusedField);
	}

	private boolean showCrossReference(IEObjectDescription objDesc, EObject model) {
		PropertyType expectedPropertyType = switch (model) {
		case PropertyAssociation propertyAssociation -> propertyAssociation.getProperty().getPropertyType();
		case BasicPropertyAssociation basicPropertyAssociation -> basicPropertyAssociation.getProperty()
				.getPropertyType();
		case Property property -> property.getPropertyType();
		case PropertyConstant propertyConstant -> propertyConstant.getPropertyType();
		case ListValue listValue -> getListElementType(listValue);
		case null, default -> null;
		};

		var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
		return switch (proposedObj) {
		case EnumerationLiteral enumerationLiteral -> true;
		case PropertyConstant propertyConstant ->
			Aadl2Util.arePropertyTypesEqual(expectedPropertyType, propertyConstant.getPropertyType())
					&& switch (model) {
					case PropertyConstant modelConstant -> !Objects.equals(modelConstant, proposedObj);
					case null, default -> true;
					};
		case Property property -> Aadl2Util.arePropertyTypesEqual(expectedPropertyType, property.getPropertyType())
				&& switch (model) {
				case PropertyAssociation propertyAssociation ->
					!Objects.equals(propertyAssociation.getProperty(), proposedObj);
				case Property modelProperty -> !Objects.equals(modelProperty, proposedObj);
				case null, default -> true;
				};
		case null, default -> false;
		};
	}

	private PropertyType getListElementType(ListValue listValue) {
		return getListElementType(listValue, 0);
	}

	private PropertyType getListElementType(EObject model, int listCount) {
		return switch (model) {
		case ListValue listValue -> getListElementType(listValue.eContainer(), listCount + 1);
		case PropertyAssociation propertyAssociation -> getNestedElementType(
				(ListType) propertyAssociation.getProperty().getPropertyType(), listCount);
		case BasicPropertyAssociation basicPropertyAssociation -> getNestedElementType(
				(ListType) basicPropertyAssociation.getProperty().getPropertyType(), listCount);
		case Property property -> getNestedElementType((ListType) property.getPropertyType(), listCount);
		case PropertyConstant propertyConstant -> getNestedElementType((ListType) propertyConstant.getPropertyType(),
				listCount);
		case null, default -> getListElementType(model.eContainer(), listCount);
		};
	}

	private PropertyType getNestedElementType(ListType listType, int n) {
		if (n == 1) {
			return listType.getElementType();
		}
		return getNestedElementType((ListType) listType.getElementType(), n - 1);
	}

	/**
	 * Finds the property type that constrains the given classifier value, looking at the closest enclosing property
	 * association, property or property constant in turn.
	 */
	private PropertyType getPropertyType(ClassifierValue model) {
		var basicPropertyAssociation = EcoreUtil2.getContainerOfType(model, BasicPropertyAssociation.class);
		var propertyType = basicPropertyAssociation == null ? null
				: propertyTypeOf(basicPropertyAssociation.getProperty());
		if (propertyType != null) {
			return propertyType;
		}

		var propertyAssociation = EcoreUtil2.getContainerOfType(model, PropertyAssociation.class);
		propertyType = propertyAssociation == null ? null : propertyTypeOf(propertyAssociation.getProperty());
		if (propertyType != null) {
			return propertyType;
		}

		var property = EcoreUtil2.getContainerOfType(model, Property.class);
		propertyType = property == null ? null : property.getPropertyType();
		if (propertyType != null) {
			return propertyType;
		}

		/* The original chain ends without a null check, so a classifier value outside any of these fails here. */
		return EcoreUtil2.getContainerOfType(model, PropertyConstant.class).getPropertyType();
	}

	private static PropertyType propertyTypeOf(BasicProperty property) {
		return property == null ? null : property.getPropertyType();
	}
}
