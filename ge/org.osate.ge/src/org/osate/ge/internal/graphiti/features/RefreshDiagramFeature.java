package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.DiagramLayoutUtil;
import org.osate.ge.internal.diagram.DiagramModification;
import org.osate.ge.internal.diagram.DiagramModifier;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.labels.AgeLabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;

public class RefreshDiagramFeature extends AbstractCustomFeature implements ICustomUndoRedoFeature {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;
	private static int counter = 0; // TODO: Remove. For testing
	private static int iteration = 0; // TODO: REMOVE. for testing
	
	@Inject
	public RefreshDiagramFeature(final IFeatureProvider fp, final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider) {
		super(fp);
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
	}
	
	@Override
	public String getName() {
		return "Refresh Diagram";
	}

	@Override
	public String getDescription() {
		return "Refresh the diagram.";
	}
	
	@Override
	public boolean canExecute(final ICustomContext context) {
		return true;
	}
	
	@Override
	public void execute(final ICustomContext context) {
		final AgeDiagram ageDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getAgeDiagram();
		
		// TODO: Replace with an implementation based on DiagramUpdater
		
		// TODO: Create diagram elements for testing
		ageDiagram.modify(new DiagramModifier() {
			@Override
			public void modify(final DiagramModification m) {
				if(iteration == 1) {
					final AgeDiagramElement elementToRemove = ageDiagram.getByRelativeReference(new RelativeBusinessObjectReference(Integer.toString(1)));
					m.removeElement(elementToRemove);
				} else if(iteration == 3) {
					final AgeDiagramElement parent = ageDiagram.getByRelativeReference(new RelativeBusinessObjectReference(Integer.toString(12)));
					m.removeElement(parent.getByRelativeReference(new RelativeBusinessObjectReference(Integer.toString(17))));
					m.removeElement(parent.getByRelativeReference(new RelativeBusinessObjectReference(Integer.toString(23))));
				} else if(iteration == 4) {
					final AgeDiagramElement parent = ageDiagram.getByRelativeReference(new RelativeBusinessObjectReference(Integer.toString(12)));
					m.removeElement(parent);
				} else if(iteration == 0 || iteration == 2) {
					final AgeDiagramElement e1 = createElement(m, ageDiagram, RectangleBuilder.create().build());
					m.setLabelConfiguration(e1, (AgeLabelConfiguration)LabelConfigurationBuilder.create().horizontalCenter().build());
					
					createElement(m, ageDiagram, EllipseBuilder.create().build());
					
					final AgeDiagramElement e3 = createElement(m, e1, RectangleBuilder.create().build());
					final AgeDiagramElement e4 = createElement(m, e1, RectangleBuilder.create().build());
					
					m.setDockArea(createElement(m, e1, RectangleBuilder.create().build()), DockArea.RIGHT);
					m.setDockArea(createElement(m, e1, RectangleBuilder.create().build()), DockArea.RIGHT);					
					m.setDockArea(createElement(m, e1, RectangleBuilder.create().build()), DockArea.RIGHT);		
					
					final AgeDiagramElement e8 = createElement(m, e1, RectangleBuilder.create().build());
					final AgeDiagramElement e9 = createElement(m, e1, RectangleBuilder.create().build());
					
					final AgeDiagramElement e10 = createConnectionElement(m, e1, ConnectionBuilder.create().build(), e3, e4);
					final AgeDiagramElement e11 = createConnectionElement(m, e1, ConnectionBuilder.create().curved().build(), e8, e9);
					createConnectionElement(m, e1, ConnectionBuilder.create().dashed().build(), e10, e11);
				}
				
				iteration++;
			}	
			
			private AgeDiagramElement createElement(final DiagramModification m, final DiagramNode parent, final Graphic graphic) {
				final int value = counter++;
				final AgeDiagramElement newElement = new AgeDiagramElement(parent, 
						value, 
						new RelativeBusinessObjectReference(Integer.toString(value)), 
						new CanonicalBusinessObjectReference(Integer.toString(value)), 
						"OBJECT: " + value);
				m.setGraphic(newElement, graphic);
				m.addElement(newElement);
				return newElement;
			}
			
			private AgeDiagramElement createConnectionElement(final DiagramModification m, 
					final DiagramNode parent, 
					final Graphic graphic,
					final AgeDiagramElement start,
					final AgeDiagramElement end) {
				final AgeDiagramElement newElement = createElement(m, parent, graphic);
				m.setConnectionStart(newElement, start);
				m.setConnectionEnd(newElement, end);
				return newElement;
			}
		});
		
		// Perform the layout as a separate operation because the sizes for the shapes are assigned by the Graphiti modification listener.
		ageDiagram.modify(new DiagramModifier() {
			@Override
			public void modify(final DiagramModification m) {
				DiagramLayoutUtil.layout(ageDiagram, m, false);
			}
		});
	}
	
	// ICustomUndoRedoFeature
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
	@Override
	public void preUndo(final IContext context) {
	}

	@Override
	public void postUndo(final IContext context) {
	}

	@Override
	public boolean canRedo(final IContext context) {
		return false;
	}

	@Override
	public void preRedo(final IContext context) {
	}

	@Override
	public void postRedo(final IContext context) {
	}
}
