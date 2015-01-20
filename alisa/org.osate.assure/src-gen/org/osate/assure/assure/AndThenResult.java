/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>And Then Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.AndThenResult#getFirst <em>First</em>}</li>
 *   <li>{@link org.osate.assure.assure.AndThenResult#getSecond <em>Second</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getAndThenResult()
 * @model
 * @generated
 */
public interface AndThenResult extends VerificationExpr
{
  /**
   * Returns the value of the '<em><b>First</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getAndThenResult_First()
   * @model containment="true"
   * @generated
   */
  EList<VerificationExpr> getFirst();

  /**
   * Returns the value of the '<em><b>Second</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getAndThenResult_Second()
   * @model containment="true"
   * @generated
   */
  EList<VerificationExpr> getSecond();

} // AndThenResult
