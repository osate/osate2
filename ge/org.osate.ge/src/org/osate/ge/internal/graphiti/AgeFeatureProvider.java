/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
// Based on OSATE Graphical Editor. Modifications are:
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data,
including any software or models in source or binary form, as well as any drawings, specifications,
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
 */
/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.graphiti;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddBendpointFeature;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveBendpointFeature;
import org.eclipse.graphiti.features.IMoveConnectionDecoratorFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IRemoveBendpointFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddBendpointContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveBendpointContext;
import org.eclipse.graphiti.features.context.IMoveConnectionDecoratorContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveBendpointContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.osate.ge.PaletteEntry;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.Names;
import org.osate.ge.internal.SimplePaletteEntry;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.AgeDiagramUtil;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.boTree.DefaultBusinessObjectNodeFactory;
import org.osate.ge.internal.diagram.runtime.boTree.DefaultTreeUpdater;
import org.osate.ge.internal.diagram.runtime.boTree.TreeUpdater;
import org.osate.ge.internal.diagram.runtime.updating.DefaultDiagramElementGraphicalConfigurationProvider;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.diagram.NodePictogramBiMap;
import org.osate.ge.internal.graphiti.features.AgeAddBendpointFeature;
import org.osate.ge.internal.graphiti.features.AgeMoveBendpointFeature;
import org.osate.ge.internal.graphiti.features.AgeMoveConnectionDecoratorFeature;
import org.osate.ge.internal.graphiti.features.AgeMoveShapeFeature;
import org.osate.ge.internal.graphiti.features.AgeRemoveBendpointFeature;
import org.osate.ge.internal.graphiti.features.AgeResizeShapeFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerCreateConnectionFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerCreateFeature;
import org.osate.ge.internal.graphiti.features.BoHandlerDirectEditFeature;
import org.osate.ge.internal.graphiti.features.UpdateDiagramFeature;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.SystemInstanceLoadingService;
import org.osate.ge.services.QueryService;

public class AgeFeatureProvider extends DefaultFeatureProvider {
	private IEclipseContext eclipseContext;
	private ReferenceService referenceService;
	private ExtensionService extService;
	private AadlModificationService aadlModService;
	private GraphitiService graphitiService;
	private ProjectReferenceService referenceResolver;
	private BoHandlerDirectEditFeature defaultDirectEditFeature;
	private AgeMoveShapeFeature defaultMoveShapeFeature;
	private AgeResizeShapeFeature defaultResizeShapeFeature;
	private AgeMoveConnectionDecoratorFeature defaultMoveConnectionDecoratorFeature;
	private IMoveBendpointFeature moveBendpointFeature;
	private IAddBendpointFeature addBendpointFeature;
	private IRemoveBendpointFeature removeBendpointFeature;
	private UpdateDiagramFeature updateDiagramFeature;
	private DiagramUpdater diagramUpdater;
	private DefaultDiagramElementGraphicalConfigurationProvider deInfoProvider;
	private TreeUpdater boTreeExpander;

	public AgeFeatureProvider(final IDiagramTypeProvider dtp) {
		super(dtp);
	}

	public void initialize(final IEclipseContext context) {
		this.eclipseContext = context.createChild();
		this.eclipseContext.set(IFeatureProvider.class, this);
		this.referenceService = Objects.requireNonNull(eclipseContext.get(ReferenceService.class),
				"unable to retrieve reference service service");
		this.extService = Objects.requireNonNull(eclipseContext.get(ExtensionService.class), "unable to retrieve extension service");
		this.aadlModService = Objects.requireNonNull(eclipseContext.get(AadlModificationService.class), "unable to retrieve AADL modification service");
		this.graphitiService = Objects.requireNonNull(eclipseContext.get(GraphitiService.class), "unablet to retrieve Graphiti service");
		this.referenceResolver = Objects.requireNonNull(eclipseContext.get(ProjectReferenceService.class), "unable to retrieve internal reference resolution service");

		// Create the feature to use for pictograms which do not have a specialized feature. Delegates to business object handlers.
		defaultDirectEditFeature = make(BoHandlerDirectEditFeature.class);
		defaultMoveShapeFeature = make(AgeMoveShapeFeature.class);
		defaultResizeShapeFeature = make(AgeResizeShapeFeature.class);
		defaultMoveConnectionDecoratorFeature = make(AgeMoveConnectionDecoratorFeature.class);
		moveBendpointFeature = make(AgeMoveBendpointFeature.class);
		addBendpointFeature = make(AgeAddBendpointFeature.class);
		removeBendpointFeature = make(AgeRemoveBendpointFeature.class);

		// Create the refresh diagram feature
		final DefaultBusinessObjectNodeFactory nodeFactory = new DefaultBusinessObjectNodeFactory(referenceResolver);
		final QueryService queryService = Objects.requireNonNull(eclipseContext.get(QueryService.class), "unable to retrieve query service");
		final ActionService actionService = Objects.requireNonNull(eclipseContext.get(ActionService.class),
				"unable to retrieve action service");
		boTreeExpander = new DefaultTreeUpdater(graphitiService, extService, referenceResolver,
				queryService, nodeFactory);
		deInfoProvider = new DefaultDiagramElementGraphicalConfigurationProvider(referenceResolver, extService);
		diagramUpdater = new DiagramUpdater(boTreeExpander, deInfoProvider, actionService);
		final SystemInstanceLoadingService systemInstanceLoader = Objects.requireNonNull(
				eclipseContext.get(SystemInstanceLoadingService.class),
				"unable to retrieve system instance loading service");
		this.updateDiagramFeature = new UpdateDiagramFeature(this, actionService, graphitiService, diagramUpdater,
				graphitiService,
				referenceResolver, systemInstanceLoader);
	}

