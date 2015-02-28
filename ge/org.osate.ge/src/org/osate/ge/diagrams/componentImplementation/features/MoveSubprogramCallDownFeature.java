package org.osate.ge.diagrams.componentImplementation.features;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ShapeService;

/**
 * Custom feature for moving a subprogram call down. It swaps the subprogram call's position in the subprogram call sequence with the next subprogram call.
 * @author philip.alldredge
 *
 */
public class MoveSubprogramCallDownFeature extends ReorderSubprogramCallFeature {
	@Inject
	public MoveSubprogramCallDownFeature(final AadlModificationService aadlModService, final ShapeService shapeService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(aadlModService, shapeService, bor, fp);
	}

	@Override
    public String getName() {
        return "Move Down";
    }	
    
    protected int getNewIndex(final SubprogramCall call) {
    	final SubprogramCallSequence cs = (SubprogramCallSequence)call.eContainer();
    	final int currentIndex = cs.getOwnedSubprogramCalls().indexOf(call);
    	return currentIndex == -1 ? -1 : currentIndex + 1;
    }
}
