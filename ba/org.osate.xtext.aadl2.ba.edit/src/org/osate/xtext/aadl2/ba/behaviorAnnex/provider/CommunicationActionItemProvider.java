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
import org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction;

/**
 * This is the item provider adapter for a {@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CommunicationActionItemProvider extends BehaviorActionItemProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommunicationActionItemProvider(AdapterFactory adapterFactory)
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

      addSendPropertyDescriptor(object);
      addDequeuePropertyDescriptor(object);
      addFreezePropertyDescriptor(object);
      addLockPropertyDescriptor(object);
      addUnlockPropertyDescriptor(object);
      addAllPropertyDescriptor(object);
      addAllLockPropertyDescriptor(object);
      addAllUnlockPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Send feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addSendPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_CommunicationAction_send_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_CommunicationAction_send_feature", "_UI_CommunicationAction_type"),
         BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__SEND,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Dequeue feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addDequeuePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_CommunicationAction_dequeue_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_CommunicationAction_dequeue_feature", "_UI_CommunicationAction_type"),
         BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__DEQUEUE,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Freeze feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addFreezePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_CommunicationAction_freeze_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_CommunicationAction_freeze_feature", "_UI_CommunicationAction_type"),
         BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__FREEZE,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Lock feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addLockPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_CommunicationAction_lock_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_CommunicationAction_lock_feature", "_UI_CommunicationAction_type"),
         BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__LOCK,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Unlock feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addUnlockPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_CommunicationAction_unlock_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_CommunicationAction_unlock_feature", "_UI_CommunicationAction_type"),
         BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__UNLOCK,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the All feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addAllPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_CommunicationAction_all_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_CommunicationAction_all_feature", "_UI_CommunicationAction_type"),
         BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__ALL,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the All Lock feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addAllLockPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_CommunicationAction_allLock_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_CommunicationAction_allLock_feature", "_UI_CommunicationAction_type"),
         BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__ALL_LOCK,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the All Unlock feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addAllUnlockPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_CommunicationAction_allUnlock_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_CommunicationAction_allUnlock_feature", "_UI_CommunicationAction_type"),
         BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__ALL_UNLOCK,
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
      childrenFeatures.add(BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__REFERENCE);
      childrenFeatures.add(BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__PARAMETERS);
      childrenFeatures.add(BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__TARGET);
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
   * This returns CommunicationAction.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/CommunicationAction"));
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
    CommunicationAction communicationAction = (CommunicationAction)object;
    return getString("_UI_CommunicationAction_type") + " " + communicationAction.isSend();
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

    switch (notification.getFeatureID(CommunicationAction.class))
    {
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__SEND:
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__DEQUEUE:
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__FREEZE:
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__LOCK:
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__UNLOCK:
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL:
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL_LOCK:
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL_UNLOCK:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__REFERENCE:
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__PARAMETERS:
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__TARGET:
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
        (BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__REFERENCE,
         BehaviorAnnexFactory.eINSTANCE.createReference()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__PARAMETERS,
         BehaviorAnnexFactory.eINSTANCE.createValueExpression()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__PARAMETERS,
         BehaviorAnnexFactory.eINSTANCE.createValueConstant()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__PARAMETERS,
         BehaviorAnnexFactory.eINSTANCE.createBehaviorIntegerLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__PARAMETERS,
         BehaviorAnnexFactory.eINSTANCE.createBehaviorRealLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__PARAMETERS,
         BehaviorAnnexFactory.eINSTANCE.createBehaviorStringLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__PARAMETERS,
         BehaviorAnnexFactory.eINSTANCE.createBehaviorBooleanLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__PARAMETERS,
         BehaviorAnnexFactory.eINSTANCE.createReferenceExpression()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__PARAMETERS,
         BehaviorAnnexFactory.eINSTANCE.createHashPropertyReference()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__PARAMETERS,
         BehaviorAnnexFactory.eINSTANCE.createBinaryExpression()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__PARAMETERS,
         BehaviorAnnexFactory.eINSTANCE.createUnaryExpression()));

    newChildDescriptors.add
      (createChildParameter
        (BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__TARGET,
         BehaviorAnnexFactory.eINSTANCE.createReference()));
  }

  /**
   * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection)
  {
    Object childFeature = feature;
    Object childObject = child;

    boolean qualify =
      childFeature == BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__REFERENCE ||
      childFeature == BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION__TARGET;

    if (qualify)
    {
      return getString
        ("_UI_CreateChild_text2",
         new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
    }
    return super.getCreateChildText(owner, feature, child, selection);
  }

}
