/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.Factor;
import fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.Term;

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
 * An implementation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TermImpl#getFactorsOwned <em>Factors Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TermImpl#isHasMultiplyingOperator <em>Has Multiplying Operator</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TermImpl#getMultiplyingOperatorsOwned <em>Multiplying Operators Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TermImpl extends ElementImpl implements Term
{
   /**
	 * The cached value of the '{@link #getFactorsOwned() <em>Factors Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getFactorsOwned()
	 * @generated
	 * @ordered
	 */
   protected EList<Factor> factorsOwned;

   /**
	 * The default value of the '{@link #isHasMultiplyingOperator() <em>Has Multiplying Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasMultiplyingOperator()
	 * @generated
	 * @ordered
	 */
   protected static final boolean HAS_MULTIPLYING_OPERATOR_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isHasMultiplyingOperator() <em>Has Multiplying Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasMultiplyingOperator()
	 * @generated
	 * @ordered
	 */
   protected boolean hasMultiplyingOperator = HAS_MULTIPLYING_OPERATOR_EDEFAULT;

   /**
	 * The cached value of the '{@link #getMultiplyingOperatorsOwned() <em>Multiplying Operators Owned</em>}' attribute list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getMultiplyingOperatorsOwned()
	 * @generated
	 * @ordered
	 */
   protected EList<MultiplyingOperator> multiplyingOperatorsOwned;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected TermImpl()
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
		return AadlBaPackage.Literals.TERM;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<Factor> getFactorsOwned()
   {
		if (factorsOwned == null) {
			factorsOwned = new EObjectContainmentEList.Unsettable<Factor>(Factor.class, this, AadlBaPackage.TERM__FACTORS_OWNED);
		}
		return factorsOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetFactorsOwned()
   {
		if (factorsOwned != null) ((InternalEList.Unsettable<?>)factorsOwned).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetFactorsOwned()
   {
		return factorsOwned != null && ((InternalEList.Unsettable<?>)factorsOwned).isSet();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isHasMultiplyingOperator()
   {
		return hasMultiplyingOperator;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setHasMultiplyingOperator(boolean newHasMultiplyingOperator)
   {
		boolean oldHasMultiplyingOperator = hasMultiplyingOperator;
		hasMultiplyingOperator = newHasMultiplyingOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.TERM__HAS_MULTIPLYING_OPERATOR, oldHasMultiplyingOperator, hasMultiplyingOperator));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<MultiplyingOperator> getMultiplyingOperatorsOwned()
   {
		if (multiplyingOperatorsOwned == null) {
			multiplyingOperatorsOwned = new EDataTypeUniqueEList.Unsettable<MultiplyingOperator>(MultiplyingOperator.class, this, AadlBaPackage.TERM__MULTIPLYING_OPERATORS_OWNED);
		}
		return multiplyingOperatorsOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetMultiplyingOperatorsOwned()
   {
		if (multiplyingOperatorsOwned != null) ((InternalEList.Unsettable<?>)multiplyingOperatorsOwned).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetMultiplyingOperatorsOwned()
   {
		return multiplyingOperatorsOwned != null && ((InternalEList.Unsettable<?>)multiplyingOperatorsOwned).isSet();
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
			case AadlBaPackage.TERM__FACTORS_OWNED:
				return ((InternalEList<?>)getFactorsOwned()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.TERM__FACTORS_OWNED:
				return getFactorsOwned();
			case AadlBaPackage.TERM__HAS_MULTIPLYING_OPERATOR:
				return isHasMultiplyingOperator();
			case AadlBaPackage.TERM__MULTIPLYING_OPERATORS_OWNED:
				return getMultiplyingOperatorsOwned();
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
			case AadlBaPackage.TERM__FACTORS_OWNED:
				getFactorsOwned().clear();
				getFactorsOwned().addAll((Collection<? extends Factor>)newValue);
				return;
			case AadlBaPackage.TERM__HAS_MULTIPLYING_OPERATOR:
				setHasMultiplyingOperator((Boolean)newValue);
				return;
			case AadlBaPackage.TERM__MULTIPLYING_OPERATORS_OWNED:
				getMultiplyingOperatorsOwned().clear();
				getMultiplyingOperatorsOwned().addAll((Collection<? extends MultiplyingOperator>)newValue);
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
			case AadlBaPackage.TERM__FACTORS_OWNED:
				unsetFactorsOwned();
				return;
			case AadlBaPackage.TERM__HAS_MULTIPLYING_OPERATOR:
				setHasMultiplyingOperator(HAS_MULTIPLYING_OPERATOR_EDEFAULT);
				return;
			case AadlBaPackage.TERM__MULTIPLYING_OPERATORS_OWNED:
				unsetMultiplyingOperatorsOwned();
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
			case AadlBaPackage.TERM__FACTORS_OWNED:
				return isSetFactorsOwned();
			case AadlBaPackage.TERM__HAS_MULTIPLYING_OPERATOR:
				return hasMultiplyingOperator != HAS_MULTIPLYING_OPERATOR_EDEFAULT;
			case AadlBaPackage.TERM__MULTIPLYING_OPERATORS_OWNED:
				return isSetMultiplyingOperatorsOwned();
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
		result.append(" (hasMultiplyingOperator: ");
		result.append(hasMultiplyingOperator);
		result.append(", MultiplyingOperatorsOwned: ");
		result.append(multiplyingOperatorsOwned);
		result.append(')');
		return result.toString();
	}

} //TermImpl
