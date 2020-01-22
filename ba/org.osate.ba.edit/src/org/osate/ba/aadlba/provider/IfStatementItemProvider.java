/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
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



import java.util.Collection ;
import java.util.List ;

import org.eclipse.emf.common.notify.AdapterFactory ;
import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.ecore.EStructuralFeature ;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory ;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor ;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor ;
import org.eclipse.emf.edit.provider.ViewerNotification ;
import org.osate.ba.aadlba.AadlBaFactory ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.IfStatement ;

/**
 * This is the item provider adapter for a {@link org.osate.ba.aadlba.IfStatement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IfStatementItemProvider
  extends BehaviorElementItemProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfStatementItemProvider(AdapterFactory adapterFactory)
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

      addElifPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Elif feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addElifPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_IfStatement_elif_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_IfStatement_elif_feature", "_UI_IfStatement_type"),
         AadlBaPackage.Literals.IF_STATEMENT__ELIF,
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
      childrenFeatures.add(AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS);
      childrenFeatures.add(AadlBaPackage.Literals.IF_STATEMENT__LOGICAL_VALUE_EXPRESSION);
      childrenFeatures.add(AadlBaPackage.Literals.IF_STATEMENT__ELSE_STATEMENT);
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
   * This returns IfStatement.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   */
  @Override
  public Object getImage(Object object)
  {
    String imgFile = BehaviorElementItemProvider.IMG_PATH + "if_16" ;
    return overlayImage(object, getResourceLocator().getImage(imgFile));
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
    IfStatement ifStatement = (IfStatement)object;
    return getString("_UI_IfStatement_type") + " " + ifStatement.isElif();
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

    switch (notification.getFeatureID(IfStatement.class))
    {
      case AadlBaPackage.IF_STATEMENT__ELIF:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS:
      case AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSION:
      case AadlBaPackage.IF_STATEMENT__ELSE_STATEMENT:
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
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createAssignmentAction()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createBehaviorActionBlock()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createBehaviorActionSequence()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createBehaviorActionSet()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createElseStatement()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createForOrForAllStatement()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createIfStatement()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createLockAction()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createPortDequeueAction()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createPortFreezeAction()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createPortSendAction()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createSubprogramCallAction()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createTimedAction()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createUnlockAction()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS,
         AadlBaFactory.eINSTANCE.createWhileOrDoUntilStatement()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.IF_STATEMENT__LOGICAL_VALUE_EXPRESSION,
         AadlBaFactory.eINSTANCE.createValueExpression()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.IF_STATEMENT__LOGICAL_VALUE_EXPRESSION,
         AadlBaFactory.eINSTANCE.createAny()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.IF_STATEMENT__ELSE_STATEMENT,
         AadlBaFactory.eINSTANCE.createElseStatement()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.IF_STATEMENT__ELSE_STATEMENT,
         AadlBaFactory.eINSTANCE.createIfStatement()));
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
      childFeature == AadlBaPackage.Literals.COND_STATEMENT__BEHAVIOR_ACTIONS ||
      childFeature == AadlBaPackage.Literals.IF_STATEMENT__ELSE_STATEMENT;

    if (qualify)
    {
      return getString
        ("_UI_CreateChild_text2",
         new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
    }
    return super.getCreateChildText(owner, feature, child, selection);
  }

}
