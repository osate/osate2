/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#isAllOutgoing <em>All Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#getFailureModeReference <em>Failure Mode Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#getFailureModeType <em>Failure Mode Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#getFailureModeDescription <em>Failure Mode Description</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorSourceImpl extends ErrorFlowImpl implements ErrorSource
{
  /**
   * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoing()
   * @generated
   * @ordered
   */
  protected ErrorPropagation outgoing;

  /**
   * The default value of the '{@link #isAllOutgoing() <em>All Outgoing</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllOutgoing()
   * @generated
   * @ordered
   */
  protected static final boolean ALL_OUTGOING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAllOutgoing() <em>All Outgoing</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllOutgoing()
   * @generated
   * @ordered
   */
  protected boolean allOutgoing = ALL_OUTGOING_EDEFAULT;

  /**
   * The cached value of the '{@link #getFailureModeReference() <em>Failure Mode Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailureModeReference()
   * @generated
   * @ordered
   */
  protected ErrorBehaviorState failureModeReference;

  /**
   * The cached value of the '{@link #getFailureModeType() <em>Failure Mode Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailureModeType()
   * @generated
   * @ordered
   */
  protected TypeSet failureModeType;

  /**
   * The default value of the '{@link #getFailureModeDescription() <em>Failure Mode Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailureModeDescription()
   * @generated
   * @ordered
   */
  protected static final String FAILURE_MODE_DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFailureModeDescription() <em>Failure Mode Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailureModeDescription()
   * @generated
   * @ordered
   */
  protected String failureModeDescription = FAILURE_MODE_DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected static final String CONDITION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected String condition = CONDITION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorSourceImpl()
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
    return ErrorModelPackage.Literals.ERROR_SOURCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagation getOutgoing()
  {
    if (outgoing != null && outgoing.eIsProxy())
    {
      InternalEObject oldOutgoing = (InternalEObject)outgoing;
      outgoing = (ErrorPropagation)eResolveProxy(oldOutgoing);
      if (outgoing != oldOutgoing)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_SOURCE__OUTGOING, oldOutgoing, outgoing));
      }
    }
    return outgoing;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagation basicGetOutgoing()
  {
    return outgoing;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutgoing(ErrorPropagation newOutgoing)
  {
    ErrorPropagation oldOutgoing = outgoing;
    outgoing = newOutgoing;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__OUTGOING, oldOutgoing, outgoing));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAllOutgoing()
  {
    return allOutgoing;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAllOutgoing(boolean newAllOutgoing)
  {
    boolean oldAllOutgoing = allOutgoing;
    allOutgoing = newAllOutgoing;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__ALL_OUTGOING, oldAllOutgoing, allOutgoing));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState getFailureModeReference()
  {
    if (failureModeReference != null && failureModeReference.eIsProxy())
    {
      InternalEObject oldFailureModeReference = (InternalEObject)failureModeReference;
      failureModeReference = (ErrorBehaviorState)eResolveProxy(oldFailureModeReference);
      if (failureModeReference != oldFailureModeReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE, oldFailureModeReference, failureModeReference));
      }
    }
    return failureModeReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState basicGetFailureModeReference()
  {
    return failureModeReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFailureModeReference(ErrorBehaviorState newFailureModeReference)
  {
    ErrorBehaviorState oldFailureModeReference = failureModeReference;
    failureModeReference = newFailureModeReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE, oldFailureModeReference, failureModeReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getFailureModeType()
  {
    return failureModeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFailureModeType(TypeSet newFailureModeType, NotificationChain msgs)
  {
    TypeSet oldFailureModeType = failureModeType;
    failureModeType = newFailureModeType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE, oldFailureModeType, newFailureModeType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFailureModeType(TypeSet newFailureModeType)
  {
    if (newFailureModeType != failureModeType)
    {
      NotificationChain msgs = null;
      if (failureModeType != null)
        msgs = ((InternalEObject)failureModeType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE, null, msgs);
      if (newFailureModeType != null)
        msgs = ((InternalEObject)newFailureModeType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE, null, msgs);
      msgs = basicSetFailureModeType(newFailureModeType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE, newFailureModeType, newFailureModeType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFailureModeDescription()
  {
    return failureModeDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFailureModeDescription(String newFailureModeDescription)
  {
    String oldFailureModeDescription = failureModeDescription;
    failureModeDescription = newFailureModeDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_DESCRIPTION, oldFailureModeDescription, failureModeDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(String newCondition)
  {
    String oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__CONDITION, oldCondition, condition));
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
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE:
        return basicSetFailureModeType(null, msgs);
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
      case ErrorModelPackage.ERROR_SOURCE__OUTGOING:
        if (resolve) return getOutgoing();
        return basicGetOutgoing();
      case ErrorModelPackage.ERROR_SOURCE__ALL_OUTGOING:
        return isAllOutgoing();
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE:
        if (resolve) return getFailureModeReference();
        return basicGetFailureModeReference();
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE:
        return getFailureModeType();
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_DESCRIPTION:
        return getFailureModeDescription();
      case ErrorModelPackage.ERROR_SOURCE__CONDITION:
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
      case ErrorModelPackage.ERROR_SOURCE__OUTGOING:
        setOutgoing((ErrorPropagation)newValue);
        return;
      case ErrorModelPackage.ERROR_SOURCE__ALL_OUTGOING:
        setAllOutgoing((Boolean)newValue);
        return;
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE:
        setFailureModeReference((ErrorBehaviorState)newValue);
        return;
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE:
        setFailureModeType((TypeSet)newValue);
        return;
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_DESCRIPTION:
        setFailureModeDescription((String)newValue);
        return;
      case ErrorModelPackage.ERROR_SOURCE__CONDITION:
        setCondition((String)newValue);
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
      case ErrorModelPackage.ERROR_SOURCE__OUTGOING:
        setOutgoing((ErrorPropagation)null);
        return;
      case ErrorModelPackage.ERROR_SOURCE__ALL_OUTGOING:
        setAllOutgoing(ALL_OUTGOING_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE:
        setFailureModeReference((ErrorBehaviorState)null);
        return;
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE:
        setFailureModeType((TypeSet)null);
        return;
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_DESCRIPTION:
        setFailureModeDescription(FAILURE_MODE_DESCRIPTION_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_SOURCE__CONDITION:
        setCondition(CONDITION_EDEFAULT);
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
      case ErrorModelPackage.ERROR_SOURCE__OUTGOING:
        return outgoing != null;
      case ErrorModelPackage.ERROR_SOURCE__ALL_OUTGOING:
        return allOutgoing != ALL_OUTGOING_EDEFAULT;
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE:
        return failureModeReference != null;
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE:
        return failureModeType != null;
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_DESCRIPTION:
        return FAILURE_MODE_DESCRIPTION_EDEFAULT == null ? failureModeDescription != null : !FAILURE_MODE_DESCRIPTION_EDEFAULT.equals(failureModeDescription);
      case ErrorModelPackage.ERROR_SOURCE__CONDITION:
        return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
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
    result.append(" (allOutgoing: ");
    result.append(allOutgoing);
    result.append(", failureModeDescription: ");
    result.append(failureModeDescription);
    result.append(", condition: ");
    result.append(condition);
    result.append(')');
    return result.toString();
  }

} //ErrorSourceImpl
