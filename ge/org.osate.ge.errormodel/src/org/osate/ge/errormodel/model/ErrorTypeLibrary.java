/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.errormodel.model;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.EObjectReferenceProvider;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;

public class ErrorTypeLibrary implements EObjectReferenceProvider {
	private final ErrorModelLibrary errorModelLib;
	
	public ErrorTypeLibrary(final ErrorModelLibrary errorModelLib) {
		this.errorModelLib = Objects.requireNonNull(errorModelLib, "errorModelLib must not be null");
	}
	
	public final ErrorModelLibrary getErrorModelLibrary() {
		return errorModelLib;
	}

	@Override
	public EObject getEObjectReference() {
		return errorModelLib;
	}
}
