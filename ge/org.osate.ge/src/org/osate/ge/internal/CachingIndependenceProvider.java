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
