/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.NamedElement;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
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
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#getSourceModelElement <em>Source Model Element</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#isAll <em>All</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#getFailureModeReference <em>Failure Mode Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#getFailureModeType <em>Failure Mode Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#getFailureModeDescription <em>Failure Mode Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorSourceImpl extends ErrorFlowImpl implements ErrorSource
{
  /**
   * The cached value of the '{@link #getSourceModelElement() <em>Source Model Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceModelElement()
   * @generated
   * @ordered
   */
  protected NamedElement sourceModelElement;

  /**
   * The default value of the '{@link #isAll() <em>All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAll()
   * @generated
   * @ordered
   */
  protected static final boolean ALL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAll() <em>All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAll()
   * @generated
   * @ordered
   */
  protected boolean all = ALL_EDEFAULT;

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
  public NamedElement getSourceModelElement()
  {
    if (sourceModelElement != null && ((EObject)sourceModelElement).eIsProxy())
    {
      InternalEObject oldSourceModelElement = (InternalEObject)sourceModelElement;
      sourceModelElement = (NamedElement)eResolveProxy(oldSourceModelElement);
      if (sourceModelElement != oldSourceModelElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_SOURCE__SOURCE_MODEL_ELEMENT, oldSourceModelElement, sourceModelElement));
      }
    }
    return sourceModelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetSourceModelElement()
  {
    return sourceModelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSourceModelElement(NamedElement newSourceModelElement)
  {
    NamedElement oldSourceModelElement = sourceModelElement;
    sourceModelElement = newSourceModelElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__SOURCE_MODEL_ELEMENT, oldSourceModelElement, sourceModelElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAll()
  {
    return all;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAll(boolean newAll)
  {
    boolean oldAll = all;
    all = newAll;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__ALL, oldAll, all));
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
      case ErrorModelPackage.ERROR_SOURCE__SOURCE_MODEL_ELEMENT:
        if (resolve) return getSourceModelElement();
        return basicGetSourceModelElement();
      case ErrorModelPackage.ERROR_SOURCE__ALL:
        return isAll();
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE:
        if (resolve) return getFailureModeReference();
        return basicGetFailureModeReference();
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE:
        return getFailureModeType();
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_DESCRIPTION:
        return getFailureModeDescription();
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
      case ErrorModelPackage.ERROR_SOURCE__SOURCE_MODEL_ELEMENT:
        setSourceModelElement((NamedElement)newValue);
        return;
      case ErrorModelPackage.ERROR_SOURCE__ALL:
        setAll((Boolean)newValue);
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
      case ErrorModelPackage.ERROR_SOURCE__SOURCE_MODEL_ELEMENT:
        setSourceModelElement((NamedElement)null);
        return;
      case ErrorModelPackage.ERROR_SOURCE__ALL:
        setAll(ALL_EDEFAULT);
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
      case ErrorModelPackage.ERROR_SOURCE__SOURCE_MODEL_ELEMENT:
        return sourceModelElement != null;
      case ErrorModelPackage.ERROR_SOURCE__ALL:
        return all != ALL_EDEFAULT;
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE:
        return failureModeReference != null;
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE:
        return failureModeType != null;
      case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_DESCRIPTION:
        return FAILURE_MODE_DESCRIPTION_EDEFAULT == null ? failureModeDescription != null : !FAILURE_MODE_DESCRIPTION_EDEFAULT.equals(failureModeDescription);
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
    result.append(" (all: ");
    result.append(all);
    result.append(", failureModeDescription: ");
    result.append(failureModeDescription);
    result.append(')');
    return result.toString();
  }

} //ErrorSourceImpl
