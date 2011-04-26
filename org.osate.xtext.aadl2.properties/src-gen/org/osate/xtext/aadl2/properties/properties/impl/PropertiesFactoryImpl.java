/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.properties.properties.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.xtext.aadl2.properties.properties.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertiesFactoryImpl extends EFactoryImpl implements PropertiesFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PropertiesFactory init()
  {
    try
    {
      PropertiesFactory thePropertiesFactory = (PropertiesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.osate.org/aadl2/properties/Properties"); 
      if (thePropertiesFactory != null)
      {
        return thePropertiesFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PropertiesFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertiesFactoryImpl()
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
      case PropertiesPackage.PROPERTY_SET: return createPropertySet();
      case PropertiesPackage.PROPERTY_TYPE: return createPropertyType();
      case PropertiesPackage.PROPERTY_DEFINITION: return createPropertyDefinition();
      case PropertiesPackage.PROPERTY_ASSOCIATION: return createPropertyAssociation();
      case PropertiesPackage.PROPERTY_EXPRESSION: return createPropertyExpression();
      case PropertiesPackage.LITERAL: return createLiteral();
      case PropertiesPackage.PROBABILITY_VALUE: return createProbabilityValue();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertySet createPropertySet()
  {
    PropertySetImpl propertySet = new PropertySetImpl();
    return propertySet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyType createPropertyType()
  {
    PropertyTypeImpl propertyType = new PropertyTypeImpl();
    return propertyType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyDefinition createPropertyDefinition()
  {
    PropertyDefinitionImpl propertyDefinition = new PropertyDefinitionImpl();
    return propertyDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyAssociation createPropertyAssociation()
  {
    PropertyAssociationImpl propertyAssociation = new PropertyAssociationImpl();
    return propertyAssociation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyExpression createPropertyExpression()
  {
    PropertyExpressionImpl propertyExpression = new PropertyExpressionImpl();
    return propertyExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProbabilityValue createProbabilityValue()
  {
    ProbabilityValueImpl probabilityValue = new ProbabilityValueImpl();
    return probabilityValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertiesPackage getPropertiesPackage()
  {
    return (PropertiesPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PropertiesPackage getPackage()
  {
    return PropertiesPackage.eINSTANCE;
  }

} //PropertiesFactoryImpl
