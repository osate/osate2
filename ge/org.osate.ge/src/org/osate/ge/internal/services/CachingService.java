/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services;

/**
 * Service for controlling caching. Primarily used for AADL declarative models.
 * TODO: Consider reworking since the usage of this service is now limited.
  */
public interface CachingService {
	interface Cache {
		void invalidate(); // Called when the cache should invalidate
	}
	
	void registerCache(final Cache cache);
	void invalidate(); // Invalidates all caches under the control of the caching service
}
