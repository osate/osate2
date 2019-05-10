/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.reqspec.reqSpec.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.ReqSpecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ExternalDocumentImpl#getDocReference <em>Doc Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ExternalDocumentImpl#getDocFragment <em>Doc Fragment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExternalDocumentImpl extends MinimalEObjectImpl.Container implements ExternalDocument
{
  /**
   * The default value of the '{@link #getDocReference() <em>Doc Reference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocReference()
   * @generated
   * @ordered
   */
  protected static final String DOC_REFERENCE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDocReference() <em>Doc Reference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocReference()
   * @generated
   * @ordered
   */
  protected String docReference = DOC_REFERENCE_EDEFAULT;

  /**
   * The default value of the '{@link #getDocFragment() <em>Doc Fragment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocFragment()
   * @generated
   * @ordered
   */
  protected static final String DOC_FRAGMENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDocFragment() <em>Doc Fragment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocFragment()
   * @generated
   * @ordered
   */
  protected String docFragment = DOC_FRAGMENT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExternalDocumentImpl()
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
    return ReqSpecPackage.Literals.EXTERNAL_DOCUMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDocReference()
  {
    return docReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDocReference(String newDocReference)
  {
    String oldDocReference = docReference;
    docReference = newDocReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.EXTERNAL_DOCUMENT__DOC_REFERENCE, oldDocReference, docReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDocFragment()
  {
    return docFragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDocFragment(String newDocFragment)
  {
    String oldDocFragment = docFragment;
    docFragment = newDocFragment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.EXTERNAL_DOCUMENT__DOC_FRAGMENT, oldDocFragment, docFragment));
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
      case ReqSpecPackage.EXTERNAL_DOCUMENT__DOC_REFERENCE:
        return getDocReference();
      case ReqSpecPackage.EXTERNAL_DOCUMENT__DOC_FRAGMENT:
        return getDocFragment();
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
      case ReqSpecPackage.EXTERNAL_DOCUMENT__DOC_REFERENCE:
        setDocReference((String)newValue);
        return;
      case ReqSpecPackage.EXTERNAL_DOCUMENT__DOC_FRAGMENT:
        setDocFragment((String)newValue);
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
      case ReqSpecPackage.EXTERNAL_DOCUMENT__DOC_REFERENCE:
        setDocReference(DOC_REFERENCE_EDEFAULT);
        return;
      case ReqSpecPackage.EXTERNAL_DOCUMENT__DOC_FRAGMENT:
        setDocFragment(DOC_FRAGMENT_EDEFAULT);
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
      case ReqSpecPackage.EXTERNAL_DOCUMENT__DOC_REFERENCE:
        return DOC_REFERENCE_EDEFAULT == null ? docReference != null : !DOC_REFERENCE_EDEFAULT.equals(docReference);
      case ReqSpecPackage.EXTERNAL_DOCUMENT__DOC_FRAGMENT:
        return DOC_FRAGMENT_EDEFAULT == null ? docFragment != null : !DOC_FRAGMENT_EDEFAULT.equals(docFragment);
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
    result.append(" (docReference: ");
    result.append(docReference);
    result.append(", docFragment: ");
    result.append(docFragment);
    result.append(')');
    return result.toString();
  }

} //ExternalDocumentImpl
