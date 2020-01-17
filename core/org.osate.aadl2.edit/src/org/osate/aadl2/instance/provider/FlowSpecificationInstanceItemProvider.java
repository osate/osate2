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

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstancePackage;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.instance.FlowSpecificationInstance} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowSpecificationInstanceItemProvider extends FlowElementInstanceItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSpecificationInstanceItemProvider(AdapterFactory adapterFactory) {
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

			addSourcePropertyDescriptor(object);
			addDestinationPropertyDescriptor(object);
			addFlowSpecificationPropertyDescriptor(object);
			addInModePropertyDescriptor(object);
			addInModeTransitionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_FlowSpecificationInstance_source_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_FlowSpecificationInstance_source_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_FlowSpecificationInstance_type"), //$NON-NLS-1$
				InstancePackage.Literals.FLOW_SPECIFICATION_INSTANCE__SOURCE, true, false, true, null, null, null));
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
				getString("_UI_FlowSpecificationInstance_destination_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_FlowSpecificationInstance_destination_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_FlowSpecificationInstance_type"), //$NON-NLS-1$
				InstancePackage.Literals.FLOW_SPECIFICATION_INSTANCE__DESTINATION, true, false, true, null, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Flow Specification feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFlowSpecificationPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_FlowSpecificationInstance_flowSpecification_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
								"_UI_FlowSpecificationInstance_flowSpecification_feature", //$NON-NLS-1$
								"_UI_FlowSpecificationInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.FLOW_SPECIFICATION_INSTANCE__FLOW_SPECIFICATION, true, false, true,
						null, null, null));
	}

	/**
	 * This adds a property descriptor for the In Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInModePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_FlowSpecificationInstance_inMode_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_FlowSpecificationInstance_inMode_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_FlowSpecificationInstance_type"), //$NON-NLS-1$
				InstancePackage.Literals.FLOW_SPECIFICATION_INSTANCE__IN_MODE, true, false, true, null, null, null));
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
				getString("_UI_FlowSpecificationInstance_inModeTransition_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
						"_UI_FlowSpecificationInstance_inModeTransition_feature", "_UI_FlowSpecificationInstance_type"), //$NON-NLS-1$ //$NON-NLS-2$
				InstancePackage.Literals.FLOW_SPECIFICATION_INSTANCE__IN_MODE_TRANSITION, true, false, true, null, null,
				null));
	}

	/**
	 * This returns FlowSpecificationInstance.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FlowSpecificationInstance")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		FlowSpecificationInstance flowInstance = (FlowSpecificationInstance) object;

		StringBuilder result = new StringBuilder(getString("_UI_FlowSpecificationInstance_type"));

		FlowSpecification declarativeFlow = flowInstance.getFlowSpecification();
		if (declarativeFlow != null && !declarativeFlow.eIsProxy()) {
			result.append(' ');
			result.append(StringExtensions.toFirstUpper(declarativeFlow.getKind().getName()));
		}

		String flowName = flowInstance.getName();
		if (flowName != null && !flowName.isEmpty()) {
			result.append(' ');
			result.append(flowName);
		}

		return result.toString();
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
		super.notifyChanged(notification);
	}

}
