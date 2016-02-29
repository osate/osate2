/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.ContainedNamedElement;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMV2 Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PathImpl#getContainmentPath <em>Containment Path</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PathImpl#getEmv2PropagationKind <em>Emv2 Propagation Kind</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PathImpl#getErrorType <em>Error Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PathImpl#getEmv2Target <em>Emv2 Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EMV2PathImpl extends ElementImpl implements EMV2Path
{
  /**
   * The cached value of the '{@link #getContainmentPath() <em>Containment Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContainmentPath()
   * @generated
   * @ordered
   */
  protected ContainedNamedElement containmentPath;

  /**
   * The default value of the '{@link #getEmv2PropagationKind() <em>Emv2 Propagation Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmv2PropagationKind()
   * @generated
   * @ordered
   */
  protected static final String EMV2_PROPAGATION_KIND_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEmv2PropagationKind() <em>Emv2 Propagation Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmv2PropagationKind()
   * @generated
   * @ordered
   */
  protected String emv2PropagationKind = EMV2_PROPAGATION_KIND_EDEFAULT;

  /**
   * The cached value of the '{@link #getErrorType() <em>Error Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrorType()
   * @generated
   * @ordered
   */
  protected ErrorTypes errorType;

  /**
   * The cached value of the '{@link #getEmv2Target() <em>Emv2 Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmv2Target()
   * @generated
   * @ordered
   */
  protected EMV2PathElement emv2Target;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EMV2PathImpl()
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
    return ErrorModelPackage.Literals.EMV2_PATH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContainedNamedElement getContainmentPath()
  {
    return containmentPath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContainmentPath(ContainedNamedElement newContainmentPath, NotificationChain msgs)
  {
    ContainedNamedElement oldContainmentPath = containmentPath;
    containmentPath = newContainmentPath;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH, oldContainmentPath, newContainmentPath);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContainmentPath(ContainedNamedElement newContainmentPath)
  {
    if (newContainmentPath != containmentPath)
    {
      NotificationChain msgs = null;
      if (containmentPath != null)
        msgs = ((InternalEObject)containmentPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH, null, msgs);
      if (newContainmentPath != null)
        msgs = ((InternalEObject)newContainmentPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH, null, msgs);
      msgs = basicSetContainmentPath(newContainmentPath, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH, newContainmentPath, newContainmentPath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEmv2PropagationKind()
  {
    return emv2PropagationKind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEmv2PropagationKind(String newEmv2PropagationKind)
  {
    String oldEmv2PropagationKind = emv2PropagationKind;
    emv2PropagationKind = newEmv2PropagationKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH__EMV2_PROPAGATION_KIND, oldEmv2PropagationKind, emv2PropagationKind));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorTypes getErrorType()
  {
    if (errorType != null && errorType.eIsProxy())
    {
      InternalEObject oldErrorType = (InternalEObject)errorType;
      errorType = (ErrorTypes)eResolveProxy(oldErrorType);
      if (errorType != oldErrorType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.EMV2_PATH__ERROR_TYPE, oldErrorType, errorType));
      }
    }
    return errorType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorTypes basicGetErrorType()
  {
    return errorType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setErrorType(ErrorTypes newErrorType)
  {
    ErrorTypes oldErrorType = errorType;
    errorType = newErrorType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH__ERROR_TYPE, oldErrorType, errorType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMV2PathElement getEmv2Target()
  {
    return emv2Target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEmv2Target(EMV2PathElement newEmv2Target, NotificationChain msgs)
  {
    EMV2PathElement oldEmv2Target = emv2Target;
    emv2Target = newEmv2Target;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH__EMV2_TARGET, oldEmv2Target, newEmv2Target);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEmv2Target(EMV2PathElement newEmv2Target)
  {
    if (newEmv2Target != emv2Target)
    {
      NotificationChain msgs = null;
      if (emv2Target != null)
        msgs = ((InternalEObject)emv2Target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.EMV2_PATH__EMV2_TARGET, null, msgs);
      if (newEmv2Target != null)
        msgs = ((InternalEObject)newEmv2Target).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.EMV2_PATH__EMV2_TARGET, null, msgs);
      msgs = basicSetEmv2Target(newEmv2Target, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH__EMV2_TARGET, newEmv2Target, newEmv2Target));
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
      case ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH:
        return basicSetContainmentPath(null, msgs);
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        return basicSetEmv2Target(null, msgs);
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
      case ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH:
        return getContainmentPath();
      case ErrorModelPackage.EMV2_PATH__EMV2_PROPAGATION_KIND:
        return getEmv2PropagationKind();
      case ErrorModelPackage.EMV2_PATH__ERROR_TYPE:
        if (resolve) return getErrorType();
        return basicGetErrorType();
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        return getEmv2Target();
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
      case ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH:
        setContainmentPath((ContainedNamedElement)newValue);
        return;
      case ErrorModelPackage.EMV2_PATH__EMV2_PROPAGATION_KIND:
        setEmv2PropagationKind((String)newValue);
        return;
      case ErrorModelPackage.EMV2_PATH__ERROR_TYPE:
        setErrorType((ErrorTypes)newValue);
        return;
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        setEmv2Target((EMV2PathElement)newValue);
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
      case ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH:
        setContainmentPath((ContainedNamedElement)null);
        return;
      case ErrorModelPackage.EMV2_PATH__EMV2_PROPAGATION_KIND:
        setEmv2PropagationKind(EMV2_PROPAGATION_KIND_EDEFAULT);
        return;
      case ErrorModelPackage.EMV2_PATH__ERROR_TYPE:
        setErrorType((ErrorTypes)null);
        return;
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        setEmv2Target((EMV2PathElement)null);
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
      case ErrorModelPackage.EMV2_PATH__CONTAINMENT_PATH:
        return containmentPath != null;
      case ErrorModelPackage.EMV2_PATH__EMV2_PROPAGATION_KIND:
        return EMV2_PROPAGATION_KIND_EDEFAULT == null ? emv2PropagationKind != null : !EMV2_PROPAGATION_KIND_EDEFAULT.equals(emv2PropagationKind);
      case ErrorModelPackage.EMV2_PATH__ERROR_TYPE:
        return errorType != null;
      case ErrorModelPackage.EMV2_PATH__EMV2_TARGET:
        return emv2Target != null;
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
    result.append(" (emv2PropagationKind: ");
    result.append(emv2PropagationKind);
    result.append(')');
    return result.toString();
  }

} //EMV2PathImpl
