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
package org.osate.ui.dependencyvisualization;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
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
import org.osate.ui.OsateUiPlugin;

/**
 * This class contains the code common to {@link ProjectDependencyVisualizationView} and
 * {@link ModelUnitDependencyVisualizationView}. Each view has a graph, control group, context menu, and refresh
 * button. The input object for the graph is an {@link IVisualizationInput}. This is the model object which handles all
 * the non-UI information necessary to build a directed graph.
 * 
 * The graph has a concept of which elements are in the scope and which are out of scope. The scope is specified when
 * setting the input to the graph. For example, a scope could be all projects in a working set. When building the
 * graph, the elements in the scope serve as the starting point and all dependencies are calculated from the scope.
 * This means that the final graph may contain elements that are outside of the scope. The elements in the scope have a
 * light blue background while the elements outside of the scope have a white and gray background. This is handled by
 * the graph's label provider which queries {@link IVisualizationInput#isInScope(Object)}.
 * 
 * If the user selects a node, that node will be highlighted yellow and all directly connected nodes will be
 * highlighted orange. The direct connection lines will also be highlighted red and become dashed. This is handled by
 * the graph's label provider which queries the graph selection and
 * {@link IVisualizationInput#getConnectedToBothDirections(Object)}.
 */
abstract class AbstractDependencyVisualizationView extends ViewPart {
	private IVisualizationInput input;

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

		IAction refreshAction = new Action("Refresh", IAction.AS_PUSH_BUTTON) {
			@Override
			public void run() {
				refresh();
			}
		};
		refreshAction.setImageDescriptor(OsateUiPlugin.getImageDescriptor("icons/refresh.png"));
		getViewSite().getActionBars().getToolBarManager().add(refreshAction);

		setScopeToWorkspace();
	}

	@Override
	public void setFocus() {
		graph.getGraphControl().setFocus();
	}

	/**
	 * This is called when the user opens the graph's context menu. Subclasses should fill the manager with
	 * appropriate actions.
	 */
	protected abstract void menuAboutToShow(IMenuManager manager);

	/**
	 * Subclasses should fill the control composite with radio buttons and combo boxes for controlling the scope of the
	 * graph.
	 */
	protected abstract void fillControlComposite(Composite parent);

	/**
	 * Called by the graph's label provider.
	 */
	protected abstract Image getImage(Object element);

	/**
	 * Called by the graph's label provider.
	 */
	protected abstract String getText(Object element);

	/**
	 * When called, subclasses should refresh the graph input based on the current scope.
	 */
	protected abstract void refresh();

	/**
	 * Sets the initial scope for the graph.
	 */
	protected abstract void setScopeToWorkspace();

	protected IStructuredSelection getGraphSelection() {
		return graph.getStructuredSelection();
	}

	/**
	 * Call to update the content of the graph.
	 */
	protected void setInput(IVisualizationInput input) {
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