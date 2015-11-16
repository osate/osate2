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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.alisa.common.common.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonFactoryImpl extends EFactoryImpl implements CommonFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CommonFactory init()
  {
    try
    {
      CommonFactory theCommonFactory = (CommonFactory)EPackage.Registry.INSTANCE.getEFactory(CommonPackage.eNS_URI);
      if (theCommonFactory != null)
      {
        return theCommonFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CommonFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommonFactoryImpl()
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
      case CommonPackage.DESCRIPTION: return createDescription();
      case CommonPackage.DESCRIPTION_ELEMENT: return createDescriptionElement();
      case CommonPackage.RATIONALE: return createRationale();
      case CommonPackage.UNCERTAINTY: return createUncertainty();
      case CommonPackage.AVARIABLE_DECLARATION: return createAVariableDeclaration();
      case CommonPackage.AEXPRESSION: return createAExpression();
      case CommonPackage.SHOW_VALUE: return createShowValue();
      case CommonPackage.IMAGE_REFERENCE: return createImageReference();
      case CommonPackage.VAL_DECLARATION: return createValDeclaration();
      case CommonPackage.COMPUTE_DECLARATION: return createComputeDeclaration();
      case CommonPackage.APROPERTY_REFERENCE: return createAPropertyReference();
      case CommonPackage.AVARIABLE_REFERENCE: return createAVariableReference();
      case CommonPackage.ABINARY_OPERATION: return createABinaryOperation();
      case CommonPackage.AUNARY_OPERATION: return createAUnaryOperation();
      case CommonPackage.ASET_LITERAL: return createASetLiteral();
      case CommonPackage.ALIST_TERM: return createAListTerm();
      case CommonPackage.ANULL_LITERAL: return createANullLiteral();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Description createDescription()
  {
    DescriptionImpl description = new DescriptionImpl();
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DescriptionElement createDescriptionElement()
  {
    DescriptionElementImpl descriptionElement = new DescriptionElementImpl();
    return descriptionElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rationale createRationale()
  {
    RationaleImpl rationale = new RationaleImpl();
    return rationale;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Uncertainty createUncertainty()
  {
    UncertaintyImpl uncertainty = new UncertaintyImpl();
    return uncertainty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AVariableDeclaration createAVariableDeclaration()
  {
    AVariableDeclarationImpl aVariableDeclaration = new AVariableDeclarationImpl();
    return aVariableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AExpression createAExpression()
  {
    AExpressionImpl aExpression = new AExpressionImpl();
    return aExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShowValue createShowValue()
  {
    ShowValueImpl showValue = new ShowValueImpl();
    return showValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImageReference createImageReference()
  {
    ImageReferenceImpl imageReference = new ImageReferenceImpl();
    return imageReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValDeclaration createValDeclaration()
  {
    ValDeclarationImpl valDeclaration = new ValDeclarationImpl();
    return valDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComputeDeclaration createComputeDeclaration()
  {
    ComputeDeclarationImpl computeDeclaration = new ComputeDeclarationImpl();
    return computeDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public APropertyReference createAPropertyReference()
  {
    APropertyReferenceImpl aPropertyReference = new APropertyReferenceImpl();
    return aPropertyReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AVariableReference createAVariableReference()
  {
    AVariableReferenceImpl aVariableReference = new AVariableReferenceImpl();
    return aVariableReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ABinaryOperation createABinaryOperation()
  {
    ABinaryOperationImpl aBinaryOperation = new ABinaryOperationImpl();
    return aBinaryOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AUnaryOperation createAUnaryOperation()
  {
    AUnaryOperationImpl aUnaryOperation = new AUnaryOperationImpl();
    return aUnaryOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASetLiteral createASetLiteral()
  {
    ASetLiteralImpl aSetLiteral = new ASetLiteralImpl();
    return aSetLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AListTerm createAListTerm()
  {
    AListTermImpl aListTerm = new AListTermImpl();
    return aListTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ANullLiteral createANullLiteral()
  {
    ANullLiteralImpl aNullLiteral = new ANullLiteralImpl();
    return aNullLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommonPackage getCommonPackage()
  {
    return (CommonPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static CommonPackage getPackage()
  {
    return CommonPackage.eINSTANCE;
  }

} //CommonFactoryImpl
