package edu.uah.rsesc.aadl.age.features;

import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateDomainObjectFeature extends AbstractCreateFeature implements
		ICreateFeature {

	public CreateDomainObjectFeature(IFeatureProvider fp) {
		super(fp, "DomainObject", "Creates a new DomainObject");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		// TODO: create the domain object here
		Object newDomainObject = null;
		
		// TODO: in case of an EMF object add the new object to a suitable resource
		// getDiagram().eResource().getContents().add(newDomainObject);

		addGraphicalRepresentation(context, newDomainObject);
		return new Object[] { newDomainObject };
	}
}
