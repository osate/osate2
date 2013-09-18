package edu.uah.rsesc.aadl.age.diagrams.pkg;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AgeFeatureProvider;
import edu.uah.rsesc.aadl.age.diagrams.pkg.features.PackageUpdateDiagramFeature;
import edu.uah.rsesc.aadl.age.diagrams.pkg.patterns.PackageClassifierPattern;
import edu.uah.rsesc.aadl.age.diagrams.pkg.patterns.PackageGeneralizationPattern;

public class PackageFeatureProvider extends AgeFeatureProvider {
	public PackageFeatureProvider(final IDiagramTypeProvider dtp) {
		super(dtp);
		addPattern(make(PackageClassifierPattern.class));
		addConnectionPattern(make(PackageGeneralizationPattern.class));
	}

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	   PictogramElement pictogramElement = context.getPictogramElement();
	   if(pictogramElement instanceof Diagram) {
		   return make(PackageUpdateDiagramFeature.class);
	   }
	   return super.getUpdateFeature(context);
	}
	
}
