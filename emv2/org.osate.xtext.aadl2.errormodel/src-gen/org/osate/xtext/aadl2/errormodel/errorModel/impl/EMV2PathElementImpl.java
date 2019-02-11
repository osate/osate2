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

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMV2 Path Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PathElementImpl#getEmv2PropagationKind <em>Emv2 Propagation Kind</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PathElementImpl#getErrorType <em>Error Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PathElementImpl#getNamedElement <em>Named Element</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EMV2PathElementImpl#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EMV2PathElementImpl extends ElementImpl implements EMV2PathElement
{
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
   * The cached value of the '{@link #getNamedElement() <em>Named Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamedElement()
   * @generated
   * @ordered
   */
  protected NamedElement namedElement;

  /**
   * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPath()
   * @generated
   * @ordered
   */
  protected EMV2PathElement path;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EMV2PathElementImpl()
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
    return ErrorModelPackage.Literals.EMV2_PATH_ELEMENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH_ELEMENT__EMV2_PROPAGATION_KIND, oldEmv2PropagationKind, emv2PropagationKind));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.EMV2_PATH_ELEMENT__ERROR_TYPE, oldErrorType, errorType));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH_ELEMENT__ERROR_TYPE, oldErrorType, errorType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement getNamedElement()
  {
    if (namedElement != null && ((EObject)namedElement).eIsProxy())
    {
      InternalEObject oldNamedElement = (InternalEObject)namedElement;
      namedElement = (NamedElement)eResolveProxy(oldNamedElement);
      if (namedElement != oldNamedElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.EMV2_PATH_ELEMENT__NAMED_ELEMENT, oldNamedElement, namedElement));
      }
    }
    return namedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetNamedElement()
  {
    return namedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNamedElement(NamedElement newNamedElement)
  {
    NamedElement oldNamedElement = namedElement;
    namedElement = newNamedElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH_ELEMENT__NAMED_ELEMENT, oldNamedElement, namedElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMV2PathElement getPath()
  {
    return path;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPath(EMV2PathElement newPath, NotificationChain msgs)
  {
    EMV2PathElement oldPath = path;
    path = newPath;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH_ELEMENT__PATH, oldPath, newPath);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPath(EMV2PathElement newPath)
  {
    if (newPath != path)
    {
      NotificationChain msgs = null;
      if (path != null)
        msgs = ((InternalEObject)path).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.EMV2_PATH_ELEMENT__PATH, null, msgs);
      if (newPath != null)
        msgs = ((InternalEObject)newPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.EMV2_PATH_ELEMENT__PATH, null, msgs);
      msgs = basicSetPath(newPath, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.EMV2_PATH_ELEMENT__PATH, newPath, newPath));
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
      case ErrorModelPackage.EMV2_PATH_ELEMENT__PATH:
        return basicSetPath(null, msgs);
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
      case ErrorModelPackage.EMV2_PATH_ELEMENT__EMV2_PROPAGATION_KIND:
        return getEmv2PropagationKind();
      case ErrorModelPackage.EMV2_PATH_ELEMENT__ERROR_TYPE:
        if (resolve) return getErrorType();
        return basicGetErrorType();
      case ErrorModelPackage.EMV2_PATH_ELEMENT__NAMED_ELEMENT:
        if (resolve) return getNamedElement();
        return basicGetNamedElement();
      case ErrorModelPackage.EMV2_PATH_ELEMENT__PATH:
        return getPath();
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
      case ErrorModelPackage.EMV2_PATH_ELEMENT__EMV2_PROPAGATION_KIND:
        setEmv2PropagationKind((String)newValue);
        return;
      case ErrorModelPackage.EMV2_PATH_ELEMENT__ERROR_TYPE:
        setErrorType((ErrorTypes)newValue);
        return;
      case ErrorModelPackage.EMV2_PATH_ELEMENT__NAMED_ELEMENT:
        setNamedElement((NamedElement)newValue);
        return;
      case ErrorModelPackage.EMV2_PATH_ELEMENT__PATH:
        setPath((EMV2PathElement)newValue);
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
      case ErrorModelPackage.EMV2_PATH_ELEMENT__EMV2_PROPAGATION_KIND:
        setEmv2PropagationKind(EMV2_PROPAGATION_KIND_EDEFAULT);
        return;
      case ErrorModelPackage.EMV2_PATH_ELEMENT__ERROR_TYPE:
        setErrorType((ErrorTypes)null);
        return;
      case ErrorModelPackage.EMV2_PATH_ELEMENT__NAMED_ELEMENT:
        setNamedElement((NamedElement)null);
        return;
      case ErrorModelPackage.EMV2_PATH_ELEMENT__PATH:
        setPath((EMV2PathElement)null);
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
      case ErrorModelPackage.EMV2_PATH_ELEMENT__EMV2_PROPAGATION_KIND:
        return EMV2_PROPAGATION_KIND_EDEFAULT == null ? emv2PropagationKind != null : !EMV2_PROPAGATION_KIND_EDEFAULT.equals(emv2PropagationKind);
      case ErrorModelPackage.EMV2_PATH_ELEMENT__ERROR_TYPE:
        return errorType != null;
      case ErrorModelPackage.EMV2_PATH_ELEMENT__NAMED_ELEMENT:
        return namedElement != null;
      case ErrorModelPackage.EMV2_PATH_ELEMENT__PATH:
        return path != null;
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
    result.append(" (emv2PropagationKind: ");
    result.append(emv2PropagationKind);
    result.append(')');
    return result.toString();
  }

} //EMV2PathElementImpl
