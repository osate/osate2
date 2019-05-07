/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.verify.verify;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Python Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.PythonMethod#getMethodPath <em>Method Path</em>}</li>
 * </ul>
 *
 * @see org.osate.verify.verify.VerifyPackage#getPythonMethod()
 * @model
 * @generated
 */
public interface PythonMethod extends MethodKind
{
  /**
   * Returns the value of the '<em><b>Method Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Path</em>' attribute.
   * @see #setMethodPath(String)
   * @see org.osate.verify.verify.VerifyPackage#getPythonMethod_MethodPath()
   * @model
   * @generated
   */
  String getMethodPath();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.PythonMethod#getMethodPath <em>Method Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method Path</em>' attribute.
   * @see #getMethodPath()
   * @generated
   */
  void setMethodPath(String value);

} // PythonMethod
