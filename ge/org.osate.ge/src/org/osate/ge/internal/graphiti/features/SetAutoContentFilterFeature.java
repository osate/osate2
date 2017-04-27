package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.ContentsFilter;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.diagram.DiagramModification;
import org.osate.ge.internal.diagram.DiagramModifier;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;

/**
 * Sets the auto contents filter for a diagram element and then updates the diagram.
 *
 */
public class SetAutoContentFilterFeature extends AbstractCustomFeature implements ICustomUndoRedoFeature {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;
	private final ContentsFilter newFilterValue;
	
	@Inject
	public SetAutoContentFilterFeature (final IFeatureProvider fp,
			final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider,
			final ContentsFilter newFilterValue) {
		super(fp);
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
		this.newFilterValue = Objects.requireNonNull(newFilterValue, "newFilerValue must not be null");
	}
	
	// TODO
	@Override
	public String getName() {
		switch(newFilterValue) {
		case ALLOW_FUNDAMENTAL:
			return "Hide Contents";
			
		case ALLOW_ALL:
			return "Show Contents";
			
		case ALLOW_TYPE:
			return "Show Type Elements";
			
		default:
			throw new RuntimeException("Unhandled Case: " + newFilterValue);
		}
	}
	
	@Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final DiagramElement[] elements = getDiagramElements(customCtx.getPictogramElements());
		if(elements == null) {
			return false;
		}
		
		boolean isApplicableToAtleastOne = false;
		for(final DiagramElement e : elements) {
			if(isContentFilterApplicable(e.getBusinessObject())) {
				isApplicableToAtleastOne = true;
				break;
			}				
		}
		
		return isApplicableToAtleastOne;		
	}
	
	private boolean isContentFilterApplicable(final Object bo) {
		return newFilterValue != ContentsFilter.ALLOW_TYPE || (bo instanceof Subcomponent || bo instanceof Classifier);
	}
	
	// TODO: Is available
	@Override
	public boolean canExecute(final ICustomContext context) {
		final DiagramElement[] elements = getDiagramElements(context.getPictogramElements());
		if(elements == null) {
			return false;
		}
		
		boolean alreadyMatch = true;
		for(final DiagramElement e : elements) {
			if(e.getAutoContentsFilter() != newFilterValue) {
				alreadyMatch = false;
				break;
			}
		}
		
		return !alreadyMatch;
	}
	
	@Override
	public void execute(final ICustomContext context) {
		final AgeDiagram ageDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getAgeDiagram();
		final DiagramElement[] elements = getDiagramElements(context.getPictogramElements());
		if(elements != null) {
			ageDiagram.modify(new DiagramModifier() {
				@Override
				public void modify(final DiagramModification m) {
					for(DiagramElement e : elements) {
						// Don't set teh type to something that isn't applicable to the type of business object
						if(isContentFilterApplicable(e.getBusinessObject())) {
							m.setManual(e, true);
							m.setAutoContentsFilter(e, newFilterValue);
						}
					}
					
					AgeFeatureUtil.storeModificationInContext(context, m);
				}						
			});
			
			// Update the diagram
			this.updatePictogramElement(graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getGraphitiDiagram());
		}
	}
	
	private DiagramElement[] getDiagramElements(final PictogramElement[] pes) {
		final DiagramElement[] elements = new DiagramElement[pes.length];
		
		for(int i = 0; i < pes.length; i++) {
			elements[i] = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getClosestDiagramElement(pes[i]);
			if(elements[i] == null) {
				return null;
			}
		}
		return elements;
	}
	
	// ICustomUndoRedoFeature
	@Override
	public boolean canUndo(final IContext context) {
		return AgeFeatureUtil.canUndo(context);
	}
	
	@Override
	public void preUndo(final IContext context) {
	}

	@Override
	public void postUndo(final IContext context) {
		AgeFeatureUtil.undoModification(graphitiAgeDiagramProvider.getGraphitiAgeDiagram(), context);
		
		// Update the diagram
		this.updatePictogramElement(graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getGraphitiDiagram());
	}

	@Override
	public boolean canRedo(final IContext context) {
		return AgeFeatureUtil.canRedo(context);
	}

	@Override
	public void preRedo(final IContext context) {
	}

	@Override
	public void postRedo(final IContext context) {
		AgeFeatureUtil.redoModification(graphitiAgeDiagramProvider.getGraphitiAgeDiagram(), context);
		
		// Update the diagram
		this.updatePictogramElement(graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getGraphitiDiagram());
	}
}
