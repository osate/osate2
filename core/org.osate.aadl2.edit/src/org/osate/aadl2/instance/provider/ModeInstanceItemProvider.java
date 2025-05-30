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
package org.osate.aadl2.instance.provider;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeInstance;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.instance.ModeInstance} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ModeInstanceItemProvider extends InstanceObjectItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeInstanceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSrcModeTransitionPropertyDescriptor(object);
			addDstModeTransitionPropertyDescriptor(object);
			addInitialPropertyDescriptor(object);
			addModePropertyDescriptor(object);
			addDerivedPropertyDescriptor(object);
			addParentPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Src Mode Transition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSrcModeTransitionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ModeInstance_srcModeTransition_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_ModeInstance_srcModeTransition_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_ModeInstance_type"), //$NON-NLS-1$
				InstancePackage.Literals.MODE_INSTANCE__SRC_MODE_TRANSITION, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Dst Mode Transition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDstModeTransitionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ModeInstance_dstModeTransition_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_ModeInstance_dstModeTransition_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_ModeInstance_type"), //$NON-NLS-1$
				InstancePackage.Literals.MODE_INSTANCE__DST_MODE_TRANSITION, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Initial feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ModeInstance_initial_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_ModeInstance_initial_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_ModeInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.MODE_INSTANCE__INITIAL, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ModeInstance_mode_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_ModeInstance_mode_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_ModeInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.MODE_INSTANCE__MODE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Derived feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDerivedPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ModeInstance_derived_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_ModeInstance_derived_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_ModeInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.MODE_INSTANCE__DERIVED, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Parent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ModeInstance_parent_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_ModeInstance_parent_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_ModeInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.MODE_INSTANCE__PARENT, true, false, true, null, null, null));
	}

	/**
	 * This returns ModeInstance.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ModeInstance")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ModeInstance) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_ModeInstance_type") : //$NON-NLS-1$
				getString("_UI_ModeInstance_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ModeInstance.class)) {
		case InstancePackage.MODE_INSTANCE__INITIAL:
		case InstancePackage.MODE_INSTANCE__DERIVED:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

}
