/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.internal.services.ComponentImplementationService;

public class DefaultComponentImplementationService implements ComponentImplementationService {
	public List<InternalFeature> getAllInternalFeatures(final ComponentImplementation ci) {
		EList<InternalFeature> returnList = new BasicEList<InternalFeature>();
		ComponentImplementation tmpCi = ci;
		while(tmpCi != null) {
			returnList.addAll(tmpCi.getOwnedInternalFeatures());
			tmpCi = tmpCi.getExtended();
		}

		return returnList;
	}
	
	public List<ProcessorFeature> getAllProcessorFeatures(final ComponentImplementation ci) {
		EList<ProcessorFeature> returnList = new BasicEList<ProcessorFeature>();
		ComponentImplementation tmpCi = ci;
		while(tmpCi != null) {
			returnList.addAll(tmpCi.getOwnedProcessorFeatures());
			tmpCi = tmpCi.getExtended();
		}
		
		return returnList;
	}

	public List<SubprogramCallSequence> getAllSubprogramCallSequences(final BehavioredImplementation bi) {
		EList<SubprogramCallSequence> returnList = new BasicEList<SubprogramCallSequence>();
		ComponentImplementation tmpCi = bi;
		while(tmpCi != null) {
			if(tmpCi instanceof BehavioredImplementation) {
				final BehavioredImplementation tmpBi = (BehavioredImplementation)tmpCi;
				returnList.addAll(tmpBi.getOwnedSubprogramCallSequences());
			}
			tmpCi = tmpCi.getExtended();
		}
		
		return returnList;
	}
}
