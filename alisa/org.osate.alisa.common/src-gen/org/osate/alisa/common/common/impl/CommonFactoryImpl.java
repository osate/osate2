/**
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
      case CommonPackage.MODEL: return createModel();
      case CommonPackage.DESCRIPTION: return createDescription();
      case CommonPackage.DESCRIPTION_ELEMENT: return createDescriptionElement();
      case CommonPackage.SHOW_VALUE: return createShowValue();
      case CommonPackage.REFERENCE_PATH: return createReferencePath();
      case CommonPackage.PREDICATE_EXPRESSION: return createPredicateExpression();
      case CommonPackage.CONSTANT_DECL: return createConstantDecl();
      case CommonPackage.CONSTANT_VALUE: return createConstantValue();
      case CommonPackage.STRING_TERM: return createStringTerm();
      case CommonPackage.REAL_TERM: return createRealTerm();
      case CommonPackage.INTEGER_TERM: return createIntegerTerm();
      case CommonPackage.MULTI_LINE_STRING: return createMultiLineString();
      case CommonPackage.TEXT_ELEMENT: return createTextElement();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
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
  public ReferencePath createReferencePath()
  {
    ReferencePathImpl referencePath = new ReferencePathImpl();
    return referencePath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PredicateExpression createPredicateExpression()
  {
    PredicateExpressionImpl predicateExpression = new PredicateExpressionImpl();
    return predicateExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantDecl createConstantDecl()
  {
    ConstantDeclImpl constantDecl = new ConstantDeclImpl();
    return constantDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantValue createConstantValue()
  {
    ConstantValueImpl constantValue = new ConstantValueImpl();
    return constantValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringTerm createStringTerm()
  {
    StringTermImpl stringTerm = new StringTermImpl();
    return stringTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RealTerm createRealTerm()
  {
    RealTermImpl realTerm = new RealTermImpl();
    return realTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegerTerm createIntegerTerm()
  {
    IntegerTermImpl integerTerm = new IntegerTermImpl();
    return integerTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiLineString createMultiLineString()
  {
    MultiLineStringImpl multiLineString = new MultiLineStringImpl();
    return multiLineString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TextElement createTextElement()
  {
    TextElementImpl textElement = new TextElementImpl();
    return textElement;
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
