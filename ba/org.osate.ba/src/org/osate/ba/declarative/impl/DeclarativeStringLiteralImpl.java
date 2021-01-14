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
package org.osate.ba.declarative.impl;

import org.eclipse.emf.ecore.EClass;
import org.osate.ba.aadlba.impl.BehaviorStringLiteralImpl;
import org.osate.ba.declarative.DeclarativePackage;
import org.osate.ba.declarative.DeclarativeStringLiteral;
import org.osate.ba.utils.AadlBaLocationReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class DeclarativeStringLiteralImpl extends BehaviorStringLiteralImpl implements DeclarativeStringLiteral {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclarativeStringLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeclarativePackage.Literals.DECLARATIVE_STRING_LITERAL;
	}

	@Override
	public AadlBaLocationReference getAadlBaLocationReference() {
		return (AadlBaLocationReference) this.getLocationReference();
	}

} // DeclarativeStringLiteralImpl
