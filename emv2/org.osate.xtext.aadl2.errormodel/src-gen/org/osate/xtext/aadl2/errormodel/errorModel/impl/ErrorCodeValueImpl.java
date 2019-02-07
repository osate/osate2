/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.PropertyConstant;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorCodeValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Code Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorCodeValueImpl#getIntValue <em>Int Value</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorCodeValueImpl#getConstant <em>Constant</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorCodeValueImpl#getEnumLiteral <em>Enum Literal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorCodeValueImpl extends ElementImpl implements ErrorCodeValue
{
  /**
   * The default value of the '{@link #getIntValue() <em>Int Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntValue()
   * @generated
   * @ordered
   */
  protected static final String INT_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIntValue() <em>Int Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntValue()
   * @generated
   * @ordered
   */
  protected String intValue = INT_VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getConstant() <em>Constant</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstant()
   * @generated
   * @ordered
   */
  protected PropertyConstant constant;

  /**
   * The default value of the '{@link #getEnumLiteral() <em>Enum Literal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumLiteral()
   * @generated
   * @ordered
   */
  protected static final String ENUM_LITERAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEnumLiteral() <em>Enum Literal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumLiteral()
   * @generated
   * @ordered
   */
  protected String enumLiteral = ENUM_LITERAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorCodeValueImpl()
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
    return ErrorModelPackage.Literals.ERROR_CODE_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIntValue()
  {
    return intValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntValue(String newIntValue)
  {
    String oldIntValue = intValue;
    intValue = newIntValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_CODE_VALUE__INT_VALUE, oldIntValue, intValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyConstant getConstant()
  {
    if (constant != null && ((EObject)constant).eIsProxy())
    {
      InternalEObject oldConstant = (InternalEObject)constant;
      constant = (PropertyConstant)eResolveProxy(oldConstant);
      if (constant != oldConstant)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_CODE_VALUE__CONSTANT, oldConstant, constant));
      }
    }
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyConstant basicGetConstant()
  {
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstant(PropertyConstant newConstant)
  {
    PropertyConstant oldConstant = constant;
    constant = newConstant;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_CODE_VALUE__CONSTANT, oldConstant, constant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEnumLiteral()
  {
    return enumLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumLiteral(String newEnumLiteral)
  {
    String oldEnumLiteral = enumLiteral;
    enumLiteral = newEnumLiteral;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_CODE_VALUE__ENUM_LITERAL, oldEnumLiteral, enumLiteral));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_CODE_VALUE__INT_VALUE:
        return getIntValue();
      case ErrorModelPackage.ERROR_CODE_VALUE__CONSTANT:
        if (resolve) return getConstant();
        return basicGetConstant();
      case ErrorModelPackage.ERROR_CODE_VALUE__ENUM_LITERAL:
        return getEnumLiteral();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_CODE_VALUE__INT_VALUE:
        setIntValue((String)newValue);
        return;
      case ErrorModelPackage.ERROR_CODE_VALUE__CONSTANT:
        setConstant((PropertyConstant)newValue);
        return;
      case ErrorModelPackage.ERROR_CODE_VALUE__ENUM_LITERAL:
        setEnumLiteral((String)newValue);
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
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_CODE_VALUE__INT_VALUE:
        setIntValue(INT_VALUE_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_CODE_VALUE__CONSTANT:
        setConstant((PropertyConstant)null);
        return;
      case ErrorModelPackage.ERROR_CODE_VALUE__ENUM_LITERAL:
        setEnumLiteral(ENUM_LITERAL_EDEFAULT);
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
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_CODE_VALUE__INT_VALUE:
        return INT_VALUE_EDEFAULT == null ? intValue != null : !INT_VALUE_EDEFAULT.equals(intValue);
      case ErrorModelPackage.ERROR_CODE_VALUE__CONSTANT:
        return constant != null;
      case ErrorModelPackage.ERROR_CODE_VALUE__ENUM_LITERAL:
        return ENUM_LITERAL_EDEFAULT == null ? enumLiteral != null : !ENUM_LITERAL_EDEFAULT.equals(enumLiteral);
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (intValue: ");
    result.append(intValue);
    result.append(", enumLiteral: ");
    result.append(enumLiteral);
    result.append(')');
    return result.toString();
  }

} //ErrorCodeValueImpl
