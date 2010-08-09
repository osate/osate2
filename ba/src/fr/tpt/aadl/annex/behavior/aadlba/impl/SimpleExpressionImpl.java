/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression;
import fr.tpt.aadl.annex.behavior.aadlba.Term;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator;

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
 * An implementation of the model object '<em><b>Simple Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl#getTermsOwned <em>Terms Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl#getUnaryAddingOperatorOwned <em>Unary Adding Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl#isHasUnaryAddingOperator <em>Has Unary Adding Operator</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl#getBinaryAddingOperatorOwned <em>Binary Adding Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl#isHasBinaryAddingOperator <em>Has Binary Adding Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleExpressionImpl extends ElementImpl implements SimpleExpression
{
   /**
	 * The cached value of the '{@link #getTermsOwned() <em>Terms Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getTermsOwned()
	 * @generated
	 * @ordered
	 */
   protected EList<Term> termsOwned;

   /**
	 * The default value of the '{@link #getUnaryAddingOperatorOwned() <em>Unary Adding Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getUnaryAddingOperatorOwned()
	 * @generated
	 * @ordered
	 */
   protected static final UnaryAddingOperator UNARY_ADDING_OPERATOR_OWNED_EDEFAULT = UnaryAddingOperator.PLUS;

   /**
	 * The cached value of the '{@link #getUnaryAddingOperatorOwned() <em>Unary Adding Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getUnaryAddingOperatorOwned()
	 * @generated
	 * @ordered
	 */
   protected UnaryAddingOperator unaryAddingOperatorOwned = UNARY_ADDING_OPERATOR_OWNED_EDEFAULT;

   /**
	 * The default value of the '{@link #isHasUnaryAddingOperator() <em>Has Unary Adding Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasUnaryAddingOperator()
	 * @generated
	 * @ordered
	 */
   protected static final boolean HAS_UNARY_ADDING_OPERATOR_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isHasUnaryAddingOperator() <em>Has Unary Adding Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasUnaryAddingOperator()
	 * @generated
	 * @ordered
	 */
   protected boolean hasUnaryAddingOperator = HAS_UNARY_ADDING_OPERATOR_EDEFAULT;

   /**
	 * The cached value of the '{@link #getBinaryAddingOperatorOwned() <em>Binary Adding Operator Owned</em>}' attribute list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getBinaryAddingOperatorOwned()
	 * @generated
	 * @ordered
	 */
   protected EList<BinaryAddingOperator> binaryAddingOperatorOwned;

   /**
	 * The default value of the '{@link #isHasBinaryAddingOperator() <em>Has Binary Adding Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasBinaryAddingOperator()
	 * @generated
	 * @ordered
	 */
   protected static final boolean HAS_BINARY_ADDING_OPERATOR_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isHasBinaryAddingOperator() <em>Has Binary Adding Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasBinaryAddingOperator()
	 * @generated
	 * @ordered
	 */
   protected boolean hasBinaryAddingOperator = HAS_BINARY_ADDING_OPERATOR_EDEFAULT;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected SimpleExpressionImpl()
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
		return AadlBaPackage.Literals.SIMPLE_EXPRESSION;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<Term> getTermsOwned()
   {
		if (termsOwned == null) {
			termsOwned = new EObjectContainmentEList.Unsettable<Term>(Term.class, this, AadlBaPackage.SIMPLE_EXPRESSION__TERMS_OWNED);
		}
		return termsOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetTermsOwned()
   {
		if (termsOwned != null) ((InternalEList.Unsettable<?>)termsOwned).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetTermsOwned()
   {
		return termsOwned != null && ((InternalEList.Unsettable<?>)termsOwned).isSet();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public UnaryAddingOperator getUnaryAddingOperatorOwned()
   {
		return unaryAddingOperatorOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setUnaryAddingOperatorOwned(UnaryAddingOperator newUnaryAddingOperatorOwned)
   {
		UnaryAddingOperator oldUnaryAddingOperatorOwned = unaryAddingOperatorOwned;
		unaryAddingOperatorOwned = newUnaryAddingOperatorOwned == null ? UNARY_ADDING_OPERATOR_OWNED_EDEFAULT : newUnaryAddingOperatorOwned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED, oldUnaryAddingOperatorOwned, unaryAddingOperatorOwned));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isHasUnaryAddingOperator()
   {
		return hasUnaryAddingOperator;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setHasUnaryAddingOperator(boolean newHasUnaryAddingOperator)
   {
		boolean oldHasUnaryAddingOperator = hasUnaryAddingOperator;
		hasUnaryAddingOperator = newHasUnaryAddingOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.SIMPLE_EXPRESSION__HAS_UNARY_ADDING_OPERATOR, oldHasUnaryAddingOperator, hasUnaryAddingOperator));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<BinaryAddingOperator> getBinaryAddingOperatorOwned()
   {
		if (binaryAddingOperatorOwned == null) {
			binaryAddingOperatorOwned = new EDataTypeUniqueEList.Unsettable<BinaryAddingOperator>(BinaryAddingOperator.class, this, AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATOR_OWNED);
		}
		return binaryAddingOperatorOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetBinaryAddingOperatorOwned()
   {
		if (binaryAddingOperatorOwned != null) ((InternalEList.Unsettable<?>)binaryAddingOperatorOwned).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetBinaryAddingOperatorOwned()
   {
		return binaryAddingOperatorOwned != null && ((InternalEList.Unsettable<?>)binaryAddingOperatorOwned).isSet();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isHasBinaryAddingOperator()
   {
		return hasBinaryAddingOperator;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setHasBinaryAddingOperator(boolean newHasBinaryAddingOperator)
   {
		boolean oldHasBinaryAddingOperator = hasBinaryAddingOperator;
		hasBinaryAddingOperator = newHasBinaryAddingOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.SIMPLE_EXPRESSION__HAS_BINARY_ADDING_OPERATOR, oldHasBinaryAddingOperator, hasBinaryAddingOperator));
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
			case AadlBaPackage.SIMPLE_EXPRESSION__TERMS_OWNED:
				return ((InternalEList<?>)getTermsOwned()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.SIMPLE_EXPRESSION__TERMS_OWNED:
				return getTermsOwned();
			case AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED:
				return getUnaryAddingOperatorOwned();
			case AadlBaPackage.SIMPLE_EXPRESSION__HAS_UNARY_ADDING_OPERATOR:
				return isHasUnaryAddingOperator();
			case AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATOR_OWNED:
				return getBinaryAddingOperatorOwned();
			case AadlBaPackage.SIMPLE_EXPRESSION__HAS_BINARY_ADDING_OPERATOR:
				return isHasBinaryAddingOperator();
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
			case AadlBaPackage.SIMPLE_EXPRESSION__TERMS_OWNED:
				getTermsOwned().clear();
				getTermsOwned().addAll((Collection<? extends Term>)newValue);
				return;
			case AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED:
				setUnaryAddingOperatorOwned((UnaryAddingOperator)newValue);
				return;
			case AadlBaPackage.SIMPLE_EXPRESSION__HAS_UNARY_ADDING_OPERATOR:
				setHasUnaryAddingOperator((Boolean)newValue);
				return;
			case AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATOR_OWNED:
				getBinaryAddingOperatorOwned().clear();
				getBinaryAddingOperatorOwned().addAll((Collection<? extends BinaryAddingOperator>)newValue);
				return;
			case AadlBaPackage.SIMPLE_EXPRESSION__HAS_BINARY_ADDING_OPERATOR:
				setHasBinaryAddingOperator((Boolean)newValue);
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
			case AadlBaPackage.SIMPLE_EXPRESSION__TERMS_OWNED:
				unsetTermsOwned();
				return;
			case AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED:
				setUnaryAddingOperatorOwned(UNARY_ADDING_OPERATOR_OWNED_EDEFAULT);
				return;
			case AadlBaPackage.SIMPLE_EXPRESSION__HAS_UNARY_ADDING_OPERATOR:
				setHasUnaryAddingOperator(HAS_UNARY_ADDING_OPERATOR_EDEFAULT);
				return;
			case AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATOR_OWNED:
				unsetBinaryAddingOperatorOwned();
				return;
			case AadlBaPackage.SIMPLE_EXPRESSION__HAS_BINARY_ADDING_OPERATOR:
				setHasBinaryAddingOperator(HAS_BINARY_ADDING_OPERATOR_EDEFAULT);
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
			case AadlBaPackage.SIMPLE_EXPRESSION__TERMS_OWNED:
				return isSetTermsOwned();
			case AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED:
				return unaryAddingOperatorOwned != UNARY_ADDING_OPERATOR_OWNED_EDEFAULT;
			case AadlBaPackage.SIMPLE_EXPRESSION__HAS_UNARY_ADDING_OPERATOR:
				return hasUnaryAddingOperator != HAS_UNARY_ADDING_OPERATOR_EDEFAULT;
			case AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATOR_OWNED:
				return isSetBinaryAddingOperatorOwned();
			case AadlBaPackage.SIMPLE_EXPRESSION__HAS_BINARY_ADDING_OPERATOR:
				return hasBinaryAddingOperator != HAS_BINARY_ADDING_OPERATOR_EDEFAULT;
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
		result.append(" (UnaryAddingOperatorOwned: ");
		result.append(unaryAddingOperatorOwned);
		result.append(", hasUnaryAddingOperator: ");
		result.append(hasUnaryAddingOperator);
		result.append(", BinaryAddingOperatorOwned: ");
		result.append(binaryAddingOperatorOwned);
		result.append(", hasBinaryAddingOperator: ");
		result.append(hasBinaryAddingOperator);
		result.append(')');
		return result.toString();
	}

} //SimpleExpressionImpl
