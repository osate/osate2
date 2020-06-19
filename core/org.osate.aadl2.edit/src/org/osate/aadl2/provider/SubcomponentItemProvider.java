/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
import org.osate.aadl2.Subcomponent;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.Subcomponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SubcomponentItemProvider extends StructuralFeatureItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubcomponentItemProvider(AdapterFactory adapterFactory) {
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

			addInModePropertyDescriptor(object);
			addSubcomponentTypePropertyDescriptor(object);
			addPrototypePropertyDescriptor(object);
			addAllModesPropertyDescriptor(object);
			addRefinedPropertyDescriptor(object);
			addClassifierPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the In Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInModePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ModalElement_inMode_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_ModalElement_inMode_feature",
								"_UI_ModalElement_type"),
						Aadl2Package.eINSTANCE.getModalElement_InMode(), true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Subcomponent Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubcomponentTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Subcomponent_subcomponentType_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Subcomponent_subcomponentType_feature",
								"_UI_Subcomponent_type"),
						Aadl2Package.eINSTANCE.getSubcomponent_SubcomponentType(), false, false, false, null, null,
						null));
	}

	/**
	 * This adds a property descriptor for the Classifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Subcomponent_classifier_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Subcomponent_classifier_feature",
								"_UI_Subcomponent_type"),
						Aadl2Package.eINSTANCE.getSubcomponent_Classifier(), false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Prototype feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrototypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Subcomponent_prototype_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Subcomponent_prototype_feature",
								"_UI_Subcomponent_type"),
						Aadl2Package.eINSTANCE.getSubcomponent_Prototype(), false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the All Modes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllModesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Subcomponent_allModes_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Subcomponent_allModes_feature",
								"_UI_Subcomponent_type"),
						Aadl2Package.eINSTANCE.getSubcomponent_AllModes(), true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Refined feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefinedPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Subcomponent_refined_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Subcomponent_refined_feature",
								"_UI_Subcomponent_type"),
						Aadl2Package.eINSTANCE.getSubcomponent_Refined(), true, false, true, null, null, null));
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
			childrenFeatures.add(Aadl2Package.eINSTANCE.getArrayableElement_ArrayDimension());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSubcomponent_OwnedPrototypeBinding());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSubcomponent_OwnedModeBinding());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSubcomponent_ImplementationReference());
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Subcomponent) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Subcomponent_type")
				: getString("_UI_Subcomponent_type") + " " + label;
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

		switch (notification.getFeatureID(Subcomponent.class)) {
		case Aadl2Package.SUBCOMPONENT__ALL_MODES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case Aadl2Package.SUBCOMPONENT__ARRAY_DIMENSION:
		case Aadl2Package.SUBCOMPONENT__OWNED_PROTOTYPE_BINDING:
		case Aadl2Package.SUBCOMPONENT__OWNED_MODE_BINDING:
		case Aadl2Package.SUBCOMPONENT__IMPLEMENTATION_REFERENCE:
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

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getArrayableElement_ArrayDimension(),
				Aadl2Factory.eINSTANCE.createArrayDimension()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getSubcomponent_OwnedPrototypeBinding(),
				Aadl2Factory.eINSTANCE.createComponentPrototypeBinding()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getSubcomponent_OwnedPrototypeBinding(),
				Aadl2Factory.eINSTANCE.createFeatureGroupPrototypeBinding()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getSubcomponent_OwnedPrototypeBinding(),
				Aadl2Factory.eINSTANCE.createFeaturePrototypeBinding()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getSubcomponent_OwnedModeBinding(),
				Aadl2Factory.eINSTANCE.createModeBinding()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getSubcomponent_ImplementationReference(),
				Aadl2Factory.eINSTANCE.createComponentImplementationReference()));
	}

}
