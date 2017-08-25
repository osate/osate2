/**
 */
package org.osate.results.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.results.ResultContributor;
import org.osate.results.ResultDataSpec;
import org.osate.results.ResultIssue;
import org.osate.results.ResultsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Contributor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.results.impl.ResultContributorImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultContributorImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultContributorImpl#getDataSpec <em>Data Spec</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultContributorImpl#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultContributorImpl#getSubcontributor <em>Subcontributor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultContributorImpl extends MinimalEObjectImpl.Container implements ResultContributor {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EObject target;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> values;

	/**
	 * The cached value of the '{@link #getDataSpec() <em>Data Spec</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSpec()
	 * @generated
	 * @ordered
	 */
	protected EList<ResultDataSpec> dataSpec;

	/**
	 * The cached value of the '{@link #getIssues() <em>Issues</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssues()
	 * @generated
	 * @ordered
	 */
	protected EList<ResultIssue> issues;

	/**
	 * The cached value of the '{@link #getSubcontributor() <em>Subcontributor</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubcontributor()
	 * @generated
	 * @ordered
	 */
	protected EList<ResultContributor> subcontributor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultContributorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultsPackage.Literals.RESULT_CONTRIBUTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultsPackage.RESULT_CONTRIBUTOR__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EObject newTarget) {
		EObject oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_CONTRIBUTOR__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getValues() {
		if (values == null) {
			values = new EDataTypeEList<Object>(Object.class, this, ResultsPackage.RESULT_CONTRIBUTOR__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResultDataSpec> getDataSpec() {
		if (dataSpec == null) {
			dataSpec = new EObjectContainmentEList<ResultDataSpec>(ResultDataSpec.class, this, ResultsPackage.RESULT_CONTRIBUTOR__DATA_SPEC);
		}
		return dataSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResultIssue> getIssues() {
		if (issues == null) {
			issues = new EObjectContainmentEList<ResultIssue>(ResultIssue.class, this, ResultsPackage.RESULT_CONTRIBUTOR__ISSUES);
		}
		return issues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResultContributor> getSubcontributor() {
		if (subcontributor == null) {
			subcontributor = new EObjectContainmentEList<ResultContributor>(ResultContributor.class, this, ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR);
		}
		return subcontributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultsPackage.RESULT_CONTRIBUTOR__DATA_SPEC:
				return ((InternalEList<?>)getDataSpec()).basicRemove(otherEnd, msgs);
			case ResultsPackage.RESULT_CONTRIBUTOR__ISSUES:
				return ((InternalEList<?>)getIssues()).basicRemove(otherEnd, msgs);
			case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
				return ((InternalEList<?>)getSubcontributor()).basicRemove(otherEnd, msgs);
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
			case ResultsPackage.RESULT_CONTRIBUTOR__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ResultsPackage.RESULT_CONTRIBUTOR__VALUES:
				return getValues();
			case ResultsPackage.RESULT_CONTRIBUTOR__DATA_SPEC:
				return getDataSpec();
			case ResultsPackage.RESULT_CONTRIBUTOR__ISSUES:
				return getIssues();
			case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
				return getSubcontributor();
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
			case ResultsPackage.RESULT_CONTRIBUTOR__TARGET:
				setTarget((EObject)newValue);
				return;
			case ResultsPackage.RESULT_CONTRIBUTOR__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends Object>)newValue);
				return;
			case ResultsPackage.RESULT_CONTRIBUTOR__DATA_SPEC:
				getDataSpec().clear();
				getDataSpec().addAll((Collection<? extends ResultDataSpec>)newValue);
				return;
			case ResultsPackage.RESULT_CONTRIBUTOR__ISSUES:
				getIssues().clear();
				getIssues().addAll((Collection<? extends ResultIssue>)newValue);
				return;
			case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
				getSubcontributor().clear();
				getSubcontributor().addAll((Collection<? extends ResultContributor>)newValue);
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
			case ResultsPackage.RESULT_CONTRIBUTOR__TARGET:
				setTarget((EObject)null);
				return;
			case ResultsPackage.RESULT_CONTRIBUTOR__VALUES:
				getValues().clear();
				return;
			case ResultsPackage.RESULT_CONTRIBUTOR__DATA_SPEC:
				getDataSpec().clear();
				return;
			case ResultsPackage.RESULT_CONTRIBUTOR__ISSUES:
				getIssues().clear();
				return;
			case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
				getSubcontributor().clear();
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
			case ResultsPackage.RESULT_CONTRIBUTOR__TARGET:
				return target != null;
			case ResultsPackage.RESULT_CONTRIBUTOR__VALUES:
				return values != null && !values.isEmpty();
			case ResultsPackage.RESULT_CONTRIBUTOR__DATA_SPEC:
				return dataSpec != null && !dataSpec.isEmpty();
			case ResultsPackage.RESULT_CONTRIBUTOR__ISSUES:
				return issues != null && !issues.isEmpty();
			case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
				return subcontributor != null && !subcontributor.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (values: ");
		result.append(values);
		result.append(')');
		return result.toString();
	}

} //ResultContributorImpl
