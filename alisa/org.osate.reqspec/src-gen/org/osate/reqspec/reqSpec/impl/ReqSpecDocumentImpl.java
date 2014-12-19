/**
 */
package org.osate.reqspec.reqSpec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.ReqSpecDocument;
import org.osate.reqspec.reqSpec.ReqSpecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecDocumentImpl#getDocref <em>Docref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReqSpecDocumentImpl extends ReqSpecImpl implements ReqSpecDocument
{
  /**
   * The cached value of the '{@link #getDocref() <em>Docref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocref()
   * @generated
   * @ordered
   */
  protected ExternalDocument docref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReqSpecDocumentImpl()
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
    return ReqSpecPackage.Literals.REQ_SPEC_DOCUMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalDocument getDocref()
  {
    return docref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDocref(ExternalDocument newDocref, NotificationChain msgs)
  {
    ExternalDocument oldDocref = docref;
    docref = newDocref;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_SPEC_DOCUMENT__DOCREF, oldDocref, newDocref);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDocref(ExternalDocument newDocref)
  {
    if (newDocref != docref)
    {
      NotificationChain msgs = null;
      if (docref != null)
        msgs = ((InternalEObject)docref).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.REQ_SPEC_DOCUMENT__DOCREF, null, msgs);
      if (newDocref != null)
        msgs = ((InternalEObject)newDocref).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.REQ_SPEC_DOCUMENT__DOCREF, null, msgs);
      msgs = basicSetDocref(newDocref, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_SPEC_DOCUMENT__DOCREF, newDocref, newDocref));
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
      case ReqSpecPackage.REQ_SPEC_DOCUMENT__DOCREF:
        return basicSetDocref(null, msgs);
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
      case ReqSpecPackage.REQ_SPEC_DOCUMENT__DOCREF:
        return getDocref();
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
      case ReqSpecPackage.REQ_SPEC_DOCUMENT__DOCREF:
        setDocref((ExternalDocument)newValue);
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
      case ReqSpecPackage.REQ_SPEC_DOCUMENT__DOCREF:
        setDocref((ExternalDocument)null);
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
      case ReqSpecPackage.REQ_SPEC_DOCUMENT__DOCREF:
        return docref != null;
    }
    return super.eIsSet(featureID);
  }

} //ReqSpecDocumentImpl
