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
package org.osate.aadl2.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.SystemImplementation;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.SystemImplementation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemImplementationItemProvider extends ComponentImplementationItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemImplementationItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedBusSubcomponent());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedDataSubcomponent());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedDeviceSubcomponent());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedMemorySubcomponent());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedProcessSubcomponent());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedProcessorSubcomponent());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedSubprogramSubcomponent());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedSubprogramGroupSubcomponent());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedSystemSubcomponent());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedVirtualBusSubcomponent());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedVirtualProcessorSubcomponent());
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
	 * This returns SystemImplementation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SystemImplementation"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SystemImplementation) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_SystemImplementation_type")
				: getString("_UI_SystemImplementation_type") + " " + label;
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

		switch (notification.getFeatureID(SystemImplementation.class)) {
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT:
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT:
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT:
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT:
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
		case Aadl2Package.SYSTEM_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
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
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedBusSubcomponent(),
						Aadl2Factory.eINSTANCE.createBusSubcomponent()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedDataSubcomponent(),
						Aadl2Factory.eINSTANCE.createDataSubcomponent()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedDeviceSubcomponent(),
						Aadl2Factory.eINSTANCE.createDeviceSubcomponent()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedMemorySubcomponent(),
						Aadl2Factory.eINSTANCE.createMemorySubcomponent()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedProcessSubcomponent(),
						Aadl2Factory.eINSTANCE.createProcessSubcomponent()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedProcessorSubcomponent(),
						Aadl2Factory.eINSTANCE.createProcessorSubcomponent()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedSubprogramSubcomponent(),
						Aadl2Factory.eINSTANCE.createSubprogramSubcomponent()));

		newChildDescriptors.add(
				createChildParameter(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedSubprogramGroupSubcomponent(),
						Aadl2Factory.eINSTANCE.createSubprogramGroupSubcomponent()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedSystemSubcomponent(),
						Aadl2Factory.eINSTANCE.createSystemSubcomponent()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedVirtualBusSubcomponent(),
						Aadl2Factory.eINSTANCE.createVirtualBusSubcomponent()));

		newChildDescriptors.add(
				createChildParameter(Aadl2Package.eINSTANCE.getSystemImplementation_OwnedVirtualProcessorSubcomponent(),
						Aadl2Factory.eINSTANCE.createVirtualProcessorSubcomponent()));
	}

}
