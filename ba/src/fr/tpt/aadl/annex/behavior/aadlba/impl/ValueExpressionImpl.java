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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl#getRelationsOwned <em>Relations Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl#getLogicalOperatorsOwned <em>Logical Operators Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl#isHasLogicalOperator <em>Has Logical Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueExpressionImpl extends ValueImpl implements ValueExpression
{
   /**
	 * The cached value of the '{@link #getRelationsOwned() <em>Relations Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getRelationsOwned()
	 * @generated
	 * @ordered
	 */
   protected EList<Relation> relationsOwned;

   /**
	 * The cached value of the '{@link #getLogicalOperatorsOwned() <em>Logical Operators Owned</em>}' attribute list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getLogicalOperatorsOwned()
	 * @generated
	 * @ordered
	 */
   protected EList<LogicalOperator> logicalOperatorsOwned;

   /**
	 * The default value of the '{@link #isHasLogicalOperator() <em>Has Logical Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasLogicalOperator()
	 * @generated
	 * @ordered
	 */
   protected static final boolean HAS_LOGICAL_OPERATOR_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isHasLogicalOperator() <em>Has Logical Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasLogicalOperator()
	 * @generated
	 * @ordered
	 */
   protected boolean hasLogicalOperator = HAS_LOGICAL_OPERATOR_EDEFAULT;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected ValueExpressionImpl()
   {
		super();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   protected EClass eStaticClass()
   {
		return AadlBaPackage.Literals.VALUE_EXPRESSION;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<Relation> getRelationsOwned()
   {
		if (relationsOwned == null) {
			relationsOwned = new EObjectContainmentEList.Unsettable<Relation>(Relation.class, this, AadlBaPackage.VALUE_EXPRESSION__RELATIONS_OWNED);
		}
		return relationsOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetRelationsOwned()
   {
		if (relationsOwned != null) ((InternalEList.Unsettable<?>)relationsOwned).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetRelationsOwned()
   {
		return relationsOwned != null && ((InternalEList.Unsettable<?>)relationsOwned).isSet();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<LogicalOperator> getLogicalOperatorsOwned()
   {
		if (logicalOperatorsOwned == null) {
			logicalOperatorsOwned = new EDataTypeUniqueEList.Unsettable<LogicalOperator>(LogicalOperator.class, this, AadlBaPackage.VALUE_EXPRESSION__LOGICAL_OPERATORS_OWNED);
		}
		return logicalOperatorsOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetLogicalOperatorsOwned()
   {
		if (logicalOperatorsOwned != null) ((InternalEList.Unsettable<?>)logicalOperatorsOwned).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetLogicalOperatorsOwned()
   {
		return logicalOperatorsOwned != null && ((InternalEList.Unsettable<?>)logicalOperatorsOwned).isSet();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isHasLogicalOperator()
   {
		return hasLogicalOperator;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setHasLogicalOperator(boolean newHasLogicalOperator)
   {
		boolean oldHasLogicalOperator = hasLogicalOperator;
		hasLogicalOperator = newHasLogicalOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.VALUE_EXPRESSION__HAS_LOGICAL_OPERATOR, oldHasLogicalOperator, hasLogicalOperator));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
   {
		switch (featureID) {
			case AadlBaPackage.VALUE_EXPRESSION__RELATIONS_OWNED:
				return ((InternalEList<?>)getRelationsOwned()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType)
   {
		switch (featureID) {
			case AadlBaPackage.VALUE_EXPRESSION__RELATIONS_OWNED:
				return getRelationsOwned();
			case AadlBaPackage.VALUE_EXPRESSION__LOGICAL_OPERATORS_OWNED:
				return getLogicalOperatorsOwned();
			case AadlBaPackage.VALUE_EXPRESSION__HAS_LOGICAL_OPERATOR:
				return isHasLogicalOperator();
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
   public void eSet(int featureID, Object newValue)
   {
		switch (featureID) {
			case AadlBaPackage.VALUE_EXPRESSION__RELATIONS_OWNED:
				getRelationsOwned().clear();
				getRelationsOwned().addAll((Collection<? extends Relation>)newValue);
				return;
			case AadlBaPackage.VALUE_EXPRESSION__LOGICAL_OPERATORS_OWNED:
				getLogicalOperatorsOwned().clear();
				getLogicalOperatorsOwned().addAll((Collection<? extends LogicalOperator>)newValue);
				return;
			case AadlBaPackage.VALUE_EXPRESSION__HAS_LOGICAL_OPERATOR:
				setHasLogicalOperator((Boolean)newValue);
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
   public void eUnset(int featureID)
   {
		switch (featureID) {
			case AadlBaPackage.VALUE_EXPRESSION__RELATIONS_OWNED:
				unsetRelationsOwned();
				return;
			case AadlBaPackage.VALUE_EXPRESSION__LOGICAL_OPERATORS_OWNED:
				unsetLogicalOperatorsOwned();
				return;
			case AadlBaPackage.VALUE_EXPRESSION__HAS_LOGICAL_OPERATOR:
				setHasLogicalOperator(HAS_LOGICAL_OPERATOR_EDEFAULT);
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
   public boolean eIsSet(int featureID)
   {
		switch (featureID) {
			case AadlBaPackage.VALUE_EXPRESSION__RELATIONS_OWNED:
				return isSetRelationsOwned();
			case AadlBaPackage.VALUE_EXPRESSION__LOGICAL_OPERATORS_OWNED:
				return isSetLogicalOperatorsOwned();
			case AadlBaPackage.VALUE_EXPRESSION__HAS_LOGICAL_OPERATOR:
				return hasLogicalOperator != HAS_LOGICAL_OPERATOR_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public String toString()
   {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (LogicalOperatorsOwned: ");
		result.append(logicalOperatorsOwned);
		result.append(", hasLogicalOperator: ");
		result.append(hasLogicalOperator);
		result.append(')');
		return result.toString();
	}

} //ValueExpressionImpl
