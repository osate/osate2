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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.provider.Aadl2EditPlugin;
import org.osate.aadl2.provider.ModeItemProvider;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.instance.SystemOperationMode} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemOperationModeItemProvider extends ModeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemOperationModeItemProvider(AdapterFactory adapterFactory) {
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

			addCurrentModePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Current Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCurrentModePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_SystemOperationMode_currentMode_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_SystemOperationMode_currentMode_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_SystemOperationMode_type"), //$NON-NLS-1$
				InstancePackage.Literals.SYSTEM_OPERATION_MODE__CURRENT_MODE, true, false, true, null, null, null));
	}

	/**
	 * This returns SystemOperationMode.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SystemOperationMode")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SystemOperationMode) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_SystemOperationMode_type") : //$NON-NLS-1$
				getString("_UI_SystemOperationMode_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return Aadl2EditPlugin.INSTANCE;
	}

	/**
	 * Manually added to show the individual modes of a SystemOperationMode.
	 */
	public Collection<?> getChildren(Object object) {
		SystemOperationMode som = (SystemOperationMode) object;
		List<SubModeItemProvider> result = new ArrayList<SubModeItemProvider>();
		for (ModeInstance subMode : som.getCurrentModes()) {
			result.add(new SubModeItemProvider(adapterFactory, som, subMode));
		}
		return result;
	}

	public static class SubModeItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
			IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
		private final ModeInstance subMode;

		private SubModeItemProvider(AdapterFactory adapterFactory, SystemOperationMode som, ModeInstance subMode) {
			super(adapterFactory);
			this.subMode = subMode;
			som.eAdapters().add(this);
		}

		public ModeInstance getSubMode() {
			return subMode;
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
			String label = subMode.getComponentInstancePath();
			return label == null || label.length() == 0 ? "Mode" : "Mode " + label;
		}

		public Object getImage(Object object) {
			return ((IItemLabelProvider) adapterFactory.adapt(subMode, IItemLabelProvider.class)).getImage(subMode);
		}
	}
}
