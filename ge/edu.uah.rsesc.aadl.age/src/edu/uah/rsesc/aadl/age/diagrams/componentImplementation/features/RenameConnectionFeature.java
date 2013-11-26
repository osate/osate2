package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.osate.aadl2.NamedElement;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.DiagramModificationService;
import edu.uah.rsesc.aadl.age.services.NamingService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;

public class RenameConnectionFeature extends AbstractDirectEditingFeature {
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final NamingService namingService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public RenameConnectionFeature(final IFeatureProvider fp, AadlModificationService aadlModService, final DiagramModificationService diagramModService, 
			final NamingService namingService, final BusinessObjectResolutionService bor) {
		super(fp);
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.namingService = namingService;
		this.bor = bor;
	}

	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}
	
	@Override
	public boolean stretchFieldToFitText() {
		return true;
	}

    @Override
    public String checkValueValid(final String value, final IDirectEditingContext context) {
    	return namingService.checkNameValidity((NamedElement)bor.getBusinessObjectForPictogramElement(context.getPictogramElement()), value);
    }    
	
	@Override
	public String getInitialValue(final IDirectEditingContext context) {
		final org.osate.aadl2.Connection connection = (org.osate.aadl2.Connection)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(connection != null) {
			return connection.getName();
		}
		return "";
	}
	
	public void setValue(final String value, final IDirectEditingContext context) {
    	final org.osate.aadl2.Connection aadlConnection = (org.osate.aadl2.Connection)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());    	   	
    	aadlModService.modify(aadlConnection, new RenameConnectionModifier(value, diagramModService));  
    }
	    
    private static class RenameConnectionModifier extends AbstractModifier<org.osate.aadl2.Connection, Object> {
    	private final String newName;
		private final DiagramModificationService diagramModService;
		private DiagramModificationService.Modification diagramMod;
		
 		public RenameConnectionModifier(final String newName, final DiagramModificationService diagramModService) {
			this.newName = newName;
			this.diagramModService = diagramModService;
		}
 		
 		@Override
		public Object modify(final Resource resource, final org.osate.aadl2.Connection aadlConnection) {
 			// Resolving allows the name change to propagate when editing without an Xtext document
 			EcoreUtil.resolveAll(resource.getResourceSet());

 			// Start the diagram modification
 			diagramMod = diagramModService.startModification();
 			
 			// Mark linkages to refinements as dirty
			for(final Setting s : EcoreUtil.UsageCrossReferencer.find(aadlConnection, resource.getResourceSet())) {
				final EStructuralFeature sf = s.getEStructuralFeature();
				if(!sf.isDerived() && sf.isChangeable()) {
					final EObject obj = s.getEObject();
					if(obj instanceof org.osate.aadl2.Connection && ((org.osate.aadl2.Connection)obj).getRefined() == aadlConnection) {
						diagramMod.markLinkagesAsDirty((org.osate.aadl2.Connection)obj);
					}
				}
			}
 			
 			// Mark linkages to the subcomponent as dirty 			
 			diagramMod.markLinkagesAsDirty(aadlConnection);
 			
 			// Set the subcomponent's name
			aadlConnection.setName(newName);

			return null;
		}	

 		@Override
		public void beforeCommit(final Resource resource, final org.osate.aadl2.Connection aadlConnection, final Object modificationResult) {
			diagramMod.commit();
		}
 	}
}
