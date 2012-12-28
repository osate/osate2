/**
 * <copyright>
 * </copyright>
 *
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SOr Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.SOrExpression#getOperands <em>Operands</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getSOrExpression()
 * @model
 * @generated
 */
public interface SOrExpression extends ConditionExpression
{
  /**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operands</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getSOrExpression_Operands()
	 * @model containment="true"
	 * @generated
	 */
  EList<ConditionExpression> getOperands();

} // SOrExpression
