/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.results.results.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.results.results.IssuesReport;
import org.osate.results.results.ResultContributor;
import org.osate.results.results.ResultData;
import org.osate.results.results.ResultIssue;
import org.osate.results.results.ResultIssueType;
import org.osate.results.results.ResultReport;
import org.osate.results.results.ResultReportCollection;
import org.osate.results.results.ResultReports;
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
  private EClass resultReportsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resultReportCollectionEClass = null;

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
  private EClass resultContributorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass issuesReportEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resultIssueEClass = null;

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
  private EEnum resultIssueTypeEEnum = null;

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
  public EClass getResultReports()
  {
    return resultReportsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReports_Name()
  {
    return (EAttribute)resultReportsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReports_Target()
  {
    return (EReference)resultReportsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReports_Issues()
  {
    return (EReference)resultReportsEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResultReportCollection()
  {
    return resultReportCollectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReportCollection_Title()
  {
    return (EAttribute)resultReportCollectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReportCollection_Decription()
  {
    return (EAttribute)resultReportCollectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReportCollection_Content()
  {
    return (EReference)resultReportCollectionEClass.getEStructuralFeatures().get(2);
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
  public EAttribute getResultReport_Title()
  {
    return (EAttribute)resultReportEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReport_Decription()
  {
    return (EAttribute)resultReportEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReport_Heading()
  {
    return (EAttribute)resultReportEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReport_Content()
  {
    return (EReference)resultReportEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReport_ResultData()
  {
    return (EReference)resultReportEClass.getEStructuralFeatures().get(4);
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
  public EReference getResultContributor_Target()
  {
    return (EReference)resultContributorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultContributor_ResultData()
  {
    return (EReference)resultContributorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultContributor_Issues()
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
  public EClass getIssuesReport()
  {
    return issuesReportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIssuesReport_Description()
  {
    return (EAttribute)issuesReportEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResultIssue()
  {
    return resultIssueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultIssue_IssueType()
  {
    return (EAttribute)resultIssueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultIssue_Message()
  {
    return (EAttribute)resultIssueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultIssue_Target()
  {
    return (EReference)resultIssueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultIssue_ExceptionType()
  {
    return (EAttribute)resultIssueEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultIssue_Issues()
  {
    return (EReference)resultIssueEClass.getEStructuralFeatures().get(4);
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
  public EAttribute getResultData_Name()
  {
    return (EAttribute)resultDataEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultData_Value()
  {
    return (EAttribute)resultDataEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getResultIssueType()
  {
    return resultIssueTypeEEnum;
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
    resultReportsEClass = createEClass(RESULT_REPORTS);
    createEAttribute(resultReportsEClass, RESULT_REPORTS__NAME);
    createEReference(resultReportsEClass, RESULT_REPORTS__TARGET);
    createEReference(resultReportsEClass, RESULT_REPORTS__ISSUES);

    resultReportCollectionEClass = createEClass(RESULT_REPORT_COLLECTION);
    createEAttribute(resultReportCollectionEClass, RESULT_REPORT_COLLECTION__TITLE);
    createEAttribute(resultReportCollectionEClass, RESULT_REPORT_COLLECTION__DECRIPTION);
    createEReference(resultReportCollectionEClass, RESULT_REPORT_COLLECTION__CONTENT);

    resultReportEClass = createEClass(RESULT_REPORT);
    createEAttribute(resultReportEClass, RESULT_REPORT__TITLE);
    createEAttribute(resultReportEClass, RESULT_REPORT__DECRIPTION);
    createEAttribute(resultReportEClass, RESULT_REPORT__HEADING);
    createEReference(resultReportEClass, RESULT_REPORT__CONTENT);
    createEReference(resultReportEClass, RESULT_REPORT__RESULT_DATA);

    resultContributorEClass = createEClass(RESULT_CONTRIBUTOR);
    createEReference(resultContributorEClass, RESULT_CONTRIBUTOR__TARGET);
    createEReference(resultContributorEClass, RESULT_CONTRIBUTOR__RESULT_DATA);
    createEReference(resultContributorEClass, RESULT_CONTRIBUTOR__ISSUES);
    createEReference(resultContributorEClass, RESULT_CONTRIBUTOR__SUBCONTRIBUTOR);

    issuesReportEClass = createEClass(ISSUES_REPORT);
    createEAttribute(issuesReportEClass, ISSUES_REPORT__DESCRIPTION);

    resultIssueEClass = createEClass(RESULT_ISSUE);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__ISSUE_TYPE);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__MESSAGE);
    createEReference(resultIssueEClass, RESULT_ISSUE__TARGET);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__EXCEPTION_TYPE);
    createEReference(resultIssueEClass, RESULT_ISSUE__ISSUES);

    resultDataEClass = createEClass(RESULT_DATA);
    createEAttribute(resultDataEClass, RESULT_DATA__NAME);
    createEAttribute(resultDataEClass, RESULT_DATA__VALUE);

    // Create enums
    resultIssueTypeEEnum = createEEnum(RESULT_ISSUE_TYPE);
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
    resultReportCollectionEClass.getESuperTypes().add(this.getResultReports());
    resultReportEClass.getESuperTypes().add(this.getResultReports());
    issuesReportEClass.getESuperTypes().add(this.getResultReports());

    // Initialize classes and features; add operations and parameters
    initEClass(resultReportsEClass, ResultReports.class, "ResultReports", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultReports_Name(), ecorePackage.getEString(), "name", null, 0, 1, ResultReports.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReports_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, ResultReports.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReports_Issues(), this.getResultIssue(), null, "issues", null, 0, -1, ResultReports.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultReportCollectionEClass, ResultReportCollection.class, "ResultReportCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultReportCollection_Title(), ecorePackage.getEString(), "title", null, 0, 1, ResultReportCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultReportCollection_Decription(), ecorePackage.getEString(), "decription", null, 0, 1, ResultReportCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReportCollection_Content(), this.getResultReport(), null, "content", null, 0, -1, ResultReportCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultReportEClass, ResultReport.class, "ResultReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultReport_Title(), ecorePackage.getEString(), "title", null, 0, 1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultReport_Decription(), ecorePackage.getEString(), "decription", null, 0, 1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultReport_Heading(), ecorePackage.getEString(), "heading", null, 0, 1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReport_Content(), this.getResultContributor(), null, "content", null, 0, -1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReport_ResultData(), this.getResultData(), null, "resultData", null, 0, -1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultContributorEClass, ResultContributor.class, "ResultContributor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResultContributor_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, ResultContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultContributor_ResultData(), this.getResultData(), null, "resultData", null, 0, -1, ResultContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultContributor_Issues(), this.getResultIssue(), null, "issues", null, 0, -1, ResultContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultContributor_Subcontributor(), this.getResultContributor(), null, "subcontributor", null, 0, -1, ResultContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(issuesReportEClass, IssuesReport.class, "IssuesReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIssuesReport_Description(), ecorePackage.getEString(), "description", null, 0, 1, IssuesReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultIssueEClass, ResultIssue.class, "ResultIssue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultIssue_IssueType(), this.getResultIssueType(), "issueType", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultIssue_Message(), ecorePackage.getEString(), "message", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultIssue_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultIssue_ExceptionType(), ecorePackage.getEString(), "exceptionType", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultIssue_Issues(), this.getResultIssue(), null, "issues", null, 0, -1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultDataEClass, ResultData.class, "ResultData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultData_Name(), ecorePackage.getEString(), "name", null, 0, 1, ResultData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultData_Value(), ecorePackage.getEString(), "value", null, 0, 1, ResultData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(resultIssueTypeEEnum, ResultIssueType.class, "ResultIssueType");
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.TBD);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.UNKNOWN);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.ERROR);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.WARNING);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.INFO);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.SUCCESS);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.FAIL);

    // Create resource
    createResource(eNS_URI);
  }

} //ResultsPackageImpl
