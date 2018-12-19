package org.osate.ui.projectvisualization;

import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
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
	private GraphViewer graph;

	@Override
	public void createPartControl(Composite parent) {
		graph = new GraphViewer(parent, SWT.NONE);
		graph.setContentProvider(new IGraphEntityContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof IWorkspaceRoot) {
					IProject[] projects = ((IWorkspaceRoot) inputElement).getProjects();
					return Arrays.stream(projects).filter(project -> project.isOpen()).toArray();
				} else {
					return new Object[0];
				}
			}

			@Override
			public Object[] getConnectedTo(Object entity) {
				if (entity instanceof IProject) {
					try {
						return ((IProject) entity).getReferencedProjects();
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
		
		
		graph.setLayoutAlgorithm(new CompositeLayoutAlgorithm(new LayoutAlgorithm[] {
				new DirectedGraphLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING),
				new HorizontalShift(LayoutStyles.NO_LAYOUT_NODE_RESIZING)
		}));
//		graph.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
//		graph.setLayoutAlgorithm(new HorizontalTreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
		
		
		graph.setInput(ResourcesPlugin.getWorkspace().getRoot());
	}
	
	@Override
	public void setFocus() {
		graph.getGraphControl().setFocus();
	}
}