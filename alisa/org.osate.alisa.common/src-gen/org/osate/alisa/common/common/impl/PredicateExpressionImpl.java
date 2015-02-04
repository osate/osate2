/**
 */
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.ConstantDecl;
import org.osate.alisa.common.common.PredicateExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.PredicateExpressionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.PredicateExpressionImpl#getLimit <em>Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PredicateExpressionImpl extends MinimalEObjectImpl.Container implements PredicateExpression
{
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
   * The cached value of the '{@link #getLimit() <em>Limit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimit()
   * @generated
   * @ordered
   */
  protected ConstantDecl limit;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PredicateExpressionImpl()
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
    return CommonPackage.Literals.PREDICATE_EXPRESSION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.PREDICATE_EXPRESSION__OP, oldOp, op));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantDecl getLimit()
  {
    if (limit != null && limit.eIsProxy())
    {
      InternalEObject oldLimit = (InternalEObject)limit;
      limit = (ConstantDecl)eResolveProxy(oldLimit);
      if (limit != oldLimit)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CommonPackage.PREDICATE_EXPRESSION__LIMIT, oldLimit, limit));
      }
    }
    return limit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantDecl basicGetLimit()
  {
    return limit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLimit(ConstantDecl newLimit)
  {
    ConstantDecl oldLimit = limit;
    limit = newLimit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.PREDICATE_EXPRESSION__LIMIT, oldLimit, limit));
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
      case CommonPackage.PREDICATE_EXPRESSION__OP:
        return getOp();
      case CommonPackage.PREDICATE_EXPRESSION__LIMIT:
        if (resolve) return getLimit();
        return basicGetLimit();
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
      case CommonPackage.PREDICATE_EXPRESSION__OP:
        setOp((String)newValue);
        return;
      case CommonPackage.PREDICATE_EXPRESSION__LIMIT:
        setLimit((ConstantDecl)newValue);
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
      case CommonPackage.PREDICATE_EXPRESSION__OP:
        setOp(OP_EDEFAULT);
        return;
      case CommonPackage.PREDICATE_EXPRESSION__LIMIT:
        setLimit((ConstantDecl)null);
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
      case CommonPackage.PREDICATE_EXPRESSION__OP:
        return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
      case CommonPackage.PREDICATE_EXPRESSION__LIMIT:
        return limit != null;
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

} //PredicateExpressionImpl
