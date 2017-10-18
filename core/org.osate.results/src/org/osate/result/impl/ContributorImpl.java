/**
 */
package org.osate.result.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.result.Contributor;
import org.osate.result.Issue;
import org.osate.result.ResultPackage;
import org.osate.result.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contributor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.result.impl.ContributorImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.result.impl.ContributorImpl#getSourceReference <em>Source Reference</em>}</li>
 *   <li>{@link org.osate.result.impl.ContributorImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.osate.result.impl.ContributorImpl#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.result.impl.ContributorImpl#getSubContributors <em>Sub Contributors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContributorImpl extends MinimalEObjectImpl.Container implements Contributor {
	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceReference() <em>Source Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceReference()
	 * @generated
	 * @ordered
	 */
	protected EObject sourceReference;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> values;

	/**
	 * The cached value of the '{@link #getIssues() <em>Issues</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssues()
	 * @generated
	 * @ordered
	 */
	protected EList<Issue> issues;

	/**
	 * The cached value of the '{@link #getSubContributors() <em>Sub Contributors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubContributors()
	 * @generated
	 * @ordered
	 */
	protected EList<Contributor> subContributors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContributorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultPackage.Literals.CONTRIBUTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(String newSource) {
		String oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.CONTRIBUTOR__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSourceReference() {
		if (sourceReference != null && sourceReference.eIsProxy()) {
			InternalEObject oldSourceReference = (InternalEObject)sourceReference;
			sourceReference = eResolveProxy(oldSourceReference);
			if (sourceReference != oldSourceReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultPackage.CONTRIBUTOR__SOURCE_REFERENCE, oldSourceReference, sourceReference));
			}
		}
		return sourceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSourceReference() {
		return sourceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceReference(EObject newSourceReference) {
		EObject oldSourceReference = sourceReference;
		sourceReference = newSourceReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.CONTRIBUTOR__SOURCE_REFERENCE, oldSourceReference, sourceReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<Value>(Value.class, this, ResultPackage.CONTRIBUTOR__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Issue> getIssues() {
		if (issues == null) {
			issues = new EObjectContainmentEList<Issue>(Issue.class, this, ResultPackage.CONTRIBUTOR__ISSUES);
		}
		return issues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Contributor> getSubContributors() {
		if (subContributors == null) {
			subContributors = new EObjectContainmentEList<Contributor>(Contributor.class, this, ResultPackage.CONTRIBUTOR__SUB_CONTRIBUTORS);
		}
		return subContributors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultPackage.CONTRIBUTOR__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
			case ResultPackage.CONTRIBUTOR__ISSUES:
				return ((InternalEList<?>)getIssues()).basicRemove(otherEnd, msgs);
			case ResultPackage.CONTRIBUTOR__SUB_CONTRIBUTORS:
				return ((InternalEList<?>)getSubContributors()).basicRemove(otherEnd, msgs);
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
			case ResultPackage.CONTRIBUTOR__SOURCE:
				return getSource();
			case ResultPackage.CONTRIBUTOR__SOURCE_REFERENCE:
				if (resolve) return getSourceReference();
				return basicGetSourceReference();
			case ResultPackage.CONTRIBUTOR__VALUES:
				return getValues();
			case ResultPackage.CONTRIBUTOR__ISSUES:
				return getIssues();
			case ResultPackage.CONTRIBUTOR__SUB_CONTRIBUTORS:
				return getSubContributors();
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
			case ResultPackage.CONTRIBUTOR__SOURCE:
				setSource((String)newValue);
				return;
			case ResultPackage.CONTRIBUTOR__SOURCE_REFERENCE:
				setSourceReference((EObject)newValue);
				return;
			case ResultPackage.CONTRIBUTOR__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends Value>)newValue);
				return;
			case ResultPackage.CONTRIBUTOR__ISSUES:
				getIssues().clear();
				getIssues().addAll((Collection<? extends Issue>)newValue);
				return;
			case ResultPackage.CONTRIBUTOR__SUB_CONTRIBUTORS:
				getSubContributors().clear();
				getSubContributors().addAll((Collection<? extends Contributor>)newValue);
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
			case ResultPackage.CONTRIBUTOR__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case ResultPackage.CONTRIBUTOR__SOURCE_REFERENCE:
				setSourceReference((EObject)null);
				return;
			case ResultPackage.CONTRIBUTOR__VALUES:
				getValues().clear();
				return;
			case ResultPackage.CONTRIBUTOR__ISSUES:
				getIssues().clear();
				return;
			case ResultPackage.CONTRIBUTOR__SUB_CONTRIBUTORS:
				getSubContributors().clear();
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
			case ResultPackage.CONTRIBUTOR__SOURCE:
				return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
			case ResultPackage.CONTRIBUTOR__SOURCE_REFERENCE:
				return sourceReference != null;
			case ResultPackage.CONTRIBUTOR__VALUES:
				return values != null && !values.isEmpty();
			case ResultPackage.CONTRIBUTOR__ISSUES:
				return issues != null && !issues.isEmpty();
			case ResultPackage.CONTRIBUTOR__SUB_CONTRIBUTORS:
				return subContributors != null && !subContributors.isEmpty();
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
		result.append(" (source: ");
		result.append(source);
		result.append(')');
		return result.toString();
	}

} //ContributorImpl
