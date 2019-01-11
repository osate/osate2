package org.osate.ui.projectvisualization;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.zest.core.viewers.GraphViewer;
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

import com.google.common.collect.Lists;
import com.google.inject.Injector;

public class ProjectVisualizationView extends ViewPart {
	public static final String ID = "org.osate.ui.projectvisualization";

	private final Injector injector;
	private final IResourceDescriptions resourceDescriptions;

	// Either IProject or IEObjectDescription<ModelUnit>
	private final Set<Object> scopedElements = new LinkedHashSet<>();

	private Label label;
	private Font labelFont;
	private GraphViewer graph;

	public ProjectVisualizationView() {
		injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.aadl")).get(Injector.class);
		resourceDescriptions = injector.getInstance(IResourceDescriptions.class);
	}

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
				Set<?> inputSet = (Set<?>) inputElement;
				if (inputSet.isEmpty()) {
					return new Object[0];
				} else if (inputSet.iterator().next() instanceof IProject) {
					Set<IProject> allProjects = new LinkedHashSet<>();
					for (Object inputSetElement : inputSet) {
						IProject project = (IProject) inputSetElement;
						if (project.isOpen()) {
							allProjects.add(project);
							traverseDependencies(project, allProjects, IProject::isOpen, dependency -> {
								try {
									return Arrays.asList(dependency.getReferencedProjects());
								} catch (CoreException e) {
									StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
									return Collections.emptySet();
								}
							});
							traverseDependencies(project, allProjects, IProject::isOpen,
									dependency -> Arrays.asList(dependency.getReferencingProjects()));
						}
					}
					return allProjects.toArray();
				} else {
					// inputSet is set of IEObjectDescription<ModelUnit>
					Set<IEObjectDescription> allModelUnits = new LinkedHashSet<>();
					for (Object inputSetElement : inputSet) {
						IEObjectDescription modelUnit = (IEObjectDescription) inputSetElement;
						allModelUnits.add(modelUnit);
						traverseDependencies(modelUnit, allModelUnits, dependency -> true,
								dependency -> referencingModelUnits.getOrDefault(dependency, Collections.emptySet()));
						traverseDependencies(modelUnit, allModelUnits, dependency -> true,
								dependency -> referencedModelUnits.getOrDefault(dependency, Collections.emptySet()));
					}
					return allModelUnits.toArray();
				}
			}

			private <T> void traverseDependencies(T start, Set<T> visited, Predicate<T> filter,
					Function<T, Iterable<T>> getDependencies) {
				for (T dependency : getDependencies.apply(start)) {
					if (filter.test(dependency) && !visited.contains(dependency)) {
						visited.add(dependency);
						traverseDependencies(dependency, visited, filter, getDependencies);
					}
				}
			}

			@Override
			public Object[] getConnectedTo(Object entity) {
				if (entity instanceof IProject) {
					try {
						IProject[] references = ((IProject) entity).getReferencedProjects();
						return Arrays.stream(references).filter(IProject::isOpen).toArray();
					} catch (CoreException e) {
						StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
						return new Object[0];
					}
				} else {
					// entity is IEObjectDescription<ModelUnit>
					return referencedModelUnits.getOrDefault(entity, Collections.emptySet()).toArray();
				}
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

	private final Map<IEObjectDescription, Set<IEObjectDescription>> referencingModelUnits = new HashMap<>();
	private final Map<IEObjectDescription, Set<IEObjectDescription>> referencedModelUnits = new HashMap<>();

	private final IAction showModelUnitsInProjectAction = new Action() {
		@Override
		public void run() {
			IProject project = (IProject) graph.getStructuredSelection().getFirstElement();
			scopedElements.clear();
			referencingModelUnits.clear();
			referencedModelUnits.clear();
			Map<URI, IEObjectDescription> eObjectDescriptions = new HashMap<>();
			for (IEObjectDescription eObjectDescription : resourceDescriptions
					.getExportedObjectsByType(Aadl2Package.eINSTANCE.getModelUnit())) {
				eObjectDescriptions.put(eObjectDescription.getEObjectURI(), eObjectDescription);
			}
			for (IResourceDescription resourceDescription : resourceDescriptions.getAllResourceDescriptions()) {
				URI resourceURI = resourceDescription.getURI();
				if (resourceURI.fileExtension().equalsIgnoreCase("aadl")
						&& resourceURI.toString().startsWith("platform:/resource/" + project.getName() + "/")) {
					List<IEObjectDescription> modelUnits = Lists.newArrayList(
							resourceDescription.getExportedObjectsByType(Aadl2Package.eINSTANCE.getModelUnit()));
					if (modelUnits.size() == 1) {
						IEObjectDescription sourceModelUnit = modelUnits.get(0);
						scopedElements.add(sourceModelUnit);
						for (IReferenceDescription referenceDescription : resourceDescription
								.getReferenceDescriptions()) {
							EReference eReference = referenceDescription.getEReference();
							if (eReference.equals(Aadl2Package.eINSTANCE.getPackageSection_ImportedUnit())
									|| eReference.equals(Aadl2Package.eINSTANCE.getPropertySet_ImportedUnit())) {
								IEObjectDescription targetModelUnit = eObjectDescriptions
										.get(referenceDescription.getTargetEObjectUri());

								// referencing
								Set<IEObjectDescription> referencingSet = referencingModelUnits.get(targetModelUnit);
								if (referencingSet == null) {
									referencingSet = new LinkedHashSet<>();
									referencingModelUnits.put(targetModelUnit, referencingSet);
								}
								referencingSet.add(sourceModelUnit);

								// referenced
								Set<IEObjectDescription> referencedSet = referencedModelUnits.get(sourceModelUnit);
								if (referencedSet == null) {
									referencedSet = new LinkedHashSet<>();
									referencedModelUnits.put(sourceModelUnit, referencedSet);
								}
								referencedSet.add(targetModelUnit);
							}
						}
					}
				}
			}
			graph.setInput(scopedElements);
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

	public void setScope(IWorkingSet workingSet) {
		List<IProject> projects = Arrays.stream(workingSet.getElements())
				.map(adaptable -> Adapters.adapt(adaptable, IProject.class)).filter(IProject::isOpen)
				.collect(Collectors.toList());
		scopedElements.clear();
		referencingModelUnits.clear();
		referencedModelUnits.clear();
		scopedElements.addAll(projects);
		graph.setInput(scopedElements);
		label.setText("Scope: Working Set '" + workingSet.getName() + "'");
	}

	public void setScope(IProject project) {
		scopedElements.clear();
		referencingModelUnits.clear();
		referencedModelUnits.clear();
		scopedElements.add(project);
		graph.setInput(scopedElements);
		label.setText("Scope: Project '" + project.getName() + "'");
	}

	private void setScopeToWorkspace() {
		List<IProject> projects = Arrays.stream(ResourcesPlugin.getWorkspace().getRoot().getProjects())
				.filter(IProject::isOpen).collect(Collectors.toList());
		scopedElements.clear();
		referencingModelUnits.clear();
		referencedModelUnits.clear();
		scopedElements.addAll(projects);
		graph.setInput(scopedElements);
		label.setText("Scope: All Projects");
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
			} else if (element instanceof IEObjectDescription) {
				return ((IEObjectDescription) element).getName().toString("::");
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
			if (!scopedElements.contains(entity)) {
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