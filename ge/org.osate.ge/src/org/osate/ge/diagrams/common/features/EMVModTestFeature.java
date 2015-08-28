package org.osate.ge.diagrams.common.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

// TODO: Remove this after testing
public class EMVModTestFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public EMVModTestFeature(final AadlModificationService aadlModService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.aadlModService = aadlModService;
		this.bor = bor;
	}
	
	@Override
	public String getName() {
		return "Test Annex Mod";
	}

	public boolean canExecute(ICustomContext context) {
		return true;
	}
	
	@Override
	public void execute(ICustomContext context) {
		// 
		
		final PictogramElement pe = (PictogramElement)context.getPictogramElements()[0];
		final DefaultAnnexLibrary defaultLib = (DefaultAnnexLibrary)bor.getBusinessObjectForPictogramElement(pe);
		
		aadlModService.modify(defaultLib.getParsedAnnexLibrary(), new AbstractModifier<AnnexLibrary, Object>() {
			@Override
			public Object modify(final Resource resource, final AnnexLibrary lib) {
				System.err.println(lib);
				final ErrorModelLibrary errorModelLibrary = (ErrorModelLibrary)lib;
				
				System.err.println("A");
				final ErrorType newErrorType = (ErrorType)EcoreUtil.create(ErrorModelPackage.eINSTANCE.getErrorType());
				newErrorType.setName("TESTING");
				errorModelLibrary.getTypes().add(newErrorType);

				return null;
			}
		});
	}

}
