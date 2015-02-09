/**
 */
package org.osate.alisa.workbench.alisa.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.XExpression;

import org.osate.aadl2.ComponentImplementation;

import org.osate.alisa.common.common.Description;

import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AssuranceCaseConfiguration;

import org.osate.categories.categories.SelectionCategory;

import org.osate.verify.verify.VerificationPlan;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assurance Case Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceCaseConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceCaseConfigurationImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceCaseConfigurationImpl#getSystem <em>System</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceCaseConfigurationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceCaseConfigurationImpl#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceCaseConfigurationImpl#getPlans <em>Plans</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.AssuranceCaseConfigurationImpl#getSelectionFilter <em>Selection Filter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssuranceCaseConfigurationImpl extends MinimalEObjectImpl.Container implements AssuranceCaseConfiguration
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
   * The cached value of the '{@link #getSystem() <em>System</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystem()
   * @generated
   * @ordered
   */
  protected ComponentImplementation system;

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
   * The cached value of the '{@link #getConstants() <em>Constants</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstants()
   * @generated
   * @ordered
   */
  protected EList<XExpression> constants;

  /**
   * The cached value of the '{@link #getPlans() <em>Plans</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlans()
   * @generated
   * @ordered
   */
  protected EList<VerificationPlan> plans;

  /**
   * The cached value of the '{@link #getSelectionFilter() <em>Selection Filter</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelectionFilter()
   * @generated
   * @ordered
   */
  protected EList<SelectionCategory> selectionFilter;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssuranceCaseConfigurationImpl()
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
    return AlisaPackage.Literals.ASSURANCE_CASE_CONFIGURATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_CASE_CONFIGURATION__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_CASE_CONFIGURATION__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentImplementation getSystem()
  {
    if (system != null && ((EObject)system).eIsProxy())
    {
      InternalEObject oldSystem = (InternalEObject)system;
      system = (ComponentImplementation)eResolveProxy(oldSystem);
      if (system != oldSystem)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlisaPackage.ASSURANCE_CASE_CONFIGURATION__SYSTEM, oldSystem, system));
      }
    }
    return system;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentImplementation basicGetSystem()
  {
    return system;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSystem(ComponentImplementation newSystem)
  {
    ComponentImplementation oldSystem = system;
    system = newSystem;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_CASE_CONFIGURATION__SYSTEM, oldSystem, system));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_CASE_CONFIGURATION__DESCRIPTION, oldDescription, newDescription);
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
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlisaPackage.ASSURANCE_CASE_CONFIGURATION__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlisaPackage.ASSURANCE_CASE_CONFIGURATION__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.ASSURANCE_CASE_CONFIGURATION__DESCRIPTION, newDescription, newDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XExpression> getConstants()
  {
    if (constants == null)
    {
      constants = new EObjectContainmentEList<XExpression>(XExpression.class, this, AlisaPackage.ASSURANCE_CASE_CONFIGURATION__CONSTANTS);
    }
    return constants;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationPlan> getPlans()
  {
    if (plans == null)
    {
      plans = new EObjectResolvingEList<VerificationPlan>(VerificationPlan.class, this, AlisaPackage.ASSURANCE_CASE_CONFIGURATION__PLANS);
    }
    return plans;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SelectionCategory> getSelectionFilter()
  {
    if (selectionFilter == null)
    {
      selectionFilter = new EObjectResolvingEList<SelectionCategory>(SelectionCategory.class, this, AlisaPackage.ASSURANCE_CASE_CONFIGURATION__SELECTION_FILTER);
    }
    return selectionFilter;
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
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__DESCRIPTION:
        return basicSetDescription(null, msgs);
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__CONSTANTS:
        return ((InternalEList<?>)getConstants()).basicRemove(otherEnd, msgs);
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
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__NAME:
        return getName();
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__TITLE:
        return getTitle();
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__SYSTEM:
        if (resolve) return getSystem();
        return basicGetSystem();
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__DESCRIPTION:
        return getDescription();
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__CONSTANTS:
        return getConstants();
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__PLANS:
        return getPlans();
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__SELECTION_FILTER:
        return getSelectionFilter();
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
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__NAME:
        setName((String)newValue);
        return;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__TITLE:
        setTitle((String)newValue);
        return;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__SYSTEM:
        setSystem((ComponentImplementation)newValue);
        return;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__CONSTANTS:
        getConstants().clear();
        getConstants().addAll((Collection<? extends XExpression>)newValue);
        return;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__PLANS:
        getPlans().clear();
        getPlans().addAll((Collection<? extends VerificationPlan>)newValue);
        return;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__SELECTION_FILTER:
        getSelectionFilter().clear();
        getSelectionFilter().addAll((Collection<? extends SelectionCategory>)newValue);
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
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__SYSTEM:
        setSystem((ComponentImplementation)null);
        return;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__DESCRIPTION:
        setDescription((Description)null);
        return;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__CONSTANTS:
        getConstants().clear();
        return;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__PLANS:
        getPlans().clear();
        return;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__SELECTION_FILTER:
        getSelectionFilter().clear();
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
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__SYSTEM:
        return system != null;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__DESCRIPTION:
        return description != null;
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__CONSTANTS:
        return constants != null && !constants.isEmpty();
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__PLANS:
        return plans != null && !plans.isEmpty();
      case AlisaPackage.ASSURANCE_CASE_CONFIGURATION__SELECTION_FILTER:
        return selectionFilter != null && !selectionFilter.isEmpty();
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
    result.append(", title: ");
    result.append(title);
    result.append(')');
    return result.toString();
  }

} //AssuranceCaseConfigurationImpl
