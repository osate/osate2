/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.eclipse.e4.core.contexts.IEclipseContext;

/**
 * Service with provides useful functionality for interacting with extensions.
 *
 */
public interface ExtensionService extends ExtensionRegistryService {
	/**
	 * Creates a context which contains the base set of services passed to all extensions. 
	 * Note: The context should be disposed when it is no longer needed.
	 * @return
	 */
	IEclipseContext createChildContext();
}
