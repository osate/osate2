/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instance;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.PropertyValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.InstanceReferenceValue#getReferencedInstanceObject <em>Referenced Instance Object</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.instance.InstancePackage#getInstanceReferenceValue()
 * @model
 * @generated
 */
public interface InstanceReferenceValue extends EObject, PropertyValue {
	/**
	 * Returns the value of the '<em><b>Referenced Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Instance Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Instance Object</em>' reference.
	 * @see #setReferencedInstanceObject(InstanceObject)
	 * @see org.osate.aadl2.instance.InstancePackage#getInstanceReferenceValue_ReferencedInstanceObject()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InstanceObject getReferencedInstanceObject();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.InstanceReferenceValue#getReferencedInstanceObject <em>Referenced Instance Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Instance Object</em>' reference.
	 * @see #getReferencedInstanceObject()
	 * @generated
	 */
	void setReferencedInstanceObject(InstanceObject value);

} // InstanceReferenceValue