	@Override
	public void dispose() {
		if(deInfoProvider != null) {
			deInfoProvider.close();
		}

		if(eclipseContext != null) {
			eclipseContext.dispose();
		}

		super.dispose();
	}

	public DiagramUpdater getDiagramUpdater() {
		return diagramUpdater;
	}

	public TreeUpdater getBoTreeUpdater() {
		return boTreeExpander;
	}

	/**
	 * Instantiates an object and injects the current context into it
	 * @param clazz
	 * @return
	 */
	protected final <T> T make(final Class<T> clazz) {
		return ContextInjectionFactory.make(clazz, eclipseContext);
	}

	// Referencing
	@Override
	public Object[] getAllBusinessObjectsForPictogramElement(final PictogramElement pictogramElement) {
		// A maximum of one business object per pictogram element is supported
		final Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		return bo == null ? new Object[0] : new Object[] { bo };
	}

	@Override
	public Object getBusinessObjectForPictogramElement(final PictogramElement pictogramElement) {
		if(pictogramElement == null) {
			return null;
		}

		final DiagramNode dn = graphitiService.getGraphitiAgeDiagram().getClosestDiagramNode(pictogramElement);
		return dn == null ? null : dn.getBusinessObject();
	}

	@Override
	public PictogramElement[] getAllPictogramElementsForBusinessObject(final Object businessObject) {
		final AgeDiagram ageDiagram = graphitiService.getGraphitiAgeDiagram().getAgeDiagram();
		final List<PictogramElement> pes = new ArrayList<>();
		final CanonicalBusinessObjectReference searchRef = referenceService.getCanonicalReference(businessObject);
		if(searchRef != null) {
			getPictogramElements(searchRef, ageDiagram, graphitiService.getGraphitiAgeDiagram(), pes, Integer.MAX_VALUE);
		}
		return pes.toArray(new PictogramElement[pes.size()]);
	}

	@Override
	public PictogramElement getPictogramElementForBusinessObject(final Object businessObject) {
		final AgeDiagram ageDiagram = graphitiService.getGraphitiAgeDiagram().getAgeDiagram();
		final List<PictogramElement> pes = new ArrayList<>();
		final CanonicalBusinessObjectReference searchRef = referenceService.getCanonicalReference(businessObject);
		if(searchRef != null) {
			getPictogramElements(searchRef, ageDiagram, graphitiService.getGraphitiAgeDiagram(), pes, 1);
		}

		return pes.size() > 0 ? pes.get(0) : null;
	}

	/**
	 * Searches the child of a specified diagram node for elements with a matching canonical business object reference.
	 * Returns the associated pictogram elmeents. Returns up to limit entries.
	 * @return whether the limit has been reached
	 */
	private boolean getPictogramElements(final CanonicalBusinessObjectReference searchRef,
			final DiagramNode dn,
			final NodePictogramBiMap mapping,
			final List<PictogramElement> results,
			final int limit) {
		for(final DiagramElement child : dn.getDiagramElements()) {
			if(searchRef.equals(referenceService.getCanonicalReference(child.getBusinessObject()))) {
				final PictogramElement pe = mapping.getPictogramElement(child);
				if(pe != null) {
					results.add(pe);
					if(results.size() >= limit) {
						return true;
					}
				}
			}

			if(getPictogramElements(searchRef, child, mapping, results, limit)) {
				return true;
			}
		}

		return false;
	}

