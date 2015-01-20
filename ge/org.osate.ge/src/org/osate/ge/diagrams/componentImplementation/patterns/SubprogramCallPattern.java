package org.osate.ge.diagrams.componentImplementation.patterns;

import javax.inject.Inject;

import org.eclipse.graphiti.features.context.ICreateContext;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.diagrams.common.AgeImageProvider;
import org.osate.ge.diagrams.common.Categorized;
import org.osate.ge.diagrams.common.patterns.AgePattern;
import org.osate.ge.services.BusinessObjectResolutionService;

public class SubprogramCallPattern extends AgePattern implements Categorized {
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public SubprogramCallPattern(final BusinessObjectResolutionService bor) {
		this.bor = bor;		
	}
	
	@Override
	public Category getCategory() {
		return Category.SUBPROGRAM_CALLS;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		final Object bo = AadlElementWrapper.unwrap(mainBusinessObject);
		return bo instanceof SubprogramCallSequence;
	}
	
	// Create
	@Override
	public boolean isPaletteApplicable() {
		return bor.getBusinessObjectForPictogramElement(getDiagram()) instanceof BehavioredImplementation;
	}
	
	@Override
	public String getCreateName() {
		return "Subprogram Call";
	}
		
	@Override
	public String getCreateImageId(){
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		return AgeImageProvider.getImage(p.getSubprogramCall());
	}
	
	@Override
	public boolean canCreate(final ICreateContext context) {
		/*
		if(subcomponentType == null) {
			return false;
		}
		
		final Object containerBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
		return !(context.getTargetContainer() instanceof Diagram) && (containerBo instanceof ComponentImplementation ? ClassifierPattern.canContainSubcomponentType((ComponentImplementation)containerBo, subcomponentType) : false);
		*/
		
		return false;
	}
	
	@Override
	public Object[] create(final ICreateContext context) {
		// TODO
		return EMPTY;
	}
}
