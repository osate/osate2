/**
 */
package org.osate.reqspec.reqSpec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.Classifier;

import org.osate.alisa.common.common.Description;

import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.StakeholderGoals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stakeholder Goals</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getTargetDescription <em>Target Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#isGlobal <em>Global</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getDocReference <em>Doc Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getIssues <em>Issues</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StakeholderGoalsImpl extends ReqSpecContainerImpl implements StakeholderGoals
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
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Classifier target;

  /**
   * The default value of the '{@link #getTargetDescription() <em>Target Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetDescription()
   * @generated
   * @ordered
   */
  protected static final String TARGET_DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTargetDescription() <em>Target Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetDescription()
   * @generated
   * @ordered
   */
  protected String targetDescription = TARGET_DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #isGlobal() <em>Global</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGlobal()
   * @generated
   * @ordered
   */
  protected static final boolean GLOBAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isGlobal() <em>Global</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGlobal()
   * @generated
   * @ordered
   */
  protected boolean global = GLOBAL_EDEFAULT;

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
   * The cached value of the '{@link #getDocReference() <em>Doc Reference</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocReference()
   * @generated
   * @ordered
   */
  protected EList<ExternalDocument> docReference;

  /**
   * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected EList<Goal> content;

  /**
   * The cached value of the '{@link #getIssues() <em>Issues</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIssues()
   * @generated
   * @ordered
   */
  protected EList<String> issues;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StakeholderGoalsImpl()
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
    return ReqSpecPackage.Literals.STAKEHOLDER_GOALS;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.STAKEHOLDER_GOALS__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.STAKEHOLDER_GOALS__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Classifier getTarget()
  {
    if (target != null && ((EObject)target).eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (Classifier)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.STAKEHOLDER_GOALS__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Classifier basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(Classifier newTarget)
  {
    Classifier oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.STAKEHOLDER_GOALS__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTargetDescription()
  {
    return targetDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetDescription(String newTargetDescription)
  {
    String oldTargetDescription = targetDescription;
    targetDescription = newTargetDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.STAKEHOLDER_GOALS__TARGET_DESCRIPTION, oldTargetDescription, targetDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isGlobal()
  {
    return global;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGlobal(boolean newGlobal)
  {
    boolean oldGlobal = global;
    global = newGlobal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.STAKEHOLDER_GOALS__GLOBAL, oldGlobal, global));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.STAKEHOLDER_GOALS__DESCRIPTION, oldDescription, newDescription);
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
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.STAKEHOLDER_GOALS__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.STAKEHOLDER_GOALS__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.STAKEHOLDER_GOALS__DESCRIPTION, newDescription, newDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExternalDocument> getDocReference()
  {
    if (docReference == null)
    {
      docReference = new EObjectContainmentEList<ExternalDocument>(ExternalDocument.class, this, ReqSpecPackage.STAKEHOLDER_GOALS__DOC_REFERENCE);
    }
    return docReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Goal> getContent()
  {
    if (content == null)
    {
      content = new EObjectContainmentEList<Goal>(Goal.class, this, ReqSpecPackage.STAKEHOLDER_GOALS__CONTENT);
    }
    return content;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getIssues()
  {
    if (issues == null)
    {
      issues = new EDataTypeEList<String>(String.class, this, ReqSpecPackage.STAKEHOLDER_GOALS__ISSUES);
    }
    return issues;
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
      case ReqSpecPackage.STAKEHOLDER_GOALS__DESCRIPTION:
        return basicSetDescription(null, msgs);
      case ReqSpecPackage.STAKEHOLDER_GOALS__DOC_REFERENCE:
        return ((InternalEList<?>)getDocReference()).basicRemove(otherEnd, msgs);
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONTENT:
        return ((InternalEList<?>)getContent()).basicRemove(otherEnd, msgs);
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
      case ReqSpecPackage.STAKEHOLDER_GOALS__NAME:
        return getName();
      case ReqSpecPackage.STAKEHOLDER_GOALS__TITLE:
        return getTitle();
      case ReqSpecPackage.STAKEHOLDER_GOALS__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case ReqSpecPackage.STAKEHOLDER_GOALS__TARGET_DESCRIPTION:
        return getTargetDescription();
      case ReqSpecPackage.STAKEHOLDER_GOALS__GLOBAL:
        return isGlobal();
      case ReqSpecPackage.STAKEHOLDER_GOALS__DESCRIPTION:
        return getDescription();
      case ReqSpecPackage.STAKEHOLDER_GOALS__DOC_REFERENCE:
        return getDocReference();
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONTENT:
        return getContent();
      case ReqSpecPackage.STAKEHOLDER_GOALS__ISSUES:
        return getIssues();
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
      case ReqSpecPackage.STAKEHOLDER_GOALS__NAME:
        setName((String)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__TITLE:
        setTitle((String)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__TARGET:
        setTarget((Classifier)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__TARGET_DESCRIPTION:
        setTargetDescription((String)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__GLOBAL:
        setGlobal((Boolean)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__DOC_REFERENCE:
        getDocReference().clear();
        getDocReference().addAll((Collection<? extends ExternalDocument>)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONTENT:
        getContent().clear();
        getContent().addAll((Collection<? extends Goal>)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__ISSUES:
        getIssues().clear();
        getIssues().addAll((Collection<? extends String>)newValue);
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
      case ReqSpecPackage.STAKEHOLDER_GOALS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__TARGET:
        setTarget((Classifier)null);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__TARGET_DESCRIPTION:
        setTargetDescription(TARGET_DESCRIPTION_EDEFAULT);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__GLOBAL:
        setGlobal(GLOBAL_EDEFAULT);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__DESCRIPTION:
        setDescription((Description)null);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__DOC_REFERENCE:
        getDocReference().clear();
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONTENT:
        getContent().clear();
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__ISSUES:
        getIssues().clear();
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
      case ReqSpecPackage.STAKEHOLDER_GOALS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ReqSpecPackage.STAKEHOLDER_GOALS__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case ReqSpecPackage.STAKEHOLDER_GOALS__TARGET:
        return target != null;
      case ReqSpecPackage.STAKEHOLDER_GOALS__TARGET_DESCRIPTION:
        return TARGET_DESCRIPTION_EDEFAULT == null ? targetDescription != null : !TARGET_DESCRIPTION_EDEFAULT.equals(targetDescription);
      case ReqSpecPackage.STAKEHOLDER_GOALS__GLOBAL:
        return global != GLOBAL_EDEFAULT;
      case ReqSpecPackage.STAKEHOLDER_GOALS__DESCRIPTION:
        return description != null;
      case ReqSpecPackage.STAKEHOLDER_GOALS__DOC_REFERENCE:
        return docReference != null && !docReference.isEmpty();
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONTENT:
        return content != null && !content.isEmpty();
      case ReqSpecPackage.STAKEHOLDER_GOALS__ISSUES:
        return issues != null && !issues.isEmpty();
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
    result.append(", targetDescription: ");
    result.append(targetDescription);
    result.append(", global: ");
    result.append(global);
    result.append(", issues: ");
    result.append(issues);
    result.append(')');
    return result.toString();
  }

} //StakeholderGoalsImpl
