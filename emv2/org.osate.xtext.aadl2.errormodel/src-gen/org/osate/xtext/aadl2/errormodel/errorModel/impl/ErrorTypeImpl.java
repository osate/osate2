/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeImpl#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeImpl#getAliasedType <em>Aliased Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeImpl#getSubType <em>Sub Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorTypeImpl extends ErrorTypesImpl implements ErrorType
{
  /**
	 * The cached value of the '{@link #getSuperType() <em>Super Type</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSuperType()
	 * @generated
	 * @ordered
	 */
  protected ErrorType superType;

  /**
	 * The cached value of the '{@link #getAliasedType() <em>Aliased Type</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAliasedType()
	 * @generated
	 * @ordered
	 */
  protected ErrorType aliasedType;

  /**
	 * The cached value of the '{@link #getSubType() <em>Sub Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubType()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorType> subType;

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ErrorTypeImpl()
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
		return ErrorModelPackage.Literals.ERROR_TYPE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorType getSuperType()
  {
		if (superType != null && superType.eIsProxy()) {
			InternalEObject oldSuperType = (InternalEObject)superType;
			superType = (ErrorType)eResolveProxy(oldSuperType);
			if (superType != oldSuperType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_TYPE__SUPER_TYPE, oldSuperType, superType));
			}
		}
		return superType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorType basicGetSuperType()
  {
		return superType;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperType(ErrorType newSuperType, NotificationChain msgs) {
		ErrorType oldSuperType = superType;
		superType = newSuperType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_TYPE__SUPER_TYPE, oldSuperType, newSuperType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSuperType(ErrorType newSuperType)
  {
		if (newSuperType != superType) {
			NotificationChain msgs = null;
			if (superType != null)
				msgs = ((InternalEObject)superType).eInverseRemove(this, ErrorModelPackage.ERROR_TYPE__SUB_TYPE, ErrorType.class, msgs);
			if (newSuperType != null)
				msgs = ((InternalEObject)newSuperType).eInverseAdd(this, ErrorModelPackage.ERROR_TYPE__SUB_TYPE, ErrorType.class, msgs);
			msgs = basicSetSuperType(newSuperType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_TYPE__SUPER_TYPE, newSuperType, newSuperType));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorType getAliasedType()
  {
		if (aliasedType != null && aliasedType.eIsProxy()) {
			InternalEObject oldAliasedType = (InternalEObject)aliasedType;
			aliasedType = (ErrorType)eResolveProxy(oldAliasedType);
			if (aliasedType != oldAliasedType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_TYPE__ALIASED_TYPE, oldAliasedType, aliasedType));
			}
		}
		return aliasedType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorType basicGetAliasedType()
  {
		return aliasedType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAliasedType(ErrorType newAliasedType)
  {
		ErrorType oldAliasedType = aliasedType;
		aliasedType = newAliasedType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_TYPE__ALIASED_TYPE, oldAliasedType, aliasedType));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ErrorType> getSubType() {
		if (subType == null) {
			subType = new EObjectWithInverseResolvingEList<ErrorType>(ErrorType.class, this, ErrorModelPackage.ERROR_TYPE__SUB_TYPE, ErrorModelPackage.ERROR_TYPE__SUPER_TYPE);
		}
		return subType;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ErrorModelPackage.ERROR_TYPE__SUPER_TYPE:
				if (superType != null)
					msgs = ((InternalEObject)superType).eInverseRemove(this, ErrorModelPackage.ERROR_TYPE__SUB_TYPE, ErrorType.class, msgs);
				return basicSetSuperType((ErrorType)otherEnd, msgs);
			case ErrorModelPackage.ERROR_TYPE__SUB_TYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubType()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ErrorModelPackage.ERROR_TYPE__SUPER_TYPE:
				return basicSetSuperType(null, msgs);
			case ErrorModelPackage.ERROR_TYPE__SUB_TYPE:
				return ((InternalEList<?>)getSubType()).basicRemove(otherEnd, msgs);
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
		switch (featureID) {
			case ErrorModelPackage.ERROR_TYPE__SUPER_TYPE:
				if (resolve) return getSuperType();
				return basicGetSuperType();
			case ErrorModelPackage.ERROR_TYPE__ALIASED_TYPE:
				if (resolve) return getAliasedType();
				return basicGetAliasedType();
			case ErrorModelPackage.ERROR_TYPE__SUB_TYPE:
				return getSubType();
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
		switch (featureID) {
			case ErrorModelPackage.ERROR_TYPE__SUPER_TYPE:
				setSuperType((ErrorType)newValue);
				return;
			case ErrorModelPackage.ERROR_TYPE__ALIASED_TYPE:
				setAliasedType((ErrorType)newValue);
				return;
			case ErrorModelPackage.ERROR_TYPE__SUB_TYPE:
				getSubType().clear();
				getSubType().addAll((Collection<? extends ErrorType>)newValue);
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
			case ErrorModelPackage.ERROR_TYPE__SUPER_TYPE:
				setSuperType((ErrorType)null);
				return;
			case ErrorModelPackage.ERROR_TYPE__ALIASED_TYPE:
				setAliasedType((ErrorType)null);
				return;
			case ErrorModelPackage.ERROR_TYPE__SUB_TYPE:
				getSubType().clear();
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
			case ErrorModelPackage.ERROR_TYPE__SUPER_TYPE:
				return superType != null;
			case ErrorModelPackage.ERROR_TYPE__ALIASED_TYPE:
				return aliasedType != null;
			case ErrorModelPackage.ERROR_TYPE__SUB_TYPE:
				return subType != null && !subType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ErrorTypeImpl
