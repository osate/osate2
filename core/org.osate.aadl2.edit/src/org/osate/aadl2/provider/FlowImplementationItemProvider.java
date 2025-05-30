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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.impl.FlowImplementationImpl;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.FlowImplementation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowImplementationItemProvider extends ModalPathItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowImplementationItemProvider(AdapterFactory adapterFactory) {
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

			addFeaturingClassifierPropertyDescriptor(object);
			addKindPropertyDescriptor(object);
			addSpecificationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Featuring Classifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeaturingClassifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ClassifierFeature_featuringClassifier_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_ClassifierFeature_featuringClassifier_feature", "_UI_ClassifierFeature_type"),
						Aadl2Package.eINSTANCE.getClassifierFeature_FeaturingClassifier(), false, false, false, null,
						null, null));
	}

	/**
	 * This adds a property descriptor for the Specification feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpecificationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_FlowImplementation_specification_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_FlowImplementation_specification_feature",
						"_UI_FlowImplementation_type"),
				Aadl2Package.eINSTANCE.getFlowImplementation_Specification(), true, false, true, null, null, null));
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
			childrenFeatures.add(Aadl2Package.eINSTANCE.getFlowImplementation_OwnedFlowSegment());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getFlowImplementation_InEnd());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getFlowImplementation_OutEnd());
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
	 * This returns FlowImplementation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getImage(Object object) {
		if (((FlowImplementationImpl) object).getInEnd() == null
				&& ((FlowImplementationImpl) object).getOutEnd() == null) {
			return null;
		} else if (((FlowImplementationImpl) object).getInEnd() == null) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/FlowSourceImplementation"));
		} else if (((FlowImplementationImpl) object).getOutEnd() == null) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/FlowSinkImplementation"));
		}

		return overlayImage(object, getResourceLocator().getImage("full/obj16/FlowPathImplementation"));
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
						getResourceLocator(), getString("_UI_FlowImplementation_kind_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_FlowImplementation_kind_feature",
								"_UI_FlowImplementation_type"),
						Aadl2Package.eINSTANCE.getFlowImplementation_Kind(), true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getText(Object object) {
		String label = ((FlowImplementation) object).getSpecification().getName();

		if (label == null || label.length() == 0) {
			return getString("_UI_Flow_type");
		} else if (!(((FlowImplementation) object).getSpecification().getAllInEnd() == null
				&& ((FlowImplementation) object).getSpecification().getAllOutEnd() == null)) {
			if (((FlowImplementation) object).getSpecification().getAllInEnd() == null) {
				return getString("_UI_Flow_type") + " Source " + label;
			} else if (((FlowImplementation) object).getSpecification().getAllOutEnd() == null) {
				return getString("_UI_Flow_type") + " Sink " + label;
			} else {
				return getString("_UI_Flow_type") + " Path " + label;
			}
		}

		return getString("_UI_Flow_type");
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

		switch (notification.getFeatureID(FlowImplementation.class)) {
		case Aadl2Package.FLOW_IMPLEMENTATION__KIND:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__OWNED_FLOW_SEGMENT:
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_END:
		case Aadl2Package.FLOW_IMPLEMENTATION__OUT_END:
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

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getFlowImplementation_OwnedFlowSegment(),
				Aadl2Factory.eINSTANCE.createFlowSegment()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getFlowImplementation_InEnd(),
				Aadl2Factory.eINSTANCE.createFlowEnd()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getFlowImplementation_OutEnd(),
				Aadl2Factory.eINSTANCE.createFlowEnd()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == Aadl2Package.eINSTANCE.getFlowImplementation_InEnd()
				|| childFeature == Aadl2Package.eINSTANCE.getFlowImplementation_OutEnd();

		if (qualify) {
			return getString("_UI_CreateChild_text2",
					new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
