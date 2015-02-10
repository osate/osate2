/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Guarantee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.OutputGuarantee#getXpression <em>Xpression</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.OutputGuarantee#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getOutputGuarantee()
 * @model
 * @generated
 */
public interface OutputGuarantee extends ReqPredicate
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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getOutputGuarantee_Xpression()
   * @model containment="true"
   * @generated
   */
  XExpression getXpression();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.OutputGuarantee#getXpression <em>Xpression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xpression</em>' containment reference.
   * @see #getXpression()
   * @generated
   */
  void setXpression(XExpression value);

  /**
   * Returns the value of the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference</em>' reference.
   * @see #setReference(EObject)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getOutputGuarantee_Reference()
   * @model
   * @generated
   */
  EObject getReference();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.OutputGuarantee#getReference <em>Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' reference.
   * @see #getReference()
   * @generated
   */
  void setReference(EObject value);

} // OutputGuarantee
