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
package org.osate.xtext.aadl2.errormodel.errorModel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.osate.aadl2.Aadl2Package;

import org.osate.aadl2.provider.NamedElementItemProvider;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * This is the item provider adapter for a {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ErrorDetectionItemProvider extends NamedElementItemProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorDetectionItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addStatePropertyDescriptor(object);
      addAllStatesPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the State feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addStatePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ErrorDetection_state_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ErrorDetection_state_feature", "_UI_ErrorDetection_type"),
         ErrorModelPackage.Literals.ERROR_DETECTION__STATE,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the All States feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addAllStatesPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ErrorDetection_allStates_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ErrorDetection_allStates_feature", "_UI_ErrorDetection_type"),
         ErrorModelPackage.Literals.ERROR_DETECTION__ALL_STATES,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
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
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_DETECTION__DETECTION_REPORTING_PORT);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_DETECTION__ERROR_CODE);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child)
  {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns ErrorDetection.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/ErrorDetection"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object)
  {
    String label = ((ErrorDetection)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_ErrorDetection_type") :
      getString("_UI_ErrorDetection_type") + " " + label;
  }


  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification)
  {
    updateChildren(notification);

    switch (notification.getFeatureID(ErrorDetection.class))
    {
      case ErrorModelPackage.ERROR_DETECTION__ALL_STATES:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case ErrorModelPackage.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT:
      case ErrorModelPackage.ERROR_DETECTION__CONDITION:
      case ErrorModelPackage.ERROR_DETECTION__DETECTION_REPORTING_PORT:
      case ErrorModelPackage.ERROR_DETECTION__ERROR_CODE:
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
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add
      (createChildParameter
        (Aadl2Package.eINSTANCE.getNamedElement_OwnedPropertyAssociation(),
         ErrorModelFactory.eINSTANCE.createEMV2PropertyAssociation()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT,
         ErrorModelFactory.eINSTANCE.createTypeSet()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
         ErrorModelFactory.eINSTANCE.createConditionExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
         ErrorModelFactory.eINSTANCE.createOrmoreExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
         ErrorModelFactory.eINSTANCE.createOrlessExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
         ErrorModelFactory.eINSTANCE.createConditionElement()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
         ErrorModelFactory.eINSTANCE.createOrExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
         ErrorModelFactory.eINSTANCE.createAndExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
         ErrorModelFactory.eINSTANCE.createAllExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
         ErrorModelFactory.eINSTANCE.createSConditionElement()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_DETECTION__DETECTION_REPORTING_PORT,
         ErrorModelFactory.eINSTANCE.createReportingPortReference()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_DETECTION__ERROR_CODE,
         ErrorModelFactory.eINSTANCE.createErrorCodeValue()));
  }

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator()
  {
    return ErrorModelEditPlugin.INSTANCE;
  }

}
