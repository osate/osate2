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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory ;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor ;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor ;
import org.eclipse.emf.edit.provider.ViewerNotification ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.BehaviorState ;

/**
 * This is the item provider adapter for a {@link org.osate.ba.aadlba.BehaviorState} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BehaviorStateItemProvider
  extends BehaviorNamedElementItemProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorStateItemProvider(AdapterFactory adapterFactory)
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

      addInitialPropertyDescriptor(object);
      addCompletePropertyDescriptor(object);
      addFinalPropertyDescriptor(object);
      addBindedModePropertyDescriptor(object);
      addIncomingTransitionsPropertyDescriptor(object);
      addOutgoingTransitionsPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Initial feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addInitialPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_BehaviorState_initial_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_BehaviorState_initial_feature", "_UI_BehaviorState_type"),
         AadlBaPackage.Literals.BEHAVIOR_STATE__INITIAL,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Complete feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addCompletePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_BehaviorState_complete_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_BehaviorState_complete_feature", "_UI_BehaviorState_type"),
         AadlBaPackage.Literals.BEHAVIOR_STATE__COMPLETE,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Final feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addFinalPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_BehaviorState_final_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_BehaviorState_final_feature", "_UI_BehaviorState_type"),
         AadlBaPackage.Literals.BEHAVIOR_STATE__FINAL,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Binded Mode feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addBindedModePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_BehaviorState_bindedMode_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_BehaviorState_bindedMode_feature", "_UI_BehaviorState_type"),
         AadlBaPackage.Literals.BEHAVIOR_STATE__BINDED_MODE,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Incoming Transitions feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addIncomingTransitionsPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_BehaviorState_incomingTransitions_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_BehaviorState_incomingTransitions_feature", "_UI_BehaviorState_type"),
         AadlBaPackage.Literals.BEHAVIOR_STATE__INCOMING_TRANSITIONS,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Outgoing Transitions feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addOutgoingTransitionsPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_BehaviorState_outgoingTransitions_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_BehaviorState_outgoingTransitions_feature", "_UI_BehaviorState_type"),
         AadlBaPackage.Literals.BEHAVIOR_STATE__OUTGOING_TRANSITIONS,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This returns BehaviorState.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   */
  @Override
  public Object getImage(Object object)
  {
BehaviorState state = (BehaviorState) object ;
    byte code = 0 ;
    String imgFile = null ;
    
    if(state.isInitial())
      code = 1 ;
    
    if(state.isComplete())
      code += 10 ;
    
    if(state.isFinal())
      code += 100 ;
    
    switch (code)
    {
      case 0 : {imgFile = BehaviorElementItemProvider.IMG_PATH + "e_state_16" ; break ;}
      case 1 : {imgFile = BehaviorElementItemProvider.IMG_PATH + "i_state_16" ; break ;}
      case 10 : {imgFile = BehaviorElementItemProvider.IMG_PATH + "c_state_16" ; break ;}
      case 11 : {imgFile = BehaviorElementItemProvider.IMG_PATH + "ic_state_16" ; break ;}
      case 100 : {imgFile = BehaviorElementItemProvider.IMG_PATH + "f_state_16" ; break ;}
      case 101 : {imgFile = BehaviorElementItemProvider.IMG_PATH + "if_state_16" ; break ;}
      case 110 : {imgFile = BehaviorElementItemProvider.IMG_PATH + "cf_state_16" ; break ;}
      case 111 : {imgFile = BehaviorElementItemProvider.IMG_PATH + "icf_state_16" ; break ;}
    }
    
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
    String label = ((BehaviorState)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_BehaviorState_type") :
      getString("_UI_BehaviorState_type") + " " + label;
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

    switch (notification.getFeatureID(BehaviorState.class))
    {
      case AadlBaPackage.BEHAVIOR_STATE__INITIAL:
      case AadlBaPackage.BEHAVIOR_STATE__COMPLETE:
      case AadlBaPackage.BEHAVIOR_STATE__FINAL:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
  }

}
