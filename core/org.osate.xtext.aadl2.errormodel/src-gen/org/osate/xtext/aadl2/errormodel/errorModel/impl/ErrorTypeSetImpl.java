/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeRefinement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Type Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeSetImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeSetImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeSetImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeSetImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeSetImpl#getRefinements <em>Refinements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorTypeSetImpl extends MinimalEObjectImpl.Container implements ErrorTypeSet
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypes()
   * @generated
   * @ordered
   */
  protected EList<ErrorType> types;

  /**
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected EList<Feature> features;

  /**
   * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtends()
   * @generated
   * @ordered
   */
  protected ErrorTypeSet extends_;

  /**
   * The cached value of the '{@link #getRefinements() <em>Refinements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefinements()
   * @generated
   * @ordered
   */
  protected EList<ErrorTypeRefinement> refinements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorTypeSetImpl()
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
    return ErrorModelPackage.Literals.ERROR_TYPE_SET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_TYPE_SET__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorType> getTypes()
  {
    if (types == null)
    {
      types = new EObjectContainmentEList<ErrorType>(ErrorType.class, this, ErrorModelPackage.ERROR_TYPE_SET__TYPES);
    }
    return types;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature> getFeatures()
  {
    if (features == null)
    {
      features = new EObjectContainmentEList<Feature>(Feature.class, this, ErrorModelPackage.ERROR_TYPE_SET__FEATURES);
    }
    return features;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorTypeSet getExtends()
  {
    if (extends_ != null && extends_.eIsProxy())
    {
      InternalEObject oldExtends = (InternalEObject)extends_;
      extends_ = (ErrorTypeSet)eResolveProxy(oldExtends);
      if (extends_ != oldExtends)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_TYPE_SET__EXTENDS, oldExtends, extends_));
      }
    }
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorTypeSet basicGetExtends()
  {
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtends(ErrorTypeSet newExtends)
  {
    ErrorTypeSet oldExtends = extends_;
    extends_ = newExtends;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_TYPE_SET__EXTENDS, oldExtends, extends_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorTypeRefinement> getRefinements()
  {
    if (refinements == null)
    {
      refinements = new EObjectContainmentEList<ErrorTypeRefinement>(ErrorTypeRefinement.class, this, ErrorModelPackage.ERROR_TYPE_SET__REFINEMENTS);
    }
    return refinements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_TYPE_SET__TYPES:
        return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_TYPE_SET__FEATURES:
        return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_TYPE_SET__REFINEMENTS:
        return ((InternalEList<?>)getRefinements()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case ErrorModelPackage.ERROR_TYPE_SET__NAME:
        return getName();
      case ErrorModelPackage.ERROR_TYPE_SET__TYPES:
        return getTypes();
      case ErrorModelPackage.ERROR_TYPE_SET__FEATURES:
        return getFeatures();
      case ErrorModelPackage.ERROR_TYPE_SET__EXTENDS:
        if (resolve) return getExtends();
        return basicGetExtends();
      case ErrorModelPackage.ERROR_TYPE_SET__REFINEMENTS:
        return getRefinements();
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
      case ErrorModelPackage.ERROR_TYPE_SET__NAME:
        setName((String)newValue);
        return;
      case ErrorModelPackage.ERROR_TYPE_SET__TYPES:
        getTypes().clear();
        getTypes().addAll((Collection<? extends ErrorType>)newValue);
        return;
      case ErrorModelPackage.ERROR_TYPE_SET__FEATURES:
        getFeatures().clear();
        getFeatures().addAll((Collection<? extends Feature>)newValue);
        return;
      case ErrorModelPackage.ERROR_TYPE_SET__EXTENDS:
        setExtends((ErrorTypeSet)newValue);
        return;
      case ErrorModelPackage.ERROR_TYPE_SET__REFINEMENTS:
        getRefinements().clear();
        getRefinements().addAll((Collection<? extends ErrorTypeRefinement>)newValue);
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
      case ErrorModelPackage.ERROR_TYPE_SET__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_TYPE_SET__TYPES:
        getTypes().clear();
        return;
      case ErrorModelPackage.ERROR_TYPE_SET__FEATURES:
        getFeatures().clear();
        return;
      case ErrorModelPackage.ERROR_TYPE_SET__EXTENDS:
        setExtends((ErrorTypeSet)null);
        return;
      case ErrorModelPackage.ERROR_TYPE_SET__REFINEMENTS:
        getRefinements().clear();
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
      case ErrorModelPackage.ERROR_TYPE_SET__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ErrorModelPackage.ERROR_TYPE_SET__TYPES:
        return types != null && !types.isEmpty();
      case ErrorModelPackage.ERROR_TYPE_SET__FEATURES:
        return features != null && !features.isEmpty();
      case ErrorModelPackage.ERROR_TYPE_SET__EXTENDS:
        return extends_ != null;
      case ErrorModelPackage.ERROR_TYPE_SET__REFINEMENTS:
        return refinements != null && !refinements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ErrorTypeSetImpl
