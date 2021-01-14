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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Property;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.Property} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertyItemProvider extends BasicPropertyItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyItemProvider(AdapterFactory adapterFactory) {
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

			addInheritPropertyDescriptor(object);
			addAppliesToMetaclassPropertyDescriptor(object);
			addAppliesToClassifierPropertyDescriptor(object);
			addEmptyListDefaultPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Inherit feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInheritPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Property_inherit_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Property_inherit_feature",
								"_UI_Property_type"),
						Aadl2Package.eINSTANCE.getProperty_Inherit(), true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Applies To Metaclass feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAppliesToMetaclassPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Property_appliesToMetaclass_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Property_appliesToMetaclass_feature",
								"_UI_Property_type"),
						Aadl2Package.eINSTANCE.getProperty_AppliesToMetaclass(), true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Applies To Classifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAppliesToClassifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Property_appliesToClassifier_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Property_appliesToClassifier_feature",
								"_UI_Property_type"),
						Aadl2Package.eINSTANCE.getProperty_AppliesToClassifier(), true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Empty List Default feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEmptyListDefaultPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Property_emptyListDefault_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Property_emptyListDefault_feature",
								"_UI_Property_type"),
						Aadl2Package.eINSTANCE.getProperty_EmptyListDefault(), true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(Aadl2Package.eINSTANCE.getProperty_DefaultValue());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getProperty_AppliesTo());
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
	 * This returns Property.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Property"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Property) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Property_type")
				: getString("_UI_Property_type") + " " + label;
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

		switch (notification.getFeatureID(Property.class)) {
		case Aadl2Package.PROPERTY__INHERIT:
		case Aadl2Package.PROPERTY__EMPTY_LIST_DEFAULT:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case Aadl2Package.PROPERTY__DEFAULT_VALUE:
		case Aadl2Package.PROPERTY__APPLIES_TO:
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

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_DefaultValue(),
				Aadl2Factory.eINSTANCE.createStringLiteral()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_DefaultValue(),
				Aadl2Factory.eINSTANCE.createClassifierValue()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_DefaultValue(),
				Aadl2Factory.eINSTANCE.createReferenceValue()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_DefaultValue(),
				Aadl2Factory.eINSTANCE.createBooleanLiteral()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_DefaultValue(),
				Aadl2Factory.eINSTANCE.createRangeValue()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_DefaultValue(),
				Aadl2Factory.eINSTANCE.createIntegerLiteral()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_DefaultValue(),
				Aadl2Factory.eINSTANCE.createRealLiteral()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_DefaultValue(),
				Aadl2Factory.eINSTANCE.createOperation()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_DefaultValue(),
				Aadl2Factory.eINSTANCE.createRecordValue()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_DefaultValue(),
				Aadl2Factory.eINSTANCE.createComputedValue()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_DefaultValue(),
				Aadl2Factory.eINSTANCE.createListValue()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_DefaultValue(),
				Aadl2Factory.eINSTANCE.createNamedValue()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_AppliesTo(),
				Aadl2Factory.eINSTANCE.createMetaclassReference()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getProperty_AppliesTo(),
				Aadl2Factory.eINSTANCE.createClassifierValue()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == Aadl2Package.eINSTANCE.getProperty_DefaultValue()
				|| childFeature == Aadl2Package.eINSTANCE.getProperty_AppliesTo();

		if (qualify) {
			return getString("_UI_CreateChild_text2",
					new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
