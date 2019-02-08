/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.IfCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.IfConditionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.IfConditionImpl#getResoluteFunction <em>Resolute Function</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.IfConditionImpl#getJavaMethod <em>Java Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfConditionImpl extends MinimalEObjectImpl.Container implements IfCondition
{
  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getResoluteFunction() <em>Resolute Function</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResoluteFunction()
   * @generated
   * @ordered
   */
  protected EObject resoluteFunction;

  /**
   * The default value of the '{@link #getJavaMethod() <em>Java Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaMethod()
   * @generated
   * @ordered
   */
  protected static final String JAVA_METHOD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getJavaMethod() <em>Java Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaMethod()
   * @generated
   * @ordered
   */
  protected String javaMethod = JAVA_METHOD_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfConditionImpl()
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
    return ErrorModelPackage.Literals.IF_CONDITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.IF_CONDITION__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getResoluteFunction()
  {
    if (resoluteFunction != null && resoluteFunction.eIsProxy())
    {
      InternalEObject oldResoluteFunction = (InternalEObject)resoluteFunction;
      resoluteFunction = eResolveProxy(oldResoluteFunction);
      if (resoluteFunction != oldResoluteFunction)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.IF_CONDITION__RESOLUTE_FUNCTION, oldResoluteFunction, resoluteFunction));
      }
    }
    return resoluteFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetResoluteFunction()
  {
    return resoluteFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResoluteFunction(EObject newResoluteFunction)
  {
    EObject oldResoluteFunction = resoluteFunction;
    resoluteFunction = newResoluteFunction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.IF_CONDITION__RESOLUTE_FUNCTION, oldResoluteFunction, resoluteFunction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getJavaMethod()
  {
    return javaMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJavaMethod(String newJavaMethod)
  {
    String oldJavaMethod = javaMethod;
    javaMethod = newJavaMethod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.IF_CONDITION__JAVA_METHOD, oldJavaMethod, javaMethod));
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
      case ErrorModelPackage.IF_CONDITION__DESCRIPTION:
        return getDescription();
      case ErrorModelPackage.IF_CONDITION__RESOLUTE_FUNCTION:
        if (resolve) return getResoluteFunction();
        return basicGetResoluteFunction();
      case ErrorModelPackage.IF_CONDITION__JAVA_METHOD:
        return getJavaMethod();
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
      case ErrorModelPackage.IF_CONDITION__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case ErrorModelPackage.IF_CONDITION__RESOLUTE_FUNCTION:
        setResoluteFunction((EObject)newValue);
        return;
      case ErrorModelPackage.IF_CONDITION__JAVA_METHOD:
        setJavaMethod((String)newValue);
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
      case ErrorModelPackage.IF_CONDITION__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case ErrorModelPackage.IF_CONDITION__RESOLUTE_FUNCTION:
        setResoluteFunction((EObject)null);
        return;
      case ErrorModelPackage.IF_CONDITION__JAVA_METHOD:
        setJavaMethod(JAVA_METHOD_EDEFAULT);
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
      case ErrorModelPackage.IF_CONDITION__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case ErrorModelPackage.IF_CONDITION__RESOLUTE_FUNCTION:
        return resoluteFunction != null;
      case ErrorModelPackage.IF_CONDITION__JAVA_METHOD:
        return JAVA_METHOD_EDEFAULT == null ? javaMethod != null : !JAVA_METHOD_EDEFAULT.equals(javaMethod);
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
    result.append(" (description: ");
    result.append(description);
    result.append(", javaMethod: ");
    result.append(javaMethod);
    result.append(')');
    return result.toString();
  }

} //IfConditionImpl
