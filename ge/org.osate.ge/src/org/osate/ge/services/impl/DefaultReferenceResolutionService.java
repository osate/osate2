/*******************************************************************************
 * Copyright (C) 2016-2017 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105
 *******************************************************************************/
package org.osate.ge.services.impl;

import java.util.Objects;

import org.osate.ge.services.ReferenceResolutionService;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.services.ProjectReferenceService;

public class DefaultReferenceResolutionService implements ReferenceResolutionService {
	private final ProjectReferenceService srService;
	
	public DefaultReferenceResolutionService(final ProjectReferenceService srService) {
		this.srService = Objects.requireNonNull(srService, "srService must not be null");
	}

	@Override
	public Object resolve(final CanonicalBusinessObjectReference reference) {
		return srService.resolve(reference);
	}
}
