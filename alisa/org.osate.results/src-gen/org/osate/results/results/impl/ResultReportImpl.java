/**
 */
package org.osate.results.results.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.results.results.ResultContributor;
import org.osate.results.results.ResultData;
import org.osate.results.results.ResultReport;
import org.osate.results.results.ResultsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.results.results.impl.ResultReportImpl#getHeading <em>Heading</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportImpl#getResultData <em>Result Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultReportImpl extends ResultReportsImpl implements ResultReport
{
  /**
   * The default value of the '{@link #getHeading() <em>Heading</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHeading()
   * @generated
   * @ordered
   */
  protected static final String HEADING_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getHeading() <em>Heading</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHeading()
   * @generated
   * @ordered
   */
  protected String heading = HEADING_EDEFAULT;

  /**
   * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected EList<ResultContributor> content;

  /**
   * The cached value of the '{@link #getResultData() <em>Result Data</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultData()
   * @generated
   * @ordered
   */
  protected EList<ResultData> resultData;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResultReportImpl()
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
    return ResultsPackage.Literals.RESULT_REPORT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getHeading()
  {
    return heading;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHeading(String newHeading)
  {
    String oldHeading = heading;
    heading = newHeading;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT__HEADING, oldHeading, heading));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ResultContributor> getContent()
  {
    if (content == null)
    {
      content = new EObjectContainmentEList<ResultContributor>(ResultContributor.class, this, ResultsPackage.RESULT_REPORT__CONTENT);
    }
    return content;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ResultData> getResultData()
  {
    if (resultData == null)
    {
      resultData = new EObjectContainmentEList<ResultData>(ResultData.class, this, ResultsPackage.RESULT_REPORT__RESULT_DATA);
    }
    return resultData;
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
      case ResultsPackage.RESULT_REPORT__CONTENT:
        return ((InternalEList<?>)getContent()).basicRemove(otherEnd, msgs);
      case ResultsPackage.RESULT_REPORT__RESULT_DATA:
        return ((InternalEList<?>)getResultData()).basicRemove(otherEnd, msgs);
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
      case ResultsPackage.RESULT_REPORT__HEADING:
        return getHeading();
      case ResultsPackage.RESULT_REPORT__CONTENT:
        return getContent();
      case ResultsPackage.RESULT_REPORT__RESULT_DATA:
        return getResultData();
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
      case ResultsPackage.RESULT_REPORT__HEADING:
        setHeading((String)newValue);
        return;
      case ResultsPackage.RESULT_REPORT__CONTENT:
        getContent().clear();
        getContent().addAll((Collection<? extends ResultContributor>)newValue);
        return;
      case ResultsPackage.RESULT_REPORT__RESULT_DATA:
        getResultData().clear();
        getResultData().addAll((Collection<? extends ResultData>)newValue);
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
      case ResultsPackage.RESULT_REPORT__HEADING:
        setHeading(HEADING_EDEFAULT);
        return;
      case ResultsPackage.RESULT_REPORT__CONTENT:
        getContent().clear();
        return;
      case ResultsPackage.RESULT_REPORT__RESULT_DATA:
        getResultData().clear();
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
      case ResultsPackage.RESULT_REPORT__HEADING:
        return HEADING_EDEFAULT == null ? heading != null : !HEADING_EDEFAULT.equals(heading);
      case ResultsPackage.RESULT_REPORT__CONTENT:
        return content != null && !content.isEmpty();
      case ResultsPackage.RESULT_REPORT__RESULT_DATA:
        return resultData != null && !resultData.isEmpty();
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
    result.append(" (heading: ");
    result.append(heading);
    result.append(')');
    return result.toString();
  }

} //ResultReportImpl
