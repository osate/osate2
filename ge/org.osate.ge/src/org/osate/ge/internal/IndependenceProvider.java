/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092.
 *******************************************************************************/
package org.osate.ge.internal;

import javax.inject.Inject;

import org.eclipse.graphiti.features.impl.IIndependenceSolver;
import org.osate.ge.internal.services.SerializableReferenceService;

public class IndependenceProvider implements IIndependenceSolver {
	private final SerializableReferenceService serializableReferenceService;

	@Inject
	public IndependenceProvider(final SerializableReferenceService serializableReferenceService) {
		this.serializableReferenceService = serializableReferenceService;
	}

	@Override
	public String getKeyForBusinessObject(final Object bo) {
		return serializableReferenceService.getReference(AadlElementWrapper.unwrap(bo));
	}

	@Override
	public Object getBusinessObjectForKey(final String key) {
		if(key == null) {
			return null;
		}

		final Object result = serializableReferenceService.getReferencedObject(key);
		return result;
	}
}
