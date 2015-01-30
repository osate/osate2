/**
 */
package org.osate.verify.verify.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.categories.categories.VerificationCategory;

import org.osate.verify.verify.ArgumentExpr;
import org.osate.verify.verify.VerifyPackage;
import org.osate.verify.verify.WhenExpr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>When Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.WhenExprImpl#getVerification <em>Verification</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.WhenExprImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WhenExprImpl extends ArgumentExprImpl implements WhenExpr
{
  /**
   * The cached value of the '{@link #getVerification() <em>Verification</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerification()
   * @generated
   * @ordered
   */
  protected ArgumentExpr verification;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected EList<VerificationCategory> condition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WhenExprImpl()
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
    return VerifyPackage.Literals.WHEN_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArgumentExpr getVerification()
  {
    return verification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVerification(ArgumentExpr newVerification, NotificationChain msgs)
  {
    ArgumentExpr oldVerification = verification;
    verification = newVerification;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.WHEN_EXPR__VERIFICATION, oldVerification, newVerification);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVerification(ArgumentExpr newVerification)
  {
    if (newVerification != verification)
    {
      NotificationChain msgs = null;
      if (verification != null)
        msgs = ((InternalEObject)verification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.WHEN_EXPR__VERIFICATION, null, msgs);
      if (newVerification != null)
        msgs = ((InternalEObject)newVerification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.WHEN_EXPR__VERIFICATION, null, msgs);
      msgs = basicSetVerification(newVerification, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.WHEN_EXPR__VERIFICATION, newVerification, newVerification));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationCategory> getCondition()
  {
    if (condition == null)
    {
      condition = new EObjectResolvingEList<VerificationCategory>(VerificationCategory.class, this, VerifyPackage.WHEN_EXPR__CONDITION);
    }
    return condition;
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
      case VerifyPackage.WHEN_EXPR__VERIFICATION:
        return basicSetVerification(null, msgs);
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
      case VerifyPackage.WHEN_EXPR__VERIFICATION:
        return getVerification();
      case VerifyPackage.WHEN_EXPR__CONDITION:
        return getCondition();
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
      case VerifyPackage.WHEN_EXPR__VERIFICATION:
        setVerification((ArgumentExpr)newValue);
        return;
      case VerifyPackage.WHEN_EXPR__CONDITION:
        getCondition().clear();
        getCondition().addAll((Collection<? extends VerificationCategory>)newValue);
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
      case VerifyPackage.WHEN_EXPR__VERIFICATION:
        setVerification((ArgumentExpr)null);
        return;
      case VerifyPackage.WHEN_EXPR__CONDITION:
        getCondition().clear();
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
      case VerifyPackage.WHEN_EXPR__VERIFICATION:
        return verification != null;
      case VerifyPackage.WHEN_EXPR__CONDITION:
        return condition != null && !condition.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //WhenExprImpl
