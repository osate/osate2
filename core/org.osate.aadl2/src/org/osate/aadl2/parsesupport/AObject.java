/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */

package org.osate.aadl2.parsesupport;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AObject</b></em>'.
 * @extends org.eclipse.core.runtime.IAdaptable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.cmu.sei.aadl.model.core.AObject#getComment <em>Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.cmu.sei.aadl.model.core.CorePackage#getAObject()
 * @model abstract="true"
 * @generated
 */
public interface AObject extends EObject, org.eclipse.core.runtime.IAdaptable {

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute list.
	 * @see edu.cmu.sei.aadl.model.core.CorePackage#getAObject_Comment()
	 * @model type="java.lang.String" unique="false"
	 * @generated
	 */

	/**
	 * Return the '<em><b>location reference</b></em>' attribute.
	 *
	 */
	LocationReference getLocationReference();

	/**
	 * Set  the '<em><b>location reference</b></em>' attribute.
	 * @param fn File name
	 * @param ln line number
	 */
	void setLocationReference(String fn, int ln);

	/**
	 * Set  the '<em><b>location reference</b></em>' attribute.
	 * @param lr Location Reference
	 */
	void setLocationReference(LocationReference lr);

} // AObject
