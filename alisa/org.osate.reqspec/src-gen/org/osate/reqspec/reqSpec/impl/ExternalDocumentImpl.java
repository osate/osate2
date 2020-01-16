/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
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
