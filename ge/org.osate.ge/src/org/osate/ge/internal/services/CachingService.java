package org.osate.ge.internal.services;

/**
 * Service for controlling caching
 *
 */
public interface CachingService {
	interface Cache {
		void invalidate(); // Called when the cache should invalidate
	}
	
	void registerCache(final Cache cache);
	void invalidate(); // Invalidates all caches under the control of the caching service
}
