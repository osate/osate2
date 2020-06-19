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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.InstancePackage;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.instance.EndToEndFlowInstance} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EndToEndFlowInstanceItemProvider extends FlowElementInstanceItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndToEndFlowInstanceItemProvider(AdapterFactory adapterFactory) {
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

			addFlowElementPropertyDescriptor(object);
			addInModePropertyDescriptor(object);
			addInSystemOperationModePropertyDescriptor(object);
			addEndToEndFlowPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Flow Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFlowElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_EndToEndFlowInstance_flowElement_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_EndToEndFlowInstance_flowElement_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_EndToEndFlowInstance_type"), //$NON-NLS-1$
				InstancePackage.Literals.END_TO_END_FLOW_INSTANCE__FLOW_ELEMENT, true, false, true, null, null, null));
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
				getString("_UI_EndToEndFlowInstance_inMode_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_EndToEndFlowInstance_inMode_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_EndToEndFlowInstance_type"), //$NON-NLS-1$
				InstancePackage.Literals.END_TO_END_FLOW_INSTANCE__IN_MODE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the In System Operation Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInSystemOperationModePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_EndToEndFlowInstance_inSystemOperationMode_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
						"_UI_EndToEndFlowInstance_inSystemOperationMode_feature", "_UI_EndToEndFlowInstance_type"), //$NON-NLS-1$ //$NON-NLS-2$
				InstancePackage.Literals.END_TO_END_FLOW_INSTANCE__IN_SYSTEM_OPERATION_MODE, true, false, true, null,
				null, null));
	}

	/**
	 * This adds a property descriptor for the End To End Flow feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndToEndFlowPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_EndToEndFlowInstance_endToEndFlow_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_EndToEndFlowInstance_endToEndFlow_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_EndToEndFlowInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.END_TO_END_FLOW_INSTANCE__END_TO_END_FLOW, true, false, true, null,
						null, null));
	}

	/**
	 * This returns EndToEndFlowInstance.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EndToEndFlowInstance")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((EndToEndFlowInstance) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_EndToEndFlowInstance_type") : //$NON-NLS-1$
				getString("_UI_EndToEndFlowInstance_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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
		super.notifyChanged(notification);
	}

	/**
	 * Manually added to show the flow elements in an EndToEndFlowInstance.
	 */
	public Collection<?> getChildren(Object object) {
		EndToEndFlowInstance etef = (EndToEndFlowInstance) object;
		List<Object> result = new ArrayList<Object>();
		for (FlowElementInstance flowElement : etef.getFlowElements()) {
			result.add(new EndToEndFlowInstanceFlowElementItemProvider(adapterFactory, etef, flowElement));
		}
		result.addAll(super.getChildren(object));
		return result;
	}

	public static class EndToEndFlowInstanceFlowElementItemProvider extends ItemProviderAdapter
			implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
			IItemLabelProvider, IItemPropertySource {
		private final FlowElementInstance flowElement;

		private EndToEndFlowInstanceFlowElementItemProvider(AdapterFactory adapterFactory, EndToEndFlowInstance etef,
				FlowElementInstance flowElement) {
			super(adapterFactory);
			this.flowElement = flowElement;
			etef.eAdapters().add(this);
		}

		public FlowElementInstance getFlowElement() {
			return flowElement;
		}
		public Collection<?> getChildren(Object object) {
			return Collections.emptyList();
		}
		public Object getParent(Object object) {
			return target;
		}
		public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain, Object sibling) {
			return Collections.emptyList();
		}
		public String getText(Object object) {
			return ((IItemLabelProvider) adapterFactory.adapt(flowElement, IItemLabelProvider.class))
					.getText(flowElement);
		}
		public Object getImage(Object object) {
			return ((IItemLabelProvider) adapterFactory.adapt(flowElement, IItemLabelProvider.class))
					.getImage(flowElement);
		}
	}
}
