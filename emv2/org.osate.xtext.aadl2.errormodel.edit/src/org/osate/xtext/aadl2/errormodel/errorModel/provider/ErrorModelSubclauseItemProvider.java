/**
 * *
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
package org.osate.xtext.aadl2.errormodel.errorModel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.osate.aadl2.provider.AnnexSubclauseItemProvider;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

/**
 * This is the item provider adapter for a {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ErrorModelSubclauseItemProvider extends AnnexSubclauseItemProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorModelSubclauseItemProvider(AdapterFactory adapterFactory)
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

      addUseTypesPropertyDescriptor(object);
      addTypeEquivalencePropertyDescriptor(object);
      addTypeMappingSetPropertyDescriptor(object);
      addUseBehaviorPropertyDescriptor(object);
      addUseTransformationPropertyDescriptor(object);
      addTypeTransformationSetPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Use Types feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addUseTypesPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ErrorModelSubclause_useTypes_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ErrorModelSubclause_useTypes_feature", "_UI_ErrorModelSubclause_type"),
         ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__USE_TYPES,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Type Equivalence feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addTypeEquivalencePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ErrorModelSubclause_typeEquivalence_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ErrorModelSubclause_typeEquivalence_feature", "_UI_ErrorModelSubclause_type"),
         ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__TYPE_EQUIVALENCE,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Type Mapping Set feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addTypeMappingSetPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ErrorModelSubclause_typeMappingSet_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ErrorModelSubclause_typeMappingSet_feature", "_UI_ErrorModelSubclause_type"),
         ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__TYPE_MAPPING_SET,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Use Behavior feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addUseBehaviorPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ErrorModelSubclause_useBehavior_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ErrorModelSubclause_useBehavior_feature", "_UI_ErrorModelSubclause_type"),
         ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Use Transformation feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addUseTransformationPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ErrorModelSubclause_useTransformation_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ErrorModelSubclause_useTransformation_feature", "_UI_ErrorModelSubclause_type"),
         ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__USE_TRANSFORMATION,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Type Transformation Set feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addTypeTransformationSetPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ErrorModelSubclause_typeTransformationSet_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ErrorModelSubclause_typeTransformationSet_feature", "_UI_ErrorModelSubclause_type"),
         ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__TYPE_TRANSFORMATION_SET,
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
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__PROPAGATIONS);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__FLOWS);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__EVENTS);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__TRANSITIONS);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__OUTGOING_PROPAGATION_CONDITIONS);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__ERROR_DETECTIONS);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__ERROR_STATE_TO_MODE_MAPPINGS);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__STATES);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__CONNECTION_ERROR_SOURCES);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__POINTS);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__PATHS);
      childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__PROPERTIES);
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
   * This returns ErrorModelSubclause.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/ErrorModelSubclause"));
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
    String label = ((ErrorModelSubclause)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_ErrorModelSubclause_type") :
      getString("_UI_ErrorModelSubclause_type") + " " + label;
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

    switch (notification.getFeatureID(ErrorModelSubclause.class))
    {
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATIONS:
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__FLOWS:
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__EVENTS:
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TRANSITIONS:
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OUTGOING_PROPAGATION_CONDITIONS:
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_DETECTIONS:
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_STATE_TO_MODE_MAPPINGS:
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__STATES:
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_ERROR_SOURCES:
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__POINTS:
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PATHS:
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPERTIES:
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
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__PROPAGATIONS,
         ErrorModelFactory.eINSTANCE.createErrorPropagation()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__FLOWS,
         ErrorModelFactory.eINSTANCE.createErrorFlow()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__FLOWS,
         ErrorModelFactory.eINSTANCE.createErrorSource()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__FLOWS,
         ErrorModelFactory.eINSTANCE.createErrorSink()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__FLOWS,
         ErrorModelFactory.eINSTANCE.createErrorPath()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__EVENTS,
         ErrorModelFactory.eINSTANCE.createErrorBehaviorEvent()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__EVENTS,
         ErrorModelFactory.eINSTANCE.createErrorEvent()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__EVENTS,
         ErrorModelFactory.eINSTANCE.createRepairEvent()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__EVENTS,
         ErrorModelFactory.eINSTANCE.createRecoverEvent()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__TRANSITIONS,
         ErrorModelFactory.eINSTANCE.createErrorBehaviorTransition()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__OUTGOING_PROPAGATION_CONDITIONS,
         ErrorModelFactory.eINSTANCE.createOutgoingPropagationCondition()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__ERROR_DETECTIONS,
         ErrorModelFactory.eINSTANCE.createErrorDetection()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__ERROR_STATE_TO_MODE_MAPPINGS,
         ErrorModelFactory.eINSTANCE.createErrorStateToModeMapping()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__STATES,
         ErrorModelFactory.eINSTANCE.createCompositeState()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__CONNECTION_ERROR_SOURCES,
         ErrorModelFactory.eINSTANCE.createErrorSource()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__POINTS,
         ErrorModelFactory.eINSTANCE.createPropagationPoint()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__PATHS,
         ErrorModelFactory.eINSTANCE.createPropagationPath()));

    newChildDescriptors.add
      (createChildParameter
        (ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__PROPERTIES,
         ErrorModelFactory.eINSTANCE.createEMV2PropertyAssociation()));
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
      childFeature == ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__FLOWS ||
      childFeature == ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE__CONNECTION_ERROR_SOURCES;

    if (qualify)
    {
      return getString
        ("_UI_CreateChild_text2",
         new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
    }
    return super.getCreateChildText(owner, feature, child, selection);
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
