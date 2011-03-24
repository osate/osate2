/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;
import fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>While Or Do Until Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.WhileOrDoUntilStatementImpl#getLogicalValueExpression <em>Logical Value Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.WhileOrDoUntilStatementImpl#isDoUntil <em>Do Until</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WhileOrDoUntilStatementImpl extends LoopStatementImpl implements WhileOrDoUntilStatement {
	/**
	 * The cached value of the '{@link #getLogicalValueExpression() <em>Logical Value Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogicalValueExpression()
	 * @generated
	 * @ordered
	 */
	protected ValueExpression logicalValueExpression;

	/**
	 * The default value of the '{@link #isDoUntil() <em>Do Until</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDoUntil()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DO_UNTIL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDoUntil() <em>Do Until</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDoUntil()
	 * @generated
	 * @ordered
	 */
	protected boolean doUntil = DO_UNTIL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhileOrDoUntilStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.WHILE_OR_DO_UNTIL_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression getLogicalValueExpression() {
		return logicalValueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLogicalValueExpression(ValueExpression newLogicalValueExpression, NotificationChain msgs) {
		ValueExpression oldLogicalValueExpression = logicalValueExpression;
		logicalValueExpression = newLogicalValueExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION, oldLogicalValueExpression, newLogicalValueExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogicalValueExpression(ValueExpression newLogicalValueExpression) {
		if (newLogicalValueExpression != logicalValueExpression) {
			NotificationChain msgs = null;
			if (logicalValueExpression != null)
				msgs = ((InternalEObject)logicalValueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION, null, msgs);
			if (newLogicalValueExpression != null)
				msgs = ((InternalEObject)newLogicalValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION, null, msgs);
			msgs = basicSetLogicalValueExpression(newLogicalValueExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION, newLogicalValueExpression, newLogicalValueExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDoUntil() {
		return doUntil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDoUntil(boolean newDoUntil) {
		boolean oldDoUntil = doUntil;
		doUntil = newDoUntil;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL, oldDoUntil, doUntil));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION:
				return basicSetLogicalValueExpression(null, msgs);
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
			case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION:
				return getLogicalValueExpression();
			case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL:
				return isDoUntil();
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
			case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION:
				setLogicalValueExpression((ValueExpression)newValue);
				return;
			case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL:
				setDoUntil((Boolean)newValue);
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
			case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION:
				setLogicalValueExpression((ValueExpression)null);
				return;
			case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL:
				setDoUntil(DO_UNTIL_EDEFAULT);
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
			case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION:
				return logicalValueExpression != null;
			case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL:
				return doUntil != DO_UNTIL_EDEFAULT;
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
		result.append(" (doUntil: ");
		result.append(doUntil);
		result.append(')');
		return result.toString();
	}

} //WhileOrDoUntilStatementImpl
