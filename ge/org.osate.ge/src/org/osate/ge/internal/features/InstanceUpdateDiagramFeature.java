/*
Copyright (c) 2015, Rockwell Collins.
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
package org.osate.ge.internal.features;

import java.util.Collections;
import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.util.Log;

public class InstanceUpdateDiagramFeature extends AbstractUpdateFeature implements DiagramUpdateFeature {
	private final BusinessObjectResolutionService bor;
	private final StyleService styleService;
	private final GhostingService ghostingService;
	private final ShapeCreationService shapeCreationService;
	private final DiagramService diagramService;
	
	@Inject
	public InstanceUpdateDiagramFeature(final BusinessObjectResolutionService bor, final StyleService styleService, final GhostingService ghostingService, 
			final ShapeCreationService shapeCreationService, final DiagramService diagramService, final IFeatureProvider fp) {
		super(fp);
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.styleService = Objects.requireNonNull(styleService, "styleService must not be null");
		this.ghostingService = Objects.requireNonNull(ghostingService, "ghostingService must not be null");
		this.shapeCreationService = Objects.requireNonNull(shapeCreationService, "shapeCreationService must not be null");
		this.diagramService = Objects.requireNonNull(diagramService, "diagramService must not be null");
	}

	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		return context.getPictogramElement() instanceof Diagram && bor.getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof SystemInstance;
	}

	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		return Reason.createTrueReason("");
	}

	@Override
	public boolean update(final IUpdateContext context) {
		Log.info("called with context: " + context);

		final SystemInstance si = (SystemInstance)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(si == null) {
			final Status status = new Status(IStatus.ERROR, Activator.getPluginId(), "Unable to update diagram. Unable to find system instance associated with diagram.", null);
			StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
			return false;
		}
		
		// Update the diagram's name
		final Diagram diagram = getDiagram();
		final String newName = diagramService.getDiagramNameByBusinessObject(si);
		if(newName != null) {
			diagram.setName(newName);
		}
		
		styleService.refreshStyles();
				
		// Remove shapes that are invalid
		ghostingService.ghostChildShapes(diagram);

		// Add/Update the shape for the classifier
		shapeCreationService.createUpdateShapes(diagram, Collections.singletonList(si), 50, false, 0, 20, false, 0);

		// Adjust positions of shapes that have not been positioned.
		final ICustomContext layoutCtx = LayoutDiagramFeature.createContext(false);
		for(ICustomFeature feature : this.getFeatureProvider().getCustomFeatures(layoutCtx)) {
			if(feature instanceof LayoutDiagramFeature) {
				feature.execute(layoutCtx);
				break;
			}
		}
		
		return true;
	}

}
