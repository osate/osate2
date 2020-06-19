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
package org.osate.aadl2.instance.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstancePackage;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.instance.ConnectionInstance} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnectionInstanceItemProvider extends FlowElementInstanceItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInstanceItemProvider(AdapterFactory adapterFactory) {
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

			addInSystemOperationModePropertyDescriptor(object);
			addInModeTransitionPropertyDescriptor(object);
			addCompletePropertyDescriptor(object);
			addKindPropertyDescriptor(object);
			addDestinationPropertyDescriptor(object);
			addBidirectionalPropertyDescriptor(object);
			addSourcePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the In System Operation Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInSystemOperationModePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ConnectionInstance_inSystemOperationMode_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_ConnectionInstance_inSystemOperationMode_feature", "_UI_ConnectionInstance_type"), //$NON-NLS-1$ //$NON-NLS-2$
						InstancePackage.Literals.CONNECTION_INSTANCE__IN_SYSTEM_OPERATION_MODE, true, false, true, null,
						null, null));
	}

	/**
	 * This adds a property descriptor for the In Mode Transition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInModeTransitionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ConnectionInstance_inModeTransition_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_ConnectionInstance_inModeTransition_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_ConnectionInstance_type"), //$NON-NLS-1$
				InstancePackage.Literals.CONNECTION_INSTANCE__IN_MODE_TRANSITION, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Complete feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCompletePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ConnectionInstance_complete_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_ConnectionInstance_complete_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_ConnectionInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.CONNECTION_INSTANCE__COMPLETE, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Kind feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKindPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ConnectionInstance_kind_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_ConnectionInstance_kind_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_ConnectionInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.CONNECTION_INSTANCE__KIND, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Destination feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDestinationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ConnectionInstance_destination_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_ConnectionInstance_destination_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_ConnectionInstance_type"), //$NON-NLS-1$
				InstancePackage.Literals.CONNECTION_INSTANCE__DESTINATION, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Bidirectional feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBidirectionalPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ConnectionInstance_bidirectional_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_ConnectionInstance_bidirectional_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_ConnectionInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.CONNECTION_INSTANCE__BIDIRECTIONAL, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ConnectionInstance_source_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_ConnectionInstance_source_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_ConnectionInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.CONNECTION_INSTANCE__SOURCE, true, false, true, null, null, null));
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
			childrenFeatures.add(InstancePackage.Literals.CONNECTION_INSTANCE__CONNECTION_REFERENCE);
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
	 * This returns ConnectionInstance.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ConnectionInstance")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((ConnectionInstance) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_ConnectionInstance_type") : //$NON-NLS-1$
				getString("_UI_ConnectionInstance_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(ConnectionInstance.class)) {
		case InstancePackage.CONNECTION_INSTANCE__COMPLETE:
		case InstancePackage.CONNECTION_INSTANCE__KIND:
		case InstancePackage.CONNECTION_INSTANCE__BIDIRECTIONAL:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case InstancePackage.CONNECTION_INSTANCE__CONNECTION_REFERENCE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

}
