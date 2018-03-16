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
 *   <li>{@link org.osate.result.impl.DiagnosticImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.result.impl.DiagnosticImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.result.impl.DiagnosticImpl#getSourceReference <em>Source Reference</em>}</li>
 *   <li>{@link org.osate.result.impl.DiagnosticImpl#getExceptionType <em>Exception Type</em>}</li>
 *   <li>{@link org.osate.result.impl.DiagnosticImpl#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.result.impl.DiagnosticImpl#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DiagnosticImpl extends MinimalEObjectImpl.Container implements Diagnostic {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final DiagnosticType TYPE_EDEFAULT = DiagnosticType.NONE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected DiagnosticType type = TYPE_EDEFAULT;

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
	 * The cached value of the '{@link #getSourceReference() <em>Source Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceReference()
	 * @generated
	 * @ordered
	 */
	protected EObject sourceReference;

	/**
	 * The default value of the '{@link #getExceptionType() <em>Exception Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionType()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExceptionType() <em>Exception Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionType()
	 * @generated
	 * @ordered
	 */
	protected String exceptionType = EXCEPTION_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIssues() <em>Issues</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssues()
	 * @generated
	 * @ordered
	 */
	protected EList<Diagnostic> issues;

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
	public DiagnosticType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DiagnosticType newType) {
		DiagnosticType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.DIAGNOSTIC__TYPE, oldType, type));
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
	public EObject getSourceReference() {
		if (sourceReference != null && sourceReference.eIsProxy()) {
			InternalEObject oldSourceReference = (InternalEObject)sourceReference;
			sourceReference = eResolveProxy(oldSourceReference);
			if (sourceReference != oldSourceReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultPackage.DIAGNOSTIC__SOURCE_REFERENCE, oldSourceReference, sourceReference));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.DIAGNOSTIC__SOURCE_REFERENCE, oldSourceReference, sourceReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExceptionType() {
		return exceptionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExceptionType(String newExceptionType) {
		String oldExceptionType = exceptionType;
		exceptionType = newExceptionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.DIAGNOSTIC__EXCEPTION_TYPE, oldExceptionType, exceptionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Diagnostic> getIssues() {
		if (issues == null) {
			issues = new EObjectContainmentEList<Diagnostic>(Diagnostic.class, this, ResultPackage.DIAGNOSTIC__ISSUES);
		}
		return issues;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResultPackage.DIAGNOSTIC__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultPackage.DIAGNOSTIC__ISSUES:
				return ((InternalEList<?>)getIssues()).basicRemove(otherEnd, msgs);
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
			case ResultPackage.DIAGNOSTIC__TYPE:
				return getType();
			case ResultPackage.DIAGNOSTIC__MESSAGE:
				return getMessage();
			case ResultPackage.DIAGNOSTIC__SOURCE_REFERENCE:
				if (resolve) return getSourceReference();
				return basicGetSourceReference();
			case ResultPackage.DIAGNOSTIC__EXCEPTION_TYPE:
				return getExceptionType();
			case ResultPackage.DIAGNOSTIC__ISSUES:
				return getIssues();
			case ResultPackage.DIAGNOSTIC__SOURCE:
				return getSource();
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
			case ResultPackage.DIAGNOSTIC__TYPE:
				setType((DiagnosticType)newValue);
				return;
			case ResultPackage.DIAGNOSTIC__MESSAGE:
				setMessage((String)newValue);
				return;
			case ResultPackage.DIAGNOSTIC__SOURCE_REFERENCE:
				setSourceReference((EObject)newValue);
				return;
			case ResultPackage.DIAGNOSTIC__EXCEPTION_TYPE:
				setExceptionType((String)newValue);
				return;
			case ResultPackage.DIAGNOSTIC__ISSUES:
				getIssues().clear();
				getIssues().addAll((Collection<? extends Diagnostic>)newValue);
				return;
			case ResultPackage.DIAGNOSTIC__SOURCE:
				setSource((String)newValue);
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
			case ResultPackage.DIAGNOSTIC__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ResultPackage.DIAGNOSTIC__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case ResultPackage.DIAGNOSTIC__SOURCE_REFERENCE:
				setSourceReference((EObject)null);
				return;
			case ResultPackage.DIAGNOSTIC__EXCEPTION_TYPE:
				setExceptionType(EXCEPTION_TYPE_EDEFAULT);
				return;
			case ResultPackage.DIAGNOSTIC__ISSUES:
				getIssues().clear();
				return;
			case ResultPackage.DIAGNOSTIC__SOURCE:
				setSource(SOURCE_EDEFAULT);
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
			case ResultPackage.DIAGNOSTIC__TYPE:
				return type != TYPE_EDEFAULT;
			case ResultPackage.DIAGNOSTIC__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case ResultPackage.DIAGNOSTIC__SOURCE_REFERENCE:
				return sourceReference != null;
			case ResultPackage.DIAGNOSTIC__EXCEPTION_TYPE:
				return EXCEPTION_TYPE_EDEFAULT == null ? exceptionType != null : !EXCEPTION_TYPE_EDEFAULT.equals(exceptionType);
			case ResultPackage.DIAGNOSTIC__ISSUES:
				return issues != null && !issues.isEmpty();
			case ResultPackage.DIAGNOSTIC__SOURCE:
				return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
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
		result.append(" (type: ");
		result.append(type);
		result.append(", message: ");
		result.append(message);
		result.append(", exceptionType: ");
		result.append(exceptionType);
		result.append(", source: ");
		result.append(source);
		result.append(')');
		return result.toString();
	}

} //DiagnosticImpl
