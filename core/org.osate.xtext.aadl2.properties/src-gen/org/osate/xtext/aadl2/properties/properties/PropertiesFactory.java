/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.properties.properties;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.properties.properties.PropertiesPackage
 * @generated
 */
public interface PropertiesFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PropertiesFactory eINSTANCE = org.osate.xtext.aadl2.properties.properties.impl.PropertiesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Property Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Set</em>'.
   * @generated
   */
  PropertySet createPropertySet();

  /**
   * Returns a new object of class '<em>Property Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Type</em>'.
   * @generated
   */
  PropertyType createPropertyType();

  /**
   * Returns a new object of class '<em>Property Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Definition</em>'.
   * @generated
   */
  PropertyDefinition createPropertyDefinition();

  /**
   * Returns a new object of class '<em>Property Association</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Association</em>'.
   * @generated
   */
  PropertyAssociation createPropertyAssociation();

  /**
   * Returns a new object of class '<em>Property Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Expression</em>'.
   * @generated
   */
  PropertyExpression createPropertyExpression();

  /**
   * Returns a new object of class '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal</em>'.
   * @generated
   */
  Literal createLiteral();

  /**
   * Returns a new object of class '<em>Probability Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Probability Value</em>'.
   * @generated
   */
  ProbabilityValue createProbabilityValue();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  PropertiesPackage getPropertiesPackage();

} //PropertiesFactory
