/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.properties.properties;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.properties.properties.PropertiesFactory
 * @model kind="package"
 * @generated
 */
public interface PropertiesPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "properties";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/aadl2/properties/Properties";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "properties";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PropertiesPackage eINSTANCE = org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.properties.properties.impl.PropertySetImpl <em>Property Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.properties.properties.impl.PropertySetImpl
   * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getPropertySet()
   * @generated
   */
  int PROPERTY_SET = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_SET__NAME = 0;

  /**
   * The feature id for the '<em><b>Owned</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_SET__OWNED = 1;

  /**
   * The number of structural features of the '<em>Property Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_SET_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.properties.properties.impl.PropertyTypeImpl <em>Property Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.properties.properties.impl.PropertyTypeImpl
   * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getPropertyType()
   * @generated
   */
  int PROPERTY_TYPE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_TYPE__NAME = 0;

  /**
   * The number of structural features of the '<em>Property Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.properties.properties.impl.PropertyDefinitionImpl <em>Property Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.properties.properties.impl.PropertyDefinitionImpl
   * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getPropertyDefinition()
   * @generated
   */
  int PROPERTY_DEFINITION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DEFINITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DEFINITION__TYPE = 1;

  /**
   * The number of structural features of the '<em>Property Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DEFINITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.properties.properties.impl.PropertyAssociationImpl <em>Property Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.properties.properties.impl.PropertyAssociationImpl
   * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getPropertyAssociation()
   * @generated
   */
  int PROPERTY_ASSOCIATION = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_ASSOCIATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_ASSOCIATION__VALUE = 1;

  /**
   * The number of structural features of the '<em>Property Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_ASSOCIATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.properties.properties.impl.PropertyExpressionImpl <em>Property Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.properties.properties.impl.PropertyExpressionImpl
   * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getPropertyExpression()
   * @generated
   */
  int PROPERTY_EXPRESSION = 4;

  /**
   * The number of structural features of the '<em>Property Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.properties.properties.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.properties.properties.impl.LiteralImpl
   * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__NAME = PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.properties.properties.impl.ProbabilityValueImpl <em>Probability Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.properties.properties.impl.ProbabilityValueImpl
   * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getProbabilityValue()
   * @generated
   */
  int PROBABILITY_VALUE = 6;

  /**
   * The feature id for the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBABILITY_VALUE__NUMBER = PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Distribution</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBABILITY_VALUE__DISTRIBUTION = PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Probability Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBABILITY_VALUE_FEATURE_COUNT = PROPERTY_EXPRESSION_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.properties.properties.PropertySet <em>Property Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Set</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.PropertySet
   * @generated
   */
  EClass getPropertySet();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.properties.properties.PropertySet#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.PropertySet#getName()
   * @see #getPropertySet()
   * @generated
   */
  EAttribute getPropertySet_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.properties.properties.PropertySet#getOwned <em>Owned</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.PropertySet#getOwned()
   * @see #getPropertySet()
   * @generated
   */
  EReference getPropertySet_Owned();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.properties.properties.PropertyType <em>Property Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Type</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.PropertyType
   * @generated
   */
  EClass getPropertyType();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.properties.properties.PropertyType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.PropertyType#getName()
   * @see #getPropertyType()
   * @generated
   */
  EAttribute getPropertyType_Name();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.properties.properties.PropertyDefinition <em>Property Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Definition</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.PropertyDefinition
   * @generated
   */
  EClass getPropertyDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.properties.properties.PropertyDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.PropertyDefinition#getName()
   * @see #getPropertyDefinition()
   * @generated
   */
  EAttribute getPropertyDefinition_Name();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.properties.properties.PropertyDefinition#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.PropertyDefinition#getType()
   * @see #getPropertyDefinition()
   * @generated
   */
  EReference getPropertyDefinition_Type();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.properties.properties.PropertyAssociation <em>Property Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Association</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.PropertyAssociation
   * @generated
   */
  EClass getPropertyAssociation();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.properties.properties.PropertyAssociation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.PropertyAssociation#getName()
   * @see #getPropertyAssociation()
   * @generated
   */
  EAttribute getPropertyAssociation_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.properties.properties.PropertyAssociation#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.PropertyAssociation#getValue()
   * @see #getPropertyAssociation()
   * @generated
   */
  EReference getPropertyAssociation_Value();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.properties.properties.PropertyExpression <em>Property Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Expression</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.PropertyExpression
   * @generated
   */
  EClass getPropertyExpression();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.properties.properties.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.properties.properties.Literal#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.Literal#getName()
   * @see #getLiteral()
   * @generated
   */
  EAttribute getLiteral_Name();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.properties.properties.ProbabilityValue <em>Probability Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Probability Value</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.ProbabilityValue
   * @generated
   */
  EClass getProbabilityValue();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.properties.properties.ProbabilityValue#getNumber <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.ProbabilityValue#getNumber()
   * @see #getProbabilityValue()
   * @generated
   */
  EAttribute getProbabilityValue_Number();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.properties.properties.ProbabilityValue#getDistribution <em>Distribution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Distribution</em>'.
   * @see org.osate.xtext.aadl2.properties.properties.ProbabilityValue#getDistribution()
   * @see #getProbabilityValue()
   * @generated
   */
  EAttribute getProbabilityValue_Distribution();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PropertiesFactory getPropertiesFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.properties.properties.impl.PropertySetImpl <em>Property Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.properties.properties.impl.PropertySetImpl
     * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getPropertySet()
     * @generated
     */
    EClass PROPERTY_SET = eINSTANCE.getPropertySet();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_SET__NAME = eINSTANCE.getPropertySet_Name();

    /**
     * The meta object literal for the '<em><b>Owned</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_SET__OWNED = eINSTANCE.getPropertySet_Owned();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.properties.properties.impl.PropertyTypeImpl <em>Property Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.properties.properties.impl.PropertyTypeImpl
     * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getPropertyType()
     * @generated
     */
    EClass PROPERTY_TYPE = eINSTANCE.getPropertyType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_TYPE__NAME = eINSTANCE.getPropertyType_Name();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.properties.properties.impl.PropertyDefinitionImpl <em>Property Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.properties.properties.impl.PropertyDefinitionImpl
     * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getPropertyDefinition()
     * @generated
     */
    EClass PROPERTY_DEFINITION = eINSTANCE.getPropertyDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_DEFINITION__NAME = eINSTANCE.getPropertyDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_DEFINITION__TYPE = eINSTANCE.getPropertyDefinition_Type();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.properties.properties.impl.PropertyAssociationImpl <em>Property Association</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.properties.properties.impl.PropertyAssociationImpl
     * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getPropertyAssociation()
     * @generated
     */
    EClass PROPERTY_ASSOCIATION = eINSTANCE.getPropertyAssociation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_ASSOCIATION__NAME = eINSTANCE.getPropertyAssociation_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_ASSOCIATION__VALUE = eINSTANCE.getPropertyAssociation_Value();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.properties.properties.impl.PropertyExpressionImpl <em>Property Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.properties.properties.impl.PropertyExpressionImpl
     * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getPropertyExpression()
     * @generated
     */
    EClass PROPERTY_EXPRESSION = eINSTANCE.getPropertyExpression();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.properties.properties.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.properties.properties.impl.LiteralImpl
     * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL__NAME = eINSTANCE.getLiteral_Name();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.properties.properties.impl.ProbabilityValueImpl <em>Probability Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.properties.properties.impl.ProbabilityValueImpl
     * @see org.osate.xtext.aadl2.properties.properties.impl.PropertiesPackageImpl#getProbabilityValue()
     * @generated
     */
    EClass PROBABILITY_VALUE = eINSTANCE.getProbabilityValue();

    /**
     * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROBABILITY_VALUE__NUMBER = eINSTANCE.getProbabilityValue_Number();

    /**
     * The meta object literal for the '<em><b>Distribution</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROBABILITY_VALUE__DISTRIBUTION = eINSTANCE.getProbabilityValue_Distribution();

  }

} //PropertiesPackage
