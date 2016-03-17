/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services;

import java.util.List;

import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.SubprogramCallSequence;

/** 
 * Contains helper methods for working with component implementations and related interfaces.
 *
 */
public interface ComponentImplementationService {
	public List<InternalFeature> getAllInternalFeatures(final ComponentImplementation ci);	
	public List<ProcessorFeature> getAllProcessorFeatures(final ComponentImplementation ci);
	public List<SubprogramCallSequence> getAllSubprogramCallSequences(final BehavioredImplementation bi);
}
