/**
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.PropertySet;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.PropertySet} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertySetItemProvider extends NamespaceItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertySetItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addImportedUnitPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Imported Unit feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImportedUnitPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_PropertySet_importedUnit_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_PropertySet_importedUnit_feature",
								"_UI_PropertySet_type"),
						Aadl2Package.eINSTANCE.getPropertySet_ImportedUnit(), true, false, true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPropertySet_OwnedProperty());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyConstant());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPropertySet_OwnedAnnexSubclause());
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns PropertySet.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PropertySet"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((PropertySet) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_PropertySet_type")
				: getString("_UI_PropertySet_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(PropertySet.class)) {
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_TYPE:
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY:
		case Aadl2Package.PROPERTY_SET__OWNED_PROPERTY_CONSTANT:
		case Aadl2Package.PROPERTY_SET__OWNED_ANNEX_SUBCLAUSE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyType(),
				Aadl2Factory.eINSTANCE.createAadlBoolean()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyType(),
				Aadl2Factory.eINSTANCE.createAadlString()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyType(),
				Aadl2Factory.eINSTANCE.createAadlInteger()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyType(),
				Aadl2Factory.eINSTANCE.createEnumerationType()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyType(),
				Aadl2Factory.eINSTANCE.createUnitsType()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyType(),
				Aadl2Factory.eINSTANCE.createAadlReal()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyType(),
				Aadl2Factory.eINSTANCE.createClassifierType()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyType(),
				Aadl2Factory.eINSTANCE.createRangeType()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyType(),
				Aadl2Factory.eINSTANCE.createRecordType()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyType(),
				Aadl2Factory.eINSTANCE.createReferenceType()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyType(),
				Aadl2Factory.eINSTANCE.createListType()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedProperty(),
				Aadl2Factory.eINSTANCE.createProperty()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedPropertyConstant(),
				Aadl2Factory.eINSTANCE.createPropertyConstant()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPropertySet_OwnedAnnexSubclause(),
				Aadl2Factory.eINSTANCE.createDefaultAnnexSubclause()));
	}

}
