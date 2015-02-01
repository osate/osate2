/**
 */
package org.osate.reqspec.reqSpec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.alisa.common.common.ConstantDecl;
import org.osate.alisa.common.common.PredicateExpression;

import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getAssert <em>Assert</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getGoalReference <em>Goal Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getException <em>Exception</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getExceptionText <em>Exception Text</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getRefinedReference <em>Refined Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getStakeholderRequirementReference <em>Stakeholder Requirement Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementImpl extends ContractualElementImpl implements Requirement
{
  /**
   * The cached value of the '{@link #getConstants() <em>Constants</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstants()
   * @generated
   * @ordered
   */
  protected EList<ConstantDecl> constants;

  /**
   * The cached value of the '{@link #getAssert() <em>Assert</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssert()
   * @generated
   * @ordered
   */
  protected PredicateExpression assert_;

  /**
   * The cached value of the '{@link #getGoalReference() <em>Goal Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGoalReference()
   * @generated
   * @ordered
   */
  protected EList<Goal> goalReference;

  /**
   * The cached value of the '{@link #getException() <em>Exception</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getException()
   * @generated
   * @ordered
   */
  protected EObject exception;

  /**
   * The default value of the '{@link #getExceptionText() <em>Exception Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptionText()
   * @generated
   * @ordered
   */
  protected static final String EXCEPTION_TEXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExceptionText() <em>Exception Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptionText()
   * @generated
   * @ordered
   */
  protected String exceptionText = EXCEPTION_TEXT_EDEFAULT;

  /**
   * The cached value of the '{@link #getRefinedReference() <em>Refined Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefinedReference()
   * @generated
   * @ordered
   */
  protected EList<Requirement> refinedReference;

  /**
   * The cached value of the '{@link #getStakeholderRequirementReference() <em>Stakeholder Requirement Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStakeholderRequirementReference()
   * @generated
   * @ordered
   */
  protected EList<Goal> stakeholderRequirementReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RequirementImpl()
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
    return ReqSpecPackage.Literals.REQUIREMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstantDecl> getConstants()
  {
    if (constants == null)
    {
      constants = new EObjectContainmentEList<ConstantDecl>(ConstantDecl.class, this, ReqSpecPackage.REQUIREMENT__CONSTANTS);
    }
    return constants;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PredicateExpression getAssert()
  {
    return assert_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssert(PredicateExpression newAssert, NotificationChain msgs)
  {
    PredicateExpression oldAssert = assert_;
    assert_ = newAssert;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQUIREMENT__ASSERT, oldAssert, newAssert);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssert(PredicateExpression newAssert)
  {
    if (newAssert != assert_)
    {
      NotificationChain msgs = null;
      if (assert_ != null)
        msgs = ((InternalEObject)assert_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.REQUIREMENT__ASSERT, null, msgs);
      if (newAssert != null)
        msgs = ((InternalEObject)newAssert).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.REQUIREMENT__ASSERT, null, msgs);
      msgs = basicSetAssert(newAssert, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQUIREMENT__ASSERT, newAssert, newAssert));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Goal> getGoalReference()
  {
    if (goalReference == null)
    {
      goalReference = new EObjectResolvingEList<Goal>(Goal.class, this, ReqSpecPackage.REQUIREMENT__GOAL_REFERENCE);
    }
    return goalReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getException()
  {
    if (exception != null && exception.eIsProxy())
    {
      InternalEObject oldException = (InternalEObject)exception;
      exception = eResolveProxy(oldException);
      if (exception != oldException)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.REQUIREMENT__EXCEPTION, oldException, exception));
      }
    }
    return exception;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetException()
  {
    return exception;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setException(EObject newException)
  {
    EObject oldException = exception;
    exception = newException;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQUIREMENT__EXCEPTION, oldException, exception));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExceptionText()
  {
    return exceptionText;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExceptionText(String newExceptionText)
  {
    String oldExceptionText = exceptionText;
    exceptionText = newExceptionText;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT, oldExceptionText, exceptionText));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Requirement> getRefinedReference()
  {
    if (refinedReference == null)
    {
      refinedReference = new EObjectResolvingEList<Requirement>(Requirement.class, this, ReqSpecPackage.REQUIREMENT__REFINED_REFERENCE);
    }
    return refinedReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Goal> getStakeholderRequirementReference()
  {
    if (stakeholderRequirementReference == null)
    {
      stakeholderRequirementReference = new EObjectResolvingEList<Goal>(Goal.class, this, ReqSpecPackage.REQUIREMENT__STAKEHOLDER_REQUIREMENT_REFERENCE);
    }
    return stakeholderRequirementReference;
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
      case ReqSpecPackage.REQUIREMENT__CONSTANTS:
        return ((InternalEList<?>)getConstants()).basicRemove(otherEnd, msgs);
      case ReqSpecPackage.REQUIREMENT__ASSERT:
        return basicSetAssert(null, msgs);
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
      case ReqSpecPackage.REQUIREMENT__CONSTANTS:
        return getConstants();
      case ReqSpecPackage.REQUIREMENT__ASSERT:
        return getAssert();
      case ReqSpecPackage.REQUIREMENT__GOAL_REFERENCE:
        return getGoalReference();
      case ReqSpecPackage.REQUIREMENT__EXCEPTION:
        if (resolve) return getException();
        return basicGetException();
      case ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT:
        return getExceptionText();
      case ReqSpecPackage.REQUIREMENT__REFINED_REFERENCE:
        return getRefinedReference();
      case ReqSpecPackage.REQUIREMENT__STAKEHOLDER_REQUIREMENT_REFERENCE:
        return getStakeholderRequirementReference();
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
      case ReqSpecPackage.REQUIREMENT__CONSTANTS:
        getConstants().clear();
        getConstants().addAll((Collection<? extends ConstantDecl>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__ASSERT:
        setAssert((PredicateExpression)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__GOAL_REFERENCE:
        getGoalReference().clear();
        getGoalReference().addAll((Collection<? extends Goal>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION:
        setException((EObject)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT:
        setExceptionText((String)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__REFINED_REFERENCE:
        getRefinedReference().clear();
        getRefinedReference().addAll((Collection<? extends Requirement>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__STAKEHOLDER_REQUIREMENT_REFERENCE:
        getStakeholderRequirementReference().clear();
        getStakeholderRequirementReference().addAll((Collection<? extends Goal>)newValue);
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
      case ReqSpecPackage.REQUIREMENT__CONSTANTS:
        getConstants().clear();
        return;
      case ReqSpecPackage.REQUIREMENT__ASSERT:
        setAssert((PredicateExpression)null);
        return;
      case ReqSpecPackage.REQUIREMENT__GOAL_REFERENCE:
        getGoalReference().clear();
        return;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION:
        setException((EObject)null);
        return;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT:
        setExceptionText(EXCEPTION_TEXT_EDEFAULT);
        return;
      case ReqSpecPackage.REQUIREMENT__REFINED_REFERENCE:
        getRefinedReference().clear();
        return;
      case ReqSpecPackage.REQUIREMENT__STAKEHOLDER_REQUIREMENT_REFERENCE:
        getStakeholderRequirementReference().clear();
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
      case ReqSpecPackage.REQUIREMENT__CONSTANTS:
        return constants != null && !constants.isEmpty();
      case ReqSpecPackage.REQUIREMENT__ASSERT:
        return assert_ != null;
      case ReqSpecPackage.REQUIREMENT__GOAL_REFERENCE:
        return goalReference != null && !goalReference.isEmpty();
      case ReqSpecPackage.REQUIREMENT__EXCEPTION:
        return exception != null;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT:
        return EXCEPTION_TEXT_EDEFAULT == null ? exceptionText != null : !EXCEPTION_TEXT_EDEFAULT.equals(exceptionText);
      case ReqSpecPackage.REQUIREMENT__REFINED_REFERENCE:
        return refinedReference != null && !refinedReference.isEmpty();
      case ReqSpecPackage.REQUIREMENT__STAKEHOLDER_REQUIREMENT_REFERENCE:
        return stakeholderRequirementReference != null && !stakeholderRequirementReference.isEmpty();
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
    result.append(" (exceptionText: ");
    result.append(exceptionText);
    result.append(')');
    return result.toString();
  }

} //RequirementImpl
