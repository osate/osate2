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
package org.osate.verify.verify.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.verify.verify.ArgumentExpr;
import org.osate.verify.verify.ElseExpr;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Else Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.ElseExprImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.ElseExprImpl#getError <em>Error</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.ElseExprImpl#getFail <em>Fail</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.ElseExprImpl#getTimeout <em>Timeout</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElseExprImpl extends ArgumentExprImpl implements ElseExpr
{
  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected ArgumentExpr left;

  /**
   * The cached value of the '{@link #getError() <em>Error</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getError()
   * @generated
   * @ordered
   */
  protected ArgumentExpr error;

  /**
   * The cached value of the '{@link #getFail() <em>Fail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFail()
   * @generated
   * @ordered
   */
  protected ArgumentExpr fail;

  /**
   * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeout()
   * @generated
   * @ordered
   */
  protected ArgumentExpr timeout;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElseExprImpl()
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
    return VerifyPackage.Literals.ELSE_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArgumentExpr getLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeft(ArgumentExpr newLeft, NotificationChain msgs)
  {
    ArgumentExpr oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.ELSE_EXPR__LEFT, oldLeft, newLeft);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLeft(ArgumentExpr newLeft)
  {
    if (newLeft != left)
    {
      NotificationChain msgs = null;
      if (left != null)
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.ELSE_EXPR__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.ELSE_EXPR__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.ELSE_EXPR__LEFT, newLeft, newLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArgumentExpr getError()
  {
    return error;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetError(ArgumentExpr newError, NotificationChain msgs)
  {
    ArgumentExpr oldError = error;
    error = newError;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.ELSE_EXPR__ERROR, oldError, newError);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setError(ArgumentExpr newError)
  {
    if (newError != error)
    {
      NotificationChain msgs = null;
      if (error != null)
        msgs = ((InternalEObject)error).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.ELSE_EXPR__ERROR, null, msgs);
      if (newError != null)
        msgs = ((InternalEObject)newError).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.ELSE_EXPR__ERROR, null, msgs);
      msgs = basicSetError(newError, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.ELSE_EXPR__ERROR, newError, newError));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArgumentExpr getFail()
  {
    return fail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFail(ArgumentExpr newFail, NotificationChain msgs)
  {
    ArgumentExpr oldFail = fail;
    fail = newFail;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.ELSE_EXPR__FAIL, oldFail, newFail);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFail(ArgumentExpr newFail)
  {
    if (newFail != fail)
    {
      NotificationChain msgs = null;
      if (fail != null)
        msgs = ((InternalEObject)fail).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.ELSE_EXPR__FAIL, null, msgs);
      if (newFail != null)
        msgs = ((InternalEObject)newFail).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.ELSE_EXPR__FAIL, null, msgs);
      msgs = basicSetFail(newFail, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.ELSE_EXPR__FAIL, newFail, newFail));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArgumentExpr getTimeout()
  {
    return timeout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTimeout(ArgumentExpr newTimeout, NotificationChain msgs)
  {
    ArgumentExpr oldTimeout = timeout;
    timeout = newTimeout;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.ELSE_EXPR__TIMEOUT, oldTimeout, newTimeout);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTimeout(ArgumentExpr newTimeout)
  {
    if (newTimeout != timeout)
    {
      NotificationChain msgs = null;
      if (timeout != null)
        msgs = ((InternalEObject)timeout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.ELSE_EXPR__TIMEOUT, null, msgs);
      if (newTimeout != null)
        msgs = ((InternalEObject)newTimeout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.ELSE_EXPR__TIMEOUT, null, msgs);
      msgs = basicSetTimeout(newTimeout, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.ELSE_EXPR__TIMEOUT, newTimeout, newTimeout));
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
      case VerifyPackage.ELSE_EXPR__LEFT:
        return basicSetLeft(null, msgs);
      case VerifyPackage.ELSE_EXPR__ERROR:
        return basicSetError(null, msgs);
      case VerifyPackage.ELSE_EXPR__FAIL:
        return basicSetFail(null, msgs);
      case VerifyPackage.ELSE_EXPR__TIMEOUT:
        return basicSetTimeout(null, msgs);
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
      case VerifyPackage.ELSE_EXPR__LEFT:
        return getLeft();
      case VerifyPackage.ELSE_EXPR__ERROR:
        return getError();
      case VerifyPackage.ELSE_EXPR__FAIL:
        return getFail();
      case VerifyPackage.ELSE_EXPR__TIMEOUT:
        return getTimeout();
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
      case VerifyPackage.ELSE_EXPR__LEFT:
        setLeft((ArgumentExpr)newValue);
        return;
      case VerifyPackage.ELSE_EXPR__ERROR:
        setError((ArgumentExpr)newValue);
        return;
      case VerifyPackage.ELSE_EXPR__FAIL:
        setFail((ArgumentExpr)newValue);
        return;
      case VerifyPackage.ELSE_EXPR__TIMEOUT:
        setTimeout((ArgumentExpr)newValue);
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
      case VerifyPackage.ELSE_EXPR__LEFT:
        setLeft((ArgumentExpr)null);
        return;
      case VerifyPackage.ELSE_EXPR__ERROR:
        setError((ArgumentExpr)null);
        return;
      case VerifyPackage.ELSE_EXPR__FAIL:
        setFail((ArgumentExpr)null);
        return;
      case VerifyPackage.ELSE_EXPR__TIMEOUT:
        setTimeout((ArgumentExpr)null);
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
      case VerifyPackage.ELSE_EXPR__LEFT:
        return left != null;
      case VerifyPackage.ELSE_EXPR__ERROR:
        return error != null;
      case VerifyPackage.ELSE_EXPR__FAIL:
        return fail != null;
      case VerifyPackage.ELSE_EXPR__TIMEOUT:
        return timeout != null;
    }
    return super.eIsSet(featureID);
  }

} //ElseExprImpl
