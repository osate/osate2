/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.type;

import java.util.List;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IMoveBendpointFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IMoveBendpointContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.ge.diagrams.common.AgeFeatureProvider;
import org.osate.ge.diagrams.common.patterns.FeaturePattern;
import org.osate.ge.diagrams.common.patterns.FlowSpecificationPattern;
import org.osate.ge.diagrams.common.patterns.ModePattern;
import org.osate.ge.diagrams.common.patterns.ModeTransitionPattern;
import org.osate.ge.diagrams.type.features.ChangeFeatureTypeFeature;
import org.osate.ge.diagrams.type.features.CreateSimpleFlowSpecificationFeature;
import org.osate.ge.diagrams.type.features.RefineFeatureFeature;
import org.osate.ge.diagrams.type.features.RefineFlowSpecificationFeature;
import org.osate.ge.diagrams.type.features.RenameFlowSpecificationFeature;
import org.osate.ge.diagrams.type.features.SetAccessFeatureKindFeature;
import org.osate.ge.diagrams.type.features.SetFeatureClassifierFeature;
import org.osate.ge.diagrams.type.features.SetFeatureDirectionFeature;
import org.osate.ge.diagrams.type.features.TypeUpdateDiagramFeature;
import org.osate.ge.diagrams.type.patterns.TypeClassifierPattern;
import org.osate.ge.services.BusinessObjectResolutionService;

public class TypeFeatureProvider extends AgeFeatureProvider {
	public TypeFeatureProvider(final IDiagramTypeProvider dtp) {
		super(dtp);
		this.addPattern(make(TypeClassifierPattern.class));
		this.addConnectionPattern(make(FlowSpecificationPattern.class));
		this.addPattern(make(ModePattern.class));
		this.addConnectionPattern(make(ModeTransitionPattern.class));
		this.addAadlFeaturePatterns();
	}

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	   PictogramElement pictogramElement = context.getPictogramElement();
	   if(pictogramElement instanceof Diagram) {
		   return make(TypeUpdateDiagramFeature.class);
	   }
	   return super.getUpdateFeature(context);
	}
	
	// Disable all moving of bendpoints. Context does not seem to contain reference to connection. Ideally will only disable for source and sink flow specifications
	@Override
	public IMoveBendpointFeature getMoveBendpointFeature(final IMoveBendpointContext context) {
		return null;
	}
	
	@Override
	protected void addCustomFeatures(final List<ICustomFeature> features) {
		super.addCustomFeatures(features);
		features.add(make(RefineFeatureFeature.class));
		features.add(make(RefineFlowSpecificationFeature.class));
		features.add(make(SetFeatureClassifierFeature.class));
		features.add(createSetFeatureDirectionFeature(DirectionType.IN));
		features.add(createSetFeatureDirectionFeature(DirectionType.OUT));
		features.add(createSetFeatureDirectionFeature(DirectionType.IN_OUT));		
		features.add(createSetFeatureKindFeature(AccessType.PROVIDES));
		features.add(createSetFeatureKindFeature(AccessType.REQUIRES));
		
		for(final EClass featureType : FeaturePattern.getFeatureTypes()) {
			final IEclipseContext childCtx = getContext().createChild();
			childCtx.set("Feature Type", featureType);
			features.add(ContextInjectionFactory.make(ChangeFeatureTypeFeature.class, childCtx));	
		}
		
		features.add(createCreateSimpleFlowSpecificationFeature(FlowKind.SOURCE));
		features.add(createCreateSimpleFlowSpecificationFeature(FlowKind.SINK));
	}
	
	private SetFeatureDirectionFeature createSetFeatureDirectionFeature(final DirectionType dirType) 
	{
		final IEclipseContext childCtx = getContext().createChild();
		childCtx.set("Direction", dirType);

		return ContextInjectionFactory.make(SetFeatureDirectionFeature.class, childCtx);
	}
	
	private SetAccessFeatureKindFeature createSetFeatureKindFeature(final AccessType accType) 
	{
		final IEclipseContext childCtx = getContext().createChild();
		childCtx.set("Access", accType);

		return ContextInjectionFactory.make(SetAccessFeatureKindFeature.class, childCtx);
	}
	
	private CreateSimpleFlowSpecificationFeature createCreateSimpleFlowSpecificationFeature(final FlowKind flowKind) 
	{
		final IEclipseContext childCtx = getContext().createChild();
		childCtx.set("Kind", flowKind);

		return ContextInjectionFactory.make(CreateSimpleFlowSpecificationFeature.class, childCtx);
	}
	
	@Override
	protected IDirectEditingFeature getDirectEditingFeatureAdditional(final IDirectEditingContext context) {
		final BusinessObjectResolutionService bor = getContext().get(BusinessObjectResolutionService.class);
		if(bor != null) {
			final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
			if(bo instanceof FlowSpecification) {
				return make(RenameFlowSpecificationFeature.class);
			}
		}

		return super.getDirectEditingFeatureAdditional(context);
	}
}
