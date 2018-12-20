package org.osate.ui.projectvisualization;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.zest.core.viewers.GraphViewer;
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
	
	private GraphViewer graph;

	@Override
	public void createPartControl(Composite parent) {
		graph = new GraphViewer(parent, SWT.NONE);
		graph.setContentProvider(new IGraphEntityContentProvider() {
			private Set<IProject> projects;

			@Override
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof IWorkspaceRoot) {
					Stream<IProject> stream = Arrays.stream(((IWorkspaceRoot) inputElement).getProjects());
					projects = stream.filter(project -> project.isOpen())
							.collect(Collectors.toCollection(LinkedHashSet::new));
				} else if (inputElement instanceof IWorkingSet) {
					Stream<IAdaptable> stream = Arrays.stream(((IWorkingSet) inputElement).getElements());
					projects = stream.map(adaptable -> Adapters.adapt(adaptable, IProject.class))
							.filter(project -> project.isOpen()).collect(Collectors.toCollection(LinkedHashSet::new));
				} else {
					projects = Collections.emptySet();
				}
				return projects.toArray();
			}

			@Override
			public Object[] getConnectedTo(Object entity) {
				if (entity instanceof IProject) {
					try {
						IProject[] references = ((IProject) entity).getReferencedProjects();
						return Arrays.stream(references).filter(project -> projects.contains(project)).toArray();
					} catch (CoreException e) {
						StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
						return new Object[0];
					}
				} else {
					return new Object[0];
				}
			}
		});
		graph.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof IProject) {
					return ((IProject) element).getName();
				} else {
					return null;
				}
			}
		});
		graph.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		graph.setLayoutAlgorithm(new CompositeLayoutAlgorithm(
				new LayoutAlgorithm[] { new DirectedGraphLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING),
						new HorizontalShift(LayoutStyles.NO_LAYOUT_NODE_RESIZING) }));
		graph.setInput(ResourcesPlugin.getWorkspace().getRoot());
	}

	@Override
	public void setFocus() {
		graph.getGraphControl().setFocus();
	}

	public void setScope(IWorkingSet workingSet) {
		graph.setInput(workingSet);
	}
}