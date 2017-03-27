package org.osate.ge.internal.graphiti.features;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.query.AgeDiagramElementQuery;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.RootAgeDiagramElementQuery;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.PropertyService;

public class SelectAncestorFeature extends AbstractCustomFeature {
	@Inject
	public SelectAncestorFeature(final IFeatureProvider fp)  {
		super(fp);
	}

	@Override
    public String getName() {
        return "Select Container";
    }
 
    @Override
    public String getDescription() {
        return "Selects a diagram element's container.";
    }
 
    @Override
	public boolean isAvailable(final IContext context) {
    	// Make the command available if the selection is a shape and has at least one logical parent
		final ICustomContext customCtx = (ICustomContext)context;
		PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length != 1) {
			return false;
		}
		
		//TODO: Migrate!
		//rootPictogramElement = pes[0];
		//return queryRunner.getFirstResult(query, null) != null;
		return false;
	}
   
    @Override
    public boolean canExecute(final ICustomContext context) {
		return true;
    }
    
	@Override
	public void execute(final ICustomContext context) {
		// Select the first logic parent
		final ICustomContext customCtx = (ICustomContext)context;
		PictogramElement[] pes = customCtx.getPictogramElements();		

		//TODO: Migrate!
		/*
		rootPictogramElement = pes[0];
		final PictogramElement ancestor = queryRunner.getFirstResult(query, null);
		if(ancestor != null) {
			getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[]{ancestor});			
		}
		*/
	}

}
