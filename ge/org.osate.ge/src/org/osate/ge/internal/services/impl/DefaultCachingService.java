package org.osate.ge.internal.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.osate.ge.internal.services.CachingService;

public class DefaultCachingService implements CachingService {
	private List<Cache> caches = new ArrayList<Cache>();
	
	@Override
	public void registerCache(final Cache cache) {
		caches.add(cache);
	}
	
	@Override
	public synchronized void invalidate() {
		for(final Cache cache : caches) {
			cache.invalidate();
		}
	}
}