	// link() is not supported because linkages are only changed when elements in the AgeDiagram is changed.
	@Override
	public void link(final PictogramElement pictogramElement, final Object[] businessObjects) {
		throw new RuntimeException("Not supported");
	}

	// Don't allow removing, just deleting.
	@Override
	public IRemoveFeature getRemoveFeature(final IRemoveContext context) {
		return null;
	}

	@Override
	public IDeleteFeature getDeleteFeature(final IDeleteContext context) {
		return null;
	}

	// Don't allow reconnection
	@Override
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		return null;
	}

	@Override
	public IDirectEditingFeature getDirectEditingFeature(final IDirectEditingContext context) {
		return defaultDirectEditFeature;
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		final List<ICreateFeature> features = new ArrayList<>();
		final IEclipseContext childCtx = createGetPaletteEntriesContext();
		try {
			for(final Object boHandler : extService.getBusinessObjectHandlers()) {
				final PaletteEntry[] extPaletteEntries = (PaletteEntry[])ContextInjectionFactory.invoke(boHandler, GetPaletteEntries.class, childCtx, null);
				if(extPaletteEntries != null) {
					for(final PaletteEntry entry : extPaletteEntries) {
						final SimplePaletteEntry simpleEntry = (SimplePaletteEntry)entry;
						if(simpleEntry .getType() == SimplePaletteEntry.Type.CREATE) {
							features.add(new BoHandlerCreateFeature(graphitiService, extService,
									aadlModService, diagramUpdater, referenceResolver, this, simpleEntry, boHandler));
						}
					}
				}
			}
		} finally {
			childCtx.dispose();
		}

		return features.toArray(new ICreateFeature[0]);
	}

	@Override
	public IAddFeature getAddFeature(final IAddContext addCtx) {
		return null;
	}

	@Override
	public IUpdateFeature getUpdateFeature(final IUpdateContext updateCtx) {
		if(updateCtx.getPictogramElement() instanceof Diagram) {
			return updateDiagramFeature;
		}

		return null;
	}

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		final List<ICreateConnectionFeature> retList = new ArrayList<ICreateConnectionFeature>();
		// Add extension create connection features
		final IEclipseContext childCtx = createGetPaletteEntriesContext();
		try {
			for(final Object boHandler : extService.getBusinessObjectHandlers()) {
				final PaletteEntry[] extPaletteEntries = (PaletteEntry[])ContextInjectionFactory.invoke(boHandler, GetPaletteEntries.class, childCtx, null);
				if(extPaletteEntries != null) {
					for(final PaletteEntry entry : extPaletteEntries) {
						final SimplePaletteEntry simpleEntry = (SimplePaletteEntry)entry;
						if(simpleEntry.getType() == SimplePaletteEntry.Type.CREATE_CONNECTION) {
							retList.add(new BoHandlerCreateConnectionFeature(graphitiService, graphitiService,
									extService, aadlModService, diagramUpdater, referenceResolver, this, simpleEntry,
									boHandler));
						}
					}
				}
			}
		} finally {
			childCtx.dispose();
		}

		return retList.toArray(new ICreateConnectionFeature[0]);
	}

	@Override
	public IMoveBendpointFeature getMoveBendpointFeature(final IMoveBendpointContext context) {
		return moveBendpointFeature;
	}

	@Override
	public IAddBendpointFeature getAddBendpointFeature(final IAddBendpointContext context) {
		return addBendpointFeature;
	}

	@Override
	public IRemoveBendpointFeature getRemoveBendpointFeature(final IRemoveBendpointContext context) {
		return removeBendpointFeature;
	}

	private IEclipseContext createGetPaletteEntriesContext() {
		final IEclipseContext childCtx = extService.createChildContext();
		childCtx.set(Names.DIAGRAM_BO, AgeDiagramUtil.getConfigurationContextBusinessObject(graphitiService.getGraphitiAgeDiagram().getAgeDiagram(), referenceResolver));
		return childCtx;
	}

	@Override
	public IMoveConnectionDecoratorFeature getMoveConnectionDecoratorFeature(final IMoveConnectionDecoratorContext context) {
		return defaultMoveConnectionDecoratorFeature;
	}

	@Override
	public IMoveShapeFeature getMoveShapeFeature(final IMoveShapeContext context) {
		return defaultMoveShapeFeature;
	}

	@Override
	public IResizeShapeFeature getResizeShapeFeature(final IResizeShapeContext context) {
		return defaultResizeShapeFeature;
	}

	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		// Layout is handled automatically
		return null;
	}
}

