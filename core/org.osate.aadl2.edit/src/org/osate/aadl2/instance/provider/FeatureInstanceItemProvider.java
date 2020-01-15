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
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemInstance;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.instance.FeatureInstance} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureInstanceItemProvider extends ConnectionInstanceEndItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureInstanceItemProvider(AdapterFactory adapterFactory) {
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

			addSrcFlowSpecPropertyDescriptor(object);
			addDstFlowSpecPropertyDescriptor(object);
			addCategoryPropertyDescriptor(object);
			addDirectionPropertyDescriptor(object);
			addFeaturePropertyDescriptor(object);
			addIndexPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Src Flow Spec feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSrcFlowSpecPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_FeatureInstance_srcFlowSpec_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_FeatureInstance_srcFlowSpec_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_FeatureInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.FEATURE_INSTANCE__SRC_FLOW_SPEC, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Dst Flow Spec feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDstFlowSpecPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_FeatureInstance_dstFlowSpec_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_FeatureInstance_dstFlowSpec_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_FeatureInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.FEATURE_INSTANCE__DST_FLOW_SPEC, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Category feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCategoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_FeatureInstance_category_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_FeatureInstance_category_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_FeatureInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.FEATURE_INSTANCE__CATEGORY, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Direction feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDirectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_FeatureInstance_direction_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_FeatureInstance_direction_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_FeatureInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.FEATURE_INSTANCE__DIRECTION, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_FeatureInstance_feature_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_FeatureInstance_feature_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_FeatureInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.FEATURE_INSTANCE__FEATURE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Index feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIndexPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_FeatureInstance_index_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_FeatureInstance_index_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_FeatureInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.FEATURE_INSTANCE__INDEX, true, false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(InstancePackage.Literals.FEATURE_INSTANCE__FEATURE_INSTANCE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns FeatureInstance.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {

		FeatureCategory cat = ((FeatureInstance) object).getCategory();
		String name = "FeatureInstance";
		if (cat != null) {
			name = cat.getLiteral();
			int idx = name.indexOf(" ");
			if (idx < 0) {
				name = name.substring(0, 1).toUpperCase() + name.substring(1) + ".gif";
			} else {
				name = name.substring(0, 1).toUpperCase() + name.substring(1, idx).toLowerCase()
						+ name.substring(idx + 1, idx + 2).toUpperCase() + name.substring(idx + 2).toLowerCase()
						+ ".gif";
			}
		}
		if (object instanceof SystemInstance) {
			name = "System";
		}
		return overlayImage(object, getResourceLocator().getImage("full/obj16/" + name)); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		FeatureInstance fi = (FeatureInstance) object;
		String label = fi.getFullName();
		String ftype = fi.getCategory().getName();
		return (ftype == null || ftype.length() == 0 ? getString("_UI_FeatureInstance_type") : ftype) //$NON-NLS-1$
				+ (label == null || label.length() == 0 ? "" : " " + label);
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

		switch (notification.getFeatureID(FeatureInstance.class)) {
		case InstancePackage.FEATURE_INSTANCE__CATEGORY:
		case InstancePackage.FEATURE_INSTANCE__DIRECTION:
		case InstancePackage.FEATURE_INSTANCE__INDEX:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case InstancePackage.FEATURE_INSTANCE__FEATURE_INSTANCE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

}
