/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeRefinement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Type Refinement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeRefinementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeRefinementImpl#getSubtypes <em>Subtypes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorTypeRefinementImpl extends MinimalEObjectImpl.Container implements ErrorTypeRefinement
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected ErrorType name;

  /**
   * The cached value of the '{@link #getSubtypes() <em>Subtypes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubtypes()
   * @generated
   * @ordered
   */
  protected EList<ErrorType> subtypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorTypeRefinementImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ErrorModelPackage.Literals.ERROR_TYPE_REFINEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorType getName()
  {
    if (name != null && name.eIsProxy())
    {
      InternalEObject oldName = (InternalEObject)name;
      name = (ErrorType)eResolveProxy(oldName);
      if (name != oldName)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_TYPE_REFINEMENT__NAME, oldName, name));
      }
    }
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorType basicGetName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(ErrorType newName)
  {
    ErrorType oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_TYPE_REFINEMENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorType> getSubtypes()
  {
    if (subtypes == null)
    {
      subtypes = new EObjectResolvingEList<ErrorType>(ErrorType.class, this, ErrorModelPackage.ERROR_TYPE_REFINEMENT__SUBTYPES);
    }
    return subtypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_TYPE_REFINEMENT__NAME:
        if (resolve) return getName();
        return basicGetName();
      case ErrorModelPackage.ERROR_TYPE_REFINEMENT__SUBTYPES:
        return getSubtypes();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_TYPE_REFINEMENT__NAME:
        setName((ErrorType)newValue);
        return;
      case ErrorModelPackage.ERROR_TYPE_REFINEMENT__SUBTYPES:
        getSubtypes().clear();
        getSubtypes().addAll((Collection<? extends ErrorType>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_TYPE_REFINEMENT__NAME:
        setName((ErrorType)null);
        return;
      case ErrorModelPackage.ERROR_TYPE_REFINEMENT__SUBTYPES:
        getSubtypes().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_TYPE_REFINEMENT__NAME:
        return name != null;
      case ErrorModelPackage.ERROR_TYPE_REFINEMENT__SUBTYPES:
        return subtypes != null && !subtypes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ErrorTypeRefinementImpl
