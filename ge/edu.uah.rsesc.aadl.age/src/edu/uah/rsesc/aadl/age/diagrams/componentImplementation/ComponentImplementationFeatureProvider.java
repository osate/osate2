package edu.uah.rsesc.aadl.age.diagrams.componentImplementation;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AgeFeatureProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.FlowSpecificationPattern;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.ModePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.ModeTransitionPattern;
import edu.uah.rsesc.aadl.age.diagrams.componentImplementation.features.ComponentImplementationUpdateDiagramFeature;
import edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns.ComponentImplementationPattern;
import edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns.ConnectionPattern;
import edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns.SubcomponentPattern;

public class ComponentImplementationFeatureProvider extends AgeFeatureProvider {
	public ComponentImplementationFeatureProvider(final IDiagramTypeProvider dtp) {
		super(dtp);
		this.addPattern(make(ComponentImplementationPattern.class));
		this.addPattern(make(SubcomponentPattern.class));
		this.addConnectionPattern(make(ConnectionPattern.class));
		this.addConnectionPattern(make(FlowSpecificationPattern.class));
		this.addPattern(make(ModePattern.class));
		this.addConnectionPattern(make(ModeTransitionPattern.class));
		this.addAadlFeaturePatterns();
	}

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	   PictogramElement pictogramElement = context.getPictogramElement();
	   if(pictogramElement instanceof Diagram) {
		   return make(ComponentImplementationUpdateDiagramFeature.class);
	   }
	   return super.getUpdateFeature(context);
	}
}
