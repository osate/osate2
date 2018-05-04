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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.result.Diagnostic;
import org.osate.result.Result;
import org.osate.result.AnalysisResult;
import org.osate.result.ResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AnalysisResult</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.result.impl.AnalysisResultImpl#getAnalysis <em>Analysis</em>}</li>
 *   <li>{@link org.osate.result.impl.AnalysisResultImpl#getInfo <em>Info</em>}</li>
 *   <li>{@link org.osate.result.impl.AnalysisResultImpl#getSourceReference <em>Source Reference</em>}</li>
 *   <li>{@link org.osate.result.impl.AnalysisResultImpl#getResults <em>Results</em>}</li>
 *   <li>{@link org.osate.result.impl.AnalysisResultImpl#getDiagnostics <em>Diagnostics</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnalysisResultImpl extends MinimalEObjectImpl.Container implements AnalysisResult {
	/**
	 * The default value of the '{@link #getAnalysis() <em>Analysis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysis()
	 * @generated
	 * @ordered
	 */
	protected static final String ANALYSIS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnalysis() <em>Analysis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysis()
	 * @generated
	 * @ordered
	 */
	protected String analysis = ANALYSIS_EDEFAULT;

	/**
	 * The default value of the '{@link #getInfo() <em>Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfo()
	 * @generated
	 * @ordered
	 */
	protected static final String INFO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInfo() <em>Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfo()
	 * @generated
	 * @ordered
	 */
	protected String info = INFO_EDEFAULT;

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
	 * The cached value of the '{@link #getResults() <em>Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<Result> results;

	/**
	 * The cached value of the '{@link #getDiagnostics() <em>Diagnostics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnostics()
	 * @generated
	 * @ordered
	 */
	protected EList<Diagnostic> diagnostics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalysisResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultPackage.Literals.ANALYSIS_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAnalysis() {
		return analysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysis(String newAnalysis) {
		String oldAnalysis = analysis;
		analysis = newAnalysis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.ANALYSIS_RESULT__ANALYSIS, oldAnalysis, analysis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfo(String newInfo) {
		String oldInfo = info;
		info = newInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.ANALYSIS_RESULT__INFO, oldInfo, info));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultPackage.ANALYSIS_RESULT__SOURCE_REFERENCE, oldSourceReference, sourceReference));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.ANALYSIS_RESULT__SOURCE_REFERENCE, oldSourceReference, sourceReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Result> getResults() {
		if (results == null) {
			results = new EObjectContainmentEList<Result>(Result.class, this, ResultPackage.ANALYSIS_RESULT__RESULTS);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Diagnostic> getDiagnostics() {
		if (diagnostics == null) {
			diagnostics = new EObjectResolvingEList<Diagnostic>(Diagnostic.class, this, ResultPackage.ANALYSIS_RESULT__DIAGNOSTICS);
		}
		return diagnostics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultPackage.ANALYSIS_RESULT__RESULTS:
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
			case ResultPackage.ANALYSIS_RESULT__ANALYSIS:
				return getAnalysis();
			case ResultPackage.ANALYSIS_RESULT__INFO:
				return getInfo();
			case ResultPackage.ANALYSIS_RESULT__SOURCE_REFERENCE:
				if (resolve) return getSourceReference();
				return basicGetSourceReference();
			case ResultPackage.ANALYSIS_RESULT__RESULTS:
				return getResults();
			case ResultPackage.ANALYSIS_RESULT__DIAGNOSTICS:
				return getDiagnostics();
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
			case ResultPackage.ANALYSIS_RESULT__ANALYSIS:
				setAnalysis((String)newValue);
				return;
			case ResultPackage.ANALYSIS_RESULT__INFO:
				setInfo((String)newValue);
				return;
			case ResultPackage.ANALYSIS_RESULT__SOURCE_REFERENCE:
				setSourceReference((EObject)newValue);
				return;
			case ResultPackage.ANALYSIS_RESULT__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends Result>)newValue);
				return;
			case ResultPackage.ANALYSIS_RESULT__DIAGNOSTICS:
				getDiagnostics().clear();
				getDiagnostics().addAll((Collection<? extends Diagnostic>)newValue);
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
			case ResultPackage.ANALYSIS_RESULT__ANALYSIS:
				setAnalysis(ANALYSIS_EDEFAULT);
				return;
			case ResultPackage.ANALYSIS_RESULT__INFO:
				setInfo(INFO_EDEFAULT);
				return;
			case ResultPackage.ANALYSIS_RESULT__SOURCE_REFERENCE:
				setSourceReference((EObject)null);
				return;
			case ResultPackage.ANALYSIS_RESULT__RESULTS:
				getResults().clear();
				return;
			case ResultPackage.ANALYSIS_RESULT__DIAGNOSTICS:
				getDiagnostics().clear();
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
			case ResultPackage.ANALYSIS_RESULT__ANALYSIS:
				return ANALYSIS_EDEFAULT == null ? analysis != null : !ANALYSIS_EDEFAULT.equals(analysis);
			case ResultPackage.ANALYSIS_RESULT__INFO:
				return INFO_EDEFAULT == null ? info != null : !INFO_EDEFAULT.equals(info);
			case ResultPackage.ANALYSIS_RESULT__SOURCE_REFERENCE:
				return sourceReference != null;
			case ResultPackage.ANALYSIS_RESULT__RESULTS:
				return results != null && !results.isEmpty();
			case ResultPackage.ANALYSIS_RESULT__DIAGNOSTICS:
				return diagnostics != null && !diagnostics.isEmpty();
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
		result.append(" (analysis: ");
		result.append(analysis);
		result.append(", info: ");
		result.append(info);
		result.append(')');
		return result.toString();
	}

} //AnalysisResultImpl
