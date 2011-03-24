/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import edu.cmu.sei.aadl.aadl2.impl.AnnexSubclauseImpl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable;
import fr.tpt.aadl.annex.behavior.aadlba.Element;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Annex</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl#getBaRef <em>Ba Ref</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl#getAadlRef <em>Aadl Ref</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl#getBehaviorVariables <em>Behavior Variables</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl#getBehaviorStates <em>Behavior States</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl#getBehaviorTransitions <em>Behavior Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorAnnexImpl extends AnnexSubclauseImpl implements BehaviorAnnex {
	/**
	 * The cached value of the '{@link #getBaRef() <em>Ba Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaRef()
	 * @generated
	 * @ordered
	 */
	protected Element baRef;

	/**
	 * The cached value of the '{@link #getAadlRef() <em>Aadl Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAadlRef()
	 * @generated
	 * @ordered
	 */
	protected edu.cmu.sei.aadl.aadl2.Element aadlRef;

	/**
	 * The cached value of the '{@link #getBehaviorVariables() <em>Behavior Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<BehaviorVariable> behaviorVariables;

	/**
	 * The cached value of the '{@link #getBehaviorStates() <em>Behavior States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorStates()
	 * @generated
	 * @ordered
	 */
	protected EList<BehaviorState> behaviorStates;

	/**
	 * The cached value of the '{@link #getBehaviorTransitions() <em>Behavior Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<BehaviorTransition> behaviorTransitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorAnnexImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.BEHAVIOR_ANNEX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getBaRef() {
		if (baRef != null && ((EObject)baRef).eIsProxy()) {
			InternalEObject oldBaRef = (InternalEObject)baRef;
			baRef = (Element)eResolveProxy(oldBaRef);
			if (baRef != oldBaRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_ANNEX__BA_REF, oldBaRef, baRef));
			}
		}
		return baRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetBaRef() {
		return baRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaRef(Element newBaRef) {
		Element oldBaRef = baRef;
		baRef = newBaRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ANNEX__BA_REF, oldBaRef, baRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.cmu.sei.aadl.aadl2.Element getAadlRef() {
		if (aadlRef != null && ((EObject)aadlRef).eIsProxy()) {
			InternalEObject oldAadlRef = (InternalEObject)aadlRef;
			aadlRef = (edu.cmu.sei.aadl.aadl2.Element)eResolveProxy(oldAadlRef);
			if (aadlRef != oldAadlRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_ANNEX__AADL_REF, oldAadlRef, aadlRef));
			}
		}
		return aadlRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.cmu.sei.aadl.aadl2.Element basicGetAadlRef() {
		return aadlRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAadlRef(edu.cmu.sei.aadl.aadl2.Element newAadlRef) {
		edu.cmu.sei.aadl.aadl2.Element oldAadlRef = aadlRef;
		aadlRef = newAadlRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ANNEX__AADL_REF, oldAadlRef, aadlRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehaviorVariable> getBehaviorVariables() {
		if (behaviorVariables == null) {
			behaviorVariables = new EObjectContainmentEList.Unsettable<BehaviorVariable>(BehaviorVariable.class, this, AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_VARIABLES);
		}
		return behaviorVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBehaviorVariables() {
		if (behaviorVariables != null) ((InternalEList.Unsettable<?>)behaviorVariables).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBehaviorVariables() {
		return behaviorVariables != null && ((InternalEList.Unsettable<?>)behaviorVariables).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehaviorState> getBehaviorStates() {
		if (behaviorStates == null) {
			behaviorStates = new EObjectContainmentEList.Unsettable<BehaviorState>(BehaviorState.class, this, AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_STATES);
		}
		return behaviorStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBehaviorStates() {
		if (behaviorStates != null) ((InternalEList.Unsettable<?>)behaviorStates).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBehaviorStates() {
		return behaviorStates != null && ((InternalEList.Unsettable<?>)behaviorStates).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehaviorTransition> getBehaviorTransitions() {
		if (behaviorTransitions == null) {
			behaviorTransitions = new EObjectContainmentEList.Unsettable<BehaviorTransition>(BehaviorTransition.class, this, AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_TRANSITIONS);
		}
		return behaviorTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBehaviorTransitions() {
		if (behaviorTransitions != null) ((InternalEList.Unsettable<?>)behaviorTransitions).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBehaviorTransitions() {
		return behaviorTransitions != null && ((InternalEList.Unsettable<?>)behaviorTransitions).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_VARIABLES:
				return ((InternalEList<?>)getBehaviorVariables()).basicRemove(otherEnd, msgs);
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_STATES:
				return ((InternalEList<?>)getBehaviorStates()).basicRemove(otherEnd, msgs);
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_TRANSITIONS:
				return ((InternalEList<?>)getBehaviorTransitions()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.BEHAVIOR_ANNEX__BA_REF:
				if (resolve) return getBaRef();
				return basicGetBaRef();
			case AadlBaPackage.BEHAVIOR_ANNEX__AADL_REF:
				if (resolve) return getAadlRef();
				return basicGetAadlRef();
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_VARIABLES:
				return getBehaviorVariables();
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_STATES:
				return getBehaviorStates();
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_TRANSITIONS:
				return getBehaviorTransitions();
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
			case AadlBaPackage.BEHAVIOR_ANNEX__BA_REF:
				setBaRef((Element)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ANNEX__AADL_REF:
				setAadlRef((edu.cmu.sei.aadl.aadl2.Element)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_VARIABLES:
				getBehaviorVariables().clear();
				getBehaviorVariables().addAll((Collection<? extends BehaviorVariable>)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_STATES:
				getBehaviorStates().clear();
				getBehaviorStates().addAll((Collection<? extends BehaviorState>)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_TRANSITIONS:
				getBehaviorTransitions().clear();
				getBehaviorTransitions().addAll((Collection<? extends BehaviorTransition>)newValue);
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
			case AadlBaPackage.BEHAVIOR_ANNEX__BA_REF:
				setBaRef((Element)null);
				return;
			case AadlBaPackage.BEHAVIOR_ANNEX__AADL_REF:
				setAadlRef((edu.cmu.sei.aadl.aadl2.Element)null);
				return;
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_VARIABLES:
				unsetBehaviorVariables();
				return;
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_STATES:
				unsetBehaviorStates();
				return;
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_TRANSITIONS:
				unsetBehaviorTransitions();
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
			case AadlBaPackage.BEHAVIOR_ANNEX__BA_REF:
				return baRef != null;
			case AadlBaPackage.BEHAVIOR_ANNEX__AADL_REF:
				return aadlRef != null;
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_VARIABLES:
				return isSetBehaviorVariables();
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_STATES:
				return isSetBehaviorStates();
			case AadlBaPackage.BEHAVIOR_ANNEX__BEHAVIOR_TRANSITIONS:
				return isSetBehaviorTransitions();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Element.class) {
			switch (derivedFeatureID) {
				case AadlBaPackage.BEHAVIOR_ANNEX__BA_REF: return AadlBaPackage.ELEMENT__BA_REF;
				case AadlBaPackage.BEHAVIOR_ANNEX__AADL_REF: return AadlBaPackage.ELEMENT__AADL_REF;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Element.class) {
			switch (baseFeatureID) {
				case AadlBaPackage.ELEMENT__BA_REF: return AadlBaPackage.BEHAVIOR_ANNEX__BA_REF;
				case AadlBaPackage.ELEMENT__AADL_REF: return AadlBaPackage.BEHAVIOR_ANNEX__AADL_REF;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //BehaviorAnnexImpl
