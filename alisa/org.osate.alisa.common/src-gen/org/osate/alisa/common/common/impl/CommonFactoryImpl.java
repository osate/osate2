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
import org.eclipse.emf.ecore.EDataType;
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
      case CommonPackage.AMODEL_REFERENCE: return createAModelReference();
      case CommonPackage.APROPERTY_REFERENCE: return createAPropertyReference();
      case CommonPackage.AUNIT_EXPRESSION: return createAUnitExpression();
      case CommonPackage.IMAGE_REFERENCE: return createImageReference();
      case CommonPackage.MODEL_REF: return createModelRef();
      case CommonPackage.TYPE_REF: return createTypeRef();
      case CommonPackage.PROPERTY_REF: return createPropertyRef();
      case CommonPackage.VAL_DECLARATION: return createValDeclaration();
      case CommonPackage.COMPUTE_DECLARATION: return createComputeDeclaration();
      case CommonPackage.AVARIABLE_REFERENCE: return createAVariableReference();
      case CommonPackage.ABINARY_OPERATION: return createABinaryOperation();
      case CommonPackage.AUNARY_OPERATION: return createAUnaryOperation();
      case CommonPackage.AFUNCTION_CALL: return createAFunctionCall();
      case CommonPackage.ARANGE: return createARange();
      case CommonPackage.ACONDITIONAL: return createAConditional();
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
      case CommonPackage.OPERATION:
        return createOperationFromString(eDataType, initialValue);
      case CommonPackage.TARGET_TYPE:
        return createTargetTypeFromString(eDataType, initialValue);
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
      case CommonPackage.OPERATION:
        return convertOperationToString(eDataType, instanceValue);
      case CommonPackage.TARGET_TYPE:
        return convertTargetTypeToString(eDataType, instanceValue);
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
  public AModelReference createAModelReference()
  {
    AModelReferenceImpl aModelReference = new AModelReferenceImpl();
    return aModelReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
  public AUnitExpression createAUnitExpression()
  {
    AUnitExpressionImpl aUnitExpression = new AUnitExpressionImpl();
    return aUnitExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
  public ModelRef createModelRef()
  {
    ModelRefImpl modelRef = new ModelRefImpl();
    return modelRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TypeRef createTypeRef()
  {
    TypeRefImpl typeRef = new TypeRefImpl();
    return typeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyRef createPropertyRef()
  {
    PropertyRefImpl propertyRef = new PropertyRefImpl();
    return propertyRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
  public AFunctionCall createAFunctionCall()
  {
    AFunctionCallImpl aFunctionCall = new AFunctionCallImpl();
    return aFunctionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ARange createARange()
  {
    ARangeImpl aRange = new ARangeImpl();
    return aRange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AConditional createAConditional()
  {
    AConditionalImpl aConditional = new AConditionalImpl();
    return aConditional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operation createOperationFromString(EDataType eDataType, String initialValue)
  {
    Operation result = Operation.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOperationToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TargetType createTargetTypeFromString(EDataType eDataType, String initialValue)
  {
    TargetType result = TargetType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTargetTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
