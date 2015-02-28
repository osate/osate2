package org.osate.ge.services;

import java.util.List;

import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.SubprogramCallSequence;

/** 
 * Contains helper methods for working with component implementations and related interfaces.
 * @author philip.alldredge
 *
 */
public interface ComponentImplementationService {
	public List<InternalFeature> getAllInternalFeatures(final ComponentImplementation ci);	
	public List<ProcessorFeature> getAllProcessorFeatures(final ComponentImplementation ci);
	public List<SubprogramCallSequence> getAllSubprogramCallSequences(final BehavioredImplementation bi);
}
