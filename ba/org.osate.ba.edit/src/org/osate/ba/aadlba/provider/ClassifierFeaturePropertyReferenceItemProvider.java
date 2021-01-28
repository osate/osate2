/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2021 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.aadlba.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osate.ba.aadlba.AadlBaFactory;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.ClassifierFeaturePropertyReference;

/**
 * This is the item provider adapter for a {@link org.osate.ba.aadlba.ClassifierFeaturePropertyReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassifierFeaturePropertyReferenceItemProvider extends PropertyReferenceItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierFeaturePropertyReferenceItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT);
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
	 * This returns ClassifierFeaturePropertyReference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ClassifierFeaturePropertyReference"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ClassifierFeaturePropertyReference_type");
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

		switch (notification.getFeatureID(ClassifierFeaturePropertyReference.class)) {
		case AadlBaPackage.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT:
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
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createBehaviorVariableHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createDataAccessHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createDataAccessPrototypeHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createDataPortHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createDataSubcomponentHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createEventDataPortHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createEventPortHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createFeatureHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createFeaturePrototypeHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createParameterHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createPortCountValue()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createPortDequeueValue()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createPortFreezeAction()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createPortFreshValue()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createPortPrototypeHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createSubcomponentHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createSubprogramAccessHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createSubprogramPrototypeHolder()));

		newChildDescriptors
				.add(createChildParameter(AadlBaPackage.Literals.CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT,
						AadlBaFactory.eINSTANCE.createSubprogramSubcomponentHolder()));
	}

}
