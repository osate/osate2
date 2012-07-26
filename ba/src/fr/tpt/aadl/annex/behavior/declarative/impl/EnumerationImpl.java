/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.declarative.impl;

import fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage;
import fr.tpt.aadl.annex.behavior.declarative.Enumeration;
import fr.tpt.aadl.annex.behavior.declarative.Identifier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.impl.EnumerationImpl#getLiteral <em>Literal</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.impl.EnumerationImpl#getProperty <em>Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationImpl extends QualifiedNamedElementImpl implements
		Enumeration {
	/**
	 * The cached value of the '{@link #getLiteral() <em>Literal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteral()
	 * @generated
	 * @ordered
	 */
	protected Identifier literal;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Identifier property;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeclarativePackage.Literals.ENUMERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getLiteral() {
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLiteral(Identifier newLiteral,
			NotificationChain msgs) {
		Identifier oldLiteral = literal;
		literal = newLiteral;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, DeclarativePackage.ENUMERATION__LITERAL,
					oldLiteral, newLiteral);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiteral(Identifier newLiteral) {
		if (newLiteral != literal) {
			NotificationChain msgs = null;
			if (literal != null)
				msgs = ((InternalEObject) literal).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- DeclarativePackage.ENUMERATION__LITERAL,
						null, msgs);
			if (newLiteral != null)
				msgs = ((InternalEObject) newLiteral).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- DeclarativePackage.ENUMERATION__LITERAL,
						null, msgs);
			msgs = basicSetLiteral(newLiteral, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DeclarativePackage.ENUMERATION__LITERAL, newLiteral,
					newLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperty(Identifier newProperty,
			NotificationChain msgs) {
		Identifier oldProperty = property;
		property = newProperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, DeclarativePackage.ENUMERATION__PROPERTY,
					oldProperty, newProperty);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(Identifier newProperty) {
		if (newProperty != property) {
			NotificationChain msgs = null;
			if (property != null)
				msgs = ((InternalEObject) property).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- DeclarativePackage.ENUMERATION__PROPERTY,
						null, msgs);
			if (newProperty != null)
				msgs = ((InternalEObject) newProperty).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- DeclarativePackage.ENUMERATION__PROPERTY,
						null, msgs);
			msgs = basicSetProperty(newProperty, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DeclarativePackage.ENUMERATION__PROPERTY, newProperty,
					newProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DeclarativePackage.ENUMERATION__LITERAL:
			return basicSetLiteral(null, msgs);
		case DeclarativePackage.ENUMERATION__PROPERTY:
			return basicSetProperty(null, msgs);
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
		case DeclarativePackage.ENUMERATION__LITERAL:
			return getLiteral();
		case DeclarativePackage.ENUMERATION__PROPERTY:
			return getProperty();
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
		case DeclarativePackage.ENUMERATION__LITERAL:
			setLiteral((Identifier) newValue);
			return;
		case DeclarativePackage.ENUMERATION__PROPERTY:
			setProperty((Identifier) newValue);
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
		case DeclarativePackage.ENUMERATION__LITERAL:
			setLiteral((Identifier) null);
			return;
		case DeclarativePackage.ENUMERATION__PROPERTY:
			setProperty((Identifier) null);
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
		case DeclarativePackage.ENUMERATION__LITERAL:
			return literal != null;
		case DeclarativePackage.ENUMERATION__PROPERTY:
			return property != null;
		}
		return super.eIsSet(featureID);
	}

} //EnumerationImpl
