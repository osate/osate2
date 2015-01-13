package org.osate.ge.diagrams.common.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;

public class SwitchDirectionOfConnectionFeature extends AbstractCustomFeature {
	private final BusinessObjectResolutionService bor;
	private final AadlModificationService aadlModService;
		
	@Inject
	public SwitchDirectionOfConnectionFeature(final IFeatureProvider fp, final BusinessObjectResolutionService bor, 
			AadlModificationService aadlModService) {
		super(fp);
		this.bor = bor;
		this.aadlModService = aadlModService;
	}

	@Override
	public String getName() {
		return "Switch Direction";
	}
		
	@Override
	public String getDescription() {
		return "Swap the ends of the selected connection.";
	}

	@Override
	public boolean canExecute(final ICustomContext context) {
		return true;
	}

	@Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();
		if (pes.length == 1) {
			final PictogramElement pe = pes[0];
			final Element feature = (Element) bor.getBusinessObjectForPictogramElement(pe);
			if (feature instanceof org.osate.aadl2.Connection) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement[] pes = context.getPictogramElements();
		final PictogramElement pe = pes[0];
		final NamedElement feature = (NamedElement)bor.getBusinessObjectForPictogramElement(pe);
		// Make modifications			
		aadlModService.modify(feature, new AbstractModifier<NamedElement, Object>() {
			@Override
			public Object modify(final Resource resource, final NamedElement feature) {
				org.osate.aadl2.Connection connection = (Connection) feature;
				final ConnectedElement ceSource = connection.getSource();
				connection.setSource(connection.getDestination());
				connection.setDestination(ceSource);	
				return null;
			}
		});
	}
}


