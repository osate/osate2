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
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.alisa.common.common.ABinaryOperation;
import org.osate.alisa.common.common.AExpression;
import org.osate.alisa.common.common.AFeatureCall;
import org.osate.alisa.common.common.AListTerm;
import org.osate.alisa.common.common.ANullLiteral;
import org.osate.alisa.common.common.APropertyReference;
import org.osate.alisa.common.common.ASetLiteral;
import org.osate.alisa.common.common.AUnaryOperation;
import org.osate.alisa.common.common.AVariableDeclaration;
import org.osate.alisa.common.common.AVariableReference;
import org.osate.alisa.common.common.CommonFactory;
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.ComputeDeclaration;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.ImageReference;
import org.osate.alisa.common.common.Rationale;
import org.osate.alisa.common.common.ResultIssue;
import org.osate.alisa.common.common.ResultIssueType;
import org.osate.alisa.common.common.ShowValue;
import org.osate.alisa.common.common.Uncertainty;
import org.osate.alisa.common.common.ValDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonPackageImpl extends EPackageImpl implements CommonPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass descriptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass descriptionElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rationaleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass uncertaintyEClass = null;

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
  private EClass aVariableDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass showValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass imageReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass computeDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aPropertyReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aVariableReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aBinaryOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aUnaryOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aFeatureCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aSetLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aListTermEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aNullLiteralEClass = null;

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
   * @see org.osate.alisa.common.common.CommonPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private CommonPackageImpl()
  {
    super(eNS_URI, CommonFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link CommonPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static CommonPackage init()
  {
    if (isInited) return (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

    // Obtain or create and register package
    CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CommonPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    Aadl2Package.eINSTANCE.eClass();

    // Create package meta-data objects
    theCommonPackage.createPackageContents();

    // Initialize created meta-data
    theCommonPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCommonPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(CommonPackage.eNS_URI, theCommonPackage);
    return theCommonPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDescription()
  {
    return descriptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDescription_Description()
  {
    return (EReference)descriptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDescriptionElement()
  {
    return descriptionElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDescriptionElement_Text()
  {
    return (EAttribute)descriptionElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDescriptionElement_ShowValue()
  {
    return (EReference)descriptionElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDescriptionElement_ThisTarget()
  {
    return (EAttribute)descriptionElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDescriptionElement_Image()
  {
    return (EReference)descriptionElementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRationale()
  {
    return rationaleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRationale_Text()
  {
    return (EAttribute)rationaleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUncertainty()
  {
    return uncertaintyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUncertainty_Volatility()
  {
    return (EAttribute)uncertaintyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUncertainty_Impact()
  {
    return (EAttribute)uncertaintyEClass.getEStructuralFeatures().get(1);
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
  public EAttribute getResultIssue_DiagnosticId()
  {
    return (EAttribute)resultIssueEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultIssue_Issues()
  {
    return (EReference)resultIssueEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAVariableDeclaration()
  {
    return aVariableDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAVariableDeclaration_Type()
  {
    return (EAttribute)aVariableDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAVariableDeclaration_Name()
  {
    return (EAttribute)aVariableDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAExpression()
  {
    return aExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShowValue()
  {
    return showValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShowValue_Ref()
  {
    return (EReference)showValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShowValue_Unit()
  {
    return (EReference)showValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImageReference()
  {
    return imageReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImageReference_Imgfile()
  {
    return (EAttribute)imageReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValDeclaration()
  {
    return valDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValDeclaration_Right()
  {
    return (EReference)valDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComputeDeclaration()
  {
    return computeDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAPropertyReference()
  {
    return aPropertyReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAPropertyReference_Property()
  {
    return (EReference)aPropertyReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAVariableReference()
  {
    return aVariableReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAVariableReference_Variable()
  {
    return (EReference)aVariableReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getABinaryOperation()
  {
    return aBinaryOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getABinaryOperation_LeftOperand()
  {
    return (EReference)aBinaryOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getABinaryOperation_Feature()
  {
    return (EAttribute)aBinaryOperationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getABinaryOperation_RightOperand()
  {
    return (EReference)aBinaryOperationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAUnaryOperation()
  {
    return aUnaryOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAUnaryOperation_Feature()
  {
    return (EAttribute)aUnaryOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAUnaryOperation_Operand()
  {
    return (EReference)aUnaryOperationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAFeatureCall()
  {
    return aFeatureCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAFeatureCall_Feature()
  {
    return (EAttribute)aFeatureCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAFeatureCall_FunctionCallArguments()
  {
    return (EReference)aFeatureCallEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getASetLiteral()
  {
    return aSetLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getASetLiteral_Elements()
  {
    return (EReference)aSetLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAListTerm()
  {
    return aListTermEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAListTerm_Elements()
  {
    return (EReference)aListTermEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getANullLiteral()
  {
    return aNullLiteralEClass;
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
  public CommonFactory getCommonFactory()
  {
    return (CommonFactory)getEFactoryInstance();
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
    descriptionEClass = createEClass(DESCRIPTION);
    createEReference(descriptionEClass, DESCRIPTION__DESCRIPTION);

    descriptionElementEClass = createEClass(DESCRIPTION_ELEMENT);
    createEAttribute(descriptionElementEClass, DESCRIPTION_ELEMENT__TEXT);
    createEReference(descriptionElementEClass, DESCRIPTION_ELEMENT__SHOW_VALUE);
    createEAttribute(descriptionElementEClass, DESCRIPTION_ELEMENT__THIS_TARGET);
    createEReference(descriptionElementEClass, DESCRIPTION_ELEMENT__IMAGE);

    rationaleEClass = createEClass(RATIONALE);
    createEAttribute(rationaleEClass, RATIONALE__TEXT);

    uncertaintyEClass = createEClass(UNCERTAINTY);
    createEAttribute(uncertaintyEClass, UNCERTAINTY__VOLATILITY);
    createEAttribute(uncertaintyEClass, UNCERTAINTY__IMPACT);

    resultIssueEClass = createEClass(RESULT_ISSUE);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__ISSUE_TYPE);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__MESSAGE);
    createEReference(resultIssueEClass, RESULT_ISSUE__TARGET);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__EXCEPTION_TYPE);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__DIAGNOSTIC_ID);
    createEReference(resultIssueEClass, RESULT_ISSUE__ISSUES);

    aVariableDeclarationEClass = createEClass(AVARIABLE_DECLARATION);
    createEAttribute(aVariableDeclarationEClass, AVARIABLE_DECLARATION__TYPE);
    createEAttribute(aVariableDeclarationEClass, AVARIABLE_DECLARATION__NAME);

    aExpressionEClass = createEClass(AEXPRESSION);

    showValueEClass = createEClass(SHOW_VALUE);
    createEReference(showValueEClass, SHOW_VALUE__REF);
    createEReference(showValueEClass, SHOW_VALUE__UNIT);

    imageReferenceEClass = createEClass(IMAGE_REFERENCE);
    createEAttribute(imageReferenceEClass, IMAGE_REFERENCE__IMGFILE);

    valDeclarationEClass = createEClass(VAL_DECLARATION);
    createEReference(valDeclarationEClass, VAL_DECLARATION__RIGHT);

    computeDeclarationEClass = createEClass(COMPUTE_DECLARATION);

    aPropertyReferenceEClass = createEClass(APROPERTY_REFERENCE);
    createEReference(aPropertyReferenceEClass, APROPERTY_REFERENCE__PROPERTY);

    aVariableReferenceEClass = createEClass(AVARIABLE_REFERENCE);
    createEReference(aVariableReferenceEClass, AVARIABLE_REFERENCE__VARIABLE);

    aBinaryOperationEClass = createEClass(ABINARY_OPERATION);
    createEReference(aBinaryOperationEClass, ABINARY_OPERATION__LEFT_OPERAND);
    createEAttribute(aBinaryOperationEClass, ABINARY_OPERATION__FEATURE);
    createEReference(aBinaryOperationEClass, ABINARY_OPERATION__RIGHT_OPERAND);

    aUnaryOperationEClass = createEClass(AUNARY_OPERATION);
    createEAttribute(aUnaryOperationEClass, AUNARY_OPERATION__FEATURE);
    createEReference(aUnaryOperationEClass, AUNARY_OPERATION__OPERAND);

    aFeatureCallEClass = createEClass(AFEATURE_CALL);
    createEAttribute(aFeatureCallEClass, AFEATURE_CALL__FEATURE);
    createEReference(aFeatureCallEClass, AFEATURE_CALL__FUNCTION_CALL_ARGUMENTS);

    aSetLiteralEClass = createEClass(ASET_LITERAL);
    createEReference(aSetLiteralEClass, ASET_LITERAL__ELEMENTS);

    aListTermEClass = createEClass(ALIST_TERM);
    createEReference(aListTermEClass, ALIST_TERM__ELEMENTS);

    aNullLiteralEClass = createEClass(ANULL_LITERAL);

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

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    aExpressionEClass.getESuperTypes().add(theAadl2Package.getPropertyExpression());
    valDeclarationEClass.getESuperTypes().add(this.getAVariableDeclaration());
    computeDeclarationEClass.getESuperTypes().add(this.getAVariableDeclaration());
    aPropertyReferenceEClass.getESuperTypes().add(this.getAExpression());
    aVariableReferenceEClass.getESuperTypes().add(this.getAExpression());
    aBinaryOperationEClass.getESuperTypes().add(theAadl2Package.getPropertyExpression());
    aUnaryOperationEClass.getESuperTypes().add(theAadl2Package.getPropertyExpression());
    aFeatureCallEClass.getESuperTypes().add(theAadl2Package.getPropertyExpression());
    aSetLiteralEClass.getESuperTypes().add(theAadl2Package.getPropertyExpression());
    aListTermEClass.getESuperTypes().add(theAadl2Package.getPropertyExpression());
    aNullLiteralEClass.getESuperTypes().add(theAadl2Package.getPropertyExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(descriptionEClass, Description.class, "Description", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDescription_Description(), this.getDescriptionElement(), null, "description", null, 0, -1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(descriptionElementEClass, DescriptionElement.class, "DescriptionElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDescriptionElement_Text(), theEcorePackage.getEString(), "text", null, 0, 1, DescriptionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDescriptionElement_ShowValue(), this.getShowValue(), null, "showValue", null, 0, 1, DescriptionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDescriptionElement_ThisTarget(), theEcorePackage.getEBoolean(), "thisTarget", null, 0, 1, DescriptionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDescriptionElement_Image(), this.getImageReference(), null, "image", null, 0, 1, DescriptionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rationaleEClass, Rationale.class, "Rationale", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRationale_Text(), theEcorePackage.getEString(), "text", null, 0, 1, Rationale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(uncertaintyEClass, Uncertainty.class, "Uncertainty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUncertainty_Volatility(), theEcorePackage.getEInt(), "volatility", null, 0, 1, Uncertainty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUncertainty_Impact(), theEcorePackage.getEInt(), "impact", null, 0, 1, Uncertainty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultIssueEClass, ResultIssue.class, "ResultIssue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultIssue_IssueType(), this.getResultIssueType(), "issueType", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultIssue_Message(), theEcorePackage.getEString(), "message", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultIssue_Target(), theEcorePackage.getEObject(), null, "target", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultIssue_ExceptionType(), theEcorePackage.getEString(), "exceptionType", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultIssue_DiagnosticId(), theEcorePackage.getEString(), "diagnosticId", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultIssue_Issues(), this.getResultIssue(), null, "issues", null, 0, -1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aVariableDeclarationEClass, AVariableDeclaration.class, "AVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAVariableDeclaration_Type(), theEcorePackage.getEString(), "type", null, 0, 1, AVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAVariableDeclaration_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aExpressionEClass, AExpression.class, "AExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(showValueEClass, ShowValue.class, "ShowValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getShowValue_Ref(), this.getAVariableDeclaration(), null, "ref", null, 0, 1, ShowValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getShowValue_Unit(), theAadl2Package.getUnitLiteral(), null, "unit", null, 0, 1, ShowValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(imageReferenceEClass, ImageReference.class, "ImageReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImageReference_Imgfile(), theEcorePackage.getEString(), "imgfile", null, 0, 1, ImageReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valDeclarationEClass, ValDeclaration.class, "ValDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValDeclaration_Right(), theAadl2Package.getPropertyExpression(), null, "right", null, 0, 1, ValDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(computeDeclarationEClass, ComputeDeclaration.class, "ComputeDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(aPropertyReferenceEClass, APropertyReference.class, "APropertyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAPropertyReference_Property(), theAadl2Package.getAbstractNamedValue(), null, "property", null, 0, 1, APropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aVariableReferenceEClass, AVariableReference.class, "AVariableReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAVariableReference_Variable(), this.getAVariableDeclaration(), null, "variable", null, 0, 1, AVariableReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aBinaryOperationEClass, ABinaryOperation.class, "ABinaryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getABinaryOperation_LeftOperand(), theAadl2Package.getPropertyExpression(), null, "leftOperand", null, 0, 1, ABinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getABinaryOperation_Feature(), theEcorePackage.getEString(), "feature", null, 0, 1, ABinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getABinaryOperation_RightOperand(), theAadl2Package.getPropertyExpression(), null, "rightOperand", null, 0, 1, ABinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aUnaryOperationEClass, AUnaryOperation.class, "AUnaryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAUnaryOperation_Feature(), theEcorePackage.getEString(), "feature", null, 0, 1, AUnaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAUnaryOperation_Operand(), theAadl2Package.getPropertyExpression(), null, "operand", null, 0, 1, AUnaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aFeatureCallEClass, AFeatureCall.class, "AFeatureCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAFeatureCall_Feature(), theEcorePackage.getEString(), "feature", null, 0, 1, AFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAFeatureCall_FunctionCallArguments(), theAadl2Package.getPropertyExpression(), null, "functionCallArguments", null, 0, -1, AFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aSetLiteralEClass, ASetLiteral.class, "ASetLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASetLiteral_Elements(), theAadl2Package.getPropertyExpression(), null, "elements", null, 0, -1, ASetLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aListTermEClass, AListTerm.class, "AListTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAListTerm_Elements(), theAadl2Package.getPropertyExpression(), null, "elements", null, 0, -1, AListTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aNullLiteralEClass, ANullLiteral.class, "ANullLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(resultIssueTypeEEnum, ResultIssueType.class, "ResultIssueType");
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.TBD);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.ERROR);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.WARNING);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.INFO);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.SUCCESS);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.FAIL);

    // Create resource
    createResource(eNS_URI);
  }

} //CommonPackageImpl
