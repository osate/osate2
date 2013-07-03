package edu.uah.rsesc.aadl.age.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.osate.aadl2.Element;
import edu.uah.rsesc.aadl.age.features.LayoutDiagramFeature;
import edu.uah.rsesc.aadl.age.features.PackageUpdateDiagramFeature;
import edu.uah.rsesc.aadl.age.patterns.PackageClassifierPattern;
import edu.uah.rsesc.aadl.age.patterns.PackageGeneralizationPattern;

public class PackageFeatureProvider extends DefaultFeatureProviderWithPatterns {
	public PackageFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		addPattern(new PackageClassifierPattern());
		addConnectionPattern(new PackageGeneralizationPattern());
		setIndependenceSolver(new IndependenceProvider());
	}
	
	@Override
	public void dispose() {
		super.dispose();
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
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	   PictogramElement pictogramElement = context.getPictogramElement();
	   if(pictogramElement instanceof Diagram) {
		   return new PackageUpdateDiagramFeature(this);
	   }
	   
	   return super.getUpdateFeature(context);
	 }
	@Override
	public ICustomFeature[] getCustomFeatures(final ICustomContext context) {
		return new ICustomFeature[] { new LayoutDiagramFeature(this) };
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
