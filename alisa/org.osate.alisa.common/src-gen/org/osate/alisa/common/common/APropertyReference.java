/**
 */
package org.osate.alisa.common.common;

<<<<<<< HEAD
import org.osate.aadl2.AbstractNamedValue;
=======
import org.osate.aadl2.Property;
>>>>>>> refs/remotes/origin/PeterWork

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AProperty Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.APropertyReference#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getAPropertyReference()
 * @model
 * @generated
 */
public interface APropertyReference extends AExpression
{
  /**
   * Returns the value of the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' reference.
   * @see #setProperty(AbstractNamedValue)
   * @see org.osate.alisa.common.common.CommonPackage#getAPropertyReference_Property()
   * @model
   * @generated
   */
  AbstractNamedValue getProperty();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.APropertyReference#getProperty <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(AbstractNamedValue value);

} // APropertyReference
