/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
import fr.tpt.aadl.annex.behavior.aadlba.IfStatement;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl#isHasElse <em>Has Else</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl#getValueExpressionOwned <em>Value Expression Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfStatementImpl extends ElementImpl implements IfStatement
{
   /**
	 * The default value of the '{@link #isHasElse() <em>Has Else</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasElse()
	 * @generated
	 * @ordered
	 */
   protected static final boolean HAS_ELSE_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isHasElse() <em>Has Else</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasElse()
	 * @generated
	 * @ordered
	 */
   protected boolean hasElse = HAS_ELSE_EDEFAULT;

   /**
	 * The cached value of the '{@link #getValueExpressionOwned() <em>Value Expression Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getValueExpressionOwned()
	 * @generated
	 * @ordered
	 */
   protected EList<ValueExpression> valueExpressionOwned;

   /**
	 * The cached value of the '{@link #getBehaviorActionsOwned() <em>Behavior Actions Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getBehaviorActionsOwned()
	 * @generated
	 * @ordered
	 */
   protected EList<BehaviorActions> behaviorActionsOwned;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected IfStatementImpl()
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
		return AadlBaPackage.Literals.IF_STATEMENT;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isHasElse()
   {
		return hasElse;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setHasElse(boolean newHasElse)
   {
		boolean oldHasElse = hasElse;
		hasElse = newHasElse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.IF_STATEMENT__HAS_ELSE, oldHasElse, hasElse));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<ValueExpression> getValueExpressionOwned()
   {
		if (valueExpressionOwned == null) {
			valueExpressionOwned = new EObjectContainmentEList.Unsettable<ValueExpression>(ValueExpression.class, this, AadlBaPackage.IF_STATEMENT__VALUE_EXPRESSION_OWNED);
		}
		return valueExpressionOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetValueExpressionOwned()
   {
		if (valueExpressionOwned != null) ((InternalEList.Unsettable<?>)valueExpressionOwned).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetValueExpressionOwned()
   {
		return valueExpressionOwned != null && ((InternalEList.Unsettable<?>)valueExpressionOwned).isSet();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<BehaviorActions> getBehaviorActionsOwned()
   {
		if (behaviorActionsOwned == null) {
			behaviorActionsOwned = new EObjectContainmentEList.Unsettable<BehaviorActions>(BehaviorActions.class, this, AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED);
		}
		return behaviorActionsOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetBehaviorActionsOwned()
   {
		if (behaviorActionsOwned != null) ((InternalEList.Unsettable<?>)behaviorActionsOwned).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetBehaviorActionsOwned()
   {
		return behaviorActionsOwned != null && ((InternalEList.Unsettable<?>)behaviorActionsOwned).isSet();
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
			case AadlBaPackage.IF_STATEMENT__VALUE_EXPRESSION_OWNED:
				return ((InternalEList<?>)getValueExpressionOwned()).basicRemove(otherEnd, msgs);
			case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				return ((InternalEList<?>)getBehaviorActionsOwned()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.IF_STATEMENT__HAS_ELSE:
				return isHasElse();
			case AadlBaPackage.IF_STATEMENT__VALUE_EXPRESSION_OWNED:
				return getValueExpressionOwned();
			case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				return getBehaviorActionsOwned();
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
			case AadlBaPackage.IF_STATEMENT__HAS_ELSE:
				setHasElse((Boolean)newValue);
				return;
			case AadlBaPackage.IF_STATEMENT__VALUE_EXPRESSION_OWNED:
				getValueExpressionOwned().clear();
				getValueExpressionOwned().addAll((Collection<? extends ValueExpression>)newValue);
				return;
			case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				getBehaviorActionsOwned().clear();
				getBehaviorActionsOwned().addAll((Collection<? extends BehaviorActions>)newValue);
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
			case AadlBaPackage.IF_STATEMENT__HAS_ELSE:
				setHasElse(HAS_ELSE_EDEFAULT);
				return;
			case AadlBaPackage.IF_STATEMENT__VALUE_EXPRESSION_OWNED:
				unsetValueExpressionOwned();
				return;
			case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				unsetBehaviorActionsOwned();
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
			case AadlBaPackage.IF_STATEMENT__HAS_ELSE:
				return hasElse != HAS_ELSE_EDEFAULT;
			case AadlBaPackage.IF_STATEMENT__VALUE_EXPRESSION_OWNED:
				return isSetValueExpressionOwned();
			case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				return isSetBehaviorActionsOwned();
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
		result.append(" (hasElse: ");
		result.append(hasElse);
		result.append(')');
		return result.toString();
	}

} //IfStatementImpl
