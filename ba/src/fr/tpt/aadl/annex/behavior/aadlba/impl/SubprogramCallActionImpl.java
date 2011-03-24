/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.Name;
import fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction;
import fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subprogram Call Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramCallActionImpl#getSubprogramNames <em>Subprogram Names</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramCallActionImpl#getSubprogramReference <em>Subprogram Reference</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramCallActionImpl#getParameterLabels <em>Parameter Labels</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubprogramCallActionImpl extends ElementImpl implements SubprogramCallAction {
	/**
	 * The cached value of the '{@link #getSubprogramNames() <em>Subprogram Names</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubprogramNames()
	 * @generated
	 * @ordered
	 */
	protected EList<Name> subprogramNames;

	/**
	 * The cached value of the '{@link #getSubprogramReference() <em>Subprogram Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubprogramReference()
	 * @generated
	 * @ordered
	 */
	protected UniqueComponentClassifierReference subprogramReference;

	/**
	 * The cached value of the '{@link #getParameterLabels() <em>Parameter Labels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterLabels()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterLabel> parameterLabels;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubprogramCallActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.SUBPROGRAM_CALL_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Name> getSubprogramNames() {
		if (subprogramNames == null) {
			subprogramNames = new EObjectContainmentEList.Unsettable<Name>(Name.class, this, AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_NAMES);
		}
		return subprogramNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSubprogramNames() {
		if (subprogramNames != null) ((InternalEList.Unsettable<?>)subprogramNames).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSubprogramNames() {
		return subprogramNames != null && ((InternalEList.Unsettable<?>)subprogramNames).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UniqueComponentClassifierReference getSubprogramReference() {
		return subprogramReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubprogramReference(UniqueComponentClassifierReference newSubprogramReference, NotificationChain msgs) {
		UniqueComponentClassifierReference oldSubprogramReference = subprogramReference;
		subprogramReference = newSubprogramReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_REFERENCE, oldSubprogramReference, newSubprogramReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubprogramReference(UniqueComponentClassifierReference newSubprogramReference) {
		if (newSubprogramReference != subprogramReference) {
			NotificationChain msgs = null;
			if (subprogramReference != null)
				msgs = ((InternalEObject)subprogramReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_REFERENCE, null, msgs);
			if (newSubprogramReference != null)
				msgs = ((InternalEObject)newSubprogramReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_REFERENCE, null, msgs);
			msgs = basicSetSubprogramReference(newSubprogramReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_REFERENCE, newSubprogramReference, newSubprogramReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterLabel> getParameterLabels() {
		if (parameterLabels == null) {
			parameterLabels = new EObjectContainmentEList.Unsettable<ParameterLabel>(ParameterLabel.class, this, AadlBaPackage.SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS);
		}
		return parameterLabels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetParameterLabels() {
		if (parameterLabels != null) ((InternalEList.Unsettable<?>)parameterLabels).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetParameterLabels() {
		return parameterLabels != null && ((InternalEList.Unsettable<?>)parameterLabels).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_NAMES:
				return ((InternalEList<?>)getSubprogramNames()).basicRemove(otherEnd, msgs);
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_REFERENCE:
				return basicSetSubprogramReference(null, msgs);
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS:
				return ((InternalEList<?>)getParameterLabels()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_NAMES:
				return getSubprogramNames();
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_REFERENCE:
				return getSubprogramReference();
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS:
				return getParameterLabels();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_NAMES:
				getSubprogramNames().clear();
				getSubprogramNames().addAll((Collection<? extends Name>)newValue);
				return;
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_REFERENCE:
				setSubprogramReference((UniqueComponentClassifierReference)newValue);
				return;
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS:
				getParameterLabels().clear();
				getParameterLabels().addAll((Collection<? extends ParameterLabel>)newValue);
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
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_NAMES:
				unsetSubprogramNames();
				return;
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_REFERENCE:
				setSubprogramReference((UniqueComponentClassifierReference)null);
				return;
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS:
				unsetParameterLabels();
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
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_NAMES:
				return isSetSubprogramNames();
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__SUBPROGRAM_REFERENCE:
				return subprogramReference != null;
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS:
				return isSetParameterLabels();
		}
		return super.eIsSet(featureID);
	}

} //SubprogramCallActionImpl
