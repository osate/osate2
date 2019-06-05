/**
 */
package org.osate.expr.expr.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.NamedElement;

import org.osate.expr.expr.ExprPackage;
import org.osate.expr.expr.Expression;
import org.osate.expr.expr.Selection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.impl.SelectionImpl#getReceiver <em>Receiver</em>}</li>
 *   <li>{@link org.osate.expr.expr.impl.SelectionImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.osate.expr.expr.impl.SelectionImpl#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SelectionImpl extends ExpressionImpl implements Selection
{
  /**
   * The cached value of the '{@link #getReceiver() <em>Receiver</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReceiver()
   * @generated
   * @ordered
   */
  protected Expression receiver;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected NamedElement ref;

  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected EList<Expression> args;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SelectionImpl()
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
    return ExprPackage.Literals.SELECTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getReceiver()
  {
    return receiver;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReceiver(Expression newReceiver, NotificationChain msgs)
  {
    Expression oldReceiver = receiver;
    receiver = newReceiver;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExprPackage.SELECTION__RECEIVER, oldReceiver, newReceiver);
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
  public void setReceiver(Expression newReceiver)
  {
    if (newReceiver != receiver)
    {
      NotificationChain msgs = null;
      if (receiver != null)
        msgs = ((InternalEObject)receiver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExprPackage.SELECTION__RECEIVER, null, msgs);
      if (newReceiver != null)
        msgs = ((InternalEObject)newReceiver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExprPackage.SELECTION__RECEIVER, null, msgs);
      msgs = basicSetReceiver(newReceiver, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.SELECTION__RECEIVER, newReceiver, newReceiver));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamedElement getRef()
  {
    if (ref != null && ((EObject)ref).eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (NamedElement)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExprPackage.SELECTION__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRef(NamedElement newRef)
  {
    NamedElement oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.SELECTION__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Expression> getArgs()
  {
    if (args == null)
    {
      args = new EObjectContainmentEList<Expression>(Expression.class, this, ExprPackage.SELECTION__ARGS);
    }
    return args;
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
      case ExprPackage.SELECTION__RECEIVER:
        return basicSetReceiver(null, msgs);
      case ExprPackage.SELECTION__ARGS:
        return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
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
      case ExprPackage.SELECTION__RECEIVER:
        return getReceiver();
      case ExprPackage.SELECTION__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case ExprPackage.SELECTION__ARGS:
        return getArgs();
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
      case ExprPackage.SELECTION__RECEIVER:
        setReceiver((Expression)newValue);
        return;
      case ExprPackage.SELECTION__REF:
        setRef((NamedElement)newValue);
        return;
      case ExprPackage.SELECTION__ARGS:
        getArgs().clear();
        getArgs().addAll((Collection<? extends Expression>)newValue);
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
      case ExprPackage.SELECTION__RECEIVER:
        setReceiver((Expression)null);
        return;
      case ExprPackage.SELECTION__REF:
        setRef((NamedElement)null);
        return;
      case ExprPackage.SELECTION__ARGS:
        getArgs().clear();
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
      case ExprPackage.SELECTION__RECEIVER:
        return receiver != null;
      case ExprPackage.SELECTION__REF:
        return ref != null;
      case ExprPackage.SELECTION__ARGS:
        return args != null && !args.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SelectionImpl
