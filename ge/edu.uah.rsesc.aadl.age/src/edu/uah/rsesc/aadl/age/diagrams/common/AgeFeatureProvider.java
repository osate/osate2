package edu.uah.rsesc.aadl.age.diagrams.common;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.func.IUpdate;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.pattern.UpdateFeatureForPattern;
import org.osate.aadl2.Element;

import edu.uah.rsesc.aadl.age.diagrams.common.features.DrillDownFeature;
import edu.uah.rsesc.aadl.age.diagrams.common.features.LayoutDiagramFeature;

public class AgeFeatureProvider extends DefaultFeatureProviderWithPatterns {

	public AgeFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		setIndependenceSolver(new IndependenceProvider(this));
	}
	
	// TODO: Remove when deleting is allowed. Just returns false for now. As of 07/03/13, connection patterns do not handle remove and delete features.
	@Override 
	public IRemoveFeature getRemoveFeature(final IRemoveContext context) {
		return null;
	}
	
	@Override 
	public IDeleteFeature getDeleteFeature(final IDeleteContext context) {
		return null;
	}
	
	@Override
	public ICustomFeature[] getCustomFeatures(final ICustomContext context) {
		return new ICustomFeature[] { 
				new LayoutDiagramFeature(this), 
				new DrillDownFeature(this) 
				};
	}
	
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {	
		PictogramElement pictogramElement = context.getPictogramElement();
		// As of 2013-07-08 Graphiti doesn't support connection patterns handling updates so check if the pattern implements IUpdate and return a feature based on the pattern
		if(pictogramElement instanceof Connection) {
			for(final IConnectionPattern conPattern : getConnectionPatterns()) {
				if(conPattern instanceof IUpdate) {
					if(((IUpdate)conPattern).canUpdate(context)) {
						final IUpdateFeature f = new UpdateFeatureForPattern(this, (IUpdate)conPattern);
						if (checkFeatureAndContext(f, context)) {
							return f;
						}
					}
				}
			}
		}
 
		return super.getUpdateFeature(context);
	}

	// Helper methods to hide the fact that we are wrapping our AADL Elements to hide the fact they are EMF objects from Graphiti. See AadlElementWrapper
	@Override
	public PictogramElement getPictogramElementForBusinessObject(Object businessObject) {
		if(businessObject instanceof Element) {
			businessObject =  new AadlElementWrapper((Element)businessObject);
		}
		
		return super.getPictogramElementForBusinessObject(businessObject);
	}
	
	public PictogramElement[] getAllPictogramElementsForBusinessObject(Object businessObject) {
		if(businessObject instanceof Element) {
			businessObject =  new AadlElementWrapper((Element)businessObject);
		}
		
		return super.getAllPictogramElementsForBusinessObject(businessObject);
	}
}
