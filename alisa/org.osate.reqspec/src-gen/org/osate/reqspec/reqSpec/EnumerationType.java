/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.EnumerationType#getEnumerators <em>Enumerators</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getEnumerationType()
 * @model
 * @generated
 */
public interface EnumerationType extends FiniteSetType, Type
{
  /**
   * Returns the value of the '<em><b>Enumerators</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Enumerator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enumerators</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumerators</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getEnumerationType_Enumerators()
   * @model containment="true"
   * @generated
   */
  EList<Enumerator> getEnumerators();

} // EnumerationType
