/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105
 *******************************************************************************/
package org.osate.ge.services.impl;

import java.util.Objects;

import org.osate.aadl2.AadlPackage;
import org.osate.ge.services.ReferenceService;
import org.osate.ge.internal.services.SerializableReferenceService;

public class DefaultReferenceService implements ReferenceService {
	private final SerializableReferenceService srService;
	
	public DefaultReferenceService(final SerializableReferenceService srService) {
		this.srService = Objects.requireNonNull(srService, "srService must not be null");
	}
	
	@Override
	public AadlPackage getAadlPackage(final String qualifiedName) {
		return srService.getAadlPackage(qualifiedName);
	}

}
