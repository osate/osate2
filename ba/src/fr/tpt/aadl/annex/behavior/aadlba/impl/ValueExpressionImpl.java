/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator;
import fr.tpt.aadl.annex.behavior.aadlba.Relation;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl#getRelations <em>Relations</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl#getLogicalOperators <em>Logical Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueExpressionImpl extends ElementImpl implements ValueExpression {
	/**
	 * The cached value of the '{@link #getRelations() <em>Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> relations;

	/**
	 * The cached value of the '{@link #getLogicalOperators() <em>Logical Operators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogicalOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<LogicalOperator> logicalOperators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.VALUE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getRelations() {
		if (relations == null) {
			relations = new EObjectContainmentEList.Unsettable<Relation>(Relation.class, this, AadlBaPackage.VALUE_EXPRESSION__RELATIONS);
		}
		return relations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRelations() {
		if (relations != null) ((InternalEList.Unsettable<?>)relations).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRelations() {
		return relations != null && ((InternalEList.Unsettable<?>)relations).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LogicalOperator> getLogicalOperators() {
		if (logicalOperators == null) {
			logicalOperators = new EDataTypeEList.Unsettable<LogicalOperator>(LogicalOperator.class, this, AadlBaPackage.VALUE_EXPRESSION__LOGICAL_OPERATORS);
		}
		return logicalOperators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLogicalOperators() {
		if (logicalOperators != null) ((InternalEList.Unsettable<?>)logicalOperators).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLogicalOperators() {
		return logicalOperators != null && ((InternalEList.Unsettable<?>)logicalOperators).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.VALUE_EXPRESSION__RELATIONS:
				return ((InternalEList<?>)getRelations()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.VALUE_EXPRESSION__RELATIONS:
				return getRelations();
			case AadlBaPackage.VALUE_EXPRESSION__LOGICAL_OPERATORS:
				return getLogicalOperators();
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
			case AadlBaPackage.VALUE_EXPRESSION__RELATIONS:
				getRelations().clear();
				getRelations().addAll((Collection<? extends Relation>)newValue);
				return;
			case AadlBaPackage.VALUE_EXPRESSION__LOGICAL_OPERATORS:
				getLogicalOperators().clear();
				getLogicalOperators().addAll((Collection<? extends LogicalOperator>)newValue);
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
			case AadlBaPackage.VALUE_EXPRESSION__RELATIONS:
				unsetRelations();
				return;
			case AadlBaPackage.VALUE_EXPRESSION__LOGICAL_OPERATORS:
				unsetLogicalOperators();
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
			case AadlBaPackage.VALUE_EXPRESSION__RELATIONS:
				return isSetRelations();
			case AadlBaPackage.VALUE_EXPRESSION__LOGICAL_OPERATORS:
				return isSetLogicalOperators();
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
		result.append(" (logicalOperators: ");
		result.append(logicalOperators);
		result.append(')');
		return result.toString();
	}

} //ValueExpressionImpl
