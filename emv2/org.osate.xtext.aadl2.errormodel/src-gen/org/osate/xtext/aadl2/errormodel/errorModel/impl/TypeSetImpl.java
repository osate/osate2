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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TypeSetImpl#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TypeSetImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TypeSetImpl#getAliasedType <em>Aliased Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeSetImpl extends ErrorTypesImpl implements TypeSet
{
  /**
	 * The cached value of the '{@link #getElementType() <em>Element Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
  protected EList<TypeToken> elementType;

  /**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
  protected TypeSet reference;

  /**
	 * The cached value of the '{@link #getAliasedType() <em>Aliased Type</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAliasedType()
	 * @generated
	 * @ordered
	 */
  protected TypeSet aliasedType;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TypeSetImpl()
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
		return ErrorModelPackage.Literals.TYPE_SET;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<TypeToken> getElementType()
  {
		if (elementType == null) {
			elementType = new EObjectContainmentEList<TypeToken>(TypeToken.class, this, ErrorModelPackage.TYPE_SET__ELEMENT_TYPE);
		}
		return elementType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeSet getReference()
  {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (TypeSet)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.TYPE_SET__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeSet basicGetReference()
  {
		return reference;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setReference(TypeSet newReference)
  {
		TypeSet oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TYPE_SET__REFERENCE, oldReference, reference));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeSet getAliasedType()
  {
		if (aliasedType != null && aliasedType.eIsProxy()) {
			InternalEObject oldAliasedType = (InternalEObject)aliasedType;
			aliasedType = (TypeSet)eResolveProxy(oldAliasedType);
			if (aliasedType != oldAliasedType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.TYPE_SET__ALIASED_TYPE, oldAliasedType, aliasedType));
			}
		}
		return aliasedType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeSet basicGetAliasedType()
  {
		return aliasedType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAliasedType(TypeSet newAliasedType)
  {
		TypeSet oldAliasedType = aliasedType;
		aliasedType = newAliasedType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TYPE_SET__ALIASED_TYPE, oldAliasedType, aliasedType));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case ErrorModelPackage.TYPE_SET__ELEMENT_TYPE:
				return ((InternalEList<?>)getElementType()).basicRemove(otherEnd, msgs);
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
			case ErrorModelPackage.TYPE_SET__ELEMENT_TYPE:
				return getElementType();
			case ErrorModelPackage.TYPE_SET__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
			case ErrorModelPackage.TYPE_SET__ALIASED_TYPE:
				if (resolve) return getAliasedType();
				return basicGetAliasedType();
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
			case ErrorModelPackage.TYPE_SET__ELEMENT_TYPE:
				getElementType().clear();
				getElementType().addAll((Collection<? extends TypeToken>)newValue);
				return;
			case ErrorModelPackage.TYPE_SET__REFERENCE:
				setReference((TypeSet)newValue);
				return;
			case ErrorModelPackage.TYPE_SET__ALIASED_TYPE:
				setAliasedType((TypeSet)newValue);
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
			case ErrorModelPackage.TYPE_SET__ELEMENT_TYPE:
				getElementType().clear();
				return;
			case ErrorModelPackage.TYPE_SET__REFERENCE:
				setReference((TypeSet)null);
				return;
			case ErrorModelPackage.TYPE_SET__ALIASED_TYPE:
				setAliasedType((TypeSet)null);
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
			case ErrorModelPackage.TYPE_SET__ELEMENT_TYPE:
				return elementType != null && !elementType.isEmpty();
			case ErrorModelPackage.TYPE_SET__REFERENCE:
				return reference != null;
			case ErrorModelPackage.TYPE_SET__ALIASED_TYPE:
				return aliasedType != null;
		}
		return super.eIsSet(featureID);
	}

} //TypeSetImpl
