/**
 */
package org.osate.assure.assure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.assure.assure.AssumptionResult;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.VerificationExpr;

import org.osate.verify.verify.VerificationAssumption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assumption Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.AssumptionResultImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssumptionResultImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssumptionResultImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssumptionResultImpl#getVerificationActivityResult <em>Verification Activity Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssumptionResultImpl extends AssureResultImpl implements AssumptionResult
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
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected VerificationAssumption target;

  /**
   * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected static final String MESSAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected String message = MESSAGE_EDEFAULT;

  /**
   * The cached value of the '{@link #getVerificationActivityResult() <em>Verification Activity Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerificationActivityResult()
   * @generated
   * @ordered
   */
  protected EList<VerificationExpr> verificationActivityResult;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssumptionResultImpl()
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
    return AssurePackage.Literals.ASSUMPTION_RESULT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSUMPTION_RESULT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationAssumption getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (VerificationAssumption)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.ASSUMPTION_RESULT__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationAssumption basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(VerificationAssumption newTarget)
  {
    VerificationAssumption oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSUMPTION_RESULT__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMessage()
  {
    return message;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessage(String newMessage)
  {
    String oldMessage = message;
    message = newMessage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSUMPTION_RESULT__MESSAGE, oldMessage, message));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationExpr> getVerificationActivityResult()
  {
    if (verificationActivityResult == null)
    {
      verificationActivityResult = new EObjectContainmentEList<VerificationExpr>(VerificationExpr.class, this, AssurePackage.ASSUMPTION_RESULT__VERIFICATION_ACTIVITY_RESULT);
    }
    return verificationActivityResult;
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
      case AssurePackage.ASSUMPTION_RESULT__VERIFICATION_ACTIVITY_RESULT:
        return ((InternalEList<?>)getVerificationActivityResult()).basicRemove(otherEnd, msgs);
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
      case AssurePackage.ASSUMPTION_RESULT__NAME:
        return getName();
      case AssurePackage.ASSUMPTION_RESULT__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case AssurePackage.ASSUMPTION_RESULT__MESSAGE:
        return getMessage();
      case AssurePackage.ASSUMPTION_RESULT__VERIFICATION_ACTIVITY_RESULT:
        return getVerificationActivityResult();
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
      case AssurePackage.ASSUMPTION_RESULT__NAME:
        setName((String)newValue);
        return;
      case AssurePackage.ASSUMPTION_RESULT__TARGET:
        setTarget((VerificationAssumption)newValue);
        return;
      case AssurePackage.ASSUMPTION_RESULT__MESSAGE:
        setMessage((String)newValue);
        return;
      case AssurePackage.ASSUMPTION_RESULT__VERIFICATION_ACTIVITY_RESULT:
        getVerificationActivityResult().clear();
        getVerificationActivityResult().addAll((Collection<? extends VerificationExpr>)newValue);
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
      case AssurePackage.ASSUMPTION_RESULT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AssurePackage.ASSUMPTION_RESULT__TARGET:
        setTarget((VerificationAssumption)null);
        return;
      case AssurePackage.ASSUMPTION_RESULT__MESSAGE:
        setMessage(MESSAGE_EDEFAULT);
        return;
      case AssurePackage.ASSUMPTION_RESULT__VERIFICATION_ACTIVITY_RESULT:
        getVerificationActivityResult().clear();
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
      case AssurePackage.ASSUMPTION_RESULT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AssurePackage.ASSUMPTION_RESULT__TARGET:
        return target != null;
      case AssurePackage.ASSUMPTION_RESULT__MESSAGE:
        return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
      case AssurePackage.ASSUMPTION_RESULT__VERIFICATION_ACTIVITY_RESULT:
        return verificationActivityResult != null && !verificationActivityResult.isEmpty();
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
    result.append(", message: ");
    result.append(message);
    result.append(')');
    return result.toString();
  }

} //AssumptionResultImpl
