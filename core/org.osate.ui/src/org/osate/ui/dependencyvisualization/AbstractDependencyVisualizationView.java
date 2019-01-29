package org.osate.ui.dependencyvisualization;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IConnectionStyleProvider;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.CompositeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.DirectedGraphLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.HorizontalShift;

abstract class AbstractDependencyVisualizationView<T> extends ViewPart {
	private AbstractVisualizationInput<T> input;

	private GraphViewer graph;

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		
		graph = new GraphViewer(parent, SWT.NONE);
		graph.getGraphControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		graph.setContentProvider(new IGraphEntityContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				return input.getGraphElements();
			}

			@Override
			public Object[] getConnectedTo(Object entity) {
				return input.getConnectedTo(entity);
			}
		});
		graph.setLabelProvider(new VisualizationLabelProvider());
		graph.setLayoutAlgorithm(new CompositeLayoutAlgorithm(
				new LayoutAlgorithm[] { new DirectedGraphLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING),
						new HorizontalShift(LayoutStyles.NO_LAYOUT_NODE_RESIZING) }));

		MenuManager menuManager = new MenuManager();
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(this::menuAboutToShow);
		graph.getGraphControl().setMenu(menuManager.createContextMenu(graph.getGraphControl()));

		graph.addSelectionChangedListener(event -> {
			graph.update(graph.getNodeElements(), null);
			graph.update(graph.getConnectionElements(), null);
		});
		
		Group controlGroup = new Group(parent, SWT.SHADOW_NONE);
		controlGroup.setText("Graph Scope:");
		controlGroup.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false));
		fillControlComposite(controlGroup);
		
		setScopeToWorkspace();
	}

	@Override
	public void setFocus() {
		graph.getGraphControl().setFocus();
	}

	protected abstract void menuAboutToShow(IMenuManager manager);
	
	protected abstract void fillControlComposite(Composite parent);

	protected abstract Image getImage(Object element);

	protected abstract String getText(Object element);

	protected abstract void setScopeToWorkspace();
	
	protected IStructuredSelection getGraphSelection() {
		return graph.getStructuredSelection();
	}
	
	protected void setInput(AbstractVisualizationInput<T> input) {
		this.input = input;
		graph.setInput(input);
	}
	
	private class VisualizationLabelProvider extends LabelProvider
			implements IEntityStyleProvider, IConnectionStyleProvider {

		@Override
		public Image getImage(Object element) {
			return AbstractDependencyVisualizationView.this.getImage(element);
		}

		@Override
		public String getText(Object element) {
			return AbstractDependencyVisualizationView.this.getText(element);
		}

		@Override
		public Color getNodeHighlightColor(Object entity) {
			return null;
		}

		@Override
		public Color getBorderColor(Object entity) {
			return null;
		}

		@Override
		public Color getBorderHighlightColor(Object entity) {
			return null;
		}

		@Override
		public int getBorderWidth(Object entity) {
			return -1;
		}

		@Override
		public Color getBackgroundColour(Object entity) {
			Stream<?> selected = graph.getStructuredSelection().toList().stream();
			Set<?> connectedToSelected = selected.flatMap(input::getConnectedToBothDirections)
					.collect(Collectors.toSet());
			if (connectedToSelected.contains(entity)) {
				return ColorConstants.orange;
			} else if (!input.isInScope(entity)) {
				return ColorConstants.white;
			} else {
				return graph.getGraphControl().LIGHT_BLUE;
			}
		}

		@Override
		public Color getForegroundColour(Object entity) {
			return null;
		}

		@Override
		public IFigure getTooltip(Object entity) {
			return null;
		}

		@Override
		public boolean fisheyeNode(Object entity) {
			return false;
		}

		@Override
		public int getConnectionStyle(Object rel) {
			if (isEndPointSelected(rel)) {
				return ZestStyles.CONNECTIONS_DIRECTED | ZestStyles.CONNECTIONS_DASH;
			} else {
				return ZestStyles.CONNECTIONS_DIRECTED;
			}
		}

		@Override
		public Color getColor(Object rel) {
			if (isEndPointSelected(rel)) {
				return ColorConstants.red;
			} else {
				return ColorConstants.lightGray;
			}
		}

		@Override
		public Color getHighlightColor(Object rel) {
			return null;
		}

		@Override
		public int getLineWidth(Object rel) {
			if (isEndPointSelected(rel)) {
				return 3;
			} else {
				return 1;
			}
		}

		private boolean isEndPointSelected(Object rel) {
			EntityConnectionData connection = (EntityConnectionData) rel;
			List<?> selection = graph.getStructuredSelection().toList();
			return selection.contains(connection.source) || selection.contains(connection.dest);
		}
	}
}