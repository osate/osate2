/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.osate.ge.services.impl.DefaultPropertyService;

public class AgeDiagramTypeProvider extends AbstractDiagramTypeProvider {
	public AgeDiagramTypeProvider() {	
		setFeatureProvider(new AgeFeatureProvider(this));
	}
	
	@Override
	public boolean isAutoUpdateAtStartup() {
		return true;
	}	

	private IToolBehaviorProvider[] toolBehaviorProviders;
	
	@Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders = new IToolBehaviorProvider[] { new AgeToolBehaviorProvider(this, new DefaultPropertyService()) };
        }
        return toolBehaviorProviders;
    }
}
