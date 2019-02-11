/**
 */
package org.osate.result.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;
import org.osate.result.ResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Issue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.result.impl.DiagnosticImpl#getDiagnosticType <em>Diagnostic Type</em>}</li>
 *   <li>{@link org.osate.result.impl.DiagnosticImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.result.impl.DiagnosticImpl#getModelElement <em>Model Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DiagnosticImpl extends MinimalEObjectImpl.Container implements Diagnostic {
	/**
	 * The default value of the '{@link #getDiagnosticType() <em>Diagnostic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnosticType()
	 * @generated
	 * @ordered
	 */
	protected static final DiagnosticType DIAGNOSTIC_TYPE_EDEFAULT = DiagnosticType.TBD;

	/**
	 * The cached value of the '{@link #getDiagnosticType() <em>Diagnostic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnosticType()
	 * @generated
	 * @ordered
	 */
	protected DiagnosticType diagnosticType = DIAGNOSTIC_TYPE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagnosticImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultPackage.Literals.DIAGNOSTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagnosticType getDiagnosticType() {
		return diagnosticType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagnosticType(DiagnosticType newDiagnosticType) {
		DiagnosticType oldDiagnosticType = diagnosticType;
		diagnosticType = newDiagnosticType == null ? DIAGNOSTIC_TYPE_EDEFAULT : newDiagnosticType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.DIAGNOSTIC__DIAGNOSTIC_TYPE, oldDiagnosticType, diagnosticType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.DIAGNOSTIC__MESSAGE, oldMessage, message));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultPackage.DIAGNOSTIC__MODEL_ELEMENT, oldModelElement, modelElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.DIAGNOSTIC__MODEL_ELEMENT, oldModelElement, modelElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResultPackage.DIAGNOSTIC__DIAGNOSTIC_TYPE:
				return getDiagnosticType();
			case ResultPackage.DIAGNOSTIC__MESSAGE:
				return getMessage();
			case ResultPackage.DIAGNOSTIC__MODEL_ELEMENT:
				if (resolve) return getModelElement();
				return basicGetModelElement();
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
			case ResultPackage.DIAGNOSTIC__DIAGNOSTIC_TYPE:
				setDiagnosticType((DiagnosticType)newValue);
				return;
			case ResultPackage.DIAGNOSTIC__MESSAGE:
				setMessage((String)newValue);
				return;
			case ResultPackage.DIAGNOSTIC__MODEL_ELEMENT:
				setModelElement((EObject)newValue);
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
			case ResultPackage.DIAGNOSTIC__DIAGNOSTIC_TYPE:
				setDiagnosticType(DIAGNOSTIC_TYPE_EDEFAULT);
				return;
			case ResultPackage.DIAGNOSTIC__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case ResultPackage.DIAGNOSTIC__MODEL_ELEMENT:
				setModelElement((EObject)null);
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
			case ResultPackage.DIAGNOSTIC__DIAGNOSTIC_TYPE:
				return diagnosticType != DIAGNOSTIC_TYPE_EDEFAULT;
			case ResultPackage.DIAGNOSTIC__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case ResultPackage.DIAGNOSTIC__MODEL_ELEMENT:
				return modelElement != null;
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
		result.append(" (diagnosticType: ");
		result.append(diagnosticType);
		result.append(", message: ");
		result.append(message);
		result.append(')');
		return result.toString();
	}

} //DiagnosticImpl
