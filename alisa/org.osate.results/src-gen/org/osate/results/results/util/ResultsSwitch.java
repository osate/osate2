/**
 */
package org.osate.results.results.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.osate.results.results.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.osate.results.results.ResultsPackage
 * @generated
 */
public class ResultsSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ResultsPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultsSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ResultsPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ResultsPackage.RESULT_REPORT:
      {
        ResultReport resultReport = (ResultReport)theEObject;
        T result = caseResultReport(resultReport);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ResultsPackage.RESULT_REPORT_ENTRY:
      {
        ResultReportEntry resultReportEntry = (ResultReportEntry)theEObject;
        T result = caseResultReportEntry(resultReportEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ResultsPackage.RESULT_CONTRIBUTOR:
      {
        ResultContributor resultContributor = (ResultContributor)theEObject;
        T result = caseResultContributor(resultContributor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ResultsPackage.REPORT_ISSUE:
      {
        ReportIssue reportIssue = (ReportIssue)theEObject;
        T result = caseReportIssue(reportIssue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ResultsPackage.RESULT_DATA:
      {
        ResultData resultData = (ResultData)theEObject;
        T result = caseResultData(resultData);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ResultsPackage.NAME_VALUE_PAIR:
      {
        NameValuePair nameValuePair = (NameValuePair)theEObject;
        T result = caseNameValuePair(nameValuePair);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Result Report</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Result Report</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResultReport(ResultReport object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Result Report Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Result Report Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResultReportEntry(ResultReportEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Result Contributor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Result Contributor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResultContributor(ResultContributor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Report Issue</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Report Issue</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReportIssue(ReportIssue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Result Data</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Result Data</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResultData(ResultData object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name Value Pair</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Value Pair</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNameValuePair(NameValuePair object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ResultsSwitch
