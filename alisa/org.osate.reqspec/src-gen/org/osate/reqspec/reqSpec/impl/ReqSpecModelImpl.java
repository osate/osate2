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

import org.eclipse.xtext.xtype.XImportDeclaration;

import org.osate.aadl2.Classifier;

import org.osate.reqspec.reqSpec.ReqSpecContainer;
import org.osate.reqspec.reqSpec.ReqSpecModel;
import org.osate.reqspec.reqSpec.ReqSpecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecModelImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecModelImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecModelImpl#getIssue <em>Issue</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecModelImpl#getImportDeclarations <em>Import Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReqSpecModelImpl extends ReqSpecImpl implements ReqSpecModel
{
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
   * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected EList<EObject> content;

  /**
   * The cached value of the '{@link #getIssue() <em>Issue</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIssue()
   * @generated
   * @ordered
   */
  protected EList<String> issue;

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
   * The cached value of the '{@link #getImportDeclarations() <em>Import Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportDeclarations()
   * @generated
   * @ordered
   */
  protected EList<XImportDeclaration> importDeclarations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReqSpecModelImpl()
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
    return ReqSpecPackage.Literals.REQ_SPEC_MODEL;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.REQ_SPEC_MODEL__TARGET, oldTarget, target));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_SPEC_MODEL__TARGET, oldTarget, target));
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
      content = new EObjectContainmentEList<EObject>(EObject.class, this, ReqSpecPackage.REQ_SPEC_MODEL__CONTENT);
    }
    return content;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getIssue()
  {
    if (issue == null)
    {
      issue = new EDataTypeEList<String>(String.class, this, ReqSpecPackage.REQ_SPEC_MODEL__ISSUE);
    }
    return issue;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_SPEC_MODEL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XImportDeclaration> getImportDeclarations()
  {
    if (importDeclarations == null)
    {
      importDeclarations = new EObjectContainmentEList<XImportDeclaration>(XImportDeclaration.class, this, ReqSpecPackage.REQ_SPEC_MODEL__IMPORT_DECLARATIONS);
    }
    return importDeclarations;
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
      case ReqSpecPackage.REQ_SPEC_MODEL__CONTENT:
        return ((InternalEList<?>)getContent()).basicRemove(otherEnd, msgs);
      case ReqSpecPackage.REQ_SPEC_MODEL__IMPORT_DECLARATIONS:
        return ((InternalEList<?>)getImportDeclarations()).basicRemove(otherEnd, msgs);
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
      case ReqSpecPackage.REQ_SPEC_MODEL__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case ReqSpecPackage.REQ_SPEC_MODEL__CONTENT:
        return getContent();
      case ReqSpecPackage.REQ_SPEC_MODEL__ISSUE:
        return getIssue();
      case ReqSpecPackage.REQ_SPEC_MODEL__NAME:
        return getName();
      case ReqSpecPackage.REQ_SPEC_MODEL__IMPORT_DECLARATIONS:
        return getImportDeclarations();
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
      case ReqSpecPackage.REQ_SPEC_MODEL__TARGET:
        setTarget((Classifier)newValue);
        return;
      case ReqSpecPackage.REQ_SPEC_MODEL__CONTENT:
        getContent().clear();
        getContent().addAll((Collection<? extends EObject>)newValue);
        return;
      case ReqSpecPackage.REQ_SPEC_MODEL__ISSUE:
        getIssue().clear();
        getIssue().addAll((Collection<? extends String>)newValue);
        return;
      case ReqSpecPackage.REQ_SPEC_MODEL__NAME:
        setName((String)newValue);
        return;
      case ReqSpecPackage.REQ_SPEC_MODEL__IMPORT_DECLARATIONS:
        getImportDeclarations().clear();
        getImportDeclarations().addAll((Collection<? extends XImportDeclaration>)newValue);
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
      case ReqSpecPackage.REQ_SPEC_MODEL__TARGET:
        setTarget((Classifier)null);
        return;
      case ReqSpecPackage.REQ_SPEC_MODEL__CONTENT:
        getContent().clear();
        return;
      case ReqSpecPackage.REQ_SPEC_MODEL__ISSUE:
        getIssue().clear();
        return;
      case ReqSpecPackage.REQ_SPEC_MODEL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ReqSpecPackage.REQ_SPEC_MODEL__IMPORT_DECLARATIONS:
        getImportDeclarations().clear();
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
      case ReqSpecPackage.REQ_SPEC_MODEL__TARGET:
        return target != null;
      case ReqSpecPackage.REQ_SPEC_MODEL__CONTENT:
        return content != null && !content.isEmpty();
      case ReqSpecPackage.REQ_SPEC_MODEL__ISSUE:
        return issue != null && !issue.isEmpty();
      case ReqSpecPackage.REQ_SPEC_MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ReqSpecPackage.REQ_SPEC_MODEL__IMPORT_DECLARATIONS:
        return importDeclarations != null && !importDeclarations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == ReqSpecContainer.class)
    {
      switch (derivedFeatureID)
      {
        case ReqSpecPackage.REQ_SPEC_MODEL__TARGET: return ReqSpecPackage.REQ_SPEC_CONTAINER__TARGET;
        case ReqSpecPackage.REQ_SPEC_MODEL__CONTENT: return ReqSpecPackage.REQ_SPEC_CONTAINER__CONTENT;
        case ReqSpecPackage.REQ_SPEC_MODEL__ISSUE: return ReqSpecPackage.REQ_SPEC_CONTAINER__ISSUE;
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
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == ReqSpecContainer.class)
    {
      switch (baseFeatureID)
      {
        case ReqSpecPackage.REQ_SPEC_CONTAINER__TARGET: return ReqSpecPackage.REQ_SPEC_MODEL__TARGET;
        case ReqSpecPackage.REQ_SPEC_CONTAINER__CONTENT: return ReqSpecPackage.REQ_SPEC_MODEL__CONTENT;
        case ReqSpecPackage.REQ_SPEC_CONTAINER__ISSUE: return ReqSpecPackage.REQ_SPEC_MODEL__ISSUE;
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
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (issue: ");
    result.append(issue);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ReqSpecModelImpl
