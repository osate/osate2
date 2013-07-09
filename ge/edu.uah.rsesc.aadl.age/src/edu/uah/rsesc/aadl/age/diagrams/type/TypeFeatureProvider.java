package edu.uah.rsesc.aadl.age.diagrams.type;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

import edu.uah.rsesc.aadl.age.diagrams.common.AgeFeatureProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.features.stub.AddDomainObjectConnectionConnectionFeature;
import edu.uah.rsesc.aadl.age.diagrams.common.features.stub.AddDomainObjectFeature;
import edu.uah.rsesc.aadl.age.diagrams.common.features.stub.CreateDomainObjectConnectionConnectionFeature;
import edu.uah.rsesc.aadl.age.diagrams.common.features.stub.CreateDomainObjectFeature;
import edu.uah.rsesc.aadl.age.diagrams.common.features.stub.LayoutDomainObjectFeature;


public class TypeFeatureProvider extends AgeFeatureProvider {
	public TypeFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] {new CreateDomainObjectFeature(this)};
	}
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] {new CreateDomainObjectConnectionConnectionFeature(this)};
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		if (context instanceof IAddConnectionContext /* && context.getNewObject() instanceof <DomainObject> */) {
			return new AddDomainObjectConnectionConnectionFeature(this);
		} else if (context instanceof IAddContext /* && context.getNewObject() instanceof <DomainObject> */) {
			return new AddDomainObjectFeature(this);
		}

		return super.getAddFeature(context);
	}
	
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		if (context.getPictogramElement() instanceof ContainerShape) {
			return  new LayoutDomainObjectFeature(this);
		}
		
		return super.getLayoutFeature(context);
	}
}
