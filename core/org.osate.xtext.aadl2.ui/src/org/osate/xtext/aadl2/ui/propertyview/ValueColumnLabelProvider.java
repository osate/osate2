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
package org.osate.xtext.aadl2.ui.propertyview;

import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator.InvalidConcreteSyntaxException;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Element;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.instance.InstanceReferenceValue;

public class ValueColumnLabelProvider extends ColumnLabelProvider {
	private final AadlPropertyView propertyView;

	ValueColumnLabelProvider(AadlPropertyView propertyView) {
		this.propertyView = propertyView;
	}

	@Override
	public String getText(Object element) {
		return propertyView.safeRead(resourceSet -> {
			/*
			 * The Xtend compiler evaluated this whole switch twice because of the trailing null-safe call, discarding
			 * the second result. It is resolved once here.
			 */
			var expression = resolveExpression(resourceSet, (TreeEntry) element);
			return expression == null ? null : getValueAsString(expression, propertyView.serializer);
		});
	}

	@Override
	public Color getForeground(Object element) {
		if (propertyView.canEdit(element)) {
			return null;
		}
		return propertyView.getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY);
	}

	private PropertyExpression resolveExpression(ResourceSet resourceSet, TreeEntry entry) {
		return switch (entry.getTreeElement()) {
		case URI uri -> switch (resourceSet.getEObject(uri, true)) {
			case Property property -> {
				var parentEntry = (TreeEntry) entry.getParent();
				var associationURI = propertyView.cachedPropertyAssociations.get(parentEntry.getTreeElement()).get(uri);
				if (associationURI == null) {
					yield property.getDefaultValue();
				}
				var association = (PropertyAssociation) resourceSet.getEObject(associationURI, true);
				/* A modal association has no single value to show in the table. */
				yield association.isModal() ? null : association.getOwnedValues().getFirst().getOwnedValue();
			}
			case ModalPropertyValue modalPropertyValue -> modalPropertyValue.getOwnedValue();
			case BasicPropertyAssociation basicPropertyAssociation -> basicPropertyAssociation.getValue();
			case null, default -> null;
		};
		case RangeElement rangeElement ->
			(PropertyExpression) resourceSet.getEObject(rangeElement.getExpressionURI(), true);
		case ListElement listElement ->
			(PropertyExpression) resourceSet.getEObject(listElement.getExpressionURI(), true);
		case null, default -> null;
		};
	}

	public static String getValueAsString(Element expression, ISerializer serializer) {
		try {
			var unformatted = switch (expression) {
			case InstanceReferenceValue instanceReferenceValue -> instanceObjectPath(instanceReferenceValue);
			case ListValue listValue when hasInstanceReferenceValue(listValue) ->
				serializeListWithInstanceReferenceValue(listValue, serializer);
			case null, default -> serializeSingleLine(expression, serializer);
			};
			return unformatted.replace("( ", "(")
					.replace(" )", ")")
					.replace("[ ", "[")
					.replace(" ]", "]")
					.replace(" ,", ",")
					.replace(" ;", ";");
		} catch (InvalidConcreteSyntaxException e) {
			// Simply return null. Expression could not be serialized because the model is invalid.
			return null;
		} catch (RuntimeException e) {
			/*
			 * See https://github.com/osate/osate2/issues/1243
			 *
			 * I don't know why the serializer throws a RuntimeException instead of an InvalidConcreteSyntaxException in
			 * this case. Does the serializer throw RuntimeException in some cases and InvalidConcreteSyntaxException in
			 * others? Could it be that the serializer used to throw InvalidConcreteSyntaxException, but now it throws
			 * RuntimeException?
			 */
			return null;
		}
	}

	private static boolean hasInstanceReferenceValue(ListValue topList) {
		return topList.getOwnedListElements()
				.stream()
				.anyMatch(listElement -> listElement instanceof InstanceReferenceValue
						|| listElement instanceof ListValue nested && hasInstanceReferenceValue(nested));
	}

	/**
	 * The serializer cannot render an instance reference value, so the list is assembled by hand. Nested lists are
	 * always rendered this way, whether or not they contain an instance reference themselves.
	 */
	private static String serializeListWithInstanceReferenceValue(ListValue topList, ISerializer serializer) {
		return topList.getOwnedListElements().stream().map(listElement -> switch (listElement) {
		case InstanceReferenceValue instanceReferenceValue -> instanceObjectPath(instanceReferenceValue);
		case ListValue nested -> serializeListWithInstanceReferenceValue(nested, serializer);
		default -> serializeSingleLine(listElement, serializer);
		}).collect(Collectors.joining(", ", "(", ")"));
	}

	private static String instanceObjectPath(InstanceReferenceValue instanceReferenceValue) {
		var referenced = instanceReferenceValue.getReferencedInstanceObject();
		var path = referenced == null ? null : referenced.getInstanceObjectPath();
		return path == null ? "null" : path;
	}

	private static String serializeSingleLine(EObject expression, ISerializer serializer) {
		return serializer.serialize(expression)
				.replaceAll("\n", "")
				.replaceAll("\r", "")
				.replaceAll("\t", "")
				.trim();
	}
}
