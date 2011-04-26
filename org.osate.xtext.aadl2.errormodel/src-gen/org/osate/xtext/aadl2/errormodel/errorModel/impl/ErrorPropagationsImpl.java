/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Propagations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationsImpl#getImportedNamespace <em>Imported Namespace</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationsImpl#getPropagations <em>Propagations</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationsImpl#getFlows <em>Flows</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorPropagationsImpl extends MinimalEObjectImpl.Container implements ErrorPropagations
{
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
   * The cached value of the '{@link #getPropagations() <em>Propagations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropagations()
   * @generated
   * @ordered
   */
  protected EList<ErrorPropagation> propagations;

  /**
   * The cached value of the '{@link #getFlows() <em>Flows</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFlows()
   * @generated
   * @ordered
   */
  protected EList<ErrorFlow> flows;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorPropagationsImpl()
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
    return ErrorModelPackage.Literals.ERROR_PROPAGATIONS;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATIONS__IMPORTED_NAMESPACE, oldImportedNamespace, importedNamespace));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorPropagation> getPropagations()
  {
    if (propagations == null)
    {
      propagations = new EObjectContainmentEList<ErrorPropagation>(ErrorPropagation.class, this, ErrorModelPackage.ERROR_PROPAGATIONS__PROPAGATIONS);
    }
    return propagations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorFlow> getFlows()
  {
    if (flows == null)
    {
      flows = new EObjectContainmentEList<ErrorFlow>(ErrorFlow.class, this, ErrorModelPackage.ERROR_PROPAGATIONS__FLOWS);
    }
    return flows;
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
      case ErrorModelPackage.ERROR_PROPAGATIONS__PROPAGATIONS:
        return ((InternalEList<?>)getPropagations()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_PROPAGATIONS__FLOWS:
        return ((InternalEList<?>)getFlows()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.ERROR_PROPAGATIONS__IMPORTED_NAMESPACE:
        return getImportedNamespace();
      case ErrorModelPackage.ERROR_PROPAGATIONS__PROPAGATIONS:
        return getPropagations();
      case ErrorModelPackage.ERROR_PROPAGATIONS__FLOWS:
        return getFlows();
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
      case ErrorModelPackage.ERROR_PROPAGATIONS__IMPORTED_NAMESPACE:
        setImportedNamespace((String)newValue);
        return;
      case ErrorModelPackage.ERROR_PROPAGATIONS__PROPAGATIONS:
        getPropagations().clear();
        getPropagations().addAll((Collection<? extends ErrorPropagation>)newValue);
        return;
      case ErrorModelPackage.ERROR_PROPAGATIONS__FLOWS:
        getFlows().clear();
        getFlows().addAll((Collection<? extends ErrorFlow>)newValue);
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
      case ErrorModelPackage.ERROR_PROPAGATIONS__IMPORTED_NAMESPACE:
        setImportedNamespace(IMPORTED_NAMESPACE_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_PROPAGATIONS__PROPAGATIONS:
        getPropagations().clear();
        return;
      case ErrorModelPackage.ERROR_PROPAGATIONS__FLOWS:
        getFlows().clear();
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
      case ErrorModelPackage.ERROR_PROPAGATIONS__IMPORTED_NAMESPACE:
        return IMPORTED_NAMESPACE_EDEFAULT == null ? importedNamespace != null : !IMPORTED_NAMESPACE_EDEFAULT.equals(importedNamespace);
      case ErrorModelPackage.ERROR_PROPAGATIONS__PROPAGATIONS:
        return propagations != null && !propagations.isEmpty();
      case ErrorModelPackage.ERROR_PROPAGATIONS__FLOWS:
        return flows != null && !flows.isEmpty();
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
    result.append(" (importedNamespace: ");
    result.append(importedNamespace);
    result.append(')');
    return result.toString();
  }

} //ErrorPropagationsImpl
