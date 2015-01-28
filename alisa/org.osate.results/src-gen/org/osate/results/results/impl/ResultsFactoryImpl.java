/**
 */
package org.osate.results.results.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.results.results.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResultsFactoryImpl extends EFactoryImpl implements ResultsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ResultsFactory init()
  {
    try
    {
      ResultsFactory theResultsFactory = (ResultsFactory)EPackage.Registry.INSTANCE.getEFactory(ResultsPackage.eNS_URI);
      if (theResultsFactory != null)
      {
        return theResultsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ResultsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultsFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ResultsPackage.RESULT_REPORT: return createResultReport();
      case ResultsPackage.RESULT_REPORT_ENTRY: return createResultReportEntry();
      case ResultsPackage.RESULT_CONTRIBUTOR: return createResultContributor();
      case ResultsPackage.REPORT_ISSUE: return createReportIssue();
      case ResultsPackage.RESULT_DATA: return createResultData();
      case ResultsPackage.NAME_VALUE_PAIR: return createNameValuePair();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ResultsPackage.ISSUE_TYPE:
        return createIssueTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ResultsPackage.ISSUE_TYPE:
        return convertIssueTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultReport createResultReport()
  {
    ResultReportImpl resultReport = new ResultReportImpl();
    return resultReport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultReportEntry createResultReportEntry()
  {
    ResultReportEntryImpl resultReportEntry = new ResultReportEntryImpl();
    return resultReportEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultContributor createResultContributor()
  {
    ResultContributorImpl resultContributor = new ResultContributorImpl();
    return resultContributor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReportIssue createReportIssue()
  {
    ReportIssueImpl reportIssue = new ReportIssueImpl();
    return reportIssue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultData createResultData()
  {
    ResultDataImpl resultData = new ResultDataImpl();
    return resultData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameValuePair createNameValuePair()
  {
    NameValuePairImpl nameValuePair = new NameValuePairImpl();
    return nameValuePair;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IssueType createIssueTypeFromString(EDataType eDataType, String initialValue)
  {
    IssueType result = IssueType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIssueTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultsPackage getResultsPackage()
  {
    return (ResultsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ResultsPackage getPackage()
  {
    return ResultsPackage.eINSTANCE;
  }

} //ResultsFactoryImpl
