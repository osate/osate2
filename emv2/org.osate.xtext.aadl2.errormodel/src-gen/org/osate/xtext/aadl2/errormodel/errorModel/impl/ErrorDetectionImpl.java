/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.TriggerPort;

import org.osate.aadl2.impl.NamedElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorCodeValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Detection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorDetectionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorDetectionImpl#getTypeTokenConstraint <em>Type Token Constraint</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorDetectionImpl#isAllStates <em>All States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorDetectionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorDetectionImpl#getDetectionReportingPort <em>Detection Reporting Port</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorDetectionImpl#getErrorCode <em>Error Code</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorDetectionImpl extends NamedElementImpl implements ErrorDetection
{
  /**
   * The cached value of the '{@link #getState() <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected ErrorBehaviorState state;

  /**
   * The cached value of the '{@link #getTypeTokenConstraint() <em>Type Token Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeTokenConstraint()
   * @generated
   * @ordered
   */
  protected TypeSet typeTokenConstraint;

  /**
   * The default value of the '{@link #isAllStates() <em>All States</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllStates()
   * @generated
   * @ordered
   */
  protected static final boolean ALL_STATES_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAllStates() <em>All States</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllStates()
   * @generated
   * @ordered
   */
  protected boolean allStates = ALL_STATES_EDEFAULT;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected ConditionExpression condition;

  /**
   * The cached value of the '{@link #getDetectionReportingPort() <em>Detection Reporting Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDetectionReportingPort()
   * @generated
   * @ordered
   */
  protected TriggerPort detectionReportingPort;

  /**
   * The cached value of the '{@link #getErrorCode() <em>Error Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrorCode()
   * @generated
   * @ordered
   */
  protected ErrorCodeValue errorCode;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorDetectionImpl()
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
    return ErrorModelPackage.Literals.ERROR_DETECTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState getState()
  {
    if (state != null && state.eIsProxy())
    {
      InternalEObject oldState = (InternalEObject)state;
      state = (ErrorBehaviorState)eResolveProxy(oldState);
      if (state != oldState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_DETECTION__STATE, oldState, state));
      }
    }
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState basicGetState()
  {
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setState(ErrorBehaviorState newState)
  {
    ErrorBehaviorState oldState = state;
    state = newState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_DETECTION__STATE, oldState, state));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getTypeTokenConstraint()
  {
    return typeTokenConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeTokenConstraint(TypeSet newTypeTokenConstraint, NotificationChain msgs)
  {
    TypeSet oldTypeTokenConstraint = typeTokenConstraint;
    typeTokenConstraint = newTypeTokenConstraint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT, oldTypeTokenConstraint, newTypeTokenConstraint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeTokenConstraint(TypeSet newTypeTokenConstraint)
  {
    if (newTypeTokenConstraint != typeTokenConstraint)
    {
      NotificationChain msgs = null;
      if (typeTokenConstraint != null)
        msgs = ((InternalEObject)typeTokenConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT, null, msgs);
      if (newTypeTokenConstraint != null)
        msgs = ((InternalEObject)newTypeTokenConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT, null, msgs);
      msgs = basicSetTypeTokenConstraint(newTypeTokenConstraint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT, newTypeTokenConstraint, newTypeTokenConstraint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAllStates()
  {
    return allStates;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAllStates(boolean newAllStates)
  {
    boolean oldAllStates = allStates;
    allStates = newAllStates;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_DETECTION__ALL_STATES, oldAllStates, allStates));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionExpression getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(ConditionExpression newCondition, NotificationChain msgs)
  {
    ConditionExpression oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_DETECTION__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(ConditionExpression newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_DETECTION__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_DETECTION__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_DETECTION__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerPort getDetectionReportingPort()
  {
    if (detectionReportingPort != null && ((EObject)detectionReportingPort).eIsProxy())
    {
      InternalEObject oldDetectionReportingPort = (InternalEObject)detectionReportingPort;
      detectionReportingPort = (TriggerPort)eResolveProxy(oldDetectionReportingPort);
      if (detectionReportingPort != oldDetectionReportingPort)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_DETECTION__DETECTION_REPORTING_PORT, oldDetectionReportingPort, detectionReportingPort));
      }
    }
    return detectionReportingPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerPort basicGetDetectionReportingPort()
  {
    return detectionReportingPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDetectionReportingPort(TriggerPort newDetectionReportingPort)
  {
    TriggerPort oldDetectionReportingPort = detectionReportingPort;
    detectionReportingPort = newDetectionReportingPort;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_DETECTION__DETECTION_REPORTING_PORT, oldDetectionReportingPort, detectionReportingPort));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorCodeValue getErrorCode()
  {
    return errorCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetErrorCode(ErrorCodeValue newErrorCode, NotificationChain msgs)
  {
    ErrorCodeValue oldErrorCode = errorCode;
    errorCode = newErrorCode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_DETECTION__ERROR_CODE, oldErrorCode, newErrorCode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setErrorCode(ErrorCodeValue newErrorCode)
  {
    if (newErrorCode != errorCode)
    {
      NotificationChain msgs = null;
      if (errorCode != null)
        msgs = ((InternalEObject)errorCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_DETECTION__ERROR_CODE, null, msgs);
      if (newErrorCode != null)
        msgs = ((InternalEObject)newErrorCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_DETECTION__ERROR_CODE, null, msgs);
      msgs = basicSetErrorCode(newErrorCode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_DETECTION__ERROR_CODE, newErrorCode, newErrorCode));
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
      case ErrorModelPackage.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT:
        return basicSetTypeTokenConstraint(null, msgs);
      case ErrorModelPackage.ERROR_DETECTION__CONDITION:
        return basicSetCondition(null, msgs);
      case ErrorModelPackage.ERROR_DETECTION__ERROR_CODE:
        return basicSetErrorCode(null, msgs);
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
      case ErrorModelPackage.ERROR_DETECTION__STATE:
        if (resolve) return getState();
        return basicGetState();
      case ErrorModelPackage.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT:
        return getTypeTokenConstraint();
      case ErrorModelPackage.ERROR_DETECTION__ALL_STATES:
        return isAllStates();
      case ErrorModelPackage.ERROR_DETECTION__CONDITION:
        return getCondition();
      case ErrorModelPackage.ERROR_DETECTION__DETECTION_REPORTING_PORT:
        if (resolve) return getDetectionReportingPort();
        return basicGetDetectionReportingPort();
      case ErrorModelPackage.ERROR_DETECTION__ERROR_CODE:
        return getErrorCode();
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
      case ErrorModelPackage.ERROR_DETECTION__STATE:
        setState((ErrorBehaviorState)newValue);
        return;
      case ErrorModelPackage.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT:
        setTypeTokenConstraint((TypeSet)newValue);
        return;
      case ErrorModelPackage.ERROR_DETECTION__ALL_STATES:
        setAllStates((Boolean)newValue);
        return;
      case ErrorModelPackage.ERROR_DETECTION__CONDITION:
        setCondition((ConditionExpression)newValue);
        return;
      case ErrorModelPackage.ERROR_DETECTION__DETECTION_REPORTING_PORT:
        setDetectionReportingPort((TriggerPort)newValue);
        return;
      case ErrorModelPackage.ERROR_DETECTION__ERROR_CODE:
        setErrorCode((ErrorCodeValue)newValue);
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
      case ErrorModelPackage.ERROR_DETECTION__STATE:
        setState((ErrorBehaviorState)null);
        return;
      case ErrorModelPackage.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT:
        setTypeTokenConstraint((TypeSet)null);
        return;
      case ErrorModelPackage.ERROR_DETECTION__ALL_STATES:
        setAllStates(ALL_STATES_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_DETECTION__CONDITION:
        setCondition((ConditionExpression)null);
        return;
      case ErrorModelPackage.ERROR_DETECTION__DETECTION_REPORTING_PORT:
        setDetectionReportingPort((TriggerPort)null);
        return;
      case ErrorModelPackage.ERROR_DETECTION__ERROR_CODE:
        setErrorCode((ErrorCodeValue)null);
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
      case ErrorModelPackage.ERROR_DETECTION__STATE:
        return state != null;
      case ErrorModelPackage.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT:
        return typeTokenConstraint != null;
      case ErrorModelPackage.ERROR_DETECTION__ALL_STATES:
        return allStates != ALL_STATES_EDEFAULT;
      case ErrorModelPackage.ERROR_DETECTION__CONDITION:
        return condition != null;
      case ErrorModelPackage.ERROR_DETECTION__DETECTION_REPORTING_PORT:
        return detectionReportingPort != null;
      case ErrorModelPackage.ERROR_DETECTION__ERROR_CODE:
        return errorCode != null;
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (allStates: ");
    result.append(allStates);
    result.append(')');
    return result.toString();
  }

} //ErrorDetectionImpl
