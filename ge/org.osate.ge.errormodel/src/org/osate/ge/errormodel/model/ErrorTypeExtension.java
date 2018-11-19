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
import org.osate.ge.EmfContainerProvider;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class ErrorTypeExtension implements EmfContainerProvider {
	private final ErrorType supertype;
	private final ErrorType subtype;

	public ErrorTypeExtension(final ErrorType supertype, final ErrorType subtype) {
		this.supertype = Objects.requireNonNull(supertype, "supertype must not be null");
		this.subtype = Objects.requireNonNull(subtype, "subtype must not be null");
	}

	public final ErrorType getSupertype() {
		return supertype;
	}

	public final ErrorType getSubtype() {
		return subtype;
	}

	@Override
	public EObject getEmfContainer() {
		return subtype;
	}
}
