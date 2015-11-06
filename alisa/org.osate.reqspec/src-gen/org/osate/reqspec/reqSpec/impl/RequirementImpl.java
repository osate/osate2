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

import org.eclipse.xtext.xbase.XExpression;

import org.osate.organization.organization.Stakeholder;

import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.ReqPredicate;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getComputes <em>Computes</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getException <em>Exception</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getExceptionText <em>Exception Text</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getRefinesReference <em>Refines Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getDecomposesReference <em>Decomposes Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getDevelopmentStakeholder <em>Development Stakeholder</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getGoalReference <em>Goal Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.RequirementImpl#getStakeholderRequirementReference <em>Stakeholder Requirement Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequirementImpl extends ContractualElementImpl implements Requirement
{
  /**
   * The cached value of the '{@link #getComputes() <em>Computes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComputes()
   * @generated
   * @ordered
   */
  protected EList<XExpression> computes;

  /**
   * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPredicate()
   * @generated
   * @ordered
   */
  protected ReqPredicate predicate;

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
   * The cached value of the '{@link #getRefinesReference() <em>Refines Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefinesReference()
   * @generated
   * @ordered
   */
  protected EList<Requirement> refinesReference;

  /**
   * The cached value of the '{@link #getDecomposesReference() <em>Decomposes Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecomposesReference()
   * @generated
   * @ordered
   */
  protected EList<Requirement> decomposesReference;

  /**
   * The cached value of the '{@link #getDevelopmentStakeholder() <em>Development Stakeholder</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDevelopmentStakeholder()
   * @generated
   * @ordered
   */
  protected EList<Stakeholder> developmentStakeholder;

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
  public EList<XExpression> getComputes()
  {
    if (computes == null)
    {
      computes = new EObjectContainmentEList<XExpression>(XExpression.class, this, ReqSpecPackage.REQUIREMENT__COMPUTES);
    }
    return computes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqPredicate getPredicate()
  {
    return predicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPredicate(ReqPredicate newPredicate, NotificationChain msgs)
  {
    ReqPredicate oldPredicate = predicate;
    predicate = newPredicate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQUIREMENT__PREDICATE, oldPredicate, newPredicate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPredicate(ReqPredicate newPredicate)
  {
    if (newPredicate != predicate)
    {
      NotificationChain msgs = null;
      if (predicate != null)
        msgs = ((InternalEObject)predicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.REQUIREMENT__PREDICATE, null, msgs);
      if (newPredicate != null)
        msgs = ((InternalEObject)newPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.REQUIREMENT__PREDICATE, null, msgs);
      msgs = basicSetPredicate(newPredicate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQUIREMENT__PREDICATE, newPredicate, newPredicate));
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
  public EList<Requirement> getRefinesReference()
  {
    if (refinesReference == null)
    {
      refinesReference = new EObjectResolvingEList<Requirement>(Requirement.class, this, ReqSpecPackage.REQUIREMENT__REFINES_REFERENCE);
    }
    return refinesReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Requirement> getDecomposesReference()
  {
    if (decomposesReference == null)
    {
      decomposesReference = new EObjectResolvingEList<Requirement>(Requirement.class, this, ReqSpecPackage.REQUIREMENT__DECOMPOSES_REFERENCE);
    }
    return decomposesReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Stakeholder> getDevelopmentStakeholder()
  {
    if (developmentStakeholder == null)
    {
      developmentStakeholder = new EObjectResolvingEList<Stakeholder>(Stakeholder.class, this, ReqSpecPackage.REQUIREMENT__DEVELOPMENT_STAKEHOLDER);
    }
    return developmentStakeholder;
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
      case ReqSpecPackage.REQUIREMENT__COMPUTES:
        return ((InternalEList<?>)getComputes()).basicRemove(otherEnd, msgs);
      case ReqSpecPackage.REQUIREMENT__PREDICATE:
        return basicSetPredicate(null, msgs);
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
      case ReqSpecPackage.REQUIREMENT__COMPUTES:
        return getComputes();
      case ReqSpecPackage.REQUIREMENT__PREDICATE:
        return getPredicate();
      case ReqSpecPackage.REQUIREMENT__EXCEPTION:
        if (resolve) return getException();
        return basicGetException();
      case ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT:
        return getExceptionText();
      case ReqSpecPackage.REQUIREMENT__REFINES_REFERENCE:
        return getRefinesReference();
      case ReqSpecPackage.REQUIREMENT__DECOMPOSES_REFERENCE:
        return getDecomposesReference();
      case ReqSpecPackage.REQUIREMENT__DEVELOPMENT_STAKEHOLDER:
        return getDevelopmentStakeholder();
      case ReqSpecPackage.REQUIREMENT__GOAL_REFERENCE:
        return getGoalReference();
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
      case ReqSpecPackage.REQUIREMENT__COMPUTES:
        getComputes().clear();
        getComputes().addAll((Collection<? extends XExpression>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__PREDICATE:
        setPredicate((ReqPredicate)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION:
        setException((EObject)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT:
        setExceptionText((String)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__REFINES_REFERENCE:
        getRefinesReference().clear();
        getRefinesReference().addAll((Collection<? extends Requirement>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__DECOMPOSES_REFERENCE:
        getDecomposesReference().clear();
        getDecomposesReference().addAll((Collection<? extends Requirement>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__DEVELOPMENT_STAKEHOLDER:
        getDevelopmentStakeholder().clear();
        getDevelopmentStakeholder().addAll((Collection<? extends Stakeholder>)newValue);
        return;
      case ReqSpecPackage.REQUIREMENT__GOAL_REFERENCE:
        getGoalReference().clear();
        getGoalReference().addAll((Collection<? extends Goal>)newValue);
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
      case ReqSpecPackage.REQUIREMENT__COMPUTES:
        getComputes().clear();
        return;
      case ReqSpecPackage.REQUIREMENT__PREDICATE:
        setPredicate((ReqPredicate)null);
        return;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION:
        setException((EObject)null);
        return;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT:
        setExceptionText(EXCEPTION_TEXT_EDEFAULT);
        return;
      case ReqSpecPackage.REQUIREMENT__REFINES_REFERENCE:
        getRefinesReference().clear();
        return;
      case ReqSpecPackage.REQUIREMENT__DECOMPOSES_REFERENCE:
        getDecomposesReference().clear();
        return;
      case ReqSpecPackage.REQUIREMENT__DEVELOPMENT_STAKEHOLDER:
        getDevelopmentStakeholder().clear();
        return;
      case ReqSpecPackage.REQUIREMENT__GOAL_REFERENCE:
        getGoalReference().clear();
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
      case ReqSpecPackage.REQUIREMENT__COMPUTES:
        return computes != null && !computes.isEmpty();
      case ReqSpecPackage.REQUIREMENT__PREDICATE:
        return predicate != null;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION:
        return exception != null;
      case ReqSpecPackage.REQUIREMENT__EXCEPTION_TEXT:
        return EXCEPTION_TEXT_EDEFAULT == null ? exceptionText != null : !EXCEPTION_TEXT_EDEFAULT.equals(exceptionText);
      case ReqSpecPackage.REQUIREMENT__REFINES_REFERENCE:
        return refinesReference != null && !refinesReference.isEmpty();
      case ReqSpecPackage.REQUIREMENT__DECOMPOSES_REFERENCE:
        return decomposesReference != null && !decomposesReference.isEmpty();
      case ReqSpecPackage.REQUIREMENT__DEVELOPMENT_STAKEHOLDER:
        return developmentStakeholder != null && !developmentStakeholder.isEmpty();
      case ReqSpecPackage.REQUIREMENT__GOAL_REFERENCE:
        return goalReference != null && !goalReference.isEmpty();
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
