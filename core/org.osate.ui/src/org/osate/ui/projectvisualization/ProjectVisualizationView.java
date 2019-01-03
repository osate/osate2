package org.osate.ui.projectvisualization;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.resource.FontDescriptor;
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
import org.osate.ui.OsateUiPlugin;

public class ProjectVisualizationView extends ViewPart {
	public static final String ID = "org.osate.ui.projectvisualization";

	private Label label;
	private Font labelFont;
	private GraphViewer graph;

	private Set<IProject> scopedProjects;

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout());

		label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		label.setText("Scope: All Projects");
		labelFont = FontDescriptor.createFrom(label.getFont()).increaseHeight(5).createFont(label.getDisplay());
		label.setFont(labelFont);

		graph = new GraphViewer(parent, SWT.NONE);
		graph.getGraphControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		graph.setContentProvider(new IGraphEntityContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				Set<IProject> allProjects = new LinkedHashSet<>();
				for (IProject project : (Set<IProject>) inputElement) {
					if (project.isOpen()) {
						allProjects.add(project);
						traverseDependencies(project, allProjects, p -> {
							try {
								return p.getReferencedProjects();
							} catch (CoreException e) {
								StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
								return new IProject[0];
							}
						});
						traverseDependencies(project, allProjects, IProject::getReferencingProjects);
					}
				}
				return allProjects.toArray();
			}

			private void traverseDependencies(IProject project, Set<IProject> visited,
					Function<IProject, IProject[]> getDependencies) {
				for (IProject dependency : getDependencies.apply(project)) {
					if (dependency.isOpen() && !visited.contains(dependency)) {
						visited.add(dependency);
						traverseDependencies(dependency, visited, getDependencies);
					}
				}
			}

			@Override
			public Object[] getConnectedTo(Object entity) {
				try {
					IProject[] references = ((IProject) entity).getReferencedProjects();
					return Arrays.stream(references).filter(project -> project.isOpen()).toArray();
				} catch (CoreException e) {
					StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
					return new Object[0];
				}
			}
		});
		graph.setLabelProvider(new VisualizationLabelProvider(parent.getDisplay()));
		graph.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		graph.setLayoutAlgorithm(new CompositeLayoutAlgorithm(
				new LayoutAlgorithm[] { new DirectedGraphLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING),
						new HorizontalShift(LayoutStyles.NO_LAYOUT_NODE_RESIZING) }));
		scopedProjects = Arrays.stream(ResourcesPlugin.getWorkspace().getRoot().getProjects())
				.filter(project -> project.isOpen()).collect(Collectors.toCollection(LinkedHashSet::new));
		graph.setInput(scopedProjects);
	}

	@Override
	public void setFocus() {
		graph.getGraphControl().setFocus();
	}

	@Override
	public void dispose() {
		super.dispose();
		labelFont.dispose();
	}

	public void setScope(IWorkingSet workingSet) {
		scopedProjects = Arrays.stream(workingSet.getElements())
				.map(adaptable -> Adapters.adapt(adaptable, IProject.class)).filter(project -> project.isOpen())
				.collect(Collectors.toCollection(LinkedHashSet::new));
		graph.setInput(scopedProjects);
		label.setText("Scope: Working Set " + workingSet.getName());
	}

	public void setScope(IProject project) {
		scopedProjects = Collections.singleton(project);
		graph.setInput(scopedProjects);
		label.setText("Scope: Project " + project.getName());
	}

	private class VisualizationLabelProvider extends LabelProvider implements IEntityStyleProvider {
		private final Display display;

		public VisualizationLabelProvider(Display display) {
			this.display = display;
		}

		@Override
		public String getText(Object element) {
			if (element instanceof IProject) {
				return ((IProject) element).getName();
			} else {
				return null;
			}
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
			if (!scopedProjects.contains(entity)) {
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