/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ba.behaviorAnnex.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexFactory;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement;

/**
 * This is the item provider adapter for a {@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ForStatementItemProvider extends BehaviorActionItemProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForStatementItemProvider(AdapterFactory adapterFactory)
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

      addForPropertyDescriptor(object);
      addForallPropertyDescriptor(object);
      addVariablePropertyDescriptor(object);
      addDataClassifierPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the For feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addForPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ForStatement_for_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ForStatement_for_feature", "_UI_ForStatement_type"),
         BehaviorAnnexPackage.Literals.FOR_STATEMENT__FOR,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Forall feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addForallPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ForStatement_forall_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ForStatement_forall_feature", "_UI_ForStatement_type"),
         BehaviorAnnexPackage.Literals.FOR_STATEMENT__FORALL,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Variable feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addVariablePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ForStatement_variable_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ForStatement_variable_feature", "_UI_ForStatement_type"),
         BehaviorAnnexPackage.Literals.FOR_STATEMENT__VARIABLE,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Data Classifier feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addDataClassifierPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ForStatement_dataClassifier_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ForStatement_dataClassifier_feature", "_UI_ForStatement_type"),
         BehaviorAnnexPackage.Literals.FOR_STATEMENT__DATA_CLASSIFIER,
         true,
         false,
         true,
         null,
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
      childrenFeatures.add(BehaviorAnnexPackage.Literals.FOR_STATEMENT__VALUES);
      childrenFeatures.add(BehaviorAnnexPackage.Literals.FOR_STATEMENT__ACTIONS);
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
   * This returns ForStatement.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/ForStatement"));
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
    ForStatement forStatement = (ForStatement)object;
    return getString("_UI_ForStatement_type") + " " + forStatement.isFor();
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

    switch (notification.getFeatureID(ForStatement.class))
    {
      case BehaviorAnnexPackage.FOR_STATEMENT__FOR:
      case BehaviorAnnexPackage.FOR_STATEMENT__FORALL:
      case BehaviorAnnexPackage.FOR_STATEMENT__VARIABLE:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case BehaviorAnnexPackage.FOR_STATEMENT__VALUES:
      case BehaviorAnnexPackage.FOR_STATEMENT__ACTIONS:
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
        (BehaviorAnnexPackage.Literals.FOR_STATEMENT__VALUES,
         BehaviorAnnexFactory.eINSTANCE.createElementValues()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.FOR_STATEMENT__ACTIONS,
         BehaviorAnnexFactory.eINSTANCE.createBehaviorActions()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.FOR_STATEMENT__ACTIONS,
         BehaviorAnnexFactory.eINSTANCE.createBehaviorAction()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.FOR_STATEMENT__ACTIONS,
         BehaviorAnnexFactory.eINSTANCE.createBehaviorActionBlock()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.FOR_STATEMENT__ACTIONS,
         BehaviorAnnexFactory.eINSTANCE.createAssignmentAction()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.FOR_STATEMENT__ACTIONS,
         BehaviorAnnexFactory.eINSTANCE.createCommunicationAction()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.FOR_STATEMENT__ACTIONS,
         BehaviorAnnexFactory.eINSTANCE.createTimedAction()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.FOR_STATEMENT__ACTIONS,
         BehaviorAnnexFactory.eINSTANCE.createIfStatement()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.FOR_STATEMENT__ACTIONS,
         BehaviorAnnexFactory.eINSTANCE.createForStatement()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.FOR_STATEMENT__ACTIONS,
         BehaviorAnnexFactory.eINSTANCE.createWhileStatement()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.FOR_STATEMENT__ACTIONS,
         BehaviorAnnexFactory.eINSTANCE.createDoUntilStatement()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.FOR_STATEMENT__ACTIONS,
         BehaviorAnnexFactory.eINSTANCE.createBehaviorActionSequence()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.FOR_STATEMENT__ACTIONS,
         BehaviorAnnexFactory.eINSTANCE.createBehaviorActionSet()));
  }

}
