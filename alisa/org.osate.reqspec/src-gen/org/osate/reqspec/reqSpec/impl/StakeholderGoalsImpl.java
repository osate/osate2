/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;

import org.osate.alisa.common.common.AVariableDeclaration;
import org.osate.alisa.common.common.Description;

import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.GlobalConstants;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.StakeholderGoals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stakeholder Goals</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getComponentCategory <em>Component Category</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getImportConstants <em>Import Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getDocReference <em>Doc Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getIssues <em>Issues</em>}</li>
 * </ul>
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
  protected ComponentClassifier target;

  /**
   * The cached value of the '{@link #getComponentCategory() <em>Component Category</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentCategory()
   * @generated
   * @ordered
   */
  protected EList<ComponentCategory> componentCategory;

  /**
   * The cached value of the '{@link #getImportConstants() <em>Import Constants</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportConstants()
   * @generated
   * @ordered
   */
  protected EList<GlobalConstants> importConstants;

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
  protected EList<AVariableDeclaration> constants;

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
   * The cached value of the '{@link #getDocReference() <em>Doc Reference</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocReference()
   * @generated
   * @ordered
   */
  protected EList<ExternalDocument> docReference;

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
  public ComponentClassifier getTarget()
  {
    if (target != null && ((EObject)target).eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (ComponentClassifier)eResolveProxy(oldTarget);
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
  public ComponentClassifier basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(ComponentClassifier newTarget)
  {
    ComponentClassifier oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.STAKEHOLDER_GOALS__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ComponentCategory> getComponentCategory()
  {
    if (componentCategory == null)
    {
      componentCategory = new EDataTypeEList<ComponentCategory>(ComponentCategory.class, this, ReqSpecPackage.STAKEHOLDER_GOALS__COMPONENT_CATEGORY);
    }
    return componentCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GlobalConstants> getImportConstants()
  {
    if (importConstants == null)
    {
      importConstants = new EObjectResolvingEList<GlobalConstants>(GlobalConstants.class, this, ReqSpecPackage.STAKEHOLDER_GOALS__IMPORT_CONSTANTS);
    }
    return importConstants;
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
  public EList<AVariableDeclaration> getConstants()
  {
    if (constants == null)
    {
      constants = new EObjectContainmentEList<AVariableDeclaration>(AVariableDeclaration.class, this, ReqSpecPackage.STAKEHOLDER_GOALS__CONSTANTS);
    }
    return constants;
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
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONSTANTS:
        return ((InternalEList<?>)getConstants()).basicRemove(otherEnd, msgs);
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONTENT:
        return ((InternalEList<?>)getContent()).basicRemove(otherEnd, msgs);
      case ReqSpecPackage.STAKEHOLDER_GOALS__DOC_REFERENCE:
        return ((InternalEList<?>)getDocReference()).basicRemove(otherEnd, msgs);
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
      case ReqSpecPackage.STAKEHOLDER_GOALS__COMPONENT_CATEGORY:
        return getComponentCategory();
      case ReqSpecPackage.STAKEHOLDER_GOALS__IMPORT_CONSTANTS:
        return getImportConstants();
      case ReqSpecPackage.STAKEHOLDER_GOALS__DESCRIPTION:
        return getDescription();
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONSTANTS:
        return getConstants();
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONTENT:
        return getContent();
      case ReqSpecPackage.STAKEHOLDER_GOALS__DOC_REFERENCE:
        return getDocReference();
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
        setTarget((ComponentClassifier)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__COMPONENT_CATEGORY:
        getComponentCategory().clear();
        getComponentCategory().addAll((Collection<? extends ComponentCategory>)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__IMPORT_CONSTANTS:
        getImportConstants().clear();
        getImportConstants().addAll((Collection<? extends GlobalConstants>)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONSTANTS:
        getConstants().clear();
        getConstants().addAll((Collection<? extends AVariableDeclaration>)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONTENT:
        getContent().clear();
        getContent().addAll((Collection<? extends Goal>)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__DOC_REFERENCE:
        getDocReference().clear();
        getDocReference().addAll((Collection<? extends ExternalDocument>)newValue);
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
        setTarget((ComponentClassifier)null);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__COMPONENT_CATEGORY:
        getComponentCategory().clear();
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__IMPORT_CONSTANTS:
        getImportConstants().clear();
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__DESCRIPTION:
        setDescription((Description)null);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONSTANTS:
        getConstants().clear();
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONTENT:
        getContent().clear();
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__DOC_REFERENCE:
        getDocReference().clear();
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
      case ReqSpecPackage.STAKEHOLDER_GOALS__COMPONENT_CATEGORY:
        return componentCategory != null && !componentCategory.isEmpty();
      case ReqSpecPackage.STAKEHOLDER_GOALS__IMPORT_CONSTANTS:
        return importConstants != null && !importConstants.isEmpty();
      case ReqSpecPackage.STAKEHOLDER_GOALS__DESCRIPTION:
        return description != null;
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONSTANTS:
        return constants != null && !constants.isEmpty();
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONTENT:
        return content != null && !content.isEmpty();
      case ReqSpecPackage.STAKEHOLDER_GOALS__DOC_REFERENCE:
        return docReference != null && !docReference.isEmpty();
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
    result.append(", componentCategory: ");
    result.append(componentCategory);
    result.append(", issues: ");
    result.append(issues);
    result.append(')');
    return result.toString();
  }

} //StakeholderGoalsImpl
