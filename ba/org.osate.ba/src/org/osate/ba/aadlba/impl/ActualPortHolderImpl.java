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
package org.osate.ba.aadlba.impl;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Port;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.ActualPortHolder;
import org.osate.ba.utils.visitor.IBAVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actual Port Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ActualPortHolderImpl extends PortHolderImpl implements ActualPortHolder {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActualPortHolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.ACTUAL_PORT_HOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPort(final Port port) {
		element = port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Port getPort() {
		return (Port) element;
	}

	public void accept(IBAVisitor visitor) {
		visitor.visit(this);
	}
} // ActualPortHolderImpl
