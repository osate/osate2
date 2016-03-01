package org.osate.ge.errormodel.pictogramHandlers;

import javax.inject.Named;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.CanHandleDoubleClick;
import org.osate.ge.ext.annotations.CanRefresh;
import org.osate.ge.ext.annotations.HandleDoubleClick;
import org.osate.ge.ext.annotations.RefreshGraphics;
import org.osate.ge.ext.annotations.RefreshShape;
import org.osate.ge.ext.services.DiagramService;
import org.osate.ge.ext.services.PictogramElementService;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;

public class ErrorTypeLibraryPictogramHandler {	
	@CanRefresh
	public boolean canRefresh(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		return true;
	}

	@RefreshShape
	public ContainerShape refresh(final @Named(Names.CONTAINER) ContainerShape container, @Named(Names.PICTOGRAM_ELEMENT) ContainerShape shape, final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib, final PictogramElementService pes) {
        // Create the container shape
		if(shape == null) {
			final IPeCreateService peCreateService = Graphiti.getPeCreateService();
	        shape = peCreateService.createContainerShape(container, true);			
		}

		// TODO: Refresh children. 
		// TODO: Consider nesting and type of diagram
		
        return shape;
	}
	
	@RefreshGraphics 
	public void refreshGraphics(@Named(Names.PICTOGRAM_ELEMENT) ContainerShape shape) {		
        // Recreate the graphics algorithm
		final IGaService gaService = Graphiti.getGaService();
        final GraphicsAlgorithm ga = gaService.createPlainRectangle(shape);
        		
		// TODO: Set appropriate size. Should behave like other pictograms. Use current size as minimum and expand as necessary
        ga.setWidth(50);
        ga.setHeight(50);
	}
	
	@CanHandleDoubleClick
	public boolean canDoubleClick(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		return true;
	}
	
	@HandleDoubleClick
	public void onDoubleclick(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib, final DiagramService diagramService) {
		diagramService.openOrCreateDiagramBusinessObject(typeLib);
	}
}
