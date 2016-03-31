/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.NamedElement;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Featureor PP Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.FeatureorPPReferenceImpl#getFeatureorPP <em>Featureor PP</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.FeatureorPPReferenceImpl#getNext <em>Next</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureorPPReferenceImpl extends ElementImpl implements FeatureorPPReference {
	/**
	 * The cached value of the '{@link #getFeatureorPP() <em>Featureor PP</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureorPP()
	 * @generated
	 * @ordered
	 */
	protected NamedElement featureorPP;

	/**
	 * The cached value of the '{@link #getNext() <em>Next</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNext()
	 * @generated
	 * @ordered
	 */
	protected FeatureorPPReference next;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureorPPReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ErrorModelPackage.Literals.FEATUREOR_PP_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getFeatureorPP() {
		if (featureorPP != null && ((EObject) featureorPP).eIsProxy()) {
			InternalEObject oldFeatureorPP = (InternalEObject) featureorPP;
			featureorPP = (NamedElement) eResolveProxy(oldFeatureorPP);
			if (featureorPP != oldFeatureorPP) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ErrorModelPackage.FEATUREOR_PP_REFERENCE__FEATUREOR_PP, oldFeatureorPP, featureorPP));
			}
		}
		return featureorPP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetFeatureorPP() {
		return featureorPP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureorPP(NamedElement newFeatureorPP) {
		NamedElement oldFeatureorPP = featureorPP;
		featureorPP = newFeatureorPP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ErrorModelPackage.FEATUREOR_PP_REFERENCE__FEATUREOR_PP, oldFeatureorPP, featureorPP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureorPPReference getNext() {
		return next;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNext(FeatureorPPReference newNext, NotificationChain msgs) {
		FeatureorPPReference oldNext = next;
		next = newNext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ErrorModelPackage.FEATUREOR_PP_REFERENCE__NEXT, oldNext, newNext);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNext(FeatureorPPReference newNext) {
		if (newNext != next) {
			NotificationChain msgs = null;
			if (next != null)
				msgs = ((InternalEObject) next).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - ErrorModelPackage.FEATUREOR_PP_REFERENCE__NEXT, null, msgs);
			if (newNext != null)
				msgs = ((InternalEObject) newNext).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ErrorModelPackage.FEATUREOR_PP_REFERENCE__NEXT, null, msgs);
			msgs = basicSetNext(newNext, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.FEATUREOR_PP_REFERENCE__NEXT,
					newNext, newNext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ErrorModelPackage.FEATUREOR_PP_REFERENCE__NEXT:
			return basicSetNext(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ErrorModelPackage.FEATUREOR_PP_REFERENCE__FEATUREOR_PP:
			if (resolve)
				return getFeatureorPP();
			return basicGetFeatureorPP();
		case ErrorModelPackage.FEATUREOR_PP_REFERENCE__NEXT:
			return getNext();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ErrorModelPackage.FEATUREOR_PP_REFERENCE__FEATUREOR_PP:
			setFeatureorPP((NamedElement) newValue);
			return;
		case ErrorModelPackage.FEATUREOR_PP_REFERENCE__NEXT:
			setNext((FeatureorPPReference) newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
		case ErrorModelPackage.FEATUREOR_PP_REFERENCE__FEATUREOR_PP:
			setFeatureorPP((NamedElement) null);
			return;
		case ErrorModelPackage.FEATUREOR_PP_REFERENCE__NEXT:
			setNext((FeatureorPPReference) null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ErrorModelPackage.FEATUREOR_PP_REFERENCE__FEATUREOR_PP:
			return featureorPP != null;
		case ErrorModelPackage.FEATUREOR_PP_REFERENCE__NEXT:
			return next != null;
		}
		return super.eIsSet(featureID);
	}

} // FeatureorPPReferenceImpl
