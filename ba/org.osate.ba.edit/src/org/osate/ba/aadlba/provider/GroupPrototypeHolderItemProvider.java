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
import org.osate.aadl2.ComponentPrototypeBinding ;
import org.osate.aadl2.FeatureGroupPrototypeBinding ;
import org.osate.aadl2.FeaturePrototypeBinding ;
import org.osate.aadl2.PrototypeBinding ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.FeatureType ;
import org.osate.ba.aadlba.PrototypeHolder ;
import org.osate.ba.utils.AadlBaUtils ;


/**
 * This is the item provider adapter for a {@link org.osate.ba.aadlba.GroupPrototypeHolder} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GroupPrototypeHolderItemProvider
  extends GroupHolderItemProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GroupPrototypeHolderItemProvider(AdapterFactory adapterFactory)
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

      addPrototypeBindingPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Prototype Binding feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addPrototypeBindingPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_GroupPrototypeHolder_prototypeBinding_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_GroupPrototypeHolder_prototypeBinding_feature", "_UI_GroupPrototypeHolder_type"),
         AadlBaPackage.Literals.GROUP_PROTOTYPE_HOLDER__PROTOTYPE_BINDING,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This returns GroupPrototypeHolder.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   */
  @Override
  public Object getImage(Object object)
  {
    String imgFile = BehaviorElementItemProvider.OSATE_IMG_PATH ;
    
    PrototypeHolder holder = (PrototypeHolder) object ;
    
    PrototypeBinding pb = holder.getPrototypeBinding() ;
    
    if(pb != null)
    {
      FeatureType type = FeatureType.ABSTRACT_FEATURE ;
      
      if(pb instanceof ComponentPrototypeBinding)
      {
        type = AadlBaUtils.getCompPrototypeType((ComponentPrototypeBinding) pb) ;
      }
      else if(pb instanceof FeatureGroupPrototypeBinding)
      {
        type = FeatureType.FEATURE_GROUP_PROTOTYPE ;
      }
      else if (pb instanceof FeaturePrototypeBinding)
      {
        type = AadlBaUtils.getFeatPrototypeType((FeaturePrototypeBinding)pb) ;
      }
      
      switch (type)
      {
        case FEATURE_GROUP_PROTOTYPE : {imgFile += "FeatureGroup" ; break;}
        case THREAD_GROUP_PROTOTYPE : {imgFile += "ThreadGroup" ; break;}
        case REQUIRES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE:
        case PROVIDES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE:  
        case SUBPROGRAM_GROUP_PROTOTYPE : {imgFile += "Subprogram" ; break;}
        default : imgFile = "full/obj16/IfStatement" ;
      }
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
    return getString("_UI_GroupPrototypeHolder_type");
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
