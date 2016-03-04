/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ConditionElementImpl#getQualifiedErrorPropagationReference <em>Qualified Error Propagation Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ConditionElementImpl#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionElementImpl extends ElementImpl implements ConditionElement
{
  /**
   * The cached value of the '{@link #getQualifiedErrorPropagationReference() <em>Qualified Error Propagation Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifiedErrorPropagationReference()
   * @generated
   * @ordered
   */
  protected EMV2Path qualifiedErrorPropagationReference;

  /**
   * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraint()
   * @generated
   * @ordered
   */
  protected TypeSet constraint;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionElementImpl()
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
    return ErrorModelPackage.Literals.CONDITION_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMV2Path getQualifiedErrorPropagationReference()
  {
    return qualifiedErrorPropagationReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQualifiedErrorPropagationReference(EMV2Path newQualifiedErrorPropagationReference, NotificationChain msgs)
  {
    EMV2Path oldQualifiedErrorPropagationReference = qualifiedErrorPropagationReference;
    qualifiedErrorPropagationReference = newQualifiedErrorPropagationReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.CONDITION_ELEMENT__QUALIFIED_ERROR_PROPAGATION_REFERENCE, oldQualifiedErrorPropagationReference, newQualifiedErrorPropagationReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualifiedErrorPropagationReference(EMV2Path newQualifiedErrorPropagationReference)
  {
    if (newQualifiedErrorPropagationReference != qualifiedErrorPropagationReference)
    {
      NotificationChain msgs = null;
      if (qualifiedErrorPropagationReference != null)
        msgs = ((InternalEObject)qualifiedErrorPropagationReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.CONDITION_ELEMENT__QUALIFIED_ERROR_PROPAGATION_REFERENCE, null, msgs);
      if (newQualifiedErrorPropagationReference != null)
        msgs = ((InternalEObject)newQualifiedErrorPropagationReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.CONDITION_ELEMENT__QUALIFIED_ERROR_PROPAGATION_REFERENCE, null, msgs);
      msgs = basicSetQualifiedErrorPropagationReference(newQualifiedErrorPropagationReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.CONDITION_ELEMENT__QUALIFIED_ERROR_PROPAGATION_REFERENCE, newQualifiedErrorPropagationReference, newQualifiedErrorPropagationReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getConstraint()
  {
    return constraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConstraint(TypeSet newConstraint, NotificationChain msgs)
  {
    TypeSet oldConstraint = constraint;
    constraint = newConstraint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.CONDITION_ELEMENT__CONSTRAINT, oldConstraint, newConstraint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstraint(TypeSet newConstraint)
  {
    if (newConstraint != constraint)
    {
      NotificationChain msgs = null;
      if (constraint != null)
        msgs = ((InternalEObject)constraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.CONDITION_ELEMENT__CONSTRAINT, null, msgs);
      if (newConstraint != null)
        msgs = ((InternalEObject)newConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.CONDITION_ELEMENT__CONSTRAINT, null, msgs);
      msgs = basicSetConstraint(newConstraint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.CONDITION_ELEMENT__CONSTRAINT, newConstraint, newConstraint));
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
      case ErrorModelPackage.CONDITION_ELEMENT__QUALIFIED_ERROR_PROPAGATION_REFERENCE:
        return basicSetQualifiedErrorPropagationReference(null, msgs);
      case ErrorModelPackage.CONDITION_ELEMENT__CONSTRAINT:
        return basicSetConstraint(null, msgs);
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
      case ErrorModelPackage.CONDITION_ELEMENT__QUALIFIED_ERROR_PROPAGATION_REFERENCE:
        return getQualifiedErrorPropagationReference();
      case ErrorModelPackage.CONDITION_ELEMENT__CONSTRAINT:
        return getConstraint();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ErrorModelPackage.CONDITION_ELEMENT__QUALIFIED_ERROR_PROPAGATION_REFERENCE:
        setQualifiedErrorPropagationReference((EMV2Path)newValue);
        return;
      case ErrorModelPackage.CONDITION_ELEMENT__CONSTRAINT:
        setConstraint((TypeSet)newValue);
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
      case ErrorModelPackage.CONDITION_ELEMENT__QUALIFIED_ERROR_PROPAGATION_REFERENCE:
        setQualifiedErrorPropagationReference((EMV2Path)null);
        return;
      case ErrorModelPackage.CONDITION_ELEMENT__CONSTRAINT:
        setConstraint((TypeSet)null);
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
      case ErrorModelPackage.CONDITION_ELEMENT__QUALIFIED_ERROR_PROPAGATION_REFERENCE:
        return qualifiedErrorPropagationReference != null;
      case ErrorModelPackage.CONDITION_ELEMENT__CONSTRAINT:
        return constraint != null;
    }
    return super.eIsSet(featureID);
  }

} //ConditionElementImpl
