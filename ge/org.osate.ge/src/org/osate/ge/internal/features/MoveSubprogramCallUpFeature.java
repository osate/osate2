/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.features;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ShapeService;

/**
 * Custom feature for moving a subprogram call up. It swaps the subprogram call's position in the subprogram call sequence with the previous subprogram call.
 *
 */
public class MoveSubprogramCallUpFeature extends ReorderSubprogramCallFeature {
	@Inject
	public MoveSubprogramCallUpFeature(final AadlModificationService aadlModService, final ShapeService shapeService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(aadlModService, shapeService, bor, fp);
	}

	@Override
    public String getName() {
        return "Move Up";
    }
    
    protected int getNewIndex(final SubprogramCall call) {
    	final SubprogramCallSequence cs = (SubprogramCallSequence)call.eContainer();
    	final int currentIndex = cs.getOwnedSubprogramCalls().indexOf(call);
    	return currentIndex == -1 ? -1 : currentIndex - 1;
    }
}
