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
import org.osate.results.Results;
import org.osate.results.ResultsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Results</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.results.impl.ResultsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultsImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultsImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultsImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultsImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultsImpl#getDataSpec <em>Data Spec</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultsImpl#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultsImpl#getContributors <em>Contributors</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultsImpl#getResults <em>Results</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultsImpl extends MinimalEObjectImpl.Container implements Results {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> values;

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
	 * The cached value of the '{@link #getContributors() <em>Contributors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributors()
	 * @generated
	 * @ordered
	 */
	protected EList<ResultContributor> contributors;

	/**
	 * The cached value of the '{@link #getResults() <em>Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<Results> results;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultsPackage.Literals.RESULTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULTS__NAME, oldName, name));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultsPackage.RESULTS__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULTS__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULTS__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULTS__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getValues() {
		if (values == null) {
			values = new EDataTypeEList<Double>(Double.class, this, ResultsPackage.RESULTS__VALUES);
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
			dataSpec = new EObjectContainmentEList<ResultDataSpec>(ResultDataSpec.class, this, ResultsPackage.RESULTS__DATA_SPEC);
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
			issues = new EObjectContainmentEList<ResultIssue>(ResultIssue.class, this, ResultsPackage.RESULTS__ISSUES);
		}
		return issues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResultContributor> getContributors() {
		if (contributors == null) {
			contributors = new EObjectContainmentEList<ResultContributor>(ResultContributor.class, this, ResultsPackage.RESULTS__CONTRIBUTORS);
		}
		return contributors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Results> getResults() {
		if (results == null) {
			results = new EObjectContainmentEList<Results>(Results.class, this, ResultsPackage.RESULTS__RESULTS);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultsPackage.RESULTS__DATA_SPEC:
				return ((InternalEList<?>)getDataSpec()).basicRemove(otherEnd, msgs);
			case ResultsPackage.RESULTS__ISSUES:
				return ((InternalEList<?>)getIssues()).basicRemove(otherEnd, msgs);
			case ResultsPackage.RESULTS__CONTRIBUTORS:
				return ((InternalEList<?>)getContributors()).basicRemove(otherEnd, msgs);
			case ResultsPackage.RESULTS__RESULTS:
				return ((InternalEList<?>)getResults()).basicRemove(otherEnd, msgs);
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
			case ResultsPackage.RESULTS__NAME:
				return getName();
			case ResultsPackage.RESULTS__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ResultsPackage.RESULTS__TITLE:
				return getTitle();
			case ResultsPackage.RESULTS__DESCRIPTION:
				return getDescription();
			case ResultsPackage.RESULTS__VALUES:
				return getValues();
			case ResultsPackage.RESULTS__DATA_SPEC:
				return getDataSpec();
			case ResultsPackage.RESULTS__ISSUES:
				return getIssues();
			case ResultsPackage.RESULTS__CONTRIBUTORS:
				return getContributors();
			case ResultsPackage.RESULTS__RESULTS:
				return getResults();
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
			case ResultsPackage.RESULTS__NAME:
				setName((String)newValue);
				return;
			case ResultsPackage.RESULTS__TARGET:
				setTarget((EObject)newValue);
				return;
			case ResultsPackage.RESULTS__TITLE:
				setTitle((String)newValue);
				return;
			case ResultsPackage.RESULTS__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ResultsPackage.RESULTS__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends Double>)newValue);
				return;
			case ResultsPackage.RESULTS__DATA_SPEC:
				getDataSpec().clear();
				getDataSpec().addAll((Collection<? extends ResultDataSpec>)newValue);
				return;
			case ResultsPackage.RESULTS__ISSUES:
				getIssues().clear();
				getIssues().addAll((Collection<? extends ResultIssue>)newValue);
				return;
			case ResultsPackage.RESULTS__CONTRIBUTORS:
				getContributors().clear();
				getContributors().addAll((Collection<? extends ResultContributor>)newValue);
				return;
			case ResultsPackage.RESULTS__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends Results>)newValue);
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
			case ResultsPackage.RESULTS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ResultsPackage.RESULTS__TARGET:
				setTarget((EObject)null);
				return;
			case ResultsPackage.RESULTS__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case ResultsPackage.RESULTS__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ResultsPackage.RESULTS__VALUES:
				getValues().clear();
				return;
			case ResultsPackage.RESULTS__DATA_SPEC:
				getDataSpec().clear();
				return;
			case ResultsPackage.RESULTS__ISSUES:
				getIssues().clear();
				return;
			case ResultsPackage.RESULTS__CONTRIBUTORS:
				getContributors().clear();
				return;
			case ResultsPackage.RESULTS__RESULTS:
				getResults().clear();
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
			case ResultsPackage.RESULTS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ResultsPackage.RESULTS__TARGET:
				return target != null;
			case ResultsPackage.RESULTS__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case ResultsPackage.RESULTS__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ResultsPackage.RESULTS__VALUES:
				return values != null && !values.isEmpty();
			case ResultsPackage.RESULTS__DATA_SPEC:
				return dataSpec != null && !dataSpec.isEmpty();
			case ResultsPackage.RESULTS__ISSUES:
				return issues != null && !issues.isEmpty();
			case ResultsPackage.RESULTS__CONTRIBUTORS:
				return contributors != null && !contributors.isEmpty();
			case ResultsPackage.RESULTS__RESULTS:
				return results != null && !results.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", title: ");
		result.append(title);
		result.append(", description: ");
		result.append(description);
		result.append(", values: ");
		result.append(values);
		result.append(')');
		return result.toString();
	}

} //ResultsImpl
