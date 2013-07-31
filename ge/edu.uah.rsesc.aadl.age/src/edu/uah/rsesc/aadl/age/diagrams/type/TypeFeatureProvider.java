package edu.uah.rsesc.aadl.age.diagrams.type;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import edu.uah.rsesc.aadl.age.diagrams.common.AgeFeatureProvider;
import edu.uah.rsesc.aadl.age.diagrams.type.features.TypeUpdateDiagramFeature;
import edu.uah.rsesc.aadl.age.diagrams.type.patterns.TypeFeaturePattern;
import edu.uah.rsesc.aadl.age.diagrams.type.patterns.TypeFlowSpecificationConnectionPattern;

public class TypeFeatureProvider extends AgeFeatureProvider {
	public TypeFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		this.addPattern(new TypeFeaturePattern());
		this.addConnectionPattern(new TypeFlowSpecificationConnectionPattern());
	}

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	   PictogramElement pictogramElement = context.getPictogramElement();
	   if(pictogramElement instanceof Diagram) {
		   return new TypeUpdateDiagramFeature(this);
	   }
	   return super.getUpdateFeature(context);
	}
}
