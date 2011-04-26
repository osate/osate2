/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EM2 Annex Subclause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EM2AnnexSubclauseImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EM2AnnexSubclauseImpl#getEbsm <em>Ebsm</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EM2AnnexSubclauseImpl#getEp <em>Ep</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EM2AnnexSubclauseImpl#getCeb <em>Ceb</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EM2AnnexSubclauseImpl#getCompeb <em>Compeb</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EM2AnnexSubclauseImpl extends MinimalEObjectImpl.Container implements EM2AnnexSubclause
{
  /**
   * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypes()
   * @generated
   * @ordered
   */
  protected EList<ErrorTypeSet> types;

  /**
   * The cached value of the '{@link #getEbsm() <em>Ebsm</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEbsm()
   * @generated
   * @ordered
   */
  protected EList<ErrorBehaviorStateMachine> ebsm;

  /**
   * The cached value of the '{@link #getEp() <em>Ep</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEp()
   * @generated
   * @ordered
   */
  protected EList<ErrorPropagations> ep;

  /**
   * The cached value of the '{@link #getCeb() <em>Ceb</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCeb()
   * @generated
   * @ordered
   */
  protected EList<ComponentErrorBehavior> ceb;

  /**
   * The cached value of the '{@link #getCompeb() <em>Compeb</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompeb()
   * @generated
   * @ordered
   */
  protected EList<CompositeErrorBehavior> compeb;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EM2AnnexSubclauseImpl()
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
    return ErrorModelPackage.Literals.EM2_ANNEX_SUBCLAUSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorTypeSet> getTypes()
  {
    if (types == null)
    {
      types = new EObjectContainmentEList<ErrorTypeSet>(ErrorTypeSet.class, this, ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__TYPES);
    }
    return types;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorBehaviorStateMachine> getEbsm()
  {
    if (ebsm == null)
    {
      ebsm = new EObjectContainmentEList<ErrorBehaviorStateMachine>(ErrorBehaviorStateMachine.class, this, ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__EBSM);
    }
    return ebsm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorPropagations> getEp()
  {
    if (ep == null)
    {
      ep = new EObjectContainmentEList<ErrorPropagations>(ErrorPropagations.class, this, ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__EP);
    }
    return ep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ComponentErrorBehavior> getCeb()
  {
    if (ceb == null)
    {
      ceb = new EObjectContainmentEList<ComponentErrorBehavior>(ComponentErrorBehavior.class, this, ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__CEB);
    }
    return ceb;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CompositeErrorBehavior> getCompeb()
  {
    if (compeb == null)
    {
      compeb = new EObjectContainmentEList<CompositeErrorBehavior>(CompositeErrorBehavior.class, this, ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__COMPEB);
    }
    return compeb;
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
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__TYPES:
        return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__EBSM:
        return ((InternalEList<?>)getEbsm()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__EP:
        return ((InternalEList<?>)getEp()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__CEB:
        return ((InternalEList<?>)getCeb()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__COMPEB:
        return ((InternalEList<?>)getCompeb()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__TYPES:
        return getTypes();
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__EBSM:
        return getEbsm();
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__EP:
        return getEp();
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__CEB:
        return getCeb();
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__COMPEB:
        return getCompeb();
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
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__TYPES:
        getTypes().clear();
        getTypes().addAll((Collection<? extends ErrorTypeSet>)newValue);
        return;
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__EBSM:
        getEbsm().clear();
        getEbsm().addAll((Collection<? extends ErrorBehaviorStateMachine>)newValue);
        return;
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__EP:
        getEp().clear();
        getEp().addAll((Collection<? extends ErrorPropagations>)newValue);
        return;
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__CEB:
        getCeb().clear();
        getCeb().addAll((Collection<? extends ComponentErrorBehavior>)newValue);
        return;
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__COMPEB:
        getCompeb().clear();
        getCompeb().addAll((Collection<? extends CompositeErrorBehavior>)newValue);
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
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__TYPES:
        getTypes().clear();
        return;
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__EBSM:
        getEbsm().clear();
        return;
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__EP:
        getEp().clear();
        return;
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__CEB:
        getCeb().clear();
        return;
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__COMPEB:
        getCompeb().clear();
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
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__TYPES:
        return types != null && !types.isEmpty();
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__EBSM:
        return ebsm != null && !ebsm.isEmpty();
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__EP:
        return ep != null && !ep.isEmpty();
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__CEB:
        return ceb != null && !ceb.isEmpty();
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE__COMPEB:
        return compeb != null && !compeb.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //EM2AnnexSubclauseImpl
