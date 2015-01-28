/**
 */
package org.osate.results.results.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.results.results.IssueType;
import org.osate.results.results.ReportIssue;
import org.osate.results.results.ResultsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Report Issue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.results.results.impl.ReportIssueImpl#getIssueType <em>Issue Type</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ReportIssueImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ReportIssueImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReportIssueImpl extends MinimalEObjectImpl.Container implements ReportIssue
{
  /**
   * The default value of the '{@link #getIssueType() <em>Issue Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIssueType()
   * @generated
   * @ordered
   */
  protected static final IssueType ISSUE_TYPE_EDEFAULT = IssueType.ERROR;

  /**
   * The cached value of the '{@link #getIssueType() <em>Issue Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIssueType()
   * @generated
   * @ordered
   */
  protected IssueType issueType = ISSUE_TYPE_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReportIssueImpl()
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
    return ResultsPackage.Literals.REPORT_ISSUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IssueType getIssueType()
  {
    return issueType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIssueType(IssueType newIssueType)
  {
    IssueType oldIssueType = issueType;
    issueType = newIssueType == null ? ISSUE_TYPE_EDEFAULT : newIssueType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.REPORT_ISSUE__ISSUE_TYPE, oldIssueType, issueType));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.REPORT_ISSUE__TITLE, oldTitle, title));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultsPackage.REPORT_ISSUE__TARGET, oldTarget, target));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.REPORT_ISSUE__TARGET, oldTarget, target));
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
      case ResultsPackage.REPORT_ISSUE__ISSUE_TYPE:
        return getIssueType();
      case ResultsPackage.REPORT_ISSUE__TITLE:
        return getTitle();
      case ResultsPackage.REPORT_ISSUE__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ResultsPackage.REPORT_ISSUE__ISSUE_TYPE:
        setIssueType((IssueType)newValue);
        return;
      case ResultsPackage.REPORT_ISSUE__TITLE:
        setTitle((String)newValue);
        return;
      case ResultsPackage.REPORT_ISSUE__TARGET:
        setTarget((EObject)newValue);
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
      case ResultsPackage.REPORT_ISSUE__ISSUE_TYPE:
        setIssueType(ISSUE_TYPE_EDEFAULT);
        return;
      case ResultsPackage.REPORT_ISSUE__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case ResultsPackage.REPORT_ISSUE__TARGET:
        setTarget((EObject)null);
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
      case ResultsPackage.REPORT_ISSUE__ISSUE_TYPE:
        return issueType != ISSUE_TYPE_EDEFAULT;
      case ResultsPackage.REPORT_ISSUE__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case ResultsPackage.REPORT_ISSUE__TARGET:
        return target != null;
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
    result.append(" (issueType: ");
    result.append(issueType);
    result.append(", title: ");
    result.append(title);
    result.append(')');
    return result.toString();
  }

} //ReportIssueImpl
