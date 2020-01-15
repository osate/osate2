/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
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

import org.osate.result.Result;
import org.osate.result.Diagnostic;
import org.osate.result.ResultPackage;
import org.osate.result.ResultType;
import org.osate.result.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.result.impl.ResultImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.osate.result.impl.ResultImpl#getDiagnostics <em>Diagnostics</em>}</li>
 *   <li>{@link org.osate.result.impl.ResultImpl#getSubResults <em>Sub Results</em>}</li>
 *   <li>{@link org.osate.result.impl.ResultImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.result.impl.ResultImpl#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link org.osate.result.impl.ResultImpl#getResultType <em>Result Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultImpl extends MinimalEObjectImpl.Container implements Result {
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
	 * The cached value of the '{@link #getDiagnostics() <em>Diagnostics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnostics()
	 * @generated
	 * @ordered
	 */
	protected EList<Diagnostic> diagnostics;

	/**
	 * The cached value of the '{@link #getSubResults() <em>Sub Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubResults()
	 * @generated
	 * @ordered
	 */
	protected EList<Result> subResults;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElement()
	 * @generated
	 * @ordered
	 */
	protected EObject modelElement;

	/**
	 * The default value of the '{@link #getResultType() <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected static final ResultType RESULT_TYPE_EDEFAULT = ResultType.TBD;

	/**
	 * The cached value of the '{@link #getResultType() <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected ResultType resultType = RESULT_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultPackage.Literals.RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<Value>(Value.class, this, ResultPackage.RESULT__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Diagnostic> getDiagnostics() {
		if (diagnostics == null) {
			diagnostics = new EObjectContainmentEList<Diagnostic>(Diagnostic.class, this, ResultPackage.RESULT__DIAGNOSTICS);
		}
		return diagnostics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Result> getSubResults() {
		if (subResults == null) {
			subResults = new EObjectContainmentEList<Result>(Result.class, this, ResultPackage.RESULT__SUB_RESULTS);
		}
		return subResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.RESULT__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getModelElement() {
		if (modelElement != null && modelElement.eIsProxy()) {
			InternalEObject oldModelElement = (InternalEObject)modelElement;
			modelElement = eResolveProxy(oldModelElement);
			if (modelElement != oldModelElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultPackage.RESULT__MODEL_ELEMENT, oldModelElement, modelElement));
			}
		}
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetModelElement() {
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElement(EObject newModelElement) {
		EObject oldModelElement = modelElement;
		modelElement = newModelElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.RESULT__MODEL_ELEMENT, oldModelElement, modelElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType getResultType() {
		return resultType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultType(ResultType newResultType) {
		ResultType oldResultType = resultType;
		resultType = newResultType == null ? RESULT_TYPE_EDEFAULT : newResultType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.RESULT__RESULT_TYPE, oldResultType, resultType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultPackage.RESULT__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
			case ResultPackage.RESULT__DIAGNOSTICS:
				return ((InternalEList<?>)getDiagnostics()).basicRemove(otherEnd, msgs);
			case ResultPackage.RESULT__SUB_RESULTS:
				return ((InternalEList<?>)getSubResults()).basicRemove(otherEnd, msgs);
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
			case ResultPackage.RESULT__VALUES:
				return getValues();
			case ResultPackage.RESULT__DIAGNOSTICS:
				return getDiagnostics();
			case ResultPackage.RESULT__SUB_RESULTS:
				return getSubResults();
			case ResultPackage.RESULT__MESSAGE:
				return getMessage();
			case ResultPackage.RESULT__MODEL_ELEMENT:
				if (resolve) return getModelElement();
				return basicGetModelElement();
			case ResultPackage.RESULT__RESULT_TYPE:
				return getResultType();
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
			case ResultPackage.RESULT__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends Value>)newValue);
				return;
			case ResultPackage.RESULT__DIAGNOSTICS:
				getDiagnostics().clear();
				getDiagnostics().addAll((Collection<? extends Diagnostic>)newValue);
				return;
			case ResultPackage.RESULT__SUB_RESULTS:
				getSubResults().clear();
				getSubResults().addAll((Collection<? extends Result>)newValue);
				return;
			case ResultPackage.RESULT__MESSAGE:
				setMessage((String)newValue);
				return;
			case ResultPackage.RESULT__MODEL_ELEMENT:
				setModelElement((EObject)newValue);
				return;
			case ResultPackage.RESULT__RESULT_TYPE:
				setResultType((ResultType)newValue);
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
			case ResultPackage.RESULT__VALUES:
				getValues().clear();
				return;
			case ResultPackage.RESULT__DIAGNOSTICS:
				getDiagnostics().clear();
				return;
			case ResultPackage.RESULT__SUB_RESULTS:
				getSubResults().clear();
				return;
			case ResultPackage.RESULT__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case ResultPackage.RESULT__MODEL_ELEMENT:
				setModelElement((EObject)null);
				return;
			case ResultPackage.RESULT__RESULT_TYPE:
				setResultType(RESULT_TYPE_EDEFAULT);
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
			case ResultPackage.RESULT__VALUES:
				return values != null && !values.isEmpty();
			case ResultPackage.RESULT__DIAGNOSTICS:
				return diagnostics != null && !diagnostics.isEmpty();
			case ResultPackage.RESULT__SUB_RESULTS:
				return subResults != null && !subResults.isEmpty();
			case ResultPackage.RESULT__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case ResultPackage.RESULT__MODEL_ELEMENT:
				return modelElement != null;
			case ResultPackage.RESULT__RESULT_TYPE:
				return resultType != RESULT_TYPE_EDEFAULT;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (message: ");
		result.append(message);
		result.append(", resultType: ");
		result.append(resultType);
		result.append(')');
		return result.toString();
	}

} //ResultImpl
