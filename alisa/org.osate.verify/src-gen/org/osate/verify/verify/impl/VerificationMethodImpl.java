/**
 */
package org.osate.verify.verify.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmFormalParameter;

import org.osate.aadl2.Property;

import org.osate.alisa.common.common.Description;

import org.osate.categories.categories.Category;

import org.osate.verify.verify.MethodType;
import org.osate.verify.verify.VerificationCondition;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getParams <em>Params</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#isIsPredicate <em>Is Predicate</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#isIsResultReport <em>Is Result Report</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getMethodType <em>Method Type</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationMethodImpl#getCategory <em>Category</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VerificationMethodImpl extends MinimalEObjectImpl.Container implements VerificationMethod
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParams()
   * @generated
   * @ordered
   */
  protected EList<JvmFormalParameter> params;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<Property> properties;

  /**
   * The default value of the '{@link #isIsPredicate() <em>Is Predicate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsPredicate()
   * @generated
   * @ordered
   */
  protected static final boolean IS_PREDICATE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsPredicate() <em>Is Predicate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsPredicate()
   * @generated
   * @ordered
   */
  protected boolean isPredicate = IS_PREDICATE_EDEFAULT;

  /**
   * The default value of the '{@link #isIsResultReport() <em>Is Result Report</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsResultReport()
   * @generated
   * @ordered
   */
  protected static final boolean IS_RESULT_REPORT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsResultReport() <em>Is Result Report</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsResultReport()
   * @generated
   * @ordered
   */
  protected boolean isResultReport = IS_RESULT_REPORT_EDEFAULT;

  /**
   * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected static final String TITLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected String title = TITLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getMethodType() <em>Method Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodType()
   * @generated
   * @ordered
   */
  protected MethodType methodType;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected Description description;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected VerificationCondition condition;

  /**
   * The cached value of the '{@link #getCategory() <em>Category</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected EList<Category> category;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VerificationMethodImpl()
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
    return VerifyPackage.Literals.VERIFICATION_METHOD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<JvmFormalParameter> getParams()
  {
    if (params == null)
    {
      params = new EObjectContainmentEList<JvmFormalParameter>(JvmFormalParameter.class, this, VerifyPackage.VERIFICATION_METHOD__PARAMS);
    }
    return params;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Property> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectResolvingEList<Property>(Property.class, this, VerifyPackage.VERIFICATION_METHOD__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsPredicate()
  {
    return isPredicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsPredicate(boolean newIsPredicate)
  {
    boolean oldIsPredicate = isPredicate;
    isPredicate = newIsPredicate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__IS_PREDICATE, oldIsPredicate, isPredicate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsResultReport()
  {
    return isResultReport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsResultReport(boolean newIsResultReport)
  {
    boolean oldIsResultReport = isResultReport;
    isResultReport = newIsResultReport;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__IS_RESULT_REPORT, oldIsResultReport, isResultReport));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTitle(String newTitle)
  {
    String oldTitle = title;
    title = newTitle;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MethodType getMethodType()
  {
    return methodType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMethodType(MethodType newMethodType, NotificationChain msgs)
  {
    MethodType oldMethodType = methodType;
    methodType = newMethodType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE, oldMethodType, newMethodType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethodType(MethodType newMethodType)
  {
    if (newMethodType != methodType)
    {
      NotificationChain msgs = null;
      if (methodType != null)
        msgs = ((InternalEObject)methodType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE, null, msgs);
      if (newMethodType != null)
        msgs = ((InternalEObject)newMethodType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE, null, msgs);
      msgs = basicSetMethodType(newMethodType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE, newMethodType, newMethodType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Description getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDescription(Description newDescription, NotificationChain msgs)
  {
    Description oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__DESCRIPTION, oldDescription, newDescription);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(Description newDescription)
  {
    if (newDescription != description)
    {
      NotificationChain msgs = null;
      if (description != null)
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__DESCRIPTION, newDescription, newDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationCondition getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(VerificationCondition newCondition, NotificationChain msgs)
  {
    VerificationCondition oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(VerificationCondition newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_METHOD__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_METHOD__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Category> getCategory()
  {
    if (category == null)
    {
      category = new EObjectResolvingEList<Category>(Category.class, this, VerifyPackage.VERIFICATION_METHOD__CATEGORY);
    }
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case VerifyPackage.VERIFICATION_METHOD__PARAMS:
        return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
      case VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE:
        return basicSetMethodType(null, msgs);
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        return basicSetDescription(null, msgs);
      case VerifyPackage.VERIFICATION_METHOD__CONDITION:
        return basicSetCondition(null, msgs);
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
    switch (featureID)
    {
      case VerifyPackage.VERIFICATION_METHOD__NAME:
        return getName();
      case VerifyPackage.VERIFICATION_METHOD__PARAMS:
        return getParams();
      case VerifyPackage.VERIFICATION_METHOD__PROPERTIES:
        return getProperties();
      case VerifyPackage.VERIFICATION_METHOD__IS_PREDICATE:
        return isIsPredicate();
      case VerifyPackage.VERIFICATION_METHOD__IS_RESULT_REPORT:
        return isIsResultReport();
      case VerifyPackage.VERIFICATION_METHOD__TITLE:
        return getTitle();
      case VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE:
        return getMethodType();
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        return getDescription();
      case VerifyPackage.VERIFICATION_METHOD__CONDITION:
        return getCondition();
      case VerifyPackage.VERIFICATION_METHOD__CATEGORY:
        return getCategory();
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
    switch (featureID)
    {
      case VerifyPackage.VERIFICATION_METHOD__NAME:
        setName((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__PARAMS:
        getParams().clear();
        getParams().addAll((Collection<? extends JvmFormalParameter>)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends Property>)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__IS_PREDICATE:
        setIsPredicate((Boolean)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__IS_RESULT_REPORT:
        setIsResultReport((Boolean)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__TITLE:
        setTitle((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE:
        setMethodType((MethodType)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__CONDITION:
        setCondition((VerificationCondition)newValue);
        return;
      case VerifyPackage.VERIFICATION_METHOD__CATEGORY:
        getCategory().clear();
        getCategory().addAll((Collection<? extends Category>)newValue);
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
      case VerifyPackage.VERIFICATION_METHOD__NAME:
        setName(NAME_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__PARAMS:
        getParams().clear();
        return;
      case VerifyPackage.VERIFICATION_METHOD__PROPERTIES:
        getProperties().clear();
        return;
      case VerifyPackage.VERIFICATION_METHOD__IS_PREDICATE:
        setIsPredicate(IS_PREDICATE_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__IS_RESULT_REPORT:
        setIsResultReport(IS_RESULT_REPORT_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE:
        setMethodType((MethodType)null);
        return;
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        setDescription((Description)null);
        return;
      case VerifyPackage.VERIFICATION_METHOD__CONDITION:
        setCondition((VerificationCondition)null);
        return;
      case VerifyPackage.VERIFICATION_METHOD__CATEGORY:
        getCategory().clear();
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
      case VerifyPackage.VERIFICATION_METHOD__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case VerifyPackage.VERIFICATION_METHOD__PARAMS:
        return params != null && !params.isEmpty();
      case VerifyPackage.VERIFICATION_METHOD__PROPERTIES:
        return properties != null && !properties.isEmpty();
      case VerifyPackage.VERIFICATION_METHOD__IS_PREDICATE:
        return isPredicate != IS_PREDICATE_EDEFAULT;
      case VerifyPackage.VERIFICATION_METHOD__IS_RESULT_REPORT:
        return isResultReport != IS_RESULT_REPORT_EDEFAULT;
      case VerifyPackage.VERIFICATION_METHOD__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case VerifyPackage.VERIFICATION_METHOD__METHOD_TYPE:
        return methodType != null;
      case VerifyPackage.VERIFICATION_METHOD__DESCRIPTION:
        return description != null;
      case VerifyPackage.VERIFICATION_METHOD__CONDITION:
        return condition != null;
      case VerifyPackage.VERIFICATION_METHOD__CATEGORY:
        return category != null && !category.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(", isPredicate: ");
    result.append(isPredicate);
    result.append(", isResultReport: ");
    result.append(isResultReport);
    result.append(", title: ");
    result.append(title);
    result.append(')');
    return result.toString();
  }

} //VerificationMethodImpl
