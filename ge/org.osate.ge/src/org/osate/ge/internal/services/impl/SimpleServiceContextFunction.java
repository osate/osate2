/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;

/**
 *  ContextFunction for use with global services. Delegates creation of the service to the child class.
 */
public abstract class SimpleServiceContextFunction<ServiceInterface> extends ContextFunction {
	private ServiceInterface service = null;
	
	public Object compute(IEclipseContext context, String contextKey) {
		if(service == null) {
			service = createService(context);
			context.set(contextKey, service);
		}
		
		return service;
	}
	
	protected abstract ServiceInterface createService(final IEclipseContext context);
	
	protected ServiceInterface getService() { return service; }
	
	protected void deactivate() {
		this.service = null;
	}
}
