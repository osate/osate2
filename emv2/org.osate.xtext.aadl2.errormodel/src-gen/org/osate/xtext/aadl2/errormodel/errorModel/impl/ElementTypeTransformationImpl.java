/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ElementTypeTransformation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Type Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ElementTypeTransformationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ElementTypeTransformationImpl#getContributor <em>Contributor</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ElementTypeTransformationImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementTypeTransformationImpl extends TypeTransformationImpl implements ElementTypeTransformation
{
  /**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
  protected ErrorType source;

  /**
	 * The cached value of the '{@link #getContributor() <em>Contributor</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getContributor()
	 * @generated
	 * @ordered
	 */
  protected ErrorType contributor;

  /**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
  protected ErrorType target;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ElementTypeTransformationImpl()
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
		return ErrorModelPackage.Literals.ELEMENT_TYPE_TRANSFORMATION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorType getSource()
  {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (ErrorType)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorType basicGetSource()
  {
		return source;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSource(ErrorType newSource)
  {
		ErrorType oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__SOURCE, oldSource, source));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorType getContributor()
  {
		if (contributor != null && contributor.eIsProxy()) {
			InternalEObject oldContributor = (InternalEObject)contributor;
			contributor = (ErrorType)eResolveProxy(oldContributor);
			if (contributor != oldContributor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__CONTRIBUTOR, oldContributor, contributor));
			}
		}
		return contributor;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorType basicGetContributor()
  {
		return contributor;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setContributor(ErrorType newContributor)
  {
		ErrorType oldContributor = contributor;
		contributor = newContributor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__CONTRIBUTOR, oldContributor, contributor));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorType getTarget()
  {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (ErrorType)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorType basicGetTarget()
  {
		return target;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTarget(ErrorType newTarget)
  {
		ErrorType oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__TARGET, oldTarget, target));
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
			case ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__CONTRIBUTOR:
				if (resolve) return getContributor();
				return basicGetContributor();
			case ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__SOURCE:
				setSource((ErrorType)newValue);
				return;
			case ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__CONTRIBUTOR:
				setContributor((ErrorType)newValue);
				return;
			case ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__TARGET:
				setTarget((ErrorType)newValue);
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
			case ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__SOURCE:
				setSource((ErrorType)null);
				return;
			case ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__CONTRIBUTOR:
				setContributor((ErrorType)null);
				return;
			case ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__TARGET:
				setTarget((ErrorType)null);
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
			case ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__SOURCE:
				return source != null;
			case ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__CONTRIBUTOR:
				return contributor != null;
			case ErrorModelPackage.ELEMENT_TYPE_TRANSFORMATION__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

} //ElementTypeTransformationImpl
