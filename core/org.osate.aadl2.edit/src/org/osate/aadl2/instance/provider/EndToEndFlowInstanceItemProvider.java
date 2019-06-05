/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 *
 * $Id: EndToEndFlowInstanceItemProvider.java,v 1.4 2010-05-12 20:09:31 lwrage Exp $
 */
package org.osate.aadl2.instance.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	@Override
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
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EndToEndFlowInstance")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * Manually added to show the flow elements in an EndToEndFlowInstance.
	 */
	@Override
	public Collection<?> getChildren(Object object) {
		EndToEndFlowInstance etef = (EndToEndFlowInstance) object;
		Stream<EndToEndFlowInstanceFlowElementItemProvider> flowElements = etef.getFlowElements().stream()
				.map(flowElement -> new EndToEndFlowInstanceFlowElementItemProvider(adapterFactory, etef, flowElement));
		return Stream.concat(flowElements, super.getChildren(object).stream()).collect(Collectors.toList());
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

		@Override
		public Collection<?> getChildren(Object object) {
			return Collections.emptyList();
		}

		@Override
		public Object getParent(Object object) {
			return target;
		}

		@Override
		public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain, Object sibling) {
			return Collections.emptyList();
		}

		@Override
		public String getText(Object object) {
			return ((IItemLabelProvider) adapterFactory.adapt(flowElement, IItemLabelProvider.class))
					.getText(flowElement);
		}

		@Override
		public Object getImage(Object object) {
			return ((IItemLabelProvider) adapterFactory.adapt(flowElement, IItemLabelProvider.class))
					.getImage(flowElement);
		}
	}
}
