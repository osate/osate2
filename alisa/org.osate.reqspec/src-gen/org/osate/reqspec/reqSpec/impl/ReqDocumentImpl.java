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

import org.osate.alisa.common.common.Description;

import org.osate.reqspec.reqSpec.ReqDocument;
import org.osate.reqspec.reqSpec.ReqSpecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Req Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqDocumentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqDocumentImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqDocumentImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqDocumentImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqDocumentImpl#getIssues <em>Issues</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReqDocumentImpl extends ReqSpecContainerImpl implements ReqDocument
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
   * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected Description description;

  /**
   * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected EList<EObject> content;

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
  protected ReqDocumentImpl()
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
    return ReqSpecPackage.Literals.REQ_DOCUMENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_DOCUMENT__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_DOCUMENT__TITLE, oldTitle, title));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_DOCUMENT__DESCRIPTION, oldDescription, newDescription);
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
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.REQ_DOCUMENT__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.REQ_DOCUMENT__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_DOCUMENT__DESCRIPTION, newDescription, newDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getContent()
  {
    if (content == null)
    {
      content = new EObjectContainmentEList<EObject>(EObject.class, this, ReqSpecPackage.REQ_DOCUMENT__CONTENT);
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
      issues = new EDataTypeEList<String>(String.class, this, ReqSpecPackage.REQ_DOCUMENT__ISSUES);
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
      case ReqSpecPackage.REQ_DOCUMENT__DESCRIPTION:
        return basicSetDescription(null, msgs);
      case ReqSpecPackage.REQ_DOCUMENT__CONTENT:
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
      case ReqSpecPackage.REQ_DOCUMENT__NAME:
        return getName();
      case ReqSpecPackage.REQ_DOCUMENT__TITLE:
        return getTitle();
      case ReqSpecPackage.REQ_DOCUMENT__DESCRIPTION:
        return getDescription();
      case ReqSpecPackage.REQ_DOCUMENT__CONTENT:
        return getContent();
      case ReqSpecPackage.REQ_DOCUMENT__ISSUES:
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
      case ReqSpecPackage.REQ_DOCUMENT__NAME:
        setName((String)newValue);
        return;
      case ReqSpecPackage.REQ_DOCUMENT__TITLE:
        setTitle((String)newValue);
        return;
      case ReqSpecPackage.REQ_DOCUMENT__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case ReqSpecPackage.REQ_DOCUMENT__CONTENT:
        getContent().clear();
        getContent().addAll((Collection<? extends EObject>)newValue);
        return;
      case ReqSpecPackage.REQ_DOCUMENT__ISSUES:
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
      case ReqSpecPackage.REQ_DOCUMENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ReqSpecPackage.REQ_DOCUMENT__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case ReqSpecPackage.REQ_DOCUMENT__DESCRIPTION:
        setDescription((Description)null);
        return;
      case ReqSpecPackage.REQ_DOCUMENT__CONTENT:
        getContent().clear();
        return;
      case ReqSpecPackage.REQ_DOCUMENT__ISSUES:
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
      case ReqSpecPackage.REQ_DOCUMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ReqSpecPackage.REQ_DOCUMENT__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case ReqSpecPackage.REQ_DOCUMENT__DESCRIPTION:
        return description != null;
      case ReqSpecPackage.REQ_DOCUMENT__CONTENT:
        return content != null && !content.isEmpty();
      case ReqSpecPackage.REQ_DOCUMENT__ISSUES:
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
    result.append(", issues: ");
    result.append(issues);
    result.append(')');
    return result.toString();
  }

} //ReqDocumentImpl
