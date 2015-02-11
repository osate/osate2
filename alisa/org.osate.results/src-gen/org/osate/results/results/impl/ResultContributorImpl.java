/**
 */
package org.osate.results.results.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.results.results.ReportIssue;
import org.osate.results.results.ResultContributor;
import org.osate.results.results.ResultsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Contributor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.results.results.impl.ResultContributorImpl#getContributor <em>Contributor</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultContributorImpl#getCell <em>Cell</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultContributorImpl#getIssue <em>Issue</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultContributorImpl#getSubcontributor <em>Subcontributor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultContributorImpl extends MinimalEObjectImpl.Container implements ResultContributor
{
  /**
   * The cached value of the '{@link #getContributor() <em>Contributor</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContributor()
   * @generated
   * @ordered
   */
  protected EObject contributor;

  /**
   * The cached value of the '{@link #getCell() <em>Cell</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCell()
   * @generated
   * @ordered
   */
  protected EList<String> cell;

  /**
   * The cached value of the '{@link #getIssue() <em>Issue</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIssue()
   * @generated
   * @ordered
   */
  protected EList<ReportIssue> issue;

  /**
   * The cached value of the '{@link #getSubcontributor() <em>Subcontributor</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubcontributor()
   * @generated
   * @ordered
   */
  protected EList<ResultContributor> subcontributor;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResultContributorImpl()
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
    return ResultsPackage.Literals.RESULT_CONTRIBUTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getContributor()
  {
    if (contributor != null && contributor.eIsProxy())
    {
      InternalEObject oldContributor = (InternalEObject)contributor;
      contributor = eResolveProxy(oldContributor);
      if (contributor != oldContributor)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultsPackage.RESULT_CONTRIBUTOR__CONTRIBUTOR, oldContributor, contributor));
      }
    }
    return contributor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetContributor()
  {
    return contributor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContributor(EObject newContributor)
  {
    EObject oldContributor = contributor;
    contributor = newContributor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_CONTRIBUTOR__CONTRIBUTOR, oldContributor, contributor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getCell()
  {
    if (cell == null)
    {
      cell = new EDataTypeEList<String>(String.class, this, ResultsPackage.RESULT_CONTRIBUTOR__CELL);
    }
    return cell;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ReportIssue> getIssue()
  {
    if (issue == null)
    {
      issue = new EObjectContainmentEList<ReportIssue>(ReportIssue.class, this, ResultsPackage.RESULT_CONTRIBUTOR__ISSUE);
    }
    return issue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ResultContributor> getSubcontributor()
  {
    if (subcontributor == null)
    {
      subcontributor = new EObjectContainmentEList<ResultContributor>(ResultContributor.class, this, ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR);
    }
    return subcontributor;
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
      case ResultsPackage.RESULT_CONTRIBUTOR__ISSUE:
        return ((InternalEList<?>)getIssue()).basicRemove(otherEnd, msgs);
      case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
        return ((InternalEList<?>)getSubcontributor()).basicRemove(otherEnd, msgs);
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
      case ResultsPackage.RESULT_CONTRIBUTOR__CONTRIBUTOR:
        if (resolve) return getContributor();
        return basicGetContributor();
      case ResultsPackage.RESULT_CONTRIBUTOR__CELL:
        return getCell();
      case ResultsPackage.RESULT_CONTRIBUTOR__ISSUE:
        return getIssue();
      case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
        return getSubcontributor();
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
      case ResultsPackage.RESULT_CONTRIBUTOR__CONTRIBUTOR:
        setContributor((EObject)newValue);
        return;
      case ResultsPackage.RESULT_CONTRIBUTOR__CELL:
        getCell().clear();
        getCell().addAll((Collection<? extends String>)newValue);
        return;
      case ResultsPackage.RESULT_CONTRIBUTOR__ISSUE:
        getIssue().clear();
        getIssue().addAll((Collection<? extends ReportIssue>)newValue);
        return;
      case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
        getSubcontributor().clear();
        getSubcontributor().addAll((Collection<? extends ResultContributor>)newValue);
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
      case ResultsPackage.RESULT_CONTRIBUTOR__CONTRIBUTOR:
        setContributor((EObject)null);
        return;
      case ResultsPackage.RESULT_CONTRIBUTOR__CELL:
        getCell().clear();
        return;
      case ResultsPackage.RESULT_CONTRIBUTOR__ISSUE:
        getIssue().clear();
        return;
      case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
        getSubcontributor().clear();
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
      case ResultsPackage.RESULT_CONTRIBUTOR__CONTRIBUTOR:
        return contributor != null;
      case ResultsPackage.RESULT_CONTRIBUTOR__CELL:
        return cell != null && !cell.isEmpty();
      case ResultsPackage.RESULT_CONTRIBUTOR__ISSUE:
        return issue != null && !issue.isEmpty();
      case ResultsPackage.RESULT_CONTRIBUTOR__SUBCONTRIBUTOR:
        return subcontributor != null && !subcontributor.isEmpty();
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
    result.append(" (cell: ");
    result.append(cell);
    result.append(')');
    return result.toString();
  }

} //ResultContributorImpl
