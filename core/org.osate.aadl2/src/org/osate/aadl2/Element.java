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
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
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
 * $Id: Element.java,v 1.25 2009-10-07 16:46:58 lwrage Exp $
 */
package org.osate.aadl2;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.parsesupport.AObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An element is a constituent of a model.
 * An element is a constituent of a model. As such, it has the capability of owning other elements.
 * <p>From package AADLInfrastructure.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.Element#getOwnedElements <em>Owned Element</em>}</li>
 *   <li>{@link org.osate.aadl2.Element#getOwnedComments <em>Owned Comment</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getElement()
 * @model abstract="true"
 * @extends AObject
 * @generated
 */
public interface Element extends AObject {
	/**
	 * Returns the value of the '<em><b>Owned Element</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.Element}.
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Elements owned by this element.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Element</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getElement_OwnedElement()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="union"
	 * @generated
	 */
	EList<Element> getOwnedElements();

	/**
	 * Returns the value of the '<em><b>Owned Comment</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.Comment}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Element#getOwnedElements() <em>Owned Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Comments owned by this element.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Comment</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getElement_OwnedComment()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Comment> getOwnedComments();

	/**
	 * Creates a new {@link org.osate.aadl2.Comment} and appends it to the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.Comment}.
	 * @see #getOwnedComments()
	 * @generated
	 */
	Comment createOwnedComment();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" ordered="false"
	 * @generated
	 */
	Element getOwner();

	/**
	 * Find the root container of this element
	 * @return The root container of this element
	 */
	NamedElement getElementRoot();

	/**
	 * Get the children of an Element
	 * This will be the content.
	 * In case of modal ComponentInstance this method is overwritten
	 * to provide mode-specific children, i.e.,
	 * the subset that is active in a given mode
	 * @return EList Element
	 */
	EList<Element> getChildren();

	/**
	 * Get the enclosing component type or implementation or Feature Group Type.
	 * @return containing classifier or null
	 */
	Classifier getContainingClassifier();

	/**
	 * Get the enclosing component implementation.
	 * @return containing ComponentImpl or null
	 */
	ComponentImplementation getContainingComponentImpl();

} // Element
