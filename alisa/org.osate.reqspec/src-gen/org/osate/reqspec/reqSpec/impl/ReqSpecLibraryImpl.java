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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.Classifier;

import org.osate.alisa.common.common.FinalValue;

import org.osate.reqspec.reqSpec.ReqSpecLibrary;
import org.osate.reqspec.reqSpec.ReqSpecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecLibraryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecLibraryImpl#getImportedNamespace <em>Imported Namespace</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecLibraryImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecLibraryImpl#getConstants <em>Constants</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReqSpecLibraryImpl extends ReqSpecContainerImpl implements ReqSpecLibrary
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
   * The default value of the '{@link #getImportedNamespace() <em>Imported Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportedNamespace()
   * @generated
   * @ordered
   */
  protected static final String IMPORTED_NAMESPACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImportedNamespace() <em>Imported Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportedNamespace()
   * @generated
   * @ordered
   */
  protected String importedNamespace = IMPORTED_NAMESPACE_EDEFAULT;

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
   * The cached value of the '{@link #getConstants() <em>Constants</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstants()
   * @generated
   * @ordered
   */
  protected EList<FinalValue> constants;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReqSpecLibraryImpl()
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
    return ReqSpecPackage.Literals.REQ_SPEC_LIBRARY;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_SPEC_LIBRARY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getImportedNamespace()
  {
    return importedNamespace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImportedNamespace(String newImportedNamespace)
  {
    String oldImportedNamespace = importedNamespace;
    importedNamespace = newImportedNamespace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_SPEC_LIBRARY__IMPORTED_NAMESPACE, oldImportedNamespace, importedNamespace));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.REQ_SPEC_LIBRARY__TARGET, oldTarget, target));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_SPEC_LIBRARY__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FinalValue> getConstants()
  {
    if (constants == null)
    {
      constants = new EObjectContainmentEList<FinalValue>(FinalValue.class, this, ReqSpecPackage.REQ_SPEC_LIBRARY__CONSTANTS);
    }
    return constants;
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
      case ReqSpecPackage.REQ_SPEC_LIBRARY__CONSTANTS:
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
      case ReqSpecPackage.REQ_SPEC_LIBRARY__NAME:
        return getName();
      case ReqSpecPackage.REQ_SPEC_LIBRARY__IMPORTED_NAMESPACE:
        return getImportedNamespace();
      case ReqSpecPackage.REQ_SPEC_LIBRARY__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case ReqSpecPackage.REQ_SPEC_LIBRARY__CONSTANTS:
        return getConstants();
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
      case ReqSpecPackage.REQ_SPEC_LIBRARY__NAME:
        setName((String)newValue);
        return;
      case ReqSpecPackage.REQ_SPEC_LIBRARY__IMPORTED_NAMESPACE:
        setImportedNamespace((String)newValue);
        return;
      case ReqSpecPackage.REQ_SPEC_LIBRARY__TARGET:
        setTarget((Classifier)newValue);
        return;
      case ReqSpecPackage.REQ_SPEC_LIBRARY__CONSTANTS:
        getConstants().clear();
        getConstants().addAll((Collection<? extends FinalValue>)newValue);
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
      case ReqSpecPackage.REQ_SPEC_LIBRARY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ReqSpecPackage.REQ_SPEC_LIBRARY__IMPORTED_NAMESPACE:
        setImportedNamespace(IMPORTED_NAMESPACE_EDEFAULT);
        return;
      case ReqSpecPackage.REQ_SPEC_LIBRARY__TARGET:
        setTarget((Classifier)null);
        return;
      case ReqSpecPackage.REQ_SPEC_LIBRARY__CONSTANTS:
        getConstants().clear();
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
      case ReqSpecPackage.REQ_SPEC_LIBRARY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ReqSpecPackage.REQ_SPEC_LIBRARY__IMPORTED_NAMESPACE:
        return IMPORTED_NAMESPACE_EDEFAULT == null ? importedNamespace != null : !IMPORTED_NAMESPACE_EDEFAULT.equals(importedNamespace);
      case ReqSpecPackage.REQ_SPEC_LIBRARY__TARGET:
        return target != null;
      case ReqSpecPackage.REQ_SPEC_LIBRARY__CONSTANTS:
        return constants != null && !constants.isEmpty();
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
    result.append(", importedNamespace: ");
    result.append(importedNamespace);
    result.append(')');
    return result.toString();
  }

} //ReqSpecLibraryImpl
