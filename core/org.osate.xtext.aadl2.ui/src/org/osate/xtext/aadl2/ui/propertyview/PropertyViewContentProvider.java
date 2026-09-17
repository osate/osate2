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

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.modelsupport.util.AadlUtil;

class PropertyViewContentProvider implements ITreeContentProvider {
	private final AadlPropertyView propertyView;

	PropertyViewContentProvider(AadlPropertyView propertyView) {
		this.propertyView = propertyView;
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public boolean hasChildren(Object element) {
		return currentChildCount(element) > 0;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return IntStream.range(0, currentChildCount(parentElement))
				.mapToObj(index -> new TreeEntry(parentElement, getChildElement(parentElement, index)))
				.toArray();
	}

	@Override
	public Object getParent(Object element) {
		return element instanceof TreeEntry entry ? entry.getParent() : null;
	}

	@Override
	public void dispose() {
	}

	void updateChildCount(Object element, int currentChildCount) {
		var childCount = currentChildCount(element);
		if (currentChildCount != childCount) {
			propertyView.treeViewer.setChildCount(element, childCount);
		}
	}

	void updateElement(Object parent, int index) {
		var childElement = new TreeEntry(parent, getChildElement(parent, index));
		propertyView.treeViewer.replace(parent, index, childElement);
		updateChildCount(childElement, -1);
	}

	private int currentChildCount(Object element) {
		return switch (element) {
		/* The input of the viewer: the URI of the element whose properties are shown. */
		case URI uri -> countVisiblePropertySets();
		case TreeEntry entry -> switch (entry.getTreeElement()) {
		case URI treeElement -> childCountOfModelElement(entry, treeElement);
		case ListElement listElement -> childCountOfListElement(listElement);
		/* A range element is a leaf. */
		case null, default -> 0;
		};
		case null, default -> 0;
		};
	}

	private Object getChildElement(Object parent, int index) {
		return switch (parent) {
		case URI uri -> visiblePropertySetURI(index);
		case TreeEntry entry -> switch (entry.getTreeElement()) {
		case URI treeElement -> childOfModelElement(entry, treeElement, index);
		case ListElement listElement -> childOfListElement(listElement, index);
		case null, default -> null;
		};
		case null, default -> null;
		};
	}

	/*
	 * The property sets and the properties within them, filtered by the two toggles of the view. The count and the
	 * elements are derived from the same predicate, so that they cannot disagree.
	 */

	private int countVisiblePropertySets() {
		if (showsEveryProperty()) {
			/* Every cached property set has at least one property that applies to the element, so all of them show. */
			return propertyView.cachedPropertyAssociations.size();
		}
		return propertyView.safeRead(resourceSet -> (int) visiblePropertySets(resourceSet).count());
	}

	private URI visiblePropertySetURI(int index) {
		return propertyView.safeRead(resourceSet -> visiblePropertySets(resourceSet)
				.sorted(Comparator.comparing(propertySetURI -> upperCaseName(resourceSet, propertySetURI)))
				.toList()
				.get(index));
	}

	private Stream<URI> visiblePropertySets(ResourceSet resourceSet) {
		if (showsEveryProperty()) {
			return propertyView.cachedPropertyAssociations.keySet().stream();
		}
		return propertyView.cachedPropertyAssociations.entrySet()
				.stream()
				.filter(propertySet -> hasVisibleProperty(resourceSet, propertySet.getValue()))
				.map(Map.Entry::getKey);
	}

	private int countVisibleProperties(ResourceSet resourceSet, URI propertySetURI) {
		return (int) visibleProperties(resourceSet, propertySetURI).count();
	}

	private URI visiblePropertyURI(ResourceSet resourceSet, URI propertySetURI, int index) {
		return visibleProperties(resourceSet, propertySetURI)
				.sorted(Comparator.comparing(propertyURI -> upperCaseName(resourceSet, propertyURI)))
				.toList()
				.get(index);
	}

	private Stream<URI> visibleProperties(ResourceSet resourceSet, URI propertySetURI) {
		return propertyView.cachedPropertyAssociations.get(propertySetURI)
				.entrySet()
				.stream()
				.filter(property -> isVisible(resourceSet, property.getKey(), property.getValue()))
				.map(Map.Entry::getKey);
	}

	private boolean hasVisibleProperty(ResourceSet resourceSet, Map<URI, URI> propertiesInSet) {
		return propertiesInSet.entrySet()
				.stream()
				.anyMatch(property -> isVisible(resourceSet, property.getKey(), property.getValue()));
	}

	/**
	 * Is the property shown in the view? A property with a property association is always shown. Without one it either
	 * takes its default value or it is undefined, and then it is shown only if the matching toggle is checked.
	 */
	private boolean isVisible(ResourceSet resourceSet, URI propertyURI, URI associationURI) {
		if (associationURI != null || showsEveryProperty()) {
			return true;
		}
		if (!propertyView.showUndefinedAction.isChecked() && !propertyView.showDefaultAction.isChecked()) {
			return false;
		}
		/* Exactly one of the two toggles is checked here. */
		var hasDefaultValue = ((Property) resourceSet.getEObject(propertyURI, true)).getDefaultValue() != null;
		return propertyView.showDefaultAction.isChecked() ? hasDefaultValue : !hasDefaultValue;
	}

	private boolean showsEveryProperty() {
		return propertyView.showUndefinedAction.isChecked() && propertyView.showDefaultAction.isChecked();
	}

	/** Property sets and properties are both sorted by their name, ignoring case. */
	private static String upperCaseName(ResourceSet resourceSet, URI namedElementURI) {
		return ((NamedElement) resourceSet.getEObject(namedElementURI, true)).getName().toUpperCase();
	}

	/*
	 * The children of an entry that stands for a model element: the properties of a property set, or the parts of a
	 * property value.
	 */

	private int childCountOfModelElement(TreeEntry entry, URI treeElement) {
		return propertyView.safeRead(resourceSet -> switch (resourceSet.getEObject(treeElement, true)) {
		case PropertySet propertySet -> countVisibleProperties(resourceSet, treeElement);
		case Property property -> {
			var associationURI = associationURI(entry);
			if (associationURI == null) {
				yield getChildCount(property.getDefaultValue(), property.getPropertyType(), null);
			}
			var association = (PropertyAssociation) resourceSet.getEObject(associationURI, true);
			/* The children of a modal association are its values, one per "in modes" clause. */
			yield association.isModal() ? association.getOwnedValues().size()
					: getChildCount(association.getOwnedValues().getFirst().getOwnedValue(), property.getPropertyType(),
							property.getDefaultValue());
		}
		case ModalPropertyValue modalPropertyValue -> {
			var property = EcoreUtil2.getContainerOfType(modalPropertyValue, PropertyAssociation.class).getProperty();
			yield getChildCount(modalPropertyValue.getOwnedValue(), property.getPropertyType(),
					property.getDefaultValue());
		}
		case BasicPropertyAssociation fieldValue ->
			getChildCount(fieldValue.getValue(), fieldValue.getProperty().getPropertyType(), null);
		case null, default -> 0;
		});
	}

	private Object childOfModelElement(TreeEntry entry, URI treeElement, int index) {
		return propertyView.safeRead(resourceSet -> switch (resourceSet.getEObject(treeElement, true)) {
		case PropertySet propertySet -> visiblePropertyURI(resourceSet, treeElement, index);
		case Property property -> {
			var associationURI = associationURI(entry);
			if (associationURI == null) {
				yield getElement(property.getDefaultValue(), index, property.getPropertyType(), null);
			}
			var association = (PropertyAssociation) resourceSet.getEObject(associationURI, true);
			yield association.isModal() ? EcoreUtil.getURI(association.getOwnedValues().get(index))
					: getElement(association.getOwnedValues().getFirst().getOwnedValue(), index,
							property.getPropertyType(), property.getDefaultValue());
		}
		case ModalPropertyValue modalPropertyValue -> {
			var property = EcoreUtil2.getContainerOfType(modalPropertyValue, PropertyAssociation.class).getProperty();
			yield getElement(modalPropertyValue.getOwnedValue(), index, property.getPropertyType(),
					property.getDefaultValue());
		}
		case BasicPropertyAssociation fieldValue ->
			getElement(fieldValue.getValue(), index, fieldValue.getProperty().getPropertyType(), null);
		case null, default -> null;
		});
	}

	private int childCountOfListElement(ListElement listElement) {
		return propertyView.safeRead(resourceSet -> {
			var expression = (PropertyExpression) resourceSet.getEObject(listElement.getExpressionURI(), true);
			return getChildCount(expression, elementPropertyType(expression), null);
		});
	}

	private Object childOfListElement(ListElement listElement, int index) {
		return propertyView.safeRead(resourceSet -> {
			var expression = (PropertyExpression) resourceSet.getEObject(listElement.getExpressionURI(), true);
			return getElement(expression, index, elementPropertyType(expression), null);
		});
	}

	private URI associationURI(TreeEntry propertyEntry) {
		var propertySetEntry = (TreeEntry) propertyEntry.getParent();
		return propertyView.cachedPropertyAssociations.get(propertySetEntry.getTreeElement())
				.get(propertyEntry.getTreeElement());
	}

	/**
	 * The type of the elements of the list that contains the expression: the base type of the property or record field
	 * that the expression ultimately belongs to.
	 */
	private static PropertyType elementPropertyType(PropertyExpression expression) {
		var fieldValue = EcoreUtil2.getContainerOfType(expression, BasicPropertyAssociation.class);
		BasicProperty property = fieldValue == null ? null : fieldValue.getProperty();
		if (property == null) {
			var association = EcoreUtil2.getContainerOfType(expression, PropertyAssociation.class);
			property = association == null ? null : association.getProperty();
		}
		if (property == null) {
			/* The expression is the default value of the property that contains it. */
			property = EcoreUtil2.getContainerOfType(expression, Property.class);
		}
		return AadlUtil.getBasePropertyType(property.getPropertyType());
	}

	/*
	 * The parts of a property value: the bounds of a range, the fields of a record, or the elements of a list.
	 */

	private int getChildCount(PropertyExpression expression, PropertyType propertyType,
			PropertyExpression defaultValue) {
		return switch (expression) {
		case RangeValue rangeValue -> rangeValue.getDelta() == null ? 2 : 3;
		case RecordValue recordValue when propertyType instanceof RecordType recordType ->
			countVisibleFields(recordValue, recordType, defaultValue);
		case ListValue listValue -> listValue.getOwnedListElements().size();
		case null, default -> 0;
		};
	}

	private Object getElement(PropertyExpression expression, int index, PropertyType propertyType,
			PropertyExpression defaultValue) {
		return switch (expression) {
		case RangeValue rangeValue -> switch (index) {
		case 0 -> new RangeElement(RangeElement.MINIMUM_LABEL, EcoreUtil.getURI(rangeValue.getMinimum()));
		case 1 -> new RangeElement(RangeElement.MAXIMUM_LABEL, EcoreUtil.getURI(rangeValue.getMaximum()));
		case 2 -> new RangeElement(RangeElement.DELTA_LABEL, EcoreUtil.getURI(rangeValue.getDelta()));
		default -> null;
		};
		case RecordValue recordValue ->
			EcoreUtil.getURI(visibleField(recordValue, (RecordType) propertyType, defaultValue, index));
		case ListValue listValue ->
			new ListElement(index, EcoreUtil.getURI(listValue.getOwnedListElements().get(index)));
		case null, default -> null;
		};
	}

	/**
	 * The number of fields of the record value that are shown, which depends on the two toggles of the view in the same
	 * way as the visibility of a property does.
	 */
	private int countVisibleFields(RecordValue value, RecordType recordType, PropertyExpression defaultValue) {
		var fields = recordType.getOwnedFields();
		if (showsEveryProperty()) {
			return fields.size();
		}
		if (propertyView.showUndefinedAction.isChecked()) {
			if (defaultValue instanceof RecordValue defaultRecord) {
				return (int) fields.stream()
						.filter(field -> fieldValue(value, field) != null && fieldValue(defaultRecord, field) == null)
						.count();
			}
			/* Without a record default value no field takes a default value, so every field is either set or undefined. */
			return fields.size();
		}
		if (propertyView.showDefaultAction.isChecked() && defaultValue instanceof RecordValue defaultRecord) {
			return (int) fields.stream()
					.filter(field -> fieldValue(value, field) != null || fieldValue(defaultRecord, field) != null)
					.count();
		}
		return (int) fields.stream().filter(field -> fieldValue(value, field) != null).count();
	}

	/**
	 * The record field shown at the index: the field value of the record value, or the one of the default value, or the
	 * field definition itself, which stands for a field without a value.
	 */
	private EObject visibleField(RecordValue value, RecordType recordType, PropertyExpression defaultValue, int index) {
		var defaultRecord = defaultValue instanceof RecordValue record ? record : null;
		if (propertyView.showUndefinedAction.isChecked()) {
			/* Every field of the type is shown, so the index is the one of the field definition. */
			var fieldInType = recordType.getOwnedFields().get(index);
			var fieldValue = fieldValue(value, fieldInType);
			if (fieldValue != null) {
				return fieldValue;
			}
			var defaultFieldValue = defaultRecord == null ? null : fieldValue(defaultRecord, fieldInType);
			return defaultFieldValue != null ? defaultFieldValue : fieldInType;
		}
		List<BasicPropertyAssociation> shownValues = recordType.getOwnedFields().stream().map(fieldInType -> {
			var fieldValue = fieldValue(value, fieldInType);
			if (fieldValue != null || defaultRecord == null) {
				return fieldValue;
			}
			return fieldValue(defaultRecord, fieldInType);
		}).filter(Objects::nonNull).toList();
		return shownValues.get(index);
	}

	private static BasicPropertyAssociation fieldValue(RecordValue record, BasicProperty fieldInType) {
		return record.getOwnedFieldValues()
				.stream()
				.filter(fieldValue -> fieldValue.getProperty() == fieldInType)
				.findFirst()
				.orElse(null);
	}
}
