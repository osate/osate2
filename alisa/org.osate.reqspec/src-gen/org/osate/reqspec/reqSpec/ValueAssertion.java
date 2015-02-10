/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.ValueAssertion#getXpression <em>Xpression</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ValueAssertion#getValToPropertyMappings <em>Val To Property Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getValueAssertion()
 * @model
 * @generated
 */
public interface ValueAssertion extends ReqPredicate
{
  /**
   * Returns the value of the '<em><b>Xpression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xpression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xpression</em>' containment reference.
   * @see #setXpression(XExpression)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getValueAssertion_Xpression()
   * @model containment="true"
   * @generated
   */
  XExpression getXpression();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ValueAssertion#getXpression <em>Xpression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xpression</em>' containment reference.
   * @see #getXpression()
   * @generated
   */
  void setXpression(XExpression value);

  /**
   * Returns the value of the '<em><b>Val To Property Mappings</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.ValToPropertyMapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val To Property Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val To Property Mappings</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getValueAssertion_ValToPropertyMappings()
   * @model containment="true"
   * @generated
   */
  EList<ValToPropertyMapping> getValToPropertyMappings();

} // ValueAssertion
