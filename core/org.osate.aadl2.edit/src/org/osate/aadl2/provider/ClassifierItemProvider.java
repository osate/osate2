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
import org.osate.aadl2.Classifier;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.Classifier} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassifierItemProvider extends NamespaceItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierItemProvider(AdapterFactory adapterFactory) {
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

			addClassifierFeaturePropertyDescriptor(object);
			addInheritedMemberPropertyDescriptor(object);
			addGeneralizationPropertyDescriptor(object);
			addGeneralPropertyDescriptor(object);
			addNoPrototypesPropertyDescriptor(object);
			addNoAnnexesPropertyDescriptor(object);
			addNoPropertiesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Classifier Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassifierFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Classifier_classifierFeature_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Classifier_classifierFeature_feature",
								"_UI_Classifier_type"),
						Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature(), false, false, false, null, null,
						null));
	}

	/**
	 * This adds a property descriptor for the Inherited Member feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInheritedMemberPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Classifier_inheritedMember_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Classifier_inheritedMember_feature",
								"_UI_Classifier_type"),
						Aadl2Package.eINSTANCE.getClassifier_InheritedMember(), false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Generalization feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGeneralizationPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Classifier_generalization_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Classifier_generalization_feature",
								"_UI_Classifier_type"),
						Aadl2Package.eINSTANCE.getClassifier_Generalization(), false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the General feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGeneralPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Classifier_general_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Classifier_general_feature",
								"_UI_Classifier_type"),
						Aadl2Package.eINSTANCE.getClassifier_General(), false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the No Properties feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNoPropertiesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Classifier_noProperties_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Classifier_noProperties_feature",
								"_UI_Classifier_type"),
						Aadl2Package.eINSTANCE.getClassifier_NoProperties(), true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the No Prototypes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNoPrototypesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Classifier_noPrototypes_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Classifier_noPrototypes_feature",
								"_UI_Classifier_type"),
						Aadl2Package.eINSTANCE.getClassifier_NoPrototypes(), true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the No Annexes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNoAnnexesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Classifier_noAnnexes_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Classifier_noAnnexes_feature",
								"_UI_Classifier_type"),
						Aadl2Package.eINSTANCE.getClassifier_NoAnnexes(), true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(Aadl2Package.eINSTANCE.getClassifier_OwnedAnnexSubclause());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototypeBinding());
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Classifier) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Classifier_type")
				: getString("_UI_Classifier_type") + " " + label;
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

		switch (notification.getFeatureID(Classifier.class)) {
		case Aadl2Package.CLASSIFIER__NO_PROTOTYPES:
		case Aadl2Package.CLASSIFIER__NO_ANNEXES:
		case Aadl2Package.CLASSIFIER__NO_PROPERTIES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE:
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE:
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING:
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
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedAnnexSubclause(),
				Aadl2Factory.eINSTANCE.createDefaultAnnexSubclause()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createFeaturePrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createFeatureGroupPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createAbstractPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createBusPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createDataPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createDevicePrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createMemoryPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createSubprogramPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createSubprogramGroupPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createSystemPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createProcessorPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createProcessPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createThreadPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createThreadGroupPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createVirtualBusPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createVirtualProcessorPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototypeBinding(),
				Aadl2Factory.eINSTANCE.createComponentPrototypeBinding()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototypeBinding(),
				Aadl2Factory.eINSTANCE.createFeatureGroupPrototypeBinding()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototypeBinding(),
				Aadl2Factory.eINSTANCE.createFeaturePrototypeBinding()));
	}

}
