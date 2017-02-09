/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.graphiti.features.impl.IIndependenceSolver;
import org.osate.ge.internal.services.CachingService.Cache;

class CachingIndependenceProvider implements IIndependenceSolver, Cache {
	private IIndependenceSolver solver;
	private Map<String, Object> keyToBusinessObjectMap = new HashMap<String, Object>();
	
	public CachingIndependenceProvider(final IIndependenceSolver solver) {
		this.solver = solver;
	}
	
	@Override
	public String getKeyForBusinessObject(final Object bo) {
		// The results of getKeyForBusinessObject() are not cached because it is of dubious value
		return solver.getKeyForBusinessObject(bo);
	}

	@Override
	public Object getBusinessObjectForKey(final String key) {
		// Look in the cache first. Don't return null objects even if they have been stored in the cache.
		Object bo = keyToBusinessObjectMap.get(key);
		if(bo != null) {
			return bo;
		}
		
		// Retrieve the value and add it to the cache
		bo = solver.getBusinessObjectForKey(key);
		keyToBusinessObjectMap.put(key, bo);
		return bo;
	}
	
	public void invalidate() {
		keyToBusinessObjectMap.clear();
	}

}
