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

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.assure.VerificationResultState;
import org.osate.assure.assure.VerificationResultStatus;

import org.osate.verify.verify.VerificationActivity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getVerificationActivity <em>Verification Activity</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getState <em>State</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getAssumptionVerificationResult <em>Assumption Verification Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VerificationResultImpl extends AssuranceResultImpl implements VerificationResult
{
  /**
   * The cached value of the '{@link #getVerificationActivity() <em>Verification Activity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerificationActivity()
   * @generated
   * @ordered
   */
  protected VerificationActivity verificationActivity;

  /**
   * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected static final String TITLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected String title = TITLE_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDate()
   * @generated
   * @ordered
   */
  protected static final String DATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDate()
   * @generated
   * @ordered
   */
  protected String date = DATE_EDEFAULT;

  /**
   * The default value of the '{@link #getState() <em>State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected static final VerificationResultState STATE_EDEFAULT = VerificationResultState.TODO;

  /**
   * The cached value of the '{@link #getState() <em>State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected VerificationResultState state = STATE_EDEFAULT;

  /**
   * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatus()
   * @generated
   * @ordered
   */
  protected static final VerificationResultStatus STATUS_EDEFAULT = VerificationResultStatus.TBD;

  /**
   * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatus()
   * @generated
   * @ordered
   */
  protected VerificationResultStatus status = STATUS_EDEFAULT;

  /**
   * The cached value of the '{@link #getAssumptionVerificationResult() <em>Assumption Verification Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssumptionVerificationResult()
   * @generated
   * @ordered
   */
  protected EList<VerificationResult> assumptionVerificationResult;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VerificationResultImpl()
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
    return AssurePackage.Literals.VERIFICATION_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationActivity getVerificationActivity()
  {
    if (verificationActivity != null && verificationActivity.eIsProxy())
    {
      InternalEObject oldVerificationActivity = (InternalEObject)verificationActivity;
      verificationActivity = (VerificationActivity)eResolveProxy(oldVerificationActivity);
      if (verificationActivity != oldVerificationActivity)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.VERIFICATION_RESULT__VERIFICATION_ACTIVITY, oldVerificationActivity, verificationActivity));
      }
    }
    return verificationActivity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationActivity basicGetVerificationActivity()
  {
    return verificationActivity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVerificationActivity(VerificationActivity newVerificationActivity)
  {
    VerificationActivity oldVerificationActivity = verificationActivity;
    verificationActivity = newVerificationActivity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__VERIFICATION_ACTIVITY, oldVerificationActivity, verificationActivity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTitle(String newTitle)
  {
    String oldTitle = title;
    title = newTitle;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDate()
  {
    return date;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDate(String newDate)
  {
    String oldDate = date;
    date = newDate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__DATE, oldDate, date));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationResultState getState()
  {
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setState(VerificationResultState newState)
  {
    VerificationResultState oldState = state;
    state = newState == null ? STATE_EDEFAULT : newState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__STATE, oldState, state));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationResultStatus getStatus()
  {
    return status;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatus(VerificationResultStatus newStatus)
  {
    VerificationResultStatus oldStatus = status;
    status = newStatus == null ? STATUS_EDEFAULT : newStatus;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__STATUS, oldStatus, status));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationResult> getAssumptionVerificationResult()
  {
    if (assumptionVerificationResult == null)
    {
      assumptionVerificationResult = new EObjectContainmentEList<VerificationResult>(VerificationResult.class, this, AssurePackage.VERIFICATION_RESULT__ASSUMPTION_VERIFICATION_RESULT);
    }
    return assumptionVerificationResult;
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
      case AssurePackage.VERIFICATION_RESULT__ASSUMPTION_VERIFICATION_RESULT:
        return ((InternalEList<?>)getAssumptionVerificationResult()).basicRemove(otherEnd, msgs);
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
      case AssurePackage.VERIFICATION_RESULT__VERIFICATION_ACTIVITY:
        if (resolve) return getVerificationActivity();
        return basicGetVerificationActivity();
      case AssurePackage.VERIFICATION_RESULT__TITLE:
        return getTitle();
      case AssurePackage.VERIFICATION_RESULT__DESCRIPTION:
        return getDescription();
      case AssurePackage.VERIFICATION_RESULT__DATE:
        return getDate();
      case AssurePackage.VERIFICATION_RESULT__STATE:
        return getState();
      case AssurePackage.VERIFICATION_RESULT__STATUS:
        return getStatus();
      case AssurePackage.VERIFICATION_RESULT__ASSUMPTION_VERIFICATION_RESULT:
        return getAssumptionVerificationResult();
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
      case AssurePackage.VERIFICATION_RESULT__VERIFICATION_ACTIVITY:
        setVerificationActivity((VerificationActivity)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__TITLE:
        setTitle((String)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__DATE:
        setDate((String)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__STATE:
        setState((VerificationResultState)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__STATUS:
        setStatus((VerificationResultStatus)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__ASSUMPTION_VERIFICATION_RESULT:
        getAssumptionVerificationResult().clear();
        getAssumptionVerificationResult().addAll((Collection<? extends VerificationResult>)newValue);
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
      case AssurePackage.VERIFICATION_RESULT__VERIFICATION_ACTIVITY:
        setVerificationActivity((VerificationActivity)null);
        return;
      case AssurePackage.VERIFICATION_RESULT__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_RESULT__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_RESULT__DATE:
        setDate(DATE_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_RESULT__STATE:
        setState(STATE_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_RESULT__STATUS:
        setStatus(STATUS_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_RESULT__ASSUMPTION_VERIFICATION_RESULT:
        getAssumptionVerificationResult().clear();
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
      case AssurePackage.VERIFICATION_RESULT__VERIFICATION_ACTIVITY:
        return verificationActivity != null;
      case AssurePackage.VERIFICATION_RESULT__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case AssurePackage.VERIFICATION_RESULT__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case AssurePackage.VERIFICATION_RESULT__DATE:
        return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
      case AssurePackage.VERIFICATION_RESULT__STATE:
        return state != STATE_EDEFAULT;
      case AssurePackage.VERIFICATION_RESULT__STATUS:
        return status != STATUS_EDEFAULT;
      case AssurePackage.VERIFICATION_RESULT__ASSUMPTION_VERIFICATION_RESULT:
        return assumptionVerificationResult != null && !assumptionVerificationResult.isEmpty();
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
    result.append(" (title: ");
    result.append(title);
    result.append(", description: ");
    result.append(description);
    result.append(", date: ");
    result.append(date);
    result.append(", state: ");
    result.append(state);
    result.append(", status: ");
    result.append(status);
    result.append(')');
    return result.toString();
  }

} //VerificationResultImpl
