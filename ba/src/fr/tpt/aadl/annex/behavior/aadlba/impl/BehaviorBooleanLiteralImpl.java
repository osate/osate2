/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import edu.cmu.sei.aadl.aadl2.Aadl2Package;
import edu.cmu.sei.aadl.aadl2.BooleanLiteral;
import edu.cmu.sei.aadl.aadl2.Element ;
import edu.cmu.sei.aadl.aadl2.PropertyExpression;
import edu.cmu.sei.aadl.aadl2.PropertyValue;
import edu.cmu.sei.aadl.aadl2.impl.BooleanLiteralImpl ;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorBooleanLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.InternalEObject ;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Boolean Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorBooleanLiteralImpl#isValue <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 */
public class BehaviorBooleanLiteralImpl extends BooleanLiteralImpl implements BehaviorBooleanLiteral {
	/**
	 * The default value of the '{@link #isValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValue()
	 * @generated
	 * @ordered
	 */
	protected boolean value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorBooleanLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.BEHAVIOR_BOOLEAN_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(boolean newValue) {
		boolean oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL__VALUE:
				return isValue();
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
			case AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL__VALUE:
				setValue((Boolean)newValue);
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
			case AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL__VALUE:
				return value != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IntegerValue.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IntegerValueConstant.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PropertyExpression.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PropertyValue.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == BooleanLiteral.class) {
			switch (derivedFeatureID) {
				case AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL__VALUE: return Aadl2Package.BOOLEAN_LITERAL__VALUE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IntegerValue.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IntegerValueConstant.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PropertyExpression.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PropertyValue.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == BooleanLiteral.class) {
			switch (baseFeatureID) {
				case Aadl2Package.BOOLEAN_LITERAL__VALUE: return AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL__VALUE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

	protected BehaviorElement baRef;
	
	protected Element aadlRef;
	
	@Override
   public BehaviorElement getBaRef() {
      if (baRef != null && ((EObject)baRef).eIsProxy()) {
         InternalEObject oldBaRef = (InternalEObject)baRef;
         baRef = (BehaviorElement)eResolveProxy(oldBaRef);
         if (baRef != oldBaRef) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_ELEMENT__BA_REF, oldBaRef, baRef));
         }
      }
      return baRef;
   }

   public BehaviorElement basicGetBaRef() {
      return baRef;
   }

   @Override
   public void setBaRef(BehaviorElement newBaRef) {
      BehaviorElement oldBaRef = baRef;
      baRef = newBaRef;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ELEMENT__BA_REF, oldBaRef, baRef));
   }

   @Override
   public Element getAadlRef() {
      if (aadlRef != null && ((EObject)aadlRef).eIsProxy()) {
         InternalEObject oldAadlRef = (InternalEObject)aadlRef;
         aadlRef = (Element)eResolveProxy(oldAadlRef);
         if (aadlRef != oldAadlRef) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_ELEMENT__AADL_REF, oldAadlRef, aadlRef));
         }
      }
      return aadlRef;
   }

   public Element basicGetAadlRef() {
      return aadlRef;
   }

   @Override
   public void setAadlRef(Element newAadlRef) {
      Element oldAadlRef = aadlRef;
      aadlRef = newAadlRef;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ELEMENT__AADL_REF, oldAadlRef, aadlRef));
   }

} //BehaviorBooleanLiteralImpl
