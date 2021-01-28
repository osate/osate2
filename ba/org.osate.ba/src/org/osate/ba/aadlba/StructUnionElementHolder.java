/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2021 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.aadlba;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct Union Element Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.StructUnionElementHolder#getStructUnionElement <em>Struct Union Element</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getStructUnionElementHolder()
 * @model
 * @generated
 */
public interface StructUnionElementHolder extends DataHolder, IndexableElement, Target, ElementValues {
	/**
	 * Sets the value of the '{@link org.osate.ba.aadlba.StructUnionElementHolder#getStructUnionElement <em>Struct Union Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Struct Union Element</em>' containment reference.
	 * @see #getStructUnionElement()
	 * @generated
	 */
	void setStructUnionElement(StructUnionElement value);

	/**
	 * Returns the value of the '<em><b>Struct Union Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Struct Union Element</em>' containment reference.
	 * @see #setStructUnionElement(StructUnionElement)
	 * @see org.osate.ba.aadlba.AadlBaPackage#getStructUnionElementHolder_StructUnionElement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StructUnionElement getStructUnionElement();

} // StructUnionElementHolder
