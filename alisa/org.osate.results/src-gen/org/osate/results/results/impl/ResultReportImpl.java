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
import org.osate.results.results.ResultData;
import org.osate.results.results.ResultReport;
import org.osate.results.results.ResultReportEntry;
import org.osate.results.results.ResultsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.results.results.impl.ResultReportImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportImpl#getDecription <em>Decription</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportImpl#getHeading <em>Heading</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportImpl#getResultData <em>Result Data</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultReportImpl#getIssue <em>Issue</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultReportImpl extends MinimalEObjectImpl.Container implements ResultReport
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
   * The cached value of the '{@link #getRoot() <em>Root</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoot()
   * @generated
   * @ordered
   */
  protected EObject root;

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
   * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected EList<ResultReportEntry> content;

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
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getRoot()
  {
    if (root != null && root.eIsProxy())
    {
      InternalEObject oldRoot = (InternalEObject)root;
      root = eResolveProxy(oldRoot);
      if (root != oldRoot)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultsPackage.RESULT_REPORT__ROOT, oldRoot, root));
      }
    }
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetRoot()
  {
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoot(EObject newRoot)
  {
    EObject oldRoot = root;
    root = newRoot;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT__ROOT, oldRoot, root));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT__DECRIPTION, oldDecription, decription));
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
  public EList<ResultReportEntry> getContent()
  {
    if (content == null)
    {
      content = new EObjectContainmentEList<ResultReportEntry>(ResultReportEntry.class, this, ResultsPackage.RESULT_REPORT__CONTENT);
    }
    return content;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT__RESULT_DATA, oldResultData, newResultData);
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
        msgs = ((InternalEObject)resultData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResultsPackage.RESULT_REPORT__RESULT_DATA, null, msgs);
      if (newResultData != null)
        msgs = ((InternalEObject)newResultData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResultsPackage.RESULT_REPORT__RESULT_DATA, null, msgs);
      msgs = basicSetResultData(newResultData, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_REPORT__RESULT_DATA, newResultData, newResultData));
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
      issue = new EObjectContainmentEList<ReportIssue>(ReportIssue.class, this, ResultsPackage.RESULT_REPORT__ISSUE);
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
      case ResultsPackage.RESULT_REPORT__CONTENT:
        return ((InternalEList<?>)getContent()).basicRemove(otherEnd, msgs);
      case ResultsPackage.RESULT_REPORT__RESULT_DATA:
        return basicSetResultData(null, msgs);
      case ResultsPackage.RESULT_REPORT__ISSUE:
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
      case ResultsPackage.RESULT_REPORT__NAME:
        return getName();
      case ResultsPackage.RESULT_REPORT__TITLE:
        return getTitle();
      case ResultsPackage.RESULT_REPORT__ROOT:
        if (resolve) return getRoot();
        return basicGetRoot();
      case ResultsPackage.RESULT_REPORT__DECRIPTION:
        return getDecription();
      case ResultsPackage.RESULT_REPORT__HEADING:
        return getHeading();
      case ResultsPackage.RESULT_REPORT__CONTENT:
        return getContent();
      case ResultsPackage.RESULT_REPORT__RESULT_DATA:
        return getResultData();
      case ResultsPackage.RESULT_REPORT__ISSUE:
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
      case ResultsPackage.RESULT_REPORT__NAME:
        setName((String)newValue);
        return;
      case ResultsPackage.RESULT_REPORT__TITLE:
        setTitle((String)newValue);
        return;
      case ResultsPackage.RESULT_REPORT__ROOT:
        setRoot((EObject)newValue);
        return;
      case ResultsPackage.RESULT_REPORT__DECRIPTION:
        setDecription((String)newValue);
        return;
      case ResultsPackage.RESULT_REPORT__HEADING:
        setHeading((String)newValue);
        return;
      case ResultsPackage.RESULT_REPORT__CONTENT:
        getContent().clear();
        getContent().addAll((Collection<? extends ResultReportEntry>)newValue);
        return;
      case ResultsPackage.RESULT_REPORT__RESULT_DATA:
        setResultData((ResultData)newValue);
        return;
      case ResultsPackage.RESULT_REPORT__ISSUE:
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
      case ResultsPackage.RESULT_REPORT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ResultsPackage.RESULT_REPORT__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case ResultsPackage.RESULT_REPORT__ROOT:
        setRoot((EObject)null);
        return;
      case ResultsPackage.RESULT_REPORT__DECRIPTION:
        setDecription(DECRIPTION_EDEFAULT);
        return;
      case ResultsPackage.RESULT_REPORT__HEADING:
        setHeading(HEADING_EDEFAULT);
        return;
      case ResultsPackage.RESULT_REPORT__CONTENT:
        getContent().clear();
        return;
      case ResultsPackage.RESULT_REPORT__RESULT_DATA:
        setResultData((ResultData)null);
        return;
      case ResultsPackage.RESULT_REPORT__ISSUE:
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
      case ResultsPackage.RESULT_REPORT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ResultsPackage.RESULT_REPORT__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case ResultsPackage.RESULT_REPORT__ROOT:
        return root != null;
      case ResultsPackage.RESULT_REPORT__DECRIPTION:
        return DECRIPTION_EDEFAULT == null ? decription != null : !DECRIPTION_EDEFAULT.equals(decription);
      case ResultsPackage.RESULT_REPORT__HEADING:
        return HEADING_EDEFAULT == null ? heading != null : !HEADING_EDEFAULT.equals(heading);
      case ResultsPackage.RESULT_REPORT__CONTENT:
        return content != null && !content.isEmpty();
      case ResultsPackage.RESULT_REPORT__RESULT_DATA:
        return resultData != null;
      case ResultsPackage.RESULT_REPORT__ISSUE:
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

} //ResultReportImpl
