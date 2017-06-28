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

import org.osate.ge.services.ReferenceBuilderService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.impl.SimpleServiceContextFunction;

public class DefaultReferenceBuilderService implements ReferenceBuilderService {
	private final ReferenceService internalService;
	
	public static class ContextFunction extends SimpleServiceContextFunction<ReferenceBuilderService> {
		@Override
		public ReferenceBuilderService createService(final IEclipseContext context) {
			return new DefaultReferenceBuilderService(context.get(ReferenceService.class));
		}		
	}
	
	public DefaultReferenceBuilderService(final ReferenceService internalService) {
		this.internalService = Objects.requireNonNull(internalService, "internalService must not be null");
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final Object bo) {
		return this.internalService.getCanonicalReference(bo);
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final Object bo) {
		return this.internalService.getRelativeReference(bo);
	}
}
