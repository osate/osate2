/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 *
 * $Id: ContainmentPathElement.java,v 1.5 2009-01-12 16:25:09 jseibel Exp $
 */
package org.osate.aadl2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Containment Path Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLProperties::Associations.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.aadl2.ContainmentPathElement#getArrayRanges <em>Array Range</em>}</li>
 *   <li>{@link org.osate.aadl2.ContainmentPathElement#getNamedElement <em>Named Element</em>}</li>
 *   <li>{@link org.osate.aadl2.ContainmentPathElement#getAnnexName <em>Annex Name</em>}</li>
 *   <li>{@link org.osate.aadl2.ContainmentPathElement#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.aadl2.Aadl2Package#getContainmentPathElement()
 * @model
 * @generated
 */
public interface ContainmentPathElement extends Element {
	/**
	 * Returns the value of the '<em><b>Array Range</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ArrayRange}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Range</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Associations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Array Range</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getContainmentPathElement_ArrayRange()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArrayRange> getArrayRanges();

	/**
	 * Creates a new {@link org.osate.aadl2.ArrayRange} and appends it to the '<em><b>Array Range</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ArrayRange}.
	 * @see #getArrayRanges()
	 * @generated
	 */
	ArrayRange createArrayRange();

	/**
	 * Returns the value of the '<em><b>Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Associations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Named Element</em>' reference.
	 * @see #setNamedElement(NamedElement)
	 * @see org.osate.aadl2.Aadl2Package#getContainmentPathElement_NamedElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NamedElement getNamedElement();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ContainmentPathElement#getNamedElement <em>Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Named Element</em>' reference.
	 * @see #getNamedElement()
	 * @generated
	 */
	void setNamedElement(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Annex Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annex Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Associations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Annex Name</em>' attribute.
	 * @see #setAnnexName(String)
	 * @see org.osate.aadl2.Aadl2Package#getContainmentPathElement_AnnexName()
	 * @model dataType="org.osate.aadl2.String" ordered="false"
	 * @generated
	 */
	String getAnnexName();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ContainmentPathElement#getAnnexName <em>Annex Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annex Name</em>' attribute.
	 * @see #getAnnexName()
	 * @generated
	 */
	void setAnnexName(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Associations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Path</em>' containment reference.
	 * @see #setPath(ContainmentPathElement)
	 * @see org.osate.aadl2.Aadl2Package#getContainmentPathElement_Path()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ContainmentPathElement getPath();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ContainmentPathElement#getPath <em>Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' containment reference.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(ContainmentPathElement value);

	/**
	 * Creates a new {@link org.osate.aadl2.ContainmentPathElement} and sets the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ContainmentPathElement}.
	 * @see #getPath()
	 * @generated
	 */
	ContainmentPathElement createPath();
} // ContainmentPathElement
