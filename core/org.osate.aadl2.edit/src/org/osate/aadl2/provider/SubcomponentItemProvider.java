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
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
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
 * $Id: SubcomponentItemProvider.java,v 1.24 2011-04-11 13:36:04 lwrage Exp $
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
