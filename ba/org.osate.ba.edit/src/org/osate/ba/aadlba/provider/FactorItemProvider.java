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
import org.osate.ba.aadlba.BinaryNumericOperator ;
import org.osate.ba.aadlba.Factor ;

/**
 * This is the item provider adapter for a {@link org.osate.ba.aadlba.Factor} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FactorItemProvider
  extends BehaviorElementItemProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactorItemProvider(AdapterFactory adapterFactory)
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

      addBinaryNumericOperatorPropertyDescriptor(object);
      addUnaryNumericOperatorPropertyDescriptor(object);
      addUnaryBooleanOperatorPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Binary Numeric Operator feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addBinaryNumericOperatorPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Factor_binaryNumericOperator_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Factor_binaryNumericOperator_feature", "_UI_Factor_type"),
         AadlBaPackage.Literals.FACTOR__BINARY_NUMERIC_OPERATOR,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Unary Numeric Operator feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addUnaryNumericOperatorPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Factor_unaryNumericOperator_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Factor_unaryNumericOperator_feature", "_UI_Factor_type"),
         AadlBaPackage.Literals.FACTOR__UNARY_NUMERIC_OPERATOR,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Unary Boolean Operator feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addUnaryBooleanOperatorPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Factor_unaryBooleanOperator_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Factor_unaryBooleanOperator_feature", "_UI_Factor_type"),
         AadlBaPackage.Literals.FACTOR__UNARY_BOOLEAN_OPERATOR,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
      childrenFeatures.add(AadlBaPackage.Literals.FACTOR__FIRST_VALUE);
      childrenFeatures.add(AadlBaPackage.Literals.FACTOR__SECOND_VALUE);
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
   * This returns Factor.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Factor"));
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
    BinaryNumericOperator labelValue = ((Factor)object).getBinaryNumericOperator();
    String label = labelValue == null ? null : labelValue.toString();
    return label == null || label.length() == 0 ?
      getString("_UI_Factor_type") :
      getString("_UI_Factor_type") + " " + label;
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

    switch (notification.getFeatureID(Factor.class))
    {
      case AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR:
      case AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR:
      case AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case AadlBaPackage.FACTOR__FIRST_VALUE:
      case AadlBaPackage.FACTOR__SECOND_VALUE:
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
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createValueExpression()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createAny()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createBehaviorBooleanLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createBehaviorIntegerLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createBehaviorPropertyConstant()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createBehaviorRealLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createBehaviorStringLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createBehaviorVariableHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createClassifierPropertyReference()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createClassifierFeaturePropertyReference()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createDataAccessHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createDataAccessPrototypeHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createDataComponentReference()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createDataPortHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createDataSubcomponentHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createEventDataPortHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createEventPortHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createFeaturePrototypeHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createIterativeVariableHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createParameterHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createPortCountValue()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createPortDequeueValue()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createPortFreezeAction()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createPortFreshValue()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createPortPrototypeHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createPropertySetPropertyReference()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__FIRST_VALUE,
         AadlBaFactory.eINSTANCE.createStructUnionElementHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createValueExpression()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createAny()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createBehaviorBooleanLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createBehaviorIntegerLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createBehaviorPropertyConstant()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createBehaviorRealLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createBehaviorStringLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createBehaviorVariableHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createClassifierPropertyReference()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createClassifierFeaturePropertyReference()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createDataAccessHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createDataAccessPrototypeHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createDataComponentReference()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createDataPortHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createDataSubcomponentHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createEventDataPortHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createEventPortHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createFeaturePrototypeHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createIterativeVariableHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createParameterHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createPortCountValue()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createPortDequeueValue()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createPortFreezeAction()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createPortFreshValue()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createPortPrototypeHolder()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createPropertySetPropertyReference()));

    newChildDescriptors.add
      (createChildParameter
        (AadlBaPackage.Literals.FACTOR__SECOND_VALUE,
         AadlBaFactory.eINSTANCE.createStructUnionElementHolder()));
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
      childFeature == AadlBaPackage.Literals.FACTOR__FIRST_VALUE ||
      childFeature == AadlBaPackage.Literals.FACTOR__SECOND_VALUE;

    if (qualify)
    {
      return getString
        ("_UI_CreateChild_text2",
         new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
    }
    return super.getCreateChildText(owner, feature, child, selection);
  }

}
