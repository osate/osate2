package edu.uah.rsesc.aadl.age.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;

import edu.uah.rsesc.aadl.age.features.PackageAddClassifierFeature;
import edu.uah.rsesc.aadl.age.features.PackageAddGeneralizationFeature;
import edu.uah.rsesc.aadl.age.features.PackageUpdateClassifierFeature;
import edu.uah.rsesc.aadl.age.features.PackageUpdateDiagramFeature;
import edu.uah.rsesc.aadl.age.features.stub.AddDomainObjectConnectionConnectionFeature;
import edu.uah.rsesc.aadl.age.features.stub.AddDomainObjectFeature;
import edu.uah.rsesc.aadl.age.features.stub.CreateDomainObjectConnectionConnectionFeature;
import edu.uah.rsesc.aadl.age.features.stub.CreateDomainObjectFeature;
import edu.uah.rsesc.aadl.age.features.stub.LayoutDomainObjectFeature;

public class PackageFeatureProvider extends DefaultFeatureProvider {
	public PackageFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);		
		//this.setIndependenceSolver(new IndependenceProvider());
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] {};//new CreateDomainObjectFeature(this)};
	}
	
	@Override 
	public IRemoveFeature getRemoveFeature(final IRemoveContext context) {
		return null;
	}
	
	@Override 
	public IDeleteFeature getDeleteFeature(final IDeleteContext context) {
		return null;
	}
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] {};//new CreateDomainObjectConnectionConnectionFeature(this)};
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		if (context instanceof IAddConnectionContext && 
				(context.getNewObject() instanceof Realization || 
						context.getNewObject() instanceof TypeExtension || 
						context.getNewObject() instanceof ImplementationExtension || 
						context.getNewObject() instanceof GroupExtension)) {
			return new PackageAddGeneralizationFeature(this);
		} else if (context instanceof IAddContext) {
			if(context.getNewObject() instanceof Classifier) {
				return new PackageAddClassifierFeature(this);
			}
		}

		return super.getAddFeature(context);
	}
	
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		// TODO: check for right domain object instances below
		if (context.getPictogramElement() instanceof ContainerShape /* && getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof <DomainObject> */) {
			return  new LayoutDomainObjectFeature(this);
		}
	
		return super.getLayoutFeature(context);
	}
	
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	   PictogramElement pictogramElement = context.getPictogramElement();
	   if(pictogramElement instanceof Diagram) {
		   return new PackageUpdateDiagramFeature(this);
	   } else if(getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof Classifier) {
		   return new PackageUpdateClassifierFeature(this);
	   }
	   
	   return super.getUpdateFeature(context);
	 }
}
