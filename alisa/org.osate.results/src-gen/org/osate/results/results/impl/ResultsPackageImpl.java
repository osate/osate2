/**
 */
package org.osate.results.results.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.results.results.NameValuePair;
import org.osate.results.results.ReportIssue;
import org.osate.results.results.ReportIssueType;
import org.osate.results.results.ResultContributor;
import org.osate.results.results.ResultData;
import org.osate.results.results.ResultReport;
import org.osate.results.results.ResultReportEntry;
import org.osate.results.results.ResultsFactory;
import org.osate.results.results.ResultsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResultsPackageImpl extends EPackageImpl implements ResultsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resultReportEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resultReportEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resultContributorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reportIssueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resultDataEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameValuePairEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum reportIssueTypeEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.osate.results.results.ResultsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ResultsPackageImpl()
  {
    super(eNS_URI, ResultsFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ResultsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ResultsPackage init()
  {
    if (isInited) return (ResultsPackage)EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI);

    // Obtain or create and register package
    ResultsPackageImpl theResultsPackage = (ResultsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ResultsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ResultsPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theResultsPackage.createPackageContents();

    // Initialize created meta-data
    theResultsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theResultsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ResultsPackage.eNS_URI, theResultsPackage);
    return theResultsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResultReport()
  {
    return resultReportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReport_Name()
  {
    return (EAttribute)resultReportEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReport_Title()
  {
    return (EAttribute)resultReportEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReport_Root()
  {
    return (EReference)resultReportEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReport_Decription()
  {
    return (EAttribute)resultReportEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReport_Heading()
  {
    return (EAttribute)resultReportEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReport_Content()
  {
    return (EReference)resultReportEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReport_ResultData()
  {
    return (EReference)resultReportEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReport_Issue()
  {
    return (EReference)resultReportEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResultReportEntry()
  {
    return resultReportEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReportEntry_Name()
  {
    return (EAttribute)resultReportEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReportEntry_Title()
  {
    return (EAttribute)resultReportEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReportEntry_Target()
  {
    return (EReference)resultReportEntryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReportEntry_Decription()
  {
    return (EAttribute)resultReportEntryEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReportEntry_Heading()
  {
    return (EAttribute)resultReportEntryEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReportEntry_ResultData()
  {
    return (EReference)resultReportEntryEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReportEntry_Issue()
  {
    return (EReference)resultReportEntryEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReportEntry_Row()
  {
    return (EReference)resultReportEntryEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResultContributor()
  {
    return resultContributorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultContributor_Contributor()
  {
    return (EReference)resultContributorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultContributor_Cell()
  {
    return (EAttribute)resultContributorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultContributor_Issue()
  {
    return (EReference)resultContributorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultContributor_Subcontributor()
  {
    return (EReference)resultContributorEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReportIssue()
  {
    return reportIssueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReportIssue_IssueType()
  {
    return (EAttribute)reportIssueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReportIssue_Title()
  {
    return (EAttribute)reportIssueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReportIssue_Target()
  {
    return (EReference)reportIssueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResultData()
  {
    return resultDataEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultData_Data()
  {
    return (EReference)resultDataEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNameValuePair()
  {
    return nameValuePairEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNameValuePair_Name()
  {
    return (EAttribute)nameValuePairEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNameValuePair_Value()
  {
    return (EAttribute)nameValuePairEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getReportIssueType()
  {
    return reportIssueTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultsFactory getResultsFactory()
  {
    return (ResultsFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    resultReportEClass = createEClass(RESULT_REPORT);
    createEAttribute(resultReportEClass, RESULT_REPORT__NAME);
    createEAttribute(resultReportEClass, RESULT_REPORT__TITLE);
    createEReference(resultReportEClass, RESULT_REPORT__ROOT);
    createEAttribute(resultReportEClass, RESULT_REPORT__DECRIPTION);
    createEAttribute(resultReportEClass, RESULT_REPORT__HEADING);
    createEReference(resultReportEClass, RESULT_REPORT__CONTENT);
    createEReference(resultReportEClass, RESULT_REPORT__RESULT_DATA);
    createEReference(resultReportEClass, RESULT_REPORT__ISSUE);

    resultReportEntryEClass = createEClass(RESULT_REPORT_ENTRY);
    createEAttribute(resultReportEntryEClass, RESULT_REPORT_ENTRY__NAME);
    createEAttribute(resultReportEntryEClass, RESULT_REPORT_ENTRY__TITLE);
    createEReference(resultReportEntryEClass, RESULT_REPORT_ENTRY__TARGET);
    createEAttribute(resultReportEntryEClass, RESULT_REPORT_ENTRY__DECRIPTION);
    createEAttribute(resultReportEntryEClass, RESULT_REPORT_ENTRY__HEADING);
    createEReference(resultReportEntryEClass, RESULT_REPORT_ENTRY__RESULT_DATA);
    createEReference(resultReportEntryEClass, RESULT_REPORT_ENTRY__ISSUE);
    createEReference(resultReportEntryEClass, RESULT_REPORT_ENTRY__ROW);

    resultContributorEClass = createEClass(RESULT_CONTRIBUTOR);
    createEReference(resultContributorEClass, RESULT_CONTRIBUTOR__CONTRIBUTOR);
    createEAttribute(resultContributorEClass, RESULT_CONTRIBUTOR__CELL);
    createEReference(resultContributorEClass, RESULT_CONTRIBUTOR__ISSUE);
    createEReference(resultContributorEClass, RESULT_CONTRIBUTOR__SUBCONTRIBUTOR);

    reportIssueEClass = createEClass(REPORT_ISSUE);
    createEAttribute(reportIssueEClass, REPORT_ISSUE__ISSUE_TYPE);
    createEAttribute(reportIssueEClass, REPORT_ISSUE__TITLE);
    createEReference(reportIssueEClass, REPORT_ISSUE__TARGET);

    resultDataEClass = createEClass(RESULT_DATA);
    createEReference(resultDataEClass, RESULT_DATA__DATA);

    nameValuePairEClass = createEClass(NAME_VALUE_PAIR);
    createEAttribute(nameValuePairEClass, NAME_VALUE_PAIR__NAME);
    createEAttribute(nameValuePairEClass, NAME_VALUE_PAIR__VALUE);

    // Create enums
    reportIssueTypeEEnum = createEEnum(REPORT_ISSUE_TYPE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(resultReportEClass, ResultReport.class, "ResultReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultReport_Name(), ecorePackage.getEString(), "name", null, 0, 1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultReport_Title(), ecorePackage.getEString(), "title", null, 0, 1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReport_Root(), ecorePackage.getEObject(), null, "root", null, 0, 1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultReport_Decription(), ecorePackage.getEString(), "decription", null, 0, 1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultReport_Heading(), ecorePackage.getEString(), "heading", null, 0, 1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReport_Content(), this.getResultReportEntry(), null, "content", null, 0, -1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReport_ResultData(), this.getResultData(), null, "resultData", null, 0, 1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReport_Issue(), this.getReportIssue(), null, "issue", null, 0, -1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultReportEntryEClass, ResultReportEntry.class, "ResultReportEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultReportEntry_Name(), ecorePackage.getEString(), "name", null, 0, 1, ResultReportEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultReportEntry_Title(), ecorePackage.getEString(), "title", null, 0, 1, ResultReportEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReportEntry_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, ResultReportEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultReportEntry_Decription(), ecorePackage.getEString(), "decription", null, 0, 1, ResultReportEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultReportEntry_Heading(), ecorePackage.getEString(), "heading", null, 0, 1, ResultReportEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReportEntry_ResultData(), this.getResultData(), null, "resultData", null, 0, 1, ResultReportEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReportEntry_Issue(), this.getReportIssue(), null, "issue", null, 0, -1, ResultReportEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReportEntry_Row(), this.getResultContributor(), null, "row", null, 0, -1, ResultReportEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultContributorEClass, ResultContributor.class, "ResultContributor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResultContributor_Contributor(), ecorePackage.getEObject(), null, "contributor", null, 0, 1, ResultContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultContributor_Cell(), ecorePackage.getEString(), "cell", null, 0, -1, ResultContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultContributor_Issue(), this.getReportIssue(), null, "issue", null, 0, -1, ResultContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultContributor_Subcontributor(), this.getResultContributor(), null, "subcontributor", null, 0, -1, ResultContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reportIssueEClass, ReportIssue.class, "ReportIssue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReportIssue_IssueType(), this.getReportIssueType(), "issueType", null, 0, 1, ReportIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReportIssue_Title(), ecorePackage.getEString(), "title", null, 0, 1, ReportIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReportIssue_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, ReportIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultDataEClass, ResultData.class, "ResultData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResultData_Data(), this.getNameValuePair(), null, "data", null, 0, -1, ResultData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nameValuePairEClass, NameValuePair.class, "NameValuePair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNameValuePair_Name(), ecorePackage.getEString(), "name", null, 0, 1, NameValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNameValuePair_Value(), ecorePackage.getEString(), "value", null, 0, 1, NameValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(reportIssueTypeEEnum, ReportIssueType.class, "ReportIssueType");
    addEEnumLiteral(reportIssueTypeEEnum, ReportIssueType.ERROR);
    addEEnumLiteral(reportIssueTypeEEnum, ReportIssueType.WARNING);
    addEEnumLiteral(reportIssueTypeEEnum, ReportIssueType.SUCCESS);
    addEEnumLiteral(reportIssueTypeEEnum, ReportIssueType.INFO);

    // Create resource
    createResource(eNS_URI);
  }

} //ResultsPackageImpl
