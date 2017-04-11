package org.osate.ge.internal.graphiti.features;

import java.util.Objects;
import javax.inject.Inject;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IMoveConnectionDecoratorContext;
import org.eclipse.graphiti.features.impl.DefaultMoveConnectionDecoratorFeature;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.diagram.DiagramModification;
import org.osate.ge.internal.diagram.DiagramModifier;
import org.osate.ge.internal.diagram.Point;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.ShapeNames;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.graphiti.diagram.PropertyUtil;

public class AgeMoveConnectionDecoratorFeature extends DefaultMoveConnectionDecoratorFeature implements ICustomUndoRedoFeature {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;
	
	@Inject
	public AgeMoveConnectionDecoratorFeature(final IFeatureProvider fp, final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider) {
		super(fp);
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
	}
	
	public boolean canMoveConnectionDecorator(final IMoveConnectionDecoratorContext context) {
		final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();
		
		// Only support moving connection decorators for connection name labels for which we can find the diagram element
		if(context.getConnectionDecorator() == null || 
				!ShapeNames.nameShapeName.equals(PropertyUtil.getName(context.getConnectionDecorator())) ||
				graphitiAgeDiagram.getDiagramElement(context.getConnectionDecorator().getConnection()) == null) {
			return false;
		}
		
		return true;
	}

	public void moveConnectionDecorator(final IMoveConnectionDecoratorContext context) {
		final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();
		final DiagramElement connectionElement = graphitiAgeDiagram.getDiagramElement(context.getConnectionDecorator().getConnection());
		
		graphitiAgeDiagram.modify(new DiagramModifier() {					
			@Override
			public void modify(final DiagramModification m) {
				m.setConnectionNameLabelPosition(connectionElement, new Point(context.getX(), context.getY()));
				AgeFeatureUtil.storeModificationInContext(context, m);
			}
		});
	}

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
	}	
}
