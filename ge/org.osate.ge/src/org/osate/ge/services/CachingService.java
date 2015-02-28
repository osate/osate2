package org.osate.ge.services;

/**
 * Service for controlling caching
 * @author philip.alldredge
 *
 */
public interface CachingService {
	interface Cache {
		void invalidate(); // Called when the cache should invalidate
	}
	
	void registerCache(final Cache cache);
	void invalidate(); // Invalidates all caches under the control of the caching service
}
