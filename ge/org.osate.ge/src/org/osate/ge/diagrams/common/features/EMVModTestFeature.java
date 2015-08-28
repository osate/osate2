package org.osate.ge.diagrams.common.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.DirectionType;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

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
		final PictogramElement pe = (PictogramElement)context.getPictogramElements()[0];
		// TODO: Test without xtext document open
		//final DefaultAnnexLibrary defaultLib = (DefaultAnnexLibrary)bor.getBusinessObjectForPictogramElement(pe);
		//final ErrorModelLibrary errorModelLibrary = (ErrorModelLibrary)defaultLib.getParsedAnnexLibrary();
		
		// Test 1 - Creating new type
		/*
		aadlModService.modify(errorModelLibrary, new AbstractModifier<ErrorModelLibrary, Object>() {
			@Override
			public Object modify(final Resource resource, final ErrorModelLibrary errorModelLibrary) {				
				final ErrorType newErrorType = (ErrorType)EcoreUtil.create(ErrorModelPackage.eINSTANCE.getErrorType());
				newErrorType.setName("TESTING");
				errorModelLibrary.getTypes().add(newErrorType);

				return null;
			}
		});
*/		

		// Test 2 - Edit existing type
		/*
		final ErrorType errorType = errorModelLibrary.getTypes().get(2);
		System.err.println("EDITING ERROR TYPE: " + errorType);
		aadlModService.modify(errorType, new AbstractModifier<ErrorType, Object>() {
			@Override
			public Object modify(final Resource resource, final ErrorType errorType) {
				System.err.println("MODIFIER: " + errorType);
				errorType.setName("MODIFIED_" + errorType.getName());

				return null;
			}
		});
		*/
	
		
		// TODO: Need to test subclauses
		
		final DefaultAnnexSubclause defaultSubclause = (DefaultAnnexSubclause)bor.getBusinessObjectForPictogramElement(pe);
		final ErrorModelSubclause errorModelSubclause = (ErrorModelSubclause)defaultSubclause.getParsedAnnexSubclause();
		
		// Test 3 - Create a new error propagation using the first feature in the current component type
		// Also uses the first error propagation to make it easier to create some of the pieces of the model.
		aadlModService.modify(errorModelSubclause, new AbstractModifier<ErrorModelSubclause, Object>() {
			@Override
			public Object modify(final Resource resource, final ErrorModelSubclause errorModelSubclause) {
				final ErrorPropagation newPropagation = (ErrorPropagation)EcoreUtil.create(ErrorModelPackage.eINSTANCE.getErrorPropagation());
				newPropagation.setDirection(DirectionType.IN);
				final FeatureorPPReference featureRef = (FeatureorPPReference)EcoreUtil.create(ErrorModelPackage.eINSTANCE.getFeatureorPPReference());
				featureRef.setFeatureorPP(((ComponentType)defaultSubclause.getContainingClassifier()).getOwnedFeatures().get(0));
				newPropagation.setFeatureorPPRef(featureRef);
				
				final TypeSet typeSet = (TypeSet)EcoreUtil.create(ErrorModelPackage.eINSTANCE.getTypeSet());
				typeSet.getTypeTokens().add(EcoreUtil.copy(errorModelSubclause.getPropagations().get(0).getTypeSet().getTypeTokens().get(0)));
				newPropagation.setTypeSet(typeSet);
				
				errorModelSubclause.getPropagations().add(newPropagation);
			
				return null;
			}
		});
		
	}

}
