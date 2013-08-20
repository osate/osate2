package edu.uah.rsesc.aadl.age.diagrams.componentImplementation;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AgeFeatureProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.FeaturePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.FlowSpecificationPattern;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.ModePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.ModeTransitionPattern;
import edu.uah.rsesc.aadl.age.diagrams.componentImplementation.features.ComponentImplementationUpdateDiagramFeature;
import edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns.ComponentImplementationPattern;
import edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns.ConnectionPattern;
import edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns.SubcomponentPattern;


public class ComponentImplementationFeatureProvider extends AgeFeatureProvider {
	public ComponentImplementationFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		this.addPattern(new ComponentImplementationPattern());
		this.addPattern(new SubcomponentPattern());
		this.addPattern(new FeaturePattern());
		this.addConnectionPattern(new ConnectionPattern());
		this.addConnectionPattern(new FlowSpecificationPattern());
		this.addPattern(new ModePattern());
		this.addConnectionPattern(new ModeTransitionPattern());
	}

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	   PictogramElement pictogramElement = context.getPictogramElement();
	   if(pictogramElement instanceof Diagram) {
		   return new ComponentImplementationUpdateDiagramFeature(this);
	   }
	   return super.getUpdateFeature(context);
	}
}
