package org.osate.ui.projectvisualization;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.CompositeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.DirectedGraphLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.HorizontalShift;
import org.osate.core.AadlNature;
import org.osate.ui.OsateUiPlugin;

public class ProjectVisualizationView extends ViewPart {
	public static final String ID = "org.osate.ui.projectvisualization";

	private AbstractVisualizationInput<?> input;

	private Label label;
	private Font labelFont;
	private GraphViewer graph;

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout());

		label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		labelFont = FontDescriptor.createFrom(label.getFont()).increaseHeight(5).createFont(label.getDisplay());
		label.setFont(labelFont);

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
		graph.setLabelProvider(new VisualizationLabelProvider(parent.getDisplay()));
		graph.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		graph.setLayoutAlgorithm(new CompositeLayoutAlgorithm(
				new LayoutAlgorithm[] { new DirectedGraphLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING),
						new HorizontalShift(LayoutStyles.NO_LAYOUT_NODE_RESIZING) }));
		setScopeToWorkspace();

		MenuManager menuManager = new MenuManager();
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(manager -> {
			manager.add(showAllProjectsAction);
			IStructuredSelection selection = graph.getStructuredSelection();
			if (selection.size() == 1) {
				Object selectedObject = selection.getFirstElement();
				if (selectedObject instanceof IProject) {
					IProject selectedProject = (IProject) selectedObject;
					try {
						if (selectedProject.hasNature(AadlNature.ID)) {
							showModelUnitsInProjectAction.setText(
									"Show Packages and Property Sets in project '" + selectedProject.getName() + "'");
							manager.add(showModelUnitsInProjectAction);
						}
					} catch (CoreException e) {
						StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
					}
				}
			}
		});
		graph.getGraphControl().setMenu(menuManager.createContextMenu(graph.getGraphControl()));
	}

	private final IAction showAllProjectsAction = new Action("Show All Projects") {
		@Override
		public void run() {
			setScopeToWorkspace();
		}
	};

	private final IAction showModelUnitsInProjectAction = new Action() {
		@Override
		public void run() {
			IProject project = (IProject) graph.getStructuredSelection().getFirstElement();
			input = ModelUnitVisualizationInput.create(project);
			graph.setInput(input);
			label.setText("Scope: Packages and Property Sets in Project '" + project.getName() + "'");
		}
	};

	@Override
	public void setFocus() {
		graph.getGraphControl().setFocus();
	}

	@Override
	public void dispose() {
		super.dispose();
		labelFont.dispose();
	}
	
	private void setScopeToWorkspace() {
		input = new ProjectVisualizationInput(ResourcesPlugin.getWorkspace());
		graph.setInput(input);
		label.setText("Scope: All Projects");
	}

	public void setScope(IWorkingSet workingSet) {
		input = new ProjectVisualizationInput(workingSet);
		graph.setInput(input);
		label.setText("Scope: Working Set '" + workingSet.getName() + "'");
	}

	public void setScope(IProject project) {
		input = new ProjectVisualizationInput(project);
		graph.setInput(input);
		label.setText("Scope: Project '" + project.getName() + "'");
	}

	private class VisualizationLabelProvider extends LabelProvider implements IEntityStyleProvider {
		private final Display display;

		public VisualizationLabelProvider(Display display) {
			this.display = display;
		}

		@Override
		public String getText(Object element) {
			return input.getText(element);
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
			if (!input.isInScope(entity)) {
				return display.getSystemColor(SWT.COLOR_WHITE);
			} else {
				return null;
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
	}
}