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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.alisa.common.common.CommonPackage;

import org.osate.results.results.IssuesReport;
import org.osate.results.results.ResultContributor;
import org.osate.results.results.ResultData;
import org.osate.results.results.ResultDataReport;
import org.osate.results.results.ResultReport;
import org.osate.results.results.ResultReportCollection;
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
  private EClass resultReportCollectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resultDataReportEClass = null;

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
  private EClass resultDataEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass issuesReportEClass = null;

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

    // Initialize simple dependencies
    CommonPackage.eINSTANCE.eClass();

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
  public EReference getResultReport_Target()
  {
    return (EReference)resultReportEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultReport_Description()
  {
    return (EAttribute)resultReportEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultReport_Issues()
  {
    return (EReference)resultReportEClass.getEStructuralFeatures().get(3);
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
  public EReference getResultReportCollection_Content()
  {
    return (EReference)resultReportCollectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResultDataReport()
  {
    return resultDataReportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultDataReport_Title()
  {
    return (EAttribute)resultDataReportEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultDataReport_Heading()
  {
    return (EAttribute)resultDataReportEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultDataReport_Content()
  {
    return (EReference)resultDataReportEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultDataReport_ResultData()
  {
    return (EReference)resultDataReportEClass.getEStructuralFeatures().get(3);
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
  public EReference getResultData_Value()
  {
    return (EReference)resultDataEClass.getEStructuralFeatures().get(1);
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
    createEReference(resultReportEClass, RESULT_REPORT__TARGET);
    createEAttribute(resultReportEClass, RESULT_REPORT__DESCRIPTION);
    createEReference(resultReportEClass, RESULT_REPORT__ISSUES);

    resultReportCollectionEClass = createEClass(RESULT_REPORT_COLLECTION);
    createEAttribute(resultReportCollectionEClass, RESULT_REPORT_COLLECTION__TITLE);
    createEReference(resultReportCollectionEClass, RESULT_REPORT_COLLECTION__CONTENT);

    resultDataReportEClass = createEClass(RESULT_DATA_REPORT);
    createEAttribute(resultDataReportEClass, RESULT_DATA_REPORT__TITLE);
    createEAttribute(resultDataReportEClass, RESULT_DATA_REPORT__HEADING);
    createEReference(resultDataReportEClass, RESULT_DATA_REPORT__CONTENT);
    createEReference(resultDataReportEClass, RESULT_DATA_REPORT__RESULT_DATA);

    resultContributorEClass = createEClass(RESULT_CONTRIBUTOR);
    createEReference(resultContributorEClass, RESULT_CONTRIBUTOR__TARGET);
    createEReference(resultContributorEClass, RESULT_CONTRIBUTOR__RESULT_DATA);
    createEReference(resultContributorEClass, RESULT_CONTRIBUTOR__ISSUES);
    createEReference(resultContributorEClass, RESULT_CONTRIBUTOR__SUBCONTRIBUTOR);

    resultDataEClass = createEClass(RESULT_DATA);
    createEAttribute(resultDataEClass, RESULT_DATA__NAME);
    createEReference(resultDataEClass, RESULT_DATA__VALUE);

    issuesReportEClass = createEClass(ISSUES_REPORT);
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

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    resultReportCollectionEClass.getESuperTypes().add(this.getResultReport());
    resultDataReportEClass.getESuperTypes().add(this.getResultReport());
    issuesReportEClass.getESuperTypes().add(this.getResultReport());

    // Initialize classes and features; add operations and parameters
    initEClass(resultReportEClass, ResultReport.class, "ResultReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultReport_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReport_Target(), theEcorePackage.getEObject(), null, "target", null, 0, 1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultReport_Description(), theEcorePackage.getEString(), "description", null, 0, 1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReport_Issues(), theCommonPackage.getResultIssue(), null, "issues", null, 0, -1, ResultReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultReportCollectionEClass, ResultReportCollection.class, "ResultReportCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultReportCollection_Title(), theEcorePackage.getEString(), "title", null, 0, 1, ResultReportCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultReportCollection_Content(), this.getResultReport(), null, "content", null, 0, -1, ResultReportCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultDataReportEClass, ResultDataReport.class, "ResultDataReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultDataReport_Title(), theEcorePackage.getEString(), "title", null, 0, 1, ResultDataReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultDataReport_Heading(), theEcorePackage.getEString(), "heading", null, 0, 1, ResultDataReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultDataReport_Content(), this.getResultContributor(), null, "content", null, 0, -1, ResultDataReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultDataReport_ResultData(), this.getResultData(), null, "resultData", null, 0, -1, ResultDataReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultContributorEClass, ResultContributor.class, "ResultContributor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResultContributor_Target(), theEcorePackage.getEObject(), null, "target", null, 0, 1, ResultContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultContributor_ResultData(), this.getResultData(), null, "resultData", null, 0, -1, ResultContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultContributor_Issues(), theCommonPackage.getResultIssue(), null, "issues", null, 0, -1, ResultContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultContributor_Subcontributor(), this.getResultContributor(), null, "subcontributor", null, 0, -1, ResultContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultDataEClass, ResultData.class, "ResultData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultData_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ResultData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultData_Value(), theAadl2Package.getPropertyExpression(), null, "value", null, 0, 1, ResultData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(issuesReportEClass, IssuesReport.class, "IssuesReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //ResultsPackageImpl
