/**
 */
package org.osate.verify.verify.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.verify.verify.ArgumentExpr;
import org.osate.verify.verify.ConditionExpr;
import org.osate.verify.verify.ConditionalExpr;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.ConditionalExprImpl#getVerification <em>Verification</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.ConditionalExprImpl#getOp <em>Op</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.ConditionalExprImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalExprImpl extends ArgumentExprImpl implements ConditionalExpr
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
   * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected static final String OP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected String op = OP_EDEFAULT;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected ConditionExpr condition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalExprImpl()
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
    return VerifyPackage.Literals.CONDITIONAL_EXPR;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.CONDITIONAL_EXPR__VERIFICATION, oldVerification, newVerification);
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
        msgs = ((InternalEObject)verification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.CONDITIONAL_EXPR__VERIFICATION, null, msgs);
      if (newVerification != null)
        msgs = ((InternalEObject)newVerification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.CONDITIONAL_EXPR__VERIFICATION, null, msgs);
      msgs = basicSetVerification(newVerification, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.CONDITIONAL_EXPR__VERIFICATION, newVerification, newVerification));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOp()
  {
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOp(String newOp)
  {
    String oldOp = op;
    op = newOp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.CONDITIONAL_EXPR__OP, oldOp, op));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionExpr getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(ConditionExpr newCondition, NotificationChain msgs)
  {
    ConditionExpr oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.CONDITIONAL_EXPR__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(ConditionExpr newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.CONDITIONAL_EXPR__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.CONDITIONAL_EXPR__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.CONDITIONAL_EXPR__CONDITION, newCondition, newCondition));
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
      case VerifyPackage.CONDITIONAL_EXPR__VERIFICATION:
        return basicSetVerification(null, msgs);
      case VerifyPackage.CONDITIONAL_EXPR__CONDITION:
        return basicSetCondition(null, msgs);
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
      case VerifyPackage.CONDITIONAL_EXPR__VERIFICATION:
        return getVerification();
      case VerifyPackage.CONDITIONAL_EXPR__OP:
        return getOp();
      case VerifyPackage.CONDITIONAL_EXPR__CONDITION:
        return getCondition();
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
      case VerifyPackage.CONDITIONAL_EXPR__VERIFICATION:
        setVerification((ArgumentExpr)newValue);
        return;
      case VerifyPackage.CONDITIONAL_EXPR__OP:
        setOp((String)newValue);
        return;
      case VerifyPackage.CONDITIONAL_EXPR__CONDITION:
        setCondition((ConditionExpr)newValue);
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
      case VerifyPackage.CONDITIONAL_EXPR__VERIFICATION:
        setVerification((ArgumentExpr)null);
        return;
      case VerifyPackage.CONDITIONAL_EXPR__OP:
        setOp(OP_EDEFAULT);
        return;
      case VerifyPackage.CONDITIONAL_EXPR__CONDITION:
        setCondition((ConditionExpr)null);
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
      case VerifyPackage.CONDITIONAL_EXPR__VERIFICATION:
        return verification != null;
      case VerifyPackage.CONDITIONAL_EXPR__OP:
        return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
      case VerifyPackage.CONDITIONAL_EXPR__CONDITION:
        return condition != null;
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
    result.append(" (op: ");
    result.append(op);
    result.append(')');
    return result.toString();
  }

} //ConditionalExprImpl
