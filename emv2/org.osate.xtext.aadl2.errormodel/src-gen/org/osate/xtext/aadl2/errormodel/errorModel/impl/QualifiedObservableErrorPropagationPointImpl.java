/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.Subcomponent;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedObservableErrorPropagationPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Observable Error Propagation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.QualifiedObservableErrorPropagationPointImpl#getSubcomponent <em>Subcomponent</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.QualifiedObservableErrorPropagationPointImpl#getObservablePoint <em>Observable Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualifiedObservableErrorPropagationPointImpl extends ElementImpl implements QualifiedObservableErrorPropagationPoint
{
  /**
	 * The cached value of the '{@link #getSubcomponent() <em>Subcomponent</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSubcomponent()
	 * @generated
	 * @ordered
	 */
  protected Subcomponent subcomponent;

  /**
	 * The cached value of the '{@link #getObservablePoint() <em>Observable Point</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getObservablePoint()
	 * @generated
	 * @ordered
	 */
  protected ErrorPropagation observablePoint;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected QualifiedObservableErrorPropagationPointImpl()
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
		return ErrorModelPackage.Literals.QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Subcomponent getSubcomponent()
  {
		if (subcomponent != null && ((EObject)subcomponent).eIsProxy()) {
			InternalEObject oldSubcomponent = (InternalEObject)subcomponent;
			subcomponent = (Subcomponent)eResolveProxy(oldSubcomponent);
			if (subcomponent != oldSubcomponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__SUBCOMPONENT, oldSubcomponent, subcomponent));
			}
		}
		return subcomponent;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Subcomponent basicGetSubcomponent()
  {
		return subcomponent;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSubcomponent(Subcomponent newSubcomponent)
  {
		Subcomponent oldSubcomponent = subcomponent;
		subcomponent = newSubcomponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__SUBCOMPONENT, oldSubcomponent, subcomponent));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorPropagation getObservablePoint()
  {
		if (observablePoint != null && observablePoint.eIsProxy()) {
			InternalEObject oldObservablePoint = (InternalEObject)observablePoint;
			observablePoint = (ErrorPropagation)eResolveProxy(oldObservablePoint);
			if (observablePoint != oldObservablePoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__OBSERVABLE_POINT, oldObservablePoint, observablePoint));
			}
		}
		return observablePoint;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorPropagation basicGetObservablePoint()
  {
		return observablePoint;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setObservablePoint(ErrorPropagation newObservablePoint)
  {
		ErrorPropagation oldObservablePoint = observablePoint;
		observablePoint = newObservablePoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__OBSERVABLE_POINT, oldObservablePoint, observablePoint));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case ErrorModelPackage.QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__SUBCOMPONENT:
				if (resolve) return getSubcomponent();
				return basicGetSubcomponent();
			case ErrorModelPackage.QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__OBSERVABLE_POINT:
				if (resolve) return getObservablePoint();
				return basicGetObservablePoint();
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
		switch (featureID) {
			case ErrorModelPackage.QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__SUBCOMPONENT:
				setSubcomponent((Subcomponent)newValue);
				return;
			case ErrorModelPackage.QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__OBSERVABLE_POINT:
				setObservablePoint((ErrorPropagation)newValue);
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
		switch (featureID) {
			case ErrorModelPackage.QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__SUBCOMPONENT:
				setSubcomponent((Subcomponent)null);
				return;
			case ErrorModelPackage.QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__OBSERVABLE_POINT:
				setObservablePoint((ErrorPropagation)null);
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
		switch (featureID) {
			case ErrorModelPackage.QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__SUBCOMPONENT:
				return subcomponent != null;
			case ErrorModelPackage.QUALIFIED_OBSERVABLE_ERROR_PROPAGATION_POINT__OBSERVABLE_POINT:
				return observablePoint != null;
		}
		return super.eIsSet(featureID);
	}

} //QualifiedObservableErrorPropagationPointImpl
