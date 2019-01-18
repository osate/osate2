package org.osate.ui.projectvisualization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.resource.IEObjectDescription;
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
import org.osate.aadl2.Aadl2Package;
import org.osate.core.AadlNature;
import org.osate.ui.OsateUiPlugin;

public class DependencyVisualizationView extends ViewPart {
	public static final String ID = "org.osate.ui.dependencyvisualization";

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
		graph.setLabelProvider(new VisualizationLabelProvider());
		graph.setLayoutAlgorithm(new CompositeLayoutAlgorithm(
				new LayoutAlgorithm[] { new DirectedGraphLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING),
						new HorizontalShift(LayoutStyles.NO_LAYOUT_NODE_RESIZING) }));
		setProjectScopeToWorkspace();

		MenuManager menuManager = new MenuManager();
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(manager -> {
			manager.add(showAllProjectsAction);
			manager.add(showAllModelUnitsAction);
			manager.add(new Separator());
			IStructuredSelection selection = graph.getStructuredSelection();
			if (selection.size() == 1) {
				Object selectedObject = selection.getFirstElement();
				if (selectedObject instanceof IProject) {
					IProject selectedProject = (IProject) selectedObject;
					try {
						focusOnProjectAction.setText("Show Projects Connected to '" + selectedProject.getName() + "'");
						manager.add(focusOnProjectAction);
						if (selectedProject.hasNature(AadlNature.ID)) {
							showModelUnitsInProjectAction
									.setText("Show Packages and Property Sets in '" + selectedProject.getName() + "'");
							manager.add(showModelUnitsInProjectAction);
						}
					} catch (CoreException e) {
						StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
					}
				} else if (selectedObject instanceof IEObjectDescription) {
					IEObjectDescription selectedModelUnit = (IEObjectDescription) selectedObject;
					String name = selectedModelUnit.getName().toString("::");
					focusOnModelUnitAction.setText("Show Packages and Property Sets Connected to '" + name + "'");
					manager.add(focusOnModelUnitAction);
				}
			}
		});
		graph.getGraphControl().setMenu(menuManager.createContextMenu(graph.getGraphControl()));

		graph.addSelectionChangedListener(event -> {
			graph.update(graph.getNodeElements(), null);
			graph.update(graph.getConnectionElements(), null);
		});
	}

	private final IAction showAllProjectsAction = new Action("Show All Projects in Workspace") {
		@Override
		public void run() {
			setProjectScopeToWorkspace();
		}
	};

	private final IAction focusOnProjectAction = new Action() {
		@Override
		public void run() {
			setProjectScope((IProject) graph.getStructuredSelection().getFirstElement());
		}
	};

	private final IAction showAllModelUnitsAction = new Action("Show All Packages and Property Sets in Workspace") {
		@Override
		public void run() {
			input = ModelUnitVisualizationInput.create(getSite().getShell());
			graph.setInput(input);
			label.setText("All Packages and Property Sets in Workspace");
		}
	};

	private final IAction showModelUnitsInProjectAction = new Action() {
		@Override
		public void run() {
			IProject project = (IProject) graph.getStructuredSelection().getFirstElement();
			input = ModelUnitVisualizationInput.create(getSite().getShell(), project);
			graph.setInput(input);
			label.setText("Packages and Property Sets in Project '" + project.getName() + "'");
		}
	};

	private final IAction focusOnModelUnitAction = new Action() {
		public void run() {
			IEObjectDescription modelUnit = (IEObjectDescription) graph.getStructuredSelection().getFirstElement();
			input = ModelUnitVisualizationInput.create(getSite().getShell(), modelUnit.getEObjectURI());
			graph.setInput(input);
			String name = modelUnit.getName().toString("::");
			if (modelUnit.getEClass().equals(Aadl2Package.eINSTANCE.getAadlPackage())) {
				label.setText("Packages and Property Sets Connected to Package '" + name + "'");
			} else if (modelUnit.getEClass().equals(Aadl2Package.eINSTANCE.getPropertySet())) {
				label.setText("Packages and Property Sets Connected to Property Set '" + name + "'");
			}
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

	private void setProjectScopeToWorkspace() {
		input = new ProjectVisualizationInput();
		graph.setInput(input);
		label.setText("All Projects in Workspace");
	}

	public void setProjectScope(IWorkingSet workingSet) {
		input = new ProjectVisualizationInput(workingSet);
		graph.setInput(input);
		label.setText("Projects in Working Set '" + workingSet.getName() + "'");
	}

	public void setProjectScope(IProject project) {
		input = new ProjectVisualizationInput(project);
		graph.setInput(input);
		label.setText("Projects Connected to Project '" + project.getName() + "'");
	}

	public void setModelUnitScope(IWorkingSet workingSet) {
		input = ModelUnitVisualizationInput.create(getSite().getShell(), workingSet);
		graph.setInput(input);
		label.setText("Packages and Property Sets in Working Set '" + workingSet.getName() + "'");
	}

	public void setModelUnitScope(IProject project) {
		input = ModelUnitVisualizationInput.create(getSite().getShell(), project);
		graph.setInput(input);
		label.setText("Packages and Property Sets in Project '" + project.getName() + "'");
	}

	private class VisualizationLabelProvider extends LabelProvider
			implements IEntityStyleProvider, IConnectionStyleProvider {
		private Map<String, Image> images = new HashMap<>();

		@Override
		public Image getImage(Object element) {
			String imagePath = input.getImagePath(element);
			if (imagePath != null) {
				return images.computeIfAbsent(imagePath, path -> OsateUiPlugin.getImageDescriptor(path).createImage());
			} else {
				return null;
			}
		}

		@Override
		public String getText(Object element) {
			return input.getText(element);
		}

		@Override
		public void dispose() {
			super.dispose();
			images.values().forEach(Image::dispose);
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