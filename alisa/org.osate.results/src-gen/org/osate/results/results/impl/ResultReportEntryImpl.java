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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.results.results.ReportIssue;
import org.osate.results.results.ResultContributor;
import org.osate.results.results.ResultData;
import org.osate.results.results.ResultReportEntry;
import org.osate.results.results.ResultsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Report Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.results.results.impl.ResultReportEntryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportEntryImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportEntryImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportEntryImpl#getDecription <em>Decription</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportEntryImpl#getHeading <em>Heading</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportEntryImpl#getResultData <em>Result Data</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportEntryImpl#getRow <em>Row</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportEntryImpl#getIssue <em>Issue</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultReportEntryImpl extends MinimalEObjectImpl.Container implements ResultReportEntry
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
  protected EObject target;

  /**
   * The default value of the '{@link #getDecription() <em>Decription</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecription()
   * @generated
   * @ordered
   */
  protected static final String DECRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDecription() <em>Decription</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecription()
   * @generated
   * @ordered
   */
  protected String decription = DECRIPTION_EDEFAULT;

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
   * The cached value of the '{@link #getResultData() <em>Result Data</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultData()
   * @generated
   * @ordered
   */
  protected ResultData resultData;

  /**
   * The cached value of the '{@link #getRow() <em>Row</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRow()
   * @generated
   * @ordered
   */
  protected EList<ResultContributor> row;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResultReportEntryImpl()
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
    return ResultsPackage.Literals.RESULT_REPORT_ENTRY;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT_ENTRY__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT_ENTRY__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultsPackage.RESULT_REPORT_ENTRY__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(EObject newTarget)
  {
    EObject oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT_ENTRY__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDecription()
  {
    return decription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDecription(String newDecription)
  {
    String oldDecription = decription;
    decription = newDecription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT_ENTRY__DECRIPTION, oldDecription, decription));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT_ENTRY__HEADING, oldHeading, heading));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultData getResultData()
  {
    return resultData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetResultData(ResultData newResultData, NotificationChain msgs)
  {
    ResultData oldResultData = resultData;
    resultData = newResultData;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT_ENTRY__RESULT_DATA, oldResultData, newResultData);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResultData(ResultData newResultData)
  {
    if (newResultData != resultData)
    {
      NotificationChain msgs = null;
      if (resultData != null)
        msgs = ((InternalEObject)resultData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResultsPackage.RESULT_REPORT_ENTRY__RESULT_DATA, null, msgs);
      if (newResultData != null)
        msgs = ((InternalEObject)newResultData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResultsPackage.RESULT_REPORT_ENTRY__RESULT_DATA, null, msgs);
      msgs = basicSetResultData(newResultData, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT_ENTRY__RESULT_DATA, newResultData, newResultData));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ResultContributor> getRow()
  {
    if (row == null)
    {
      row = new EObjectContainmentEList<ResultContributor>(ResultContributor.class, this, ResultsPackage.RESULT_REPORT_ENTRY__ROW);
    }
    return row;
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
      issue = new EObjectContainmentEList<ReportIssue>(ReportIssue.class, this, ResultsPackage.RESULT_REPORT_ENTRY__ISSUE);
    }
    return issue;
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
      case ResultsPackage.RESULT_REPORT_ENTRY__RESULT_DATA:
        return basicSetResultData(null, msgs);
      case ResultsPackage.RESULT_REPORT_ENTRY__ROW:
        return ((InternalEList<?>)getRow()).basicRemove(otherEnd, msgs);
      case ResultsPackage.RESULT_REPORT_ENTRY__ISSUE:
        return ((InternalEList<?>)getIssue()).basicRemove(otherEnd, msgs);
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
      case ResultsPackage.RESULT_REPORT_ENTRY__NAME:
        return getName();
      case ResultsPackage.RESULT_REPORT_ENTRY__TITLE:
        return getTitle();
      case ResultsPackage.RESULT_REPORT_ENTRY__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case ResultsPackage.RESULT_REPORT_ENTRY__DECRIPTION:
        return getDecription();
      case ResultsPackage.RESULT_REPORT_ENTRY__HEADING:
        return getHeading();
      case ResultsPackage.RESULT_REPORT_ENTRY__RESULT_DATA:
        return getResultData();
      case ResultsPackage.RESULT_REPORT_ENTRY__ROW:
        return getRow();
      case ResultsPackage.RESULT_REPORT_ENTRY__ISSUE:
        return getIssue();
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
      case ResultsPackage.RESULT_REPORT_ENTRY__NAME:
        setName((String)newValue);
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__TITLE:
        setTitle((String)newValue);
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__TARGET:
        setTarget((EObject)newValue);
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__DECRIPTION:
        setDecription((String)newValue);
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__HEADING:
        setHeading((String)newValue);
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__RESULT_DATA:
        setResultData((ResultData)newValue);
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__ROW:
        getRow().clear();
        getRow().addAll((Collection<? extends ResultContributor>)newValue);
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__ISSUE:
        getIssue().clear();
        getIssue().addAll((Collection<? extends ReportIssue>)newValue);
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
      case ResultsPackage.RESULT_REPORT_ENTRY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__TARGET:
        setTarget((EObject)null);
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__DECRIPTION:
        setDecription(DECRIPTION_EDEFAULT);
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__HEADING:
        setHeading(HEADING_EDEFAULT);
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__RESULT_DATA:
        setResultData((ResultData)null);
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__ROW:
        getRow().clear();
        return;
      case ResultsPackage.RESULT_REPORT_ENTRY__ISSUE:
        getIssue().clear();
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
      case ResultsPackage.RESULT_REPORT_ENTRY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ResultsPackage.RESULT_REPORT_ENTRY__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case ResultsPackage.RESULT_REPORT_ENTRY__TARGET:
        return target != null;
      case ResultsPackage.RESULT_REPORT_ENTRY__DECRIPTION:
        return DECRIPTION_EDEFAULT == null ? decription != null : !DECRIPTION_EDEFAULT.equals(decription);
      case ResultsPackage.RESULT_REPORT_ENTRY__HEADING:
        return HEADING_EDEFAULT == null ? heading != null : !HEADING_EDEFAULT.equals(heading);
      case ResultsPackage.RESULT_REPORT_ENTRY__RESULT_DATA:
        return resultData != null;
      case ResultsPackage.RESULT_REPORT_ENTRY__ROW:
        return row != null && !row.isEmpty();
      case ResultsPackage.RESULT_REPORT_ENTRY__ISSUE:
        return issue != null && !issue.isEmpty();
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
    result.append(", decription: ");
    result.append(decription);
    result.append(", heading: ");
    result.append(heading);
    result.append(')');
    return result.toString();
  }

} //ResultReportEntryImpl
