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
package org.osate.results.results;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Contributor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.results.results.ResultContributor#getCell <em>Cell</em>}</li>
 *   <li>{@link org.osate.results.results.ResultContributor#getSubcontributor <em>Subcontributor</em>}</li>
 * </ul>
 *
 * @see org.osate.results.results.ResultsPackage#getResultContributor()
 * @model
 * @generated
 */
public interface ResultContributor extends ResultIssue
{
  /**
   * Returns the value of the '<em><b>Cell</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cell</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cell</em>' attribute list.
   * @see org.osate.results.results.ResultsPackage#getResultContributor_Cell()
   * @model unique="false"
   * @generated
   */
  EList<String> getCell();

  /**
   * Returns the value of the '<em><b>Subcontributor</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.results.results.ResultIssue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subcontributor</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subcontributor</em>' containment reference list.
   * @see org.osate.results.results.ResultsPackage#getResultContributor_Subcontributor()
   * @model containment="true"
   * @generated
   */
  EList<ResultIssue> getSubcontributor();

} // ResultContributor
