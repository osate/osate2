/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Propagation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.QualifiedPropagationPointImpl#getSubcomponents <em>Subcomponents</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.QualifiedPropagationPointImpl#getPropagationPoint <em>Propagation Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualifiedPropagationPointImpl extends ElementImpl implements QualifiedPropagationPoint
{
  /**
   * The cached value of the '{@link #getSubcomponents() <em>Subcomponents</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubcomponents()
   * @generated
   * @ordered
   */
  protected EList<SubcomponentElement> subcomponents;

  /**
   * The cached value of the '{@link #getPropagationPoint() <em>Propagation Point</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropagationPoint()
   * @generated
   * @ordered
   */
  protected PropagationPoint propagationPoint;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualifiedPropagationPointImpl()
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
    return ErrorModelPackage.Literals.QUALIFIED_PROPAGATION_POINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SubcomponentElement> getSubcomponents()
  {
    if (subcomponents == null)
    {
      subcomponents = new EObjectContainmentEList<SubcomponentElement>(SubcomponentElement.class, this, ErrorModelPackage.QUALIFIED_PROPAGATION_POINT__SUBCOMPONENTS);
    }
    return subcomponents;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropagationPoint getPropagationPoint()
  {
    if (propagationPoint != null && propagationPoint.eIsProxy())
    {
      InternalEObject oldPropagationPoint = (InternalEObject)propagationPoint;
      propagationPoint = (PropagationPoint)eResolveProxy(oldPropagationPoint);
      if (propagationPoint != oldPropagationPoint)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.QUALIFIED_PROPAGATION_POINT__PROPAGATION_POINT, oldPropagationPoint, propagationPoint));
      }
    }
    return propagationPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropagationPoint basicGetPropagationPoint()
  {
    return propagationPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPropagationPoint(PropagationPoint newPropagationPoint)
  {
    PropagationPoint oldPropagationPoint = propagationPoint;
    propagationPoint = newPropagationPoint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.QUALIFIED_PROPAGATION_POINT__PROPAGATION_POINT, oldPropagationPoint, propagationPoint));
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
      case ErrorModelPackage.QUALIFIED_PROPAGATION_POINT__SUBCOMPONENTS:
        return ((InternalEList<?>)getSubcomponents()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.QUALIFIED_PROPAGATION_POINT__SUBCOMPONENTS:
        return getSubcomponents();
      case ErrorModelPackage.QUALIFIED_PROPAGATION_POINT__PROPAGATION_POINT:
        if (resolve) return getPropagationPoint();
        return basicGetPropagationPoint();
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
      case ErrorModelPackage.QUALIFIED_PROPAGATION_POINT__SUBCOMPONENTS:
        getSubcomponents().clear();
        getSubcomponents().addAll((Collection<? extends SubcomponentElement>)newValue);
        return;
      case ErrorModelPackage.QUALIFIED_PROPAGATION_POINT__PROPAGATION_POINT:
        setPropagationPoint((PropagationPoint)newValue);
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
      case ErrorModelPackage.QUALIFIED_PROPAGATION_POINT__SUBCOMPONENTS:
        getSubcomponents().clear();
        return;
      case ErrorModelPackage.QUALIFIED_PROPAGATION_POINT__PROPAGATION_POINT:
        setPropagationPoint((PropagationPoint)null);
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
      case ErrorModelPackage.QUALIFIED_PROPAGATION_POINT__SUBCOMPONENTS:
        return subcomponents != null && !subcomponents.isEmpty();
      case ErrorModelPackage.QUALIFIED_PROPAGATION_POINT__PROPAGATION_POINT:
        return propagationPoint != null;
    }
    return super.eIsSet(featureID);
  }

} //QualifiedPropagationPointImpl
