package edu.uah.rsesc.aadl.age.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.func.IUpdate;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.AddFeatureForPattern;
import org.eclipse.graphiti.pattern.CreateConnectionFeatureForPattern;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.pattern.UpdateFeatureForPattern;

import edu.uah.rsesc.aadl.age.features.PackageUpdateDiagramFeature;
import edu.uah.rsesc.aadl.age.patterns.PackageClassifierPattern;
import edu.uah.rsesc.aadl.age.patterns.PackageGeneralizationPattern;

public class PackageFeatureProvider extends AgeFeatureProvider {
	public PackageFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		addPattern(new PackageClassifierPattern());
		addConnectionPattern(new PackageGeneralizationPattern());
	}

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	   PictogramElement pictogramElement = context.getPictogramElement();
	   if(pictogramElement instanceof Diagram) {
		   return new PackageUpdateDiagramFeature(this);
	   }
	   return super.getUpdateFeature(context);
	}
}
