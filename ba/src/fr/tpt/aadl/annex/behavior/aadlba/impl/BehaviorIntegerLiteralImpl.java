/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import edu.cmu.sei.aadl.aadl2.Aadl2Package;
import edu.cmu.sei.aadl.aadl2.Element ;
import edu.cmu.sei.aadl.aadl2.IntegerLiteral;
import edu.cmu.sei.aadl.aadl2.NumberValue;
import edu.cmu.sei.aadl.aadl2.PropertyExpression;
import edu.cmu.sei.aadl.aadl2.PropertyValue;
import edu.cmu.sei.aadl.aadl2.UnitLiteral;
import edu.cmu.sei.aadl.aadl2.impl.IntegerLiteralImpl ;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorIntegerLiteral;

import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.InternalEObject ;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Integer Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorIntegerLiteralImpl#getValueString <em>Value String</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorIntegerLiteralImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorIntegerLiteralImpl#getBase <em>Base</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorIntegerLiteralImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 */
public class BehaviorIntegerLiteralImpl extends IntegerLiteralImpl implements BehaviorIntegerLiteral {
	/**
	 * The default value of the '{@link #getValueString() <em>Value String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueString()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValueString() <em>Value String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueString()
	 * @generated
	 * @ordered
	 */
	protected String valueString = VALUE_STRING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected UnitLiteral unit;

	/**
	 * The default value of the '{@link #getBase() <em>Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase()
	 * @generated
	 * @ordered
	 */
	protected static final long BASE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getBase() <em>Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase()
	 * @generated
	 * @ordered
	 */
	protected long base = BASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final long VALUE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected long value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorIntegerLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.BEHAVIOR_INTEGER_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueString() {
		return valueString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueString(String newValueString) {
		String oldValueString = valueString;
		valueString = newValueString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE_STRING, oldValueString, valueString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitLiteral getUnit() {
		if (unit != null && ((EObject)unit).eIsProxy()) {
			InternalEObject oldUnit = (InternalEObject)unit;
			unit = (UnitLiteral)eResolveProxy(oldUnit);
			if (unit != oldUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__UNIT, oldUnit, unit));
			}
		}
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitLiteral basicGetUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(UnitLiteral newUnit) {
		UnitLiteral oldUnit = unit;
		unit = newUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__UNIT, oldUnit, unit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getBase() {
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase(long newBase) {
		long oldBase = base;
		base = newBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__BASE, oldBase, base));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(long newValue) {
		long oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE_STRING:
				return getValueString();
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__UNIT:
				if (resolve) return getUnit();
				return basicGetUnit();
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__BASE:
				return getBase();
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE:
				return getValue();
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
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE_STRING:
				setValueString((String)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__UNIT:
				setUnit((UnitLiteral)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__BASE:
				setBase((Long)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE:
				setValue((Long)newValue);
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
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE_STRING:
				setValueString(VALUE_STRING_EDEFAULT);
				return;
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__UNIT:
				setUnit((UnitLiteral)null);
				return;
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__BASE:
				setBase(BASE_EDEFAULT);
				return;
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE:
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
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE_STRING:
				return VALUE_STRING_EDEFAULT == null ? valueString != null : !VALUE_STRING_EDEFAULT.equals(valueString);
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__UNIT:
				return unit != null;
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__BASE:
				return base != BASE_EDEFAULT;
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE:
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
		if (baseClass == NumberValue.class) {
			switch (derivedFeatureID) {
				case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE_STRING: return Aadl2Package.NUMBER_VALUE__VALUE_STRING;
				case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__UNIT: return Aadl2Package.NUMBER_VALUE__UNIT;
				default: return -1;
			}
		}
		if (baseClass == IntegerLiteral.class) {
			switch (derivedFeatureID) {
				case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__BASE: return Aadl2Package.INTEGER_LITERAL__BASE;
				case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE: return Aadl2Package.INTEGER_LITERAL__VALUE;
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
		if (baseClass == NumberValue.class) {
			switch (baseFeatureID) {
				case Aadl2Package.NUMBER_VALUE__VALUE_STRING: return AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE_STRING;
				case Aadl2Package.NUMBER_VALUE__UNIT: return AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__UNIT;
				default: return -1;
			}
		}
		if (baseClass == IntegerLiteral.class) {
			switch (baseFeatureID) {
				case Aadl2Package.INTEGER_LITERAL__BASE: return AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__BASE;
				case Aadl2Package.INTEGER_LITERAL__VALUE: return AadlBaPackage.BEHAVIOR_INTEGER_LITERAL__VALUE;
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
		result.append(" (valueString: ");
		result.append(valueString);
		result.append(", base: ");
		result.append(base);
		result.append(", value: ");
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

} //BehaviorIntegerLiteralImpl
