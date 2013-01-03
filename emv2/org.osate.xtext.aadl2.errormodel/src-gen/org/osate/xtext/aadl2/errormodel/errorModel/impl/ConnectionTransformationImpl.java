/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ConnectionTransformation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ConnectionTransformationImpl#getTypeTransformationSet <em>Type Transformation Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionTransformationImpl extends ElementImpl implements ConnectionTransformation
{
  /**
	 * The cached value of the '{@link #getTypeTransformationSet() <em>Type Transformation Set</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTypeTransformationSet()
	 * @generated
	 * @ordered
	 */
  protected TypeTransformationSet typeTransformationSet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ConnectionTransformationImpl()
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
		return ErrorModelPackage.Literals.CONNECTION_TRANSFORMATION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeTransformationSet getTypeTransformationSet()
  {
		if (typeTransformationSet != null && typeTransformationSet.eIsProxy()) {
			InternalEObject oldTypeTransformationSet = (InternalEObject)typeTransformationSet;
			typeTransformationSet = (TypeTransformationSet)eResolveProxy(oldTypeTransformationSet);
			if (typeTransformationSet != oldTypeTransformationSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.CONNECTION_TRANSFORMATION__TYPE_TRANSFORMATION_SET, oldTypeTransformationSet, typeTransformationSet));
			}
		}
		return typeTransformationSet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeTransformationSet basicGetTypeTransformationSet()
  {
		return typeTransformationSet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTypeTransformationSet(TypeTransformationSet newTypeTransformationSet)
  {
		TypeTransformationSet oldTypeTransformationSet = typeTransformationSet;
		typeTransformationSet = newTypeTransformationSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.CONNECTION_TRANSFORMATION__TYPE_TRANSFORMATION_SET, oldTypeTransformationSet, typeTransformationSet));
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
			case ErrorModelPackage.CONNECTION_TRANSFORMATION__TYPE_TRANSFORMATION_SET:
				if (resolve) return getTypeTransformationSet();
				return basicGetTypeTransformationSet();
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
			case ErrorModelPackage.CONNECTION_TRANSFORMATION__TYPE_TRANSFORMATION_SET:
				setTypeTransformationSet((TypeTransformationSet)newValue);
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
			case ErrorModelPackage.CONNECTION_TRANSFORMATION__TYPE_TRANSFORMATION_SET:
				setTypeTransformationSet((TypeTransformationSet)null);
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
			case ErrorModelPackage.CONNECTION_TRANSFORMATION__TYPE_TRANSFORMATION_SET:
				return typeTransformationSet != null;
		}
		return super.eIsSet(featureID);
	}

} //ConnectionTransformationImpl
